package br.com.pizzaria.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaBanco implements AutoCloseable {

    private final String url = "jdbc:mysql://localhost/pizzaria";
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String userName = "root";
    private final String password = "root";
    private static Connection con;
    private static String status;

    public ConectaBanco() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(url, userName, password);
            con.setAutoCommit(false);
            System.out.println("Conectou");
            status="Conectou";
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Driver não encontrado \n Contatar o suporte");
            System.out.println("Driver não encontrado");
            status="Driver não encontrado";
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco \n Contatar o suporte ");
            System.out.println("Erro ao conectar ao banco");
            status="Erro ao conectar ao banco";
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
    
    public static String statusBanco(){
        return ConectaBanco.status;
    }

    public static void main(String args[]) {
        ConectaBanco.getConnection();
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
