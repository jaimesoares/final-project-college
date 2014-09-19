package br.com.pizzaria.controller;

import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.beans.TipoProdutoBeans;
import br.com.pizzaria.model.ProdutoModel;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoController {

    ProdutoModel produtoModel;

    public ProdutoController() {
        produtoModel = new ProdutoModel();
    }

    public String controleDeCodigo() {
        return produtoModel.proximoProduto();
    }

    public boolean verificarDados(ProdutoBeans produto, int tipo) {
        if (produto.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo descrição não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (tipo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de produto!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        return produtoModel.cadastrarProduto(produto);
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        produtoModel.procuraProduto(pesquisa, modelo);
    }

    public ProdutoBeans controlePreenchimento(int codigo) {
        return produtoModel.preencherCampos(codigo);
    }

    public boolean verificarDadosParaEditar(ProdutoBeans cardapio, int tipo) {
        if (cardapio.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo descrição não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (tipo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de produto!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        return produtoModel.editarProduto(cardapio);

    }

    public void controleListaProduto(List<TipoProdutoBeans> lista) {
        produtoModel.populaListaTipoProduto(lista);
    }
}
