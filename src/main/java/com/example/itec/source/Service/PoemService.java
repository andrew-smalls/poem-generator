package source.Service;

import org.springframework.stereotype.Service;
import source.Model.Poem;
import source.Repository.PoemRepository;

@Service
public class PoemService {

    private PoemRepository poemRepository;

    public PoemService(PoemRepository poemRepository) {
        this.poemRepository = poemRepository;
    }

    public Poem get(int id) {
        return poemRepository.getById(id);
    }
}
