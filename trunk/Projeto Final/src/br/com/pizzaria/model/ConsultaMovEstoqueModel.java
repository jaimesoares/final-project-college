package br.com.pizzaria.model;

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

public class ConsultaMovEstoqueModel {

    public ConsultaMovEstoqueModel() {
    }

    

    public void pesquisaItens(int codigo, List<ProdutoBean> listaDeItens) {
        try {
            String SQLPesquisa = "SELECT \n"
                    + "  t.`tprd_id`,\n"
                    + "  t.`tprd_descr`,\n"
                    + "  p.`prd_prod`,\n"
                    + "  p.`prd_prod_venda`,\n"
                    + "  p.`prd_descr`,\n"
                    + "  p.`prd_unid_med`,\n"
                    + "  p.`prod_estocavel`\n "
                    //+ "  c.`tprc_preco` \n"
                    + "FROM\n"
                    + "  `pizzaria`.`tipo_prod` t \n"
                    + "  JOIN `pizzaria`.`produtos` p \n"
                    + "    ON t.tprd_id = p.`prd_tipo_prod` \n"
                    // + "  JOIN `pizzaria`.`tab_precos_venda` c \n"
                    //+ "    ON c.tprc_cod_prod = p.prd_prod \n"
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
            Logger.getLogger(ConsultaMovEstoqueModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
