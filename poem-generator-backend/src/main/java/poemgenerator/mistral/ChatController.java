package poemgenerator.mistral;

import org.springframework.web.bind.annotation.*;
import poemgenerator.poem.repository.PoemRepository;

import java.util.List;

// TODO: Add error handling and logging. Add response entity. Make async.
// How does it work with multiple requests? Limit the number of threads? Limit response size. Limit request size.
@RestController
@RequestMapping("/mistral")
public class ChatController {

    private final ChatService chatService;
    private final PoemRepository poemRepository;

    public ChatController(ChatService chatService, PoemRepository poemRepository) {
        this.chatService = chatService;
        this.poemRepository = poemRepository;
    }

    @GetMapping("/poem")
    public String getPoem(@RequestParam(value = "theme", defaultValue = "random theme") String theme) {
        return chatService.generatePoem(theme);
    }

    @GetMapping("/poems")
    public List<String> getAllPoems() {
        return poemRepository.findAll();
    }

}
