package com.github.nogueiralegacy.curso.persistencia;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FabricaDeConexaoTest {
    @Test
    void testGetConexao() {
        Connection conexao = FabricaDeConexao.getConexao();

        assertNotNull(conexao);
    }

}
