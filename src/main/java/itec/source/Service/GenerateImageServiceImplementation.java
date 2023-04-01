package itec.source.Service;

import itec.source.api.imageGenerator.GenerateImageClient;
import itec.source.api.imageGenerator.ImageRequest;
import itec.source.api.imageGenerator.ImageResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenerateImageServiceImplementation {
    private final GenerateImageClient imgClient;

    public ResponseEntity<ImageResponse> generateImage(ImageRequest request) {
        ResponseEntity<ImageResponse> response = imgClient.generateImage(request);
        return response;
    }

}

