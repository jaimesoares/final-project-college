package br.com.pizzaria.model;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.beans.ModuloBeans;
import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.beans.TipoProdutoBeans;
import br.com.pizzaria.beans.UsuarioBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PrecoProdutoModel {

    public PrecoProdutoModel() {

    }

    /**
     * Método sobrescrito para trabalhar com a pesquisa da tela de pedido do
     * cliente
     *
     * @param pesquisa o nome dos clientes para o pedido
     * @param tipo
     * @param lista para popular o comboBox da pesquisa
     */
    public void populaProduto(List<ProdutoBeans> lista) {
        try {
            String SQLSelection = "select * from produtos;";
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

                produtoBeans.setDataCad(VerificadoresECorretores.converteParaJAVA(rs.getString("prod_data_cadastro")));
                produtoBeans.setDescricao(rs.getString("prd_descr"));
                produtoBeans.setEstocavel(rs.getString("prod_estocavel").charAt(0));
                produtoBeans.setQtdSaldoEstoque(rs.getDouble("prd_qtd_saldo_estoq"));
                produtoBeans.setAvisaEstoqueMinimo(rs.getString("prd_stt_avisa_estoq_min").charAt(0));
                produtoBeans.setQtdMinima(rs.getDouble("prd_qtd_min_estoq"));
                produtoBeans.setCodigo(rs.getInt("prd_prod"));
                lista.add(produtoBeans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar"+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
    
    

    
}
