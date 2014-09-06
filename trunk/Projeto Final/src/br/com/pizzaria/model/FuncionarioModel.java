package br.com.pizzaria.model;

import br.com.pizzaria.beans.FuncionarioBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioModel {

    public FuncionarioModel() {

    }

    public void cadastrarFuncionario(FuncionarioBeans funcionarioBeans) {
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
                    +"`fun_rua`,`fun_cep`,`fun_bairro`, fun_cidade)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);
            pstm.setString(1, funcionarioBeans.getNome());
            pstm.setString(2, VerificadoresECorretores.converteParaSql(funcionarioBeans.getDataCad()));
            pstm.setInt(3, funcionarioBeans.getNumero());
            pstm.setString(4, funcionarioBeans.getCpf());
            pstm.setString(5, funcionarioBeans.getRg());
            pstm.setString(6, funcionarioBeans.getTelefone());
            pstm.setString(7, funcionarioBeans.getTelCelular());
            pstm.setString(8, funcionarioBeans.getEmail());
            pstm.setString(9, funcionarioBeans.getCargo());
            pstm.setDouble(10, funcionarioBeans.getSalario());
            pstm.setDouble(11, funcionarioBeans.getValeTrans());
            pstm.setDouble(12, funcionarioBeans.getValeRefeicao());
            pstm.setString(13, funcionarioBeans.getCtps());
            pstm.setInt(14, 1);
            pstm.setString(15, VerificadoresECorretores.converteParaSql(funcionarioBeans.getNascimento()));
            pstm.setString(16, funcionarioBeans.getRua());            
            pstm.setInt(17, funcionarioBeans.getCep());
            pstm.setString(18, funcionarioBeans.getBairro());
            pstm.setString(19, funcionarioBeans.getCidade());  

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
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
                modelo.addRow(new Object[]{rs.getString("fun_codigo"), rs.getString("fun_nome"), rs.getString("fun_cargo"), rs.getString("fun_permissao")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public void listaFuncionario(DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from funcionario;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("fun_codigo"), rs.getString("fun_nome")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível listar funcionário " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public FuncionarioBeans preencherCampos(int codigo) {

        FuncionarioBeans funcionarioBeans = new FuncionarioBeans();

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
                funcionarioBeans.setNascimento(VerificadoresECorretores.converteParaJAVA(rs.getString("fun_nascimento")));
                funcionarioBeans.setRua(rs.getString("fun_rua"));
                funcionarioBeans.setNumero(rs.getInt("fun_nro_ender"));
                funcionarioBeans.setCep(rs.getInt("fun_cep"));
                funcionarioBeans.setBairro(rs.getString("fun_bairro"));
                funcionarioBeans.setCidade(rs.getString("fun_cidade"));
                funcionarioBeans.setCpf(rs.getString("fun_cpf"));
                funcionarioBeans.setRg(rs.getString("fun_rg"));
                funcionarioBeans.setCargo(rs.getString("fun_cargo"));
                funcionarioBeans.setCtps(rs.getString("fun_ctps"));
                funcionarioBeans.setSalario(rs.getDouble("fun_salario"));
                funcionarioBeans.setValeRefeicao(rs.getDouble("fun_vale_refeicao"));
                funcionarioBeans.setValeTrans(rs.getDouble("fun_vale_transp"));
                funcionarioBeans.setEmail(rs.getString("fun_email"));
                funcionarioBeans.setDataCad(VerificadoresECorretores.converteParaJAVA(rs.getString("fun_dt_admis")));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return funcionarioBeans;
    }

    public void editarFuncionario(FuncionarioBeans funcionarioBeans) {
        try {
            String SQLUpdate = "UPDATE `funcionario` SET "
                    
                    + "(`fun_nome`=?,"
                    + "`fun_dt_admis`=?,"
                    + "`fun_nro_ender`=?,`fun_cpf`=?,"
                    + "`fun_rg`=?,`fun_tel`=?,"
                    + "`tel_cel`=?,`fun_email`=?,"
                    + "`fun_cargo`=?,`fun_salario`=?,"
                    + "`fun_vale_transp`=?,`fun_vale_refeicao`=?,"
                    + "`fun_ctps`=?,`fun_id_empresa`=?,"
                    + "`fun_nascimento`=?,"
                    +"`fun_rua`=?,`fun_cep`=?,`fun_bairro`=?, fun_cidade=?)"
                    
                    + "WHERE `fun_codigo` = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            
            pstm.setString(1, funcionarioBeans.getNome());
            pstm.setString(2, VerificadoresECorretores.converteParaSql(funcionarioBeans.getDataCad()));
            pstm.setInt(3, funcionarioBeans.getNumero());
            pstm.setString(4, funcionarioBeans.getCpf());
            pstm.setString(5, funcionarioBeans.getRg());
            pstm.setString(6, funcionarioBeans.getTelefone());
            pstm.setString(7, funcionarioBeans.getTelCelular());
            pstm.setString(8, funcionarioBeans.getEmail());
            pstm.setString(9, funcionarioBeans.getCargo());
            pstm.setDouble(10, funcionarioBeans.getSalario());
            pstm.setDouble(11, funcionarioBeans.getValeTrans());
            pstm.setDouble(12, funcionarioBeans.getValeRefeicao());
            pstm.setString(13, funcionarioBeans.getCtps());
            pstm.setInt(14, 1);
            pstm.setString(15, VerificadoresECorretores.converteParaSql(funcionarioBeans.getNascimento()));
            pstm.setString(16, funcionarioBeans.getRua());            
            pstm.setInt(17, funcionarioBeans.getCep());
            pstm.setString(18, funcionarioBeans.getBairro());
            pstm.setString(19, funcionarioBeans.getCidade());
            pstm.setInt(20, funcionarioBeans.getCodigo());
            
            
            
            
           

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
