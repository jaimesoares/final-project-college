
package br.com.pizzaria.controller;

import br.com.pizzaria.bean.AjusteEstoqueBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.RequisicaoMercadoriaBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.model.RequisicaoMercadoriaModel;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class RequisicaoMercadoriaController {

    RequisicaoMercadoriaModel requisicaoMercadoriaModel;
    
    public RequisicaoMercadoriaController() {
        requisicaoMercadoriaModel = new RequisicaoMercadoriaModel();
    }
    
    
    
    public void controleDeItens(int pesquisa, List<ProdutoBean> listaDeItens) {
        requisicaoMercadoriaModel.pesquisaProdutos(pesquisa, listaDeItens);
    }
    
     public void controleListaTipoProduto(List<TipoProdutoBean> lista) {
        requisicaoMercadoriaModel.populaListaTipoProduto(lista);
    }
     
     public void controleListaData(int codigo, List<String> lista) {
         requisicaoMercadoriaModel.populaListaData(codigo, lista );
     }
     
     public void controleTabelaMovimentoEstoque(String data, int codigo, DefaultTableModel tabela, JTextField anterior, JTextField atual) {
         requisicaoMercadoriaModel.listarTabelaMovimentoEstoque(data, codigo, tabela, anterior, atual);
     }
     
     public long controleQuantidadeAtual(int codigoProduto) {
        return requisicaoMercadoriaModel.pesquisaQuantidadeAtual(codigoProduto);
     }
     
     public boolean controleAjusteEstoque(RequisicaoMercadoriaBean requisicaoMercadoria) {
         return requisicaoMercadoriaModel.ajusteEstoque(requisicaoMercadoria);
     }
}
