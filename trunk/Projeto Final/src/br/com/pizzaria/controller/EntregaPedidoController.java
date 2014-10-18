package br.com.pizzaria.controller;

import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.model.ClienteModel;
import br.com.pizzaria.model.EntregaPedidoModel;
import br.com.pizzaria.view.EntregaPedidoView;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class EntregaPedidoController {

    EntregaPedidoModel entregaPedidoModel;
    ClienteModel clienteModel;

    public EntregaPedidoController() {
        entregaPedidoModel = new EntregaPedidoModel();
        clienteModel = new ClienteModel();
    }

    public void controleDeItens(int pesquisa, List<ProdutoBean> listaDeItens) {
        entregaPedidoModel.pesquisaItens(pesquisa, listaDeItens);
    }

    public double controleDeValor(int codigoProduto) {
        return entregaPedidoModel.valorDoItem(codigoProduto);
    }

    public int controleDeCodigo(String codigo) {
        return entregaPedidoModel.codigoDoItem(codigo);
    }

    public boolean verificaItens(String quantidade) {


        try {
            int x = Integer.parseInt(quantidade);
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "Campo 'Quantidade' não pode ser 0!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
                return false;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Campo 'Quantidade' deve ser um número inteiro!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (quantidade.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'quantidade' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        

        return true;
    }

    public boolean conttroleDePedido(/*String codigoCliente, String codigoFuncioario, String total, int tamanhoTabela, */PedidoBean pedidobeans) {
        return entregaPedidoModel.cadastrarPedido(/*codigoCliente, codigoFuncioario, total, tamanhoTabela, */pedidobeans);
    }

    public void controlePesquisa(String pesquisa, String tipo, List<ClienteBean> lista) {
        clienteModel.procuraCliente(pesquisa, tipo, lista);
    }
    
    public void controleListaTipoProduto(List<TipoProdutoBean> lista) {
        entregaPedidoModel.populaListaTipoProduto(lista);
    }
    
    public void controleListaPizza(List<ProdutoBean> listaDePizza) {
        entregaPedidoModel.pesquisaPizza(listaDePizza);
    }
    
     public void controleListaBorda(List<ProdutoBean> listaDePizza) {
        entregaPedidoModel.pesquisaBorda(listaDePizza);
    }
    
    public int controleCodigoPedido(){
        return entregaPedidoModel.codigoDoPedido();
    }
    
    public void controleImpressaoCupom(PedidoBean pedidoBean){
        entregaPedidoModel.imprimirCupom(pedidoBean);
    }
    
    
}
