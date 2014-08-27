package br.com.pizzaria.controller;

import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.beans.FuncionarioBeans;
import br.com.pizzaria.model.ProdutoModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoController {
    
    ProdutoModel cardapioModel;
    
    public ProdutoController(){
        cardapioModel = new ProdutoModel();
    }
    
    public String controleDeCodigo() {
        return cardapioModel.proximoCardapio();
    }
    
    public boolean verificarDados(ProdutoBeans cardapio, String valor) {
        if (cardapio.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo descrição não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (valor.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo valor não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

            cardapioModel.cadastrarCardapio(cardapio);
        return true;
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        cardapioModel.procuraCardapio(pesquisa, modelo);
    }
    
    public ProdutoBeans controlePreenchimento(int codigo) {
        return cardapioModel.preencherCampos(codigo);
    }
    
    public boolean verificarDadosParaEditar(ProdutoBeans cardapio, String valor) {
        if (cardapio.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo descrição não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (valor.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo valor não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

            cardapioModel.editarCardapio(cardapio);
        return true;
    }
}
