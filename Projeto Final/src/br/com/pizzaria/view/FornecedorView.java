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

public class FornecedorView extends javax.swing.JInternalFrame {

    MaskFormatter formatoTelefone;
    MaskFormatter formatoCEP;
    SimpleDateFormat FormatoData;
    Date dataAtual;
    FornecedorBean fornecedorBeans;
    FornecedorController fornecedorController;
    DefaultTableModel modelo;
    List<FornecedorBean> listaFornecedor;

    FornecedorModel list = new FornecedorModel();

    public FornecedorView() {
        initComponents();
        habilitarCampos(false);
        txtData.setText(VerificarData.retornoDeDataAtual());
        btnNovo1.setText("Novo");
         txtData.setEditable(false);
        FormatoData = new SimpleDateFormat("dd/MM/yyyy");

        fornecedorBeans = new FornecedorBean();
        fornecedorController = new FornecedorController();
        modelo = (DefaultTableModel) tblFornecedor.getModel();
        list.listaFornecedor(modelo);
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
        lbl_data1 = new javax.swing.JLabel();
        sep_formulario = new javax.swing.JSeparator();
        sep_pesquisa = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornecedor = new javax.swing.JTable();
        sep_tabela = new javax.swing.JSeparator();
        txfPesquisar = new javax.swing.JFormattedTextField();
        sep_codigo = new javax.swing.JSeparator();
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
        btnEditar1 = new javax.swing.JButton();
        btnFechar1 = new javax.swing.JButton();
        btnRemov = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE FORNECEDOR");
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
        lbl_data.setText("Data Cad.:");

        lbl_rua2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua2.setText("Estado:");

        lbl_data1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data1.setText("Pesquisar:");

        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF/CNPJ", "Contato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFornecedor.getTableHeader().setReorderingAllowed(false);
        tblFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFornecedorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFornecedor);

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

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Número:");

        txtBairro.setBackground(new java.awt.Color(255, 255, 204));

        lbl_bairro2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro2.setText("Cidade:");

        txtRua.setBackground(new java.awt.Color(255, 255, 204));
        txtRua.setText(" ");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

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
        lbl_telefone1.setText("Celular:");

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
        lbl_telefone.setText("Tel. Fixo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPF:", "CNPJ:" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        txtEstado.setBackground(new java.awt.Color(255, 255, 204));

        lbl_bairro1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro1.setText("Contato:");

        jLabel2.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Manutenção de Fornecedor");

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

        btnEditar1.setText("Editar");
        btnEditar1.setToolTipText("Para edita alguma informação de cliente");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        btnFechar1.setText("Fechar");
        btnFechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechar1ActionPerformed(evt);
            }
        });

        btnRemov.setText("Remover");
        btnRemov.setToolTipText("Para edita alguma informação de cliente");
        btnRemov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovActionPerformed(evt);
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
                            .addComponent(lbl_bairro3)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_rua)
                                .addGap(0, 362, Short.MAX_VALUE))
                            .addComponent(txtRua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_bairro2)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_bairro1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtContato)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_bairro)
                                        .addGap(0, 194, Short.MAX_VALUE))
                                    .addComponent(txtBairro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_data)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemov)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_bairro3)
                                        .addComponent(lbl_rua))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_data3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_bairro)
                                    .addComponent(lbl_bairro2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_rua2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_bairro1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(btnNovo1)
                    .addComponent(btnEditar1)
                    .addComponent(btnFechar1)
                    .addComponent(btnRemov))
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFornecedorMousePressed
        int codigo = 0;
        codigo = Integer.parseInt(modelo.getValueAt(tblFornecedor.getSelectedRow(), 0).toString());

        // list.preencherCampos(Integer.parseInt(modelo.getValueAt(tblFornecedor.getSelectedRow(), 0).toString()));
        habilitarCampos(true);
        preencherCampos(codigo);
        table(false);
        btnFechar1.setText("Cancelar");
         txtData.setEditable(false);
    }//GEN-LAST:event_tblFornecedorMousePressed

    private void txfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPesquisarKeyReleased
        modelo.setNumRows(0);
        fornecedorController.controlePesquisa(txfPesquisar.getText(), modelo);

    }//GEN-LAST:event_txfPesquisarKeyReleased

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

        if (btnNovo1.getText().equals("Novo")) {
            btnNovo1.setText("Salvar");
            habilitarCampos(true);
            limpaTudo();
        } else {

            cadastraFornecedor();
            limpaTudo();
            list.listaFornecedor(modelo);
            habilitarCampos(false);

        }


    }//GEN-LAST:event_btnNovo1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed

        FornecedorBean fornecedorBeans = new FornecedorBean();

        int codigo = Integer.parseInt(modelo.getValueAt(tblFornecedor.getSelectedRow(), 0).toString());

        if (txtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para editar!");

        } else {

            if (btnEditar1.getText().equals("Editar")) {

                editarFornecedor(codigo);
                // btnEditar1.setText("Salvar");
                //JOptionPane.showMessageDialog(null, codigo1);
                btnFechar1.setText("Cancelar");
                btnNovo1.setEnabled(false);
                habilitarCampos(false);

                txfPesquisar.setEnabled(false);
                modelo.setNumRows(0);
            } else {
                // JOptionPane.showMessageDialog(null, codigo);
                editarFornecedor(codigo);
                btnEditar1.setText("Editar");
                btnFechar1.setText("Fechar");
                btnNovo1.setEnabled(true);

                limpaTudo();
                habilitarCampos(false);
                txfPesquisar.setEnabled(true);

            }

        }
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnFechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechar1ActionPerformed

        if (btnFechar1.getText().equals("Cancelar")) {
            JOptionPane.showMessageDialog(null, "if");
            table(true);
            modelo.setNumRows(0);
            list.listaFornecedor(modelo);
            btnFechar1.setText("Fechar");
            btnNovo1.setText("Novo");

            limpaTudo();
            if (btnEditar1.getText().equals("Salvar")) {

                btnEditar1.setText("Editar");
            }
            btnNovo1.setEnabled(true);
            habilitarCampos(false);

        } else {
            JOptionPane.showMessageDialog(null, "Else");
            btnNovo1.setText("Novo");
            btnFechar1.setText("Fechar");
            btnEditar1.setEnabled(true);
            tblFornecedor.setEnabled(true);
            txfPesquisar.setEnabled(true);
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

            }
            txtBairro.setEditable(false);
            txtCep.setEditable(false);
            txtCidade.setEditable(false);
            txtRua.setEditable(false);
            txtEstado.setEditable(false);
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
            System.out.println("salvar");
        }

    }//GEN-LAST:event_txtNome2FocusLost

    private void btnRemovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovActionPerformed

        int codigo = Integer.parseInt(modelo.getValueAt(tblFornecedor.getSelectedRow(), 0).toString());
        String in = "Inativo";

        try {

            String SQLUpdate = "UPDATE `pizzaria`.`fornecedor`\n"
                    + "SET `for_status` = 'Inativo'\n"
                    + "WHERE `for_id_fornec` = " + codigo + ";";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);

            //pstm.setString(1, in);
            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));
            table(true);
            modelo.setNumRows(0);
            list.listaFornecedor(modelo);
            limpaTudo();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));

        }


    }//GEN-LAST:event_btnRemovActionPerformed

    private void txfPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPesquisarActionPerformed

    public void cadastraFornecedor() {

        try {
            modelo.setNumRows(0);

            String SQLInsertion = "INSERT INTO `pizzaria`.`fornecedor`\n"
                    + "            (`for_nome`,\n"
                    + "             `for_cod_pfj`,\n"
                    + "             `for_cep`,\n"
                    + "             `for_nro_ender`,\n"
                    + "             `for_email`,\n"
                    + "             `for_tel`,\n"
                    + "             `for_tel_cel`,\n"
                    + "             `for_dt_cad`,\n"
                    + "             `for_contato`,\n"
                    + "             `for_ender`,\n"
                    + "             `for_bairro`,\n"
                    + "             `for_cidade`,\n"
                    + "             `for_estado`,\n"
                    + "             `for_status`)\n"
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
                    + "        ?);";

            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLInsertion);
            pstm.setString(1, txtNome.getText());
            pstm.setString(2, jFormattedTextField2.getText().replace(".", "").replace("-", ""));
            pstm.setString(3, txtCep.getText().replace("-", ""));
            pstm.setInt(4, Integer.parseInt(txtNumero.getText()));
            pstm.setString(5, txtNome2.getText());
            pstm.setString(6, txfTelefone.getText());
            pstm.setString(7, txfTelefone1.getText());
            pstm.setString(8, VerificarData.converteParaSql(txtData.getText()));
            pstm.setString(9, txtContato.getText());
            pstm.setString(10, txtRua.getText());
            pstm.setString(11, txtBairro.getText());
            pstm.setString(12, txtCidade.getText());
            pstm.setString(13, txtEstado.getText());
            pstm.setString(14, "Ativo");

           // JOptionPane.showMessageDialog(null, "terminei a instrução");
            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

            btnNovo1.setText("Novo");
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnFechar1;
    private javax.swing.JButton btnNovo1;
    private javax.swing.JButton btnRemov;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_bairro1;
    private javax.swing.JLabel lbl_bairro2;
    private javax.swing.JLabel lbl_bairro3;
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
    private javax.swing.JTable tblFornecedor;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JFormattedTextField txfTelefone1;
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
        txtBairro.setText("");
        txfTelefone.setText("");
        
        txfTelefone1.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtContato.setText("");
        txtNome2.setText("");
        txtEstado.setText("");
        txtBairro.setText("");
        jFormattedTextField2.setText("");

    }

    final void limpaNovo() {
        txtNome.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txfTelefone.setText("");
    }

    public void table(boolean valor) {

        tblFornecedor.setVisible(valor);
    }

    public void preencherCampos(int codigo) {

        int codigo2 = Integer.parseInt(modelo.getValueAt(tblFornecedor.getSelectedRow(), 0).toString());
        fornecedorBeans.setCodigo(codigo2);

        try {

            String SQLSelection = "select * from fornecedor where for_id_fornec = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {

                txtNome.setText(rs.getString("for_nome"));

                txfTelefone.setText(rs.getString("for_tel"));

                txfTelefone1.setText(rs.getString("for_tel_cel"));

                txtCep.setText(rs.getString("for_cep"));
                txtRua.setText(rs.getString("for_ender"));

                txtNumero.setText(rs.getString("for_nro_ender"));
                txtCidade.setText(rs.getString("for_cidade"));
                txtBairro.setText(rs.getString("for_bairro"));
                txtEstado.setText(rs.getString("for_estado"));

                jFormattedTextField2.setText(rs.getString("for_cod_pfj"));
                txtData.setText(VerificarData.converteParaJAVA(rs.getString("for_dt_cad")));
                txtContato.setText(rs.getString("for_contato"));
                txtNome2.setText(rs.getString("for_email"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public void editarFornecedor(int codigo) {

        try {
            String SQLUpdate = "UPDATE `pizzaria`.`fornecedor`\n"
                    + "SET `for_nome` = ?,\n"
                    + "  `for_cod_pfj` = ?,\n"
                    + "  `for_cep` = ?,\n"
                    + "  `for_nro_ender` = ?,\n"
                    + "  `for_email` = ?,\n"
                    + "  `for_tel` = ?,\n"
                    + "  `for_tel_cel` = ?,\n"
                    + "  `for_dt_cad` = ?,\n"
                    + "  `for_contato` = ?,\n"
                    + "  `for_ender` = ?,\n"
                    + "  `for_bairro` = ?,\n"
                    + "  `for_cidade` = ?,\n"
                    + "  `for_estado` = ?,\n"
                    + "  `for_status` = ?\n"
                    + "WHERE `for_id_fornec` = " + codigo + ";";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate);

            pstm.setString(1, txtNome.getText());
            pstm.setString(2, jFormattedTextField2.getText().replace(".", "").replace("-", ""));
            pstm.setString(3, txtCep.getText().replace("-", ""));
            pstm.setInt(4, Integer.parseInt(txtNumero.getText()));
            pstm.setString(5, txtNome2.getText());
            pstm.setString(6, txfTelefone.getText());
            pstm.setString(7, txfTelefone1.getText());
            pstm.setString(8, VerificarData.converteParaSql(txtData.getText()));
            pstm.setString(9, txtContato.getText());
            pstm.setString(10, txtRua.getText());
            pstm.setString(11, txtBairro.getText());
            pstm.setString(12, txtCidade.getText());
            pstm.setString(13, txtEstado.getText());
            pstm.setString(14, "Ativo");

            pstm.execute();
            ConectaBanco.getConnection().commit();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));

        }

    }
}
