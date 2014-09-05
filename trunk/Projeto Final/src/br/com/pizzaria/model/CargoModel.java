package br.com.pizzaria.model;

import br.com.pizzaria.beans.CargoBeans;
import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CargoModel {

    public CargoModel() {

    }

    public void cadastrarCargo(CargoBeans cargoBeans) {

        String SQLInsertion = "insert into `pizzaria`.`cargo`"
                + "(`crg_descr`)"
                + "values (?);";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion)) {

            pstm.setString(1, cargoBeans.getDescricao());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex.getMessage(), "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public void populaListaCargo(DefaultListModel modelo) {

        String SQLSelection = "select * from cargo;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                modelo.addElement(rs.getString("crg_descr"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Carregar Lista", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void editarCargo(CargoBeans cargoBeans) {

        String SQLUpdate = "delete from `pizzaria`.`cargo`"
                + "where `crg_id_cargo` = ?;";
        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate)) {

            pstm.setInt(1, cargoBeans.getCodigo());
            

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
