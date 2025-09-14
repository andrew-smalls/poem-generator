package poemgenerator.mistral;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import poemgenerator.config.MistralProperties;
import poemgenerator.poem.model.Poem;
import poemgenerator.poem.repository.PoemRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ChatService {
    private final Logger logger = LoggerFactory.getLogger(ChatService.class);
    private final WebClient webClient;
    private final MistralProperties mistralProperties;

    private final PoemRepository poemRepository;

    private final String COMPLETIONS_ENDPOINT = "/v1/chat/completions";

    public ChatService(MistralProperties mistralProperties, PoemRepository poemRepository) {
        this.mistralProperties = mistralProperties;
        this.poemRepository = poemRepository;

        this.webClient = WebClient.builder()
                .baseUrl(mistralProperties.getHost())
                .defaultHeaders(h -> h.setBearerAuth(mistralProperties.getApiKey()))
                .defaultHeader("Content-Type", "application/json")
                .defaultHeader("Accept", "application/json")
                .build();
    }

    @Transactional
    public Poem generatePoem(String theme, UUID userId) {
        validateUserId(userId);
        validatePrompt(theme);

        Map<String, Object> requestBody = getRequestBody(theme);

        MistralResponse response = webClient.post()
                .uri(COMPLETIONS_ENDPOINT)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(MistralResponse.class)
                .block();

        if (response == null || response.getChoices().isEmpty()) {
            throw new RuntimeException("No response from Mistral API");
        }

        String poemContent = response.getChoices().get(0).getMessage().getContent();
        Poem poem = new Poem(poemContent, theme, userId);

        try {
            poemRepository.save(poem);
        } catch (Exception e) {
            logger.error("Failed to save poem {} to repository: {}", e.getMessage(), poemContent);
        }

        return poem;
    }

    private void validateUserId(UUID userId) {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
    }

    @NotNull
    private Map<String, Object> getRequestBody(String theme) {
        Map<String, String> systemMessage = Map.of(
                "role", "system",
                "content", "You are a creative poet. Generate poems of 8–12 verses maximum, concise and lyrical."
        );

        Map<String, String> userMessage = Map.of(
                "role", "user",
                "content", "Write me a poem about: " + theme
        );

        Map<String, Object> requestBody = Map.of(
                "model", mistralProperties.getModel(),
                "temperature", 0.9,
                "max_tokens", 200,
                "messages", List.of(systemMessage, userMessage)
        );
        return requestBody;
    }

    private void validatePrompt(String prompt) {
        if (prompt == null || prompt.trim().isEmpty()) {
            throw new IllegalArgumentException("Prompt cannot be null or empty");
        }
        if (prompt.length() > 100) {
            throw new IllegalArgumentException("Prompt is too long");
        }
    }

}
