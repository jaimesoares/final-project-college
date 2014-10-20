package br.com.pizzaria.view;

import br.com.pizzaria.bean.PrecoProdutoBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.controller.PrecoProdutoController;
import br.com.pizzaria.controller.ProdutoController;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public final class PrecoProdutoView extends javax.swing.JInternalFrame {

    List<ProdutoBean> listaProduto;
    PrecoProdutoController precoProdutoController;
    DefaultListModel modeloListaProd;
    ComboBoxModel<PrecoProdutoBean> modeloComboProd;
    DefaultTableModel modeloTabelaPrecoProd;
    DecimalFormat decimalFormato;
    ComboBoxModel<TipoProdutoBean> modeloTipoProd;
    List<TipoProdutoBean> listaTipoProd;
    ProdutoController produtoController;

    public PrecoProdutoView() {
        initComponents();
        precoProdutoController = new PrecoProdutoController();
        modeloListaProd = new DefaultListModel();
        modeloComboProd = cbProduto.getModel();
        modeloTabelaPrecoProd = (DefaultTableModel) tblPrecoProduto.getModel();
        decimalFormato = new DecimalFormat("0.00");
        modeloTipoProd = cbTipo.getModel();
        produtoController = new ProdutoController();

        populaTipoProduto();
        //populaListaProduto();

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
        lblUsuario1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();

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

        btnAdicionar.setText("Adicionar");
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

        txtPreco.setBackground(new java.awt.Color(204, 255, 255));
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoKeyTyped(evt);
            }
        });

        tblPrecoProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Tipo", "Valor", "Data Alteração"
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

        lblUsuario1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario1.setText("Tipo:");

        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblModulo)
                        .addGap(18, 18, 18)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUsuario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUsuario1)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUsuario)
                        .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblModulo)
                        .addComponent(btnAdicionar))
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if (precoProdutoController.controlePrecoData(((ProdutoBean) modeloComboProd.getSelectedItem()).getCodigo(), txtPreco.getText().toString().replace(",", "."))) {
        } else if (precoProdutoController.verificarDados(((ProdutoBean) modeloComboProd.getSelectedItem()).getCodigo(), txtPreco.getText())) {
            modeloListaProd.removeAllElements();
            modeloTabelaPrecoProd.setNumRows(0);
            precoProdutoController.controlePesquisaPrecoProdutos(((ProdutoBean) modeloComboProd.getSelectedItem()).getCodigo(), modeloTabelaPrecoProd);
            txtPreco.setText("");
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
        if (cbProduto.getSelectedIndex() >= 0) {
            modeloTabelaPrecoProd.setNumRows(0);
            precoProdutoController.controlePesquisaPrecoProdutos(((ProdutoBean) modeloComboProd.getSelectedItem()).getCodigo(), modeloTabelaPrecoProd);
        }
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void txtPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyTyped
        String caracteres = "0987654321,.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtPrecoKeyTyped

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        modeloTabelaPrecoProd.setNumRows(0);
        cbProduto.removeAllItems();

        populaListaProduto();
    }//GEN-LAST:event_cbTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JTable tblPrecoProduto;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables

    public void populaListaProduto() {
        listaProduto = new ArrayList<>();
        precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
        for (ProdutoBean prdutoBeans : listaProduto) {
            cbProduto.addItem(prdutoBeans);
        }
    }

    public void populaTipoProduto() {
        listaTipoProd = new ArrayList<>();
        produtoController.controleListaProduto(listaTipoProd);
        for (TipoProdutoBean tipoProdutoBeans : listaTipoProd) {
            cbTipo.addItem(tipoProdutoBeans);
        }
    }

}
