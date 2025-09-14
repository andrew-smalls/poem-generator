package poemgenerator.poem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Poem")
public class Poem {
    @Id
    private Long id;

    private String content;
}
