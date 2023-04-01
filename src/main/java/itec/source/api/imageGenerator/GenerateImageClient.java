package itec.source.api.imageGenerator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "imageGenerator", url = "${openai.image-generator.url}", configuration = GenerateImageConfig.class)
public interface GenerateImageClient {
        @PostMapping(value = "/v1/images/generations")
        ResponseEntity<ImageResponse> generateImage(@RequestBody final ImageRequest request);
}
