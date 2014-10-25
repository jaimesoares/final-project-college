package br.com.pizzaria.model;

import br.com.pizzaria.bean.CargoBean;
import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.pizzaria.bean.FornecedorBean;

public class FornecedorModel {

    public FornecedorModel() {

    }

    public boolean cadastrarFornecedor(FornecedorBean fornecedorBeans) {

        return false;
    }

    public String proximoFornecedor() {
        try {
            String SQLSelection = "SELECT * FROM fornecedor order by fun_codigo desc limit 1";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("fun_codigo")) + 1) + "";
            } else {
                String SQLResetIncrement = "alter table funcionario auto_increment = 1";
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

    public void procuraFornecedor(String pesquisa, DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from fornecedor where fun_nome like '%" + pesquisa + "%';";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("fun_codigo"), rs.getString("fun_nome"), rs.getString("fun_cargo"), rs.getString("fun_permissao")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void listaFornecedor(DefaultTableModel modelo) {
        try {
            String SQLSelection = "SELECT\n"
                    + "  `for_id_fornec`,\n"
                    + "  `for_nome`,\n"
                    + "  `for_cod_pfj`,\n"
                    + "  `for_contato`,\n"
                    
                    + "FROM `pizzaria`.`fornecedor`\n";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                FornecedorBean novo = new FornecedorBean();

                novo.setCodigo(rs.getInt("fun_codigo"));

                novo.setNome(rs.getString("for_nome"));
                novo.setEndereco(rs.getString("for_cod_pfj"));
                modelo.addRow(new Object[]{novo, rs.getString("for_contato")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível listar o fornecedor " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public FornecedorBean preencherCampos(int codigo) {

        FornecedorBean fornecedorBeans = new FornecedorBean();

        try {
            String SQLSelection = "select * from fornecedor where fun_codigo = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                fornecedorBeans.setCodigo(rs.getInt("fun_codigo"));
                fornecedorBeans.setNome(rs.getString("fun_nome"));
                fornecedorBeans.setTelefone(rs.getString("fun_tel"));
                fornecedorBeans.setTelCelular(rs.getString("tel_cel"));

                fornecedorBeans.setEndereco(rs.getString("fun_rua"));
                //      fornecedorBeans.setNumero(rs.getInt("fun_nro_ender"));
                //    fornecedorBeans.setCep(rs.getString("fun_cep"));
                fornecedorBeans.setBairro(rs.getString("fun_bairro"));
                fornecedorBeans.setCidade(rs.getString("fun_cidade"));
                //  fornecedorBeans.setCpf(rs.getString("fun_cpf"));
                //fornecedorBeans.setRg(rs.getString("fun_rg"));
                // fornecedorBeans.setMoto(rs.getString("fun_moto"));
                // fornecedorBeans.setPlacaMoto(rs.getString("fun_placa_moto"));
                // fornecedorBeans.setCnh(rs.getString("fun_cnh"));

                String SQLSelect = "select * from cargo where crg_id_cargo = '" + rs.getInt("fun_cargo") + "';";

                try (PreparedStatement pstmCargo = ConectaBanco.getConnection().prepareStatement(SQLSelect)) {

                    ResultSet rsCargo = pstmCargo.executeQuery();

                    if (rsCargo.next()) {
                        CargoBean novo = new CargoBean();
                        novo.setCodigo(rsCargo.getInt("crg_id_cargo"));
                        novo.setDescricao(rsCargo.getString("crg_descr"));

                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossível Preencher Campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                }

                fornecedorBeans.setEmail(rs.getString("fun_email"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return fornecedorBeans;
    }

    public boolean editarFornecedor(FornecedorBean fornecedorBeans) {
        try {
            String SQLUpdate = "update `pizzaria`.`fornecedor`\n"
                    + "set `fun_nome` = ?,\n"
                    + "  `fun_nro_ender` = ?,\n"
                    + "  `fun_cpf` = ?,\n"
                    + "  `fun_rg` = ?,\n"
                    + "  `fun_tel` = ?,\n"
                    + "  `tel_cel` = ?,\n"
                    + "  `fun_email` = ?,\n"
                    + "  `fun_cargo` = ?,\n"
                    + "  `fun_id_empresa` = ?,\n"
                    + "  `fun_nascimento` = ?,\n"
                    + "  `fun_rua` = ?,\n"
                    + "  `fun_cep` = ?,\n"
                    + "  `fun_bairro` = ?,\n"
                    + "  `fun_estado` = ?,\n"
                    + "  `fun_cidade` = ?,\n"
                    + "  `fun_moto` = ?,\n"
                    + "  `fun_placa_moto` = ?,\n"
                    + "  `fun_cnh` = ?\n"
                    + "where `fun_codigo` = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);

            pstm.setString(1, fornecedorBeans.getNome());
            pstm.setInt(2, fornecedorBeans.getNumero());

            pstm.setString(5, fornecedorBeans.getTelefone());
            pstm.setString(6, fornecedorBeans.getTelCelular());
            pstm.setString(7, fornecedorBeans.getEmail());

            pstm.setString(11, fornecedorBeans.getEndereco());

            pstm.setString(13, fornecedorBeans.getBairro());

            pstm.setString(15, fornecedorBeans.getCidade());

            pstm.setInt(19, fornecedorBeans.getCodigo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
    }

    public CepBean populaCamposCep(String cep) {
        CepBean cepBeans = new CepBean();
        String SQLSelection = "select "
                + "c.`cep_cod`,"
                + "c.`cep_ender`,"
                + "c.`cep_bai`,"
                + "c.`cep_cid`,"
                + "m.`mun_uf` "
                + "from"
                + "`cep` c "
                + "join municipio m "
                + "on c.`cep_municip` = m.`mun_cod` "
                + "WHERE c.`cep_cod` = ? ;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {
            pstm.setString(1, cep);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                cepBeans.setBairro(rs.getString("cep_bai"));
                cepBeans.setCep(rs.getString("cep_cod"));
                cepBeans.setCidade(rs.getString("cep_cid"));
                cepBeans.setEndereco(rs.getString("cep_ender"));
                cepBeans.setEstado(rs.getString("mun_uf"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return cepBeans;
    }
}
