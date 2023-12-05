package com.github.nogueiralegacy.curso.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Curso {
    private Long id;
    private String nome;
    private int ano;
    private List<Disciplina> disciplinas;

    public Curso(Long id, String nome, int ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.disciplinas = new ArrayList<>();
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void removeDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
    }
}
