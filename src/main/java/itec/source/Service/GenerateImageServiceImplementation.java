package itec.source.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class GenerateImageServiceImplementation implements GenerateImageService {
    private final GenerateImageClient imgClient;

    public GenerateImageResponse generateImage(final GenerateImageRequest request) {
        final GenerateImageResponse response = imgClient.generateImage(request);
        return response;
    }

}

