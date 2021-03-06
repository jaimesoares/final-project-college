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

        produtoBeans = new ProdutoBean();
        produtoController = new ProdutoController();
        formatoDecimal = new DecimalFormat("0.00");
        modeloTipoProd = cbTipo.getModel();
        precoProdutoController = new PrecoProdutoController();

        grupoProdAcabPrima = new ButtonGroup();
        grupoProdAcabPrima.add(rbMateriaPrima);
        grupoProdAcabPrima.add(rbProdAcabado);

        modeloUnidade = cbUnidadeMedida.getModel();
        populaTipoProduto();
        habilitarCampos(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        lblDescricao = new javax.swing.JLabel();
        txfPesquisar = new javax.swing.JFormattedTextField();
        lbl_data1 = new javax.swing.JLabel();
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
        lbingred = new javax.swing.JLabel();
        txaDescricao2 = new javax.swing.JTextField();

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
        txfPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPesquisarActionPerformed(evt);
            }
        });
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
                "Tipo", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
        cbTipo.setEnabled(false);
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        txaDescricao.setEditable(false);

        lblValor1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor1.setText("Qtd. Mín. Estoque:");

        txtQtd.setEditable(false);
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

        cbAvisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        cbAvisa.setEnabled(false);
        cbAvisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAvisaActionPerformed(evt);
            }
        });

        lblDescricao3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDescricao3.setText("Estocavél:");

        cbEstocavel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Não", "Sim" }));
        cbEstocavel.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));

        rbProdAcabado.setSelected(true);
        rbProdAcabado.setText("Prod. Acabado");
        rbProdAcabado.setEnabled(false);
        rbProdAcabado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProdAcabadoActionPerformed(evt);
            }
        });

        rbMateriaPrima.setText("Matéria-prima");
        rbMateriaPrima.setEnabled(false);
        rbMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMateriaPrimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbMateriaPrima)
                    .addComponent(rbProdAcabado))
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
        cbxProdutoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoVendaActionPerformed(evt);
            }
        });

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
        cbUnidadeMedida.setEnabled(false);

        lbingred.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbingred.setText("Ingrediente:");

        txaDescricao2.setEditable(false);
        txaDescricao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txaDescricao2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addComponent(txaDescricao2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addComponent(txaDescricao)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addGap(415, 573, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescricao1)
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
                                    .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbingred))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_data1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPesquisar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblDescricao1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_data1)
                        .addComponent(txfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lbingred)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txaDescricao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                            .addComponent(cbAvisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDescricao4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            //habilitarCampos(true);
            cbTipo.setEnabled(true);
            cbTipo.requestFocus();
            cbTipo.setSelectedIndex(0);

            // limpaNovo();
        } else {

            capturaBeans();
            if (cbxProdutoVenda.isSelected() && txtPreco.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Campo preço deve ser preechido");
            } else if (produtoController.verificarDados(capturaBeans(), cbTipo.getSelectedIndex(), txtPreco.getText())) {

                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
                tblProduto.setEnabled(true);
                txfPesquisar.setEnabled(true);
                limpaTudo();
                habilitarCampos(false);
                cbTipo.setEnabled(false);
            }
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void txfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPesquisarKeyReleased
        modeloTabela.setNumRows(0);
        produtoController.controlePesquisa(txfPesquisar.getText(), modeloTabela);

    }//GEN-LAST:event_txfPesquisarKeyReleased

    private void tblProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMousePressed
        produtoBeans = produtoController.controlePreenchimento(((ProdutoBean) modeloTabela.getValueAt(tblProduto.getSelectedRow(), 1)).getCodigo());

        System.out.println(produtoBeans.getTipoProduto().getDescricao());

        modeloTipoProd.setSelectedItem(produtoBeans.getTipoProduto());
        txtPreco.setText(String.valueOf(formatoDecimal.format(produtoBeans.getPrecoProduto().getPreco())));

        if (produtoBeans.getTipoProduto().getDescricao().equals("Pizza")) {

            txaDescricao2.setVisible(true);
            lbingred.setVisible(true);
            txaDescricao2.setEditable(true);
        } else {

        }

        if (String.valueOf(produtoBeans.getEstocavel()).equals("S")) {
            cbEstocavel.setSelectedIndex(1);
        } else {
            cbEstocavel.setSelectedIndex(0);
        }
        if (String.valueOf(produtoBeans.getAvisaEstoqueMinimo()).equals("S")) {
            cbAvisa.setSelectedIndex(1);
        } else {
            cbAvisa.setSelectedIndex(0);
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
        txaDescricao.setText(produtoBeans.getDescricao());
        txaDescricao2.setText(produtoBeans.getIngredientes());

    }//GEN-LAST:event_tblProdutoMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (txaDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um produto para editar!");
        } else {
            if (btnEditar.getText().equals("Editar")) {
                btnEditar.setText("Salvar");
                btnFechar.setText("Cancelar");
                btnNovo.setEnabled(false);
                habilitarCamposEditar(true);

                txfPesquisar.setEnabled(false);
                modeloTabela.setNumRows(0);

            } else {
                if (produtoController.verificarDadosParaEditar(capturaBeanEditar())) {
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
                tblProduto.setEnabled(true);
                txfPesquisar.setEnabled(true);
                habilitarCampos(false);
                cbTipo.setEnabled(false);
            } else {
                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
                tblProduto.setEnabled(true);
                txfPesquisar.setEnabled(true);
                habilitarCampos(false);
                cbTipo.setEnabled(false);
            }
            btnFechar.setText("Fechar");
        } else {
            switch (JOptionPane.showConfirmDialog(null, "Deseja sair", "Sair", JOptionPane.YES_NO_OPTION)) {
                case 0:
                    this.dispose();
                    break;
            }
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtQtdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtQtdFocusLost

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed

        if (cbTipo.getSelectedIndex() > 0) {
//            habilitarCampos(true);
            verificaPizza(false);

            if (((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getPizza().equals("S")) {

                lbingred.setVisible(true);
                txaDescricao2.setVisible(true);
                txaDescricao2.setEditable(true);
            } else {

                lbingred.setVisible(false);
                txaDescricao2.setVisible(false);
            }

        } else {

            cbUnidadeMedida.setEnabled(false);
            cbUnidadeMedida.setSelectedIndex(0);

            cbEstocavel.setSelectedIndex(0);
            cbEstocavel.setEnabled(false);

            cbAvisa.setSelectedIndex(0);
            cbAvisa.setEnabled(false);

            txtQtd.setEditable(false);
            txtQtd.setText("");

            cbxProdutoVenda.setSelected(false);
            txtPreco.setText("");
            txtPreco.setEditable(false);

            txaDescricao.setEditable(false);
            txaDescricao.setText("");

            rbMateriaPrima.setEnabled(false);
            rbProdAcabado.setEnabled(false);

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

    private void cbxProdutoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoVendaActionPerformed
        // TODO add your handling code here:
        if (cbxProdutoVenda.isSelected()) {
            txtPreco.setEditable(true);
            txtPreco.setText("");
        } else {
            txtPreco.setEditable(false);
            txtPreco.setText("");
        }
    }//GEN-LAST:event_cbxProdutoVendaActionPerformed

    private void cbAvisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAvisaActionPerformed
        // TODO add your handling code here:
        if (cbAvisa.getSelectedIndex() == 0) {
            txtQtd.setEditable(false);
        } else {
            txtQtd.setEditable(true);
        }
    }//GEN-LAST:event_cbAvisaActionPerformed

    private void rbMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMateriaPrimaActionPerformed
        // TODO add your handling code here:
        if (rbMateriaPrima.isSelected()) {
            cbxProdutoVenda.setSelected(false);
            txtQtd.setText("");
        }
    }//GEN-LAST:event_rbMateriaPrimaActionPerformed

    private void rbProdAcabadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProdAcabadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbProdAcabadoActionPerformed

    private void txaDescricao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txaDescricao2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txaDescricao2ActionPerformed

    private void txfPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPesquisarActionPerformed


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
    private javax.swing.JLabel lbingred;
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
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txaDescricao;
    private javax.swing.JTextField txaDescricao2;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txaDescricao.setEditable(valor);
        //cbTipo.setEnabled(valor);
        cbAvisa.setEnabled(valor);
        cbEstocavel.setEnabled(valor);
        cbUnidadeMedida.setEnabled(valor);
        txtQtd.setEditable(valor);
        //txtQtdEstoque.setEditable(valor);
        //txtPreco.setEditable(valor);
        rbMateriaPrima.setEnabled(valor);
        rbProdAcabado.setEnabled(valor);
        cbxProdutoVenda.setEnabled(valor);

        lbingred.setVisible(valor);
        txaDescricao2.setVisible(valor);
    }

    final void habilitarCamposEditar(boolean valor) {
        if (cbTipo.getSelectedItem().toString().equals("Pizza")) {
            txaDescricao.setEditable(valor);
            cbxProdutoVenda.setEnabled(valor);
        } else {

            cbAvisa.setEnabled(valor);
            txaDescricao.setEditable(valor);
            cbxProdutoVenda.setEnabled(valor);
        }
    }

    final ProdutoBean capturaBeans() {

        produtoBeans.setCodigo(Integer.parseInt(produtoController.controleDeCodigo()));
        if (cbTipo.getSelectedIndex() != 0) {
            produtoBeans.setTipoProduto((TipoProdutoBean) cbTipo.getSelectedItem());
        }
        produtoBeans.setDescricao(txaDescricao.getText());
        produtoBeans.setIngredientes(txaDescricao2.getText());
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

        if (cbTipo.getSelectedIndex() != 0) {
            produtoBeans.setTipoProduto((TipoProdutoBean) cbTipo.getSelectedItem());
        }
        produtoBeans.setDescricao(txaDescricao.getText());
        produtoBeans.setUnidadeMedida((cbUnidadeMedida.getSelectedItem().toString()));
        produtoBeans.setEstocavel((cbEstocavel.getSelectedItem().toString().charAt(0)));
        produtoBeans.setAvisaEstoqueMinimo((cbAvisa.getSelectedItem().toString().charAt(0)));
        produtoBeans.setProdAcabadoPrima(rbMateriaPrima.isSelected() ? 'P' : 'A');
        produtoBeans.setIngredientes(txaDescricao2.getText());

        if (!txtQtd.getText().isEmpty()) {
            produtoBeans.setQtdMinima(Double.parseDouble(txtQtd.getText()));
        }

        if (cbxProdutoVenda.isSelected()) {
            produtoBeans.setVenda('S');
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
        if (((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getPizza().equals("S")) {

            lbingred.setVisible(true);
            txaDescricao2.setVisible(true);

            cbAvisa.setSelectedIndex(0);
            cbAvisa.setEnabled(false);

            cbEstocavel.setSelectedIndex(0);
            cbEstocavel.setEnabled(false);

            cbUnidadeMedida.setEnabled(false);
            cbUnidadeMedida.setSelectedIndex(0);

            txtQtd.setEditable(false);
            txtQtd.setText("");

            cbxProdutoVenda.setSelected(true);
            cbxProdutoVenda.setEnabled(true);

            txaDescricao.setEditable(true);
            txaDescricao.setText("");

            txtPreco.setEditable(true);
            txtPreco.setText("");

            rbProdAcabado.setSelected(true);
            rbProdAcabado.setEnabled(true);

            txaDescricao2.setEditable(true);
            txaDescricao2.setText("");

        } else {
            cbAvisa.setSelectedIndex(0);
            cbAvisa.setEnabled(true);

            cbEstocavel.setSelectedIndex(0);
            cbEstocavel.setEnabled(true);

            cbUnidadeMedida.setSelectedIndex(0);
            cbUnidadeMedida.setEnabled(true);

            txtQtd.setText("");

            cbxProdutoVenda.setSelected(true);
            cbxProdutoVenda.setEnabled(true);

            txtPreco.setText("");
            txtPreco.setEditable(true);

            txaDescricao.setEditable(true);
            txaDescricao.setText("");

            rbMateriaPrima.setEnabled(true);
            rbProdAcabado.setEnabled(true);
        }
    }

}
