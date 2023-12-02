package curriculoathos.example.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import curriculoathos.example.model.Curriculo;
import curriculoathos.example.repository.CurriculoRepository;

import java.util.Optional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public Iterable<Curriculo> getCurriculos() {
        return curriculoRepository.findAll();
    }

    public Optional<Curriculo> getCurriculo(Long id) {
        return curriculoRepository.findById(id);
    }

    public Curriculo createCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public Curriculo updateCurriculo(Long id, Curriculo curriculo) {
        if (curriculoRepository.existsById(id)) {
            curriculo.setId(id);
            return curriculoRepository.save(curriculo);
        } else {
            throw new RuntimeException("Curriculo não encontrado");
        }
    }

    public void deleteCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }
}
