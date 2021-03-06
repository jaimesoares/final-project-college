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

    public boolean cadastrarProduto(ProdutoBean produtoBeans, String preco) {
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
                    + "             `prd_prod_venda`,"
                    + "             `prd_ingrediente`"
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
                    + "        ?,\n"
                    + "        ?);";
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
            pstm.setString(11, produtoBeans.getIngredientes());

            pstm.execute();
            
            if(!preco.isEmpty()){
                cadastrarPrecoProduto(produtoBeans.getCodigo(),Double.parseDouble(preco));
            }
            
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

            String SQLSelection = "select \n"
                    + "  `prd_prod`,\n"
                    + "  `prd_descr`,\n"
                    + "  `tprd_descr` \n"
                    + "from\n"
                    + "  `pizzaria`.`produtos` \n"
                    + "  join `tipo_prod` \n"
                    + "    on `tprd_id` = prd_tipo_prod \n"
                    + "where prd_descr like '%"+pesquisa+"%' \n"
                    + "limit 0, 1000 ;\n"
                    + "";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ProdutoBean novo = new ProdutoBean();
                novo.setDescricao(rs.getString("prd_descr"));
                novo.setCodigo(rs.getInt("prd_prod"));
                novo.getTipoProduto().setDescricao(rs.getString("tprd_descr"));
                modelo.addRow(new Object[]{rs.getString("tprd_descr"), novo});
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
    
                    + "  p.`prd_ingrediente`"
                    + "from\n"
                    + "  `pizzaria`.`produtos` p \n"
                    + "where p.`prd_prod` = ?;\n";
         
            
            
            
            
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
                
                
                String SQLSelectPreco = "select * from tab_precos_venda where tprc_cod_prod = '" + codigo + "' order by `tprc_vigencia` desc limit 1 ;";
                try (PreparedStatement pstmPreco = ConectaBanco.getConnection().prepareStatement(SQLSelectPreco)) {

                    ResultSet rsPreco = pstmPreco.executeQuery();

                    if (rsPreco.next()) {
                        produtoBeans.getPrecoProduto().setPreco(rsPreco.getDouble("tprc_preco"));
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossível Preencher Campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                }

                
                
                //JOptionPane.showMessageDialog(null,rs.getString("prd_ingrediente"));    
                produtoBeans.setDataCad(VerificarData.converteParaJAVA(rs.getString("prod_data_cadastro")));
                produtoBeans.setDescricao(rs.getString("prd_descr"));
                produtoBeans.setEstocavel(rs.getString("prod_estocavel").charAt(0));
                produtoBeans.setQtdSaldoEstoque(rs.getLong("prd_qtd_saldo_estoq"));
                produtoBeans.setAvisaEstoqueMinimo(rs.getString("prd_stt_avisa_estoq_min").charAt(0));
                produtoBeans.setQtdMinima(rs.getDouble("prd_qtd_min_estoq"));
                produtoBeans.setCodigo(rs.getInt("prd_prod"));
                
                produtoBeans.setUnidadeMedida(rs.getString("prd_unid_med"));
                produtoBeans.setProdAcabadoPrima(rs.getString("prd_acab_prima").charAt(0));
                produtoBeans.setVenda(rs.getString("prd_prod_venda").charAt(0));
                produtoBeans.setIngredientes(rs.getString("prd_ingrediente"));
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
                    + "  `prd_prod_venda`= ?,"
                    + "  `prd_ingrediente`= ?" 
                    + "where `prd_prod` =  ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            pstm.setString(1, produtoBeans.getDescricao());
            pstm.setDouble(2, produtoBeans.getQtdMinima());
            pstm.setString(3, String.valueOf(produtoBeans.getAvisaEstoqueMinimo()));          
            pstm.setString(4, String.valueOf(produtoBeans.getVenda()));
            pstm.setString(5, produtoBeans.getIngredientes());
            pstm.setInt(6, produtoBeans.getCodigo());
            pstm.executeUpdate();
            ConectaBanco.getConnection().commit();
// olha..
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
                novo.setPizza(rs.getString("tprd_stt_pizza"));
                
                lista.add(novo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Carregar Lista " + ex, "Erro de SQL ", 0, new ImageIcon("imagens/cancelar.png"));
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
            

            //JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex.getMessage(), "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }
}
