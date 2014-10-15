package br.com.pizzaria.model;

import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoModel {

    public ProdutoModel() {
    }

    public String proximoProduto() {
        try {
            String SQLSelection = "SELECT * FROM produtos order by prd_prod desc limit 1";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("prd_prod")) + 1) + "";
            } else {
                String SQLResetIncrement = "alter table produtos auto_increment = 1";
                PreparedStatement pstmIncrement = ConectaBanco.getConnection().prepareStatement(SQLResetIncrement);
                pstmIncrement.execute();
                ConectaBanco.getConnection().commit();
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex.getMessage(), "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return "0";
        }
    }

    public boolean cadastrarProduto(ProdutoBean produtoBeans) {
        try {
            String SQLInsertion = "insert into `pizzaria`.`produtos`\n"
                    + "             (`prd_descr`,\n"
                    + "             `prd_qtd_min_estoq`,\n"
                    + "             `prd_stt_avisa_estoq_min`,\n"
                    + "             `prd_tipo_prod`,\n"
                    + "             `prd_qtd_saldo_estoq`,\n"
                    + "             `prod_data_cadastro`,\n"
                    + "             `prod_estocavel`,"
                    + "             `prd_unid_med`,"
                    + "             `prd_acab_prima`,"
                    + "             `prd_prod_venda`"
                    + ")\n"
                    + "values (?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "       ?);";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);

            pstm.setString(1, produtoBeans.getDescricao());
            pstm.setDouble(2, produtoBeans.getQtdMinima());
            pstm.setString(3, String.valueOf(produtoBeans.getAvisaEstoqueMinimo()));
            pstm.setInt(4, produtoBeans.getTipoProduto().getCodigo());
            pstm.setDouble(5, produtoBeans.getQtdSaldoEstoque());
            pstm.setString(6, VerificarData.converteParaSql(produtoBeans.getDataCad()));
            pstm.setString(7, String.valueOf(produtoBeans.getEstocavel()));
            pstm.setString(8, String.valueOf(produtoBeans.getUnidadeMedida()));
            pstm.setString(9, String.valueOf(produtoBeans.getProdAcabadoPrima()));
            pstm.setString(10, String.valueOf(produtoBeans.getVenda()));

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

    }

    public void procuraProduto(String pesquisa, DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from produtos where prd_descr like '%" + pesquisa + "%';";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ProdutoBean novo = new ProdutoBean();
                novo.setDescricao(rs.getString("prd_descr"));
                novo.setCodigo(rs.getInt("prd_prod"));
                modelo.addRow(new Object[]{novo});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public ProdutoBean preencherCampos(int codigo) {

        ProdutoBean produtoBeans = new ProdutoBean();

        try {
            //String SQLSelection = "select * from produtos where prd_prod = ?;";
            String SQLSelection = "select \n"
                    + "p.`prd_prod`,\n"
                    + "  p.`prd_descr`,\n"
                    + "  p.`prd_id_fornec`,\n"
                    + "  p.`prd_qtd_min_estoq`,\n"
                    + "  p.`prd_stt_avisa_estoq_min`,\n"
                    + "  p.`prd_vlr_compra`,\n"
                    + "  p.`prd_tipo_prod`,\n"
                    + "  p.`prd_qtd_saldo_estoq`,\n"
                    + "  p.`prod_data_cadastro`,\n"
                    + "  p.`prod_estocavel`,"
                    + "  p.`prd_unid_med`,"
                    + "  p.`prd_acab_prima`,"
                    + "  p.`prd_prod_venda`,"
                    + "  v.`tprc_preco` \n"
                    + "from\n"
                    + "  `pizzaria`.`tab_precos_venda` v \n"
                    + "  join `produtos` p \n"
                    + "    on v.`tprc_cod_prod` = p.`prd_prod` \n"
                    + "where p.`prd_prod` = ? \n"
                    + "order by v.`tprc_vigencia` desc \n"
                    + "limit 1 ;\n"
                    + "";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {

                String SQLSelect = "select * from tipo_prod where tprd_id = '" + rs.getInt("prd_tipo_prod") + "';";
                try (PreparedStatement pstmProduto = ConectaBanco.getConnection().prepareStatement(SQLSelect)) {

                    ResultSet rsProduto = pstmProduto.executeQuery();

                    if (rsProduto.next()) {
                        TipoProdutoBean novo = new TipoProdutoBean();
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
                produtoBeans.getPrecoProduto().setPreco(rs.getDouble("tprc_preco"));
                produtoBeans.setUnidadeMedida(rs.getString("prd_unid_med"));
                produtoBeans.setProdAcabadoPrima(rs.getString("prd_acab_prima").charAt(0));
                produtoBeans.setVenda(rs.getString("prd_prod_venda").charAt(0));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return produtoBeans;
    }

    public boolean editarProduto(ProdutoBean produtoBeans) {
        try {
            String SQLUpdate = "update `pizzaria`.`produtos` set\n"
                    + "  `prd_descr` = ?,\n"
                    + "  `prd_qtd_min_estoq` = ?,\n"
                    + "  `prd_stt_avisa_estoq_min` = ?,\n"
                    + "  `prd_tipo_prod` = ?,\n"
                    + "  `prd_qtd_saldo_estoq` = ?,\n"
                    + "  `prod_data_cadastro` = ?,\n"
                    + "  `prod_estocavel` = ?,\n"
                    + "  `prd_unid_med`= ?,"
                    + "  `prd_acab_prima`= ?,"
                    + "  `prd_prod_venda`= ?"
                    + "where `prd_prod` = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            pstm.setString(1, produtoBeans.getDescricao());
            pstm.setDouble(2, produtoBeans.getQtdMinima());
            pstm.setString(3, String.valueOf(produtoBeans.getAvisaEstoqueMinimo()));
            pstm.setInt(4, produtoBeans.getTipoProduto().getCodigo());
            pstm.setDouble(5, produtoBeans.getQtdSaldoEstoque());
            pstm.setString(6, VerificarData.converteParaSql(produtoBeans.getDataCad()));
            pstm.setString(7, String.valueOf(produtoBeans.getEstocavel()));
            pstm.setString(8, String.valueOf(produtoBeans.getUnidadeMedida()));
            pstm.setString(9, String.valueOf(produtoBeans.getProdAcabadoPrima()));
            pstm.setString(10, String.valueOf(produtoBeans.getVenda()));
            pstm.setInt(11, produtoBeans.getCodigo());

            pstm.executeUpdate();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso! ", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
    }

    public void populaListaTipoProduto(List<TipoProdutoBean> lista) {
        String SQLSelection = "select \n"
                + "  `tprd_id`,\n"
                + "  `tprd_descr`,\n"
                + "  `tprd_stt_pizza` \n"
                + "from\n"
                + "  `pizzaria`.`tipo_prod` ;";

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
}
