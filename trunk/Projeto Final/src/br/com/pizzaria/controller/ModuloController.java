package br.com.pizzaria.controller;

import br.com.pizzaria.beans.ModuloBeans;
import br.com.pizzaria.model.ModuloModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ModuloController {

    ModuloModel moduloModel;

    public ModuloController() {
        moduloModel = new ModuloModel();
    }

    public boolean verificarDados(ModuloBeans moduloBeans) {
        if (moduloBeans.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Nome' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        if (moduloBeans.getTitulo().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Titulo' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        moduloModel.cadastrarModulo(moduloBeans);
        return true;
    }

    public void controleListaModulo(DefaultListModel modelo) {
        moduloModel.populaListaModulo(modelo);
    }

    public boolean verificarDadosParaEditar(ModuloBeans modulo) {
        if (modulo.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"Nome\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        
        if (modulo.getTitulo().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"Título\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        moduloModel.editarModulo(modulo);
        return true;
    }
}
