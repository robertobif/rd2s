package com.rd2s.projeto.resource;

import com.rd2s.projeto.model.Estado;
import com.rd2s.projeto.model.Pais;

public class EstadoDTO {
    private Long id;
    private String nome;
    private String populacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }
    public static EstadoDTO toDTO(Estado estado){
        EstadoDTO dto = new EstadoDTO();
        dto.setId(estado.getId());
        dto.setNome(estado.getNome());
        dto.setPopulacao(estado.getPopulacao());
        return dto;
    }

    public static Estado fromDTO(EstadoDTO dto){
        Estado entity = new Estado();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setPopulacao(dto.getPopulacao());
        return entity;
    }
}

