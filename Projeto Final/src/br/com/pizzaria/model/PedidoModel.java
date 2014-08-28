
package br.com.pizzaria.model;

import br.com.pizzaria.util.ConectaBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoModel {

    public PedidoModel() {
    }
   
    public void pesquisaItens(String pesquisa, List<String> listaDeItens){
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao like '%"+pesquisa+"%';";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                listaDeItens.add(rs.getString("car_descricao"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double valorDoItem(String pesquisa){
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao = ?";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            pstmt.setString(1, pesquisa);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getDouble("car_valor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int codigoDoItem(String pesquisa){
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao = ?";
            PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SQLPesquisa);
            pstmt.setString(1, pesquisa);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt("car_cod");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
