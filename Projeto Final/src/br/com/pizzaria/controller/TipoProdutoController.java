package br.com.pizzaria.controller;

import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.model.TipoProdutoModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TipoProdutoController {

    TipoProdutoModel tipoProdutoModel;

    public TipoProdutoController() {
        tipoProdutoModel = new TipoProdutoModel();
    }

    public boolean verificarDados(String descricao) {
        if (descricao.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo 'Descrição' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        tipoProdutoModel.cadastrarTipoProduto(descricao);
        return true;
    }

    public void controleListaCargo(DefaultListModel modelo) {
        tipoProdutoModel.populaListaTipoProduto(modelo);
    }

    public boolean verificarDadosParaEditar(TipoProdutoBean tipoProduto) {
        if (tipoProduto.getDescricao().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo \"Descrição\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        tipoProdutoModel.editarTipoProduto(tipoProduto);
        return true;
    }
}
