package br.com.pizzaria.model;

import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class RelatorioClienteModel {

    public RelatorioClienteModel() {
    }

    /**
     *
     * @param data
     * @param tabela
     */
    public void listarClienteDia(String data, DefaultTableModel tabela) {
        String SqlSelection = "select\n"
                + "  `cli_cod`,\n"
                + "  `cli_nome`,\n"
                + "  `cli_cep`,\n"
                + "  `cli_nro_ender`,\n"
                + "  `cli_email`,\n"
                + "  `cli_telefone`,\n"
                + "  `cli_tel_cel`,\n"
                + "  `cli_aniversario`,\n"
                + "  `cli_datacad`,\n"
                + "  `cli_dt_ult_compra`,\n"
                + "  `cli_stt_inadimp`,\n"
                + "  `cli_rua`,\n"
                + "  `cli_bairro`,\n"
                + "  `cli_obs`,\n"
                + "  `cli_cidade`\n"
                + "from `pizzaria`.`cliente`\n"
                + "where `cli_datacad`='" + VerificarData.converteParaSql(data) + "';";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getString("cli_cod"), rs.getString("cli_nome"), rs.getString("cli_rua"), rs.getString("cli_bairro"), rs.getString("cli_cidade"), rs.getString("cli_telefone"), rs.getString("cli_tel_cel"), VerificarData.converteParaJAVA(rs.getString("cli_datacad"))});
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tabela
     */
    public void listarTodosClientes(DefaultTableModel tabela) {
        String SqlSelection = "select *  from `pizzaria`.`cliente`";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getString("cli_cod"), rs.getString("cli_nome"), rs.getString("cli_rua"), rs.getString("cli_bairro"), rs.getString("cli_cidade"), rs.getString("cli_telefone"), rs.getString("cli_tel_cel"), VerificarData.converteParaJAVA(rs.getString("cli_datacad"))});
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param dataInicial
     * @param dataFinal
     * @param tabela
     */
    public void listarCLientePeriodo(String dataInicial, String dataFinal, DefaultTableModel tabela) {
        String SqlSelection = "select\n"
                + "  `cli_cod`,\n"
                + "  `cli_nome`,\n"
                + "  `cli_cep`,\n"
                + "  `cli_nro_ender`,\n"
                + "  `cli_email`,\n"
                + "  `cli_telefone`,\n"
                + "  `cli_tel_cel`,\n"
                + "  `cli_aniversario`,\n"
                + "  `cli_datacad`,\n"
                + "  `cli_dt_ult_compra`,\n"
                + "  `cli_stt_inadimp`,\n"
                + "  `cli_rua`,\n"
                + "  `cli_bairro`,\n"
                + "  `cli_obs`,\n"
                + "  `cli_cidade`\n"
                + "from `pizzaria`.`cliente`\n"
                + "WHERE  `cli_datacad`  BETWEEN '" + VerificarData.converteParaSql(dataInicial) + "' AND '" + VerificarData.converteParaSql(dataFinal) + "';";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getString("cli_cod"), rs.getString("cli_nome"), rs.getString("cli_rua"), rs.getString("cli_bairro"), rs.getString("cli_cidade"), rs.getString("cli_telefone"), rs.getString("cli_tel_cel"), VerificarData.converteParaJAVA(rs.getString("cli_datacad"))    });
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        RelatorioClienteModel novo = new RelatorioClienteModel();
        novo.listarClienteDia(null, null);
    }
}
