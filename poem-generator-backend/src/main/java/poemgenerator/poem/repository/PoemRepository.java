package poemgenerator.poem.repository;

import org.springframework.stereotype.Repository;
import poemgenerator.poem.model.Poem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PoemRepository {
    private final List<String> poems = new ArrayList<>();

    public void save(String poem) {
        poems.add(poem);
    }

    public List<String> findAll() {
        return Collections.unmodifiableList(poems);
    }

}
