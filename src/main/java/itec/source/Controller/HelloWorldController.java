package itec.source.Controller;

import itec.source.Model.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
