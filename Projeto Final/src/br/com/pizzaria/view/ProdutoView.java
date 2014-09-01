package br.com.pizzaria.view;

import br.com.pizzaria.beans.ProdutoBeans;
import br.com.pizzaria.beans.FuncionarioBeans;
import br.com.pizzaria.controller.ProdutoController;
import br.com.pizzaria.controller.FuncionarioController;
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
        modelo = (DefaultTableModel) tblFucnionario.getModel();
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
        tblFucnionario = new javax.swing.JTable();
        sep_tabela = new javax.swing.JSeparator();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLiberar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescricao = new javax.swing.JTextArea();
        lblDescricao1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE FUNCIONARIO");
        setPreferredSize(new java.awt.Dimension(450, 600));
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

        tblFucnionario.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFucnionario.getTableHeader().setReorderingAllowed(false);
        tblFucnionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFucnionarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFucnionario);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setToolTipText("Cadastro de um novo cliente");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Para edita alguma informação de cliente");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnLiberar.setText("Liberar");
        btnLiberar.setToolTipText("Libera os campos para edição");
        btnLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        txaDescricao.setColumns(20);
        txaDescricao.setRows(5);
        jScrollPane2.setViewportView(txaDescricao);

        lblDescricao1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao1.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Refrigerante", "Pizza" }));

        lblValor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor.setText("Valor:");

        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCodigo)
            .addComponent(sep_codigo)
            .addComponent(sep_formulario)
            .addComponent(sep_pesquisa)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep_tabela)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescricao)
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDescricao1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLiberar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFechar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_data1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblValor, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDescricao1)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtValor))
                .addGap(18, 18, 18)
                .addComponent(sep_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_data1)
                    .addComponent(txfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar)
                    .addComponent(btnLiberar)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        habilitarCampos(true);
        txtCodigo.setText(produtoController.controleDeCodigo());
        limpaNovo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (produtoController.verificarDados(capturaBeans(), txtValor.getText())) {
            limpaTudo();
            habilitarCampos(false);
        }


    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPesquisarKeyReleased
        modelo.setNumRows(0);
       produtoController.controlePesquisa(txfPesquisar.getText(), modelo);
    }//GEN-LAST:event_txfPesquisarKeyReleased

    private void tblFucnionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFucnionarioMousePressed
        produtoBeans = produtoController.controlePreenchimento(Integer.parseInt(modelo.getValueAt(tblFucnionario.getSelectedRow(), 0).toString()));
        txtCodigo.setText(produtoBeans.getCodigo() + "");
        txaDescricao.setText(produtoBeans.getDescricao());
        txtValor.setText(produtoBeans.getValor()+"");
        cbTipo.setSelectedItem(produtoBeans.getTipo());

    }//GEN-LAST:event_tblFucnionarioMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (produtoController.verificarDadosParaEditar(capturaBeans(), txtValor.getText())) {
            limpaTudo();
            habilitarCampos(false);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarActionPerformed
        habilitarCampos(true);
    }//GEN-LAST:event_btnLiberarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLiberar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JSeparator sep_codigo;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblFucnionario;
    private javax.swing.JTextArea txaDescricao;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtValor;
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
