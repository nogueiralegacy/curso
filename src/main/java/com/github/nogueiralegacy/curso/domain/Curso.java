package com.github.nogueiralegacy.curso.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Curso {
    private long id;
    private String nome;
    private int ano;
    private List<Disciplina> disciplinas;

    public Curso(long id, String nome, int ano) {
        this.id = id;
        this.nome = nome;
        setAno(ano);
        this.disciplinas = new ArrayList<>();
    }

    public void setAno(int ano) throws IllegalArgumentException {
        if (ano > 0) {
            this.ano = ano;
        }
        throw new IllegalArgumentException();
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void removeDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
    }
}
