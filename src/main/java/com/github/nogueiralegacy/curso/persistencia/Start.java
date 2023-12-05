package com.github.nogueiralegacy.curso.persistencia;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.nogueiralegacy.curso.persistencia.repository.CursoRepository;
import com.github.nogueiralegacy.curso.utils.Utils;
import com.github.nogueiralegacy.curso.utils.dto.CursoDTO;
import com.github.nogueiralegacy.curso.utils.dto.UniversidadeDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {
    private final static Path dadosPath = new Utils().getPath("dados.xml");
    private final static CursoRepository cursoRepository = new CursoRepositoryDB();
    private final static XmlMapper xmlMapper = new XmlMapper();
    private final static String SCRIPT_DDL = getScriptDDL("script.ddl");


    static {
        deletarBanco(FabricaDeConexao.DATABASE_NAME);
        criarBanco(SCRIPT_DDL);
        carregarDados();
    }


    private static void carregarDados() {
        File file = dadosPath.toFile();
        if (file.exists()) {
            UniversidadeDTO universidadeDTO = null;
            try {
                universidadeDTO = xmlMapper.readValue(file, UniversidadeDTO.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (CursoDTO cursoDTO : universidadeDTO.getCursos()) {
                cursoRepository.save(cursoDTO.toCurso());
            }
        }
    }

    private static void deletarBanco(String databaseName) {
        Connection conexao = FabricaDeConexao.getConexao();


        try {
            Statement statement = conexao.createStatement();
            String sql = "do $$ declare\n" +
                    "    r record;\n" +
                    "begin\n" +
                    "    for r in (select tablename from pg_tables where schemaname = 'my-schema-name') loop\n" +
                    "        execute 'drop table if exists ' || quote_ident(r.tablename) || ' cascade';\n" +
                    "    end loop;\n" +
                    "end $$;";

            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void criarBanco(String scriptDDL) {
        Connection conexao = FabricaDeConexao.getConexao();

        try {
            Statement statement = conexao.createStatement();
            statement.execute(scriptDDL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getScriptDDL(String fileName) {
        String filePath = new Utils().getPath(fileName).toString();
        StringBuilder stringBuilder = null;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            stringBuilder = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
