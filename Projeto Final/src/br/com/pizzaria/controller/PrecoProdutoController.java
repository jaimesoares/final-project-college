package br.com.pizzaria.controller;

import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.model.PrecoProdutoModel;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PrecoProdutoController {
    
    PrecoProdutoModel precoProdutoModel;
    
    public PrecoProdutoController() {
        precoProdutoModel = new PrecoProdutoModel();
    }
    
    public boolean verificarDados(int codigo, String precoC) {
        if (precoC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo 'Preço' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        double preco = 0;
        try {
            preco = Double.parseDouble((precoC).replace(",", "."));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Campo 'Preço' deve conter apenas números!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        
//        if(!precoProdutoModel.pesquisaPrecoData(codigo)){
//            return false;
//        }
        
        precoProdutoModel.cadastrarPrecoProduto(codigo, preco);
        return true;
    }
    
    public void controleListaProduto(List<ProdutoBean> lista, int tipoProduto) {
        precoProdutoModel.populaProduto(lista, tipoProduto);
    }
    
    public void controlePesquisaPrecoProdutos(int codigo, DefaultTableModel modelo) {
        precoProdutoModel.pesquisaPrecoProduto(codigo, modelo);
    }
    
    public boolean controlePrecoData(int codigo, String precoNovo) {
        return precoProdutoModel.pesquisaPrecoData(codigo, precoNovo);
    }
    
}
