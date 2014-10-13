package br.com.pizzaria.controller;

import br.com.pizzaria.bean.CargoBean;
import br.com.pizzaria.model.CargoModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CargoController {

    CargoModel cargoModel;

    public CargoController() {
        cargoModel = new CargoModel();
    }

    public boolean verificarDados(String descricao, DefaultListModel lista) {
        if (descricao.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Descrição' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }
        
        for(int i=0; i<lista.size();i++){
            if(descricao.equalsIgnoreCase(lista.getElementAt(i).toString())){
                JOptionPane.showMessageDialog(null, lista.getElementAt(i).toString()+ " já existe!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
            }
        }
       

        cargoModel.cadastrarCargo(descricao);
        return true;
    }

    public void controleListaCargo(DefaultListModel modelo) {
        cargoModel.populaListaCargo(modelo);
    }

    public boolean verificarDadosParaEditar(CargoBean cargo) {
        if (cargo.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo \"Descrição\" não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
        }

        cargoModel.editarCargo(cargo);
        return true;
    }
}
