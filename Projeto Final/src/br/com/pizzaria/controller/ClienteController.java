package br.com.pizzaria.controller;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.model.ClienteModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteController {

    ClienteModel clienteModel;

    public ClienteController() {
        clienteModel = new ClienteModel();
    }

    public boolean verificarDados(ClienteBeans cliente) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo rua não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));

            return false;
        }

        if (cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo bairro não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Campo telefone não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        clienteModel.cadastrarCliente(cliente);
        return true;
    }

    public String controleDeCodigo() {
        return clienteModel.proximoCliente();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modelo){
        clienteModel.procuraCliente(pesquisa, modelo);
    }
    
    public ClienteBeans controlePreenchimento(int codigo){
        return clienteModel.preencherCampos(codigo);
    }
    
    public boolean verificarDadosParaEditar(ClienteBeans cliente) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo rua não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));

            return false;
        }

        if (cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo bairro não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Campo telefone não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        clienteModel.editarCliente(cliente);
        return true;
    }
}
