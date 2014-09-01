package br.com.pizzaria.controller;

import br.com.pizzaria.beans.PedidoBeans;
import br.com.pizzaria.model.ClienteModel;
import br.com.pizzaria.model.EntregaPedidoModel;
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

    public void controleDeItens(String pesquisa, List<String> listaDeItens) {
        entregaPedidoModel.pesquisaItens(pesquisa, listaDeItens);
    }

    public double controleDeValor(String valor) {
        return entregaPedidoModel.valorDoItem(valor);
    }

    public int controleDeCodigo(String codigo) {
        return entregaPedidoModel.codigoDoItem(codigo);
    }

    public boolean verificaItens(String valor, String quantidade, String codigo, String item) {

        if (item.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'item' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (valor.equals("")) {
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

        if (quantidade.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'quantidade' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (codigo.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'código' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        return true;
    }

    public void conttroleDePedido(String codigoCliente, String codigoFuncioario, String total, int tamanhoTabela, PedidoBeans pedidobeans) {
        entregaPedidoModel.cadastrarPedido(codigoCliente, codigoFuncioario, total, tamanhoTabela, pedidobeans);
    }

    public void controlePesquisa(String pesquisa, String tipo, List<String> lista) {
        clienteModel.procuraCliente(pesquisa, tipo, lista);
    }
}
