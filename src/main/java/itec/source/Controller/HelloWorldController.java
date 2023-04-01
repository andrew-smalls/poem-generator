package itec.source.Controller;

import itec.source.Model.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import itec.source.Service.PoemService;

@RestController
public class HelloWorldController {
    @Autowired
    PoemService poemService;
    @RequestMapping("/")
    public String hello()
    {
        return "Hello User";
    }

    @RequestMapping("/getPoem/{id}")
    public String getPoem(@PathVariable int id) {
        Poem poem = poemService.get(id);
        String content = poem.getContent();
        return "Fetched: " + content;
    }

    @GetMapping("/image")
    @ResponseBody
    public ResponseEntity<Resource> getImage() {
        Resource image = new FileSystemResource("src/main/resources/static/img.png");
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(image);
    }
}
