package br.com.pizzaria.view;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.controller.CancelamentoPedidoController;
import br.com.pizzaria.controller.EntregaPedidoController;
import br.com.pizzaria.controller.RelatorioClienteController;
import br.com.pizzaria.util.VerificarData;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class CancelamentoPedidosView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    MaskFormatter formatoData;
    MaskFormatter formatoCEP;
    PedidoBean pedidoBean;
    EntregaPedidoController pedidoController;
    DefaultTableModel modeloTabelaPedido;
    DefaultTableModel modeloTabelaItemPedido;
    JFrame frame;
    CancelamentoPedidoController cancelamentoPedidoController;

    public CancelamentoPedidosView(JFrame frame) {
        initComponents();
        this.frame = frame;
        habilitarCampos(false);

        pedidoBean = new PedidoBean();
        cancelamentoPedidoController = new CancelamentoPedidoController();
        modeloTabelaPedido = (DefaultTableModel) tblPedido.getModel();
        modeloTabelaItemPedido = (DefaultTableModel) tblItemPedido.getModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sep_pesquisa = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        sep_tabela = new javax.swing.JSeparator();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnEntrega = new javax.swing.JButton();
        btnBalcao = new javax.swing.JButton();
        btnTodosPedidos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItemPedido = new javax.swing.JTable();
        btnCancelarPedido = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CANCELAMENTO DE PEDIDOS");
        setPreferredSize(new java.awt.Dimension(1000, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pedido", "Tipo Pedido", "Cliente ", "Telefone", "Forma Pagto.", "Vlr. Total", "Situação"
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
            tblPedido.getColumnModel().getColumn(5).setHeaderValue("Vlr. Total");
            tblPedido.getColumnModel().getColumn(6).setHeaderValue("Situação");
        }

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
        jLabel1.setText("Cancelamento de Pedidos");
        jLabel1.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Pedido:"));

        btnEntrega.setText("Entrega");
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        btnBalcao.setText("Balcão");
        btnBalcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalcaoActionPerformed(evt);
            }
        });

        btnTodosPedidos.setText("Todos");
        btnTodosPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEntrega)
                .addGap(18, 18, 18)
                .addComponent(btnBalcao)
                .addGap(18, 18, 18)
                .addComponent(btnTodosPedidos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBalcao, btnEntrega, btnTodosPedidos});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTodosPedidos)
                    .addComponent(btnEntrega)
                    .addComponent(btnBalcao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblItemPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Produto", "Preço Unit.", "Quantidade", "Total", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItemPedido.getTableHeader().setReorderingAllowed(false);
        tblItemPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblItemPedidoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblItemPedido);

        btnCancelarPedido.setText("Cancelar Pedido");
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sep_pesquisa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnCancelarPedido))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMousePressed
        modeloTabelaItemPedido.setNumRows(0);
        cancelamentoPedidoController.controleItemPedido(Integer.parseInt(modeloTabelaPedido.getValueAt(tblPedido.getSelectedRow(), 0).toString()), modeloTabelaItemPedido);
    }//GEN-LAST:event_tblPedidoMousePressed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
//        if (btnFechar.getText().equals("Cancelar")) {
//            limpaTudo();
//            if (btnEditar.getText().equals("Salvar")) {
//                btnEditar.setText("Editar");
//                btnNovo.setEnabled(true);
//                habilitarCampos(false);
//            } else {
//                btnNovo.setText("Novo");
//                btnFechar.setText("Fechar");
//                btnEditar.setEnabled(true);
//                tblCliente.setEnabled(true);
//                txtPesquisar.setEnabled(true);
//                habilitarCampos(false);
//            }
//            btnFechar.setText("Fechar");
//        } else {
        this.dispose();
//        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed
        modeloTabelaPedido.setNumRows(0);
        modeloTabelaItemPedido.setNumRows(0);
        cancelamentoPedidoController.controlePedidoEntrega(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnEntregaActionPerformed

    private void btnTodosPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosPedidosActionPerformed
        modeloTabelaPedido.setNumRows(0);
        modeloTabelaItemPedido.setNumRows(0);
        cancelamentoPedidoController.controleTodosPedidos(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnTodosPedidosActionPerformed

    private void btnBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalcaoActionPerformed
        modeloTabelaPedido.setNumRows(0);
        modeloTabelaItemPedido.setNumRows(0);
        cancelamentoPedidoController.controlePedidoBalcao(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnBalcaoActionPerformed

    private void tblItemPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemPedidoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblItemPedidoMousePressed

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        if (cancelamentoPedidoController.controleCancelaPedido(Integer.parseInt(modeloTabelaPedido.getValueAt(tblPedido.getSelectedRow(), 0).toString()))) {

            btnTodosPedidosActionPerformed(null);
        }
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalcao;
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnTodosPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblItemPedido;
    private javax.swing.JTable tblPedido;
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

//    final ClienteBean populaClienteBeans() {
//        pedidoBean.setNome(txtNome.getText());
//        pedidoBean.setRua(txtRua.getText());
//        pedidoBean.setBairro(txtBairro.getText());
//        pedidoBean.setDataCadastro(txtData.getText());
//        pedidoBean.setObservacao(txaObs.getText());
//        pedidoBean.setAniversario(txfNascimento.getText());
//        pedidoBean.setTelCelular(txfTelCelular.getText());
//        pedidoBean.setTelefone(txfTelefone.getText());
//        pedidoBean.setCodigoCliente(Integer.parseInt(txtCodigo.getText()));
//        pedidoBean.setEmail(txtEmail.getText());
//        pedidoBean.setEstado(txtEstado.getText());
//        pedidoBean.setCidade(txtCidade.getText());
//        return pedidoBean;
//    }
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

//        if (pedidoController.controleCepValido(cepBeans = pedidoController.controleCep(txfCEP.getText().replace("-", "")))) {
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

}
