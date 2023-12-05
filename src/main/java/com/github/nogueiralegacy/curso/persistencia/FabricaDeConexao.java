package com.github.nogueiralegacy.curso.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {

    public final static String USUARIO = "guest";
    public final static String SENHA = "password";
    public final static String DATABASE_NAME = "avaliacao1";
    public final static String HOST = "localhost";
    public final static String PORT = "5432";
    public final static String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;
    public final static String DRIVER = "org.postgresql.Driver";



    public static Connection getConexao() {
        try {
            Class.forName(DRIVER);
            Connection conexao = DriverManager.getConnection(
                    URL, USUARIO, SENHA);
            return conexao;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
