package br.com.pizzaria.model;

import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.beans.FuncionarioBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoModel {

    public ProdutoModel() {
    }

    public String proximoCardapio() {
        try {
            String SQLSelection = "SELECT * FROM cardapio order by car_cod desc limit 1";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("car_cod")) + 1) + "";
            } else {
                String SQLResetIncrement = "alter table cardapio auto_increment = 1";
                PreparedStatement pstmIncrement = ConectaBanco.getConnection().prepareStatement(SQLResetIncrement);
                pstmIncrement.execute();
                ConectaBanco.getConnection().commit();
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex.getMessage(), "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return "0";
        }
    }

    public void cadastrarCardapio(ProdutoBeans cardapioBeans) {
        try {
            String SQLInsertion = "INSERT INTO `cardapio`(`car_descricao`,`car_tipo`,`car_valor`)"
                    + "VALUES (?,?,?);";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);
            pstm.setString(1, cardapioBeans.getDescricao());
            pstm.setString(2, cardapioBeans.getTipo());
            pstm.setDouble(3, cardapioBeans.getValor());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public void procuraCardapio(String pesquisa, DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from cardapio where car_descricao like '%" + pesquisa + "%';";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("car_cod"), rs.getString("car_descricao"), rs.getString("car_tipo"), rs.getString("car_valor")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public ProdutoBeans preencherCampos(int codigo) {

        ProdutoBeans cardapioBeans = new ProdutoBeans();

        try {
            String SQLSelection = "select * from cardapio where car_cod = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                cardapioBeans.setCodigo(rs.getInt("car_cod"));
                cardapioBeans.setDescricao(rs.getString("car_descricao"));
                cardapioBeans.setTipo(rs.getString("car_tipo"));
                cardapioBeans.setValor(rs.getDouble("car_valor"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return cardapioBeans;
    }

    public void editarCardapio(ProdutoBeans cardapioBeans) {
        try {
            String SQLUpdate = "UPDATE `cardapio` SET"
                    + "`car_descricao` = ?,"
                    + "`car_tipo` = ?,"
                    + "`car_valor` = ?"
                    + "WHERE `car_cod` = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            pstm.setString(1, cardapioBeans.getDescricao());
            pstm.setString(2, cardapioBeans.getTipo());
            pstm.setDouble(3, cardapioBeans.getValor());
            pstm.setInt(4, cardapioBeans.getCodigo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
