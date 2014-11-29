/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.view;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.ItemPedidoBean;
import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.bean.PrecoProdutoBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.controller.PedidoController;
import br.com.pizzaria.controller.PrecoProdutoController;
import br.com.pizzaria.controller.ProdutoController;
import br.com.pizzaria.util.CentralizarForm;
import br.com.pizzaria.util.Global;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author katia
 */
public class PedidoView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    ClienteBean clienteBeans;
    ClienteController clienteController;
    List<ClienteBean> listaDeClientes;
    private List<ProdutoBean> listaDeProdutos;
    List<ItemPedidoBean> listaDeItens;
    PedidoBean pedidoBeans;
    PedidoController entregaPedidoController;
    DefaultTableModel modeloDeTabela;
    DecimalFormat decimalFormato;
    DecimalFormat decimalFormatoCodigo;
    int codigoFuncionario;
    Date dataAtual;
    SimpleDateFormat formatoData, formatoHora;
    ButtonGroup grupoPesquisa;
    ButtonGroup grupoPizza;
    MaskFormatter formatoNascimento;
    MaskFormatter formatoCEP;
    PrecoProdutoController precoProdutoController;
    DefaultListModel modeloListaProd;
    ComboBoxModel<PrecoProdutoBean> modeloComboProd;
    ComboBoxModel<TipoProdutoBean> modeloTipoProd;
    ComboBoxModel<TipoProdutoBean> modeloTipoPizza;
    List<TipoProdutoBean> listaTipoProd;
    List<TipoProdutoBean> listaTipoPizza;
    ProdutoController produtoController;
    List<ProdutoBean> listaProduto;

    ComboBoxModel<ProdutoBean> modeloPizzaInteira;
    List<ProdutoBean> listaPizzaInteira;
    ComboBoxModel<ProdutoBean> modeloPizzaSabor1;
    List<ProdutoBean> listaPizzaSabor1;
    ComboBoxModel<ProdutoBean> modeloPizzaSabor2;
    List<ProdutoBean> listaPizzaSabor2;
    ComboBoxModel<ProdutoBean> modeloBorda;
    List<ProdutoBean> listaBorda;
    IngredientesPizzaView ingredienteV;

    /**
     * Creates new form PedidoView
     *
     * @param codigoFuncionario
     */
    public PedidoView(int codigoFuncionario) {
        initComponents();
        this.codigoFuncionario = codigoFuncionario;
        habilitarCampos(false);

        btnFinalizar.setEnabled(false);
        clienteController = new ClienteController();
        clienteBeans = new ClienteBean();
        listaDeClientes = new ArrayList<>();
        listaDeProdutos = new ArrayList<>();
        listaDeItens = new ArrayList<>();
        pnlPai.setEnabledAt(1, false);
        pedidoBeans = new PedidoBean();
        entregaPedidoController = new PedidoController();
        modeloDeTabela = (DefaultTableModel) tblPedido.getModel();
        decimalFormato = new DecimalFormat("0.00");
        decimalFormatoCodigo = new DecimalFormat("0000");
        tblPedido.setSelectionMode(0);
        txtTotal.setEditable(false);
        formatoData = new SimpleDateFormat("yyyy-MM-dd");
        formatoHora = new SimpleDateFormat("HH-mm-ss");

        precoProdutoController = new PrecoProdutoController();
        modeloTipoProd = cbTipo.getModel();
        modeloTipoPizza = cbTipoPizza.getModel();
        produtoController = new ProdutoController();

        populaTipoProduto();
        populaTipoPizza();

        grupoPesquisa = new ButtonGroup();
        grupoPesquisa.add(rbNome);
        grupoPesquisa.add(rbTelefone);
        grupoPesquisa.add(rbEndereco);

        grupoPizza = new ButtonGroup();
        grupoPizza.add(rbInteira);
        grupoPizza.add(rbMeiaPizza);

        modeloPizzaInteira = cbInteira.getModel();
        modeloPizzaSabor1 = cbSabor1.getModel();
        modeloPizzaSabor2 = cbSabor2.getModel();
        modeloBorda = cbBorda.getModel();

//        populaListaPizzaInteira();
//        populaListaPizzaSabor1();
//        populaListaPizzaSabor2();
        populaListaBorda();
        txtCodigo.setText(String.valueOf(decimalFormatoCodigo.format(entregaPedidoController.controleCodigoPedido() + 1)));
        ingredienteV = new IngredientesPizzaView(Global.principal, true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        pnlPai = new javax.swing.JTabbedPane();
        pnlCliente = new javax.swing.JPanel();
        btnContinuarPedido = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        btnNovoCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnBalcao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        sep_formulario = new javax.swing.JSeparator();
        txtEstado = new javax.swing.JTextField();
        try{

            FormatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelefone = new JFormattedTextField(FormatoTelefone);
        lblTelefone = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        lbl_bairro = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        rbTelefone = new javax.swing.JRadioButton();
        lblCep = new javax.swing.JLabel();
        rbNome = new javax.swing.JRadioButton();
        lblNasc = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lbl_rua = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        rbEndereco = new javax.swing.JRadioButton();
        lblObservacao = new javax.swing.JLabel();
        txtObservacao = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        try{

            formatoNascimento = new MaskFormatter("##/##/####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);
        }
        txfNascimento = new JFormattedTextField(formatoNascimento);
        lblNumero = new javax.swing.JLabel();
        try{

            FormatoTelefone = new MaskFormatter("(##)#####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelCelular = new JFormattedTextField(FormatoTelefone);
        txtNumero = new javax.swing.JTextField();
        cbPesquisa = new javax.swing.JComboBox();
        try{
            formatoCEP = new MaskFormatter("#####-###");

        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "CEP inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfCEP = new JFormattedTextField(formatoCEP);
        ;
        btnPesquisar = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        pnlPedido = new javax.swing.JPanel();
        txtCliente = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        btnCancelarPedido = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        lblObservacao1 = new javax.swing.JLabel();
        txtObservacao1 = new javax.swing.JTextField();
        lblFormaPagamento = new javax.swing.JLabel();
        cbFormaPagamento = new javax.swing.JComboBox();
        lblFormaPagamento1 = new javax.swing.JLabel();
        txtValorRecebido = new javax.swing.JTextField();
        lblValor1 = new javax.swing.JLabel();
        txtTroco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        rbInteira = new javax.swing.JRadioButton();
        rbMeiaPizza = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbInteira = new javax.swing.JComboBox();
        cbSabor1 = new javax.swing.JComboBox();
        cbSabor2 = new javax.swing.JComboBox();
        cbBorda = new javax.swing.JComboBox();
        txtValorPizza = new javax.swing.JTextField();
        txtValorDescPizza = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtQtdPizza = new javax.swing.JTextField();
        txtValorSubPizza = new javax.swing.JTextField();
        btnAdicionaPizza = new javax.swing.JButton();
        btnIngredInteira = new javax.swing.JButton();
        lblUsuario2 = new javax.swing.JLabel();
        cbTipoPizza = new javax.swing.JComboBox();
        btnIngredSabor1 = new javax.swing.JButton();
        btnIngredSabor2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblUsuario1 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        lblUsuario = new javax.swing.JLabel();
        cbProduto = new javax.swing.JComboBox();
        lblValor2 = new javax.swing.JLabel();
        txtValorProd = new javax.swing.JTextField();
        lblQuantidade1 = new javax.swing.JLabel();
        txtQuantidadeProd = new javax.swing.JTextField();
        lblValor3 = new javax.swing.JLabel();
        txtValorDescProd = new javax.swing.JTextField();
        cbxGratis = new javax.swing.JCheckBox();
        btnAdicionaProduto = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        btnImprimirCupom = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setClosable(true);
        setTitle("PEDIDO");
        setPreferredSize(new java.awt.Dimension(891, 681));

        btnContinuarPedido.setText("Continuar Pedido");
        btnContinuarPedido.setEnabled(false);
        btnContinuarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarPedidoActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnNovoCliente.setText("Novo Cliente");
        btnNovoCliente.setEnabled(false);
        btnNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoClienteActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jButton1.setText("<html> Pedido<br/> Entrega");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBalcao.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        btnBalcao.setText("<html>\nPedido<br/>\nBalcão");
        btnBalcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalcaoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        sep_formulario.setEnabled(false);

        txtEstado.setEditable(false);
        txtEstado.setBackground(new java.awt.Color(255, 255, 204));
        txtEstado.setEnabled(false);

        txfTelefone.setEditable(false);
        txfTelefone.setEnabled(false);
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

        lblTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTelefone.setText("Tel. Fixo:");
        lblTelefone.setEnabled(false);

        txtRua.setEditable(false);
        txtRua.setBackground(new java.awt.Color(255, 255, 204));
        txtRua.setEnabled(false);

        lbl_bairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro.setText("Bairro:");
        lbl_bairro.setEnabled(false);

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data:");
        lbl_data.setEnabled(false);

        rbTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbTelefone.setText("Telefone");
        rbTelefone.setEnabled(false);

        lblCep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCep.setText("CEP:");
        lblCep.setEnabled(false);

        rbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbNome.setSelected(true);
        rbNome.setText("Nome");
        rbNome.setEnabled(false);

        lblNasc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNasc.setText("Nasc.:");
        lblNasc.setEnabled(false);

        txtData.setEditable(false);
        txtData.setBackground(new java.awt.Color(255, 255, 204));
        txtData.setForeground(new java.awt.Color(51, 102, 255));
        txtData.setEnabled(false);
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        txtEmail.setEditable(false);
        txtEmail.setEnabled(false);

        txtCidade.setEditable(false);
        txtCidade.setBackground(new java.awt.Color(255, 255, 204));
        txtCidade.setEnabled(false);

        lblCidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCidade.setText("Cidade:");
        lblCidade.setEnabled(false);

        txtBairro.setEditable(false);
        txtBairro.setBackground(new java.awt.Color(255, 255, 204));
        txtBairro.setEnabled(false);

        lbl_rua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua.setText("Endereço:");
        lbl_rua.setEnabled(false);

        txtNome.setEditable(false);
        txtNome.setEnabled(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNome.setText("Nome:");
        lblNome.setEnabled(false);

        lblEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEmail.setText("E-mail:");
        lblEmail.setEnabled(false);

        rbEndereco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbEndereco.setText("Endereço");
        rbEndereco.setEnabled(false);

        lblObservacao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblObservacao.setText("Observação:");
        lblObservacao.setEnabled(false);

        txtObservacao.setEditable(false);
        txtObservacao.setEnabled(false);

        lblCelular.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCelular.setText("Celular:");
        lblCelular.setEnabled(false);

        txfNascimento.setEditable(false);
        txfNascimento.setEnabled(false);
        txfNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txfNascimentoKeyTyped(evt);
            }
        });

        lblNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNumero.setText("Número:");
        lblNumero.setEnabled(false);

        txfTelCelular.setEditable(false);
        txfTelCelular.setEnabled(false);
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

        txtNumero.setEditable(false);
        txtNumero.setEnabled(false);
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroKeyTyped(evt);
            }
        });

        cbPesquisa.setEnabled(false);
        cbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPesquisaActionPerformed(evt);
            }
        });

        txfCEP.setEditable(false);
        txfCEP.setBackground(new java.awt.Color(204, 255, 255));
        txfCEP.setEnabled(false);
        txfCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCEPActionPerformed(evt);
            }
        });
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

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setEnabled(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEstado.setText("Estado:");
        lblEstado.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_formulario, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblObservacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservacao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtEmail))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_data)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCelular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNasc)
                            .addComponent(txfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtRua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNumero)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCidade)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCep)
                                .addGap(78, 78, 78)
                                .addComponent(lbl_rua))
                            .addComponent(txtCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_bairro))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstado)))
                    .addComponent(cbPesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbEndereco)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(rbNome)
                    .addComponent(rbTelefone)
                    .addComponent(rbEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblTelefone)
                    .addComponent(lblCelular)
                    .addComponent(lblNasc))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCep)
                            .addComponent(lbl_rua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_bairro)
                    .addComponent(lblCidade)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lbl_data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData))
                .addGap(18, 18, 18)
                .addComponent(sep_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObservacao))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBalcao, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                        .addComponent(btnContinuarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNovoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBalcao, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuarPedido)
                    .addComponent(btnFechar)
                    .addComponent(btnNovoCliente))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pnlPai.addTab("Cliente", pnlCliente);

        txtCliente.setEditable(false);
        txtCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(0, 0, 255));
        txtCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnRemove.setText("Remover Item");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotal.setText("Total:");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 204));

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Vl. Unit", "(+)Borda", "Qtde", "SubTotal", "(-)Vl. Desc", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedido.getTableHeader().setReorderingAllowed(false);
        tblPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPedidoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPedido);
        if (tblPedido.getColumnModel().getColumnCount() > 0) {
            tblPedido.getColumnModel().getColumn(0).setResizable(false);
            tblPedido.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblPedido.getColumnModel().getColumn(1).setResizable(false);
            tblPedido.getColumnModel().getColumn(1).setPreferredWidth(8);
            tblPedido.getColumnModel().getColumn(2).setResizable(false);
            tblPedido.getColumnModel().getColumn(2).setPreferredWidth(8);
            tblPedido.getColumnModel().getColumn(3).setResizable(false);
            tblPedido.getColumnModel().getColumn(3).setPreferredWidth(5);
            tblPedido.getColumnModel().getColumn(4).setResizable(false);
            tblPedido.getColumnModel().getColumn(4).setPreferredWidth(8);
            tblPedido.getColumnModel().getColumn(5).setResizable(false);
            tblPedido.getColumnModel().getColumn(5).setPreferredWidth(8);
            tblPedido.getColumnModel().getColumn(6).setResizable(false);
            tblPedido.getColumnModel().getColumn(6).setPreferredWidth(8);
        }

        btnCancelarPedido.setText("Fechar");
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Enviar Pedido de Venda");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        lblObservacao1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblObservacao1.setText("Observação:");

        lblFormaPagamento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFormaPagamento.setText("Forma Pagto:");

        cbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Escolha forma de Pagamento", "Dinheiro", "Cartão de Crédito", "Cartão de Débito" }));
        cbFormaPagamento.setEnabled(false);
        cbFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFormaPagamentoActionPerformed(evt);
            }
        });

        lblFormaPagamento1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFormaPagamento1.setText("Vlr. Recebido:");

        txtValorRecebido.setBackground(new java.awt.Color(204, 255, 255));
        txtValorRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorRecebidoActionPerformed(evt);
            }
        });
        txtValorRecebido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorRecebidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorRecebidoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtValorRecebidoKeyPressed(evt);
            }
        });

        lblValor1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor1.setText("Troco:");

        txtTroco.setEditable(false);
        txtTroco.setBackground(new java.awt.Color(255, 255, 204));
        txtTroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrocoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("PIZZAS:"));

        rbInteira.setSelected(true);
        rbInteira.setText("Inteira");
        rbInteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInteiraActionPerformed(evt);
            }
        });

        rbMeiaPizza.setText("Meia-a-meia");
        rbMeiaPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMeiaPizzaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Inteira:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Sabor 1:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Sabor 2:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Vlr. Pizza:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Borda:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Vlr. Desc:");

        cbInteira.setEnabled(false);
        cbInteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInteiraActionPerformed(evt);
            }
        });

        cbSabor1.setEnabled(false);
        cbSabor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSabor1ActionPerformed(evt);
            }
        });

        cbSabor2.setEnabled(false);
        cbSabor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSabor2ActionPerformed(evt);
            }
        });

        cbBorda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar borda" }));
        cbBorda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBordaActionPerformed(evt);
            }
        });

        txtValorPizza.setEditable(false);
        txtValorPizza.setBackground(new java.awt.Color(255, 255, 204));

        txtValorDescPizza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorDescPizzaKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Qtde:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Valor:");

        txtQtdPizza.setBackground(new java.awt.Color(204, 255, 255));
        txtQtdPizza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQtdPizzaMouseClicked(evt);
            }
        });
        txtQtdPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdPizzaActionPerformed(evt);
            }
        });
        txtQtdPizza.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtdPizzaKeyTyped(evt);
            }
        });

        txtValorSubPizza.setEditable(false);
        txtValorSubPizza.setBackground(new java.awt.Color(255, 255, 204));
        txtValorSubPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorSubPizzaActionPerformed(evt);
            }
        });

        btnAdicionaPizza.setText("Adicionar Item");
        btnAdicionaPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaPizzaActionPerformed(evt);
            }
        });

        btnIngredInteira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pizzaria/icons/interrogacao.gif"))); // NOI18N
        btnIngredInteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngredInteiraActionPerformed(evt);
            }
        });

        lblUsuario2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario2.setText("Tipo:");

        cbTipoPizza.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Tipo Produto" }));
        cbTipoPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoPizzaActionPerformed(evt);
            }
        });

        btnIngredSabor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pizzaria/icons/interrogacao.gif"))); // NOI18N
        btnIngredSabor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngredSabor1ActionPerformed(evt);
            }
        });

        btnIngredSabor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/pizzaria/icons/interrogacao.gif"))); // NOI18N
        btnIngredSabor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngredSabor2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSabor2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSabor1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rbInteira)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbMeiaPizza)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblUsuario2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTipoPizza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIngredSabor1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnIngredSabor2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorDescPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdicionaPizza))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQtdPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbInteira, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIngredInteira, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbBorda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorSubPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbInteira)
                    .addComponent(rbMeiaPizza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario2))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cbInteira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIngredInteira))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIngredSabor1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSabor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbSabor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIngredSabor2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtValorPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtQtdPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbBorda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtValorSubPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtValorDescPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionaPizza)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnIngredInteira, btnIngredSabor1, cbInteira, cbSabor1, cbSabor2, cbTipoPizza});

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUTOS DIVERSOS:"));

        lblUsuario1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario1.setText("Tipo:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Tipo Produto" }));
        cbTipo.setMinimumSize(new java.awt.Dimension(138, 25));
        cbTipo.setPreferredSize(new java.awt.Dimension(138, 25));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario.setText("Produto:");

        cbProduto.setEnabled(false);
        cbProduto.setMinimumSize(new java.awt.Dimension(138, 25));
        cbProduto.setPreferredSize(new java.awt.Dimension(138, 25));
        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

        lblValor2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor2.setText("Valor:");

        txtValorProd.setEditable(false);
        txtValorProd.setBackground(new java.awt.Color(255, 255, 204));
        txtValorProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorProdActionPerformed(evt);
            }
        });

        lblQuantidade1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQuantidade1.setText("Qtde:");

        txtQuantidadeProd.setBackground(new java.awt.Color(204, 255, 255));
        txtQuantidadeProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQuantidadeProdMouseClicked(evt);
            }
        });
        txtQuantidadeProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeProdActionPerformed(evt);
            }
        });
        txtQuantidadeProd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantidadeProdFocusLost(evt);
            }
        });
        txtQuantidadeProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantidadeProdKeyTyped(evt);
            }
        });

        lblValor3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor3.setText("Vlr. Desc:");

        txtValorDescProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorDescProdKeyTyped(evt);
            }
        });

        cbxGratis.setText("Grátis");
        cbxGratis.setEnabled(false);
        cbxGratis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGratisActionPerformed(evt);
            }
        });

        btnAdicionaProduto.setText("Adicionar Item");
        btnAdicionaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdicionaProduto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsuario)
                            .addComponent(lblUsuario1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTipo, 0, 315, Short.MAX_VALUE)
                            .addComponent(cbProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValor2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblValor3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtValorProd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblQuantidade1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtQuantidadeProd, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtValorDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(cbxGratis)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor2)
                    .addComponent(lblQuantidade1)
                    .addComponent(txtQuantidadeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor3)
                    .addComponent(cbxGratis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionaProduto))
        );

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(0, 0, 255));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        btnImprimirCupom.setText("Imprimir cupom");
        btnImprimirCupom.setEnabled(false);
        btnImprimirCupom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirCupomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPedidoLayout = new javax.swing.GroupLayout(pnlPedido);
        pnlPedido.setLayout(pnlPedidoLayout);
        pnlPedidoLayout.setHorizontalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPedidoLayout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente))
                    .addGroup(pnlPedidoLayout.createSequentialGroup()
                        .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(pnlPedidoLayout.createSequentialGroup()
                                .addComponent(lblFormaPagamento)
                                .addGap(1, 1, 1)
                                .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                                .addComponent(lblFormaPagamento1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValor1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPedidoLayout.createSequentialGroup()
                                .addComponent(lblObservacao1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObservacao1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPedidoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPedidoLayout.createSequentialGroup()
                                        .addComponent(btnRemove)
                                        .addGap(43, 43, 43)
                                        .addComponent(lblTotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPedidoLayout.createSequentialGroup()
                                        .addComponent(btnImprimirCupom)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnFinalizar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelarPedido))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPedidoLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        pnlPedidoLayout.setVerticalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservacao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObservacao1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor1)
                    .addComponent(txtValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormaPagamento1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarPedido)
                    .addComponent(btnFinalizar)
                    .addComponent(btnImprimirCupom))
                .addGap(86, 86, 86))
        );

        pnlPedidoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCliente, txtCodigo});

        pnlPai.addTab("Pedido", pnlPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPai)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPai)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnContinuarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarPedidoActionPerformed
        pnlPai.setEnabledAt(1, true);
        pnlPai.setEnabledAt(0, false);
        pnlPai.setSelectedIndex(1);


    }//GEN-LAST:event_btnContinuarPedidoActionPerformed

    private void btnNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoClienteActionPerformed
        ClienteView clienteV = new ClienteView(this);
        Global.principal.Desktop.add(clienteV);
        Dimension desktopSize = Global.principal.Desktop.getSize();
        Dimension jInternalFrameSize = clienteV.getSize();
        clienteV.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        clienteV.setVisible(true);
        this.hide();
    }//GEN-LAST:event_btnNovoClienteActionPerformed

    private void btnBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalcaoActionPerformed
        btnContinuarPedidoActionPerformed(null);
        txtCliente.setText("Venda Balcão");
        clienteBeans.setCodigoCliente(null);
        pedidoBeans.setTipoPedido("B");
    }//GEN-LAST:event_btnBalcaoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        habilitarCamposCliente(true);
        pedidoBeans.setTipoPedido("E");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        pesquisaCliente();

//        String tipoPesquisa;
//        if (rbNome.isSelected()) {
//            tipoPesquisa = "nome";
//        } else if (rbTelefone.isSelected()) {
//            tipoPesquisa = "telefone";
//        } else {
//            tipoPesquisa = "rua";
//        }
//
//        cbPesquisa.removeAllItems();
//        listaDeClientes.clear();
//        String pesquisa = JOptionPane.showInputDialog(null, "Entre com " + tipoPesquisa + " do cliente:", "PESQUISA DE CLIENTE", 3);
//
//        if (pesquisa != null) {
//            entregaPedidoController.controlePesquisa(pesquisa, tipoPesquisa, listaDeClientes);
//            for (ClienteBean clienteB : listaDeClientes) {
//                cbPesquisa.addItem(clienteB);
//            }
//        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txfCEPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfCEPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            populaCamposCep();
        }
    }//GEN-LAST:event_txfCEPKeyPressed

    private void txfCEPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txfCEPFocusLost
        populaCamposCep();
    }//GEN-LAST:event_txfCEPFocusLost

    private void txfCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCEPActionPerformed

    }//GEN-LAST:event_txfCEPActionPerformed

    private void cbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPesquisaActionPerformed
        if (!(cbPesquisa.getSelectedItem() == null)) {

            clienteBeans = clienteController.controlePreenchimento(((ClienteBean) cbPesquisa.getSelectedItem()).getCodigoCliente());
            txtNome.setText(clienteBeans.getNome());
            txtCliente.setText(clienteBeans.getNome());
            txtRua.setText(clienteBeans.getRua());
            txtBairro.setText(clienteBeans.getBairro());
            txfTelefone.setText(clienteBeans.getTelefone());
            txtData.setText(clienteBeans.getDataCadastro());
            txtObservacao.setText(clienteBeans.getObservacao());
            txfCEP.setText(clienteBeans.getCep() + "");
            txfNascimento.setText(clienteBeans.getAniversario());
            txfTelCelular.setText(clienteBeans.getTelCelular());
            txtCidade.setText(clienteBeans.getCidade());
            txtEstado.setText("SP");
            txtEmail.setText(clienteBeans.getEmail());
            txtNumero.setText(clienteBeans.getNumero() + "");
            btnContinuarPedido.setEnabled(true);
        }
    }//GEN-LAST:event_cbPesquisaActionPerformed

    private void txtNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtNumeroKeyTyped

    private void txfTelCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelCelularKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txfTelCelularKeyTyped

    private void txfTelCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelCelularActionPerformed

    private void txfNascimentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfNascimentoKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txfNascimentoKeyTyped

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txfTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfTelefoneKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txfTelefoneKeyTyped

    private void txfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfTelefoneActionPerformed

    private void txtQuantidadeProdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeProdFocusLost
        // TODO add your handling code here:
        if (!txtQuantidadeProd.getText().isEmpty()) {
            cbxGratis.setEnabled(true);
            cbxGratisActionPerformed(null);
        } else {
            cbxGratis.setEnabled(false);
            cbxGratis.setSelected(false);
            txtValorDescProd.setText("");
        }
    }//GEN-LAST:event_txtQuantidadeProdFocusLost

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        if (cbProduto.getSelectedIndex() >= 0) {
            //txtValor.setText(entregaPedidoController.controleDeValor(((ProdutoBean) cbProdutos.getSelectedItem()).getCodigo()) + "");

            txtValorDescProd.setText("");
            txtValorProd.setText("");
            txtQuantidadeProd.setText("1");
            cbxGratis.setSelected(false);
            txtValorProd.setText(decimalFormato.format(((ProdutoBean) cbProduto.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", "."));
        } else {
            txtValorProd.setText("");
        }
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        if (cbTipo.getSelectedIndex() > 0) {
            cbProduto.removeAllItems();
            populaListaProduto();
        } else {
            cbProduto.setEnabled(false);
            cbProduto.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void txtValorRecebidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebidoKeyReleased

        if (!txtValorRecebido.getText().isEmpty()) {
            try {
                double verifica = Double.parseDouble(txtValorRecebido.getText().replace(",", "."));
                double troco = verifica - Double.parseDouble(txtTotal.getText().replace(",", "."));
                txtTroco.setText(decimalFormato.format(troco).replace(",", "."));
                if (Double.parseDouble(txtTroco.getText()) >= 0) {
                    btnFinalizar.setEnabled(true);
                    //btnImprimirCupom.setEnabled(true);
                } else {
                    btnFinalizar.setEnabled(false);
                    //btnImprimirCupom.setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Campo valor deve conter apenas número!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
                txtValorRecebido.setText("");
                txtValorRecebido.requestFocus();
                txtTroco.setText("");

            }
        } else {
            txtTroco.setText("");
            btnFinalizar.setEnabled(false);
        }
    }//GEN-LAST:event_txtValorRecebidoKeyReleased

    private void txtValorRecebidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebidoKeyTyped
        String caracteres = "0987654321,.";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtValorRecebidoKeyTyped

    private void txtValorRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorRecebidoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtValorRecebidoActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Finalizar Pedido!", "Finalizar Pedido", JOptionPane.YES_NO_OPTION)) {
            case 0:
                populaPedidoBeans();
                if (entregaPedidoController.conttroleDePedido(/*String.valueOf(clienteBeans.getCodigoCliente()), codigoFuncionario + "", txtTotal.getText(), tblPedido.getRowCount(), */pedidoBeans)) {
//                limpaFinaliza();
//                limpaTudo();
                    //new CozinhaView();
                    CozinhaView.getCozinha();
//                this.dispose();
                    btnAdicionaPizza.setEnabled(false);
                    btnAdicionaProduto.setEnabled(false);
                    btnRemove.setEnabled(false);
                    btnFinalizar.setEnabled(false);
                    cbFormaPagamento.setEnabled(false);
                    txtValorRecebido.setEnabled(false);
                    btnImprimirCupom.setEnabled(true);
                    break;
                }
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Deseja sair", "Sair", JOptionPane.YES_NO_OPTION)) {
            case 0:
                limpaFinaliza();
                limpaTudo();
                this.dispose();
                break;
        }
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed

    private void tblPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMousePressed

    }//GEN-LAST:event_tblPedidoMousePressed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int linha = tblPedido.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um item na lista para remover", "ERRO", 0, new ImageIcon("imagens/cancelar.png"));
        } else {
            switch (JOptionPane.showConfirmDialog(null, "Remover Item " + listaDeItens.get(linha), "Remover item de pedido", JOptionPane.YES_NO_OPTION)) {
                case 0:
                    modeloDeTabela.removeRow(linha);
                    listaDeItens.remove(linha);
                    calculaTotal();
                    if (Double.parseDouble(txtTotal.getText()) > 0) {
                        cbFormaPagamento.setEnabled(true);
                        txtTroco.setText("");
                        btnFinalizar.setEnabled(false);
                    } else {
                        cbFormaPagamento.setEnabled(false);
                    }
                    break;
            }

        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void txtTrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrocoActionPerformed

    private void btnAdicionaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaProdutoActionPerformed
        double subTotal = 0.0;
        double valorDesconto = 0.0;
        double valorTotal = 0.0;

        if (cbProduto.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Campo 'Produto' não pode ser vazio!", "ERRO DE PREENCHIMENTO", 0, new ImageIcon("imagens/cancelar.png"));
        } else if (entregaPedidoController.verificaItens(txtQuantidadeProd.getText())) {

            subTotal = Double.parseDouble(txtValorProd.getText()) * Integer.parseInt(txtQuantidadeProd.getText());

//            if (cbxGratis.isSelected()) {
//                valorTotal = subTotal - ((ProdutoBean) cbProduto.getSelectedItem()).getPrecoProduto().getPreco();
//                valorDesconto = ((ProdutoBean) cbProduto.getSelectedItem()).getPrecoProduto().getPreco();
//            } else 
            if (!(txtValorDescProd.getText().isEmpty())) {
                valorTotal = subTotal - Double.parseDouble(txtValorDescProd.getText());
                valorDesconto = Double.parseDouble(txtValorDescProd.getText());
            } else {
                valorTotal = subTotal;
            }

            // double subTotal = Double.parseDouble(txtValorProd.getText()) * Integer.parseInt(txtQuantidadeProd.getText());
            modeloDeTabela.addRow(new Object[]{cbTipo.getSelectedItem()+" "+cbProduto.getSelectedItem(), (decimalFormato.format(((ProdutoBean) cbProduto.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", ".")), "", txtQuantidadeProd.getText(), decimalFormato.format(subTotal).replace(",", "."), decimalFormato.format(valorDesconto).replace(",", "."), decimalFormato.format(valorTotal).replace(",", ".")});

            cbFormaPagamento.setEnabled(true);
            txtTroco.setText("");
            btnFinalizar.setEnabled(false);
            adicionaProduto(valorTotal);
            limpaProduto();
            calculaTotal();
            txtValorDescProd.setText("");
            cbxGratis.setSelected(false);
            cbTipo.setSelectedIndex(0);

        }
    }//GEN-LAST:event_btnAdicionaProdutoActionPerformed

    private void cbInteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInteiraActionPerformed
        if (rbInteira.isSelected()) {
            txtValorPizza.setText("");
            //00:09 OK
            txtQtdPizza.setText("");
            if (cbInteira.getSelectedIndex() >= 0) {
                //txtValor.setText(entregaPedidoController.controleDeValor(((ProdutoBean) cbProdutos.getSelectedItem()).getCodigo()) + "");
                txtValorPizza.setText(decimalFormato.format(((ProdutoBean) cbInteira.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", "."));
                txtQtdPizza.setText("1");
            }
        }
        cbBorda.setSelectedIndex(0);
    }//GEN-LAST:event_cbInteiraActionPerformed

    private void rbInteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInteiraActionPerformed
        cbInteira.removeAllItems();
        cbSabor1.removeAllItems();
        cbSabor2.removeAllItems();
        cbSabor1.setEnabled(false);
        cbSabor2.setEnabled(false);
        cbInteira.setEnabled(false);
        txtQtdPizza.setEditable(true);
        txtQtdPizza.setText("");
//        Color cor = new Color(204, 255, 255);
//        txtQtdPizza.setBackground(cor);
        cbBorda.setSelectedIndex(0);
        cbSabor1.setSelectedIndex(-1);
        cbSabor2.setSelectedIndex(-1);
        txtValorPizza.setText("");
        cbTipoPizza.setSelectedIndex(0);
    }//GEN-LAST:event_rbInteiraActionPerformed

    private void rbMeiaPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMeiaPizzaActionPerformed
        cbInteira.removeAllItems();
        cbSabor1.removeAllItems();
        cbSabor2.removeAllItems();
        cbSabor1.setEnabled(false);
        cbSabor2.setEnabled(false);
        cbInteira.setEnabled(false);
        txtQtdPizza.setEditable(true);
        txtQtdPizza.setText("");
//        txtQtdPizza.setEditable(false);
//        txtQtdPizza.setText("1");
//        Color cor = new Color(255, 255, 204);
//        txtQtdPizza.setBackground(cor);
        cbBorda.setSelectedIndex(0);
        cbInteira.setSelectedIndex(-1);
        txtValorPizza.setText("");
        cbTipoPizza.setSelectedIndex(0);
    }//GEN-LAST:event_rbMeiaPizzaActionPerformed

    private void cbSabor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSabor2ActionPerformed
        if (rbMeiaPizza.isSelected()) {
            controleValorSabores();
        }
        cbBorda.setSelectedIndex(0);
    }//GEN-LAST:event_cbSabor2ActionPerformed

    private void txtValorProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorProdActionPerformed

    private void cbSabor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSabor1ActionPerformed
        if (rbMeiaPizza.isSelected()) {
            controleValorSabores();
        }
        cbBorda.setSelectedIndex(0);
    }//GEN-LAST:event_cbSabor1ActionPerformed

    private void txtQuantidadeProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeProdActionPerformed

    private void btnAdicionaPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaPizzaActionPerformed

        if (rbMeiaPizza.isSelected()) {
            controleMeiaPizza();
        } else {
            controlePizzaInteira();
        }

    }//GEN-LAST:event_btnAdicionaPizzaActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        txtCodigo.setText(String.valueOf(entregaPedidoController.controleCodigoPedido()));
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void cbFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFormaPagamentoActionPerformed
        if (cbFormaPagamento.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma forma de Pagamento!");
            txtValorRecebido.setEditable(false);
            txtValorRecebido.setText("");
            txtValorRecebidoKeyReleased(null);
        } else if (cbFormaPagamento.getSelectedIndex() == 1) {
            txtValorRecebido.setEditable(true);
            txtValorRecebido.setText("");
            txtValorRecebidoKeyReleased(null);
        } else {
            txtValorRecebido.setEditable(false);
            txtValorRecebido.setText(txtTotal.getText());
            txtValorRecebidoKeyReleased(null);
        }
    }//GEN-LAST:event_cbFormaPagamentoActionPerformed

    private void cbBordaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBordaActionPerformed
        // TODO add your handling code here:
        if (txtValorPizza.getText().isEmpty()) {

            //00:09 OK
        } else if (cbBorda.getSelectedIndex() > 0) {
            //txtValor.setText(entregaPedidoController.controleDeValor(((ProdutoBean) cbProdutos.getSelectedItem()).getCodigo()) + "");
            //txtValorSubPizza.setText(decimalFormato.format((((ProdutoBean) cbBorda.getSelectedItem()).getPrecoProduto().getPreco()) + (Double.parseDouble(txtValorPizza.getText()))).replace(",", "."));
            txtValorSubPizza.setText(decimalFormato.format((((ProdutoBean) cbBorda.getSelectedItem()).getPrecoProduto().getPreco())).replace(",", "."));
        } else {
            txtValorSubPizza.setText("");
        }

    }//GEN-LAST:event_cbBordaActionPerformed

    private void txtValorSubPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorSubPizzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorSubPizzaActionPerformed

    private void cbxGratisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGratisActionPerformed
        // TODO add your handling code here:
        double valorDesconto;
        if (cbxGratis.isSelected() && !txtValorProd.getText().isEmpty() && !txtQuantidadeProd.getText().isEmpty()) {
            valorDesconto = Double.parseDouble(txtValorProd.getText()) * Integer.parseInt(txtQuantidadeProd.getText());
            txtValorDescProd.setText(decimalFormato.format(valorDesconto).replace(",", "."));
            txtValorDescProd.setEditable(false);
            Color cor = new Color(255, 255, 204);
            txtValorDescProd.setBackground(cor);
        } else {
            txtValorDescProd.setText("");
            txtValorDescProd.setEditable(true);
            Color cor = new Color(204, 255, 255);
            txtValorDescProd.setBackground(cor);
        }
    }//GEN-LAST:event_cbxGratisActionPerformed

    private void txtQtdPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdPizzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdPizzaActionPerformed

    private void btnImprimirCupomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirCupomActionPerformed
        // TODO add your handling code here:
        populaPedidoBeans();
        entregaPedidoController.controleImpressaoCupom(pedidoBeans);
        btnAdicionaPizza.setEnabled(false);
        btnAdicionaProduto.setEnabled(false);
        btnRemove.setEnabled(false);
        btnImprimirCupom.setEnabled(false);
        cbFormaPagamento.setEnabled(false);
        txtValorRecebido.setEnabled(false);
        this.dispose();
        
        PedidoView pedidoV = new PedidoView(codigoFuncionario);
        Global.principal.Desktop.add(pedidoV);
       // CentralizarForm.centralizaForm(pedidoV);
        
        
        Dimension desktopSize = Global.principal.getDesktop().getSize();
        Dimension jInternalFrameSize = pedidoV.getSize();
        pedidoV.setLocation(((desktopSize.width - jInternalFrameSize.width)) / 2 + 100,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    
        
        
        
        pedidoV.setVisible(true);

    }//GEN-LAST:event_btnImprimirCupomActionPerformed

    private void txtQuantidadeProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeProdKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantidadeProdKeyTyped

    private void txtQtdPizzaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtdPizzaKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtQtdPizzaKeyTyped

    private void txtValorDescPizzaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorDescPizzaKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321.,";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorDescPizzaKeyTyped

    private void txtValorDescProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorDescProdKeyTyped
        // TODO add your handling code here:
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtValorDescProdKeyTyped

    private void txtValorRecebidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorRecebidoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            txtValorRecebidoKeyReleased(null);
        }
    }//GEN-LAST:event_txtValorRecebidoKeyPressed

    private void btnIngredInteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngredInteiraActionPerformed
        // TODO add your handling code here:
        if (cbInteira.getSelectedIndex() >= 0) {
            Point location = btnIngredInteira.getLocation();
            String descIngred[] = (((ProdutoBean) cbInteira.getSelectedItem()).getIngredientes()).split(",");
            String string = (((ProdutoBean) cbInteira.getSelectedItem()).getTipoProduto().getDescricao() + " " + ((ProdutoBean) cbInteira.getSelectedItem()).getDescricao() + "\n\n");
            for (String area : descIngred) {
                string += area + "\n";
            }
            ingredienteV.setLocation(location);
            ingredienteV.setTitle("Ingredientes");
            ingredienteV.txaIngredientes.setText(string);
            ingredienteV.setVisible(true);
        }

    }//GEN-LAST:event_btnIngredInteiraActionPerformed

    private void cbTipoPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoPizzaActionPerformed
        // TODO add your handling code here:
        cbInteira.removeAllItems();
        cbSabor1.removeAllItems();
        cbSabor2.removeAllItems();
        cbSabor1.setEnabled(false);
        cbSabor2.setEnabled(false);
        cbInteira.setEnabled(false);
        if (cbTipoPizza.getSelectedIndex() > 0) {
            populaListaPizzaInteira();
            populaListaPizzaSabor1();
            populaListaPizzaSabor2();
            cbSabor1.setSelectedIndex(-1);
            cbSabor2.setSelectedIndex(-1);
            cbInteira.setSelectedIndex(-1);
            //   populaListaBorda();
            if (rbInteira.isSelected()) {
                cbSabor1.setEnabled(false);
                cbSabor2.setEnabled(false);
                cbInteira.setEnabled(true);
                txtQtdPizza.setEditable(true);
                txtQtdPizza.setText("");
//        Color cor = new Color(204, 255, 255);
//        txtQtdPizza.setBackground(cor);
                cbBorda.setSelectedIndex(0);
                cbSabor1.setSelectedIndex(-1);
                cbSabor2.setSelectedIndex(-1);
                txtValorPizza.setText("");
            } else {
                cbSabor1.setEnabled(true);
                cbSabor2.setEnabled(true);
                cbInteira.setEnabled(false);
                txtQtdPizza.setEditable(true);
                txtQtdPizza.setText("");
//        txtQtdPizza.setEditable(false);
//        txtQtdPizza.setText("1");
//        Color cor = new Color(255, 255, 204);
//        txtQtdPizza.setBackground(cor);
                cbBorda.setSelectedIndex(0);
                cbInteira.setSelectedIndex(-1);
                txtValorPizza.setText("");
            }

        }
    }//GEN-LAST:event_cbTipoPizzaActionPerformed

    private void btnIngredSabor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngredSabor1ActionPerformed
        // TODO add your handling code here:
        if (cbSabor1.getSelectedIndex() >= 0) {
            Point location = btnIngredSabor1.getLocation();
            String descIngred[] = (((ProdutoBean) cbSabor1.getSelectedItem()).getIngredientes()).split(",");
            String string = (((ProdutoBean) cbSabor1.getSelectedItem()).getTipoProduto().getDescricao() + " " + ((ProdutoBean) cbSabor1.getSelectedItem()).getDescricao() + "\n\n");
            for (String area : descIngred) {
                string += area + "\n";
            }
            ingredienteV.setLocation(location);
            ingredienteV.setTitle("Ingredientes");
            ingredienteV.txaIngredientes.setText(string);
            ingredienteV.setVisible(true);
        }
    }//GEN-LAST:event_btnIngredSabor1ActionPerformed

    private void btnIngredSabor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngredSabor2ActionPerformed
        // TODO add your handling code here:
        if (cbSabor2.getSelectedIndex() >= 0) {
            Point location = btnIngredSabor2.getLocation();
            String descIngred[] = (((ProdutoBean) cbSabor2.getSelectedItem()).getIngredientes()).split(",");
            String string = (((ProdutoBean) cbSabor2.getSelectedItem()).getTipoProduto().getDescricao() + " " + ((ProdutoBean) cbSabor2.getSelectedItem()).getDescricao() + "\n\n");
            for (String area : descIngred) {
                string += area + "\n";
            }
            ingredienteV.setLocation(location);
            ingredienteV.setTitle("Ingredientes");
            ingredienteV.txaIngredientes.setText(string);
            ingredienteV.setVisible(true);
        }
    }//GEN-LAST:event_btnIngredSabor2ActionPerformed

    private void txtQtdPizzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQtdPizzaMouseClicked
        // TODO add your handling code here:
        txtQtdPizza.setText("");
    }//GEN-LAST:event_txtQtdPizzaMouseClicked

    private void txtQuantidadeProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantidadeProdMouseClicked
        // TODO add your handling code here:
        txtQuantidadeProd.setText("");
    }//GEN-LAST:event_txtQuantidadeProdMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionaPizza;
    private javax.swing.JButton btnAdicionaProduto;
    private javax.swing.JButton btnBalcao;
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnContinuarPedido;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnImprimirCupom;
    private javax.swing.JButton btnIngredInteira;
    private javax.swing.JButton btnIngredSabor1;
    private javax.swing.JButton btnIngredSabor2;
    private javax.swing.JButton btnNovoCliente;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox cbBorda;
    private javax.swing.JComboBox cbFormaPagamento;
    private javax.swing.JComboBox cbInteira;
    private javax.swing.JComboBox cbPesquisa;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JComboBox cbSabor1;
    private javax.swing.JComboBox cbSabor2;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JComboBox cbTipoPizza;
    private javax.swing.JCheckBox cbxGratis;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblFormaPagamento1;
    private javax.swing.JLabel lblNasc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblObservacao;
    private javax.swing.JLabel lblObservacao1;
    private javax.swing.JLabel lblQuantidade1;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuario1;
    private javax.swing.JLabel lblUsuario2;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lblValor2;
    private javax.swing.JLabel lblValor3;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_rua;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JTabbedPane pnlPai;
    private javax.swing.JPanel pnlPedido;
    private javax.swing.JRadioButton rbEndereco;
    private javax.swing.JRadioButton rbInteira;
    private javax.swing.JRadioButton rbMeiaPizza;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbTelefone;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JTable tblPedido;
    private javax.swing.JFormattedTextField txfCEP;
    private javax.swing.JFormattedTextField txfNascimento;
    private javax.swing.JFormattedTextField txfTelCelular;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtObservacao;
    private javax.swing.JTextField txtObservacao1;
    private javax.swing.JTextField txtQtdPizza;
    private javax.swing.JTextField txtQuantidadeProd;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtTroco;
    private javax.swing.JTextField txtValorDescPizza;
    private javax.swing.JTextField txtValorDescProd;
    private javax.swing.JTextField txtValorPizza;
    private javax.swing.JTextField txtValorProd;
    private javax.swing.JTextField txtValorRecebido;
    private javax.swing.JTextField txtValorSubPizza;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        //txtCodigoCliente.setEditable(valor);
        txtNome.setEditable(valor);
        txtRua.setEditable(valor);
        txtBairro.setEditable(valor);
        txfTelefone.setEditable(valor);
        txtData.setEditable(valor);
        cbFormaPagamento.setEditable(valor);
        txtValorRecebido.setEditable(valor);
        txtTroco.setEditable(valor);
    }

    final void habilitarCamposCliente(boolean valor) {

        cbPesquisa.setEnabled(valor);
        btnPesquisar.setEnabled(valor);
        txtEstado.setEnabled(true);
        txtObservacao.setEnabled(valor);
        txfCEP.setEnabled(valor);
        txfNascimento.setEnabled(valor);
        txfTelCelular.setEnabled(valor);
        txfTelefone.setEnabled(valor);
        txtBairro.setEnabled(true);
        txtCidade.setEnabled(true);
        txtEmail.setEnabled(valor);
        txtNome.setEnabled(valor);
        txtNumero.setEnabled(valor);
        txtRua.setEnabled(true);
        rbEndereco.setEnabled(valor);
        rbNome.setEnabled(valor);
        rbTelefone.setEnabled(valor);
        txtData.setEnabled(valor);

        lblCelular.setEnabled(valor);
        lblCep.setEnabled(valor);
        lblCidade.setEnabled(valor);
        lblEmail.setEnabled(valor);
        lblEstado.setEnabled(valor);
        lblNasc.setEnabled(valor);
        lblNome.setEnabled(valor);
        lblObservacao.setEnabled(valor);
        lblTelefone.setEnabled(valor);
        lbl_bairro.setEnabled(valor);
        lbl_rua.setEnabled(valor);
        lbl_data.setEnabled(valor);
        lblNumero.setEnabled(valor);
        btnBalcao.setEnabled(false);
        btnNovoCliente.setEnabled(valor);

    }

    public void habilitaCamposEditar(boolean valor) {
        txtEstado.setEditable(false);
        txtObservacao.setEditable(valor);
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

    final void limpaProduto() {
        // txtItem.setText("");
        txtQuantidadeProd.setText("");
        txtValorProd.setText("");

        cbProduto.removeAllItems();
    }

    final void populaPedidoBeans() {

        pedidoBeans.setCodigoCliente(clienteBeans.getCodigoCliente());
        pedidoBeans.setLoginUsuario(Global.usuario.getLogin());
        pedidoBeans.setCodigoEntregador(0);
        pedidoBeans.setStatus("A");
        pedidoBeans.setObs(txtObservacao1.getText());
        pedidoBeans.setValorTotalPedido(Double.parseDouble(txtTotal.getText()));
        pedidoBeans.setItensPedido(listaDeItens);
        pedidoBeans.setValorRecebido(Double.parseDouble(txtValorRecebido.getText().replace(",", ".")));
        pedidoBeans.setValorTroco(Double.parseDouble(txtTroco.getText()));
        pedidoBeans.setTipoPagamento(cbFormaPagamento.getSelectedItem().toString());

    }

    final void limpaFinaliza() {
        txtTotal.setText("");
        btnFinalizar.setEnabled(false);
        modeloDeTabela.setNumRows(0);
        txtCliente.setText("");
        btnRemove.setEnabled(true);
        pnlPai.setEnabledAt(0, true);
        pnlPai.setEnabledAt(1, false);
        pnlPai.setSelectedIndex(0);

    }

    final void limpaNovo() {
        txtNome.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txfTelefone.setText("");
    }

    final ClienteBean populaClienteBeans() {
        clienteBeans.setNome(txtNome.getText());
        clienteBeans.setRua(txtRua.getText());
        clienteBeans.setBairro(txtBairro.getText());
        clienteBeans.setTelefone(txfTelefone.getText());
        clienteBeans.setDataCadastro(txtData.getText());

        return clienteBeans;

    }

    final void limpaTudo() {
        txtNome.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txfTelefone.setText("");
        //txtCodigoCliente.setText("");
        txtData.setText("");
        cbPesquisa.removeAllItems();
    }

    public void adicionaProduto(double total) {
        double subTotal = Double.parseDouble(txtValorProd.getText()) * Integer.parseInt(txtQuantidadeProd.getText());
        ItemPedidoBean itemPedido = new ItemPedidoBean();
        itemPedido.setCodigoProduto(((ProdutoBean) cbProduto.getSelectedItem()).getCodigo());
        itemPedido.setPrecoUnitario(((ProdutoBean) cbProduto.getSelectedItem()).getPrecoProduto().getPreco());
        itemPedido.setQuantidade(Integer.parseInt(txtQuantidadeProd.getText()));
        itemPedido.setPrecoTotal(total);
        itemPedido.setMeiaPizza("N");
        itemPedido.setDescricao(((ProdutoBean) cbProduto.getSelectedItem()).getDescricao());
        itemPedido.setItemProdutoBean((ProdutoBean) cbProduto.getSelectedItem());

        listaDeItens.add(itemPedido);
    }

    public void calculaTotal() {
        double totalDoPedido = 0;
        for (ItemPedidoBean listaDeIten : listaDeItens) {
            totalDoPedido += listaDeIten.getPrecoTotal();
        }

        txtTotal.setText(decimalFormato.format(totalDoPedido).replace(",", "."));
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

    public void populaTipoProduto() {
        listaTipoProd = new ArrayList<>();
        entregaPedidoController.controleListaTipoProduto(listaTipoProd);
        for (TipoProdutoBean tipoProdutoBeans : listaTipoProd) {
            cbTipo.addItem(tipoProdutoBeans);
        }
    }

    public void populaTipoPizza() {
        listaTipoPizza = new ArrayList<>();
        entregaPedidoController.controleListaTipoPizza(listaTipoPizza);
        for (TipoProdutoBean tipoProdutoBeans : listaTipoPizza) {
            cbTipoPizza.addItem(tipoProdutoBeans);
        }
    }

    public void populaListaProduto() {
        if (cbTipo.getSelectedIndex() > 0) {
            listaProduto = new ArrayList<>();
            // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
            entregaPedidoController.controleDeItens(((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo(), listaProduto);
            for (ProdutoBean prdutoBeans : listaProduto) {
                cbProduto.addItem(prdutoBeans);
            }
            cbProduto.setEnabled(true);
        } else {
            cbProduto.setEnabled(false);
            cbProduto.setSelectedIndex(0);
        }
    }

    public void populaListaPizzaInteira() {
        listaPizzaInteira = new ArrayList<>();
        // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
        entregaPedidoController.controleListaPizza(listaPizzaInteira, ((TipoProdutoBean) cbTipoPizza.getSelectedItem()).getCodigo());
        for (ProdutoBean prdutoBeans : listaPizzaInteira) {
            cbInteira.addItem(prdutoBeans);
        }
    }

    public void populaListaPizzaSabor1() {
        listaPizzaSabor1 = new ArrayList<>();
        // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
        entregaPedidoController.controleListaPizza(listaPizzaSabor1, ((TipoProdutoBean) cbTipoPizza.getSelectedItem()).getCodigo());
        for (ProdutoBean prdutoBeans : listaPizzaSabor1) {
            cbSabor1.addItem(prdutoBeans);
        }
    }

    public void populaListaPizzaSabor2() {
        listaPizzaSabor2 = new ArrayList<>();
        // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
        entregaPedidoController.controleListaPizza(listaPizzaSabor2, ((TipoProdutoBean) cbTipoPizza.getSelectedItem()).getCodigo());
        for (ProdutoBean prdutoBeans : listaPizzaSabor2) {
            cbSabor2.addItem(prdutoBeans);
        }
    }

    public void populaListaBorda() {
        listaBorda = new ArrayList<>();
        // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
        entregaPedidoController.controleListaBorda(listaBorda);
        for (ProdutoBean prdutoBeans : listaBorda) {
            cbBorda.addItem(prdutoBeans);
        }
    }

    public void habilitaPizza(boolean valor) {
        cbInteira.setEnabled(valor);
        cbSabor1.setEnabled(valor);
        cbSabor2.setEnabled(valor);
    }

    public void adicionaPizzaInteira(double total) {
        double subTotal = Double.parseDouble(txtValorPizza.getText()) * Integer.parseInt(txtQtdPizza.getText());
        ItemPedidoBean itemPedido = new ItemPedidoBean();
        itemPedido.setCodigoProduto(((ProdutoBean) cbInteira.getSelectedItem()).getCodigo());
        itemPedido.setPrecoUnitario(((ProdutoBean) cbInteira.getSelectedItem()).getPrecoProduto().getPreco());
        itemPedido.setQuantidade(Integer.parseInt(txtQtdPizza.getText()));
        itemPedido.setPrecoTotal(total);
        itemPedido.setMeiaPizza("N");
        itemPedido.setDescricao(((ProdutoBean) cbInteira.getSelectedItem()).getDescricao());
        itemPedido.setItemProdutoBean((ProdutoBean) cbInteira.getSelectedItem());
        listaDeItens.add(itemPedido);
    }

    public void adicionaPizzaSabores(String valorMaior, double total) {
        double subTotal = Double.parseDouble(txtValorPizza.getText()) * Integer.parseInt(txtQtdPizza.getText());

        if (valorMaior.equals("sabor1")) {
            ItemPedidoBean itemPedido = new ItemPedidoBean();
            itemPedido.setCodigoProduto(((ProdutoBean) cbSabor1.getSelectedItem()).getCodigo());
            itemPedido.setPrecoUnitario(((ProdutoBean) cbSabor1.getSelectedItem()).getPrecoProduto().getPreco());
            itemPedido.setQuantidade(Integer.parseInt(txtQtdPizza.getText()));
            itemPedido.setPrecoTotal(total);
            itemPedido.setDescricao(((ProdutoBean) cbSabor1.getSelectedItem()).getDescricao());
            itemPedido.setCodigoProduto2(((ProdutoBean) cbSabor2.getSelectedItem()).getCodigo());
            itemPedido.setMeiaPizza("S");
            itemPedido.setItemProdutoBean((ProdutoBean) cbSabor1.getSelectedItem());
            listaDeItens.add(itemPedido);
//            ItemPedidoBean itemPedido2 = new ItemPedidoBean();
//            itemPedido2.setCodigoProduto(((ProdutoBean) cbSabor2.getSelectedItem()).getCodigo());
//            itemPedido2.setPrecoUnitario(0.0);
//            itemPedido2.setQuantidade(0);
//            itemPedido2.setPrecoTotal(0.0);
//            itemPedido2.setDescricao(((ProdutoBean) cbSabor2.getSelectedItem()).getDescricao() + " meia");
//            itemPedido2.setMeiaPizza("S");
//            listaDeItens.add(itemPedido2);
        } else {
            ItemPedidoBean itemPedido = new ItemPedidoBean();
            itemPedido.setCodigoProduto(((ProdutoBean) cbSabor2.getSelectedItem()).getCodigo());
            itemPedido.setPrecoUnitario(((ProdutoBean) cbSabor2.getSelectedItem()).getPrecoProduto().getPreco());
            itemPedido.setQuantidade(Integer.parseInt(txtQtdPizza.getText()));
            itemPedido.setPrecoTotal(total);
            itemPedido.setDescricao(((ProdutoBean) cbSabor2.getSelectedItem()).getDescricao());
            itemPedido.setCodigoProduto2(((ProdutoBean) cbSabor1.getSelectedItem()).getCodigo());
            itemPedido.setMeiaPizza("S");
            itemPedido.setItemProdutoBean((ProdutoBean) cbSabor2.getSelectedItem());
            listaDeItens.add(itemPedido);
//            ItemPedidoBean itemPedido2 = new ItemPedidoBean();
//            itemPedido2.setCodigoProduto(((ProdutoBean) cbSabor1.getSelectedItem()).getCodigo());
//            itemPedido2.setPrecoUnitario(0.0);
//            itemPedido2.setQuantidade(0);
//            itemPedido2.setPrecoTotal(0.0);
//            itemPedido2.setDescricao(((ProdutoBean) cbSabor1.getSelectedItem()).getDescricao() + " meia");
//            itemPedido2.setMeiaPizza("S");
//            listaDeItens.add(itemPedido2);
        }

    }

    final void limpaPizza() {

        txtQtdPizza.setText("");
        txtValorPizza.setText("");

    }

    public void pesquisaCliente() {
        String tipoPesquisa;
        if (rbNome.isSelected()) {
            tipoPesquisa = "nome";
        } else if (rbTelefone.isSelected()) {
            tipoPesquisa = "telefone";
        } else {
            tipoPesquisa = "rua";
        }

        cbPesquisa.removeAllItems();
        listaDeClientes.clear();
        String pesquisa = JOptionPane.showInputDialog(null, "Entre com " + tipoPesquisa + " do cliente:", "PESQUISA DE CLIENTE", 3);

        if (pesquisa != null) {
            entregaPedidoController.controlePesquisa(pesquisa, tipoPesquisa, listaDeClientes);
            for (ClienteBean clienteB : listaDeClientes) {
                cbPesquisa.addItem(clienteB);
            }
        }
    }

    public void pesquisaCliente(String pesquisa) {

        cbPesquisa.removeAllItems();
        listaDeClientes.clear();

        if (pesquisa != null) {
            entregaPedidoController.controlePesquisa(pesquisa, "nome", listaDeClientes);
            for (ClienteBean clienteB : listaDeClientes) {
                cbPesquisa.addItem(clienteB);
            }
        }
    }

    public void controleMeiaPizza() {
        double subTotal;
        double valorBorda = 0;
        double valorDesconto = 0;
        double valorTotal;

        if (cbSabor1.getSelectedIndex() <= -1 || cbSabor2.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(null, "Selecione dois sabores!");
        } else if (entregaPedidoController.verificaItens(txtQtdPizza.getText())) {

            if (!(txtValorSubPizza.getText().isEmpty())) {
                valorBorda = Double.parseDouble(txtValorSubPizza.getText());
                subTotal = (Double.parseDouble(txtValorPizza.getText()) + valorBorda) * Integer.parseInt(txtQtdPizza.getText());
            } else {
                subTotal = Double.parseDouble(txtValorPizza.getText()) * Integer.parseInt(txtQtdPizza.getText());
            }

            if (!(txtValorDescPizza.getText().isEmpty())) {
                valorTotal = subTotal - Double.parseDouble(txtValorDescPizza.getText().replace(",", "."));
                valorDesconto = Double.parseDouble(txtValorDescPizza.getText().replace(",", "."));
            } else {
                valorTotal = subTotal;
            }

            if (cbSabor2.getSelectedItem() != null) {
                double sabor1 = ((ProdutoBean) cbSabor1.getSelectedItem()).getPrecoProduto().getPreco();
                double sabor2 = ((ProdutoBean) cbSabor2.getSelectedItem()).getPrecoProduto().getPreco();
                if (sabor1 >= sabor2) {
                    modeloDeTabela.addRow(new Object[]{cbTipoPizza.getSelectedItem()+" "+cbSabor1.getSelectedItem() + " / " + cbSabor2.getSelectedItem(), (decimalFormato.format(((ProdutoBean) cbSabor1.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", ".")), decimalFormato.format(valorBorda).replace(",", "."), txtQtdPizza.getText(), decimalFormato.format(subTotal).replace(",", "."), decimalFormato.format(valorDesconto).replace(",", "."), decimalFormato.format(valorTotal).replace(",", ".")});
                    // modeloDeTabela.addRow(new Object[]{cbSabor2.getSelectedItem() + " meia", 0.00, 0, 0.00});
                    adicionaPizzaSabores("sabor1", valorTotal);
                } else {
                    // modeloDeTabela.addRow(new Object[]{cbSabor1.getSelectedItem() + " meia", 0.00, 0, 0.00});
                    modeloDeTabela.addRow(new Object[]{cbTipoPizza.getSelectedItem()+" "+cbSabor2.getSelectedItem() + " / " + cbSabor1.getSelectedItem(), (decimalFormato.format(((ProdutoBean) cbSabor2.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", ".")), decimalFormato.format(valorBorda).replace(",", "."), txtQtdPizza.getText(), decimalFormato.format(subTotal).replace(",", "."), decimalFormato.format(valorDesconto).replace(",", "."), decimalFormato.format(valorTotal).replace(",", ".")});
                    adicionaPizzaSabores("sabor2", valorTotal);
                }
            }

            cbTipoPizza.setSelectedIndex(0);
            cbFormaPagamento.setEnabled(true);
            txtTroco.setText("");
            btnFinalizar.setEnabled(false);
            txtValorDescPizza.setText("");
            txtValorSubPizza.setText("");

            limpaPizza();
            calculaTotal();
        }
    }

    public void controlePizzaInteira() {
        double subTotal;
        double valorBorda = 0;
        double valorDesconto = 0;
        double valorTotal;
        if (cbInteira.getSelectedIndex() <= -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma Pizza!");
        } else if (entregaPedidoController.verificaItens(txtQtdPizza.getText())) {

            if (!(txtValorSubPizza.getText().isEmpty())) {
                valorBorda = Double.parseDouble(txtValorSubPizza.getText());
                subTotal = (Double.parseDouble(txtValorPizza.getText()) + valorBorda) * Integer.parseInt(txtQtdPizza.getText());
            } else {
                subTotal = Double.parseDouble(txtValorPizza.getText()) * Integer.parseInt(txtQtdPizza.getText());
            }

            if (!(txtValorDescPizza.getText().isEmpty())) {
                valorTotal = subTotal - Double.parseDouble(txtValorDescPizza.getText().replace(",", "."));
                valorDesconto = Double.parseDouble(txtValorDescPizza.getText().replace(",", "."));
            } else {
                valorTotal = subTotal;
            }

            if (cbInteira.getSelectedItem() != null) {
                modeloDeTabela.addRow(new Object[]{cbTipoPizza.getSelectedItem()+" "+cbInteira.getSelectedItem(), (decimalFormato.format(((ProdutoBean) cbInteira.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", ".")), decimalFormato.format(valorBorda).replace(",", "."), txtQtdPizza.getText(), decimalFormato.format(subTotal).replace(",", "."), decimalFormato.format(valorDesconto).replace(",", "."), decimalFormato.format(valorTotal).replace(",", ".")});
                adicionaPizzaInteira(valorTotal);
            }
            cbInteira.setSelectedIndex(0);
            cbBorda.setSelectedIndex(0);
            cbFormaPagamento.setEnabled(true);
            txtTroco.setText("");
            btnFinalizar.setEnabled(false);
            txtValorDescPizza.setText("");
            txtValorSubPizza.setText("");

            limpaPizza();
            calculaTotal();
        }
    }

    public void controleValorSabores() {
        txtValorPizza.setText("");
        txtQtdPizza.setText("1");
        if (cbSabor2.getSelectedIndex() >= 0 && cbSabor1.getSelectedIndex() >= 0) {
            double sabor1 = ((ProdutoBean) cbSabor1.getSelectedItem()).getPrecoProduto().getPreco();
            double sabor2 = ((ProdutoBean) cbSabor2.getSelectedItem()).getPrecoProduto().getPreco();
            if (sabor1 >= sabor2) {
                txtValorPizza.setText(decimalFormato.format(((ProdutoBean) cbSabor1.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", "."));
            } else {
                txtValorPizza.setText(decimalFormato.format(((ProdutoBean) cbSabor2.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", "."));
            }
        }
    }

}
