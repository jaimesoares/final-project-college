package br.com.pizzaria.controller;

import br.com.pizzaria.beans.UsuarioBean;
import br.com.pizzaria.model.FuncionarioModel;
import br.com.pizzaria.model.UsuarioModel;
import br.com.pizzaria.util.Som;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioController {

    UsuarioModel usuarioModel;
    private final Som play;
    FuncionarioModel funcionarioModel;

    public UsuarioController() {
        usuarioModel = new UsuarioModel();
        play = new Som();
        funcionarioModel = new FuncionarioModel();
    }

    public boolean verificaDados(UsuarioBean usuarioBeans) {

        if (usuarioBeans.getLogin().equals("")) {
            play.som();
            JOptionPane.showMessageDialog(null, "Campo 'USUÁRIO' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (usuarioBeans.getSenha().equals("")) {
            play.som();
            JOptionPane.showMessageDialog(null, "Campo 'SENHA' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        return true;

    }

    public UsuarioBean controlePesquisaLogin(UsuarioBean usuario) {
        return usuarioModel.selectUser(usuario);
    }

    public void controleListaFuncionario(DefaultTableModel modelo) {
        funcionarioModel.listaFuncionario(modelo);
    }
    
    public UsuarioBean controlePreenchimento(int codigo){
        return usuarioModel.preencherCampos(codigo);
    }
    
    public boolean controleDeCampos(int selecaoTabela, String login){
        if (selecaoTabela < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionário!", "SELEÇÃO INVÁLIDA", 1 );
            return false;
        }
        
        if (!login.equals("")) {
            JOptionPane.showMessageDialog(null, "Usuário já cadastrado", "OPÇÃO INVÁLIDA", 1 );
            return false;
        }
        
        return true;
    }
    
    public boolean controleDeCamposEditar(int selecaoTabela, String login){
        if (selecaoTabela < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionário!", "SELEÇÃO INVÁLIDA", 1 );
            return false;
        }
        
        if (login.equals("")) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado", "OPÇÃO INVÁLIDA", 1 );
            return false;
        }
        
        return true;
    }
    
    public boolean controleDeSenha(String senha1, String senha2){
        if(senha1.equals(senha2)){
        return true;
        }else{
            JOptionPane.showMessageDialog(null, "Senhas não condizem", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
    }
    
    public boolean controleDadosNovo(UsuarioBean usuarioBeans) {

        if (usuarioBeans.getLogin().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Login' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (usuarioBeans.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Senha' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        usuarioModel.cadastrarUsuario(usuarioBeans);
        return true;

    }
    
    public boolean controleDadosEditar(UsuarioBean usuarioBeans) {

        if (usuarioBeans.getLogin().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Login' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (usuarioBeans.getSenha().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Senha' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        usuarioModel.editarUsuario(usuarioBeans);
        return true;

    }
    
    
    
    

}
