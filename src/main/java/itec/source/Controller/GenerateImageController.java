package itec.source.Controller;

import itec.source.api.imageGenerator.Data;
import itec.source.api.imageGenerator.ImageRequest;
import itec.source.api.imageGenerator.ImageResponse;
import itec.source.Service.GenerateImageServiceImplementation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/images")
public class GenerateImageController {
    private final GenerateImageServiceImplementation imgService;

    public GenerateImageController(GenerateImageServiceImplementation imgService) {
        this.imgService = imgService;
    }

    @PostMapping(path = "/generate")
    public ResponseEntity<ImageResponse> generateImage(ImageRequest request) {
        ImageResponse response = new ImageResponse();
        response.setCreated(Long.getLong("123"));
        Data data = new Data();
        data.setUrl("https://oaidalleapiprodscus.blob.core.windows.net/private/org-v7D9NinSpdHbGzbqEhlh5KRT/user-HZYu7OAiEzMzb6VZyqqTSkBm/img-Y0f7TvIX8YhhtmAeiqgtHhyK.png?st=2023-04-01T17%3A46%3A32Z&se=2023-04-01T19%3A46%3A32Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-04-01T08%3A29%3A34Z&ske=2023-04-02T08%3A29%3A34Z&sks=b&skv=2021-08-06&sig=/VCTC1rEUvc3fqo0sASp7FbaFdUFpHETWYyr5TacpsQ%3D");
        response.setData(List.of(data));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
        return ResponseEntity.ok()
                .headers(headers)
                .body(response);
        //final var response = imgService.generateImage(request);
        // return ResponseEntity.ok(response.getBody());
    }

}

