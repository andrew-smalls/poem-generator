package poemgenerator.poem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="poem")
public class Poem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id", nullable=false)
    private UUID userId;

    private String theme;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    public Poem(String poemContent, String theme, UUID userId) {
        this.setUserId(userId);
        this.setTheme(theme);
        this.setContent(poemContent);
        this.setCreationDate(LocalDateTime.now());
    }

    public Poem() {
    }
}
