package curriculoathos.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import curriculoathos.example.model.Curriculo;
import curriculoathos.example.service.CurriculoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public Iterable<Curriculo> getCurriculos() {
        return curriculoService.getCurriculos();
    }

    @GetMapping("/{id}")
    public Optional<Curriculo> getCurriculo(@PathVariable Long id) {
        return curriculoService.getCurriculo(id);
    }

    @PostMapping
    public Curriculo createCurriculo(@RequestBody Curriculo curriculo) {
        return curriculoService.createCurriculo(curriculo);
    }

    @PutMapping("/{id}")
    public Curriculo updateCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        return curriculoService.updateCurriculo(id, curriculo);
    }

    @DeleteMapping("/{id}")
    public void deleteCurriculo(@PathVariable Long id) {
        curriculoService.deleteCurriculo(id);
    }
}
