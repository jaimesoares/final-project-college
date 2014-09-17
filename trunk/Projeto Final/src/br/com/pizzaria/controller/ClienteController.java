package br.com.pizzaria.controller;

import br.com.pizzaria.beans.CepBeans;
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

    public boolean verificarDados(ClienteBeans cliente, String cep, String numero, String nascimento) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (nascimento.equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Campo \"NASCIMENTO\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Endereço' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));

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

        if (cep.equals("     -   ")) {
            JOptionPane.showMessageDialog(null, "Campo 'CEP' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (numero.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'NÚMERO' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        cliente.setAniversario(nascimento);
        cliente.setNumero(Integer.parseInt(numero));
        cliente.setCep(cep.replace("-", ""));
        return clienteModel.cadastrarCliente(cliente);
    }

    public String controleDeCodigo() {
        return clienteModel.proximoCliente();
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        clienteModel.procuraCliente(pesquisa, modelo);
    }

    /**
     * Método sobrescrito para trabalhar com a tela de pedido do cliente
     *
     * @param pesquisa
     * @param lista para popular o comboBox da pesquisa
     */
//    public void controlePesquisa(String pesquisa, List<String> lista) {
//        clienteModel.procuraCliente(pesquisa, lista);
//    }
    public ClienteBeans controlePreenchimento(int codigo) {
        return clienteModel.preencherCampos(codigo);
    }

    public boolean verificarDadosParaEditar(ClienteBeans cliente, String cep, String numero, String nascimento) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"NOME\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (nascimento.equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Campo \"NASCIMENTO\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"Endereço\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));

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

        if (cep.equals("     -   ")) {
            JOptionPane.showMessageDialog(null, "Campo 'CEP' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (numero.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'NÚMERO' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        cliente.setAniversario(nascimento);
        cliente.setNumero(Integer.parseInt(numero));
        cliente.setCep(cep.replace("-", ""));
        clienteModel.editarCliente(cliente);
        return true;
    }

    public CepBeans controleCep(String cep) {
        return clienteModel.populaCamposCep(cep);
    }

    public boolean controleCepValido(CepBeans cepBeans) {
        if (cepBeans.getCep() == null) {
            JOptionPane.showMessageDialog(null, "CEP Inválido", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        } else {
            return true;
        }
    }
}
