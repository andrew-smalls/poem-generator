package poemgenerator.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import poemgenerator.poem.model.Poem;
import poemgenerator.poem.repository.PoemRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class DatabaseTests {

    @Autowired
    private PoemRepository poemRepository;
    @Test
    void testSaveAndFindPoem() {
        Poem poem = new Poem();
        poem.setUserId(UUID.randomUUID());
        poem.setTheme("Nature");
        poem.setContent("A small test poem");
        poem.setCreationDate(LocalDateTime.now());

        Poem saved = poemRepository.save(poem);

        assertThat(saved.getId()).isNotNull();
        assertThat(poemRepository.findById(saved.getId())).isPresent();
    }

    @Test
    void testDeletePoem() {
        Poem poem = new Poem();
        poem.setUserId(UUID.randomUUID());
        poem.setTheme("Delete test");
        poem.setContent("Temporary poem");
        poem.setCreationDate(LocalDateTime.now());

        Poem saved = poemRepository.save(poem);
        poemRepository.deleteById(saved.getId());

        assertThat(poemRepository.findById(saved.getId())).isEmpty();
    }

}