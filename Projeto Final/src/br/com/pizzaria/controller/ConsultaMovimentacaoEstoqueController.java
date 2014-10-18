
package br.com.pizzaria.controller;

import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.model.ConsultaMovimmentoEstoqueModel;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ConsultaMovimentacaoEstoqueController {

    ConsultaMovimmentoEstoqueModel movimentoEstoqueModel;
    
    public ConsultaMovimentacaoEstoqueController() {
        movimentoEstoqueModel = new ConsultaMovimmentoEstoqueModel();
    }
    
    public void controlePeriodoCliente(String dataInicial, String dataFinal, DefaultTableModel tabela){
        movimentoEstoqueModel.listarCLientePeriodo(dataInicial, dataFinal, tabela);
    }
    
    public void controleClienteDia(String data, DefaultTableModel tabela){
        movimentoEstoqueModel.listarClienteDia(data, tabela);
    }
    
    public void controleTodosClientes(DefaultTableModel tabela){
        movimentoEstoqueModel.listarTodosClientes(tabela);
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
