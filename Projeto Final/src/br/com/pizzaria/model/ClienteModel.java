package br.com.pizzaria.model;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteModel {

    public ClienteModel() {

    }

    public void cadastrarCliente(ClienteBeans clienteBeans) {
        try {
            String SQLInsertion = "INSERT INTO `cliente`(`cli_nome`,`cli_rua`,`cli_bairro`,"
                    + "`cli_telefone`,`cli_datacad`)"
                    + "VALUES (?,?,?,?,?);";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);
            pstm.setString(1, clienteBeans.getNome());
            pstm.setString(2, clienteBeans.getRua());
            pstm.setString(3, clienteBeans.getBairro());
            pstm.setString(4, clienteBeans.getTelefone());
            pstm.setString(5, VerificadoresECorretores.converteParaSql(clienteBeans.getDataCad()));

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public String proximoCliente() {
        try {
            String SQLSelection = "SELECT * FROM cliente order by cli_cod desc limit 1";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("cli_cod")) + 1) + "";
            } else {
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return "0";
        }
    }

    public void procuraCliente(String pesquisa, DefaultTableModel modelo) {
        try {
            String SQLSelection = "select * from cliente where cli_nome like '%" + pesquisa + "%';";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[] {rs.getString("cli_cod"), rs.getString("cli_nome"),rs.getString("cli_rua"),rs.getString("cli_bairro"),rs.getString("cli_telefone")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
