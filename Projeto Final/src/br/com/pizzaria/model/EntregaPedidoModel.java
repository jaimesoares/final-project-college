package br.com.pizzaria.model;

import br.com.pizzaria.bean.CupomBean;
import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.GeneratorPDF;
import br.com.pizzaria.util.VerificarData;
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

    public void pesquisaItens(int pesquisa, List<ProdutoBean> listaDeItens) {
        try {
            String SQLPesquisa = "SELECT \n"
                    + "  t.`tprd_id`,\n"
                    + "  t.`tprd_descr`,\n"
                    + "  p.`prd_prod`,\n"
                    + "  p.`prd_descr`\n"
                    //+ "  c.`tprc_preco` \n"
                    + "FROM\n"
                    + "  `pizzaria`.`tipo_prod` t \n"
                    + "  JOIN `pizzaria`.`produtos` p \n"
                    + "    ON t.tprd_id = p.`prd_tipo_prod` \n"
                    // + "  JOIN `pizzaria`.`tab_precos_venda` c \n"
                    //+ "    ON c.tprc_cod_prod = p.prd_prod \n"
                    + "WHERE t.`tprd_id` = '" + pesquisa + "';";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProdutoBean novo = new ProdutoBean();
                novo.setCodigo(rs.getInt("prd_prod"));
                novo.setDescricao(rs.getString("prd_descr"));
                novo.getPrecoProduto().setPreco(valorDoItem(rs.getInt("prd_prod")));
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
            String SQLPesquisa = "select * from tab_precos_venda where tprc_cod_prod = ? order by `tprc_vigencia` DESC";
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

    public void cadastrarPedido(/*int codigoCliente, String codigoFuncioario, String total, int tamanhoTabela,*/PedidoBean pedidobeans) {

        Date data = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        pedidobeans.setData(formatoData.format(data));
        pedidobeans.setHora(formatoHora.format(data));

        try {
            String SQLInserePedido = "insert into `pizzaria`.`pedido`\n"
                    + "            (\n"
                    + "             `ped_data`,\n"
                    + "             `ped_hr`,\n"
                    + "             `ped_vlr_tot`,\n"
                    + "             `ped_cli_cod`,\n"
                    + "             `ped_id_usuario`,\n"
                    + "             `ped_stt_canc`,\n"
                    + "             `ped_tipo`,\n"
                    + "             `ped_pagamento`,\n"
                    + "             `ped_vlr_desc`,\n"
                    + "             `ped_obs`)\n"
                    + "values (\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?);";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInserePedido);
            pstmt.setObject(4, pedidobeans.getCodigoCliente());
            pstmt.setString(5, pedidobeans.getLoginUsuario());
            pstmt.setString(1, formatoData.format(data));
            pstmt.setString(2, formatoHora.format(data));
            pstmt.setDouble(3, pedidobeans.getValorTotalPedido());
            pstmt.setString(7, pedidobeans.getTipoPedido());
            pstmt.setString(8, pedidobeans.getTipoPagamento());
            pstmt.setString(10, pedidobeans.getObs());
            pstmt.setString(6, pedidobeans.getStatus());
            pstmt.setDouble(9, pedidobeans.getValorDesc());

            pstmt.execute();
            pedidobeans.setCodigoPedido(codigoDoPedido());

            if (cadastrarItens(codigoDoPedido(), pedidobeans) || cadastrarCupom(pedidobeans)) {
                ConectaBanco.getConnection().commit();
                JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
            }

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

    public boolean cadastrarItens(/*String codigoCliente, String codigoFuncioario, int tamanhoTabela,*//*String codigoCliente, String codigoFuncioario, int tamanhoTabela,*/int codigoPedido, PedidoBean pedidoBeans) {
        DecimalFormat formatoDecimal = new DecimalFormat("0.00");
//        List<String> cupom = new ArrayList<>();
        String totalPedido = formatoDecimal.format(pedidoBeans.getValorTotalPedido());
//        cupom.add(VerificarData.converteParaJAVA(pedidoBeans.getData()) + "      " + pedidoBeans.getHora());
//        cupom.add("---------------------------------------------------------");//60 espaços
//        cupom.add("                      CUPOM NÃO FISCAL                      ");//16 - 8
//        cupom.add("PROD                QTD       VL UNIT.  VL TOTAL  ");
        for (int i = 0; i < pedidoBeans.getItensPedido().size(); i++) {
            try {

                String SQLInsertItens = "insert into `pizzaria`.`item`\n"
                        + "            (`item_ped_cod`,\n"
                        + "             `item_cod_prod`,\n"
                        + "             `item_quantidade`,\n"
                        + "             `item_preco_unit`,\n"
                        + "             `item_preco_tot`,\n"
                        + "             `item_stt_meia_pizza`,\n"
                        + "             `item_cod_prod2`\n"
                        + "             )\n"
                        + "values (?,\n"
                        + "        ?,\n"
                        + "        ?,\n"
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

                if (pedidoBeans.getItensPedido().get(i).getMeiaPizza().endsWith("S")) {
                    pstmt.setString(6, pedidoBeans.getItensPedido().get(i).getMeiaPizza());
                    pstmt.setInt(7, pedidoBeans.getItensPedido().get(i).getCodigoProduto2());
                } else {
                    pstmt.setString(6, pedidoBeans.getItensPedido().get(i).getMeiaPizza());
                    pstmt.setString(7, null);
                }

                pstmt.execute();

//                cupom.add(campoNota(pedidoBeans.getItensPedido().get(i).getDescricao()) + "" + campoNota2(String.valueOf(pedidoBeans.getItensPedido().get(i).getQuantidade())) + "" + campoNota2(String.valueOf(formatoDecimal.format(pedidoBeans.getItensPedido().get(i).getPrecoUnitario()))) + "" + campoNota2(String.valueOf(formatoDecimal.format(pedidoBeans.getItensPedido().get(i).getPrecoTotal()))));
            } catch (SQLException ex) {
                Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
                try {
                    ConectaBanco.getConnection().rollback();
                    //JOptionPane.showMessageDialog(null, "Impossível Cadastrar Item" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));

                } catch (SQLException ex1) {
                    Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
                }
                return false;
            }
        }
//        cupom.add("------------------------------------------------------------");
//        cupom.add("Total:                                    R$" + totalPedido);
//        cupom.add(pedidoBeans.getTipoPagamento() + ":                                  R$" + pedidoBeans.getValorRecebido());
//        cupom.add("Troco:                                    R$" + pedidoBeans.getValorTroco());
//        JOptionPane.showMessageDialog(null, GeneratorPDF.gerarPDF(cupom));
        return true;
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

    public String campoNota(String campo) {
        int espaco = 20 - campo.length();

        for (int j = 0; j < espaco; j++) {
            campo = campo.concat(" ");
        }
        return campo;
    }

    public String campoNota2(String campo) {
        int espaco = 10 - campo.length();

        for (int j = 0; j < espaco; j++) {
            campo = campo.concat(" ");
        }
        return campo;
    }

    public void populaListaTipoProduto(List<TipoProdutoBean> lista) {
        String SQLSelection = "select \n"
                + "  `tprd_id`,\n"
                + "  `tprd_descr`,\n"
                + "  `tprd_stt_pizza` \n"
                + "from\n"
                + "  `pizzaria`.`tipo_prod` \n"
                + "where `tprd_descr` <> 'Pizza' and `tprd_descr` <> 'Borda';";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                TipoProdutoBean novo = new TipoProdutoBean();
                novo.setCodigo(rs.getInt("tprd_id"));
                novo.setDescricao(rs.getString("tprd_descr"));
                lista.add(novo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Carregar Lista " + ex, "Erro de SQL ", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void pesquisaPizza(List<ProdutoBean> listaDePizza) {
        try {
            String SQLPesquisa = "SELECT \n"
                    + "  t.`tprd_id`,\n"
                    + "  t.`tprd_descr`,\n"
                    + "  p.`prd_prod`,\n"
                    + "  p.`prd_descr`\n"
                    //+ "  c.`tprc_preco` \n"
                    + "FROM\n"
                    + "  `pizzaria`.`tipo_prod` t \n"
                    + "  JOIN `pizzaria`.`produtos` p \n"
                    + "    ON t.tprd_id = p.`prd_tipo_prod` \n"
                    // + "  JOIN `pizzaria`.`tab_precos_venda` c \n"
                    //+ "    ON c.tprc_cod_prod = p.prd_prod \n"
                    + "WHERE t.`tprd_descr` = 'Pizza';";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProdutoBean novo = new ProdutoBean();
                novo.setCodigo(rs.getInt("prd_prod"));
                novo.setDescricao(rs.getString("prd_descr"));
                novo.getPrecoProduto().setPreco(valorDoItem(rs.getInt("prd_prod")));
                novo.getTipoProduto().setCodigo(rs.getInt("tprd_id"));
                novo.getTipoProduto().setDescricao(rs.getString("tprd_descr"));
                listaDePizza.add(novo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pesquisaBorda(List<ProdutoBean> listaDePizza) {
        try {
            String SQLPesquisa = "SELECT \n"
                    + "  t.`tprd_id`,\n"
                    + "  t.`tprd_descr`,\n"
                    + "  p.`prd_prod`,\n"
                    + "  p.`prd_descr`\n"
                    //+ "  c.`tprc_preco` \n"
                    + "FROM\n"
                    + "  `pizzaria`.`tipo_prod` t \n"
                    + "  JOIN `pizzaria`.`produtos` p \n"
                    + "    ON t.tprd_id = p.`prd_tipo_prod` \n"
                    // + "  JOIN `pizzaria`.`tab_precos_venda` c \n"
                    //+ "    ON c.tprc_cod_prod = p.prd_prod \n"
                    + "WHERE t.`tprd_descr` = 'Borda';";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProdutoBean novo = new ProdutoBean();
                novo.setCodigo(rs.getInt("prd_prod"));
                novo.setDescricao(rs.getString("prd_descr"));
                novo.getPrecoProduto().setPreco(valorDoItem(rs.getInt("prd_prod")));
                novo.getTipoProduto().setCodigo(rs.getInt("tprd_id"));
                novo.getTipoProduto().setDescricao(rs.getString("tprd_descr"));
                listaDePizza.add(novo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean cadastrarCupom(PedidoBean pedidobeans) {

        try {
            String SQLInsereCupom = "insert into `pizzaria`.`cupom` (\n"
                    + "  `cup_vlr`,\n"
                    //+ "  `cup_tributos`,\n"
                    + "  `cup_dt_emissao`,\n"
                    + "  `cup_hr_emissao`,\n"
                    + "  `cup_ped_cod`\n"
                    + ") \n"
                    + "values\n"
                    + "  (\n"
                    + "    ?,\n"
                    //+ "    'cup_tributos',\n"
                    + "    ?,\n"
                    + "    ?,\n"
                    + "    ?\n"
                    + "  ) ;";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInsereCupom);
            pstmt.setString(2, pedidobeans.getData());
            pstmt.setString(3, pedidobeans.getHora());
            pstmt.setDouble(1, pedidobeans.getValorTotalPedido());
            pstmt.setInt(4, pedidobeans.getCodigoPedido());

            pstmt.execute();

            cadastrarItensCupom(codigoDoCupom(), pedidobeans);

            System.out.println("Cadastro cupom realizado!");

        } catch (SQLException ex) {
            try {
                ConectaBanco.getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Impossível Cadastrar Cupom" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));

            } catch (SQLException ex1) {
                Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
        return true;
    }

    public boolean cadastrarItensCupom(int codigoCupom, PedidoBean pedidoBeans) {

        for (int i = 0; i < pedidoBeans.getItensPedido().size(); i++) {
            try {

                String SQLInsertItens = "insert into `pizzaria`.`cupom_item` (\n"
                        + "  `cupi_cod_cup`,\n"
                        + "  `cupi_cod_prod`,\n"
                        + "  `cupi_qtd`,\n"
                        + "  `cupi_vlr_unit`,\n"
                        + "  `cupi_vlr_tot`,\n"
                        + "  `cupi_cod_prod2`,\n"
                        + "  `cupi_vlr_desc`\n"
                        // + "  `cupi_vlr_tributo`\n"
                        + ") \n"
                        + "values\n"
                        + "  (\n"
                        + "    ?,\n"
                        + "    ?,\n"
                        + "    ?,\n"
                        + "    ?,\n"
                        + "    ?,\n"
                        + "    ?,\n"
                        + "    ?\n"
                        + "  ) ;\n"
                        + "";

                PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInsertItens);
                pstmt.setInt(1, codigoCupom);
                pstmt.setInt(2, pedidoBeans.getItensPedido().get(i).getCodigoProduto());
                pstmt.setInt(3, pedidoBeans.getItensPedido().get(i).getQuantidade());
                pstmt.setDouble(4, pedidoBeans.getItensPedido().get(i).getPrecoUnitario());
                pstmt.setDouble(5, pedidoBeans.getItensPedido().get(i).getPrecoTotal());
                pstmt.setDouble(7, pedidoBeans.getItensPedido().get(i).getValotDesconto());

                if (pedidoBeans.getItensPedido().get(i).getMeiaPizza().endsWith("S")) {

                    pstmt.setInt(6, pedidoBeans.getItensPedido().get(i).getCodigoProduto2());
                } else {
                    pstmt.setString(6, null);
                }

                pstmt.execute();

            } catch (SQLException ex) {
                try {
                    ConectaBanco.getConnection().rollback();
                    JOptionPane.showMessageDialog(null, "Impossível Cadastrar Item de Cupom" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));

                } catch (SQLException ex1) {
                    Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
                }
                return false;
            }
        }
        return true;
    }

    public int codigoDoCupom() {
        int codigo = 0;

        try {
            String SQLSelection = "select cup_cod_id from cupom order by cup_cod_id desc limit 1";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                codigo = rs.getInt("cup_cod_id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(EntregaPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null, codigo);
        return codigo;
    }

    public void imprimirCupom(PedidoBean pedidoBeans) {
        Date data = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        pedidoBeans.setData(formatoData.format(data));
        pedidoBeans.setHora(formatoHora.format(data));

        String descricao = "";
        DecimalFormat formatoDecimal = new DecimalFormat("0.00");
        List<String> cupom = new ArrayList<>();
        String totalPedido = formatoDecimal.format(pedidoBeans.getValorTotalPedido());
        cupom.add(VerificarData.converteParaJAVA(pedidoBeans.getData()) + "      " + pedidoBeans.getHora());
        cupom.add("---------------------------------------------------------");//60 espaços
        cupom.add("                      CUPOM NÃO FISCAL                      ");//16 - 8
        cupom.add("PROD                QTD       VL UNIT.  VL TOTAL  ");
        for (int i = 0; i < pedidoBeans.getItensPedido().size(); i++) {

            if (pedidoBeans.getItensPedido().get(i).getMeiaPizza().endsWith("S")) {
                descricao = pedidoBeans.getItensPedido().get(i).getDescricao() + "/" + pesquisaProduto(pedidoBeans.getItensPedido().get(i).getCodigoProduto2());
            } else {
                descricao = pedidoBeans.getItensPedido().get(i).getDescricao();
            }

            cupom.add(campoNota(descricao) + "" + campoNota2(String.valueOf(pedidoBeans.getItensPedido().get(i).getQuantidade())) + "" + campoNota2(String.valueOf(formatoDecimal.format(pedidoBeans.getItensPedido().get(i).getPrecoUnitario()))) + "" + campoNota2(String.valueOf(formatoDecimal.format(pedidoBeans.getItensPedido().get(i).getPrecoTotal()))));

        }
        cupom.add("------------------------------------------------------------");
        cupom.add("Total:                                    R$" + totalPedido);
        cupom.add(pedidoBeans.getTipoPagamento() + ":                                  R$" + pedidoBeans.getValorRecebido());
        cupom.add("Troco:                                    R$" + pedidoBeans.getValorTroco());
        JOptionPane.showMessageDialog(null, GeneratorPDF.gerarPDF(cupom));
    }

}
