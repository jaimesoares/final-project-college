package br.com.pizzaria.view;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.util.VerificadoresECorretores;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ClienteView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    MaskFormatter formatoNascimento;
    MaskFormatter formatoCEP;
    ClienteBeans clienteBeans;
    ClienteController clienteController;
    DefaultTableModel modelo;
    JFrame frame;

    public ClienteView(JFrame frame) {
        initComponents();
        this.frame = frame;
        habilitarCampos(false);

        clienteBeans = new ClienteBeans();
        clienteController = new ClienteController();
        modelo = (DefaultTableModel) tblCliente.getModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_codigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        sep_codigo = new javax.swing.JSeparator();
        lbl_rua = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lbl_bairro = new javax.swing.JLabel();
        lbl_telefone = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JFormattedTextField();
        lbl_data = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        sep_formulario = new javax.swing.JSeparator();
        lbl_data1 = new javax.swing.JLabel();
        try{

            FormatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelefone = new JFormattedTextField(FormatoTelefone);
        sep_pesquisa = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        sep_tabela = new javax.swing.JSeparator();
        btnNovo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        try{

            FormatoTelefone = new MaskFormatter("(##)#####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelCelular = new JFormattedTextField(FormatoTelefone);
        lbl_telefone1 = new javax.swing.JLabel();
        lbl_bairro2 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lbl_rua2 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        lbl_bairro3 = new javax.swing.JLabel();
        lbl_data2 = new javax.swing.JLabel();
        lbl_rua3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaObs = new javax.swing.JTextArea();
        lbl_rua5 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        lbl_data3 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        try{

            formatoNascimento = new MaskFormatter("##/##/####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);
        }
        txfNascimento = new JFormattedTextField(formatoNascimento);
        try{
            formatoCEP = new MaskFormatter("#####-###");

        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "CEP inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfCEP = new JFormattedTextField(formatoCEP);
        ;

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE CLIENTE");
        setPreferredSize(new java.awt.Dimension(550, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        lbl_codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 51, 51));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        txtNome.setForeground(new java.awt.Color(51, 102, 255));

        lbl_rua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua.setText("Endereço:");

        txtBairro.setForeground(new java.awt.Color(51, 102, 255));

        lbl_bairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro.setText("Bairro:");

        lbl_telefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone.setText("Tel. Fixo:");

        txtPesquisar.setForeground(new java.awt.Color(0, 51, 255));
        txtPesquisar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data:");

        txtData.setEditable(false);
        txtData.setForeground(new java.awt.Color(51, 102, 255));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        lbl_data1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data1.setText("Pesquisar:");

        txfTelefone.setForeground(new java.awt.Color(51, 102, 255));
        txfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTelefoneActionPerformed(evt);
            }
        });
        txfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefoneKeyTyped(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Rua", "Bairro", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txfTelCelular.setForeground(new java.awt.Color(51, 102, 255));
        txfTelCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTelCelularActionPerformed(evt);
            }
        });
        txfTelCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelCelularKeyTyped(evt);
            }
        });

        lbl_telefone1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone1.setText("Celular:");

        lbl_bairro2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro2.setText("Cidade:");

        txtCidade.setForeground(new java.awt.Color(51, 102, 255));

        lbl_rua2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua2.setText("Estado:");

        cbEstado.setForeground(new java.awt.Color(51, 102, 255));
        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SP", " " }));

        lbl_bairro3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro3.setText("CEP:");

        lbl_data2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data2.setText("Nasc.:");

        lbl_rua3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua3.setText("E-mail:");

        txtEmail.setForeground(new java.awt.Color(51, 102, 255));

        txaObs.setColumns(20);
        txaObs.setLineWrap(true);
        txaObs.setRows(5);
        jScrollPane3.setViewportView(txaObs);

        lbl_rua5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua5.setText("Observação:");

        txtRua.setForeground(new java.awt.Color(51, 102, 255));

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Número:");

        txtNumero.setForeground(new java.awt.Color(51, 102, 255));
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        txfNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNascimentoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_codigo)
            .addComponent(sep_formulario, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(sep_pesquisa, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(lbl_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCodigo)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_rua3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEmail))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bairro2)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bairro3)
                                    .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_bairro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_rua2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_data1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_telefone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_telefone1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data2)
                                    .addComponent(txfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_rua)
                                        .addGap(364, 364, 364)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_data3)))
                                    .addComponent(lbl_rua5)
                                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_telefone)
                    .addComponent(lbl_telefone1)
                    .addComponent(lbl_data2))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rua)
                    .addComponent(lbl_data3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_bairro)
                    .addComponent(lbl_bairro3)
                    .addComponent(lbl_bairro2)
                    .addComponent(lbl_rua2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rua3)
                    .addComponent(lbl_data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_rua5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_data1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnFechar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        modelo.setNumRows(0);
        clienteController.controlePesquisa(txtPesquisar.getText(), modelo);
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tblClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMousePressed
        clienteBeans = clienteController.controlePreenchimento(Integer.parseInt(modelo.getValueAt(tblCliente.getSelectedRow(), 0).toString()));
        
        txtCodigo.setText(clienteBeans.getCodigoCliente() + "");
        txtNome.setText(clienteBeans.getNome());
        txtRua.setText(clienteBeans.getRua());
        txtBairro.setText(clienteBeans.getBairro());
        txfTelefone.setText(clienteBeans.getTelefone());
        txtData.setText(clienteBeans.getDataCadastro());
        txaObs.setText(clienteBeans.getObservacao());
        txfCEP.setText(clienteBeans.getCep() + "");
        txfNascimento.setText(clienteBeans.getAniversario());
        txfTelCelular.setText(clienteBeans.getTelCelular());
        txfTelefone.setText(clienteBeans.getTelefone());
        txtEmail.setText(clienteBeans.getEmail());
        txtNumero.setText(clienteBeans.getNumero() + "");
    }//GEN-LAST:event_tblClienteMousePressed

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
                tblCliente.setEnabled(true);
                txtPesquisar.setEnabled(true);
                habilitarCampos(false);
            }
            btnFechar.setText("Fechar");
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (btnNovo.getText().equals("Novo")) {
            btnNovo.setText("Salvar");
            btnFechar.setText("Cancelar");
            btnEditar.setEnabled(false);
            txtPesquisar.setEnabled(false);
            modelo.setNumRows(0);
            txtData.setText(VerificadoresECorretores.retornoDeDataAtual());
            habilitarCampos(true);
            txtNome.requestFocus();
            txtCodigo.setText(clienteController.controleDeCodigo());
            limpaNovo();
        } else {

            populaClienteBeans();
            if (clienteController.verificarDados(clienteBeans, txfCEP.getText(), txtNumero.getText(), txfNascimento.getText())) {
                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
                tblCliente.setEnabled(true);
                txtPesquisar.setEnabled(true);
                limpaTudo();
                habilitarCampos(false);
            }
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (btnEditar.getText().equals("Editar")) {
            btnEditar.setText("Salvar");
            btnFechar.setText("Cancelar");
            btnNovo.setEnabled(false);
            habilitarCampos(true);
        } else {
            if (clienteController.verificarDadosParaEditar(populaClienteBeans(), txfCEP.getText(), txtNumero.getText(), txfNascimento.getText())) {
                btnEditar.setText("Editar");
                btnFechar.setText("Fechar");
                btnNovo.setEnabled(true);
                limpaTudo();
                habilitarCampos(false);
            }
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void txfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefoneActionPerformed

    private void txfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefoneKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txfTelefoneKeyTyped

    private void txfTelCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelCelularActionPerformed

    private void txfTelCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelCelularKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txfTelCelularKeyTyped

    private void txfNascimentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNascimentoKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txfNascimentoKeyTyped

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtNumeroKeyTyped

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_bairro2;
    private javax.swing.JLabel lbl_bairro3;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JLabel lbl_data2;
    private javax.swing.JLabel lbl_data3;
    private javax.swing.JLabel lbl_rua;
    private javax.swing.JLabel lbl_rua2;
    private javax.swing.JLabel lbl_rua3;
    private javax.swing.JLabel lbl_rua5;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JLabel lbl_telefone1;
    private javax.swing.JSeparator sep_codigo;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextArea txaObs;
    private javax.swing.JFormattedTextField txfCEP;
    private javax.swing.JFormattedTextField txfNascimento;
    private javax.swing.JFormattedTextField txfTelCelular;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtPesquisar;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        cbEstado.setEditable(valor);
        txaObs.setEditable(valor);
        txfCEP.setEditable(valor);
        txfNascimento.setEditable(valor);
        txfTelCelular.setEditable(valor);
        txfTelefone.setEditable(valor);
        txtBairro.setEditable(valor);
        txtCidade.setEditable(valor);
        txtEmail.setEditable(valor);
        txtNome.setEditable(valor);
        txtNumero.setEditable(valor);
        txtRua.setEditable(valor);
    }

    final ClienteBeans populaClienteBeans() {
        clienteBeans.setNome(txtNome.getText());
        clienteBeans.setRua(txtRua.getText());
        clienteBeans.setBairro(txtBairro.getText());
        clienteBeans.setDataCadastro(txtData.getText());
        clienteBeans.setObservacao(txaObs.getText());
        //clienteBeans.setCep(Integer.parseInt(txfCEP.getText().replace("-", "")));
        clienteBeans.setAniversario(txfNascimento.getText());
        clienteBeans.setTelCelular(txfTelCelular.getText());
        clienteBeans.setTelefone(txfTelefone.getText());
        clienteBeans.setCodigoCliente(Integer.parseInt(txtCodigo.getText()));
        clienteBeans.setEmail(txtEmail.getText());
        //clienteBeans.setNumero(Integer.parseInt(txtNumero.getText()));

        return clienteBeans;

    }

    final void limpaTudo() {
        cbEstado.setSelectedIndex(0);
        txaObs.setText("");
        txfCEP.setText("");
        txfNascimento.setText("");
        txfTelCelular.setText("");
        txfTelefone.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtCodigo.setText("");
        txtData.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtNumero.setText("");
        txtPesquisar.setText("");
        txtRua.setText("");
    }

    final void limpaNovo() {
        cbEstado.setSelectedIndex(0);
        txaObs.setText("");
        txfCEP.setText("");
        txfNascimento.setText("");
        txfTelCelular.setText("");
        txfTelefone.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtNumero.setText("");
        txtPesquisar.setText("");
        txtRua.setText("");
    }

    public static void main(String args[]) {
//        ClienteView cliente = new ClienteView();
//        cliente.setVisible(true);
    }

}
