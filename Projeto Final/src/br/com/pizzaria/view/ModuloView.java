package br.com.pizzaria.view;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.controller.ClienteController;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ModuloView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    ClienteBeans clienteBeans;
    ClienteController clienteController;
    DefaultTableModel modelo;
    JFrame frame;

    public ModuloView() {
        initComponents();
        this.frame = frame;
        habilitarCampos(false);

        clienteBeans = new ClienteBeans();
        clienteController = new ClienteController();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        sep_codigo1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE CLIENTE");
        setPreferredSize(new java.awt.Dimension(229, 315));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Permissão de Módulos");

        btnNovo.setText("+");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnEditar.setText("-");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_codigo1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNome)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditar, btnNovo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnFechar))
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
//        if (btnFechar.getText().equals("Cancelar")) {
//            limpaTudo();
//            if (btnEditar.getText().equals("Salvar")) {
//                btnEditar.setText("Editar");
//                btnNovo.setEnabled(true);
//                habilitarCampos(false);
//            } else {
//                btnNovo.setText("Novo");
//                btnFechar.setText("Fechar");
//                btnEditar.setEnabled(true);
//                habilitarCampos(false);
//            }
//            btnFechar.setText("Fechar");
//        } else {
            this.dispose();
//        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
//        if (btnNovo.getText().equals("Novo")) {
//            btnNovo.setText("Salvar");
//            btnFechar.setText("Cancelar");
//            btnEditar.setEnabled(false);
//            modelo.setNumRows(0);
//            habilitarCampos(true);
//            txtNome.requestFocus();
//            txtCodigo.setText(clienteController.controleDeCodigo());
//            limpaNovo();
//        } else {
//
//            populaClienteBeans();
//            if (clienteController.verificarDados(clienteBeans)) {
//                btnNovo.setText("Novo");
//                btnFechar.setText("Fechar");
//                btnEditar.setEnabled(true);
//             
//                limpaTudo();
//                habilitarCampos(false);
//            }
//        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//
//        if (btnEditar.getText().equals("Editar")) {
//            btnEditar.setText("Salvar");
//            btnFechar.setText("Cancelar");
//            btnNovo.setEnabled(false);
//            habilitarCampos(true);
//        } else {
//            if (clienteController.verificarDadosParaEditar(populaClienteBeans())) {
//                btnEditar.setText("Editar");
//                btnFechar.setText("Fechar");
//                btnNovo.setEnabled(true);
//                limpaTudo();
//                habilitarCampos(false);
//            }
//        }

    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator sep_codigo1;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txtNome.setEditable(valor);
        
    }

    final ClienteBeans populaClienteBeans() {
        clienteBeans.setNome(txtNome.getText());
        
        System.out.println(clienteBeans);
        return clienteBeans;

    }

    final void limpaTudo() {
        txtNome.setText("");
    }

    final void limpaNovo() {
        txtNome.setText("");
       
    }

    public static void main(String args[]) {
//        ClienteView cliente = new ClienteView();
//        cliente.setVisible(true);
    }

}
