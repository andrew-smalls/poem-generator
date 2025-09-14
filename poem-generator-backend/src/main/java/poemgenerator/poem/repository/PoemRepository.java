package poemgenerator.poem.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import poemgenerator.poem.model.Poem;

@Repository
public interface PoemRepository extends JpaRepository<Poem, Long> {
}
