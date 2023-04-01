package itec.source.Controller;

import itec.source.api.imageGenerator.ImageRequest;
import itec.source.api.imageGenerator.ImageResponse;
import itec.source.Service.GenerateImageServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class GenerateImageController {
    private final GenerateImageServiceImplementation imgService;

    public GenerateImageController(GenerateImageServiceImplementation imgService) {
        this.imgService = imgService;
    }

    @PostMapping("generate")
    public ResponseEntity<ImageResponse> generateImage(@Valid @RequestBody ImageRequest request) {
        final var response = imgService.generateImage(request);
        return ResponseEntity.ok(response.getBody());
    }

}

