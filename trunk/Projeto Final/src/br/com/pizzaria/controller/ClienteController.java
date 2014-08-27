package br.com.pizzaria.controller;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.model.ClienteModel;
import java.util.List;
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
            JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'RUA' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));

            return false;
        }

        if (cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'BAIRRO' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Campo 'TELEFONE' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
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
    
    /**
     * Método sobrescrito para trabalhar com a tela 
     * de pedido do cliente
     * @param pesquisa
     * @param lista para popular o comboBox da pesquisa
     */
    public void controlePesquisa(String pesquisa, List<String> lista){
        clienteModel.procuraCliente(pesquisa, lista);
    }
    
    public ClienteBeans controlePreenchimento(int codigo){
        return clienteModel.preencherCampos(codigo);
    }
    
    public boolean verificarDadosParaEditar(ClienteBeans cliente) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"NOME\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"RUA\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));

            return false;
        }

        if (cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"BAIRRO\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getTelefone().equals("(  )    -    ")) {
            JOptionPane.showMessageDialog(null, "Campo \"TELEFONE\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        

        clienteModel.editarCliente(cliente);
        return true;
    }
}
