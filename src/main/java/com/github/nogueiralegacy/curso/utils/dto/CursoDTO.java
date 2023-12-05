package com.github.nogueiralegacy.curso.utils.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.github.nogueiralegacy.curso.domain.Curso;
import com.github.nogueiralegacy.curso.domain.Disciplina;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "curso")
public class CursoDTO {
    private Long iden;
    private int ano;
    private String nome;
    @JacksonXmlProperty(localName = "disciplina")
    private String disciplinaNome;
    private int ch;

    public Curso toCurso() {
        Curso curso = new Curso(iden, nome, ano);
        curso.addDisciplina(new Disciplina(disciplinaNome, ch));

        return curso;
    }
}
