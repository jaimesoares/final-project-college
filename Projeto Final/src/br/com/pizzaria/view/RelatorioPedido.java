package br.com.pizzaria.view;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.controller.CancelamentoPedidoController;
import br.com.pizzaria.controller.PedidoController;
import br.com.pizzaria.model.CancelamentoPedidoModel;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import static br.com.pizzaria.view.CozinhaView.modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class RelatorioPedido extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    MaskFormatter formatoData;
    MaskFormatter formatoCEP;
    PedidoBean pedidoBean;
    PedidoController pedidoController;
    DefaultTableModel modeloTabelaPedido;
    DefaultTableModel modeloTabelaItemPedido;

    CancelamentoPedidoController cancelamentoPedidoController;

    public RelatorioPedido() {
        initComponents();

       

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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItemPedido = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        try{

            formatoData = new MaskFormatter("##/##/####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);
        }
        txtDataInicialE = new JFormattedTextField(formatoData);
        try{

            formatoData = new MaskFormatter("##/##/####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);
        }
        txtDataFinalE = new JFormattedTextField(formatoData);
        btnListarE = new javax.swing.JButton();
        btnEntrega = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        try{

            formatoData = new MaskFormatter("##/##/####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);
        }
        txtDataInicialB = new JFormattedTextField(formatoData);
        try{

            formatoData = new MaskFormatter("##/##/####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);
        }
        txtDataFinalB = new JFormattedTextField(formatoData);
        btnListarB = new javax.swing.JButton();
        btnBalcao = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("RELATÓRIO DE PEDIDO");
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
                "Pedido", "Tipo Pedido", "Cliente ", "Telefone", "Forma Pagto.", "Vlr. Total", "Situação", "Data", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório de Pedido");
        jLabel1.setOpaque(true);

        tblItemPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Produto", "Preço Unit.", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listar Pedidos Entrega:"));

        jLabel2.setText("Data Inicial:");

        jLabel3.setText("Data Final:");

        txtDataInicialE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataInicialEKeyTyped(evt);
            }
        });

        txtDataFinalE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataFinalEKeyTyped(evt);
            }
        });

        btnListarE.setText("Listar");
        btnListarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarEActionPerformed(evt);
            }
        });

        btnEntrega.setText("Listar Todos");
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDataInicialE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDataFinalE, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(btnEntrega))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnListarE)
                        .addComponent(btnEntrega))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInicialE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataFinalE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Listar Pedidos Balcão:"));

        jLabel4.setText("Data Inicial:");

        jLabel5.setText("Data Final:");

        txtDataInicialB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataInicialBKeyTyped(evt);
            }
        });

        txtDataFinalB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataFinalBKeyTyped(evt);
            }
        });

        btnListarB.setText("Listar");
        btnListarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarBActionPerformed(evt);
            }
        });

        btnBalcao.setText("ListarTodos");
        btnBalcao.setToolTipText("Pedidos realizados no balcão");
        btnBalcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtDataInicialB, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDataFinalB, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListarB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(btnBalcao)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnListarB)
                        .addComponent(btnBalcao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataInicialB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataFinalB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                    .addComponent(sep_pesquisa, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMousePressed
        modeloTabelaItemPedido.setNumRows(0);
        listarItemPedido(Integer.parseInt(modeloTabelaPedido.getValueAt(tblPedido.getSelectedRow(), 0).toString()), modeloTabelaItemPedido);
    }//GEN-LAST:event_tblPedidoMousePressed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Deseja sair", "Sair", JOptionPane.YES_NO_OPTION)) {
            case 0:
                this.dispose();
                break;
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntregaActionPerformed
        modeloTabelaPedido.setNumRows(0);
        modeloTabelaItemPedido.setNumRows(0);
        listarPedidoEntrega(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnEntregaActionPerformed

    private void btnBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalcaoActionPerformed
        modeloTabelaPedido.setNumRows(0);
        modeloTabelaItemPedido.setNumRows(0);
        listarPedidoBalcao(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnBalcaoActionPerformed

    private void tblItemPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemPedidoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblItemPedidoMousePressed

    private void txtDataInicialEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataInicialEKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtDataInicialEKeyTyped

    private void txtDataFinalEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataFinalEKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtDataFinalEKeyTyped

    private void btnListarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarEActionPerformed
        modeloTabelaPedido.setNumRows(0);
        modeloTabelaItemPedido.setNumRows(0);
        listarPedidoEntregaPeriodo(txtDataInicialE.getText(), txtDataFinalE.getText(), modeloTabelaPedido);
    }//GEN-LAST:event_btnListarEActionPerformed

    private void txtDataInicialBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataInicialBKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataInicialBKeyTyped

    private void txtDataFinalBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataFinalBKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtDataFinalBKeyTyped

    private void btnListarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarBActionPerformed
        // TODO add your handling code here:
         modeloTabelaPedido.setNumRows(0);
        modeloTabelaItemPedido.setNumRows(0);
        listarPedidoBalcaoPeriodo(txtDataInicialB.getText(), txtDataFinalB.getText(), modeloTabelaPedido);
    }//GEN-LAST:event_btnListarBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalcao;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnListarB;
    private javax.swing.JButton btnListarE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblItemPedido;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtDataFinalB;
    private javax.swing.JTextField txtDataFinalE;
    private javax.swing.JTextField txtDataInicialB;
    private javax.swing.JTextField txtDataInicialE;
    // End of variables declaration//GEN-END:variables

    public void listarPedidoBalcao(String data, DefaultTableModel tabela) {
        String SqlSelection = "select \n"
                + "  p.`ped_cod`,\n"
                + "  p.`ped_tipo`,\n"
                + "  p.`ped_pagamento`,\n"
                 + "  p.ped_data,\n"
                + "  p.`ped_vlr_tot`,\n"
                + "  p.ped_hr,\n"
                + "  p.`ped_stt_canc` \n"
                + " from\n"
                + "  `pizzaria`.`pedido` p \n"
                + " where `ped_tipo` = 'B' \n"
                
                + " limit 0, 1000 ;";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String situacao = "";
                switch (rs.getString("ped_stt_canc")) {
                    case "A":
                        situacao = "Aberto";
                        break;
                    case "C":
                        situacao = "Cancelado";
                        break;
                    case "S":
                        situacao = "Saiu p/ Entrega";
                        break;
                    case "E":
                        situacao = "Entrega OK";
                        break;
                    case "N":
                        situacao = "Não Entregue";
                        break;
                    default:
                        throw new AssertionError();
                }
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), "Balcão", "", "", rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"),  situacao, VerificarData.converteParaJAVA(rs.getString("ped_data")),  rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarItemPedido(int codigo, DefaultTableModel tabela) {
        String SqlSelection = "SELECT \n"
                + "  t.`tprd_descr`,\n"
                + "  c.prd_descr,\n"
                + "  i.`item_preco_unit`,\n"
                + "  i.`item_quantidade`,\n"
                + "  i.`item_preco_tot`,\n"
                + "  i.item_stt_meia_pizza \n"
                + " FROM\n"
                + "  pedido p \n"
                + "  JOIN item i \n"
                + "    ON i.item_ped_cod = p.`ped_cod` \n"
                + "  JOIN produtos c \n"
                + "    ON c.`prd_prod` = i.`item_cod_prod` \n"
                + "  JOIN `tipo_prod` t\n"
                + "    ON t.`tprd_id`=c.`prd_tipo_prod`"
                + " WHERE p.ped_cod = " + codigo + " ;\n";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String meia = "";
                if (rs.getString("item_stt_meia_pizza").equals("S")) {
                    meia = " meia";
                }
                tabela.addRow(new Object[]{rs.getString("tprd_descr") + meia, rs.getString("prd_descr"), rs.getDouble("item_preco_unit"), rs.getInt("item_quantidade"), rs.getDouble("item_preco_tot")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listarPedidoEntrega(String data, DefaultTableModel tabela) {
        String SqlSelection = "select \n"
                + "  p.`ped_cod`,\n"
                + "  p.`ped_tipo`,\n"
                + "  c.`cli_nome`,\n"
                + "  c.`cli_telefone`,\n"
                + "  p.`ped_pagamento`,\n"
                 + "  p.ped_data,\n"
                + "  p.`ped_vlr_tot`,\n"
                + "  p.ped_hr,\n"
                + "  p.`ped_stt_canc` \n"
                + " from\n"
                + "  `pizzaria`.`pedido` p \n"
                + "  join `cliente` c \n"
                + "    on c.`cli_cod` = p.`ped_cli_cod` \n"
                + " where `ped_tipo` = 'E' \n"
                
                + " limit 0, 1000 ;";

//                 "where `ped_tipo` = 'E' and `ped_data` = '"+VerificarData.converteParaSql(data)+"'\n"
//                + ";";
        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String situacao = "";
                switch (rs.getString("ped_stt_canc")) {
                    case "A":
                        situacao = "Aberto";
                        break;
                    case "C":
                        situacao = "Cancelado";
                        break;
                    case "S":
                        situacao = "Saiu p/ Entrega";
                        break;
                    case "E":
                        situacao = "Entrega OK";
                        break;
                    case "N":
                        situacao = "Não Entregue";
                        break;
                    default:
                        throw new AssertionError();
                }
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), "Entrega", rs.getString("cli_nome"), rs.getString("cli_telefone"), rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), situacao, VerificarData.converteParaJAVA(rs.getString("ped_data")), rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarPedidoBalcaoPeriodo(String dataInicial, String dataFinal, DefaultTableModel tabela) {
        String SqlSelection = "select \n"
                + "  p.`ped_cod`,\n"
                + "  p.`ped_tipo`,\n"
                + "  p.`ped_pagamento`,\n"
                + "  p.`ped_vlr_tot`,\n"
                + "  p.ped_data,\n"
                + "  p.ped_hr,\n"
                + "  p.`ped_stt_canc` \n"
                + "from\n"
                + "  `pizzaria`.`pedido` p \n"
                + "where `ped_tipo` = 'B' \n"
                + "  and `ped_data` BETWEEN '" + VerificarData.converteParaSql(dataInicial) + "' AND '" + VerificarData.converteParaSql(dataFinal) + "'"
                + " limit 0, 1000 ;";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String situacao = "";
                switch (rs.getString("ped_stt_canc")) {
                    case "A":
                        situacao = "Aberto";
                        break;
                    case "C":
                        situacao = "Cancelado";
                        break;
                    case "S":
                        situacao = "Saiu p/ Entrega";
                        break;
                    case "E":
                        situacao = "Entrega OK";
                        break;
                    case "N":
                        situacao = "Não Entregue";
                        break;
                    default:
                        throw new AssertionError();
                }
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), "Balcão", "", "", rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), situacao, VerificarData.converteParaJAVA(rs.getString("ped_data")), rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void listarPedidoEntregaPeriodo(String dataInicial, String dataFinal, DefaultTableModel tabela) {
        String SqlSelection = "select \n"
                + "  p.`ped_cod`,\n"
                + "  p.`ped_tipo`,\n"
                + "  c.`cli_nome`,\n"
                + "  c.`cli_telefone`,\n"
                + "  p.`ped_pagamento`,\n"
                 + "  p.ped_data,\n"
                + "  p.`ped_vlr_tot`,\n"
                + "  p.ped_hr,\n"
                + "  p.`ped_stt_canc` \n"
                + "from\n"
                + "  `pizzaria`.`pedido` p \n"
                + "  join `cliente` c \n"
                + "    on c.`cli_cod` = p.`ped_cli_cod` \n"
                + "where `ped_tipo` = 'E' \n"
                + "  and `ped_data` BETWEEN '" + VerificarData.converteParaSql(dataInicial) + "' AND '" + VerificarData.converteParaSql(dataFinal) + "'"
                + " limit 0, 1000 ;";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String situacao = "";
                switch (rs.getString("ped_stt_canc")) {
                    case "A":
                        situacao = "Aberto";
                        break;
                    case "C":
                        situacao = "Cancelado";
                        break;
                    case "S":
                        situacao = "Saiu p/ Entrega";
                        break;
                    case "E":
                        situacao = "Entrega OK";
                        break;
                    case "N":
                        situacao = "Não Entregue";
                        break;
                    default:
                        throw new AssertionError();
                }
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), "Entrega", rs.getString("cli_nome"), rs.getString("cli_telefone"), rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), situacao, VerificarData.converteParaJAVA(rs.getString("ped_data")), rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
