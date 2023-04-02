package itec.source.Controller;

import itec.source.Service.GenerateImageServiceImplementation;
import itec.source.api.imageGenerator.ImageRequest;
import itec.source.api.imageGenerator.ImageResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/images")
public class GenerateImageController {
    private final GenerateImageServiceImplementation imgService;

    public GenerateImageController(GenerateImageServiceImplementation imgService) {
        this.imgService = imgService;
    }

    @PostMapping(path = "/generate")
    public ResponseEntity<ImageResponse> generateImage(ImageRequest request) {
        ImageResponse response = imgService.generateImage(request).getBody();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
        return ResponseEntity.ok()
                .headers(headers)
                .body(response);
    }

}

