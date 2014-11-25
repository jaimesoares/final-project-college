package br.com.pizzaria.model;

import br.com.pizzaria.bean.AjusteEstoqueBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AjusteEstoqueModel {

    public AjusteEstoqueModel() {
    }

    public void pesquisaProdutos(int codigo, List<ProdutoBean> listaDeItens) {
        try {
            String SQLPesquisa = "SELECT \n"
                    + "  t.`tprd_id`,\n"
                    + "  t.`tprd_descr`,\n"
                    + "  p.`prd_prod`,\n"
                    + "  p.`prd_prod_venda`,\n"
                    + "  p.`prd_descr`,\n"
                    + "  p.`prd_unid_med`,\n"
                    + "  p.`prod_estocavel`\n "
                    //                    + "  c.`sdoe_qtd_sdo_atu` \n"
                    + "FROM\n"
                    + "  `pizzaria`.`tipo_prod` t \n"
                    + "  JOIN `pizzaria`.`produtos` p \n"
                    + "    ON p.`prd_tipo_prod`=t.tprd_id \n"
                    //                     + "  JOIN `pizzaria`.`saldo_estoque` c \n"
                    //                    + "    ON c.sdoe_cod_prod = p.prd_prod \n"
                    + "WHERE t.`tprd_id` = '" + codigo + "' and p.`prod_estocavel` ='S';";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProdutoBean novo = new ProdutoBean();
                novo.setCodigo(rs.getInt("prd_prod"));
                novo.setDescricao(rs.getString("prd_descr"));
                novo.getTipoProduto().setCodigo(rs.getInt("tprd_id"));
                novo.getTipoProduto().setDescricao(rs.getString("tprd_descr"));
                novo.setEstocavel(rs.getString("prod_estocavel").charAt(0));
                novo.setUnidadeMedida(rs.getString("prd_unid_med"));

                listaDeItens.add(novo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void populaListaTipoProduto(List<TipoProdutoBean> lista) {
        String SQLSelection = "select \n"
                + "  `tprd_id`,\n"
                + "  `tprd_descr`,\n"
                + "  `tprd_stt_pizza` \n"
                + "from\n"
                + "  `pizzaria`.`tipo_prod` \n"
                + "where tprd_stt_pizza='N';";

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

    public void populaListaData(int codigo, List<String> lista) {
        String SQLSelection = "SELECT DISTINCT \n"
                + "  s.`sdoe_dt_movto` \n"
                + "FROM\n"
                + "  `pizzaria`.`saldo_estoque` s \n"
                + "WHERE `sdoe_cod_prod` = '" + codigo + "' \n"
                + "LIMIT 0, 1000 ;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                lista.add(VerificarData.converteParaJAVA(rs.getString("sdoe_dt_movto")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Carregar Lista " + ex, "Erro de SQL ", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void listarTabelaMovimentoEstoque(String data, int codigo, DefaultTableModel tabela, JTextField anterior, JTextField atual) {
        String SqlSelection = "SELECT \n"
                + "  m.`estq_id`,\n"
                + "  m.`estq_dt_movto`,\n"
                + "  m.`estq_cod_prod`,\n"
                + "  m.`estq_tipo`,\n"
                + "  m.`estq_qtd`,\n"
                + "  s.`sdoe_dt_movto`,\n"
                + "  s.`sdoe_cod_prod`,\n"
                + "  s.`sdoe_qtd_sdo_ant`,\n"
                + "  s.`sdoe_qtd_ent`,\n"
                + "  s.`sdoe_qtd_sai`,\n"
                + "  s.`sdoe_qtd_sdo_atu`,\n"
                + "  t.`tme_descr`,\n"
                + "  t.`tme_stt_ent_sai` \n"
                + "FROM\n"
                + "  `pizzaria`.`saldo_estoque` s \n"
                + "  JOIN `movto_estoq` m \n"
                + "    ON m.`estq_cod_prod` = s.`sdoe_cod_prod` \n"
                + "  JOIN `tipo_movto_estoq` t \n"
                + "    ON t.`tme_id_tipo` = m.`estq_tipo` \n"
                + "WHERE `sdoe_cod_prod` = '" + codigo + "' \n"
                + "AND sdoe_dt_movto = '" + VerificarData.converteParaSql(data) + "' and `estq_dt_movto` = '" + VerificarData.converteParaSql(data) + "'\n"
                + "LIMIT 0, 1000 ;";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            long entrada = 0;
            long saida = 0;
            long total = 0;

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                anterior.setText(String.valueOf(rs.getLong("sdoe_qtd_sdo_ant")));
                atual.setText(String.valueOf(rs.getLong("sdoe_qtd_sdo_atu")));
                if (rs.getString("tme_stt_ent_sai").equals("E")) {
                    entrada += rs.getLong("estq_qtd");
                } else {
                    saida += rs.getLong("estq_qtd");
                }
                total = entrada - saida;
                tabela.addRow(new Object[]{rs.getString("tme_descr"), rs.getString("tme_stt_ent_sai"), rs.getLong("estq_qtd")});
            }
            tabela.addRow(new Object[]{"", "", ""});
            tabela.addRow(new Object[]{"Total:", "", total});
        } catch (SQLException ex) {
            Logger.getLogger(AjusteEstoqueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public long pesquisaQuantidadeAtual(int codigoProduto) {
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
                    + "where `sdoe_cod_prod` = " + codigoProduto + "\n "
                    + "ORDER BY `sdoe_dt_movto` desc \n"
                    + "limit 1 ;";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                return rs.getLong("sdoe_qtd_sdo_atu");

            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Pesquisa data movimento produto " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return 0;
        }
        return 0;
    }

    public boolean ajusteEstoque(AjusteEstoqueBean ajusteEstoque) {

        try {
            String SQLInserePedido = "insert into `pizzaria`.`ajuste_estoq`\n"
                    + "            (\n"
                    + "             `aju_dt_movto`,\n"
                    + "             `aju_cod_prod`,\n"
                    + "             `aju_tipo_movto`,\n"
                    + "             `aju_qtd`,\n"
                    + "             `aju_cod_func`)\n"
                    + "values (?,\n"
                    + "       ?,\n"
                    + "       ?,\n"
                    + "       ?,\n"
                    + "       ?);";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInserePedido);
            pstmt.setString(1, VerificarData.converteParaSql(ajusteEstoque.getDataMovimento()));
            pstmt.setInt(2, ajusteEstoque.getProdutoBean().getCodigo());
            pstmt.setInt(3, ajusteEstoque.getTipoMovimento());
            pstmt.setLong(4, ajusteEstoque.getAjusteMovimento());
            pstmt.setInt(5, ajusteEstoque.getCodigoFunc());
            pstmt.execute();
            
            if (atualizaMovimentoEstoque(ajusteEstoque)) {
                ConectaBanco.getConnection().commit();
                JOptionPane.showMessageDialog(null, "Estoque atualizado", "ESTOQUE", 1, new ImageIcon("imagens/ticado.png"));
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            try {
                ConectaBanco.getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Impossível Cadastrar Pedido" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            } catch (SQLException ex1) {
                Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }

    }
    
    
    
    public boolean atualizaMovimentoEstoque(AjusteEstoqueBean ajusteEstoque) {

      
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
                pstmt.setString(1, VerificarData.converteParaSql(ajusteEstoque.getDataMovimento()));
                pstmt.setInt(2, ajusteEstoque.getProdutoBean().getCodigo());
                pstmt.setInt(3, ajusteEstoque.getTipoMovimento());
                pstmt.setLong(4, ajusteEstoque.getAjusteMovimento());

                pstmt.execute();

                if (!atualizaSaldoEstoque(ajusteEstoque)) {
                    return false;
                }

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
        
        return true;
    }

    public boolean atualizaSaldoEstoque(AjusteEstoqueBean ajusteEstoque) {

        boolean insert = true;

        

            if (ajusteEstoque.getProdutoBean().getEstocavel() == 'S') {
                long quantidadeEntrada = 0;
                long quantidadeSaida = 0;
                long saldoAtual = 0;
                long saldoAnterior = 0;
                String dataSaldoEstoque ;

                /*Pesquisa para verificar todas as ocorrências de um produto de entrada e saída na data atual da tabela movto_estoq*/
                try {
                    String SQLPesquisa = "select\n"
                            + "  `estq_id`,\n"
                            + "  `estq_dt_movto`,\n"
                            + "  `estq_cod_prod`,\n"
                            + "  `estq_tipo`,\n"
                            + "  `estq_qtd`\n"
                            + "from `pizzaria`.`movto_estoq`"
                            + "WHERE `estq_cod_prod` = '" + ajusteEstoque.getProdutoBean().getCodigo() + "'"
                            + " and `estq_dt_movto` = '" + VerificarData.converteParaSql(ajusteEstoque.getDataMovimento()) + "';";

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
                            + "where `sdoe_cod_prod` = " + ajusteEstoque.getProdutoBean().getCodigo() + "\n "/*+ " AND `sdoe_dt_movto` < '" + pedidoBeans.getData() + "'\n "*/
                            + "ORDER BY `sdoe_dt_movto` desc \n"
                            + "limit 2 ;";

                    PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) { //verifico se tem algum registro do produto

                        dataSaldoEstoque = rs.getString("sdoe_dt_movto");

                        if (dataSaldoEstoque.equals(VerificarData.converteParaSql(ajusteEstoque.getDataMovimento()))) {//se o resultado do rs for a data atual, então contém registo deste produto de hoje
                            if (rs.next()) {//verifico a data anterior da última atualização do registro desse produto
                                dataSaldoEstoque = rs.getString("sdoe_dt_movto");
                                saldoAnterior = rs.getLong("sdoe_qtd_sdo_atu");
                                insert = false;
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

                        pstm.setString(5, VerificarData.converteParaSql(ajusteEstoque.getDataMovimento()));
                        pstm.setInt(6, ajusteEstoque.getProdutoBean().getCodigo());

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
                        pstm.setString(1, VerificarData.converteParaSql(ajusteEstoque.getDataMovimento()));
                        pstm.setInt(2, ajusteEstoque.getProdutoBean().getCodigo());
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
