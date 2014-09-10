package br.com.pizzaria.view;

import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.controller.ProdutoController;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
        lbl_codigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        sep_codigo = new javax.swing.JSeparator();
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
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txaDescricao = new javax.swing.JTextField();
        lblValor1 = new javax.swing.JLabel();
        txtValor1 = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        lbl_data = new javax.swing.JLabel();
        lblDescricao2 = new javax.swing.JLabel();
        cbTipo1 = new javax.swing.JComboBox();

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

        lbl_codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 51, 51));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        lblValor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor.setText("Valor de Compra:");

        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorFocusLost(evt);
            }
        });

        lblValor1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor1.setText("Qtd. Mín. Estoque:");

        txtValor1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValor1FocusLost(evt);
            }
        });

        txtData.setEditable(false);
        txtData.setForeground(new java.awt.Color(51, 102, 255));

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data Cadastro:");

        lblDescricao2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao2.setText("Avisa Estoque Mín.:");

        cbTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Bão" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCodigo)
            .addComponent(sep_codigo)
            .addComponent(sep_formulario)
            .addComponent(sep_pesquisa)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao)
                            .addComponent(lblDescricao2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                            .addComponent(txaDescricao)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblDescricao1)
                                            .addComponent(cbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValor)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValor1)
                                    .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_data1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfPesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFechar)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescricao)
                .addGap(2, 2, 2)
                .addComponent(txaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescricao1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDescricao2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_data)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData)))
                        .addGap(90, 90, 90)))
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
                .addGap(115, 115, 115))
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
            txtCodigo.setText(produtoController.controleDeCodigo());
            limpaNovo();
        } else {

            capturaBeans();
            if (produtoController.verificarDados(capturaBeans(), txtValor.getText())) {
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
        txtCodigo.setText(produtoBeans.getCodigo() + "");
        txaDescricao.setText(produtoBeans.getDescricao());
        txtValor.setText(produtoBeans.getValor() + "");
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
            if (produtoController.verificarDadosParaEditar(capturaBeans(), txtValor.getText())) {
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

    private void txtValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusLost
        try {
            double verifica = Double.parseDouble(txtValor.getText().replace(",", "."));
            txtValor.setText(formatoDecimal.format(verifica).replace(",", "."));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Campo valor deve conter apenas número!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
            txtValor.setText("");
            txtValor.requestFocus();
        }
    }//GEN-LAST:event_txtValorFocusLost

    private void txtValor1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValor1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValor1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JComboBox cbTipo1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblDescricao2;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JSeparator sep_codigo;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField txaDescricao;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValor1;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txaDescricao.setEditable(valor);
        cbTipo.setEnabled(valor);
        txtValor.setEnabled(valor);
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
        produtoBeans.setValor(Double.parseDouble(txtValor.getText()));

        return produtoBeans;
    }

    final void limpaTudo() {
        txaDescricao.setText("");
        cbTipo.setSelectedIndex(0);
        txtCodigo.setText("");
        txtValor.setText("");
    }
//    

    final void limpaNovo() {
        txaDescricao.setText("");
        cbTipo.setSelectedIndex(0);
        txtValor.setText("");

    }

}
