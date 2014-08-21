package br.com.pizzaria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {

    private final String url = "jdbc:mysql://localhost/pizzaria_mama";
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String userName = "root";
    private final String password = "";
    private static Connection con;

    public ConectaBanco() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, userName, password);
            con.setAutoCommit(false);
            System.out.println("Conectou");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco");
        }

    }

    public static Connection getConnection() {
        if (con == null) {
            new ConectaBanco();
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        if (!con.isClosed()) {
            con.close();
        }
    }

    public static void main(String args[]) {
        ConectaBanco.getConnection();
    }

}