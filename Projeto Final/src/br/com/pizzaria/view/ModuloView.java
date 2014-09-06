package br.com.pizzaria.view;

import br.com.pizzaria.beans.CargoBeans;
import br.com.pizzaria.beans.ModuloBeans;
import br.com.pizzaria.controller.ModuloController;
import javax.swing.DefaultListModel;

public class ModuloView extends javax.swing.JInternalFrame {

   ModuloBeans moduloBeans;
    ModuloController moduloController;
    DefaultListModel modelo;

    public ModuloView() {
        initComponents();
        
        moduloBeans = new ModuloBeans();
        moduloController = new ModuloController();
        modelo = new DefaultListModel();
        carregaListaModulo();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstModulo = new javax.swing.JList();
        sep_codigo1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE MÓDULOS");
        setPreferredSize(new java.awt.Dimension(229, 350));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Permissão de Módulos");

        btnAdicionar.setText("+");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnRemover.setText("-");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstModulo);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Título:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_codigo1)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addComponent(txtNome)
                    .addComponent(txtTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnRemover});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnRemover)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

            this.dispose();

    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (moduloController.verificarDados(populaModuloBeans())) {
            modelo.removeAllElements();
            carregaListaModulo();
            txtNome.setText("");
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        ModuloBeans novo = (ModuloBeans) lstModulo.getSelectedValue();
        moduloController.verificarDadosParaEditar(novo);
        modelo.removeAllElements();
        carregaListaModulo();
        txtNome.setText("");
        txtTitulo.setText("");
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList lstModulo;
    private javax.swing.JSeparator sep_codigo1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

    public void carregaListaModulo() {
        moduloController.controleListaModulo(modelo);
        lstModulo.setModel(modelo);
    }
final ModuloBeans populaModuloBeans() {
        moduloBeans.setNome(txtNome.getText());
        moduloBeans.setTitulo(txtTitulo.getText());

        System.out.println(moduloBeans);
        return moduloBeans;

    }


    public static void main(String args[]) {
//        ClienteView cliente = new ClienteView();
//        cliente.setVisible(true);
    }

}
