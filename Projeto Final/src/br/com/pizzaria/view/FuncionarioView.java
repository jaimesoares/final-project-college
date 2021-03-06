package br.com.pizzaria.view;

import br.com.pizzaria.bean.CargoBean;
import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.FuncionarioBean;
import br.com.pizzaria.controller.FuncionarioController;
import br.com.pizzaria.util.Global;
import br.com.pizzaria.util.ValidaCPF;
import br.com.pizzaria.util.VerificarData;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class FuncionarioView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    MaskFormatter formatoNascimento;
    MaskFormatter formatoCEP;
    MaskFormatter formatoRG;
    FuncionarioBean funcionarioBeans;
    FuncionarioController funcionarioController;
//    DefaultTableModel modelo;
    List<CargoBean> listaCargo;
    ComboBoxModel<CargoBean> modeloCargos;
    String test;

    public FuncionarioView() {
        initComponents();

        habilitarCampos(false);
        funcionarioBeans = new FuncionarioBean();
        funcionarioController = new FuncionarioController();
//        modelo = (DefaultTableModel) tblFuncionario.getModel();
        modeloCargos = cbCargo.getModel();
        populaCargo();
        btnNovoActionPerformed(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        sep_codigo = new javax.swing.JSeparator();
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

            FormatoTelefone = new MaskFormatter("(##)#####-####");

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
        try{        formatoRG = new MaskFormatter("##.###.###-#");    
        }catch (Exception Erro){      
            JOptionPane.showMessageDialog(null, "RG inválida", "ERRO DE FORMATAÇÃO", 0);  }
        txtRg = new JFormattedTextField(formatoRG);
        jButton1 = new javax.swing.JButton();

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

        txtNumero.setBackground(new java.awt.Color(204, 255, 255));
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        lbl_bairro3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro3.setText("CEP:");

        txfTelefone.setBackground(new java.awt.Color(204, 255, 255));
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

        txfNascimento.setBackground(new java.awt.Color(204, 255, 255));
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

        txtNome.setBackground(new java.awt.Color(204, 255, 255));

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

        txtCpf.setBackground(new java.awt.Color(204, 255, 255));
        txtCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCpfFocusLost(evt);
            }
        });
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCpfKeyPressed(evt);
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
        txtPlaca.setEnabled(false);
        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        txtCnh.setEditable(false);
        txtCnh.setEnabled(false);
        txtCnh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCnhKeyTyped(evt);
            }
        });

        lbl_bairro8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro8.setText("CNH:");

        txtMoto.setEditable(false);
        txtMoto.setEnabled(false);

        lbl_bairro9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro9.setText("Modelo Moto:");

        txtEstado.setEditable(false);
        txtEstado.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Manutenção de Funcionário");

        txtRg.setBackground(new java.awt.Color(204, 255, 255));
        txtRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRgKeyTyped(evt);
            }
        });

        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_codigo)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sep_tabela)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bairro4)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bairro5)
                                    .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_rua6)
                                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bairro2)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_bairro)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtBairro))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_rua2)
                                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(66, 66, 66))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_rua3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtEmail))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_data))
                                .addGap(51, 51, 51)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_bairro3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_rua)
                                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_data3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 281, Short.MAX_VALUE))
                                    .addComponent(txtNome))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_telefone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_telefone1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_data2)
                                        .addGap(39, 39, 39))
                                    .addComponent(txfNascimento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar)
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_telefone)
                    .addComponent(lbl_telefone1)
                    .addComponent(lbl_data2))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_bairro4)
                                    .addComponent(lbl_bairro5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_rua6)
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
                .addGap(70, 70, 70)
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
//            txfPesquisar.setEnabled(false);
//            modelo.setNumRows(0);
            txtData.setText(VerificarData.retornoDeDataAtual());
            habilitarCampos(true);
            txtNome.requestFocus();
            limpaNovo();
        } else {

            if (funcionarioController.verificarDados(capturaBeans(), cbCargo.getSelectedIndex(), txfCEP.getText(), txtNumero.getText(), txfNascimento.getText())) {
                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
//                tblFuncionario.setEnabled(true);
//                txfPesquisar.setEnabled(true);

                switch (JOptionPane.showConfirmDialog(null, "Deseja cadastrar usuário de sistema para " + txtNome.getText(), "Cadastro de Usuários", JOptionPane.YES_NO_OPTION)) {
                    case 0:
                        UsuarioView usuarioV = new UsuarioView(txtNome.getText());
                        Global.principal.Desktop.add(usuarioV);
                        Dimension desktopSize = Global.principal.Desktop.getSize();
                        Dimension jInternalFrameSize = usuarioV.getSize();
                        usuarioV.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                                (desktopSize.height - jInternalFrameSize.height) / 2);
                        usuarioV.setVisible(true);
                        break;
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
                verificaEntregador();
//                txfPesquisar.setEnabled(false);
//                modelo.setNumRows(0);
            } else {
                if (funcionarioController.verificarDadosParaEditar(capturaBeans(), cbCargo.getSelectedIndex(), txfCEP.getText(), txtNumero.getText(), txfNascimento.getText())) {
                    btnEditar.setText("Editar");
                    btnFechar.setText("Fechar");
                    btnNovo.setEnabled(true);
                    limpaTudo();
                    habilitarCampos(false);
//                    txfPesquisar.setEnabled(true);
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
//                tblFuncionario.setEnabled(true);
//                txfPesquisar.setEnabled(true);
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
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            populaCamposCep();
//        }
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

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroKeyTyped

    private void txtRgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRgKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtRgKeyTyped

    private void txtCnhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCnhKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCnhKeyTyped

    private void txfCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCEPActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void txfPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPesquisarActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FuncionarioPesquisa pesquisaCliente = new FuncionarioPesquisa(Global.principal, true);
        pesquisaCliente.setVisible(true);
        funcionarioBeans = pesquisaCliente.getFuncionarioBean();
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
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbCargo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_bairro2;
    private javax.swing.JLabel lbl_bairro3;
    private javax.swing.JLabel lbl_bairro4;
    private javax.swing.JLabel lbl_bairro5;
    private javax.swing.JLabel lbl_bairro7;
    private javax.swing.JLabel lbl_bairro8;
    private javax.swing.JLabel lbl_bairro9;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data2;
    private javax.swing.JLabel lbl_data3;
    private javax.swing.JLabel lbl_rua;
    private javax.swing.JLabel lbl_rua2;
    private javax.swing.JLabel lbl_rua3;
    private javax.swing.JLabel lbl_rua6;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JLabel lbl_telefone1;
    private javax.swing.JSeparator sep_codigo;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTextField txfCEP;
    private javax.swing.JTextField txfNascimento;
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
    private javax.swing.JFormattedTextField txtRg;
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

    final FuncionarioBean capturaBeans() {
        funcionarioBeans.setNome(txtNome.getText());
        if (cbCargo.getSelectedIndex() != 0) {
            funcionarioBeans.setCargo(((CargoBean) cbCargo.getSelectedItem()));
        }
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
//        txfPesquisar.setText("");
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
//        txfPesquisar.setText("");
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
        for (CargoBean cargoBeans : listaCargo) {
            cbCargo.addItem(cargoBeans);
        }
    }

    public void populaCamposCep() {
        CepBean cepBeans;

        if (funcionarioController.controleCepValido(cepBeans = funcionarioController.controleCep(txfCEP.getText().replace("-", "")))) {
            txtBairro.setText(cepBeans.getBairro());
            txtCidade.setText(cepBeans.getCidade());
            txtRua.setText(cepBeans.getEndereco());
            txtEstado.setText(cepBeans.getEstado());
        }
    }

    public void verificaEntregador() {
        if (modeloCargos.getSelectedItem().toString().equals("ENTREGADOR")) {
            txtCnh.setEnabled(true);
            txtMoto.setEnabled(true);
            txtPlaca.setEnabled(true);
            txtCnh.setEditable(true);
            txtMoto.setEditable(true);
            txtPlaca.setEditable(true);

        } else {
            txtCnh.setEnabled(false);
            txtMoto.setEnabled(false);
            txtPlaca.setEnabled(false);
            txtCnh.setText("");
            txtMoto.setText("");
            txtPlaca.setText("");
        }
    }

}
