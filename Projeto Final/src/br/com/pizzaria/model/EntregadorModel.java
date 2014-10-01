package br.com.pizzaria.model;

import br.com.pizzaria.beans.ClienteBean;
import br.com.pizzaria.beans.EntregadorBean;
import br.com.pizzaria.beans.FuncionarioBean;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EntregadorModel {

    public EntregadorModel() {

    }

    public void cadastrarEntregador(EntregadorBean entregadorBeans) {
        try {
            String SQLInsertion = "INSERT INTO `entregador`(`ent_nome`,`ent_permissao`,`ent_datacad`,"
                    + "`ent_status`)"
                    + "VALUES (?,?,?,?);";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);
            pstm.setString(1, entregadorBeans.getNome());
            pstm.setString(2, "ENT");            
            pstm.setString(3, VerificarData.converteParaSql(entregadorBeans.getDataCad()));
            pstm.setString(4, "Livre");
                
            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public String proximoEntrgador() {
        try {
            String SQLSelection = "SELECT * FROM entregador order by ent_cod desc limit 1";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("ent_cod")) + 1) + "";
            } else {
                String SQLResetIncrement = "alter table entregador auto_increment = 1";
                PreparedStatement pstmIncrement = ConectaBanco.getConnection().prepareStatement(SQLResetIncrement);
                pstmIncrement.execute();
                ConectaBanco.getConnection().commit();
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex.getMessage(), "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return "0";
        }
    }

    public void procuraEntregador(String pesquisa, DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from entregador where ent_nome like '%" + pesquisa + "%';";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("ent_cod"), rs.getString("ent_nome")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Pesquisar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public EntregadorBean preencherCampos(int codigo) {

        EntregadorBean entregadorBeans = new EntregadorBean();

        try {
            String SQLSelection = "select * from entregador where ent_cod = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                entregadorBeans.setCodigo(rs.getInt("ent_cod"));
                entregadorBeans.setNome(rs.getString("ent_nome"));
                entregadorBeans.setStatus(rs.getString("ent_status"));
                entregadorBeans.setPermissao(rs.getString("ent_permissao"));
                entregadorBeans.setDataCad(VerificarData.converteParaJAVA(rs.getString("ent_datacad")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return entregadorBeans;
    }

    public void editarEntregador(EntregadorBean entregadorBeans) {
        try {
            String SQLUpdate = "UPDATE `entregador` SET `ent_nome` = ?"
                    + "WHERE `ent_cod` = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            pstm.setString(1, entregadorBeans.getNome());
            pstm.setInt(2, entregadorBeans.getCodigo());
            

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
