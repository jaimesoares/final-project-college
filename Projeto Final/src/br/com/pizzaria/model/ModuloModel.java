package br.com.pizzaria.model;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.beans.UsuarioBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ModuloModel {

    public ModuloModel() {

    }

    /**
     * Método sobrescrito para trabalhar com a pesquisa da tela de pedido do
     * cliente
     *
     * @param pesquisa o nome dos clientes para o pedido
     * @param tipo
     * @param lista para popular o comboBox da pesquisa
     */
    public void procuraCliente(List<UsuarioBeans> lista) {
        try {
            String SQLSelection = "select * from usuario;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                UsuarioBeans usuarioBeans = new UsuarioBeans();
                usuarioBeans.setCodigoFuncionario(rs.getInt("usu_fun_cod"));
                usuarioBeans.setSenha(rs.getString("usu_senha"));
                usuarioBeans.setLogin(rs.getString("usu_login"));
                lista.add(usuarioBeans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar"+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public ClienteBeans preencherCampos(int codigo) {

        ClienteBeans clienteBeans = new ClienteBeans();

        try {
            String SQLSelection = "select * from cliente where cli_cod = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                clienteBeans.setCodigoCliente(rs.getInt("cli_cod"));
                clienteBeans.setNome(rs.getString("cli_nome"));
                clienteBeans.setRua(rs.getString("cli_rua"));
                clienteBeans.setBairro(rs.getString("cli_bairro"));
                clienteBeans.setTelefone(rs.getString("cli_telefone"));
                clienteBeans.setDataCadastro(VerificadoresECorretores.converteParaJAVA(rs.getString("cli_datacad")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return clienteBeans;
    }

    public void editarCliente(ClienteBeans clienteBeans) {
        try {
            String SQLUpdate = "UPDATE `cliente` SET `cli_nome` = ?,`cli_rua` = ?,"
                    + "`cli_bairro` = ?,`cli_telefone` = ?"
                    + "WHERE `cli_cod` = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
            pstm.setString(1, clienteBeans.getNome());
            pstm.setString(2, clienteBeans.getRua());
            pstm.setString(3, clienteBeans.getBairro());
            pstm.setString(4, clienteBeans.getTelefone());
            pstm.setInt(5, clienteBeans.getCodigoCliente());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
}
