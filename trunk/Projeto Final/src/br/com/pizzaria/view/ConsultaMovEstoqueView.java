package br.com.pizzaria.view;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.ProdutoBean;
import br.com.pizzaria.bean.TipoProdutoBean;
import br.com.pizzaria.controller.ConsultaMovEstoqueController;
import br.com.pizzaria.controller.ProdutoController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ConsultaMovEstoqueView extends javax.swing.JInternalFrame {

    MaskFormatter formatoData;
    ConsultaMovEstoqueController consultaEstoqueController;
    DefaultTableModel modelo;
    ProdutoController produtoController;
    List<ProdutoBean> listaProduto;
    ComboBoxModel<TipoProdutoBean> modeloTipoProd;
    List<TipoProdutoBean> listaTipoProd;
    ComboBoxModel<ProdutoBean> modeloProduto;

    ComboBoxModel<String> modeloProdData;
    List<String> listaProdData;

    public ConsultaMovEstoqueView() {

        initComponents();
        habilitarCampos(false);
        modelo = (DefaultTableModel) tblMovimentacaoEstoque.getModel();
        produtoController = new ProdutoController();

        modeloTipoProd = cbTipo.getModel();
        modeloProdData = cbData.getModel();
        modeloProduto = cbProduto.getModel();
        produtoController = new ProdutoController();

        consultaEstoqueController = new ConsultaMovEstoqueController();

        populaTipoProduto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sep_pesquisa = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimentacaoEstoque = new javax.swing.JTable();
        sep_tabela = new javax.swing.JSeparator();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSaldoAnterior = new javax.swing.JTextField();
        txtSaldoAtual = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox();
        cbProduto = new javax.swing.JComboBox();
        cbData = new javax.swing.JComboBox();
        lbl_data3 = new javax.swing.JLabel();
        txtUnidade = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("MOVIMENTAÇÃO DE ESTOQUE");
        setPreferredSize(new java.awt.Dimension(1000, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        tblMovimentacaoEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo Movimento", "E/S", "Qtd. Movimento Prod"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMovimentacaoEstoque.getTableHeader().setReorderingAllowed(false);
        tblMovimentacaoEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMovimentacaoEstoqueMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblMovimentacaoEstoque);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consulta Movimentação Estoque");
        jLabel1.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quantidade Movimento Dia"));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Saldo Anterior");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Saldo Atual");

        txtSaldoAnterior.setEditable(false);

        txtSaldoAtual.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtSaldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldoAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Data:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Tipo Produto" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        cbProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Produto" }));
        cbProduto.setEnabled(false);
        cbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProdutoActionPerformed(evt);
            }
        });

        cbData.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecionar Data" }));
        cbData.setEnabled(false);
        cbData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDataActionPerformed(evt);
            }
        });

        lbl_data3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbl_data3.setText("Unid. Med.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_data3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbData, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(sep_pesquisa)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(29, 29, 29))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_data3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMovimentacaoEstoqueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovimentacaoEstoqueMousePressed

    }//GEN-LAST:event_tblMovimentacaoEstoqueMousePressed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed

        this.dispose();

    }//GEN-LAST:event_btnFecharActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        if (cbTipo.getSelectedIndex() > 0) {
            limpaCampos();
            cbProduto.removeAllItems();
            populaListaProduto();
            cbProduto.setEnabled(true);
        } else {
            cbProduto.setEnabled(false);
            cbProduto.setSelectedIndex(0);
            limpaCampos();
        }
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProdutoActionPerformed
        if (cbProduto.getSelectedIndex() > 0) {
            //txtValor.setText(consultaEstoqueController.controleDeValor(((ProdutoBean) cbProdutos.getSelectedItem()).getCodigo()) + "");
            limpaCampos();
            cbData.removeAllItems();
            populaListaData();
            txtUnidade.setText(((ProdutoBean) modeloProduto.getSelectedItem()).getUnidadeMedida());
            cbData.setEnabled(true);

            //txtValorProd.setText(decimalFormato.format(((ProdutoBean) cbProduto.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", "."));
        } else {
            cbData.setEnabled(false);
            cbData.setSelectedIndex(0);
            limpaCampos();
        }
    }//GEN-LAST:event_cbProdutoActionPerformed

    private void cbDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDataActionPerformed
        // TODO add your handling code here:
        if (cbData.getSelectedIndex() > 0) {
            //txtValor.setText(consultaEstoqueController.controleDeValor(((ProdutoBean) cbProdutos.getSelectedItem()).getCodigo()) + "");
            limpaCampos();
            tblMovimentacaoEstoque.removeAll();
            modelo.setNumRows(0);
            populaTabela();

            //txtValorProd.setText(decimalFormato.format(((ProdutoBean) cbProduto.getSelectedItem()).getPrecoProduto().getPreco()).replace(",", "."));
        } else {
            tblMovimentacaoEstoque.removeAll();
            modelo.setNumRows(0);
            limpaCampos();
        }
    }//GEN-LAST:event_cbDataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox cbData;
    private javax.swing.JComboBox cbProduto;
    private javax.swing.JComboBox cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_data3;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblMovimentacaoEstoque;
    private javax.swing.JTextField txtSaldoAnterior;
    private javax.swing.JTextField txtSaldoAtual;
    private javax.swing.JTextField txtUnidade;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
//        txtEstado.setEditable(false);
//        txaObs.setEditable(valor);
//        txfCEP.setEditable(valor);
//        txfNascimento.setEditable(valor);
//        txfTelCelular.setEditable(valor);
//        txfTelefone.setEditable(valor);
//        txtBairro.setEditable(false);
//        txtCidade.setEditable(false);
//        txtEmail.setEditable(valor);
//        txtNome.setEditable(valor);
//        txtNumero.setEditable(valor);
//        txtRua.setEditable(false);
    }

    final ClienteBean populaClienteBeans() {

        return null;

    }

    final void limpaTudo() {
//        txtEstado.setText("");
//        txaObs.setText("");
//        txfCEP.setText("");
//        txfNascimento.setText("");
//        txfTelCelular.setText("");
//        txfTelefone.setText("");
//        txtBairro.setText("");
//        txtCidade.setText("");
//        txtCodigo.setText("");
//        txtData.setText("");
//        txtEmail.setText("");
//        txtNome.setText("");
//        txtNumero.setText("");
//        txtPesquisar.setText("");
//        txtRua.setText("");
    }

    final void limpaNovo() {
//       txtEstado.setText("");
//        txaObs.setText("");
//        txfCEP.setText("");
//        txfNascimento.setText("");
//        txfTelCelular.setText("");
//        txfTelefone.setText("");
//        txtBairro.setText("");
//        txtCidade.setText("");
//        txtEmail.setText("");
//        txtNome.setText("");
//        txtNumero.setText("");
//        txtPesquisar.setText("");
//        txtRua.setText("");
    }

    public void populaCamposCep() {
        CepBean cepBeans;

//        if (consultaEstoqueController.controleCepValido(cepBeans = consultaEstoqueController.controleCep(txfCEP.getText().replace("-", "")))) {
//            txtBairro.setText(cepBeans.getBairro());
//            txtCidade.setText(cepBeans.getCidade());
//            txtRua.setText(cepBeans.getEndereco());
//            txtEstado.setText(cepBeans.getEstado());
//        }
    }

    public static void main(String args[]) {
//        ClienteView cliente = new ClienteView();
//        cliente.setVisible(true);
    }

    public void populaTipoProduto() {
        listaTipoProd = new ArrayList<>();
        consultaEstoqueController.controleListaTipoProduto(listaTipoProd);
        for (TipoProdutoBean tipoProdutoBeans : listaTipoProd) {
            cbTipo.addItem(tipoProdutoBeans);
        }
    }

    public void populaListaProduto() {
        if (cbTipo.getSelectedIndex() > 0) {
            listaProduto = new ArrayList<>();
            // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
            consultaEstoqueController.controleDeItens(((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo(), listaProduto);
            cbProduto.addItem("Selecionar Produto");

            for (ProdutoBean prdutoBeans : listaProduto) {
                cbProduto.addItem(prdutoBeans);
            }

        } else {

            cbProduto.setSelectedIndex(0);
        }
    }

    public void populaListaData() {
        if (cbProduto.getSelectedIndex() > 0) {
            listaProdData = new ArrayList<>();
            // precoProdutoController.controleListaProduto(listaProduto, ((TipoProdutoBean) modeloTipoProd.getSelectedItem()).getCodigo());
            consultaEstoqueController.controleListaData(((ProdutoBean) modeloProduto.getSelectedItem()).getCodigo(), listaProdData);
            cbData.addItem("Selecionar Data");

            for (String data : listaProdData) {
                cbData.addItem(data);
            }

        } else {

            cbData.setSelectedIndex(0);
        }
    }

    public void populaTabela() {
        if (cbData.getSelectedIndex() > 0) {
            consultaEstoqueController.controleTabelaMovimentoEstoque(cbData.getSelectedItem().toString(), ((ProdutoBean) modeloProduto.getSelectedItem()).getCodigo(), modelo, txtSaldoAnterior, txtSaldoAtual);
        }
    }
    
    public void limpaCampos(){
        txtSaldoAnterior.setText("");
        txtSaldoAtual.setText("");
    }
}
