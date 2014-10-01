package br.com.pizzaria.controller;

import br.com.pizzaria.beans.CargoBean;
import br.com.pizzaria.beans.ClienteBean;
import br.com.pizzaria.model.CargoModel;
import br.com.pizzaria.model.ClienteModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CargoController {

    CargoModel cargoModel;

    public CargoController() {
        cargoModel = new CargoModel();
    }

    public boolean verificarDados(String descricao) {
        if (descricao.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo 'Descrição' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            return false;
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
