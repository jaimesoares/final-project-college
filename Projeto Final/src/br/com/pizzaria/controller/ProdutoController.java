package br.com.pizzaria.controller;

import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
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

    public boolean verificarDados(ProdutoBean produto, int tipo) {
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

    public ProdutoBean controlePreenchimento(int codigo) {
        return produtoModel.preencherCampos(codigo);
    }

    public boolean verificarDadosParaEditar(ProdutoBean cardapio, int tipo, String descricao) {
        if (descricao.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo descrição não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (tipo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um tipo de produto!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        
        cardapio.getTipoProduto().setCodigo(tipo);
        cardapio.setDescricao(descricao);
        return produtoModel.editarProduto(cardapio);

    }

    public void controleListaProduto(List<TipoProdutoBean> lista) {
        produtoModel.populaListaTipoProduto(lista);
    }
}
