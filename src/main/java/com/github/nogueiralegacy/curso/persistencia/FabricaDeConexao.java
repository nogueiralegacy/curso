package com.github.nogueiralegacy.curso.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

    //TODO confirar para variáveis de ambiente
    public static String usuario = "admin01";
    public static String senha = "admin01";
    public static String textoDeConexao = "jdbc:mariadb://127.0.0.1:3306/faculdade";


    public static Connection getConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection(
                    textoDeConexao, usuario, senha);
            return conexao;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
