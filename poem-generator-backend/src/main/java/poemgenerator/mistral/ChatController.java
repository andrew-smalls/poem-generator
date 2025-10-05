package poemgenerator.mistral;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poemgenerator.poem.PoemHistoryService;
import poemgenerator.poem.model.Poem;
import poemgenerator.poem.repository.PoemRepository;

import java.io.*;
import java.util.List;
import java.util.UUID;

// TODO: Add error handling and logging. Add response entity. Make async.
// How does it work with multiple requests? Limit the number of threads? Limit response size. Limit request size.
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/mistral")
public class ChatController {

    private final ChatService chatService;
    private final PoemRepository poemRepository;
    private final PoemHistoryService poemHistoryService;

    public ChatController(ChatService chatService, PoemRepository poemRepository, PoemHistoryService poemHistoryService) {
        this.chatService = chatService;
        this.poemRepository = poemRepository;
        this.poemHistoryService = poemHistoryService;
    }

    @PostMapping("/poem")
    public ResponseEntity<Poem> createPoem(@RequestParam(value = "theme", defaultValue = "random theme") String theme,
                                     @RequestParam(value = "userId", required = false) UUID userId) {
        Poem poem;
        try {
            // TODO: Validate userId actually
            if (userId == null) {
                userId = UUID.randomUUID(); // TODO: Remove this
            }
            poem = chatService.generatePoem(theme, userId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok(poem);
    }

    @GetMapping("/poems")
    public List<Poem> getAllPoems(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category
    ) {
        if (search == null || search.isBlank()) {
            return poemRepository.findAll();
        }

        if (category == null || category.isBlank()) {
            return poemRepository.findBySearchTerm(search);
        }

        return switch (category.toLowerCase()) {
            case "theme" -> poemRepository.findByTheme(search);
            case "wordsused" -> poemRepository.findByContent(search);
            default -> poemRepository.findBySearchTerm(search);
        };
    }

    @GetMapping("/poems/recent")
    public List<String> getRecentPoems() {
        return poemHistoryService.getRecentPoems();
    }
}
