package br.com.pizzaria.controller;

import br.com.pizzaria.beans.ClienteBean;
import br.com.pizzaria.beans.ModuloBean;
import br.com.pizzaria.beans.UsuarioBean;
import br.com.pizzaria.model.DefinirModuloModel;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DefinirModuloController {

    DefinirModuloModel moduloModel;

    public DefinirModuloController() {
        moduloModel = new DefinirModuloModel();
    }

    public boolean verificarDados(ClienteBean cliente) {
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

    
    
    
    public void controleUsuario(List<UsuarioBean> lista) {
        moduloModel.populaCliente(lista);
    }
    
    public void controleModulo(List<ModuloBean> lista) {
        moduloModel.populaModulo(lista);
    }
    
    public ClienteBean controlePreenchimento(int codigo){
        return moduloModel.preencherCampos(codigo);
    }
    
    public boolean verificarDadosParaEditar(ClienteBean cliente) {
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
