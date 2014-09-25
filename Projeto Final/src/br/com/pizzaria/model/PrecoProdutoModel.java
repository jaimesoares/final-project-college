package br.com.pizzaria.model;

import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.beans.TipoProdutoBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrecoProdutoModel {

    DecimalFormat decimalFormato;

    public PrecoProdutoModel() {
        decimalFormato = new DecimalFormat("0.00");

    }

    /**
     * Método sobrescrito para trabalhar com a pesquisa da tela de pedido do
     * cliente
     *
     * @param pesquisa o nome dos clientes para o pedido
     * @param tipo
     * @param lista para popular o comboBox da pesquisa
     */
    public void populaProduto(List<ProdutoBeans> lista, int tipoProduto) {
        try {
            String SQLSelection = "select * from produtos where prd_tipo_prod = '" + tipoProduto + "';";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ProdutoBeans produtoBeans = new ProdutoBeans();
                String SQLSelect = "select * from tipo_prod where tprd_id = '" + rs.getInt("prd_tipo_prod") + "';";
                try (PreparedStatement pstmProduto = ConectaBanco.getConnection().prepareStatement(SQLSelect)) {

                    ResultSet rsProduto = pstmProduto.executeQuery();

                    if (rsProduto.next()) {
                        TipoProdutoBeans novo = new TipoProdutoBeans();
                        novo.setCodigo(rsProduto.getInt("tprd_id"));
                        novo.setDescricao(rsProduto.getString("tprd_descr"));
                        produtoBeans.setTipoProduto(novo);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossível Preencher Campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                }

                produtoBeans.setDataCad(VerificarData.converteParaJAVA(rs.getString("prod_data_cadastro")));
                produtoBeans.setDescricao(rs.getString("prd_descr"));
                produtoBeans.setEstocavel(rs.getString("prod_estocavel").charAt(0));
                produtoBeans.setQtdSaldoEstoque(rs.getDouble("prd_qtd_saldo_estoq"));
                produtoBeans.setAvisaEstoqueMinimo(rs.getString("prd_stt_avisa_estoq_min").charAt(0));
                produtoBeans.setQtdMinima(rs.getDouble("prd_qtd_min_estoq"));
                produtoBeans.setCodigo(rs.getInt("prd_prod"));
                lista.add(produtoBeans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void cadastrarPrecoProduto(int codigo, double preco) {

        String SQLInsertion = "insert into `pizzaria`.`tab_precos_venda`\n"
                + "            (`tprc_cod_prod`,\n"
                + "             `tprc_vigencia`,\n"
                + "             `tprc_preco`)\n"
                + "values (?,\n"
                + "        ?,\n"
                + "        ?);";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion)) {

            pstm.setInt(1, codigo);
            pstm.setDouble(3, preco);
            pstm.setString(2, VerificarData.converteParaSql(VerificarData.retornoDeDataAtual()));

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex.getMessage(), "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public void pesquisaPrecoProduto(int codigo, DefaultTableModel modelo) {
        try {
            String SQLSelection = "SELECT \n"
                    + "  i.prd_descr,\n"
                    + "  p.`tprc_vigencia`,\n"
                    + "  p.`tprc_preco` ,\n"
                    + "  t.`tprd_descr`\n"
                    + "FROM\n"
                    + "  tab_precos_venda p \n"
                    + "  JOIN produtos i \n"
                    + "    ON i.prd_prod = p.`tprc_cod_prod` \n"
                    + "  join `tipo_prod` t \n"
                    + "    on t.`tprd_id` = i.`prd_tipo_prod` \n"
                    + "WHERE i.`prd_prod` = '" + codigo + "' \n"
                    + "ORDER BY `tprc_vigencia` desc ;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("prd_descr"), rs.getString("tprd_descr"), decimalFormato.format(rs.getDouble("tprc_preco")), VerificarData.converteParaJAVA(String.valueOf(rs.getDate("tprc_vigencia")))});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
