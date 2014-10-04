
package br.com.pizzaria.controller;

import br.com.pizzaria.model.CancelamentoPedidoModel;
import javax.swing.table.DefaultTableModel;

public class CancelamentoPedidoController {

    CancelamentoPedidoModel cancelamentoPedidoModel;
    
    public CancelamentoPedidoController() {
        cancelamentoPedidoModel = new CancelamentoPedidoModel();
    }
    
    public void controlePedidoBalcao(String data, DefaultTableModel tabela){
        cancelamentoPedidoModel.listarPedidoBalcao(data, tabela);
    }
    
    public void controlePedidoEntrega(String data, DefaultTableModel tabela){
        cancelamentoPedidoModel.listarPedidoEntrega(data, tabela);
    }
    
    public void controleTodosPedidos(String data, DefaultTableModel tabela){
        cancelamentoPedidoModel.listarTodosPedidos(data, tabela);
    }
    
    public void controleItemPedido(int codigo, DefaultTableModel tabela) {
        cancelamentoPedidoModel.listarItemPedido(codigo, tabela);
    }
    
    public boolean controleCancelaPedido(int codigo) {
        return cancelamentoPedidoModel.cancelarPedido(codigo);
    }
}
