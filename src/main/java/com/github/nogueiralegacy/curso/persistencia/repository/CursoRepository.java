package com.github.nogueiralegacy.curso.persistencia.repository;

import com.github.nogueiralegacy.curso.domain.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    /**
     * Salvar uma entidade Curso no componente de persistência
     *
     * @param curso Endidate curso a ser salva
     * @return true caso a entidade seja salva com sucesso e false caso contrário
     */
    boolean save(Curso curso);

    boolean saveAll(List<Curso> cursos);

    /**
     * Recupera da persistência uma entidade de curso pelo seu identificado
     * @param id Identificador da entidade curso
     * @return Um Optional com um curso presente caso o curso seja encontredo
     * ou um Optinal vazio caso o curso não seja encontrado
     */
    Optional<Curso> findById(long id);

    /**
     * Recupera todas as entidades de curso salvas na persistência
     *
     * @return Retorna um List com entidades de Curso, podendo estar vazia
     */
    List<Curso> findAll();

    /**
     * Deleta da persistência uma entidade de curso
     *
     * @param id Identificador de Curso
     * @return Retorna true caso a operação tenha sido feita com sucesso e
     * false caso contrário
     */
    boolean deleteById(long id);

}
