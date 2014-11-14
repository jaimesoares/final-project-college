package br.com.pizzaria.util;

import ConfiguracaoBanco.EXECUTE.ConfiguraBancoMain;
import ConfiguracaoBanco.FACTORY.ConnectionFactory;
import ConfiguracaoBanco.FILE.ManageFiles;
import ConfiguracaoBanco.FILE.ManageFilesReader;
import ConfiguracaoBanco.GUI.Frame;
import ConfiguracaoBanco.GUI.FrameConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectaBanco implements AutoCloseable {

    private static Connection con;
    private static String status;

    String server;
    String door;
    String dataBase;
    String user;
    String password;

    public ConectaBanco() {

        try {
            ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

            server = manageFilesReader.getArrayDoArquivo()[0];
            door = manageFilesReader.getArrayDoArquivo()[1];
            dataBase = manageFilesReader.getArrayDoArquivo()[2];
            user = manageFilesReader.getArrayDoArquivo()[3];
            password = manageFilesReader.getArrayDoArquivo()[4];
            
            con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + door + "/" + dataBase, user, password);
            con.setAutoCommit(false);
            System.out.println("Conectou");
            status = "Conectou";
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            new Frame();
        } catch (IOException ex) {
            //Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no banco ");
            new FrameConnection();
            System.out.println("Erro ao conectar no banco");
            status = "Erro ao conectar no banco";
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

    public static String statusBanco() {
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
