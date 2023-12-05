package com.github.nogueiralegacy.curso.persistencia;

import com.github.nogueiralegacy.curso.domain.Curso;
import com.github.nogueiralegacy.curso.domain.Disciplina;
import com.github.nogueiralegacy.curso.persistencia.repository.CursoRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CursoRepositoryDB implements CursoRepository {
    private final static Connection conexao = FabricaDeConexao.getConexao();

    @Override
    public boolean save(Curso curso) {
        try {
            String cursoSql = "INSERT INTO curso(iden, nome, ano) VALUES (?, ?, ?)";
            String disciplinaSql = "INSERT INTO disciplina(nome, ch, iden_curso) VALUES (?, ?, ?)";



            PreparedStatement cursoInstrucao = this.conexao.prepareStatement(cursoSql);
            PreparedStatement disciplinaInstrucao = this.conexao.prepareStatement(disciplinaSql);

            cursoInstrucao.setLong(1, curso.getId());
            cursoInstrucao.setString(2, curso.getNome());
            cursoInstrucao.setInt(3, curso.getAno());
            cursoInstrucao.executeUpdate();

            for (Disciplina disciplina : curso.getDisciplinas()) {
                disciplinaInstrucao.setString(1, disciplina.getNome());
                disciplinaInstrucao.setInt(2, disciplina.getCargaHoraria());
                disciplinaInstrucao.setLong(3, curso.getId());
                disciplinaInstrucao.addBatch();
            }

            disciplinaInstrucao.executeBatch();

            this.conexao.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    @Override
    public boolean saveAll(List<Curso> cursos) {
        return false;
    }

    @Override
    public Optional<Curso> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Curso> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }
}
