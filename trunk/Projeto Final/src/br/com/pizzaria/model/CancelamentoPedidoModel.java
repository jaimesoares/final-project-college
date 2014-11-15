package br.com.pizzaria.model;

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

public class CancelamentoPedidoModel {

    public CancelamentoPedidoModel() {
    }

    /**
     *
     * @param data
     * @param tabela
     */
    public void listarPedidoEntrega(String data, DefaultTableModel tabela) {
        String SqlSelection = "select \n"
                + "  p.`ped_cod`,\n"
                + "  p.`ped_tipo`,\n"
                + "  c.`cli_nome`,\n"
                + "  c.`cli_telefone`,\n"
                + "  p.`ped_pagamento`,\n"
                + "  p.`ped_vlr_tot`,\n"
                + "  p.ped_hr,\n"
                + "  p.`ped_stt_canc` \n"
                + "from\n"
                + "  `pizzaria`.`pedido` p \n"
                + "  join `cliente` c \n"
                + "    on c.`cli_cod` = p.`ped_cli_cod` \n"
                + "where `ped_tipo` = 'E' \n"
                + "  and `ped_data` = '" + VerificarData.converteParaSql(data) + "'\n"
                + "limit 0, 1000 ;";

//                 "where `ped_tipo` = 'E' and `ped_data` = '"+VerificarData.converteParaSql(data)+"'\n"
//                + ";";
        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), "Entrega", rs.getString("cli_nome"), rs.getString("cli_telefone"), rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), rs.getString("ped_stt_canc"), rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tabela
     */
    public void listarTodosPedidos(String data, DefaultTableModel tabela) {

        listarPedidoBalcao(data, tabela);
        listarPedidoEntrega(data, tabela);

//        String SqlSelection = "select \n"
//                + "  p.`ped_cod`,\n"
//                + "  p.`ped_tipo`,\n"
//                + "  c.`cli_nome`,\n"
//                + "  c.`cli_telefone`,\n"
//                + "  p.`ped_pagamento`,\n"
//                + "  p.`ped_vlr_tot`,\n"
//                + "  p.`ped_stt_canc` \n"
//                + "from\n"
//                + "  `pizzaria`.`pedido` p \n"
//                + "  join `cliente` c \n"
//                + "    on c.`cli_cod` = p.`ped_cli_cod` \n"
//                + "where `ped_tipo` = 'E' \n"
//                + "  and `ped_data` = '"+VerificarData.converteParaSql(data)+"'\n"
//                + "limit 0, 1000 ;";
//
//        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {
//
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                tabela.addRow(new Object[]{rs.getInt("ped_cod"), rs.getString("ped_tipo"), rs.getString("cli_nome"), rs.getString("cli_telefone"), rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), rs.getString("ped_stt_canc")});
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    /**
     *
     * @param dataInicial
     * @param dataFinal
     * @param tabela
     */
    public void listarPedidoBalcao(String data, DefaultTableModel tabela) {
        String SqlSelection = "select \n"
                + "  p.`ped_cod`,\n"
                + "  p.`ped_tipo`,\n"
                + "  p.`ped_pagamento`,\n"
                + "  p.`ped_vlr_tot`,\n"
                + "  p.ped_hr,\n"
                + "  p.`ped_stt_canc` \n"
                + "from\n"
                + "  `pizzaria`.`pedido` p \n"
                + "where `ped_tipo` = 'B' \n"
                + "  and `ped_data` = '" + VerificarData.converteParaSql(data) + "'\n"
                + "limit 0, 1000 ;";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), "Balcão", "", "", rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), rs.getString("ped_stt_canc"), rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarItemPedido(int codigo, DefaultTableModel tabela) {
        String SqlSelection = "SELECT \n"
                + "  t.`tprd_descr`,\n"
                + "  c.prd_descr,\n"
                + "  i.`item_preco_unit`,\n"
                + "  i.`item_quantidade`,\n"
                + "  i.`item_preco_tot`,\n"
                
                + "  i.item_stt_meia_pizza \n"
                + "FROM\n"
                + "  pedido p \n"
                + "  JOIN item i \n"
                + "    ON i.item_ped_cod = p.`ped_cod` \n"
                + "  JOIN produtos c \n"
                + "    ON c.`prd_prod` = i.`item_cod_prod` \n"
                + "  JOIN `tipo_prod` t\n"
                + "    ON t.`tprd_id`=c.`prd_tipo_prod`"
                + "WHERE p.ped_cod = " + codigo + " ;\n";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String meia = "";
                if (rs.getString("item_stt_meia_pizza").equals("S")) {
                    meia = " meia";
                }
                tabela.addRow(new Object[]{rs.getString("tprd_descr") + meia, rs.getString("prd_descr"), rs.getDouble("item_preco_unit"), rs.getInt("item_quantidade"), rs.getDouble("item_preco_tot")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean cancelarPedido(int codigo) {

        try {
            String SQLUpdate = "update \n"
                    + "  `pizzaria`.`pedido` \n"
                    + "set\n"
                    + "  `ped_stt_canc` = 'C' \n"
                    + "where `ped_cod` = ? ;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            pstm.setInt(1, codigo);

            int resultado = pstm.executeUpdate();

            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Alteração efetivada", 1, new ImageIcon("imagens/ticado.png"));
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
    }

    public static void main(String[] args) {
        CancelamentoPedidoModel novo = new CancelamentoPedidoModel();
        novo.listarPedidoEntrega(null, null);
    }
}
