package com.rd2s.projeto.model;

import com.rd2s.projeto.enterprise.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "POSICOES")
public class Posicoes extends AbstractEntity {

    @NotNull
    @Size(max = 25, message = "A Descrição não pode ter mais de {max} caracteres")
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotNull
    @Size (max = 3, message = "A Sigla não pode ter mais de {max} caracteres")
    @Column(name = "SIGLA_POS")
    private SiglaPosicoes sigla_pos;

    //    @ManyToOne
    //    @JoinColumn(name = "I_USUARIOS", referencedColumnName = "ID")
    //private Usuarios usuarios;

    //    @ManyToOne
    //    @JoinColumn(name = "I_USUARIOS", referencedColumnName = "ID")
    //private Usuarios usuariosAlt;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SiglaPosicoes getSigla_pos() {
        return sigla_pos;
    }

    public void setSigla_pos(SiglaPosicoes sigla_pos) {
        this.sigla_pos = sigla_pos;
    }

    @Override
    public String toString() {
        return "Posicoes{" +
                "descricao='" + descricao + '\'' +
                ", sigla_pos=" + sigla_pos +
                '}';
    }
}

/*
ID
DESCRICAO
SIGLA_POS - ENUM
ID_USUARIO
ID_USUARIOALT

*/