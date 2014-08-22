package br.com.pizzaria.controller;

import br.com.pizzaria.beans.UsuarioBeans;
import br.com.pizzaria.model.UsuarioModel;
import br.com.pizzaria.util.Som;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UsuarioController {

    UsuarioModel usuarioModel;
    private final Som play;

    public UsuarioController() {
        usuarioModel = new UsuarioModel();
        play = new Som();
    }

    public boolean verificaDados(UsuarioBeans usuarioBeans) {

        if (usuarioBeans.getUsuario().equals("")) {
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

    public UsuarioBeans controlePesquisa(UsuarioBeans usuario) {
        return usuarioModel.selectUser(usuario);
    }

}
