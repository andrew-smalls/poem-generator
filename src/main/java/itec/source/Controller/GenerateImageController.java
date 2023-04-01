package itec.source.Controller;

import itec.source.Service.GenerateImageRequest;
import itec.source.Service.GenerateImageResponse;
import itec.source.Service.GenerateImageServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class GenerateImageController {
    @Autowired
    private final GenerateImageServiceImplementation imgService;

    public GenerateImageController(GenerateImageServiceImplementation imgService) {
        this.imgService = imgService;
    }

    @GetMapping("/generate")
    public ResponseEntity<GenerateImageResponse> generateImage(@RequestBody GenerateImageRequest request) {
        final GenerateImageResponse response = imgService.generateImage(request);
        return ResponseEntity.ok(response);
    }

}

