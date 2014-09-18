package br.com.pizzaria.view;

import br.com.pizzaria.beans.CargoBeans;
import br.com.pizzaria.beans.CepBeans;
import br.com.pizzaria.beans.FuncionarioBeans;
import br.com.pizzaria.controller.FuncionarioController;
import br.com.pizzaria.util.ValidaCPF;
import br.com.pizzaria.util.VerificadoresECorretores;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class FuncionarioView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    MaskFormatter formatoNascimento;
    MaskFormatter formatoCEP;
    FuncionarioBeans funcionarioBeans;
    FuncionarioController funcionarioController;
    DefaultTableModel modelo;
    List<CargoBeans> listaCargo;
    ComboBoxModel<CargoBeans> modeloCargos;

    public FuncionarioView() {
        initComponents();

        habilitarCampos(false);
        funcionarioBeans = new FuncionarioBeans();
        funcionarioController = new FuncionarioController();
        modelo = (DefaultTableModel) tblFuncionario.getModel();
        modeloCargos = (ComboBoxModel) cbCargo.getModel();
        populaCargo();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
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
        txtNumero = new javax.swing.JTextField();
        lbl_bairro3 = new javax.swing.JLabel();
        try{

            FormatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelefone = new JFormattedTextField(FormatoTelefone);
        try{      formatoCEP = new MaskFormatter("#####-###");    }catch(Exception erro){      JOptionPane.showMessageDialog(null, "CEP inválido", "ERRO DE FORMATAÇÃO", 0);  }
        txfCEP = new JFormattedTextField(formatoCEP);  ;
        lbl_rua2 = new javax.swing.JLabel();
        try{        formatoNascimento = new MaskFormatter("##/##/####");    }catch (Exception Erro){      JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);  }
        txfNascimento = new JFormattedTextField(formatoNascimento);
        lbl_data = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lbl_telefone = new javax.swing.JLabel();
        lbl_data2 = new javax.swing.JLabel();
        lbl_rua3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        try{

            FormatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelCelular = new JFormattedTextField(FormatoTelefone);
        lbl_bairro = new javax.swing.JLabel();
        lbl_telefone1 = new javax.swing.JLabel();
        lbl_rua = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        lbl_bairro2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        lbl_data3 = new javax.swing.JLabel();
        lbl_bairro4 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        lbl_bairro5 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lbl_rua6 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox();
        lbl_bairro7 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtCnh = new javax.swing.JTextField();
        lbl_bairro8 = new javax.swing.JLabel();
        txtMoto = new javax.swing.JTextField();
        lbl_bairro9 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE FUNCIONÁRIO");
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

        lbl_bairro3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro3.setText("CEP:");

        txfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefoneKeyTyped(evt);
            }
        });

        txfCEP.setBackground(new java.awt.Color(204, 255, 255));
        txfCEP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txfCEPFocusLost(evt);
            }
        });
        txfCEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txfCEPKeyPressed(evt);
            }
        });

        lbl_rua2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua2.setText("Estado:");

        txfNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNascimentoKeyTyped(evt);
            }
        });

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data Cad.:");

        txtData.setEditable(false);
        txtData.setBackground(new java.awt.Color(255, 255, 204));

        lbl_telefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone.setText("Tel. Fixo:");

        lbl_data2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data2.setText("Nasc.:");

        lbl_rua3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua3.setText("E-mail:");

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

        lbl_bairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro.setText("Bairro:");

        lbl_telefone1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone1.setText("Celular:");

        lbl_rua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua.setText("Endereço:");

        txtCidade.setEditable(false);
        txtCidade.setBackground(new java.awt.Color(255, 255, 204));

        lbl_bairro2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro2.setText("Cidade:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        txtRua.setEditable(false);
        txtRua.setBackground(new java.awt.Color(255, 255, 204));

        txtBairro.setEditable(false);
        txtBairro.setBackground(new java.awt.Color(255, 255, 204));

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Número:");

        lbl_bairro4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro4.setText("CPF:");

        lbl_bairro5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro5.setText("RG:");

        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpfKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });

        lbl_rua6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua6.setText("Função / Cargo:");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma Função / Cargo" }));
        cbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargoActionPerformed(evt);
            }
        });

        lbl_bairro7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro7.setText("Placa Moto:");

        txtPlaca.setEditable(false);
        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        txtCnh.setEditable(false);

        lbl_bairro8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro8.setText("CNH:");

        txtMoto.setEditable(false);

        lbl_bairro9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro9.setText("Modelo Moto:");

        txtEstado.setEditable(false);
        txtEstado.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Manutenção de Funcionário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_codigo)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep_formulario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sep_pesquisa, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbl_data1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_rua3)
                                .addGap(0, 484, Short.MAX_VALUE))
                            .addComponent(txtEmail))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_bairro3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_rua)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtRua))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_bairro)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtBairro))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rua2)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bairro4)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bairro5)
                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rua6)
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bairro7)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bairro8)
                            .addComponent(txtCnh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bairro9)
                            .addComponent(txtMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(175, 175, 175))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_bairro2)
                                .addGap(0, 501, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 281, Short.MAX_VALUE))
                                    .addComponent(txtNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_telefone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_telefone1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_data2)
                                .addGap(39, 39, 39))
                            .addComponent(txfNascimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_data3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_bairro3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_rua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_bairro4)
                            .addComponent(lbl_rua6)
                            .addComponent(lbl_bairro5))
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_bairro7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_bairro8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_bairro9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rua3)
                    .addComponent(lbl_data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(btnEditar)
                    .addComponent(btnFechar))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
//      
        if (btnNovo.getText().equals("Novo")) {
            btnNovo.setText("Salvar");
            btnFechar.setText("Cancelar");
            btnEditar.setEnabled(false);
            txfPesquisar.setEnabled(false);
            modelo.setNumRows(0);
            txtData.setText(VerificadoresECorretores.retornoDeDataAtual());
            habilitarCampos(true);
            txtNome.requestFocus();
            limpaNovo();
        } else {

            if (funcionarioController.verificarDados(capturaBeans(), cbCargo.getSelectedIndex(), txfCEP.getText(), txtNumero.getText(), txfNascimento.getText())) {
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
        funcionarioController.controlePesquisa(txfPesquisar.getText(), modelo);
    }//GEN-LAST:event_txfPesquisarKeyReleased

    private void tblFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionarioMousePressed

        funcionarioBeans = funcionarioController.controlePreenchimento(Integer.parseInt(modelo.getValueAt(tblFuncionario.getSelectedRow(), 0).toString()));

        modeloCargos.setSelectedItem(funcionarioBeans.getCargo());
        txtNome.setText(funcionarioBeans.getNome());
        txtData.setText(funcionarioBeans.getDataCad());
        txtNome.setText(funcionarioBeans.getNome());
        txtRua.setText(funcionarioBeans.getRua());
        txtBairro.setText(funcionarioBeans.getBairro());
        txfTelefone.setText(funcionarioBeans.getTelefone());
        txtData.setText(funcionarioBeans.getDataCad());
        txfCEP.setText(funcionarioBeans.getCep() + "");
        txfNascimento.setText(funcionarioBeans.getNascimento());
        txfTelCelular.setText(funcionarioBeans.getTelCelular());
        txtCidade.setText(funcionarioBeans.getCidade());
        txtEstado.setText("SP");
        txtEmail.setText(funcionarioBeans.getEmail());
        txtNumero.setText(funcionarioBeans.getNumero() + "");
        txtCnh.setText(funcionarioBeans.getCnh());
        txtMoto.setText(funcionarioBeans.getMoto());
        txtPlaca.setText(funcionarioBeans.getPlacaMoto());
        txtCpf.setText(funcionarioBeans.getCpf());
        txtRg.setText(funcionarioBeans.getRg());


    }//GEN-LAST:event_tblFuncionarioMousePressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (btnEditar.getText().equals("Editar")) {
            btnEditar.setText("Salvar");
            btnFechar.setText("Cancelar");
            btnNovo.setEnabled(false);
            habilitarCampos(true);
            verificaEntregador();
        } else {
            if (funcionarioController.verificarDadosParaEditar(capturaBeans(), cbCargo.getSelectedIndex(), txfCEP.getText(), txtNumero.getText(), txfNascimento.getText())) {
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

    private void txfTelCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelCelularActionPerformed

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed
        if (cbCargo.isEnabled()) {
            verificaEntregador();
        }
    }//GEN-LAST:event_cbCargoActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void txfCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfCEPFocusLost
        populaCamposCep();
    }//GEN-LAST:event_txfCEPFocusLost

    private void txfCEPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCEPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            populaCamposCep();
        }
    }//GEN-LAST:event_txfCEPKeyPressed

    private void txfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefoneKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txfTelefoneKeyTyped

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

    private void txtCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCpfFocusLost
        if (ValidaCPF.isCPF(txtCpf.getText())) {
            txtCpf.setText(ValidaCPF.imprimeCPF(txtCpf.getText()));
        } else {
            txtCpf.setText("");
            JOptionPane.showMessageDialog(null, "CPF inválido", "Erro de Preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }//GEN-LAST:event_txtCpfFocusLost

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCpfKeyTyped

    private void txtCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (ValidaCPF.isCPF(txtCpf.getText())) {
                txtCpf.setText(ValidaCPF.imprimeCPF(txtCpf.getText()));
            } else {
                txtCpf.setText("");
                JOptionPane.showMessageDialog(null, "CPF inválido", "Erro de Preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
            }
        }
    }//GEN-LAST:event_txtCpfKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_bairro2;
    private javax.swing.JLabel lbl_bairro3;
    private javax.swing.JLabel lbl_bairro4;
    private javax.swing.JLabel lbl_bairro5;
    private javax.swing.JLabel lbl_bairro7;
    private javax.swing.JLabel lbl_bairro8;
    private javax.swing.JLabel lbl_bairro9;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JLabel lbl_data2;
    private javax.swing.JLabel lbl_data3;
    private javax.swing.JLabel lbl_rua;
    private javax.swing.JLabel lbl_rua2;
    private javax.swing.JLabel lbl_rua3;
    private javax.swing.JLabel lbl_rua6;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JLabel lbl_telefone1;
    private javax.swing.JSeparator sep_codigo;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JTextField txfCEP;
    private javax.swing.JTextField txfNascimento;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JFormattedTextField txfTelCelular;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCnh;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtMoto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        cbCargo.setEnabled(valor);
        txtEstado.setEditable(false);
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
        txtCpf.setEditable(valor);
        txtRg.setEditable(valor);

    }

    final FuncionarioBeans capturaBeans() {
        funcionarioBeans.setNome(txtNome.getText());
        funcionarioBeans.setCargo(((CargoBeans) cbCargo.getSelectedItem()));
        funcionarioBeans.setPermissao(txtEstado.getText());
        funcionarioBeans.setDataCad(txtData.getText());
        funcionarioBeans.setNome(txtNome.getText());
        funcionarioBeans.setRua(txtRua.getText());
        funcionarioBeans.setBairro(txtBairro.getText());
        funcionarioBeans.setNascimento(txfNascimento.getText());
        funcionarioBeans.setTelCelular(txfTelCelular.getText());
        funcionarioBeans.setTelefone(txfTelefone.getText());
        funcionarioBeans.setEmail(txtEmail.getText());
        funcionarioBeans.setEstado(txtEstado.getText());
        funcionarioBeans.setCidade(txtCidade.getText());
        funcionarioBeans.setMoto(txtMoto.getText());
        funcionarioBeans.setPlacaMoto(txtPlaca.getText());
        funcionarioBeans.setCnh(txtCnh.getText());
        funcionarioBeans.setCpf(txtCpf.getText());
        funcionarioBeans.setRg(txtRg.getText());

        return funcionarioBeans;
    }

    final void limpaTudo() {
        txtEstado.setText("");
        txfCEP.setText("");
        txfNascimento.setText("");
        txfTelCelular.setText("");
        txfTelefone.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtData.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtNumero.setText("");
        txfPesquisar.setText("");
        txtRua.setText("");
        cbCargo.setSelectedIndex(0);
        txtCnh.setText("");
        txtMoto.setText("");
        txtPlaca.setText("");
        txtCpf.setText("");
        txtRg.setText("");
    }

    final void limpaNovo() {
        txtNome.setText("");
        cbCargo.setSelectedIndex(0);
        txtEstado.setText("");
        txtEstado.setText("");
        txfCEP.setText("");
        txfNascimento.setText("");
        txfTelCelular.setText("");
        txfTelefone.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEmail.setText("");
        txtNome.setText("");
        txtNumero.setText("");
        txfPesquisar.setText("");
        txtRua.setText("");
        txtCnh.setText("");
        txtMoto.setText("");
        txtPlaca.setText("");
        txtCpf.setText("");
        txtRg.setText("");

    }

    public void populaCargo() {
        listaCargo = new ArrayList<>();
        funcionarioController.controleListaCargo(listaCargo);
        for (CargoBeans cargoBeans : listaCargo) {
            cbCargo.addItem(cargoBeans);
        }
    }

    public void populaCamposCep() {
        CepBeans cepBeans;

        if (funcionarioController.controleCepValido(cepBeans = funcionarioController.controleCep(txfCEP.getText().replace("-", "")))) {
            txtBairro.setText(cepBeans.getBairro());
            txtCidade.setText(cepBeans.getCidade());
            txtRua.setText(cepBeans.getEndereco());
            txtEstado.setText(cepBeans.getEstado());
        }
    }

    public void verificaEntregador() {
        System.out.println(modeloCargos.getSelectedItem());
        if (modeloCargos.getSelectedItem().toString().equals("Entregador")) {
            txtCnh.setEditable(true);
            txtMoto.setEditable(true);
            txtPlaca.setEditable(true);
        } else {
            txtCnh.setEditable(false);
            txtMoto.setEditable(false);
            txtPlaca.setEditable(false);
            txtCnh.setText("");
            txtMoto.setText("");
            txtPlaca.setText("");
        }
    }

}
