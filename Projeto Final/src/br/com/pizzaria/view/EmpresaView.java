package br.com.pizzaria.view;

import br.com.pizzaria.bean.FornecedorBean;
import br.com.pizzaria.controller.FornecedorController;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import br.com.pizzaria.util.ValidaCPF;
import br.com.pizzaria.util.ValidaCNPJ;
import java.util.List;
import br.com.pizzaria.model.FornecedorModel;

public class EmpresaView extends javax.swing.JInternalFrame {

    MaskFormatter formatoTelefone;
    MaskFormatter formatoCEP;
    SimpleDateFormat FormatoData;
    Date dataAtual;
    FornecedorBean fornecedorBeans;
    FornecedorController fornecedorController;
    DefaultTableModel modelo;
    List<FornecedorBean> listaFornecedor;

    FornecedorModel list = new FornecedorModel();

    public EmpresaView() {
        initComponents();
        habilitarCampos(true);
        txtData.setText(VerificarData.retornoDeDataAtual());
        selectEmpresa();
       
        if (txtNome.getText().isEmpty()) {

            
btnNovo1.setText("Salvar");
        }else{
        btnNovo1.setText("Editar");
            
        }
       

       // FormatoData = new SimpleDateFormat("dd/MM/yyyy");
        // fornecedorBeans = new FornecedorBean();
        //fornecedorController = new FornecedorController();
        // modelo = (DefaultTableModel) tblFornecedor.getModel();
        // list.listaFornecedor(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try{

            formatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelefone = new JFormattedTextField(formatoTelefone);
        txtNumero = new javax.swing.JTextField();
        lbl_bairro3 = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        lbl_rua2 = new javax.swing.JLabel();
        lbl_data3 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lbl_bairro2 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        lbl_rua = new javax.swing.JLabel();
        lbl_telefone1 = new javax.swing.JLabel();
        lbl_bairro = new javax.swing.JLabel();
        try{
 
     formatoTelefone = new MaskFormatter("(##)#####-####");
 
 }catch (Exception Erro){
     JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
 }
        txfTelefone1 = new JFormattedTextField(formatoTelefone);
        txtNome2 = new javax.swing.JTextField();
        lbl_rua3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lbl_telefone = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        txtEstado = new javax.swing.JTextField();
        lbl_bairro1 = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        try{      formatoCEP = new MaskFormatter("#####-###");    }catch(Exception erro){      JOptionPane.showMessageDialog(null, "CEP inválido", "ERRO DE FORMATAÇÃO", 0);  }
        txtCep = new JFormattedTextField(formatoCEP);  ;
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        btnNovo1 = new javax.swing.JButton();
        btnFechar1 = new javax.swing.JButton();
        lbl_telefone2 = new javax.swing.JLabel();
        try{

            formatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelefone2 = new JFormattedTextField(formatoTelefone);
        lbl_telefone3 = new javax.swing.JLabel();
        try{
 
     formatoTelefone = new MaskFormatter("(##)#####-####");
 
 }catch (Exception Erro){
     JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
 }
        txfTelefone3 = new JFormattedTextField(formatoTelefone);
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setTitle("CADASTRO DA EMPRESA");
        setPreferredSize(new java.awt.Dimension(680, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        txfTelefone.setBackground(new java.awt.Color(204, 255, 255));
        txfTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefoneKeyTyped(evt);
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

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data Mov.:");

        lbl_rua2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua2.setText("Estado:");

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Número:");

        txtBairro.setBackground(new java.awt.Color(255, 255, 204));

        lbl_bairro2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro2.setText("Cidade:");

        txtRua.setBackground(new java.awt.Color(255, 255, 204));
        txtRua.setText(" ");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome da Empresa:");

        txtNome.setBackground(new java.awt.Color(204, 255, 255));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCidade.setBackground(new java.awt.Color(255, 255, 204));

        lbl_rua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua.setText("Endereço:");

        lbl_telefone1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone1.setText("Celular-1:");

        lbl_bairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro.setText("Bairro:");

        txfTelefone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTelefone1ActionPerformed(evt);
            }
        });
        txfTelefone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefone1KeyTyped(evt);
            }
        });

        txtNome2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNome2FocusLost(evt);
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
        txtData.setBackground(new java.awt.Color(255, 255, 204));
        txtData.setForeground(new java.awt.Color(51, 102, 255));

        lbl_telefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone.setText("Tel. Fixo-1:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPF:", "CNPJ:" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        txtEstado.setBackground(new java.awt.Color(255, 255, 204));

        lbl_bairro1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro1.setText("Site:");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cadastro Empresa");

        txtCep.setBackground(new java.awt.Color(204, 255, 255));
        txtCep.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCepFocusLost(evt);
            }
        });
        txtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCepActionPerformed(evt);
            }
        });
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCepKeyTyped(evt);
            }
        });

        jFormattedTextField2.setBackground(new java.awt.Color(204, 255, 255));
        jFormattedTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField2FocusLost(evt);
            }
        });
        jFormattedTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField2ActionPerformed(evt);
            }
        });
        jFormattedTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField2KeyTyped(evt);
            }
        });

        btnNovo1.setText("Novo");
        btnNovo1.setToolTipText("Habilita o formulário para receber novos dados");
        btnNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovo1ActionPerformed(evt);
            }
        });

        btnFechar1.setText("Fechar");
        btnFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar1ActionPerformed(evt);
            }
        });

        lbl_telefone2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone2.setText("Tel. Fixo-2:");

        txfTelefone2.setBackground(new java.awt.Color(204, 255, 255));
        txfTelefone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTelefone2ActionPerformed(evt);
            }
        });
        txfTelefone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefone2KeyTyped(evt);
            }
        });

        lbl_telefone3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone3.setText("Celular-2:");

        txfTelefone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfTelefone3ActionPerformed(evt);
            }
        });
        txfTelefone3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfTelefone3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(58, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnNovo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFechar1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_telefone))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_telefone1))
                                        .addGap(125, 125, 125)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_telefone2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txfTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_telefone3)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_rua3)
                                        .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(lbl_bairro3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_data3))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lbl_data)
                                                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lbl_bairro2)
                                                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(lbl_bairro)
                                                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGap(18, 18, 18)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(lbl_rua2)
                                                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbl_bairro1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(lbl_rua)
                                                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_bairro3)
                                        .addComponent(lbl_rua))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbl_data3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbl_bairro2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_rua2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_bairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_data)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_bairro1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_rua3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_telefone)
                            .addComponent(lbl_telefone1))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_telefone2)
                            .addComponent(lbl_telefone3))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar1)
                    .addComponent(btnNovo1))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfTelefone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelefone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefone1ActionPerformed

    private void txtNome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome2ActionPerformed

    private void txfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefoneKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();

        }
    }//GEN-LAST:event_txfTelefoneKeyTyped

    private void txfTelefone1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefone1KeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txfTelefone1KeyTyped

    private void txtCepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCepKeyTyped

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroKeyTyped

    private void jFormattedTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jFormattedTextField2KeyTyped

    private void btnNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovo1ActionPerformed

        if (btnNovo1.getText().equals("Salvar")) {

            validaCampos();
            cadastraEmpresa();
            limpaTudo();
            //list.listaFornecedor(modelo);
            habilitarCampos(false);
        } else {
            
            editarEmpresa();

        }


    }//GEN-LAST:event_btnNovo1ActionPerformed

    private void btnFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar1ActionPerformed

        if (btnFechar1.getText().equals("Cancelar")) {
            JOptionPane.showMessageDialog(null, "if");
            table(true);
            modelo.setNumRows(0);
            list.listaFornecedor(modelo);
            btnFechar1.setText("Fechar");
            btnNovo1.setText("Novo");

            limpaTudo();
          

        } else {
            JOptionPane.showMessageDialog(null, "Else");
            btnNovo1.setText("Novo");
            btnFechar1.setText("Fechar");
           
            // tblFornecedor.setEnabled(true);
            //txfPesquisar.setEnabled(true);
            habilitarCampos(false);

            btnFechar1.setText("Fechar");

            this.dispose();
        }

    }//GEN-LAST:event_btnFechar1ActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCepActionPerformed

    private void txtCepFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCepFocusLost

        String SQLSelection = "select "
                + "c.`cep_cod`,"
                + "c.`cep_ender`,"
                + "c.`cep_bai`,"
                + "c.`cep_cid`,"
                + "m.`mun_uf` "
                + "from"
                + "`cep` c "
                + "join municipio m "
                + "on c.`cep_municip` = m.`mun_cod` "
                + "WHERE c.`cep_cod` = ? ;";

        String nada = "00 18 20 34 40 - 63 79 80";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection)) {
            pstm.setString(1, txtCep.getText().substring(0, 5) + txtCep.getText().substring(6, 9));
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                txtBairro.setText(rs.getString("cep_bai"));
                txtCep.setText(rs.getString("cep_cod"));
                txtCidade.setText(rs.getString("cep_cid"));
                txtRua.setText(rs.getString("cep_ender"));
                txtEstado.setText(rs.getString("mun_uf"));
            }else{
                JOptionPane.showMessageDialog(null, "CEP não encontrado!");
                txtCep.setFocusable(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }


    }//GEN-LAST:event_txtCepFocusLost

    private void jFormattedTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2ActionPerformed

    private void jFormattedTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField2KeyPressed


    }//GEN-LAST:event_jFormattedTextField2KeyPressed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jFormattedTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField2FocusLost
        if (jComboBox1.getSelectedIndex() == 0) {

            if (ValidaCPF.isCPF(jFormattedTextField2.getText())) {
                jFormattedTextField2.setText(ValidaCPF.imprimeCPF(jFormattedTextField2.getText()));
            } else {
                jFormattedTextField2.setText("");
                JOptionPane.showMessageDialog(null, "CPF inválido", "Erro de Preenchimento", 0, new ImageIcon("imagens/cancelar.png"));
            }
        } else {

            if (ValidaCNPJ.isCNPJ(jFormattedTextField2.getText())) {
                jFormattedTextField2.setText(ValidaCNPJ.imprimeCNPJ(jFormattedTextField2.getText()));
            } else {
                jFormattedTextField2.setText("");
                JOptionPane.showMessageDialog(null, "CNPJ inválido", "Erro de Preenchimento", 0, new ImageIcon("imagens/cancelar.png"));

            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField2FocusLost

    private void txtNome2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNome2FocusLost

        FornecedorBean e = new FornecedorBean();

        String email = txtNome2.getText();

        e.setEmail(email);

        if (fornecedorController.verificaEmail(e)) {
            //System.out.println("salvar");
        }

    }//GEN-LAST:event_txtNome2FocusLost

    private void txfTelefone2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefone2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefone2KeyTyped

    private void txfTelefone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelefone3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefone3ActionPerformed

    private void txfTelefone3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefone3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefone3KeyTyped

    private void txfTelefone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelefone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefone2ActionPerformed

    public void cadastraEmpresa() {

        try {

            String pjf = "";

            if (jComboBox1.getSelectedIndex() == 0) {

                pjf = "Pessoa Física";

            } else {

                pjf = "Pessoa Jurídica";

            }

            String SQLInsertion = "INSERT INTO `pizzaria`.`empresa`\n"
                    + "            (`emp_cod_pfj`,\n"
                    + "             `emp_fis_jur_emp`,\n"
                    + "             `emp_cep`,\n"
                    + "             `emp_raz_emp`,\n"
                    + "             `emp_fantasia_emp`,\n"
                    + "             `emp_nro_ender`,\n"
                    + "             `emp_tel1`,\n"
                    + "             `emp_tel2`,\n"
                    + "             `emp_tel_cel`,\n"
                    + "             `emp_tel_cel2`,\n"
                    + "             `emp_email`,\n"
                    + "             `emp_site`,\n"
                    + "             `emp_dt_movto`,\n"
                    + "             `emp_bairro`,\n"
                    + "             `emp_estado`,\n"
                    + "             `emp_cidade`,\n"
                    + "             `emp_rua`)\n"
                    + "VALUES (?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?,\n"
                    + "        ?);";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);

            pstm.setDouble(1, Double.parseDouble(jFormattedTextField2.getText().replace(".", "").replace("-", "")));
            pstm.setString(2, pjf);
            pstm.setDouble(3, Double.parseDouble(txtCep.getText().replace("-", "")));
            pstm.setString(4, txtNome.getText());
            pstm.setString(5, "PizzariaMama");

            pstm.setInt(6, Integer.parseInt(txtNumero.getText()));

            pstm.setString(7, txfTelefone.getText());
            pstm.setString(8, txfTelefone1.getText());
            pstm.setString(9, txfTelefone2.getText());
            pstm.setString(10, txfTelefone3.getText());
            pstm.setString(11, txtNome2.getText());
            pstm.setString(12, txtContato.getText());
            pstm.setString(13, VerificarData.converteParaSql(txtData.getText()));
            pstm.setString(14, txtBairro.getText());
            pstm.setString(15, txtEstado.getText());
            pstm.setString(16, txtCidade.getText());
            pstm.setString(17, txtRua.getText());

            // JOptionPane.showMessageDialog(null, "terminei a instrução");
            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Empresa Cadastra com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar1;
    private javax.swing.JButton btnNovo1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_bairro1;
    private javax.swing.JLabel lbl_bairro2;
    private javax.swing.JLabel lbl_bairro3;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data3;
    private javax.swing.JLabel lbl_rua;
    private javax.swing.JLabel lbl_rua2;
    private javax.swing.JLabel lbl_rua3;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JLabel lbl_telefone1;
    private javax.swing.JLabel lbl_telefone2;
    private javax.swing.JLabel lbl_telefone3;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JFormattedTextField txfTelefone1;
    private javax.swing.JFormattedTextField txfTelefone2;
    private javax.swing.JFormattedTextField txfTelefone3;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome2;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {

        txtData.setEditable(valor);
        txtNome.setEditable(valor);
        txtRua.setEditable(valor);
        txtBairro.setEditable(valor);
        txfTelefone.setEditable(valor);
        txtCep.setEditable(valor);

    }

    final void populaClienteBeans() {
        fornecedorBeans.setNome(txtNome.getText());
        fornecedorBeans.setEndereco(txtRua.getText());
        fornecedorBeans.setBairro(txtBairro.getText());
        fornecedorBeans.setTelefone(txfTelefone.getText());
        fornecedorBeans.setDataCad(txtData.getText());

    }

    final void limpaTudo() {

        txtNome.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txfTelefone.setText("");
        txtData.setText("");
        txfTelefone1.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtContato.setText("");
        txtNome2.setText("");
        txtEstado.setText("");
        txtBairro.setText("");
        jFormattedTextField2.setText("");
        txfTelefone2.setText("");
        txfTelefone3.setText("");
        
    }

    final void limpaNovo() {
        txtNome.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txfTelefone.setText("");
    }

    public void table(boolean valor) {

        //  tblFornecedor.setVisible(valor);
    }

    public void selectEmpresa() {

        //int codigo2 = Integer.parseInt(modelo.getValueAt(tblFornecedor.getSelectedRow(), 0).toString());
        // fornecedorBeans.setCodigo(codigo2);
        try {

            String SQLSelection = "select * from empresa where emp_id_empresa = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, 1);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {

                jFormattedTextField2.setText(rs.getString("emp_cod_pfj"));

                txtCep.setText("0"+rs.getString("emp_cep"));
                txtNome.setText(rs.getString("emp_raz_emp"));

                txtNumero.setText(rs.getString("emp_nro_ender"));
                txfTelefone.setText(rs.getString("emp_tel1"));
                txfTelefone1.setText(rs.getString("emp_tel2"));
                txfTelefone2.setText(rs.getString("emp_tel_cel"));
                txfTelefone3.setText(rs.getString("emp_tel_cel2"));
                txtNome2.setText(rs.getString("emp_email"));
                txtContato.setText(rs.getString("emp_site"));
                txtBairro.setText(rs.getString("emp_bairro"));
                txtEstado.setText(rs.getString("emp_estado"));
                txtCidade.setText(rs.getString("emp_cidade"));
                txtRua.setText(rs.getString("emp_rua"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public void editarEmpresa() {

               String pjf = "";

            if (jComboBox1.getSelectedIndex() == 0) {

                pjf = "Pessoa Física";

            } else {

                pjf = "Pessoa Jurídica";

            }
            
        try {
            int cod = 1;
            
            String SQLUpdate = "UPDATE `pizzaria`.`empresa`\n"
                    + "SET `emp_cod_pfj` = ?,\n"
                    + "  `emp_fis_jur_emp` = ?,\n"
                    + "  `emp_cep` = ?,\n"
                    + "  `emp_raz_emp` = ?,\n"
                    + "  `emp_fantasia_emp` = ?,\n"
                    + "  `emp_nro_ender` = ?,\n"
                   
                    + "  `emp_tel1` = ?,\n"
                    + "  `emp_tel2` = ?,\n"
                    + "  `emp_tel_cel` = ?,\n"
                    + "  `emp_tel_cel2` = ?,\n"
                    + "  `emp_email` = ?,\n"
                    + "  `emp_site` = ?,\n"
                    + "  `emp_dt_movto` = ?,\n"
                    + "  `emp_bairro` = ?,\n"
                    + "  `emp_estado` = ?,\n"
                    + "  `emp_cidade` = ?,\n"
                    + "  `emp_rua` = ?\n"
                    + "WHERE `emp_id_empresa` ="+cod+"";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);
           
            
              pstm.setDouble(1, Double.parseDouble(jFormattedTextField2.getText().replace(".", "").replace("-", "")));
            pstm.setString(2, pjf);
            pstm.setDouble(3, Double.parseDouble(txtCep.getText().replace("-", "")));
            pstm.setString(4, txtNome.getText());
            pstm.setString(5, "PizzariaMama");

            pstm.setInt(6, Integer.parseInt(txtNumero.getText()));

            pstm.setString(7, txfTelefone.getText());
            pstm.setString(8, txfTelefone1.getText());
            pstm.setString(9, txfTelefone2.getText());
            pstm.setString(10, txfTelefone3.getText());
            pstm.setString(11, txtNome2.getText());
            pstm.setString(12, txtContato.getText());
            pstm.setString(13, VerificarData.converteParaSql(txtData.getText()));
            pstm.setString(14, txtBairro.getText());
            pstm.setString(15, txtEstado.getText());
            pstm.setString(16, txtCidade.getText());
            pstm.setString(17, txtRua.getText());

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));

        }

    }

    public void validaCampos() {

        if (txtNome.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Digite o nome da Empresa");

        }

    }

}
