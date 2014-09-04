package br.com.pizzaria.controller;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.beans.UsuarioBeans;
import br.com.pizzaria.model.ClienteModel;
import br.com.pizzaria.model.DefinirModuloModel;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DefinirModuloController {

    DefinirModuloModel moduloModel;

    public DefinirModuloController() {
        moduloModel = new DefinirModuloModel();
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

      //  moduloModel.cadastrarCliente(cliente);
        return true;
    }

    public String controleDeCodigo() {
     //   return moduloModel.proximoCliente();
        return null;
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modelo){
      //  moduloModel.procuraCliente(pesquisa, modelo);
    }
    
    /**
     * Método sobrescrito para trabalhar com a tela 
     * de pedido do cliente
     * @param pesquisa
     * @param lista para popular o comboBox da pesquisa
     */
    public void controlePesquisa(List<UsuarioBeans> lista) {
        moduloModel.procuraCliente(lista);
    }
    
    public ClienteBeans controlePreenchimento(int codigo){
        return moduloModel.preencherCampos(codigo);
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

        

        moduloModel.editarCliente(cliente);
        return true;
    }
}
