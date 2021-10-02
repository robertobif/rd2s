package com.rd2s.projeto.resource;

import com.rd2s.projeto.model.Pais;

public class PaisDTO {

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

    public static PaisDTO toDTO(Pais pais) {

        PaisDTO dto = new PaisDTO();
        dto.setId(pais.getId());
        dto.setNome(pais.getNome());
        dto.setPopulacao(pais.getPopulacao());
        return dto;
    }

    public static Pais fromDTO(PaisDTO dto) {

        Pais entity = new Pais();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setPopulacao(dto.getPopulacao());

        return entity;
    }
}
