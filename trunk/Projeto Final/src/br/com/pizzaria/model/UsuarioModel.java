package br.com.pizzaria.model;

import br.com.pizzaria.beans.FuncionarioBeans;
import br.com.pizzaria.beans.UsuarioBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioModel {

    public UsuarioModel() {

    }

    public UsuarioBeans selectUser(UsuarioBeans user) {

        UsuarioBeans usuarioBeans = new UsuarioBeans();

        try {
            String SQLSelection = "SELECT * FROM usuario WHERE usu_login = '" + user.getUsuario() + "';";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                usuarioBeans.setCodigo(rs.getInt("usu_fun_cod"));
                usuarioBeans.setUsuario(rs.getString("usu_login"));
                usuarioBeans.setSenha(rs.getString("usu_senha"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar usuario", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
        return usuarioBeans;
    }
    
    public UsuarioBeans preencherCampos(int codigo) {

        UsuarioBeans usuarioBeans = new UsuarioBeans();

        try {
            String SQLSelection = "select * from usuario where usu_fun_cod = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                usuarioBeans.setCodigo(rs.getInt("usu_fun_cod"));
                usuarioBeans.setSenha(rs.getString("usu_senha"));
                usuarioBeans.setUsuario(rs.getString("usu_login"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return usuarioBeans;
    }
    
    public void cadastrarUsuario(UsuarioBeans usuarioBeans) {
        try {
            String SQLInsertion = "INSERT INTO `usuario`(`usu_login`,`usu_senha`,`usu_fun_cod`)"
                    + "VALUES (?,?,?);";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);
            pstm.setString(1, usuarioBeans.getUsuario());
            pstm.setString(2, usuarioBeans.getSenha());
            pstm.setInt(3, usuarioBeans.getCodigo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }
    
    public void editarUsuario(UsuarioBeans usuarioBeans) {
        try {
            String SQLUpdate = "UPDATE `usuario` SET `usu_login` = ?,`usu_senha` = ?"
                    + "WHERE `usu_fun_cod` = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            pstm.setString(1, usuarioBeans.getUsuario());
            pstm.setString(2, usuarioBeans.getSenha());
            pstm.setInt(3, usuarioBeans.getCodigo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }
    

    /*public static void main(String args[]){
     UsuarioModel user =new UsuarioModel();
     UsuarioBeans beans = new UsuarioBeans();
     beans.setSenha("123");
     beans.setUsuario("jaime");
     UsuarioBeans user2 = user.selectUser(beans);
     System.out.print(user2.getCodigo());
     }*/
}
