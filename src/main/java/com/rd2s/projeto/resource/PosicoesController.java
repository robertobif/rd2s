package com.rd2s.projeto.resource;

import com.rd2s.projeto.model.Posicoes;
import com.rd2s.projeto.repository.PosicoesRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posicoes")
public class PosicoesController {

    @Autowired
    private PosicoesRepository repository;

    @GetMapping
    public List<PosicoesDTO> getPosicoes() {
        return repository.findAll().stream().map(p-> PosicoesDTO.toDTO(p)).collect(Collectors.toList());
    }



    @GetMapping("/{id}")
    public PosicoesDTO getPosicoesId(@PathVariable(value = "id") Long posicoesId) throws EntityNotFoundException {

        Posicoes posicoesFind = repository.findById(posicoesId).orElseThrow(() -> new EntityNotFoundException("Posição não encontrada com ID :: " + posicoesId));

        return PosicoesDTO.toDTO(posicoesFind);

    }

    @PostMapping
    public PosicoesDTO create(@Valid @RequestBody Posicoes posicoes) {

        return PosicoesDTO.toDTO(repository.save(posicoes));

    }

    @PutMapping("/{id}")
    public Posicoes update(@PathVariable(value = "id") Long posicoesId, @RequestBody Posicoes posicoes) throws EntityNotFoundException {
        Posicoes posicoesFind = repository.findById(posicoesId).orElseThrow(() -> new EntityNotFoundException("Posição não encontrada com ID:: " + posicoesId));

        posicoesFind.setId(posicoes.getId());
        posicoesFind.setDescricao(posicoes.getDescricao());
        posicoesFind.setSigla_pos(posicoes.getSigla_pos());

        return repository.save(posicoesFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long paisId) throws EntityNotFoundException {
        Pais paisFind = repository.findById(paisId).orElseThrow(() -> new EntityNotFoundException("Pais não encontrado com ID :: " + paisId));

        repository.delete(paisFind);

        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
