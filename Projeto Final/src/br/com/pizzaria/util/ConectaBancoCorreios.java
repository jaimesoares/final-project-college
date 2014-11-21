package br.com.pizzaria.util;

import ConfiguracaoBanco.FILE.ManageFiles;
import ConfiguracaoBanco.FILE.ManageFilesReader;
import ConfiguracaoBanco.GUI.Frame;
import ConfiguracaoBanco.GUI.FrameConnection;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaBancoCorreios implements AutoCloseable {

//    private final String url = "jdbc:mysql://localhost/cep.gpbe.17.01.2014";
//    private final String driverName = "com.mysql.jdbc.Driver";
//    private final String userName = "root";
//    private final String password = "root";
//    private static Connection con;
    
     private static Connection con;
    private static String status;

    String server;
    String door;
    String dataBase;
    String user;
    String password;

    public ConectaBancoCorreios() {
        try {
            ManageFiles manageFiles = new ManageFiles();
            ManageFilesReader manageFilesReader = new ManageFilesReader(5, manageFiles.getArquivoDeConf());

            server = manageFilesReader.getArrayDoArquivo()[0];
            door = manageFilesReader.getArrayDoArquivo()[1];
            dataBase = manageFilesReader.getArrayDoArquivo()[2];
            user = manageFilesReader.getArrayDoArquivo()[3];
            password = manageFilesReader.getArrayDoArquivo()[4];
            
            con = DriverManager.getConnection("jdbc:mysql://" + server + ":" + door + "/" + "pizzariacep", user, password);
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
            new ConectaBancoCorreios();
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        if (!con.isClosed()) {
            con.close();
        }
    }

    public static void main(String args[]) {
        ConectaBancoCorreios.populaCEP();
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void populaCEP() {
        System.out.println("populaCEP");
        int cont = 1;
        String SQLSelect = "SELECT "
                + "log_logradouro.log_tipo_logradouro, "
                + "log_logradouro.log_no as logradouro,"
                + "log_bairro.bai_no as bairro,"
                + "log_localidade.loc_no as cidade,"
                + "log_localidade.ufe_sg as uf,"
                + "log_logradouro.cep"
                + " FROM "
                + " `log_logradouro`,`log_localidade`,`log_bairro`"
                + " WHERE "
                + " log_logradouro.loc_nu_sequencial = log_localidade.loc_nu_sequencial"
                + " AND "
                + " log_logradouro.bai_nu_sequencial_ini = log_bairro.bai_nu_sequencial"
                + " AND "
                + " log_localidade.ufe_sg = 'SP';";

        try (PreparedStatement pstm = getConnection().prepareStatement(SQLSelect)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                try {

                    String SQLInsertLogradouro = "INSERT INTO `cep`(`cep_cod`,`cep_ender`,`cep_bai`,`cep_cid`,`cep_municip`)"
                            + "VALUES (?,?,?,?,?);";

                    PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInsertLogradouro);

                    pstmt.setString(1, rs.getString("cep"));
                    pstmt.setString(2, rs.getString("log_tipo_logradouro") +" "+ rs.getString("logradouro"));
                    pstmt.setString(3, rs.getString("bairro"));
                    pstmt.setString(4, rs.getString("cidade"));
                    pstmt.setInt(5, 1);

                    pstmt.execute();
                    ConectaBanco.getConnection().commit();

                    System.out.println(cont++);
                } catch (SQLException ex) {
                    System.out.println("ERRO CEP " + ex);
                }
                //Fim CEP              
                getConnection().commit();
            }
        } catch (SQLException e) {
            System.out.println("erro" + e);
        }

    }

}
