package br.com.pizzaria.controller;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.beans.FuncionarioBeans;
import br.com.pizzaria.model.ClienteModel;
import br.com.pizzaria.model.FuncionarioModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioController {

    FuncionarioModel funcionarioModel;

    public FuncionarioController() {
        funcionarioModel = new FuncionarioModel();
    }

    public boolean verificarDados(FuncionarioBeans funcionario, int cargo) {
        if (funcionario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cargo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cargo!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        
      
        funcionarioModel.cadastrarFuncionario(funcionario);
        return true;
    }

    public String controleDeCodigo() {
        return funcionarioModel.proximoFuncionario();
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        funcionarioModel.procuraFuncionario(pesquisa, modelo);
    }

    public FuncionarioBeans controlePreenchimento(int codigo) {
        return funcionarioModel.preencherCampos(codigo);
    }

    public boolean verificarDadosParaEditar(FuncionarioBeans funcionario, int cargo) {
        if (funcionario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cargo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cargo!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

       
      
        funcionarioModel.editarFuncionario(funcionario);
        return true;
    }
}
