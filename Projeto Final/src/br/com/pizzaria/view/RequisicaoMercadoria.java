package br.com.pizzaria.view;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.RequisicaoMercadoriaBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.controller.RequisicaoMercadoriaController;
import br.com.pizzaria.util.Global;
import br.com.pizzaria.util.VerificarData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RequisicaoMercadoria extends javax.swing.JInternalFrame {

    RequisicaoMercadoriaController RequisicaoMercadoriaController;
    List<ProdutoBean> listaProduto;
    ComboBoxModel<TipoProdutoBean> modeloTipoProd;
    List<TipoProdutoBean> listaTipoProd;
    ComboBoxModel<ProdutoBean> modeloProduto;
    DefaultTableModel modeloTabela;
    
    RequisicaoMercadoriaBean requisicaoMercadoriaBean;

    public RequisicaoMercadoria() {

        initComponents();
        txtData.setText(VerificarData.retornoDeDataAtual());
        habilitarCampos(false);
        modeloTipoProd = cbTipo.getModel();
        modeloProduto = cbProduto.getModel();
        modeloTabela = (DefaultTableModel) tblPedido.getModel();

        RequisicaoMercadoriaController = new RequisicaoMercadoriaController();
        requisicaoMercadoriaBean = new RequisicaoMercadoriaBean();

        populaTipoProduto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sep_tabela = new javax.swing.JSeparator();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnFechar1 = new javax.swing.JButton();
        lbl_data6 = new javax.swing.JLabel();
        cbTipo1 = new javax.swing.JComboBox();
        sep_tabela1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        cbTipo = new javax.swing.JComboBox();
        cbProduto = new javax.swing.JComboBox();
        txtMedida = new javax.swing.JTextField();
        txtQtdAtual = new javax.swing.JTextField();
        txtQtdAjuste = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        lbl_data = new javax.swing.JLabel();
        lbl_data1 = new javax.swing.JLabel();
        lbl_data2 = new javax.swing.JLabel();
        lbl_data3 = new javax.swing.JLabel();
        lbl_data4 = new javax.swing.JLabel();
        lbl_data5 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("REQUISIÇÃO DE MERCADORIA");
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
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Requisição de Mercadoria");
        jLabel1.setOpaque(true);

        btnFechar1.setText("Requisitar");
        btnFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar1ActionPerformed(evt);
            }
        });

        lbl_data6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data6.setText("Setor Solicitante:");

        cbTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Setor", "Cozinha", "Balcão", "Salão", "Almoxarifado" }));
        cbTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipo1ActionPerformed(evt);
            }
        });

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Setor", "Produto", "Unid. Med.", "Qtde  Solicitada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedido.getTableHeader().setReorderingAllowed(false);
        tblPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPedidoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPedido);

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Tipo Produto" }));
        cbTipo.setEnabled(false);
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

        txtMedida.setEditable(false);
        txtMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedidaActionPerformed(evt);
            }
        });

        txtQtdAtual.setEditable(false);

        txtQtdAjuste.setEditable(false);
        txtQtdAjuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdAjusteActionPerformed(evt);
            }
        });
        txtQtdAjuste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtdAjusteKeyTyped(evt);
            }
        });

        txtData.setEditable(false);
        txtData.setBackground(new java.awt.Color(255, 255, 204));
        txtData.setForeground(new java.awt.Color(51, 102, 255));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Dt. Movto:");

        lbl_data1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data1.setText("Tipo Produto:");

        lbl_data2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data2.setText("Produto:");

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Unid. Med.");

        lbl_data4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data4.setText("Qtde Atual:");

        lbl_data5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data5.setText("Qtde Requis:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_data5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtQtdAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFechar1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data2)
                                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_data))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_data6)
                                            .addComponent(cbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data1)
                                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_data3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_data4)
                                            .addComponent(txtQtdAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sep_tabela1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_data)
                            .addComponent(lbl_data1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(lbl_data5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtdAjuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_tabela1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Deseja sair", "Sair", JOptionPane.YES_NO_OPTION)) {
            case 0:
                this.dispose();
                break;
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar1ActionPerformed
        // TODO add your handling code here:
        if (txtQtdAjuste.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entre com a quantidade!");
            txtQtdAjuste.requestFocus();
        } else {
            if(RequisicaoMercadoriaController.controleAjusteEstoque(populaAjuste())){                
                modeloTabela.addRow(new Object[]{cbTipo1.getSelectedItem(), cbProduto.getSelectedItem(), txtMedida.getText(), txtQtdAjuste.getText()});
                cbTipo.setSelectedIndex(0);
                cbTipo1.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btnFechar1ActionPerformed

    private void cbTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipo1ActionPerformed
        // TODO add your handling code here:        
        if(cbTipo1.getSelectedIndex()>0){
            limpaCampos();
            cbTipo.setEnabled(true);
            cbTipo.setSelectedIndex(0);
        }else{
            cbTipo.setSelectedIndex(0);
            cbTipo.setEnabled(false);
            limpaCampos();
        }
    }//GEN-LAST:event_cbTipo1ActionPerformed

    private void tblPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMousePressed

    }//GEN-LAST:event_tblPedidoMousePressed

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

    private void txtMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedidaActionPerformed

    private void txtQtdAjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdAjusteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdAjusteActionPerformed

    private void txtQtdAjusteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdAjusteKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321,.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtQtdAjusteKeyTyped

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFechar1;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JComboBox cbTipo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JLabel lbl_data2;
    private javax.swing.JLabel lbl_data3;
    private javax.swing.JLabel lbl_data4;
    private javax.swing.JLabel lbl_data5;
    private javax.swing.JLabel lbl_data6;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JSeparator sep_tabela1;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtMedida;
    private javax.swing.JTextField txtQtdAjuste;
    private javax.swing.JTextField txtQtdAtual;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
//        txtEstado.setEditable(false);
//        txaObs.setEditable(valor);
//        txfCEP.setEditable(valor);
//        txfNascimento.setEditable(valor);
//        txfTelCelular.setEditable(valor);
//        txfTelefone.setEditable(valor);
//        txtBairro.setEditable(false);
//        txtCidade.setEditable(false);
//        txtEmail.setEditable(valor);
//        txtNome.setEditable(valor);
//        txtNumero.setEditable(valor);
//        txtRua.setEditable(false);
    }

    final ClienteBean populaClienteBeans() {

        return null;

    }

    final void limpaTudo() {
//        txtEstado.setText("");
//        txaObs.setText("");
//        txfCEP.setText("");
//        txfNascimento.setText("");
//        txfTelCelular.setText("");
//        txfTelefone.setText("");
//        txtBairro.setText("");
//        txtCidade.setText("");
//        txtCodigo.setText("");
//        txtData.setText("");
//        txtEmail.setText("");
//        txtNome.setText("");
//        txtNumero.setText("");
//        txtPesquisar.setText("");
//        txtRua.setText("");
    }

    final void limpaNovo() {
//       txtEstado.setText("");
//        txaObs.setText("");
//        txfCEP.setText("");
//        txfNascimento.setText("");
//        txfTelCelular.setText("");
//        txfTelefone.setText("");
//        txtBairro.setText("");
//        txtCidade.setText("");
//        txtEmail.setText("");
//        txtNome.setText("");
//        txtNumero.setText("");
//        txtPesquisar.setText("");
//        txtRua.setText("");
    }

    public void populaCamposCep() {
        CepBean cepBeans;

//        if (consultaEstoqueController.controleCepValido(cepBeans = consultaEstoqueController.controleCep(txfCEP.getText().replace("-", "")))) {
//            txtBairro.setText(cepBeans.getBairro());
//            txtCidade.setText(cepBeans.getCidade());
//            txtRua.setText(cepBeans.getEndereco());
//            txtEstado.setText(cepBeans.getEstado());
//        }
    }

    public static void main(String args[]) {
//        ClienteView cliente = new ClienteView();
//        cliente.setVisible(true);
    }

    public void populaTipoProduto() {
        listaTipoProd = new ArrayList<>();
        RequisicaoMercadoriaController.controleListaTipoProduto(listaTipoProd);
        for (TipoProdutoBean tipoProdutoBeans : listaTipoProd) {
            cbTipo.addItem(tipoProdutoBeans);
        }
    }

    public void populaListaProduto() {
        if (cbTipo.getSelectedIndex() > 0) {
            listaProduto = new ArrayList<>();
            RequisicaoMercadoriaController.controleDeItens(((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo(), listaProduto);
            cbProduto.addItem("Selecionar Produto");

            for (ProdutoBean prdutoBeans : listaProduto) {
                cbProduto.addItem(prdutoBeans);
            }

        } else {

            cbProduto.setSelectedIndex(0);
        }
    }
    
    public void limpaCampos() {
        txtMedida.setText("");
        txtQtdAjuste.setText("");
        txtQtdAtual.setText("");
    }

    public void populaQuantidadeAtual() {
        if (cbProduto.getSelectedIndex() > 0) {

            long controleQuantidadeAtual = RequisicaoMercadoriaController.controleQuantidadeAtual(((ProdutoBean) modeloProduto.getSelectedItem()).getCodigo());
            txtQtdAtual.setText(String.valueOf(controleQuantidadeAtual));

        }
    }
    
    public RequisicaoMercadoriaBean populaAjuste() {
        requisicaoMercadoriaBean.setTipoMovimento(6);
        requisicaoMercadoriaBean.setQuantidadeMovimento(Long.parseLong(txtQtdAjuste.getText()));
        requisicaoMercadoriaBean.setCodigoFunc(Global.usuario.getCodigoFuncionario());
        requisicaoMercadoriaBean.setDataMovimento(txtData.getText());
        requisicaoMercadoriaBean.setProdutoBean((ProdutoBean) modeloProduto.getSelectedItem());
        requisicaoMercadoriaBean.setCodigoSetor(cbTipo1.getSelectedIndex());
        return requisicaoMercadoriaBean;
    }
}
