package br.com.pizzaria.view;

import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.controller.PrecoProdutoController;
import br.com.pizzaria.controller.ProdutoController;
import br.com.pizzaria.util.VerificarData;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoView extends javax.swing.JInternalFrame {

    ProdutoBean produtoBeans;
    ProdutoController produtoController;
    DefaultTableModel modeloTabela;
    DecimalFormat formatoDecimal;
    List<TipoProdutoBean> listaTipoProd;
    ComboBoxModel<TipoProdutoBean> modeloTipoProd;
    PrecoProdutoController precoProdutoController;
    ButtonGroup grupoProdAcabPrima;

    ComboBoxModel<String> modeloUnidade;

    public ProdutoView() {
        initComponents();
        modeloTabela = (DefaultTableModel) tblProduto.getModel();
        habilitarCampos(false);
        produtoBeans = new ProdutoBean();
        produtoController = new ProdutoController();
        formatoDecimal = new DecimalFormat("0.00");
        modeloTipoProd = cbTipo.getModel();
        precoProdutoController = new PrecoProdutoController();
        populaTipoProduto();

        grupoProdAcabPrima = new ButtonGroup();
        grupoProdAcabPrima.add(rbMateriaPrima);
        grupoProdAcabPrima.add(rbProdAcabado);

        modeloUnidade = cbUnidadeMedida.getModel();
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
        tblProduto = new javax.swing.JTable();
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
        jPanel1 = new javax.swing.JPanel();
        rbProdAcabado = new javax.swing.JRadioButton();
        rbMateriaPrima = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        cbxProdutoVenda = new javax.swing.JCheckBox();
        lblValor3 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblDescricao4 = new javax.swing.JLabel();
        cbUnidadeMedida = new javax.swing.JComboBox();

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

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.getTableHeader().setReorderingAllowed(false);
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProdutoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);

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

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um tipo de produto" }));
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
        txtData.setBackground(new java.awt.Color(255, 255, 204));
        txtData.setForeground(new java.awt.Color(51, 102, 255));

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data Cadastro:");

        lblDescricao2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao2.setText("Avisa Estoque Mín.:");

        cbAvisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));

        lblDescricao3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao3.setText("Estocavél:");

        cbEstocavel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        rbProdAcabado.setSelected(true);
        rbProdAcabado.setText("Prod. Acabado");

        rbMateriaPrima.setText("Matéria-prima");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbProdAcabado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbMateriaPrima, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {rbMateriaPrima, rbProdAcabado});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbProdAcabado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbMateriaPrima)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        cbxProdutoVenda.setText("Produto de Venda");

        lblValor3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor3.setText("Valor de Venda:");

        txtPreco.setEditable(false);
        txtPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoFocusLost(evt);
            }
        });
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxProdutoVenda)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblValor3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxProdutoVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblDescricao4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao4.setText("Unid. Medida:");

        cbUnidadeMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UN", "KG", "CX", "DZ", "GR", "LT" }));

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblDescricao4)
                            .addComponent(cbUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblDescricao3)
                            .addComponent(cbEstocavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblDescricao2)
                            .addComponent(cbAvisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblValor1)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescricao1)
                                .addGap(124, 124, 124)
                                .addComponent(lblDescricao)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
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
                                .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txaDescricao)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_data)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescricao1)
                            .addComponent(lblDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescricao3)
                            .addComponent(lblValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescricao2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEstocavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAvisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDescricao4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
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
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        if (btnNovo.getText().equals("Novo")) {
            btnNovo.setText("Salvar");
            btnFechar.setText("Cancelar");
            btnEditar.setEnabled(false);
            txfPesquisar.setEnabled(false);
            modeloTabela.setNumRows(0);
            txtData.setText(VerificarData.retornoDeDataAtual());
            habilitarCampos(true);
            txaDescricao.requestFocus();
            limpaNovo();
        } else {

            capturaBeans();
            if (produtoController.verificarDados(capturaBeans(), cbTipo.getSelectedIndex())) {
                precoProdutoController.verificarDados(produtoBeans.getCodigo(), txtPreco.getText());
                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
                tblProduto.setEnabled(true);
                txfPesquisar.setEnabled(true);
                limpaTudo();
                habilitarCampos(false);
            }
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void txfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPesquisarKeyReleased
        modeloTabela.setNumRows(0);
        produtoController.controlePesquisa(txfPesquisar.getText(), modeloTabela);
    }//GEN-LAST:event_txfPesquisarKeyReleased

    private void tblProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMousePressed
        produtoBeans = produtoController.controlePreenchimento(((ProdutoBean) modeloTabela.getValueAt(tblProduto.getSelectedRow(), 0)).getCodigo());

        System.out.println(produtoBeans.getTipoProduto().getDescricao());
        txaDescricao.setText(produtoBeans.getDescricao());
        modeloTipoProd.setSelectedItem(produtoBeans.getTipoProduto());
        txtPreco.setText(String.valueOf(formatoDecimal.format(produtoBeans.getPrecoProduto().getPreco())));
        if (String.valueOf(produtoBeans.getEstocavel()).equals("S")) {
            cbEstocavel.setSelectedIndex(0);
        } else {
            cbEstocavel.setSelectedIndex(1);
        }
        if (String.valueOf(produtoBeans.getAvisaEstoqueMinimo()).equals("S")) {
            cbAvisa.setSelectedIndex(0);
        } else {
            cbAvisa.setSelectedIndex(1);
        }

        if (produtoBeans.getProdAcabadoPrima() == 'P') {
            rbMateriaPrima.setSelected(true);
        } else {
            rbProdAcabado.setSelected(true);
        }

        if (produtoBeans.getVenda() == 'S') {
            cbxProdutoVenda.setSelected(true);
        } else {
            cbxProdutoVenda.setSelected(false);
        }

        txtQtd.setText(String.valueOf(produtoBeans.getQtdMinima()));
        //txtQtdEstoque.setText(String.valueOf(produtoBeans.getQtdSaldoEstoque()));
        txtData.setText(produtoBeans.getDataCad());

        modeloUnidade.setSelectedItem(produtoBeans.getUnidadeMedida());

    }//GEN-LAST:event_tblProdutoMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (txaDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um clinete para editar!");
        } else {
            if (btnEditar.getText().equals("Editar")) {
                btnEditar.setText("Salvar");
                btnFechar.setText("Cancelar");
                btnNovo.setEnabled(false);
                habilitarCampos(true);
                verificaPizza(true);
                txfPesquisar.setEnabled(false);
                modeloTabela.setNumRows(0);
            } else {
                if (produtoController.verificarDadosParaEditar(produtoBeans, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo(), txaDescricao.getText())) {
                    btnEditar.setText("Editar");
                    btnFechar.setText("Fechar");
                    btnNovo.setEnabled(true);
                    limpaTudo();
                    habilitarCampos(false);
                    txfPesquisar.setEnabled(true);
                }
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
                tblProduto.setEnabled(true);
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

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed

        if (cbTipo.isEnabled()) {
            verificaPizza(false);
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void txtPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoFocusLost

    private void txtPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyTyped
        String caracteres = "0987654321,.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtPrecoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbAvisa;
    private javax.swing.JComboBox cbEstocavel;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JComboBox cbUnidadeMedida;
    private javax.swing.JCheckBox cbxProdutoVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblDescricao2;
    private javax.swing.JLabel lblDescricao3;
    private javax.swing.JLabel lblDescricao4;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lblValor3;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JRadioButton rbMateriaPrima;
    private javax.swing.JRadioButton rbProdAcabado;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txaDescricao;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txaDescricao.setEditable(valor);
        cbTipo.setEnabled(valor);
        cbAvisa.setEnabled(valor);
        cbEstocavel.setEnabled(valor);
        txtQtd.setEditable(valor);
        //txtQtdEstoque.setEditable(valor);
        txtPreco.setEditable(valor);
    }

    final ProdutoBean capturaBeans() {

        produtoBeans.setCodigo(Integer.parseInt(produtoController.controleDeCodigo()));
        if (cbTipo.getSelectedIndex() != 0) {
            produtoBeans.setTipoProduto((TipoProdutoBean) cbTipo.getSelectedItem());
        }
        produtoBeans.setDescricao(txaDescricao.getText());
        produtoBeans.setUnidadeMedida((cbUnidadeMedida.getSelectedItem().toString()));
        produtoBeans.setEstocavel((cbEstocavel.getSelectedItem().toString().charAt(0)));
        produtoBeans.setAvisaEstoqueMinimo((cbAvisa.getSelectedItem().toString().charAt(0)));
        if (!txtQtd.getText().isEmpty()) {
            produtoBeans.setQtdMinima(Double.parseDouble(txtQtd.getText()));
        }

        if (rbMateriaPrima.isSelected()) {
            produtoBeans.setProdAcabadoPrima('P');
        } else {
            produtoBeans.setProdAcabadoPrima('A');
        }

        if (cbxProdutoVenda.isSelected()) {
            produtoBeans.setVenda('S');
        }
        produtoBeans.setDataCad(txtData.getText());

        return produtoBeans;
    }

    final ProdutoBean capturaBeanEditar() {

        produtoBeans.setCodigo(Integer.parseInt(produtoController.controleDeCodigo()));
        produtoBeans.setDescricao(txaDescricao.getText());
        produtoBeans.setDataCad(txtData.getText());
        produtoBeans.setEstocavel((cbEstocavel.getSelectedItem().toString().charAt(0)));
//        if (!txtQtdEstoque.getText().equals("")) {
//            produtoBeans.setQtdSaldoEstoque(Double.parseDouble(txtQtdEstoque.getText()));
//        }
        produtoBeans.setAvisaEstoqueMinimo((cbAvisa.getSelectedItem().toString().charAt(0)));
        if (!txtQtd.getText().isEmpty()) {
            produtoBeans.setQtdMinima(Double.parseDouble(txtQtd.getText()));
        }
        if (cbTipo.getSelectedIndex() != 0) {
            produtoBeans.setTipoProduto((TipoProdutoBean) cbTipo.getSelectedItem());
        }
        return produtoBeans;
    }

    final void limpaTudo() {
        txaDescricao.setText("");
        cbTipo.setSelectedIndex(0);
        cbEstocavel.setSelectedIndex(0);
        cbAvisa.setSelectedIndex(0);
        txtQtd.setText("");
//        txtQtdEstoque.setText("");
        txtData.setText("");
        txtPreco.setText("");
    }

    final void limpaNovo() {
        txaDescricao.setText("");
        cbTipo.setSelectedIndex(0);
        cbEstocavel.setSelectedIndex(0);
        cbAvisa.setSelectedIndex(0);
        txtQtd.setText("");
        // txtQtdEstoque.setText("");
        txtPreco.setText("");

    }

    public void populaTipoProduto() {
        listaTipoProd = new ArrayList<>();
        produtoController.controleListaProduto(listaTipoProd);
        for (TipoProdutoBean tipoProdutoBeans : listaTipoProd) {
            cbTipo.addItem(tipoProdutoBeans);
        }
    }

    public void verificaPizza(boolean editar) {
        if (modeloTipoProd.getSelectedItem().toString().equals("Pizza")) {
            cbAvisa.setSelectedIndex(1);
            cbEstocavel.setSelectedIndex(1);
            cbAvisa.setEnabled(false);
            cbEstocavel.setEnabled(false);
        } else {
            cbAvisa.setEnabled(true);
            cbEstocavel.setEnabled(true);
            if (!editar) {
                cbAvisa.setSelectedIndex(0);
                cbEstocavel.setSelectedIndex(0);
            }
        }
    }

}
