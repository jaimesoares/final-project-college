package br.com.pizzaria.controller;

import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.EntregadorBean;
import br.com.pizzaria.bean.FuncionarioBean;
import br.com.pizzaria.model.ClienteModel;
import br.com.pizzaria.model.EntregadorModel;
import br.com.pizzaria.model.FuncionarioModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EntregadorController {

   EntregadorModel entregadorModel;

    public EntregadorController() {
        entregadorModel = new EntregadorModel();
    }

    public boolean verificarDados(EntregadorBean entregador) {
        if (entregador.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
      
        entregadorModel.cadastrarEntregador(entregador);
        return true;
    }

    public String controleDeCodigo() {
        return entregadorModel.proximoEntrgador();
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        entregadorModel.procuraEntregador(pesquisa, modelo);
    }

    public EntregadorBean controlePreenchimento(int codigo) {
        return entregadorModel.preencherCampos(codigo);
    }

    public boolean verificarDadosParaEditar(EntregadorBean entregador) {
        if (entregador.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        entregadorModel.editarEntregador(entregador);
        return true;
    }
}
