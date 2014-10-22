/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pizzaria.model;

import br.com.pizzaria.util.ConectaBanco;
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
            String SQLSelection = "SELECT p.ped_cod, c.prd_descr, i.`item_quantidade`, p.ped_hr, i.item_stt_meia_pizza \n" +
"                    FROM pedido p JOIN item i ON i.item_ped_cod = p.`ped_cod` \n" +
"                    JOIN produtos c ON c.`prd_prod` = i.`item_cod_prod` \n" +
"                    WHERE p.`ped_stt_canc` = 'A' AND c.`prd_tipo_prod` = 1\n" +
"                    ORDER BY p.`ped_cod` desc ;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                String meia ="";
                if(rs.getString("item_stt_meia_pizza").equals("S")){
                    meia = " meia";
                }
                modelo.addRow(new Object[]{rs.getString("ped_cod"),rs.getString("prd_descr")+meia, rs.getInt("item_quantidade"), rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
    
    
//SELECT 
//  p.ped_cod,
//  c.car_descricao,
//  i.`item_quantidade`,
//  p.ped_hora 
//FROM
//  pedido p 
//  JOIN item i 
//    ON i.item_ped_cod = p.`ped_cod` 
//  JOIN cardapio c 
//    ON c.`car_cod` = i.`item_car_cod` 
//WHERE p.`ped_status` = 'Pedido aberto' 
//  AND c.`car_tipo` = 'Pizza' 
//     ORDER BY p.`ped_hora`;
}
