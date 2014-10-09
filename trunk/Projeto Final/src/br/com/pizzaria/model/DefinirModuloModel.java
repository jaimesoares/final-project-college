package br.com.pizzaria.model;

import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.ModuloBean;
import br.com.pizzaria.bean.UsuarioBean;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DefinirModuloModel {

    public DefinirModuloModel() {

    }

    /**
     * Método sobrescrito para trabalhar com a pesquisa da tela de pedido do
     * cliente
     *
     * @param pesquisa o nome dos clientes para o pedido
     * @param tipo
     * @param lista para popular o comboBox da pesquisa
     */
    public void populaCliente(List<UsuarioBean> lista) {
        try {
            String SQLSelection = "select * from usuario;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                UsuarioBean usuarioBeans = new UsuarioBean();
                usuarioBeans.setCodigoFuncionario(rs.getInt("usu_fun_cod"));
                usuarioBeans.setSenha(rs.getString("usu_senha"));
                usuarioBeans.setLogin(rs.getString("usu_login"));
                lista.add(usuarioBeans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar"+ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }
    
    public void populaModulo(List<ModuloBean> modelo) {

        String SQLSelection = "select * from programas;";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                ModuloBean novo = new ModuloBean();
                novo.setCodigo(rs.getInt("pgm_id"));
                novo.setNome(rs.getString("pgm_nome"));
                novo.setTitulo(rs.getString("pgm_titulo"));
                modelo.add(novo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Carregar Lista", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public ClienteBean preencherCampos(int codigo) {

        ClienteBean clienteBeans = new ClienteBean();

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
                clienteBeans.setDataCadastro(VerificarData.converteParaJAVA(rs.getString("cli_datacad")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return clienteBeans;
    }

    public void editarCliente(ClienteBean clienteBeans) {
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
