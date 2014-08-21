package br.com.pizzaria.view;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.controller.ClienteController;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ClienteView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    SimpleDateFormat FormatoData;
    Date DataAtual;
    ClienteBeans clienteBeans;
    ClienteController clienteController;
    DefaultTableModel modelo;

    public ClienteView() {
        initComponents();
        habilitarCampos(false);
        FormatoData = new SimpleDateFormat("dd/MM/yyyy");
        DataAtual = new Date();
        txtData.setText(FormatoData.format(DataAtual));
        clienteBeans = new ClienteBeans();
        clienteController = new ClienteController();
        modelo = (DefaultTableModel) tblCliente.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        lbl_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        sep_codigo = new javax.swing.JSeparator();
        lbl_rua = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        lbl_bairro = new javax.swing.JLabel();
        lbl_telefone = new javax.swing.JLabel();
        txfPesquisar = new javax.swing.JFormattedTextField();
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
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("MANUTENÇÃO DE CLIENTE");
        setPreferredSize(new java.awt.Dimension(450, 600));
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

        lbl_codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Código");

        txt_codigo.setEditable(false);
        txt_codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_codigo.setForeground(new java.awt.Color(255, 51, 51));
        txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        lbl_rua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua.setText("Rua:");

        lbl_bairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro.setText("Bairro:");

        lbl_telefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone.setText("Telefone:");

        txfPesquisar.setForeground(new java.awt.Color(0, 51, 255));
        txfPesquisar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txfPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txfPesquisarKeyReleased(evt);
            }
        });

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data:");

        txtData.setEditable(false);

        lbl_data1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data1.setText("Pesquisar:");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Rua", "Bairro", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setToolTipText("Cadastro de um novo cliente");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setToolTipText("Para edita alguma informação de cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txt_codigo)
            .addComponent(sep_codigo)
            .addComponent(sep_formulario)
            .addComponent(sep_pesquisa)
            .addComponent(sep_tabela)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rua, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_bairro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_telefone, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRua, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBairro)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txfTelefone)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_data)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_data1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rua)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_bairro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_telefone)
                    .addComponent(lbl_data)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sep_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_data1))
                    .addComponent(txfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        habilitarCampos(true);
        txtNome.requestFocus();
        txt_codigo.setText(clienteController.controleDeCodigo());
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        populaClienteBeans();
        if (clienteController.verificarDados(clienteBeans)) {
            limpaTudo();
            habilitarCampos(false);
        }


    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txfPesquisarKeyReleased
        clienteController.controlePesquisa(txfPesquisar.getText(), modelo);
    }//GEN-LAST:event_txfPesquisarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_data1;
    private javax.swing.JLabel lbl_rua;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JSeparator sep_codigo;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblCliente;
    private javax.swing.JFormattedTextField txfPesquisar;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txt_codigo;
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
        clienteBeans.setDataCad(txtData.getText());

    }

    final void limpaTudo() {
        txtNome.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txfTelefone.setText("");
        txt_codigo.setText("");
    }

}
