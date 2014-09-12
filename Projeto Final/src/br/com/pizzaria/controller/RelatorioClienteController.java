
package br.com.pizzaria.controller;

import br.com.pizzaria.model.RelatorioClienteModel;
import javax.swing.table.DefaultTableModel;

public class RelatorioClienteController {

    RelatorioClienteModel relatorioClieteModel;
    
    public RelatorioClienteController() {
        relatorioClieteModel = new RelatorioClienteModel();
    }
    
    public void controlePeriodoCliente(String dataInicial, String dataFinal, DefaultTableModel tabela){
        relatorioClieteModel.listarCLientePeriodo(dataInicial, dataFinal, tabela);
    }
    
    public void controleClienteDia(String data, DefaultTableModel tabela){
        relatorioClieteModel.listarClienteDia(data, tabela);
    }
    
    public void controleTodosClientes(DefaultTableModel tabela){
        relatorioClieteModel.listarTodosClientes(tabela);
    }
}
