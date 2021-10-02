package com.rd2s.projeto.resource;

import com.rd2s.projeto.model.Posicoes;
import com.rd2s.projeto.model.SiglaPosicoes;

public class PosicoesDTO {

    private Long id;
    private String descricao;
    private SiglaPosicoes siglaPosicoes;
    //private Usuarios usuarios;
    //private Usuarios usuariosAlt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SiglaPosicoes getSiglaPosicoes() {
        return siglaPosicoes;
    }

    public void setSiglaPosicoes(SiglaPosicoes siglaPosicoes) {
        this.siglaPosicoes = siglaPosicoes;
    }

    public static PosicoesDTO toDTO(Posicoes posicoes){

        PosicoesDTO dto = new PosicoesDTO();
        dto.setId(posicoes.getId());
        dto.setDescricao(posicoes.getDescricao());
        dto.setSiglaPosicoes(posicoes.getSigla_pos());
        return dto;
    }

    public static Posicoes fromDTO(PosicoesDTO dto){

        Posicoes entity = new Posicoes();
        entity.setId(dto.getId());
        entity.setDescricao(dto.getDescricao());
        entity.setSigla_pos(dto.getSiglaPosicoes());

        return entity;
    }

}
