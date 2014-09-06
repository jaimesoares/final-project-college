package br.com.pizzaria.model;

import br.com.pizzaria.beans.ModuloBeans;
import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ModuloModel {

    public ModuloModel() {

    }

    public void cadastrarModulo(ModuloBeans moduloView) {

        String SQLInsertion = "insert into `pizzaria`.`programas`"
                + "(`pgm_nome`,`pgm_titulo`)"
                + "values (?,?);";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion)) {

            pstm.setString(1, moduloView.getNome());
            pstm.setString(2, moduloView.getTitulo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex.getMessage(), "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public void populaListaModulo(DefaultListModel modelo) {

        String SQLSelection = "select * from programas;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                ModuloBeans novo = new ModuloBeans();
                novo.setCodigo(rs.getInt("pgm_id"));
                novo.setNome(rs.getString("pgm_nome"));
                novo.setTitulo(rs.getString("pgm_titulo"));
                modelo.addElement(novo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Carregar Lista", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void editarModulo(ModuloBeans moduloBeans) {

        String SQLUpdate = "delete from `pizzaria`.`programas`"
                + "where `pgm_id` = ?;";
        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate)) {

            pstm.setInt(1, moduloBeans.getCodigo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
