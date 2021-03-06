package br.com.pizzaria.controller;

import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.model.ClienteModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.com.pizzaria.bean.FornecedorBean;
import br.com.pizzaria.model.FornecedorModel;

public class FornecedorController {

    ClienteModel clienteModel;

    public FornecedorController() {
       // clienteModel = new ClienteModel();

    }

    public boolean verificarDados(ClienteBean cliente) {
        if (cliente.getNome().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getRua().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo rua não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));

            return false;
        }

        if (cliente.getBairro().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo bairro não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Campo telefone não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getNome().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        clienteModel.cadastrarCliente(cliente);
        return true;
    }

    public String controleDeCodigo() {
        return clienteModel.proximoCliente();
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {

        FornecedorModel a = new FornecedorModel();
        a.procuraFornecedor(pesquisa, modelo);
    }

    public ClienteBean controlePreenchimento(int codigo) {
        return clienteModel.preencherCampos(codigo);
    }

    public boolean verificarDadosParaEditar(FornecedorBean fornecedor) {
        if (fornecedor.getNome().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (fornecedor.getEndereco().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo rua não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));

            return false;
        }

        if (fornecedor.getBairro().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo bairro não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (fornecedor.getTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Campo telefone não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (fornecedor.getNome().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        FornecedorBean a = new FornecedorBean();
        if ((a.getEmail().isEmpty())) {
        } else 
            if ((a.getEmail().contains("@")) && (a.getEmail().contains(".")) && (!a.getEmail().contains(" "))) {
            String usuario = new String(a.getEmail().substring(0, a.getEmail().lastIndexOf('@')));
            String dominio = new String(a.getEmail().substring(a.getEmail().lastIndexOf('@') + 1, a.getEmail().length()));
            if ((usuario.length() >= 1) && (!usuario.contains("@")) && (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".") >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {

            } else {
                JOptionPane.showMessageDialog(null, "Campo 'E-MAIL' inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo 'E-MAIL' inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        //clienteModel.editarFornecedor(fornecedor);
        return true;
    }

    public boolean verificaEmail(FornecedorBean fornecedor) {
        if ((fornecedor.getEmail().isEmpty())) {
        } else if ((fornecedor.getEmail().contains("@")) && (fornecedor.getEmail().contains(".")) && (!fornecedor.getEmail().contains(" "))) {
            String usuario = new String(fornecedor.getEmail().substring(0, fornecedor.getEmail().lastIndexOf('@')));
            String dominio = new String(fornecedor.getEmail().substring(fornecedor.getEmail().lastIndexOf('@') + 1, fornecedor.getEmail().length()));
            if ((usuario.length() >= 1) && (!usuario.contains("@")) && (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".") >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {

            } else {
                JOptionPane.showMessageDialog(null, "Campo 'E-MAIL' inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo 'E-MAIL' inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        return true;
    }
}
