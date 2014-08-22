package br.com.pizzaria.model;

import br.com.pizzaria.beans.UsuarioBeans;
import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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

    /*public static void main(String args[]){
     UsuarioModel user =new UsuarioModel();
     UsuarioBeans beans = new UsuarioBeans();
     beans.setSenha("123");
     beans.setUsuario("jaime");
     UsuarioBeans user2 = user.selectUser(beans);
     System.out.print(user2.getCodigo());
     }*/
}
