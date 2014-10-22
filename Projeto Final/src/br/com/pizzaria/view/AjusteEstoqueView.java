package br.com.pizzaria.view;

import br.com.pizzaria.bean.AjusteEstoqueBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.controller.AjusteEstoqueController;
import br.com.pizzaria.util.VerificarData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;

public class AjusteEstoqueView extends javax.swing.JInternalFrame {

    AjusteEstoqueController ajusteEstoqueController;
    List<ProdutoBean> listaProduto;
    ComboBoxModel<TipoProdutoBean> modeloTipoProd;
    List<TipoProdutoBean> listaTipoProd;
    ComboBoxModel<ProdutoBean> modeloProduto;
    ButtonGroup grupoAjuste;
    AjusteEstoqueBean ajusteEstoqueBean;

    public AjusteEstoqueView() {

        initComponents();

        grupoAjuste = new ButtonGroup();
        grupoAjuste.add(rbEntrada);
        grupoAjuste.add(rbSaida);

        txtData.setText(VerificarData.retornoDeDataAtual());
        habilitarCampos(false);
        modeloTipoProd = cbTipo.getModel();
        modeloProduto = cbProduto.getModel();

        ajusteEstoqueController = new AjusteEstoqueController();
        ajusteEstoqueBean = new AjusteEstoqueBean();

        populaTipoProduto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sep_tabela = new javax.swing.JSeparator();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        cbProduto = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        lbl_data = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lbl_data1 = new javax.swing.JLabel();
        lbl_data2 = new javax.swing.JLabel();
        lbl_data3 = new javax.swing.JLabel();
        lbl_data4 = new javax.swing.JLabel();
        txtMedida = new javax.swing.JTextField();
        txtQtdAtual = new javax.swing.JTextField();
        lbl_data5 = new javax.swing.JLabel();
        txtQtdAjuste = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rbEntrada = new javax.swing.JRadioButton();
        rbSaida = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("AJUSTE DE ESTOQUE");
        setPreferredSize(new java.awt.Dimension(680, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ajuste de Estoque");
        jLabel1.setOpaque(true);

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Tipo Produto" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        cbProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Produto" }));
        cbProduto.setEnabled(false);
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

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Dt. Movto:");

        txtData.setEditable(false);
        txtData.setBackground(new java.awt.Color(255, 255, 204));
        txtData.setForeground(new java.awt.Color(51, 102, 255));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        lbl_data1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data1.setText("Tipo Produto:");

        lbl_data2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data2.setText("Produto:");

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Unid. Med.");

        lbl_data4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data4.setText("Qtde Atual:");

        txtMedida.setEditable(false);
        txtMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedidaActionPerformed(evt);
            }
        });

        txtQtdAtual.setEditable(false);

        lbl_data5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data5.setText("Qtde Ajuste:");

        txtQtdAjuste.setEditable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Ajuste:"));

        rbEntrada.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbEntrada.setSelected(true);
        rbEntrada.setText("Ajuste Entrada");

        rbSaida.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbSaida.setText("Ajuste Saída");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbEntrada)
                    .addComponent(rbSaida))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbSaida))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 492, Short.MAX_VALUE)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_data))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data1)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data2)
                                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_data3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMedida))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data4)
                                    .addComponent(txtQtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data5)
                                    .addComponent(txtQtdAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_data)
                    .addComponent(lbl_data1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_data2)
                    .addComponent(lbl_data3)
                    .addComponent(lbl_data4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(373, 373, 373)
                        .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFechar)
                            .addComponent(btnAdicionar)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

        this.dispose();

    }//GEN-LAST:event_btnFecharActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        if (cbTipo.getSelectedIndex() > 0) {
            limpaCampos();
            cbProduto.removeAllItems();
            populaListaProduto();
            cbProduto.setEnabled(true);
        } else {
            cbProduto.setEnabled(false);
            cbProduto.setSelectedIndex(0);
            limpaCampos();
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        if (cbProduto.getSelectedIndex() > 0) {
            limpaCampos();
            populaQuantidadeAtual();
            txtMedida.setText(((ProdutoBean) modeloProduto.getSelectedItem()).getUnidadeMedida());
            txtQtdAjuste.setEditable(true);
        } else {
            txtQtdAjuste.setEditable(false);
            limpaCampos();
        }
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JLabel lbl_data2;
    private javax.swing.JLabel lbl_data3;
    private javax.swing.JLabel lbl_data4;
    private javax.swing.JLabel lbl_data5;
    private javax.swing.JRadioButton rbEntrada;
    private javax.swing.JRadioButton rbSaida;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtQtdAjuste;
    private javax.swing.JTextField txtQtdAtual;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txtMedida.setEditable(valor);
        txtQtdAjuste.setEditable(valor);
        txtQtdAtual.setEditable(valor);
    }

    public void populaTipoProduto() {
        listaTipoProd = new ArrayList<>();
        ajusteEstoqueController.controleListaTipoProduto(listaTipoProd);
        for (TipoProdutoBean tipoProdutoBeans : listaTipoProd) {
            cbTipo.addItem(tipoProdutoBeans);
        }
    }

    public void populaListaProduto() {
        if (cbTipo.getSelectedIndex() > 0) {
            listaProduto = new ArrayList<>();
            ajusteEstoqueController.controleDeItens(((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo(), listaProduto);
            cbProduto.addItem("Selecionar Produto");

            for (ProdutoBean prdutoBeans : listaProduto) {
                cbProduto.addItem(prdutoBeans);
            }

        } else {

            cbProduto.setSelectedIndex(0);
        }
    }

    public void populaQuantidadeAtual() {
        if (cbProduto.getSelectedIndex() > 0) {

            long controleQuantidadeAtual = ajusteEstoqueController.controleQuantidadeAtual(((ProdutoBean) modeloProduto.getSelectedItem()).getCodigo());
            txtQtdAtual.setText(String.valueOf(controleQuantidadeAtual));

        }
    }

    public void limpaCampos() {
        txtMedida.setText("");
        txtQtdAjuste.setText("");
        txtQtdAtual.setText("");
    }
    
    public AjusteEstoqueBean populaAjuste(){
        
        return null;
    }
}
