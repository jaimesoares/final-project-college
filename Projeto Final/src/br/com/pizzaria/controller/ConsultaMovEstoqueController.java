
package br.com.pizzaria.controller;

import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.model.ConsultaMovEstoqueModel;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ConsultaMovEstoqueController {

    ConsultaMovEstoqueModel movimentoEstoqueModel;
    
    public ConsultaMovEstoqueController() {
        movimentoEstoqueModel = new ConsultaMovEstoqueModel();
    }
    
    public void controleDeItens(int pesquisa, List<ProdutoBean> listaDeItens) {
        movimentoEstoqueModel.pesquisaItens(pesquisa, listaDeItens);
    }
    
     public void controleListaTipoProduto(List<TipoProdutoBean> lista) {
        movimentoEstoqueModel.populaListaTipoProduto(lista);
    }
     
     public void controleListaData(int codigo, List<String> lista) {
         movimentoEstoqueModel.populaListaData(codigo, lista );
     }
     
     public void controleTabelaMovimentoEstoque(String data, int codigo, DefaultTableModel tabela, JTextField anterior, JTextField atual) {
         movimentoEstoqueModel.listarTabelaMovimentoEstoque(data, codigo, tabela, anterior, atual);
     }
}
