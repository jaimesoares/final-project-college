package br.com.pizzaria.controller;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.model.ClienteModel;
import br.com.pizzaria.util.VerificarData;
import br.com.pizzaria.view.ClienteView;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteController extends ClienteView{

    ClienteModel clienteModel;

    public ClienteController() {
        clienteModel = new ClienteModel();
    }

    public boolean verificarDados(ClienteBean cliente, String cep, String numero, String nascimento) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'NOME' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
            
        }

        if (nascimento.equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Campo \"NASCIMENTO\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (!VerificarData.verificaData(nascimento)) {
            JOptionPane.showMessageDialog(null, "Campo \"NASCIMENTO\" inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

//        if (cliente.getRua().equals("")) {
//            JOptionPane.showMessageDialog(null, "Campo 'Endereço' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
//
//            return false;
//        }
//        if (cliente.getBairro().equals("")) {
//            JOptionPane.showMessageDialog(null, "Campo 'BAIRRO' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
//            return false;
//        }
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

        if ((cliente.getEmail().equals(""))) {
        } else if ((cliente.getEmail().contains("@")) && (cliente.getEmail().contains(".")) && (!cliente.getEmail().contains(" "))) {
            String usuario = new String(cliente.getEmail().substring(0, cliente.getEmail().lastIndexOf('@')));
            String dominio = new String(cliente.getEmail().substring(cliente.getEmail().lastIndexOf('@') + 1, cliente.getEmail().length()));
            if ((usuario.length() >= 1) && (!usuario.contains("@")) && (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".") >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {

            } else {
                JOptionPane.showMessageDialog(null, "Campo 'E-MAIL' inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo 'E-MAIL' inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
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

    public ClienteBean controlePreenchimento(int codigo) {
        return clienteModel.preencherCampos(codigo);
    }

    public boolean verificarDadosParaEditar(ClienteBean cliente, String cep, String numero, String nascimento) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"NOME\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (nascimento.equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Campo \"NASCIMENTO\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (!VerificarData.verificaData(nascimento)) {
            JOptionPane.showMessageDialog(null, "Campo \"NASCIMENTO\" inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

//        if (cliente.getRua().equals("")) {
//            JOptionPane.showMessageDialog(null, "Campo \"Endereço\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
//
//            return false;
//        }
//
//        if (cliente.getBairro().equals("")) {
//            JOptionPane.showMessageDialog(null, "Campo \"BAIRRO\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
//            return false;
//        }
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

        if ((cliente.getEmail().equals(""))) {
        } else if ((cliente.getEmail().contains("@")) && (cliente.getEmail().contains(".")) && (!cliente.getEmail().contains(" "))) {
            String usuario = new String(cliente.getEmail().substring(0, cliente.getEmail().lastIndexOf('@')));
            String dominio = new String(cliente.getEmail().substring(cliente.getEmail().lastIndexOf('@') + 1, cliente.getEmail().length()));
            if ((usuario.length() >= 1) && (!usuario.contains("@")) && (dominio.contains(".")) && (!dominio.contains("@")) && (dominio.indexOf(".") >= 1) && (dominio.lastIndexOf(".") < dominio.length() - 1)) {

            } else {
                JOptionPane.showMessageDialog(null, "Campo 'E-MAIL' inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo 'E-MAIL' inválido!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        cliente.setAniversario(nascimento);
        cliente.setNumero(Integer.parseInt(numero));
        cliente.setCep(cep.replace("-", ""));
        clienteModel.editarCliente(cliente);
        return true;
    }

    public CepBean controleCep(String cep) {
        return clienteModel.populaCamposCep(cep);
    }

    public boolean controleCepValido(CepBean cepBeans) {
        if (cepBeans.getCep() == null) {
            JOptionPane.showMessageDialog(null, "CEP Inválido", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        } else {
            return true;
        }
    }
    
    
   
}
