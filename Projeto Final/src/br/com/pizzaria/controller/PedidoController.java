package br.com.pizzaria.controller;

import br.com.pizzaria.model.PedidoModel;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author katia e Jaime
 */
public class PedidoController {

    PedidoModel pedidoModel;

    public PedidoController() {
        pedidoModel = new PedidoModel();
    }

    public void controleDeItens(String pesquisa, List<String> listaDeItens) {
        pedidoModel.pesquisaItens(pesquisa, listaDeItens);
    }

    public double controleDeValor(String valor) {
        return pedidoModel.valorDoItem(valor);
    }

    public int controleDeCodigo(String codigo) {
        return pedidoModel.codigoDoItem(codigo);
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
}
