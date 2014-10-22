package br.com.pizzaria.view;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.controller.ConsultaMovEstoqueController;
import br.com.pizzaria.controller.ProdutoController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class RequisicaoMercadoria extends javax.swing.JInternalFrame {

    MaskFormatter formatoData;
    ConsultaMovEstoqueController consultaEstoqueController;
    DefaultTableModel modelo;
    ProdutoController produtoController;
    List<ProdutoBean> listaProduto;
    ComboBoxModel<TipoProdutoBean> modeloTipoProd;
    List<TipoProdutoBean> listaTipoProd;
    ComboBoxModel<ProdutoBean> modeloProduto;

    ComboBoxModel<String> modeloProdData;
    List<String> listaProdData;

    public RequisicaoMercadoria() {

        initComponents();
        habilitarCampos(false);
//        modelo = (DefaultTableModel) tblMovimentacaoEstoque.getModel();
//        produtoController = new ProdutoController();
//
//        modeloTipoProd = cbTipo.getModel();
//        modeloProdData = cbData.getModel();
//        modeloProduto = cbProduto.getModel();
//        produtoController = new ProdutoController();

        consultaEstoqueController = new ConsultaMovEstoqueController();

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
        btnFechar1 = new javax.swing.JButton();
        lbl_data = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lbl_data1 = new javax.swing.JLabel();
        lbl_data2 = new javax.swing.JLabel();
        lbl_data3 = new javax.swing.JLabel();
        lbl_data4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        lbl_data5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        lbl_data6 = new javax.swing.JLabel();
        cbTipo1 = new javax.swing.JComboBox();
        sep_tabela1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();

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
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Requisição de Mercadoria");
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

        btnFechar1.setText("Adicionar");
        btnFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar1ActionPerformed(evt);
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

        lbl_data5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data5.setText("Qtde Ajuste:");

        lbl_data6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data6.setText("Setor Solicitante:");

        cbTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Setor" }));
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_data5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_data3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField1))
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_data4)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbl_data1)
                                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sep_tabela1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_data5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFechar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_tabela1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

        this.dispose();

    }//GEN-LAST:event_btnFecharActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
//        if (cbTipo.getSelectedIndex() > 0) {
//            limpaCampos();
//            cbProduto.removeAllItems();
//            populaListaProduto();
//            cbProduto.setEnabled(true);
//        } else {
//            cbProduto.setEnabled(false);
//            cbProduto.setSelectedIndex(0);
//            limpaCampos();
//        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
//        if (cbProduto.getSelectedIndex() > 0) {
//            //txtValor.setText(consultaEstoqueController.controleDeValor(((ProdutoBean) cbProdutos.getSelectedItem()).getCodigo()) + "");
//            limpaCampos();
//            cbData.removeAllItems();
//            populaListaData();
//            cbData.setEnabled(true);
//
//            //txtValorProd.setText(decimalFormato.format(((ProdutoBean) cbProduto.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", "."));
//        } else {
//            cbData.setEnabled(false);
//            cbData.setSelectedIndex(0);
//            limpaCampos();
//        }
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void btnFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFechar1ActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void cbTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipo1ActionPerformed

    private void tblPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMousePressed

    }//GEN-LAST:event_tblPedidoMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFechar1;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JComboBox cbTipo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
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
        consultaEstoqueController.controleListaTipoProduto(listaTipoProd);
        for (TipoProdutoBean tipoProdutoBeans : listaTipoProd) {
            cbTipo.addItem(tipoProdutoBeans);
        }
    }

    public void populaListaProduto() {
        if (cbTipo.getSelectedIndex() > 0) {
            listaProduto = new ArrayList<>();
            // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
            consultaEstoqueController.controleDeItens(((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo(), listaProduto);
            cbProduto.addItem("Selecionar Produto");

            for (ProdutoBean prdutoBeans : listaProduto) {
                cbProduto.addItem(prdutoBeans);
            }

        } else {

            cbProduto.setSelectedIndex(0);
        }
    }

//    public void populaListaData() {
//        if (cbProduto.getSelectedIndex() > 0) {
//            listaProdData = new ArrayList<>();
//            // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
//            consultaEstoqueController.controleListaData(((ProdutoBean) modeloProduto.getSelectedItem()).getCodigo(), listaProdData);
//            cbData.addItem("Selecionar Data");
//
//            for (String data : listaProdData) {
//                cbData.addItem(data);
//            }
//
//        } else {
//
//            cbData.setSelectedIndex(0);
//        }
//    }
//
//    public void populaTabela() {
//        if (cbData.getSelectedIndex() > 0) {
//            consultaEstoqueController.controleTabelaMovimentoEstoque(cbData.getSelectedItem().toString(), ((ProdutoBean) modeloProduto.getSelectedItem()).getCodigo(), modelo, txtSaldoAnterior, txtSaldoAtual);
//        }
//    }
//    
//    public void limpaCampos(){
//        txtSaldoAnterior.setText("");
//        txtSaldoAtual.setText("");
//    }
}
