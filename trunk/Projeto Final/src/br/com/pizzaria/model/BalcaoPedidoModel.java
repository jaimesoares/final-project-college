package br.com.pizzaria.model;

import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BalcaoPedidoModel {

    public BalcaoPedidoModel() {
    }

    public void pesquisaItens(String pesquisa, List<ProdutoBean> listaDeItens) {
        try {
//            
//            String SQLPesquisa ="SELECT \n"
//                    + "  i.prd_descr,\n"
//                    + "  p.`tprc_vigencia`,\n"
//                    + "  p.`tprc_preco` ,\n"
//                    + "  p.`tprc_cod_prod` \n"
//                    + "FROM\n"
//                    + "  tab_precos_venda p \n"
//                    + "  JOIN produtos i \n"
//                    + "    ON i.prd_prod = p.`tprc_cod_prod` \n"
//                    + "WHERE i.`prd_descr`like '%" + pesquisa + "%' \n"
//                    + "ORDER BY `tprc_vigencia` desc ;";
//            

            String SQLPesquisa = "select * from produtos where prd_descr like '%" + pesquisa + "%';";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProdutoBean novo = new ProdutoBean();
                novo.setCodigo(rs.getInt("prd_prod"));
                novo.setDescricao(rs.getString("prd_descr"));
                listaDeItens.add(novo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void cadastrarPedido(String codigoCliente, String codigoFuncioario, String total, int tamanhoTabela, PedidoBean pedidobeans) {
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
                    + "             `ped_obs`)\n"
                    + "values (\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    // + "        'ped_vlr_desc',\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?);";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInserePedido);
            pstmt.setInt(4, 1);
            pstmt.setString(5, "Jaime");
            pstmt.setString(1, formatoData.format(data));
            pstmt.setString(2, formatoHora.format(data));
            pstmt.setString(3, total);
            pstmt.setString(6, "Pedido aberto");

            pstmt.execute();
            cadastrarItens(codigoCliente, codigoFuncioario, codigoDoPedido(), tamanhoTabela, pedidobeans);
            //codigoDoPedido();
            ConectaBanco.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
        } catch (SQLException ex) {
            try {
                ConectaBanco.getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Impossível Cadastrar Pedido" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            } catch (SQLException ex1) {
                Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public String codigoDoPedido() {
        String codigo = "0";

        try {
            String SQLSelection = "select ped_cod from pedido order by ped_cod desc limit 1";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                codigo = rs.getString("ped_cod");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null, codigo);
        return codigo;
    }

    public void cadastrarItens(String codigoCliente, String codigoFuncioario, String codigoPedido, int tamanhoTabela, PedidoBean pedidoBeans) {
        for (int i = 0; i < tamanhoTabela; i++) {
            try {
                

                String SQLInsertItens = "insert into `pizzaria`.`item`\n"
                        + "            (`item_ped_cod`,\n"
                        + "             `item_cod_prod`,\n"
                        + "             `item_quantidade`,\n"
                        + "             `item_preco_unit`\n"
                        + "             )\n"
                        + "values (?,\n"
                        + "        ?,\n"
                        + "        ?,\n"
                        + "        ?\n"
                        + "        );";

                PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInsertItens);
                pstmt.setString(1, codigoPedido);
                pstmt.setInt(2, pedidoBeans.getCodProduto(i));
                pstmt.setInt(3, pedidoBeans.getQuantidade(i));
                pstmt.setDouble(4, pedidoBeans.getValorTotalPedido());

                pstmt.execute();
            } catch (SQLException ex) {
                try {
                    ConectaBanco.getConnection().rollback();
                    JOptionPane.showMessageDialog(null, "Impossível Cadastrar Item" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                } catch (SQLException ex1) {
                    Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }

}
