package br.com.pizzaria.controller;

import br.com.pizzaria.beans.CargoBean;
import br.com.pizzaria.beans.CepBean;
import br.com.pizzaria.beans.FuncionarioBean;
import br.com.pizzaria.model.FuncionarioModel;
import br.com.pizzaria.util.VerificarData;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioController {

    FuncionarioModel funcionarioModel;

    public FuncionarioController() {
        funcionarioModel = new FuncionarioModel();
    }

    public boolean verificarDados(FuncionarioBean funcionario, int cargo, String cep, String numero, String nascimento) {
        if (funcionario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cargo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cargo!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
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

        if (funcionario.getTelefone().equals("(  )    -    ")) {
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

        funcionario.setNascimento(nascimento);
        funcionario.setNumero(Integer.parseInt(numero));
        funcionario.setCep(cep.replace("-", ""));
        return funcionarioModel.cadastrarFuncionario(funcionario);
    }

    public String controleDeCodigo() {
        return funcionarioModel.proximoFuncionario();
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        funcionarioModel.procuraFuncionario(pesquisa, modelo);
    }

    public FuncionarioBean controlePreenchimento(int codigo) {
        return funcionarioModel.preencherCampos(codigo);
    }

    public boolean verificarDadosParaEditar(FuncionarioBean funcionario, int cargo, String cep, String numero, String nascimento) {
        if (funcionario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        if (cargo == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um cargo!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
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

        if (funcionario.getTelefone().equals("(  )    -    ")) {
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

        funcionario.setNascimento(nascimento);
        funcionario.setNumero(Integer.parseInt(numero));
        funcionario.setCep(cep.replace("-", ""));

        return funcionarioModel.editarFuncionario(funcionario);

    }

    public void controleListaCargo(List<CargoBean> lista) {
        funcionarioModel.populaListaCargo(lista);
    }

    public boolean controleCepValido(CepBean cepBeans) {
        if (cepBeans.getCep() == null) {
            JOptionPane.showMessageDialog(null, "CEP Inválido", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        } else {
            return true;
        }
    }

    public CepBean controleCep(String cep) {
        return funcionarioModel.populaCamposCep(cep);
    }
}
