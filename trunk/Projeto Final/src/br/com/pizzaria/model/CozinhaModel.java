/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.model;

import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author katia
 */
public class CozinhaModel {

    public CozinhaModel() {
    }

    public static void populaTabela(DefaultTableModel modelo) {
        try {
            String SQLSelection = "SELECT \n"
                    + "  p.ped_data,\n"
                    + "  p.ped_cod,\n"
                    + "  c.prd_descr,\n"
                    + "  i.`item_quantidade`,\n"
                    + "  p.ped_hr,\n"
                    + "  i.`item_cod_prod2`, \n"
                    + "  i.item_stt_meia_pizza, \n"
                    + "  t.`tprd_descr`\n"
                    + "FROM\n"
                    + "  pedido p \n"
                    + "  JOIN item i \n"
                    + "    ON i.item_ped_cod = p.`ped_cod` \n"
                    + "  JOIN produtos c \n"
                    + "    ON c.`prd_prod` = i.`item_cod_prod`\n"
                    + "    join `tipo_prod` t\n"
                    + "    on t.`tprd_id` = c.`prd_tipo_prod`\n"
                    + "WHERE p.`ped_stt_canc` = 'A' \n"
                    + "  AND t.`tprd_stt_pizza` = 'S'\n"
                    + "  AND p.ped_data = '" + VerificarData.converteParaSql(VerificarData.retornoDeDataAtual()) + "' \n"
                    + "ORDER BY p.`ped_hr` desc ;\n"
                    + "";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String meia = " ";
                if (rs.getString("item_stt_meia_pizza").equals("S")) {
                    meia = " meia";
                    modelo.addRow(new Object[]{rs.getString("ped_cod"), rs.getString("tprd_descr") + " " + rs.getString("prd_descr") +" "+ meia +" "+ produto(rs.getInt("item_cod_prod2")), rs.getInt("item_quantidade"), rs.getString("ped_hr")});

                } else {
                    modelo.addRow(new Object[]{rs.getString("ped_cod"), rs.getString("tprd_descr") + " " + rs.getString("prd_descr"), rs.getInt("item_quantidade"), rs.getString("ped_hr")});
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public static String produto(int codigo) {

        

        try {
            
            String SQLSelection = "select \n"
                    + "  p.`prd_descr`\n"
                    + "from\n"
                    + "  `pizzaria`.`produtos` p \n"
                    + "where p.`prd_prod` = ?;\n";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                return rs.getString("prd_descr");

            }
        } catch (SQLException ex) {
        }

        return "";
    }

//
//"SELECT p.ped_data, p.ped_cod, c.prd_descr, i.`item_quantidade`, p.ped_hr, i.item_stt_meia_pizza \n"
//                    + "                    FROM pedido p JOIN item i ON i.item_ped_cod = p.`ped_cod` \n"
//                    + "                    JOIN produtos c ON c.`prd_prod` = i.`item_cod_prod` \n"
//                    + "                    WHERE p.`ped_stt_canc` = 'A' AND c.`prd_tipo_prod` = 1 AND p.ped_data = '" + VerificarData.converteParaSql(VerificarData.retornoDeDataAtual()) + "'\n"
//                    + "                    ORDER BY p.`ped_hr` desc ;";
}
