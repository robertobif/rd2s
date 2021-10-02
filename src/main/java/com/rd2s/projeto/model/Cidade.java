package com.rd2s.projeto.model;


import com.rd2s.projeto.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends AbstractRegion {
    @ManyToOne
    @JoinColumn(name="I_ESTADO",referencedColumnName = "ID")
    private Estado estado;

    @Column(name = "INDICE_DES_HUM")
    private Integer idh;

    public Integer getIdh() {
        return idh;
    }

    public void setIdh(Integer idh) {
        this.idh = idh;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}