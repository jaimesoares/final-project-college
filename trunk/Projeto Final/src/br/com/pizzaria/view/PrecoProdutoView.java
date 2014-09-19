package br.com.pizzaria.view;

import br.com.pizzaria.beans.PrecoProdutoBeans;
import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.beans.TipoProdutoBeans;
import br.com.pizzaria.controller.PrecoProdutoController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public final class PrecoProdutoView extends javax.swing.JInternalFrame {

    List<ProdutoBeans> listaProduto;
    PrecoProdutoController precoProdutoController;
    DefaultListModel modeloListaProd;
    ComboBoxModel<PrecoProdutoBeans> modeloComboProd;
    DefaultTableModel modeloTabelaPrecoProd;

    public PrecoProdutoView() {
        initComponents();
        precoProdutoController = new PrecoProdutoController();
        modeloListaProd = new DefaultListModel();
        modeloComboProd = (ComboBoxModel) cbProduto.getModel();
        modeloTabelaPrecoProd = (DefaultTableModel) tblPrecoProduto.getModel();
        
        populaListaProduto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblModulo = new javax.swing.JLabel();
        cbProduto = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrecoProduto = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO PREÇO DE PRODUTOS");
        setPreferredSize(new java.awt.Dimension(680, 680));

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario.setText("Produto:");

        lblModulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblModulo.setText("Preço:");

        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

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

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });

        tblPrecoProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Tipo", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPrecoProduto.getTableHeader().setReorderingAllowed(false);
        tblPrecoProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPrecoProdutoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPrecoProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblModulo)
                                .addGap(18, 18, 18)
                                .addComponent(txtPreco)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblModulo)
                        .addComponent(btnAdicionar))
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (precoProdutoController.verificarDados(((ProdutoBeans)modeloComboProd.getSelectedItem()).getCodigo(), Double.parseDouble(txtPreco.getText()))) {
            modeloListaProd.removeAllElements();
            
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void tblPrecoProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPrecoProdutoMousePressed
        
    }//GEN-LAST:event_tblPrecoProdutoMousePressed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        modeloTabelaPrecoProd.setNumRows(0);
        precoProdutoController.controlePesquisaPrecoProdutos(((ProdutoBeans)modeloComboProd.getSelectedItem()).getCodigo(), modeloTabelaPrecoProd);
    }//GEN-LAST:event_cbProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblPrecoProduto;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables

    public void populaListaProduto() {
        listaProduto = new ArrayList<>();
        precoProdutoController.controleListaProduto(listaProduto);
        for (ProdutoBeans prdutoBeans : listaProduto) {
            cbProduto.addItem(prdutoBeans);
        }
    }
    
    

}
