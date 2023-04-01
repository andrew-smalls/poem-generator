package itec.source.Service;

import org.springframework.stereotype.Service;

@Service
public interface GenerateImageService {
    GenerateImageResponse generateImage(GenerateImageRequest generateImageRequest);
}
