
package br.com.pizzaria.controller;

import br.com.pizzaria.model.CozinhaModel;
import javax.swing.table.DefaultTableModel;

public class CozinhaController {

    CozinhaModel cozinhaModel;
    
    public CozinhaController() {
        cozinhaModel = new CozinhaModel();
    }
    
    
    public static void controleTabela(DefaultTableModel modelo){
        CozinhaModel.populaTabela(modelo);
    }
}
