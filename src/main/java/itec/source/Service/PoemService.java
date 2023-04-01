package itec.source.Service;

import itec.source.Model.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import itec.source.Repository.PoemRepository;

@Service
public class PoemService {

    @Autowired
    private PoemRepository poemRepository;

    public PoemService(PoemRepository poemRepository) {
        this.poemRepository = poemRepository;
    }

    public Poem get(int id) {
        return poemRepository.getById(id);
    }
}
