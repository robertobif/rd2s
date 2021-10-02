package com.rd2s.projeto.resource;


import com.rd2s.projeto.model.Usuarios;
import com.rd2s.projeto.model.Pais;
import com.rd2s.projeto.repository.UsuariosRepository;
//import com.rd2s.projeto.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosRepository repository;

    @GetMapping
    public List<UsuariosDTO> getUsuarios() {
        return repository.findAll().stream().map(c -> UsuariosDTO.toDTO(c)).collect(Collectors.toList());
    }

    @PostMapping
    public UsuariosDTO create(@Valid @RequestBody Usuarios usuarios) {
        return UsuariosDTO.toDTO(repository.save(usuarios));
    }
}