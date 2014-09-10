package br.com.pizzaria.view;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.controller.ClienteController;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class FornecedorView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    SimpleDateFormat FormatoData;
    Date DataAtual;
    ClienteBeans clienteBeans;
    ClienteController clienteController;
    DefaultTableModel modelo;

    public FornecedorView() {
        initComponents();
        habilitarCampos(false);
        FormatoData = new SimpleDateFormat("dd/MM/yyyy");

        clienteBeans = new ClienteBeans();
        clienteController = new ClienteController();
//        modelo = (DefaultTableModel) tblCliente.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFechar = new javax.swing.JButton();
        txtBairro6 = new javax.swing.JTextField();
        try{

            FormatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelefone = new JFormattedTextField(FormatoTelefone);
        txtBairro3 = new javax.swing.JTextField();
        txtBairro5 = new javax.swing.JTextField();
        lbl_bairro3 = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        lbl_rua2 = new javax.swing.JLabel();
        lbl_data1 = new javax.swing.JLabel();
        sep_formulario = new javax.swing.JSeparator();
        sep_pesquisa = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFucnionario = new javax.swing.JTable();
        sep_tabela = new javax.swing.JSeparator();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLiberar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        lbl_codigo = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        txfPesquisar = new javax.swing.JFormattedTextField();
        sep_codigo = new javax.swing.JSeparator();
        lbl_data3 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lbl_bairro2 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtBairro2 = new javax.swing.JTextField();
        lbl_rua = new javax.swing.JLabel();
        lbl_telefone1 = new javax.swing.JLabel();
        lbl_bairro = new javax.swing.JLabel();
        try{

            FormatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelefone1 = new JFormattedTextField(FormatoTelefone);
        txtNome2 = new javax.swing.JTextField();
        lbl_rua3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lbl_telefone = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        txtEstado = new javax.swing.JTextField();
        lbl_bairro1 = new javax.swing.JLabel();
        txtBairro1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE FORNECEDOR");
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

        txtBairro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairro3ActionPerformed(evt);
            }
        });

        lbl_bairro3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro3.setText("CEP:");

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data Cad.:");

        lbl_rua2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua2.setText("Estado:");

        lbl_data1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data1.setText("Pesquisar:");

        tblFucnionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Cargo", "Permissão"
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

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 51, 51));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbl_codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Código");

        btnNovo.setText("Novo");
        btnNovo.setToolTipText("Habilita o formulário para receber novos dados");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        txfPesquisar.setForeground(new java.awt.Color(0, 51, 255));
        txfPesquisar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPesquisarKeyReleased(evt);
            }
        });

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Número:");

        lbl_bairro2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro2.setText("Cidade:");

        txtRua.setText(" ");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        lbl_rua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua.setText("Endereço:");

        lbl_telefone1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone1.setText("Celular:");

        lbl_bairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro.setText("Bairro:");

        txfTelefone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTelefone1ActionPerformed(evt);
            }
        });

        txtNome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome2ActionPerformed(evt);
            }
        });

        lbl_rua3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua3.setText("E-mail:");

        txtData.setEditable(false);
        txtData.setForeground(new java.awt.Color(51, 102, 255));

        lbl_telefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone.setText("Tel. Fixo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPF:", "CNPJ:" }));

        lbl_bairro1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro1.setText("Contato:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCodigo)
            .addComponent(sep_codigo)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBairro3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_bairro3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rua)
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBairro5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bairro2)
                            .addComponent(txtBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_bairro1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtBairro1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bairro)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_rua2)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(sep_tabela)
                    .addComponent(sep_formulario)
                    .addComponent(sep_pesquisa)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNome))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone1)))
                    .addComponent(txtNome2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rua3)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBairro6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(lbl_telefone)
                                    .addComponent(lbl_telefone1))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbl_bairro3)
                                            .addComponent(lbl_rua))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBairro3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_data3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bairro)
                                    .addComponent(lbl_bairro2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_rua2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_bairro1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_rua3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(sep_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_data1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar)
                    .addComponent(btnLiberar)
                    .addComponent(btnFechar))
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void tblFucnionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFucnionarioMousePressed
//        funcionarioBeans = funcionarioController.controlePreenchimento(Integer.parseInt(modelo.getValueAt(tblFucnionario.getSelectedRow(), 0).toString()));
//        txtCodigo.setText(funcionarioBeans.getCodigo() + "");
//        txtNome.setText(funcionarioBeans.getNome());
//        cbCargo.setSelectedItem(funcionarioBeans.getCargo());
//        cbPermissao.setSelectedItem(funcionarioBeans.getPermissao());
//        txtData.setText(funcionarioBeans.getDataCad());
    }//GEN-LAST:event_tblFucnionarioMousePressed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
//        if (funcionarioController.verificarDados(capturaBeans(), cbCargo.getSelectedIndex(), cbPermissao.getSelectedIndex())) {
//            limpaTudo();
//            habilitarCampos(false);
//        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//        if (funcionarioController.verificarDadosParaEditar(capturaBeans(), cbCargo.getSelectedIndex(), cbPermissao.getSelectedIndex())) {
//            limpaTudo();
//            habilitarCampos(false);
//        }
        
        //        if (btnEditar.getText().equals("Editar")) {
//            btnEditar.setText("Salvar");
//            btnFechar.setText("Cancelar");
//            btnNovo.setEnabled(false);
//            habilitarCampos(true);
//        } else {
//            if (clienteController.verificarDadosParaEditar(populaClienteBeans())) {
//                btnEditar.setText("Editar");
//                btnFechar.setText("Fechar");
//                btnNovo.setEnabled(true);
//                limpaTudo();
//                habilitarCampos(false);
//            }
//        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarActionPerformed
        habilitarCampos(true);
    }//GEN-LAST:event_btnLiberarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
//        txtData.setText(VerificadoresECorretores.retornoDeDataAtual());
//        habilitarCampos(true);
//        txtNome.requestFocus();
//        txtCodigo.setText(funcionarioController.controleDeCodigo());
//        limpaNovo();
        
//        if (btnNovo.getText().equals("Novo")) {
//            btnNovo.setText("Salvar");
//            btnFechar.setText("Cancelar");
//            btnEditar.setEnabled(false);
//            txtPesquisar.setEnabled(false);
//            modelo.setNumRows(0);
//            txtData.setText(VerificadoresECorretores.retornoDeDataAtual());
//            habilitarCampos(true);
//            txtNome.requestFocus();
//            txtCodigo.setText(clienteController.controleDeCodigo());
//            limpaNovo();
//        } else {
//
//            populaClienteBeans();
//            if (clienteController.verificarDados(clienteBeans)) {
//                btnNovo.setText("Novo");
//                btnFechar.setText("Fechar");
//                btnEditar.setEnabled(true);
//                tblFuncionario.setEnabled(true);
//                txtPesquisar.setEnabled(true);
//                limpaTudo();
//                habilitarCampos(false);
//            }
//        }
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void txfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPesquisarKeyReleased
//        modelo.setNumRows(0);
//        funcionarioController.controlePesquisa(txfPesquisar.getText(), modelo);
    }//GEN-LAST:event_txfPesquisarKeyReleased

    private void txfTelefone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefone1ActionPerformed

    private void txtBairro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairro3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairro3ActionPerformed

    private void txtNome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLiberar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_bairro1;
    private javax.swing.JLabel lbl_bairro2;
    private javax.swing.JLabel lbl_bairro3;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JLabel lbl_data3;
    private javax.swing.JLabel lbl_rua;
    private javax.swing.JLabel lbl_rua2;
    private javax.swing.JLabel lbl_rua3;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JLabel lbl_telefone1;
    private javax.swing.JSeparator sep_codigo;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblFucnionario;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JFormattedTextField txfTelefone1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBairro1;
    private javax.swing.JTextField txtBairro2;
    private javax.swing.JTextField txtBairro3;
    private javax.swing.JTextField txtBairro5;
    private javax.swing.JTextField txtBairro6;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome2;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txtNome.setEditable(valor);
        txtRua.setEditable(valor);
        txtBairro.setEditable(valor);
        txfTelefone.setEditable(valor);
    }

    final void populaClienteBeans() {
        clienteBeans.setNome(txtNome.getText());
        clienteBeans.setRua(txtRua.getText());
        clienteBeans.setBairro(txtBairro.getText());
        clienteBeans.setTelefone(txfTelefone.getText());
        clienteBeans.setDataCadastro(txtData.getText());

    }

    final void limpaTudo() {
        txtNome.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txfTelefone.setText("");
        txtCodigo.setText("");
        txtData.setText("");
    }   
    
    final void limpaNovo() {
        txtNome.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txfTelefone.setText("");
    }   

}
