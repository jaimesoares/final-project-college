package br.com.pizzaria.model;

import br.com.pizzaria.beans.PedidoBeans;
import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.ConectaBancoPizzariMama;
import br.com.pizzaria.util.GeneratorPDF;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class EntregaPedidoModel {

    public EntregaPedidoModel() {
    }

    public void pesquisaItens(String pesquisa, List<ProdutoBeans> listaDeItens) {
        try {
            String SQLPesquisa = "SELECT \n"
                    + "  t.`tprd_id`,\n"
                    + "  t.`tprd_descr`,\n"
                    + "  p.`prd_prod`,\n"
                    + "  p.`prd_descr`,\n"
                    + "  c.`tprc_preco` \n"
                    + "FROM\n"
                    + "  `pizzaria`.`tipo_prod` t \n"
                    + "  JOIN `pizzaria`.`produtos` p \n"
                    + "    ON t.tprd_id = p.`prd_tipo_prod` \n"
                    + "  JOIN `pizzaria`.`tab_precos_venda` c \n"
                    + "    ON c.tprc_cod_prod = p.prd_prod \n"
                    + "WHERE p.`prd_descr` like '%" + pesquisa + "%' || t.`tprd_descr` LIKE '%" + pesquisa + "%' ;";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProdutoBeans novo = new ProdutoBeans();
                novo.setCodigo(rs.getInt("prd_prod"));
                novo.setDescricao(rs.getString("prd_descr"));
                novo.getPrecoProduto().setPreco(rs.getDouble("tprc_preco"));
                novo.getTipoProduto().setCodigo(rs.getInt("tprd_id"));
                novo.getTipoProduto().setDescricao(rs.getString("tprd_descr"));
                listaDeItens.add(novo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double valorDoItem(int codigoProduto) {
        try {

//                    
            String SQLPesquisa = "select * from tab_precos_venda where tprc_cod_prod = ?";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            pstmt.setInt(1, codigoProduto);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("tprc_preco");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int codigoDoItem(String pesquisa) {
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao = ?";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            pstmt.setString(1, pesquisa);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("car_cod");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void cadastrarPedido(/*int codigoCliente, String codigoFuncioario, String total, int tamanhoTabela,*/PedidoBeans pedidobeans) {

        Date data = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        try {
            String SQLInserePedido = "insert into `pizzaria`.`pedido`\n"
                    + "            (\n"
                    + "             `ped_data`,\n"
                    + "             `ped_hr`,\n"
                    + "             `ped_vlr_tot`,\n"
                    // + "             `ped_vlr_desc`,\n"
                    + "             `ped_cli_cod`,\n"
                    + "             `ped_id_usuario`,\n"   
                            + "             `ped_stt_canc`,\n"
                    + "             `ped_obs`)\n"
                    + "values (\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                   // + "        'ped_vlr_desc',\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?);";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInserePedido);
            pstmt.setInt(4, pedidobeans.getCodigoCliente());
            pstmt.setString(5, pedidobeans.getLoginUsuario());
            pstmt.setString(1, formatoData.format(data));
            pstmt.setString(2, formatoHora.format(data));
            pstmt.setDouble(3, pedidobeans.getValorTotalPedido());
            pstmt.setString(7, pedidobeans.getObs());
            pstmt.setString(6, pedidobeans.getStatus());

            pstmt.execute();
            cadastrarItens(/*codigoCliente, codigoFuncioario, tamanhoTabela,*/codigoDoPedido(), pedidobeans);
            //codigoDoPedido();
            ConectaBanco.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            try {
                ConectaBanco.getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Impossível Cadastrar Pedido" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            } catch (SQLException ex1) {
                Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public int codigoDoPedido() {
        int codigo = 0;

        try {
            String SQLSelection = "select ped_cod from pedido order by ped_cod desc limit 1";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                codigo = rs.getInt("ped_cod");
            }

        } catch (SQLException ex) {
            Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null, codigo);
        return codigo;
    }

    public void cadastrarItens(/*String codigoCliente, String codigoFuncioario, int tamanhoTabela,*/int codigoPedido, PedidoBeans pedidoBeans) {
        DecimalFormat formatoDecimal = new DecimalFormat("0.00");
        List<String> cupom = new ArrayList<>();
        String totalPedido = formatoDecimal.format(pedidoBeans.getValorTotalPedido());
        cupom.add("------------------------------------------------------------");
        cupom.add("                      CUPOM NÃO FISCAL                      ");//16 - 8
        cupom.add("PROD         QTD      VL UNIT.    VL TOTAL    ");
        for (int i = 0; i < pedidoBeans.getItensPedido().size(); i++) {
            try {

                String SQLInsertItens = "insert into `pizzaria`.`item`\n"
                        + "            (`item_ped_cod`,\n"
                        + "             `item_cod_prod`,\n"
                        + "             `item_quantidade`,\n"
                        + "             `item_preco_unit`,\n"
                        + "             `item_preco_tot`\n"
                        + "             )\n"
                        + "values (?,\n"
                        + "        ?,\n"
                        + "        ?,\n"
                        + "        ?,\n"
                        + "        ?\n"
                        + "        );";

                PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInsertItens);
                pstmt.setInt(1, codigoPedido);
                pstmt.setInt(2, pedidoBeans.getItensPedido().get(i).getCodigoProduto());
                pstmt.setInt(3, pedidoBeans.getItensPedido().get(i).getQuantidade());
                pstmt.setDouble(4, pedidoBeans.getItensPedido().get(i).getPrecoUnitario());
                pstmt.setDouble(5, pedidoBeans.getItensPedido().get(i).getPrecoTotal());

                pstmt.execute();

                
                
                
                cupom.add(campoNota(pedidoBeans.getItensPedido().get(i).getDescricao())+ "" + campoNota(String.valueOf(pedidoBeans.getItensPedido().get(i).getQuantidade())) + "" + campoNota(String.valueOf(formatoDecimal.format(pedidoBeans.getItensPedido().get(i).getPrecoUnitario()))) + "" + campoNota(String.valueOf(formatoDecimal.format(pedidoBeans.getItensPedido().get(i).getPrecoTotal()))));

            } catch (SQLException ex) {
                try {
                    ConectaBanco.getConnection().rollback();
                    JOptionPane.showMessageDialog(null, "Impossível Cadastrar Item" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                } catch (SQLException ex1) {
                    Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
        cupom.add("------------------------------------------------------------");
        cupom.add("Total:                                            R$"+totalPedido);
        JOptionPane.showMessageDialog(null, GeneratorPDF.gerarPDF(cupom));
    }

    public String pesquisaProduto(int codigo) {
        try {
//            
            String SQLPesquisa = "select * from produtos where prd_prod =" + codigo + ";";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("prd_descr");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public String campoNota(String campo){
        int espaco = 15-campo.length();
                
                for(int j=0; j<espaco;j++){
                    campo = campo.concat(" ");
                }
        return campo;
    }

}
