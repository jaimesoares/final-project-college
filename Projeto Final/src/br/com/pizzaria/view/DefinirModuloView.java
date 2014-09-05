package br.com.pizzaria.view;

import br.com.pizzaria.beans.UsuarioBeans;
import br.com.pizzaria.controller.DefinirModuloController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public final class DefinirModuloView extends javax.swing.JInternalFrame {
    
    List<UsuarioBeans> listaUsuario;
    DefinirModuloController moduloController;
    DefaultListModel modeloLista;

    public DefinirModuloView() {
        initComponents();
        moduloController = new DefinirModuloController();
        populaUsuario();
        modeloLista = new DefaultListModel();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblModulo = new javax.swing.JLabel();
        cbUsuario = new javax.swing.JComboBox();
        cbModulo = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstModulos = new javax.swing.JList();
        btnFechar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setTitle("Definição de Módulos");

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário:");

        lblModulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblModulo.setText("Módulo:");

        cbModulo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cadastro Usuário", "Cadastro Cliente", "Cadastro Funcionário" }));

        btnAdicionar.setText("+");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstModulos);

        btnFechar.setText("Fechar");

        btnRemover.setText("Remover Módulo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblModulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(cbUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModulo)
                    .addComponent(cbModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnRemover))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
       modeloLista.addElement(cbModulo.getSelectedItem());
       lstModulos.setModel(modeloLista);
       cbModulo.removeItem(cbModulo.getSelectedItem());
    }//GEN-LAST:event_btnAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cbModulo;
    private javax.swing.JComboBox cbUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JList lstModulos;
    // End of variables declaration//GEN-END:variables

    public void populaUsuario(){
        listaUsuario = new ArrayList<>();
        moduloController.controlePesquisa(listaUsuario);
        for(UsuarioBeans usuarioBeans : listaUsuario){
            cbUsuario.addItem(usuarioBeans.getLogin());
        }
    }

}
