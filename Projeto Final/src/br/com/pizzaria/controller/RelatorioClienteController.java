
package br.com.pizzaria.controller;

import br.com.pizzaria.model.RelatorioClienteModel;
import javax.swing.table.DefaultTableModel;

public class RelatorioClienteController {

    RelatorioClienteModel relatorioClieteModel;
    
    public RelatorioClienteController() {
        relatorioClieteModel = new RelatorioClienteModel();
    }
    
    public void controlePeriodoCliente(){
        
    }
    
    public void controleClienteDia(String data, DefaultTableModel tabela){
        relatorioClieteModel.listarClienteDia(data, tabela);
    }
}
