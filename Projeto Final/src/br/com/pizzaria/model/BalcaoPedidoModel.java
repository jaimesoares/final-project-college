package br.com.pizzaria.model;

import br.com.pizzaria.beans.PedidoBeans;
import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BalcaoPedidoModel {

    public BalcaoPedidoModel() {
    }

    public void pesquisaItens(String pesquisa, List<String> listaDeItens) {
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao like '%" + pesquisa + "%';";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listaDeItens.add(rs.getString("car_descricao"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BalcaoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double valorDoItem(String pesquisa) {
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao = ?";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            pstmt.setString(1, pesquisa);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("car_valor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BalcaoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int codigoDoItem(String pesquisa) {
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao = ?";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            pstmt.setString(1, pesquisa);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("car_cod");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BalcaoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void cadastrarPedido(String total, int tamanhoTabela, PedidoBeans pedidobeans) {
        Date data = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        try {
            String SQLInserePedido = "insert into pedido(ped_cli_cod, ped_fun_cod, ped_ent_cod, ped_data, ped_hora, ped_total, ped_status)"
                    + "values (?,?,?,?,?,?,?);";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInserePedido);
            pstmt.setInt(1, pedidobeans.getCodigoCliente());
            pstmt.setInt(2, pedidobeans.getCodigoFuncionario());
            pstmt.setString(3, "0");
            pstmt.setString(4, formatoData.format(data));
            pstmt.setString(5, formatoHora.format(data));
            pstmt.setString(6, total);
            pstmt.setString(7, "Pedido aberto");

            pstmt.execute();
            cadastrarItens(codigoDoPedido(), tamanhoTabela, pedidobeans);
            //codigoDoPedido();
            ConectaBanco.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
        } catch (SQLException ex) {
            try {
                ConectaBanco.getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            } catch (SQLException ex1) {
                Logger.getLogger(BalcaoPedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    public String codigoDoPedido() {
        String codigo = "0";

        try {
            String SQLSelection = "select ped_cod from pedido order by ped_cod desc limit 1";

            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                codigo = rs.getString("ped_cod");
            }

        } catch (SQLException ex) {
            Logger.getLogger(BalcaoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showMessageDialog(null, codigo);
        return codigo;
    }
    
    public void cadastrarItens(String codigoPedido, int tamanhoTabela, PedidoBeans pedidoBeans){
        for(int i=0; i< tamanhoTabela; i++){
            try {
                String SQLInsertItens = "insert into item(item_ped_ent_cod, item_ped_fun_cod, item_ped_cli_cod, item_ped_cod, item_car_cod, item_quantidade)"
                        +"values(?,?,?,?,?,?);";
                
                PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLInsertItens);
                pstmt.setString(1, "0");
                pstmt.setInt(2, pedidoBeans.getCodigoFuncionario());
                pstmt.setInt(3, pedidoBeans.getCodigoCliente());
                pstmt.setString(4, codigoPedido);
                pstmt.setInt(5, pedidoBeans.getCodProduto(i));
                pstmt.setInt(6, pedidoBeans.getQuantidade(i));
                
                pstmt.execute();
            } catch (SQLException ex) {
                try {
                ConectaBanco.getConnection().rollback();
                JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
            } catch (SQLException ex1) {
                Logger.getLogger(BalcaoPedidoModel.class.getName()).log(Level.SEVERE, null, ex1);
            }
            }
        }
    }

}
