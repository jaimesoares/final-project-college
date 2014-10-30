/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.model;

import br.com.pizzaria.bean.AtualizaMovimentoEstoqueBean;
import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jaime
 */
public class Estoque {

    /*
    Este método não realiza o comit no banco, portanto a classe que estiver chamando 
    deverá fazer o comit caso retorne verdadeia a condião.
    */
    
    
    public static boolean atualizaMovimentoEstoque(List<AtualizaMovimentoEstoqueBean> atualizaEstoque) {

        for (AtualizaMovimentoEstoqueBean MovimentoEstoque : atualizaEstoque) {
            if (!atualizaMovimentoEstoque(MovimentoEstoque)) {
                return false;
            }
        }
        return true;
    }

    public static boolean atualizaMovimentoEstoque(AtualizaMovimentoEstoqueBean atualizaMovimentoEstoque) {

        try {

            String SQLInsertItens = "insert into `pizzaria`.`movto_estoq`\n"
                    + "            (\n"
                    + "             `estq_dt_movto`,\n"
                    + "             `estq_cod_prod`,\n"
                    + "             `estq_tipo`,\n"
                    + "             `estq_qtd`)\n"
                    + "values (\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?);";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInsertItens);
            pstmt.setString(1, atualizaMovimentoEstoque.getDataMovimento());
            pstmt.setInt(2, atualizaMovimentoEstoque.getProdutoBean().getCodigo());
            pstmt.setInt(3, atualizaMovimentoEstoque.getTipoMovimento());
            pstmt.setLong(4, atualizaMovimentoEstoque.getQuantidadeProduto());

            pstmt.execute();            

        } catch (SQLException ex) {
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
            try {
                ConectaBanco.getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Impossível Atualizar Movimento Estoque " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            } catch (SQLException ex1) {
                Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

        
   

        boolean insert = true;

        if (atualizaMovimentoEstoque.getProdutoBean().getEstocavel() == 'S') {
            long quantidadeEntrada = 0;
            long quantidadeSaida = 0;
            long saldoAtual;
            long saldoAnterior = 0;
            String dataSaldoEstoque;

            /*Pesquisa para verificar todas as ocorrências de um produto de entrada e saída na data atual da tabela movto_estoq*/
            try {
                String SQLPesquisa = "select\n"
                        + "  `estq_id`,\n"
                        + "  `estq_dt_movto`,\n"
                        + "  `estq_cod_prod`,\n"
                        + "  `estq_tipo`,\n"
                        + "  `estq_qtd`\n"
                        + "from `pizzaria`.`movto_estoq`"
                        + "WHERE `estq_cod_prod` = '" + atualizaMovimentoEstoque.getProdutoBean().getCodigo() + "'"
                        + " and `estq_dt_movto` = '" + atualizaMovimentoEstoque.getDataMovimento() + "';";

                PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int tipoMovimentacaoEstoque = rs.getInt("estq_tipo");

                    if (tipoMovimentacaoEstoque == 1 || tipoMovimentacaoEstoque == 4 || tipoMovimentacaoEstoque == 6 || tipoMovimentacaoEstoque == 8) {
                        quantidadeSaida += rs.getLong("estq_qtd");
                    }
                    if (tipoMovimentacaoEstoque == 2 || tipoMovimentacaoEstoque == 3 || tipoMovimentacaoEstoque == 5 || tipoMovimentacaoEstoque == 7) {
                        quantidadeEntrada += rs.getLong("estq_qtd");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Pesquisa para verificar todas as ocorrências de um produto de entrada e saída na data atual " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            }

            /*Pesquisa para saber o saldo anterior do produto acima*/
            try {
                String SQLPesquisa = "select \n"
                        + "  `sdoe_dt_movto`,\n"
                        + "  `sdoe_cod_prod`,\n"
                        + "  `sdoe_qtd_sdo_ant`,\n"
                        + "  `sdoe_qtd_ent`,\n"
                        + "  `sdoe_qtd_sai`,\n"
                        + "  `sdoe_qtd_sdo_atu` \n"
                        + "from\n"
                        + "  `pizzaria`.`saldo_estoque` \n"
                        + "where `sdoe_cod_prod` = " + atualizaMovimentoEstoque.getProdutoBean().getCodigo() + "\n "/*+ " AND `sdoe_dt_movto` < '" + pedidoBeans.getData() + "'\n "*/
                        + "ORDER BY `sdoe_dt_movto` desc \n"
                        + "limit 2 ;";

                PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) { //verifico se tem algum registro do produto

                    dataSaldoEstoque = rs.getString("sdoe_dt_movto");

                    if (dataSaldoEstoque.equals(atualizaMovimentoEstoque.getDataMovimento())) {//se o resultado do rs for a data atual, então contém registo deste produto de hoje
                        if (rs.next()) {//verifico a data anterior da última atualização do registro desse produto
                            saldoAnterior = rs.getLong("sdoe_qtd_sdo_atu");
                        }
                        insert = false;
                    } else { //caso possua apenas o registro de hoje
                        saldoAnterior = rs.getLong("sdoe_qtd_sdo_atu");
                        insert = true;
                    }

                } else {
                    insert = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Pesquisa para saber o saldo anterior do produto " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                return false;
            }

            if (!insert) {
                //fazer update
                try {
                    String SQLUpdate = "update `pizzaria`.`saldo_estoque`\n"
                            + "set \n"
                            + "  `sdoe_qtd_sdo_ant` = ?,\n"
                            + "  `sdoe_qtd_ent` = ?,\n"
                            + "  `sdoe_qtd_sai` = ?,\n"
                            + "  `sdoe_qtd_sdo_atu` = ?\n"
                            + "where `sdoe_dt_movto` = ?\n"
                            + "    and `sdoe_cod_prod` = ?;";
                    PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
                    pstm.setLong(1, saldoAnterior);
                    pstm.setLong(2, quantidadeEntrada);
                    pstm.setLong(3, quantidadeSaida);

                    saldoAtual = saldoAnterior + quantidadeEntrada - quantidadeSaida;
                    pstm.setLong(4, saldoAtual); //saldo que deverá ser atualizado

                    pstm.setString(5, atualizaMovimentoEstoque.getDataMovimento());
                    pstm.setInt(6, atualizaMovimentoEstoque.getProdutoBean().getCodigo());

                    pstm.executeUpdate();

                    //JOptionPane.showMessageDialog(null, "Produto alterado com sucesso! ", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
                } catch (SQLException ex) {
                    Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        ConectaBanco.getConnection().rollback();
                        JOptionPane.showMessageDialog(null, "Update tabela saldo estoque" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                    } catch (SQLException ex1) {
                        Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    return false;
                }
            } else {
                //fazer insert
                try {
                    String SQLInsert = "insert into `pizzaria`.`saldo_estoque`\n"
                            + "            (`sdoe_dt_movto`,\n"
                            + "             `sdoe_cod_prod`,\n"
                            + "             `sdoe_qtd_sdo_ant`,\n"
                            + "             `sdoe_qtd_ent`,\n"
                            + "             `sdoe_qtd_sai`,\n"
                            + "             `sdoe_qtd_sdo_atu`)\n"
                            + "values (?,\n"
                            + "       ?,\n"
                            + "        ?,\n"
                            + "        ?,\n"
                            + "       ?,\n"
                            + "        ?);";
                    PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsert);
                    pstm.setString(1, atualizaMovimentoEstoque.getDataMovimento());
                    pstm.setInt(2, atualizaMovimentoEstoque.getProdutoBean().getCodigo());
                    pstm.setLong(3, saldoAnterior);
                    pstm.setLong(4, quantidadeEntrada);
                    pstm.setLong(5, quantidadeSaida);

                    saldoAtual = saldoAnterior + quantidadeEntrada - quantidadeSaida;
                    pstm.setLong(6, saldoAtual); //saldo que deverá ser atualizado

                    pstm.execute();

                    //JOptionPane.showMessageDialog(null, "Produto alterado com sucesso! ", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
                } catch (SQLException ex) {
                    Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
                    try {
                        ConectaBanco.getConnection().rollback();
                        JOptionPane.showMessageDialog(null, "Insert tabela saldo estoque" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                    } catch (SQLException ex1) {
                        Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    return false;
                }
            }
        }

        return true;
    }

}
