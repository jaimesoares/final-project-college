package br.com.pizzaria.view;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.util.VerificarData;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ClienteView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    MaskFormatter formatoNascimento;
    MaskFormatter formatoCEP;
    ClienteBean clienteBeans;
    ClienteController clienteController;
    DefaultTableModel modelo;
    PedidoView frame;

    public ClienteView() {
        initComponents();

        habilitarCampos(false);

        clienteBeans = new ClienteBean();
        clienteController = new ClienteController();
        modelo = (DefaultTableModel) tblCliente.getModel();
        frame = new PedidoView(1);
        frame.setTitle("");

    }

    public ClienteView(PedidoView frame) {
        this.frame = frame;
        initComponents();

        habilitarCampos(false);

        clienteBeans = new ClienteBean();
        clienteController = new ClienteController();
        modelo = (DefaultTableModel) tblCliente.getModel();
        btnNovoActionPerformed(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        txtEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE CLIENTE");
        setPreferredSize(new java.awt.Dimension(680, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        txtNome.setBackground(new java.awt.Color(204, 255, 255));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lbl_rua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua.setText("Endereço:");

        txtBairro.setBackground(new java.awt.Color(255, 255, 204));

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
        txtData.setBackground(new java.awt.Color(255, 255, 204));
        txtData.setForeground(new java.awt.Color(51, 102, 255));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        lbl_data1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data1.setText("Pesquisar:");

        txfTelefone.setBackground(new java.awt.Color(204, 255, 255));
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

        txtCidade.setBackground(new java.awt.Color(255, 255, 204));

        lbl_rua2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua2.setText("Estado:");

        lbl_bairro3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro3.setText("CEP:");

        lbl_data2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data2.setText("Nasc.:");

        lbl_rua3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua3.setText("E-mail:");

        txaObs.setColumns(20);
        txaObs.setLineWrap(true);
        txaObs.setRows(5);
        jScrollPane3.setViewportView(txaObs);

        lbl_rua5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua5.setText("Observação / Referência:");

        txtRua.setBackground(new java.awt.Color(255, 255, 204));

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Número:");

        txtNumero.setBackground(new java.awt.Color(204, 255, 255));
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        txfNascimento.setBackground(new java.awt.Color(204, 255, 255));
        txfNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNascimentoKeyTyped(evt);
            }
        });

        txfCEP.setBackground(new java.awt.Color(204, 255, 255));
        txfCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfCEPFocusLost(evt);
            }
        });
        txfCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCEPActionPerformed(evt);
            }
        });
        txfCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfCEPKeyPressed(evt);
            }
        });

        txtEstado.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Manutenção de Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_codigo)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sep_formulario)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_rua3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEmail))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_telefone1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_data2)
                            .addComponent(txfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bairro2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_bairro3)
                                .addGap(78, 78, 78)
                                .addComponent(lbl_rua))
                            .addComponent(txtCidade))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_bairro))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_rua2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_rua5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_data1))
                .addGap(42, 42, 42)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_bairro3)
                            .addComponent(lbl_rua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_bairro)
                    .addComponent(lbl_bairro2)
                    .addComponent(lbl_rua2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(sep_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        if (txtPesquisar.getText().isEmpty()) {
            modelo.setNumRows(0);

        } else {
            modelo.setNumRows(0);
            clienteController.controlePesquisa(txtPesquisar.getText(), modelo);

        }
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tblClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMousePressed
        clienteBeans = clienteController.controlePreenchimento(Integer.parseInt(modelo.getValueAt(tblCliente.getSelectedRow(), 0).toString()));

        //txtCodigo.setText(clienteBeans.getCodigoCliente() + "");
        txtNome.setText(clienteBeans.getNome());
        txtRua.setText(clienteBeans.getRua());
        txtBairro.setText(clienteBeans.getBairro());
        txfTelefone.setText(clienteBeans.getTelefone());
        txtData.setText(clienteBeans.getDataCadastro());
        txaObs.setText(clienteBeans.getObservacao());
        txfCEP.setText(clienteBeans.getCep() + "");
        txfNascimento.setText(clienteBeans.getAniversario());
        txfTelCelular.setText(clienteBeans.getTelCelular());
        txtCidade.setText(clienteBeans.getCidade());
        txtEstado.setText("SP");
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
            switch (JOptionPane.showConfirmDialog(null, "Deseja sair", "Sair", JOptionPane.YES_NO_OPTION)) {
                case 0:
                    this.dispose();
                    break;
            }
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (btnNovo.getText().equals("Novo")) {
            btnNovo.setText("Salvar");
            btnFechar.setText("Cancelar");
            btnEditar.setEnabled(false);
            txtPesquisar.setEnabled(false);
            modelo.setNumRows(0);
            txtData.setText(VerificarData.retornoDeDataAtual());
            habilitarCampos(true);
            txtNome.requestFocus();
            //txtCodigo.setText(clienteController.controleDeCodigo());
            limpaNovo();
        } else {

            populaClienteBeans();
            if (clienteController.verificarDados(clienteBeans, txfCEP.getText(), txtNumero.getText(), txfNascimento.getText())) {
                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
                tblCliente.setEnabled(true);
                txtPesquisar.setEnabled(true);

                if (frame.getTitle().equalsIgnoreCase("PEDIDO")) {
                    frame.pesquisaCliente(txtNome.getText());
                    frame.setVisible(true);
                    this.dispose();
                }

                limpaTudo();
                habilitarCampos(false);
            }
        }

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um clinete para editar!");
        } else {
            if (btnEditar.getText().equals("Editar")) {
                btnEditar.setText("Salvar");
                btnFechar.setText("Cancelar");
                btnNovo.setEnabled(false);
                habilitarCampos(true);
                txtPesquisar.setEnabled(false);
                modelo.setNumRows(0);
            } else {
                if (clienteController.verificarDadosParaEditar(populaClienteBeans(), txfCEP.getText(), txtNumero.getText(), txfNascimento.getText())) {
                    btnEditar.setText("Editar");
                    btnFechar.setText("Fechar");
                    btnNovo.setEnabled(true);
                    limpaTudo();
                    habilitarCampos(false);
                    txtPesquisar.setEnabled(true);
                }
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

    private void txfCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfCEPFocusLost
        populaCamposCep();
    }//GEN-LAST:event_txfCEPFocusLost

    private void txfCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCEPActionPerformed

    }//GEN-LAST:event_txfCEPActionPerformed

    private void txfCEPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCEPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            populaCamposCep();
        }
    }//GEN-LAST:event_txfCEPKeyPressed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_bairro2;
    private javax.swing.JLabel lbl_bairro3;
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
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextArea txaObs;
    private javax.swing.JFormattedTextField txfCEP;
    private javax.swing.JFormattedTextField txfNascimento;
    private javax.swing.JFormattedTextField txfTelCelular;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JFormattedTextField txtPesquisar;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txtEstado.setEditable(false);
        txaObs.setEditable(valor);
        txfCEP.setEditable(valor);
        txfNascimento.setEditable(valor);
        txfTelCelular.setEditable(valor);
        txfTelefone.setEditable(valor);
        txtBairro.setEditable(false);
        txtCidade.setEditable(false);
        txtEmail.setEditable(valor);
        txtNome.setEditable(valor);
        txtNumero.setEditable(valor);
        txtRua.setEditable(false);
    }

    final ClienteBean populaClienteBeans() {
        clienteBeans.setNome(txtNome.getText());
        clienteBeans.setRua(txtRua.getText());
        clienteBeans.setBairro(txtBairro.getText());
        clienteBeans.setDataCadastro(txtData.getText());
        clienteBeans.setObservacao(txaObs.getText());
        clienteBeans.setAniversario(txfNascimento.getText());
        clienteBeans.setTelCelular(txfTelCelular.getText());
        clienteBeans.setTelefone(txfTelefone.getText());
        //clienteBeans.setCodigoCliente(Integer.parseInt(txtCodigo.getText()));
        clienteBeans.setEmail(txtEmail.getText());
        clienteBeans.setEstado(txtEstado.getText());
        clienteBeans.setCidade(txtCidade.getText());

        return clienteBeans;

    }

    final void limpaTudo() {
        txtEstado.setText("");
        txaObs.setText("");
        txfCEP.setText("");
        txfNascimento.setText("");
        txfTelCelular.setText("");
        txfTelefone.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        //txtCodigo.setText("");
        txtData.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtNumero.setText("");
        txtPesquisar.setText("");
        txtRua.setText("");
    }

    final void limpaNovo() {
        txtEstado.setText("");
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

    public void populaCamposCep() {
        CepBean cepBeans;

        if (clienteController.controleCepValido(cepBeans = clienteController.controleCep(txfCEP.getText().replace("-", "")))) {
            txtBairro.setText(cepBeans.getBairro());
            txtCidade.setText(cepBeans.getCidade());
            txtRua.setText(cepBeans.getEndereco());
            txtEstado.setText(cepBeans.getEstado());
        }
    }

    public static void main(String args[]) {
//        ClienteView cliente = new ClienteView();
//        cliente.setVisible(true);
    }

}
