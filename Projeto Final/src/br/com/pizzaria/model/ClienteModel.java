package br.com.pizzaria.model;

import br.com.pizzaria.beans.CepBeans;
import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.ConectaBancoPizzariMama;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteModel {

    public ClienteModel() {

    }

    public boolean cadastrarCliente(ClienteBeans clienteBeans) {

        String SQLInsertion = "INSERT INTO `cliente`(`cli_nome`,`cli_cep`,`cli_nro_ender`,"
                + "`cli_email`,`cli_telefone`,`cli_tel_cel`,`cli_aniversario`,`cli_datacad`,"
                + "`cli_rua`,`cli_bairro`,`cli_obs`, cli_cidade)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion)) {

            pstm.setString(1, clienteBeans.getNome());
            pstm.setString(2, clienteBeans.getCep());
            pstm.setInt(3, clienteBeans.getNumero());
            pstm.setString(4, clienteBeans.getEmail());
            pstm.setString(5, clienteBeans.getTelefone());
            pstm.setString(6, clienteBeans.getTelCelular());
            pstm.setString(7, VerificadoresECorretores.converteParaSql(clienteBeans.getAniversario()));
            pstm.setString(8, VerificadoresECorretores.converteParaSql(clienteBeans.getDataCadastro()));
            pstm.setString(9, clienteBeans.getRua());
            pstm.setString(10, clienteBeans.getBairro());
            pstm.setString(11, clienteBeans.getObservacao());
            pstm.setString(12, clienteBeans.getCidade());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar" + ex.getMessage(), "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

    }

    public String proximoCliente() {

        String SQLSelection = "SELECT * FROM cliente order by cli_cod desc limit 1";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("cli_cod")) + 1) + "";
            } else {
                String SQLResetIncrement = "alter table cliente auto_increment = 1";
                PreparedStatement pstmIncrement = ConectaBanco.getConnection().prepareStatement(SQLResetIncrement);
                pstmIncrement.execute();
                ConectaBanco.getConnection().commit();
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            return "0";
        }
    }

    public void procuraCliente(String pesquisa, DefaultTableModel modelo) {

        String SQLSelection = "select * from cliente where cli_nome like '%" + pesquisa + "%';";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();
//            if (pesquisa.equals("")) {
//                rs.next();
//            }
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("cli_cod"), rs.getString("cli_nome"), rs.getString("cli_rua"), rs.getString("cli_bairro"), rs.getString("cli_telefone")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    /**
     * Método sobrescrito para trabalhar com a pesquisa da tela de pedido do
     * cliente
     *
     * @param pesquisa o nome dos clientes para o pedido
     * @param tipo
     * @param lista para popular o comboBox da pesquisa
     */
    public void procuraCliente(String pesquisa, String tipo, List<String> lista) {
        String SQLSelection = "";
        switch (tipo) {
            case "nome":
                SQLSelection = "select * from cliente where cli_nome like '%" + pesquisa + "%';";
                break;
            case "telefone":
                SQLSelection = "select * from cliente where cli_telefone like '%" + pesquisa + "%';";
                break;
            default:
                SQLSelection = "select * from cliente where cli_rua like '%" + pesquisa + "%';";
                break;
        }
        try (PreparedStatement pstm = ConectaBancoPizzariMama.getConnection().prepareStatement(SQLSelection)) {

            ResultSet rs = pstm.executeQuery();
            if (pesquisa.equals("")) {
                rs.next();
            }
            while (rs.next()) {
                lista.add(rs.getString("cli_cod") + " - " + rs.getString("cli_nome"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public ClienteBeans preencherCampos(int codigo) {

        ClienteBeans clienteBeans = new ClienteBeans();
        String SQLSelection = "select * from cliente where cli_cod = ?;";

        try (PreparedStatement pstm = ConectaBancoPizzariMama.getConnection().prepareStatement(SQLSelection)) {
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                
                clienteBeans.setObservacao(rs.getString("cli_obs"));
                clienteBeans.setCep(rs.getString("cli_cep"));
                clienteBeans.setAniversario(VerificadoresECorretores.converteParaJAVA(rs.getString("cli_aniversario")));
                clienteBeans.setTelCelular(rs.getString("cli_tel_cel"));
                clienteBeans.setEmail(rs.getString("cli_email"));
                clienteBeans.setNumero(rs.getInt("cli_nro_ender"));
                clienteBeans.setCodigoCliente(rs.getInt("cli_cod"));
                clienteBeans.setNome(rs.getString("cli_nome"));
                clienteBeans.setRua(rs.getString("cli_rua"));
                clienteBeans.setBairro(rs.getString("cli_bairro"));
                clienteBeans.setTelefone(rs.getString("cli_telefone"));
                clienteBeans.setDataCadastro(VerificadoresECorretores.converteParaJAVA(rs.getString("cli_datacad")));
                clienteBeans.setCidade(rs.getString("cli_cidade"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return clienteBeans;
    }

    public void editarCliente(ClienteBeans clienteBeans) {

        String SQLUpdate = "update `pizzaria`.`cliente`"
                + "`cli_nome` = ?,`cli_cep` = ?,"
                + "`cli_nro_ender` = ?,`cli_email` = ?,`cli_telefone` = ?,"
                + "`cli_tel_cel` = ?,`cli_aniversario` = ?,`cli_datacad` = ?,"
                + "`cli_rua` = ?,"
                + "`cli_bairro` = ?,`cli_obs` = ?,"
                + "`cli_cidade` = ?"
                + "where `cli_cod` = ?;";
        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate)) {

            pstm.setString(1, clienteBeans.getNome());
            pstm.setString(2, clienteBeans.getCep());
            pstm.setInt(3, clienteBeans.getNumero());
            pstm.setString(4, clienteBeans.getEmail());
            pstm.setString(5, clienteBeans.getTelefone());
            pstm.setString(6, clienteBeans.getTelCelular());
            pstm.setString(7, VerificadoresECorretores.converteParaSql(clienteBeans.getAniversario()));
            pstm.setString(8, VerificadoresECorretores.converteParaSql(clienteBeans.getDataCadastro()));
            pstm.setString(9, clienteBeans.getRua());
            pstm.setString(10, clienteBeans.getBairro());
            pstm.setString(11, clienteBeans.getObservacao());
            pstm.setString(12, clienteBeans.getCidade());
            pstm.setInt(13, clienteBeans.getCodigoCliente());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar", "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public CepBeans populaCamposCep(String cep) {
        CepBeans cepBeans = new CepBeans();
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

//"select "
//  +"c.`cep_cod`,"
//  +"c.`cep_ender`,"
//  +"c.`cep_bai`,"
//  +"c.`cep_cid`,"
//  +"m.`mun_uf` "
//+"from"
//  +"`cep` c "
//  +"join municipio m "
//    +"on c.`cep_municip` = m.`mun_cod` "
//+"WHERE c.`cep_cod` = '14403351' ;"
