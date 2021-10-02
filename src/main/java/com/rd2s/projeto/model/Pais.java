package com.rd2s.projeto.model;

import com.rd2s.projeto.enterprise.AbstractRegion;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pais extends AbstractRegion {

    @Column(name = "INDICE_DES_HUM")
    private Integer idh;

}