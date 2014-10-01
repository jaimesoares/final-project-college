package br.com.pizzaria.view;

import br.com.pizzaria.beans.ModuloBean;
import br.com.pizzaria.beans.UsuarioBean;
import br.com.pizzaria.controller.DefinirModuloController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public final class DefinirModuloView extends javax.swing.JInternalFrame {
    
    List<UsuarioBean> listaUsuario;
    List<ModuloBean> listaModulo;
    DefinirModuloController moduloController;
    DefaultListModel modeloLista;

    public DefinirModuloView() {
        initComponents();
        moduloController = new DefinirModuloController();
        populaUsuario();
        populaModulo();
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

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE MÓDULOS USUÁRIO");
        setPreferredSize(new java.awt.Dimension(680, 680));

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário:");

        lblModulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblModulo.setText("Módulo:");

        btnAdicionar.setText("+");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstModulos);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover Módulo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblModulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbModulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionar)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
       modeloLista.addElement(cbModulo.getSelectedItem());
       lstModulos.setModel(modeloLista);
       cbModulo.removeItem(cbModulo.getSelectedItem());
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed


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
        moduloController.controleUsuario(listaUsuario);
        for(UsuarioBean usuarioBeans : listaUsuario){
            cbUsuario.addItem(usuarioBeans.getLogin());
        }
    }
    
    public void populaModulo(){
        listaModulo = new ArrayList<>();
        moduloController.controleModulo(listaModulo);
        for(ModuloBean moduloBeans : listaModulo){
            cbModulo.addItem(moduloBeans.getNome());
        }
    }

}
