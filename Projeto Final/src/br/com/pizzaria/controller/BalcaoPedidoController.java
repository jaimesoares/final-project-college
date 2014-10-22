package br.com.pizzaria.controller;

import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.model.BalcaoPedidoModel;
import br.com.pizzaria.model.ClienteModel;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BalcaoPedidoController {

    BalcaoPedidoModel balcaoPedidoModel;
    ClienteModel clienteModel;

    public BalcaoPedidoController() {
        balcaoPedidoModel = new BalcaoPedidoModel();
        clienteModel = new ClienteModel();
    }

   public void controleDeItens(String pesquisa, List<ProdutoBean> listaDeItens) {
        balcaoPedidoModel.pesquisaItens(pesquisa, listaDeItens);
    }

    public double controleDeValor(int codigoProduto) {
        return balcaoPedidoModel.valorDoItem(codigoProduto);
    }

    public int controleDeCodigo(String codigo) {
        return balcaoPedidoModel.codigoDoItem(codigo);
    }

    public boolean verificaItens(String valor, String quantidade, String codigo, String item) {

        if (item.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo 'item' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo 'valor' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

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

        if (quantidade.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo 'quantidade' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        

        return true;
    }

    public void conttroleDePedido(String codigoCliente, String codigoFuncioario, String total, int tamanhoTabela, PedidoBean pedidobeans) {
        balcaoPedidoModel.cadastrarPedido(codigoCliente, codigoFuncioario, total, tamanhoTabela, pedidobeans);
    }

    public void controlePesquisa(String pesquisa, String tipo, List<ClienteBean> lista) {
        clienteModel.procuraCliente(pesquisa, tipo, lista);
    }
}
