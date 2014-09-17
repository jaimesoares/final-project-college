package br.com.pizzaria.view;

import br.com.pizzaria.beans.CargoBeans;
import br.com.pizzaria.controller.CargoController;
import javax.swing.DefaultListModel;

public class CargoFuncaoView extends javax.swing.JInternalFrame {

    CargoBeans cargoBeans;
    CargoController cargoController;
    DefaultListModel modelo;

    public CargoFuncaoView() {
        initComponents();

        cargoBeans = new CargoBeans();
        cargoController = new CargoController();
        modelo = new DefaultListModel();
        carregaListaCargo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCargo = new javax.swing.JList();
        sep_codigo1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE FUNÇÃO/CARGO");
        setPreferredSize(new java.awt.Dimension(680, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Função/Cargo");

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

        lstCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lstCargoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(lstCargo);

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
                    .addComponent(txtCargo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 487, Short.MAX_VALUE)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnRemover});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnRemover)
                    .addComponent(btnFechar))
                .addContainerGap(322, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

        this.dispose();

    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (cargoController.verificarDados(txtCargo.getText())) {
            modelo.removeAllElements();
            carregaListaCargo();
            txtCargo.setText("");
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        CargoBeans novo = (CargoBeans) lstCargo.getSelectedValue();
        cargoController.verificarDadosParaEditar(novo);
        modelo.removeAllElements();
        carregaListaCargo();
        txtCargo.setText("");

    }//GEN-LAST:event_btnRemoverActionPerformed

    private void lstCargoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCargoMouseReleased
        CargoBeans novo = (CargoBeans) lstCargo.getSelectedValue();
        //txtCargo.setText(novo.getDescricao());
    }//GEN-LAST:event_lstCargoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstCargo;
    private javax.swing.JSeparator sep_codigo1;
    private javax.swing.JTextField txtCargo;
    // End of variables declaration//GEN-END:variables

    final CargoBeans populaClienteBeans() {
        cargoBeans.setDescricao(txtCargo.getText());

        System.out.println(cargoBeans);
        return cargoBeans;

    }

    public void carregaListaCargo() {
        cargoController.controleListaCargo(modelo);
        lstCargo.setModel(modelo);
    }

    public static void main(String args[]) {
//        ClienteView cliente = new ClienteView();
//        cliente.setVisible(true);
    }

}
