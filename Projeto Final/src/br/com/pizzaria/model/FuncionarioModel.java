package br.com.pizzaria.model;

import br.com.pizzaria.bean.CargoBean;
import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.FuncionarioBean;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.ConectaBancoCorreios;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioModel {

    public FuncionarioModel() {

    }

    public boolean cadastrarFuncionario(FuncionarioBean funcionarioBeans) {
        try {
            String SQLInsertion = "insert into `pizzaria`.`funcionario`"
                    + "(`fun_nome`,"
                    + "`fun_dt_admis`,"
                    + "`fun_nro_ender`,`fun_cpf`,"
                    + "`fun_rg`,`fun_tel`,"
                    + "`tel_cel`,`fun_email`,"
                    + "`fun_cargo`,`fun_salario`,"
                    + "`fun_vale_transp`,`fun_vale_refeicao`,"
                    + "`fun_ctps`,`fun_id_empresa`,"
                    + "`fun_nascimento`,"
                    + "`fun_rua`,`fun_cep`,`fun_bairro`, fun_cidade, fun_moto, fun_placa_moto, fun_cnh)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);
            pstm.setString(1, funcionarioBeans.getNome());
            pstm.setString(2, VerificarData.converteParaSql(funcionarioBeans.getDataCad()));
            pstm.setInt(3, funcionarioBeans.getNumero());
            pstm.setString(4, funcionarioBeans.getCpf());
            pstm.setString(5, funcionarioBeans.getRg());
            pstm.setString(6, funcionarioBeans.getTelefone());
            pstm.setString(7, funcionarioBeans.getTelCelular());
            pstm.setString(8, funcionarioBeans.getEmail());
            pstm.setInt(9, funcionarioBeans.getCargo().getCodigo());
            pstm.setDouble(10, funcionarioBeans.getSalario());
            pstm.setDouble(11, funcionarioBeans.getValeTrans());
            pstm.setDouble(12, funcionarioBeans.getValeRefeicao());
            pstm.setString(13, funcionarioBeans.getEstado());
            pstm.setInt(14, 1);
            pstm.setString(15, VerificarData.converteParaSql(funcionarioBeans.getNascimento()));
            pstm.setString(16, funcionarioBeans.getRua());
            pstm.setString(17, funcionarioBeans.getCep());
            pstm.setString(18, funcionarioBeans.getBairro());
            pstm.setString(19, funcionarioBeans.getCidade());
            pstm.setString(20, funcionarioBeans.getMoto());
            pstm.setString(21, funcionarioBeans.getPlacaMoto());
            pstm.setString(22, funcionarioBeans.getCnh());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

    }

    public String proximoFuncionario() {
        try {
            String SQLSelection = "SELECT * FROM funcionario order by fun_codigo desc limit 1";

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

    public void procuraFuncionario(String pesquisa, DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from funcionario where fun_nome like '%" + pesquisa + "%';";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                FuncionarioBean funcionarioBeans = new FuncionarioBean();
                funcionarioBeans.setCodigo(rs.getInt("fun_codigo"));
                funcionarioBeans.setNome(rs.getString("fun_nome"));
                funcionarioBeans.setTelefone(rs.getString("fun_tel"));
                funcionarioBeans.setTelCelular(rs.getString("tel_cel"));
                funcionarioBeans.setNascimento(VerificarData.converteParaJAVA(rs.getString("fun_nascimento")));
                funcionarioBeans.setRua(rs.getString("fun_rua"));
                funcionarioBeans.setNumero(rs.getInt("fun_nro_ender"));
                funcionarioBeans.setCep(rs.getString("fun_cep"));
                funcionarioBeans.setBairro(rs.getString("fun_bairro"));
                funcionarioBeans.setCidade(rs.getString("fun_cidade"));
                funcionarioBeans.setCpf(rs.getString("fun_cpf"));
                funcionarioBeans.setRg(rs.getString("fun_rg"));
                funcionarioBeans.setMoto(rs.getString("fun_moto"));
                funcionarioBeans.setPlacaMoto(rs.getString("fun_placa_moto"));
                funcionarioBeans.setCnh(rs.getString("fun_cnh"));

                String SQLSelect = "select * from cargo where crg_id_cargo = '" + rs.getInt("fun_cargo") + "';";

                try (PreparedStatement pstmCargo = ConectaBanco.getConnection().prepareStatement(SQLSelect)) {

                    ResultSet rsCargo = pstmCargo.executeQuery();

                    if (rsCargo.next()) {
                        CargoBean novo = new CargoBean();
                        novo.setCodigo(rsCargo.getInt("crg_id_cargo"));
                        novo.setDescricao(rsCargo.getString("crg_descr"));
                        funcionarioBeans.setCargo(novo);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossível Preencher Campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                }

                funcionarioBeans.setEstado(rs.getString("fun_ctps"));
                funcionarioBeans.setSalario(rs.getDouble("fun_salario"));
                funcionarioBeans.setValeRefeicao(rs.getDouble("fun_vale_refeicao"));
                funcionarioBeans.setValeTrans(rs.getDouble("fun_vale_transp"));
                funcionarioBeans.setEmail(rs.getString("fun_email"));
                funcionarioBeans.setDataCad(VerificarData.converteParaJAVA(rs.getString("fun_dt_admis")));
                modelo.addRow(new Object[]{funcionarioBeans,funcionarioBeans.getTelefone(), funcionarioBeans.getCargo().getDescricao()});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void listaFuncionario(DefaultTableModel modelo) {
        try {
            String SQLSelection = "SELECT \n"
                    + "  f.`fun_codigo`,\n"
                    + "  f.`fun_nome`,\n"
                    + "  c.`crg_descr` \n"
                    + "FROM\n"
                    + "  `funcionario` f \n"
                    + "  JOIN `cargo` c \n"
                    + "    ON c.`crg_id_cargo` = f.`fun_cargo` ;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                FuncionarioBean novo = new FuncionarioBean();
                novo.setCodigo(rs.getInt("fun_codigo"));

                novo.setNome(rs.getString("fun_nome"));
                novo.getCargo().setDescricao(rs.getString("crg_descr"));
                modelo.addRow(new Object[]{novo, rs.getString("crg_descr")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível listar funcionário " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public FuncionarioBean preencherCampos(int codigo) {

        FuncionarioBean funcionarioBeans = new FuncionarioBean();

        try {
            String SQLSelection = "select * from funcionario where fun_codigo = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                funcionarioBeans.setCodigo(rs.getInt("fun_codigo"));
                funcionarioBeans.setNome(rs.getString("fun_nome"));
                funcionarioBeans.setTelefone(rs.getString("fun_tel"));
                funcionarioBeans.setTelCelular(rs.getString("tel_cel"));
                funcionarioBeans.setNascimento(VerificarData.converteParaJAVA(rs.getString("fun_nascimento")));
                funcionarioBeans.setRua(rs.getString("fun_rua"));
                funcionarioBeans.setNumero(rs.getInt("fun_nro_ender"));
                funcionarioBeans.setCep(rs.getString("fun_cep"));
                funcionarioBeans.setBairro(rs.getString("fun_bairro"));
                funcionarioBeans.setCidade(rs.getString("fun_cidade"));
                funcionarioBeans.setCpf(rs.getString("fun_cpf"));
                funcionarioBeans.setRg(rs.getString("fun_rg"));
                funcionarioBeans.setMoto(rs.getString("fun_moto"));
                funcionarioBeans.setPlacaMoto(rs.getString("fun_placa_moto"));
                funcionarioBeans.setCnh(rs.getString("fun_cnh"));

                String SQLSelect = "select * from cargo where crg_id_cargo = '" + rs.getInt("fun_cargo") + "';";

                try (PreparedStatement pstmCargo = ConectaBanco.getConnection().prepareStatement(SQLSelect)) {

                    ResultSet rsCargo = pstmCargo.executeQuery();

                    if (rsCargo.next()) {
                        CargoBean novo = new CargoBean();
                        novo.setCodigo(rsCargo.getInt("crg_id_cargo"));
                        novo.setDescricao(rsCargo.getString("crg_descr"));
                        funcionarioBeans.setCargo(novo);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossível Preencher Campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                }

                funcionarioBeans.setEstado(rs.getString("fun_ctps"));
                funcionarioBeans.setSalario(rs.getDouble("fun_salario"));
                funcionarioBeans.setValeRefeicao(rs.getDouble("fun_vale_refeicao"));
                funcionarioBeans.setValeTrans(rs.getDouble("fun_vale_transp"));
                funcionarioBeans.setEmail(rs.getString("fun_email"));
                funcionarioBeans.setDataCad(VerificarData.converteParaJAVA(rs.getString("fun_dt_admis")));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return funcionarioBeans;
    }

    public boolean editarFuncionario(FuncionarioBean funcionarioBeans) {
        try {
            String SQLUpdate = "update `pizzaria`.`funcionario`\n"
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

            pstm.setString(1, funcionarioBeans.getNome());
            pstm.setInt(2, funcionarioBeans.getNumero());
            pstm.setString(3, funcionarioBeans.getCpf());
            pstm.setString(4, funcionarioBeans.getRg());
            pstm.setString(5, funcionarioBeans.getTelefone());
            pstm.setString(6, funcionarioBeans.getTelCelular());
            pstm.setString(7, funcionarioBeans.getEmail());
            pstm.setInt(8, funcionarioBeans.getCargo().getCodigo());
            pstm.setInt(9, 1);
            pstm.setString(10, VerificarData.converteParaSql(funcionarioBeans.getNascimento()));
            pstm.setString(11, funcionarioBeans.getRua());
            pstm.setString(12, funcionarioBeans.getCep());
            pstm.setString(13, funcionarioBeans.getBairro());
            pstm.setString(14, funcionarioBeans.getEstado());
            pstm.setString(15, funcionarioBeans.getCidade());
            pstm.setString(16, funcionarioBeans.getMoto());
            pstm.setString(17, funcionarioBeans.getPlacaMoto());
            pstm.setString(18, funcionarioBeans.getCnh());
            pstm.setInt(19, funcionarioBeans.getCodigo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
    }

    public void populaListaCargo(List<CargoBean> lista) {

        String SQLSelection = "select * from cargo;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                CargoBean novo = new CargoBean();
                novo.setCodigo(rs.getInt("crg_id_cargo"));
                novo.setDescricao(rs.getString("crg_descr"));
                lista.add(novo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Carregar Lista " + ex, "Erro de SQL ", 0, new ImageIcon("imagens/cancelar.png"));
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

        // try (PreparedStatement pstm = ConectaBancoCorreios.getConnection().prepareStatement(SQLSelection)) {
        try (PreparedStatement pstm = ConectaBancoCorreios.getConnection().prepareStatement(SQLSelection)) {
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
