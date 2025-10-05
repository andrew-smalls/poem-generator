package poemgenerator.poem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import poemgenerator.poem.model.Poem;

import java.util.List;

@Repository
public interface PoemRepository extends JpaRepository<Poem, Long> {

    @Query("SELECT p FROM Poem p WHERE LOWER(p.theme) = LOWER(:theme)")
    List<Poem> findByTheme(String theme);


    @Query("SELECT p FROM Poem p WHERE LOWER(p.content) LIKE LOWER(CONCAT('%', :content, '%'))")
    List<Poem> findByContent(String content);

    @Query("SELECT p FROM Poem p WHERE " +
            "LOWER(p.content) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(p.theme) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Poem> findBySearchTerm(String search);
}
