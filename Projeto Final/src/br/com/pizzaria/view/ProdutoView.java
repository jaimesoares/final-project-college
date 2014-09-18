package br.com.pizzaria.view;

import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.controller.ProdutoController;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ProdutoView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    ProdutoBeans produtoBeans;
    ProdutoController produtoController;
    DefaultTableModel modelo;
    DecimalFormat formatoDecimal;

    public ProdutoView() {
        initComponents();
        modelo = (DefaultTableModel) tblFuncionario.getModel();
        habilitarCampos(false);
        produtoBeans = new ProdutoBeans();
        produtoController = new ProdutoController();
        formatoDecimal = new DecimalFormat("0.00");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        lblDescricao = new javax.swing.JLabel();
        txfPesquisar = new javax.swing.JFormattedTextField();
        sep_formulario = new javax.swing.JSeparator();
        lbl_data1 = new javax.swing.JLabel();
        sep_pesquisa = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        sep_tabela = new javax.swing.JSeparator();
        btnEditar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        lblDescricao1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        txaDescricao = new javax.swing.JTextField();
        lblValor1 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        lbl_data = new javax.swing.JLabel();
        lblDescricao2 = new javax.swing.JLabel();
        cbAvisa = new javax.swing.JComboBox();
        lblDescricao3 = new javax.swing.JLabel();
        cbEstocavel = new javax.swing.JComboBox();
        lblValor2 = new javax.swing.JLabel();
        txtQtdEstoque = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE PRODUTO");
        setPreferredSize(new java.awt.Dimension(680, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Habilita o formulário para receber novos dados");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        lblDescricao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao.setText("Descrição:");

        txfPesquisar.setForeground(new java.awt.Color(0, 51, 255));
        txfPesquisar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPesquisarKeyReleased(evt);
            }
        });

        lbl_data1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data1.setText("Pesquisar:");

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFuncionario.getTableHeader().setReorderingAllowed(false);
        tblFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFuncionarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuncionario);

        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Para edita alguma informação de cliente");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lblDescricao1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao1.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Refrigerante", "Pizza" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        lblValor1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor1.setText("Qtd. Mín. Estoque:");

        txtQtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtdFocusLost(evt);
            }
        });

        txtData.setEditable(false);
        txtData.setForeground(new java.awt.Color(51, 102, 255));

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data Cadastro:");

        lblDescricao2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao2.setText("Avisa Estoque Mín.:");

        cbAvisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));

        lblDescricao3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao3.setText("Estocavél:");

        cbEstocavel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));

        lblValor2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor2.setText("Qtd. Estoque:");

        txtQtdEstoque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtdEstoqueFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_formulario)
            .addComponent(sep_pesquisa)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescricao3)
                                    .addComponent(cbEstocavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValor1)
                                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbAvisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDescricao2)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescricao1)
                                .addGap(124, 124, 124)
                                .addComponent(lblDescricao)))
                        .addGap(0, 170, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txaDescricao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_data)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValor2)
                                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao1)
                    .addComponent(lblDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescricao3)
                            .addComponent(lblValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescricao2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEstocavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAvisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addComponent(lbl_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData)
                        .addGap(18, 18, 18)
                        .addComponent(sep_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_data1)
                            .addComponent(txfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovo)
                            .addComponent(btnEditar)
                            .addComponent(btnFechar))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblValor2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
//        habilitarCampos(true);
//        txtCodigo.setText(produtoController.controleDeCodigo());
//        limpaNovo();

        if (btnNovo.getText().equals("Novo")) {
            btnNovo.setText("Salvar");
            btnFechar.setText("Cancelar");
            btnEditar.setEnabled(false);
            txfPesquisar.setEnabled(false);
            modelo.setNumRows(0);
            txtData.setText(VerificadoresECorretores.retornoDeDataAtual());
            habilitarCampos(true);
            txaDescricao.requestFocus();
            //txtCodigo.setText(produtoController.controleDeCodigo());
            limpaNovo();
        } else {

            capturaBeans();
            if (produtoController.verificarDados(capturaBeans()/*, txtValor.getText()*/)) {
                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
                tblFuncionario.setEnabled(true);
                txfPesquisar.setEnabled(true);
                limpaTudo();
                habilitarCampos(false);
            }
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void txfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPesquisarKeyReleased
        modelo.setNumRows(0);
        produtoController.controlePesquisa(txfPesquisar.getText(), modelo);
    }//GEN-LAST:event_txfPesquisarKeyReleased

    private void tblFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionarioMousePressed
        produtoBeans = produtoController.controlePreenchimento(Integer.parseInt(modelo.getValueAt(tblFuncionario.getSelectedRow(), 0).toString()));
        //txtCodigo.setText(produtoBeans.getCodigo() + "");
        txaDescricao.setText(produtoBeans.getDescricao());
        //txtValor.setText(produtoBeans.getValor() + "");
        cbTipo.setSelectedItem(produtoBeans.getTipo());

    }//GEN-LAST:event_tblFuncionarioMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//        if (produtoController.verificarDadosParaEditar(capturaBeans(), txtValor.getText())) {
//            limpaTudo();
//            habilitarCampos(false);
//        }

        if (btnEditar.getText().equals("Editar")) {
            btnEditar.setText("Salvar");
            btnFechar.setText("Cancelar");
            btnNovo.setEnabled(false);
            habilitarCampos(true);
        } else {
            if (produtoController.verificarDadosParaEditar(capturaBeans()/*, txtValor.getText()*/)) {
                btnEditar.setText("Editar");
                btnFechar.setText("Fechar");
                btnNovo.setEnabled(true);
                limpaTudo();
                habilitarCampos(false);
            }
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        if (btnFechar.getText().equals("Cancelar")) {
            limpaTudo();
            if (btnEditar.getText().equals("Salvar")) {
                btnEditar.setText("Editar");
                btnNovo.setEnabled(true);
                habilitarCampos(false);
            } else {
                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
                tblFuncionario.setEnabled(true);
                txfPesquisar.setEnabled(true);
                habilitarCampos(false);
            }
            btnFechar.setText("Fechar");
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtQtdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdFocusLost

    private void txtQtdEstoqueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdEstoqueFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdEstoqueFocusLost

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbAvisa;
    private javax.swing.JComboBox cbEstocavel;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblDescricao2;
    private javax.swing.JLabel lblDescricao3;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lblValor2;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField txaDescricao;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtQtdEstoque;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txaDescricao.setEditable(valor);
        cbTipo.setEnabled(valor);
        //txtValor.setEnabled(valor);
    }

//    final void populaClienteBeans() {
//        funcionarioBeans.setNome(txtNome.getText());
////        funcionarioBeans.setCargo(txtRua.getText());
////        funcionarioBeans.setPermissao(txtBairro.getText());
////        funcionarioBeans.setTelefone(txfTelefone.getText());
//        funcionarioBeans.setDataCad(txtData.getText());
//
//    }
//    
    final ProdutoBeans capturaBeans() {

        produtoBeans.setDescricao(txaDescricao.getText());
        produtoBeans.setTipo(cbTipo.getSelectedItem().toString());
        //produtoBeans.setValor(Double.parseDouble(txtValor.getText()));

        return produtoBeans;
    }

    final void limpaTudo() {
        txaDescricao.setText("");
        cbTipo.setSelectedIndex(0);
        //txtCodigo.setText("");
        //txtValor.setText("");
    }
//    

    final void limpaNovo() {
        txaDescricao.setText("");
        cbTipo.setSelectedIndex(0);
        //txtValor.setText("");

    }

}
