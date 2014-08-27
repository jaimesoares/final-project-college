/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.view;

import br.com.pizzaria.beans.ClienteBeans;
import br.com.pizzaria.controller.ClienteController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author katia
 */
public class PedidoView extends javax.swing.JInternalFrame {

    MaskFormatter formatoTelefone;
    ClienteBeans clienteBeans;
    ClienteController clienteController;
    List<String> lista;

    /**
     * Creates new form PedidoView
     */
    public PedidoView() {
        initComponents();
        habilitarCampos(false);
        clienteController = new ClienteController();
        clienteBeans = new ClienteBeans();
        lista = new ArrayList<>();
        pnlPai.setEnabledAt(1, false);

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
        pnlPai = new javax.swing.JTabbedPane();
        pnlCliente = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        cbPesquisa = new javax.swing.JComboBox();
        lbl_codigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        sep_codigo = new javax.swing.JSeparator();
        txtBairro = new javax.swing.JTextField();
        try{

            formatoTelefone = new MaskFormatter("(##)####-####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Telefone inválido", "ERRO DE FORMATAÇÃO", 0);
        }
        txfTelefone = new JFormattedTextField(formatoTelefone);
        lbl_telefone = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lbl_bairro = new javax.swing.JLabel();
        lbl_rua = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sep_formulario = new javax.swing.JSeparator();
        btnContinuarPedido = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        pnlPedido = new javax.swing.JPanel();
        txtCliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbSelecionar = new javax.swing.JComboBox();
        btnValor = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnAdiciona = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnCalcular = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFuncionario = new javax.swing.JTable();
        btnFecharPedido = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade1 = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        setClosable(true);
        setTitle("PEDIDO");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        cbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPesquisaActionPerformed(evt);
            }
        });

        lbl_codigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Código");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(255, 51, 51));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lbl_telefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_telefone.setText("Telefone:");

        lbl_data.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data.setText("Data:");

        txtData.setEditable(false);

        lbl_bairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_bairro.setText("Bairro:");

        lbl_rua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_rua.setText("Rua:");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome:");

        btnContinuarPedido.setText("Continuar Pedido");
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

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_codigo)
            .addComponent(sep_formulario, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(lbl_codigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_rua, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_bairro, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_telefone, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlClienteLayout.createSequentialGroup()
                                .addComponent(txfTelefone)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_data)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtBairro)
                            .addComponent(txtRua)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlClienteLayout.createSequentialGroup()
                            .addComponent(btnPesquisar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(pnlClienteLayout.createSequentialGroup()
                            .addComponent(btnContinuarPedido)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFechar))))
                .addContainerGap())
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sep_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_data)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_rua)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_bairro)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_telefone)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_formulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuarPedido)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pnlPai.addTab("Cliente", pnlCliente);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Selecionar:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Item:");

        btnValor.setText("Valor");

        lblValor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblValor.setText("Valor:");

        lblQuantidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblQuantidade.setText("Quantidade:");

        btnAdiciona.setText("+");

        btnRemove.setText("-");

        btnCalcular.setText("Calcular");

        lblTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTotal.setText("Total:");

        tblFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Item", "Descrição", "Valor UNT", "Total"
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

        btnFecharPedido.setText("Fechar");
        btnFecharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharPedidoActionPerformed(evt);
            }
        });

        btnFinalizar.setText("Finalizar");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Código:");

        javax.swing.GroupLayout pnlPedidoLayout = new javax.swing.GroupLayout(pnlPedido);
        pnlPedido.setLayout(pnlPedidoLayout);
        pnlPedidoLayout.setHorizontalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCliente)
            .addComponent(jSeparator1)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPedidoLayout.createSequentialGroup()
                        .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPedidoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtItem))
                            .addGroup(pnlPedidoLayout.createSequentialGroup()
                                .addComponent(btnValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblQuantidade)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPedidoLayout.createSequentialGroup()
                                .addComponent(txtQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQuantidade))
                            .addComponent(cbSelecionar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlPedidoLayout.createSequentialGroup()
                        .addComponent(btnAdiciona)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPedidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFecharPedido)))
                .addContainerGap())
        );
        pnlPedidoLayout.setVerticalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValor)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdiciona)
                    .addComponent(btnRemove)
                    .addComponent(btnCalcular)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFecharPedido)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

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

    private void tblFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuncionarioMousePressed

    }//GEN-LAST:event_tblFuncionarioMousePressed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        cbPesquisa.removeAllItems();
        lista.clear();
        String pesquisa = JOptionPane.showInputDialog(null, "Entre com o nome do cliente:", "PESQUISA DE CLIENTE", 3);
        clienteController.controlePesquisa(pesquisa, lista);
        for (String string : lista) {
            cbPesquisa.addItem(string);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPesquisaActionPerformed
        if (!(cbPesquisa.getSelectedItem() == null)) {
            String codigo = cbPesquisa.getSelectedItem().toString();
            codigo = codigo.substring(0, codigo.indexOf(" "));
            clienteBeans = clienteController.controlePreenchimento(Integer.parseInt(codigo));
            txtCodigo.setText(clienteBeans.getCodigo() + "");
            txtNome.setText(clienteBeans.getNome());
            txtRua.setText(clienteBeans.getRua());
            txtBairro.setText(clienteBeans.getBairro());
            txfTelefone.setText(clienteBeans.getTelefone());
            txtData.setText(clienteBeans.getDataCad());
        }
    }//GEN-LAST:event_cbPesquisaActionPerformed

    private void btnContinuarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarPedidoActionPerformed
        pnlPai.setEnabledAt(1, true);
        pnlPai.setEnabledAt(0, false);
        pnlPai.setSelectedIndex(1);
    }//GEN-LAST:event_btnContinuarPedidoActionPerformed

    private void btnFecharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharPedidoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdiciona;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnContinuarPedido;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFecharPedido;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnValor;
    private javax.swing.JComboBox cbPesquisa;
    private javax.swing.JComboBox cbSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lbl_bairro;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_rua;
    private javax.swing.JLabel lbl_telefone;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JTabbedPane pnlPai;
    private javax.swing.JPanel pnlPedido;
    private javax.swing.JSeparator sep_codigo;
    private javax.swing.JSeparator sep_formulario;
    private javax.swing.JTable tblFuncionario;
    private javax.swing.JFormattedTextField txfTelefone;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtQuantidade1;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txtCodigo.setEditable(valor);
        txtNome.setEditable(valor);
        txtRua.setEditable(valor);
        txtBairro.setEditable(valor);
        txfTelefone.setEditable(valor);
        txtData.setEditable(valor);
    }

}