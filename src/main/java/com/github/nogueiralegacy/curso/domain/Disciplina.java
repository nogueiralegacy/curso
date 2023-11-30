package com.github.nogueiralegacy.curso.domain;

import lombok.Data;
import sun.awt.util.IdentityLinkedList;

@Data
public class Disciplina {
    private long id;
    private String nome;
    private int cargaHoraria;

    public Disciplina(long id, String nome, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        setCargaHoraria(cargaHoraria);
    }

    public void setCargaHoraria(int cargaHoraria) throws IllegalArgumentException {
        if (cargaHoraria > 0) {
            this.cargaHoraria = cargaHoraria;
        }
        throw new IllegalArgumentException();
    }
}
