package com.rd2s.projeto.resource;

import com.rd2s.projeto.model.Estado;
import com.rd2s.projeto.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/estados")
public class EstadoController {
    @Autowired
    private EstadoRepository repository;

    @GetMapping
    public List<Estado> getEstado() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Estado getEstado(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com o ID: " + estadoId));
        return estadoFind;
    }

    @PostMapping
    public Estado create(@Valid @RequestBody Estado estado) {
        return repository.save(estado);
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable(value = "id") Long estadoId, @RequestBody Estado estado) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com o ID: " + estadoId));
        estadoFind.setId(estado.getId());
        estadoFind.setNome(estado.getNome());
        estadoFind.setPopulacao(estado.getPopulacao());
        estadoFind.setPais(estado.getPais());

        return repository.save(estadoFind);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long estadoId) throws EntityNotFoundException {
        Estado estadoFind = repository.findById(estadoId)
                .orElseThrow(() -> new EntityNotFoundException("Estado não encontrado com ID :: " + estadoId));
        repository.delete(estadoFind);

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
