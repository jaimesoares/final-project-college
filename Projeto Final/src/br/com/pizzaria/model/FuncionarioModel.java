package br.com.pizzaria.model;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.beans.FuncionarioBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioModel {

    public FuncionarioModel() {

    }

    public void cadastrarFuncionario(FuncionarioBeans funcionarioBeans) {
        try {
            String SQLInsertion = "INSERT INTO `funcionario`(`fun_nome`,`fun_cargo`,`fun_permissao`,"
                    + "`fun_datacad`)"
                    + "VALUES (?,?,?,?);";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);
            pstm.setString(1, funcionarioBeans.getNome());
            pstm.setString(2, funcionarioBeans.getCargo());
            pstm.setString(3, funcionarioBeans.getPermissao());
            pstm.setString(4, VerificadoresECorretores.converteParaSql(funcionarioBeans.getDataCad()));

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
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
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
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
            JOptionPane.showMessageDialog(null, "Impossível listar funcionário "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
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
                funcionarioBeans.setCargo(rs.getString("fun_cargo"));
                funcionarioBeans.setPermissao(rs.getString("fun_permissao"));
                funcionarioBeans.setDataCad(VerificadoresECorretores.converteParaJAVA(rs.getString("fun_datacad")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return funcionarioBeans;
    }

    public void editarFuncionario(FuncionarioBeans funcionarioBeans) {
        try {
            String SQLUpdate = "UPDATE `funcionario` SET `fun_nome` = ?,`fun_cargo` = ?,"
                    + "`fun_permissao` = ?"
                    + "WHERE `fun_codigo` = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            pstm.setString(1, funcionarioBeans.getNome());
            pstm.setString(2, funcionarioBeans.getCargo());
            pstm.setString(3, funcionarioBeans.getPermissao());
            pstm.setInt(4, funcionarioBeans.getCodigo());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar "+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
