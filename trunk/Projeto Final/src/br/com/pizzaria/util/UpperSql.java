/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.util;

import br.com.pizzaria.bean.TipoProdutoBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaime
 */
public class UpperSql {

    public void populaListaTipoProduto() {
        String SQLSelection = "SELECT\n"
                + "  `tprd_id`,\n"
                + "  `tprd_descr`,\n"
                + "  `tprd_stt_pizza`\n"
                + "FROM `pizzaria`.`tipo_prod`\n"
                + "LIMIT 0, 1000;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                try {

                    String Update = "UPDATE `pizzaria`.`tipo_prod`\n"
                            + "SET "
                            + "  `tprd_descr` = UPPER('" + rs.getString("tprd_descr") + "')\n"
                            + "WHERE `tprd_id` = '" + rs.getInt("tprd_id") + "';";
                    PreparedStatement pstm2 = ConectaBanco.getConnection().prepareStatement(Update);
                    pstm2.executeUpdate();
                    ConectaBanco.getConnection().commit();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossível UPPER " + ex, "Erro de SQL ", 0, new ImageIcon("imagens/cancelar.png"));
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível PESQUISA" + ex, "Erro de SQL ", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void populaListaCargo() {
        String SQLSelection = "SELECT\n"
                + "  `crg_id_cargo`,\n"
                + "  `crg_descr`\n"
                + "FROM `pizzaria`.`cargo`\n"
                + "LIMIT 0, 1000;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

                try {

                    String Update = "UPDATE `pizzaria`.`cargo`\n"
                            + "SET "
                            + "  `crg_descr` = UPPER('" + rs.getString("crg_descr") + "')\n"
                            + "WHERE `crg_id_cargo` = '" + rs.getInt("crg_id_cargo") + "';";
                    PreparedStatement pstm2 = ConectaBanco.getConnection().prepareStatement(Update);
                    pstm2.executeUpdate();
                    ConectaBanco.getConnection().commit();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossível UPPER " + ex, "Erro de SQL ", 0, new ImageIcon("imagens/cancelar.png"));
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível PESQUISA" + ex, "Erro de SQL ", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public static void main(String[] args) {
        UpperSql novo = new UpperSql();
        novo.populaListaCargo();
    }
}
