package itec.source.Repository;

import itec.source.Model.Poem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PoemRepository extends CrudRepository<Poem, Long> {

    @Query("SELECT p FROM Poem p WHERE p.id = ?1")
    public Poem getById(int id);

}
