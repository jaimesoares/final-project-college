package br.com.pizzaria.model;

import br.com.pizzaria.beans.TipoProdutoBeans;
import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TipoProdutoModel {

    public TipoProdutoModel() {

    }

    public void cadastrarTipoProduto(String descricao) {

        String SQLInsertion = "insert into `pizzaria`.`tipo_prod`"
                + "(`tprd_descr`)"
                + "values (?);";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion)) {

            pstm.setString(1, descricao);

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public void populaListaTipoProduto(DefaultListModel modelo) {

        String SQLSelection = "select * from tipo_prod;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                TipoProdutoBeans novo = new TipoProdutoBeans();
                novo.setCodigo(rs.getInt("tprd_id"));
                novo.setDescricao(rs.getString("tprd_descr"));
                modelo.addElement(novo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Carregar Lista " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void editarTipoProduto(TipoProdutoBeans tipoProdutoBeans) {

        String SQLUpdate = "delete from `pizzaria`.`tipo_prod`"
                + "where `tprd_id` = ?;";
        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate)) {

            pstm.setInt(1, tipoProdutoBeans.getCodigo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
