
package br.com.pizzaria.controller;

import br.com.pizzaria.bean.AjusteEstoqueBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.model.AjusteEstoqueModel;
import br.com.pizzaria.model.AtualizaMovimentoEstoqueModel;
import br.com.pizzaria.model.ConsultaMovEstoqueModel;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AjusteEstoqueController {

    AjusteEstoqueModel ajusteEstoqueModel;
    
    public AjusteEstoqueController() {
        ajusteEstoqueModel = new AjusteEstoqueModel();
    }
    
    
    
    public void controleDeItens(int pesquisa, List<ProdutoBean> listaDeItens) {
        ajusteEstoqueModel.pesquisaProdutos(pesquisa, listaDeItens);
    }
    
     public void controleListaTipoProduto(List<TipoProdutoBean> lista) {
        ajusteEstoqueModel.populaListaTipoProduto(lista);
    }
     
     public void controleListaData(int codigo, List<String> lista) {
         ajusteEstoqueModel.populaListaData(codigo, lista );
     }
     
     public void controleTabelaMovimentoEstoque(String data, int codigo, DefaultTableModel tabela, JTextField anterior, JTextField atual) {
         ajusteEstoqueModel.listarTabelaMovimentoEstoque(data, codigo, tabela, anterior, atual);
     }
     
     public long controleQuantidadeAtual(int codigoProduto) {
        return ajusteEstoqueModel.pesquisaQuantidadeAtual(codigoProduto);
     }
     
     public boolean controleMovimentoEstoque(AjusteEstoqueBean ajusteEstoque) {
         return ajusteEstoqueModel.atualizaMovimentoEstoque(ajusteEstoque);
     }
}
