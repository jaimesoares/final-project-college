package br.com.pizzaria.view;

import br.com.pizzaria.beans.TipoProdutoBean;
import br.com.pizzaria.controller.TipoProdutoController;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TipoProdutoView extends javax.swing.JInternalFrame {

    TipoProdutoBean tipoProdutoBeans;
    TipoProdutoController tipoProdutoController;
    DefaultListModel modelo;

    public TipoProdutoView() {
        initComponents();

        tipoProdutoBeans = new TipoProdutoBean();
        tipoProdutoController = new TipoProdutoController();
        modelo = new DefaultListModel();
        carregaListaCargo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCargo = new javax.swing.JList();
        sep_codigo1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE TIPO DE PRODUTO");
        setPreferredSize(new java.awt.Dimension(680, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Produto:");

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
                    .addComponent(txtTipo)
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
                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (tipoProdutoController.verificarDados(txtTipo.getText())) {
            modelo.removeAllElements();
            carregaListaCargo();
            txtTipo.setText("");
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        TipoProdutoBean novo = (TipoProdutoBean) lstCargo.getSelectedValue();
        if(novo.getDescricao().equals("Pizza")){
            JOptionPane.showMessageDialog(null, "Campo não pode ser removido");
        }else{
        tipoProdutoController.verificarDadosParaEditar(novo);
        modelo.removeAllElements();
        carregaListaCargo();
        txtTipo.setText("");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void lstCargoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCargoMouseReleased
        TipoProdutoBean novo = (TipoProdutoBean) lstCargo.getSelectedValue();
    }//GEN-LAST:event_lstCargoMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstCargo;
    private javax.swing.JSeparator sep_codigo1;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    final TipoProdutoBean populaClienteBeans() {

        System.out.println(tipoProdutoBeans);
        return tipoProdutoBeans;

    }

    public void carregaListaCargo() {
        tipoProdutoController.controleListaCargo(modelo);
        lstCargo.setModel(modelo);
    }

    public static void main(String args[]) {
//        ClienteView cliente = new ClienteView();
//        cliente.setVisible(true);
    }

}
