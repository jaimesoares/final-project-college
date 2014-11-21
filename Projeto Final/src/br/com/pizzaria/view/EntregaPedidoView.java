package br.com.pizzaria.view;

import br.com.pizzaria.bean.CargoBean;
import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.FuncionarioBean;
import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.controller.CancelamentoPedidoController;
import br.com.pizzaria.controller.PedidoController;
import br.com.pizzaria.model.CancelamentoPedidoModel;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class EntregaPedidoView extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    MaskFormatter formatoData;
    MaskFormatter formatoCEP;
    PedidoBean pedidoBean;
    PedidoController pedidoController;
    DefaultTableModel modeloTabelaPedido;
    CancelamentoPedidoController cancelamentoPedidoController;

    public EntregaPedidoView() {
        initComponents();

        pedidoBean = new PedidoBean();
        cancelamentoPedidoController = new CancelamentoPedidoController();
        modeloTabelaPedido = (DefaultTableModel) tblPedido.getModel();

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
        btnCancelarPedido = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbSaiu = new javax.swing.JRadioButton();
        rbOk = new javax.swing.JRadioButton();
        rbNao = new javax.swing.JRadioButton();
        txtObs = new javax.swing.JTextField();
        lblSaiu = new javax.swing.JLabel();
        lblOk = new javax.swing.JLabel();
        lblNao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("ENTREGA DE PEDIDO");
        setPreferredSize(new java.awt.Dimension(1000, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Pedido", "Cliente ", "Telefone", "Forma Pagto.", "Vlr. Total", "Entregador", "Situação", "Hr Ped.", "Hr Sai", "Hr Ent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrega de Pedidos");
        jLabel1.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de Pedido:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 14))); // NOI18N

        btnEntrega.setText("Entrega");
        btnEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntregaActionPerformed(evt);
            }
        });

        btnBalcao.setText("Balcão");
        btnBalcao.setToolTipText("Pedidos realizados no balcão");
        btnBalcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalcaoActionPerformed(evt);
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBalcao, btnEntrega});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrega)
                    .addComponent(btnBalcao))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelarPedido.setText("Atualiza Entrega");
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Atualizar Entregador:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar Situação da Entrega", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 14))); // NOI18N

        rbSaiu.setText("Saiu p/ Entregar   HR:");

        rbOk.setText("Entrega OK          HR:");

        rbNao.setText("Não Entregue      HR:");

        lblSaiu.setText("Ok");

        lblOk.setText("Ok");

        lblNao.setText("OK");

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("Obs.:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbSaiu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSaiu))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbOk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOk))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbNao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNao))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSaiu)
                    .addComponent(lblSaiu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbOk)
                    .addComponent(lblOk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNao)
                    .addComponent(lblNao))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setText("Pedido:");

        jTextField1.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addComponent(sep_pesquisa)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnCancelarPedido))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMousePressed
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

        listarPedidoEntrega(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnEntregaActionPerformed

    private void btnBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalcaoActionPerformed
        modeloTabelaPedido.setNumRows(0);
        listarPedidoBalcao(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnBalcaoActionPerformed

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        if (cancelamentoPedidoController.controleCancelaPedido(Integer.parseInt(modeloTabelaPedido.getValueAt(tblPedido.getSelectedRow(), 0).toString()))) {

        }
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalcao;
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblNao;
    private javax.swing.JLabel lblOk;
    private javax.swing.JLabel lblSaiu;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbOk;
    private javax.swing.JRadioButton rbSaiu;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtObs;
    // End of variables declaration//GEN-END:variables

    public void listarPedidoEntrega(String data, DefaultTableModel tabela) {
        String SqlSelection = "select \n"
                + "  p.`ped_cod`,\n"
                + "  p.`ped_tipo`,\n"
                + "  c.`cli_nome`,\n"
                + "  c.`cli_telefone`,\n"
                + "  p.`ped_pagamento`,\n"
                + "  p.`ped_vlr_tot`,\n"
                + "  p.ped_hr,\n"
                + "  p.`ped_stt_canc`, \n"
                + "  p.`ped_hr_saiu`,\n"
                + "  p.`ped_hr_entrega`,\n"
                + "  p.`ped_obs_entrega`,\n"
                + "  p.`ped_entregador` "
                + "  from\n"
                + "  `pizzaria`.`pedido` p \n"
                + "  join `cliente` c \n"
                + "    on c.`cli_cod` = p.`ped_cli_cod` \n"
                + "where `ped_tipo` = 'E' \n"
                + "  and `ped_data` = '" + VerificarData.converteParaSql(data) + "' and `ped_stt_canc` <> 'C'\n"
                + "limit 0, 1000 ;";

//                 "where `ped_tipo` = 'E' and `ped_data` = '"+VerificarData.converteParaSql(data)+"'\n"
//                + ";";
        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), rs.getString("cli_nome"), rs.getString("cli_telefone"), rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), "", rs.getString("ped_stt_canc"), rs.getString("ped_hr"), rs.getString("ped_hr"), rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listarPedidoBalcao(String data, DefaultTableModel tabela) {
        String SqlSelection = "select \n"
                + "  p.`ped_cod`,\n"
                + "  p.`ped_tipo`,\n"
                + "  p.`ped_pagamento`,\n"
                + "  p.`ped_vlr_tot`,\n"
                + "  p.ped_hr,\n"
                + "  p.`ped_stt_canc`, \n"
                + "  p.`ped_hr_saiu`,\n"
                + "  p.`ped_hr_entrega`,\n"
                + "  p.`ped_obs_entrega`,\n"
                + "  p.`ped_entregador` "                
                + "  from\n"
                + "  `pizzaria`.`pedido` p \n"
                + "where `ped_tipo` = 'B' \n"
                + "  and `ped_data` = '" + VerificarData.converteParaSql(data) + "' and `ped_stt_canc` <> 'C'\n"
                + "limit 0, 1000 ;";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), "", "", rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), "", rs.getString("ped_stt_canc"), rs.getString("ped_hr"), rs.getString("ped_hr"), rs.getString("ped_hr")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public FuncionarioBean preencherCampos(int codigo) {

        FuncionarioBean funcionarioBeans = new FuncionarioBean();

        try {
            
            String SQLSelect = "select * from cargo where crg_descr = 'Entregador';";

                try (PreparedStatement pstmCargo = ConectaBanco.getConnection().prepareStatement(SQLSelect)) {

                    ResultSet rsCargo = pstmCargo.executeQuery();

                    if (rsCargo.next()) {
                        CargoBean novo = new CargoBean();
                        novo.setCodigo(rsCargo.getInt("crg_id_cargo"));                        
                        funcionarioBeans.setCargo(novo);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Impossível Preencher Campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                }
            
            
            
            
            
            String SQLSelection = "select * from funcionario where fun_codigo = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                funcionarioBeans.setCodigo(rs.getInt("fun_codigo"));
                funcionarioBeans.setNome(rs.getString("fun_nome"));
                funcionarioBeans.setTelefone(rs.getString("fun_tel"));
                funcionarioBeans.setTelCelular(rs.getString("tel_cel"));
                funcionarioBeans.setNascimento(VerificarData.converteParaJAVA(rs.getString("fun_nascimento")));
                funcionarioBeans.setRua(rs.getString("fun_rua"));
                funcionarioBeans.setNumero(rs.getInt("fun_nro_ender"));
                funcionarioBeans.setCep(rs.getString("fun_cep"));
                funcionarioBeans.setBairro(rs.getString("fun_bairro"));
                funcionarioBeans.setCidade(rs.getString("fun_cidade"));
                funcionarioBeans.setCpf(rs.getString("fun_cpf"));
                funcionarioBeans.setRg(rs.getString("fun_rg"));
                funcionarioBeans.setMoto(rs.getString("fun_moto"));
                funcionarioBeans.setPlacaMoto(rs.getString("fun_placa_moto"));
                funcionarioBeans.setCnh(rs.getString("fun_cnh"));

//                String SQLSelect = "select * from cargo where crg_id_cargo = '" + rs.getInt("fun_cargo") + "';";
//
//                try (PreparedStatement pstmCargo = ConectaBanco.getConnection().prepareStatement(SQLSelect)) {
//
//                    ResultSet rsCargo = pstmCargo.executeQuery();
//
//                    if (rsCargo.next()) {
//                        CargoBean novo = new CargoBean();
//                        novo.setCodigo(rsCargo.getInt("crg_id_cargo"));
//                        novo.setDescricao(rsCargo.getString("crg_descr"));
//                        funcionarioBeans.setCargo(novo);
//                    }
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(null, "Impossível Preencher Campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
//                }

                funcionarioBeans.setEstado(rs.getString("fun_ctps"));
                funcionarioBeans.setSalario(rs.getDouble("fun_salario"));
                funcionarioBeans.setValeRefeicao(rs.getDouble("fun_vale_refeicao"));
                funcionarioBeans.setValeTrans(rs.getDouble("fun_vale_transp"));
                funcionarioBeans.setEmail(rs.getString("fun_email"));
                funcionarioBeans.setDataCad(VerificarData.converteParaJAVA(rs.getString("fun_dt_admis")));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return funcionarioBeans;
    }
    
}
