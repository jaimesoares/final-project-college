package br.com.pizzaria.view;

import br.com.pizzaria.bean.CargoBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.FuncionarioBean;
import br.com.pizzaria.bean.ModuloBean;
import br.com.pizzaria.bean.PedidoBean;
import br.com.pizzaria.bean.UsuarioBean;
import br.com.pizzaria.controller.CancelamentoPedidoController;
import br.com.pizzaria.controller.PedidoController;
import br.com.pizzaria.model.CancelamentoPedidoModel;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
    List<FuncionarioBean> listaFuncionario;
    boolean entrega;
    ButtonGroup grupoAlteracao;

    public EntregaPedidoView() {
        initComponents();

        pedidoBean = new PedidoBean();
        cancelamentoPedidoController = new CancelamentoPedidoController();
        modeloTabelaPedido = (DefaultTableModel) tblPedido.getModel();
        grupoAlteracao = new ButtonGroup();
        grupoAlteracao.add(rbSaiu);
        grupoAlteracao.add(rbOk);
        grupoAlteracao.add(rbNao);

        carregaEntregador();

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
        btnAtualizarPedido = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbEntregador = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rbSaiu = new javax.swing.JRadioButton();
        rbOk = new javax.swing.JRadioButton();
        rbNao = new javax.swing.JRadioButton();
        txtObs = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumPedido = new javax.swing.JTextField();

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

        btnAtualizarPedido.setText("Atualiza Entrega");
        btnAtualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarPedidoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbEntregador.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione um Entregador" }));
        cbEntregador.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel3.setText("Atualizar Entregador:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar Situação da Entrega", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Aharoni", 0, 14))); // NOI18N

        rbSaiu.setText("Saiu p/ Entregar ");
        rbSaiu.setEnabled(false);

        rbOk.setText("Entrega OK       ");
        rbOk.setEnabled(false);

        rbNao.setText("Não Entregue     ");
        rbNao.setEnabled(false);

        txtObs.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setText("Obs.:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbSaiu)
                    .addComponent(rbOk)
                    .addComponent(rbNao)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbSaiu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNao)
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
                    .addComponent(cbEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(cbEntregador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setText("Pedido:");

        txtNumPedido.setEditable(false);
        txtNumPedido.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        txtNumPedido.setForeground(new java.awt.Color(255, 0, 0));
        txtNumPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumPedidoActionPerformed(evt);
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
                        .addComponent(btnAtualizarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(txtNumPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnAtualizarPedido))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPedidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMousePressed
        txtNumPedido.setText(modeloTabelaPedido.getValueAt(tblPedido.getSelectedRow(), 0).toString());
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
        entrega = true;
        txtNumPedido.setText("");
        txtObs.setText("");
        cbEntregador.setSelectedIndex(0);
        cbEntregador.setEnabled(true);
        rbNao.setEnabled(true);
        rbOk.setEnabled(true);
        rbSaiu.setEnabled(true);
        txtObs.setEnabled(true);

        listarPedidoEntrega(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnEntregaActionPerformed

    private void btnBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalcaoActionPerformed
        modeloTabelaPedido.setNumRows(0);
        entrega = false;
        txtNumPedido.setText("");
        txtObs.setText("");
        cbEntregador.setSelectedIndex(0);
        cbEntregador.setEnabled(false);
        rbNao.setEnabled(true);
        rbOk.setEnabled(true);
        rbSaiu.setEnabled(false);
        txtObs.setEnabled(true);
        listarPedidoBalcao(VerificarData.retornoDeDataAtual(), modeloTabelaPedido);
    }//GEN-LAST:event_btnBalcaoActionPerformed

    private void btnAtualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarPedidoActionPerformed
        if (tblPedido.getSelectedRow() >= 0) {
            editarPedido();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um pedido!");
        }

    }//GEN-LAST:event_btnAtualizarPedidoActionPerformed

    private void txtNumPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumPedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarPedido;
    private javax.swing.JButton btnBalcao;
    private javax.swing.JButton btnEntrega;
    private javax.swing.JButton btnFechar;
    private javax.swing.JComboBox cbEntregador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbOk;
    private javax.swing.JRadioButton rbSaiu;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtNumPedido;
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
                String entregador = "";
                if (rs.getString("ped_entregador") != null) {
                    entregador = pesquisaEntregador(Integer.parseInt(rs.getString("ped_entregador"))).getNome();
                }
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), rs.getString("cli_nome"), rs.getString("cli_telefone"), rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), entregador, rs.getString("ped_stt_canc"), rs.getString("ped_hr"), rs.getString("ped_hr_saiu"), rs.getString("ped_hr_entrega")});
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
                tabela.addRow(new Object[]{rs.getInt("ped_cod"), "", "", rs.getString("ped_pagamento"), rs.getString("ped_vlr_tot"), "", rs.getString("ped_stt_canc"), rs.getString("ped_hr"), rs.getString("ped_hr_saiu"), rs.getString("ped_hr_entrega")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelamentoPedidoModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FuncionarioBean pesquisaEntregador(int codigo) {

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

    public void carregaEntregador() {
        try {
            String SQLSelection = "SELECT \n"
                    + "  f.`fun_codigo`,\n"
                    + "  f.`fun_nome`,\n"
                    + "  c.`crg_descr` \n"
                    + "FROM\n"
                    + "  `funcionario` f \n"
                    + "  JOIN `cargo` c \n"
                    + "    ON c.`crg_id_cargo` = f.`fun_cargo` \n"
                    + "where c.`crg_descr` = 'Entregador' ;\n"
                    + "";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                FuncionarioBean novo = new FuncionarioBean();
                novo.setCodigo(rs.getInt("fun_codigo"));

                novo.setNome(rs.getString("fun_nome"));
                novo.getCargo().setDescricao(rs.getString("crg_descr"));
                cbEntregador.addItem(novo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível listar funcionário " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

    }

    public void editarPedido() {
//        int entregador = (cbEntregador.getSelectedIndex() == 0 ? 0 : ((FuncionarioBean) cbEntregador.getSelectedItem()).getCodigo());
        String SQLUpdate = "update `pizzaria`.`pedido`\n"
                + "set \n";
//                + "  `ped_stt_canc` = '" + (rbNao.isSelected() ? "C" : "A") + "',\n"
//                + "  `ped_hr_saiu` = '" + (rbSaiu.isSelected() ? VerificarData.retornaHoraAtual() : "") + "',\n"
//                + "  `ped_hr_entrega` = '" + (rbOk.isSelected() ? VerificarData.retornaHoraAtual() : "") + "',\n"
//                + "  `ped_obs_entrega` = '" + (txtObs.getText().isEmpty() ? "" : txtObs.getText()) + "'\n"
//                + "  `ped_entregador` = '" + (entregador == 0 ? null : entregador) + "'\n"
//                + "where `ped_cod` = '" + txtNumPedido.getText() + "';";

        if (rbNao.isSelected()) {
            SQLUpdate += "  `ped_stt_canc` = 'N', \n";
        }
        if (rbSaiu.isSelected() && modeloTabelaPedido.getValueAt(tblPedido.getSelectedRow(), 8) == null) {
            SQLUpdate += "  `ped_hr_saiu` = '" + VerificarData.retornaHoraAtual() + "', \n"
                    + "  `ped_stt_canc` = 'S', \n";
        }
        if (rbOk.isSelected() && modeloTabelaPedido.getValueAt(tblPedido.getSelectedRow(), 9) == null) {
            SQLUpdate += "  `ped_hr_entrega` = '" + VerificarData.retornaHoraAtual() + "', \n"
                    + "  `ped_stt_canc` = 'E', \n";
        }
        if (!txtObs.getText().isEmpty()) {
            SQLUpdate += "  `ped_obs_entrega` = '" + txtObs.getText() + "', \n";
        }
        if (cbEntregador.getSelectedIndex() > 0 && modeloTabelaPedido.getValueAt(tblPedido.getSelectedRow(), 5).equals("")) {
            SQLUpdate += "  `ped_entregador` = '" + ((FuncionarioBean) cbEntregador.getSelectedItem()).getCodigo() + "', \n";
        }

        SQLUpdate += "  `ped_cod` = '" + txtNumPedido.getText() + "' \n"
                + "where `ped_cod` = '" + txtNumPedido.getText() + "';";

        try (PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLUpdate)) {

            if (pstm.executeUpdate() == 1) {
                ConectaBanco.getConnection().commit();
                modeloTabelaPedido.setNumRows(0);
                if (entrega) {
                    btnEntregaActionPerformed(null);
                } else {
                    btnBalcaoActionPerformed(null);
                }
            } else {
                ConectaBanco.getConnection().rollback();
            }

            JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Cadastro efetivado", 1, new ImageIcon("imagens/ticado.png"));

        } catch (SQLException ex) {
            try {
                JOptionPane.showMessageDialog(null, "Impossível Editar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
                ConectaBanco.getConnection().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(EntregaPedidoView.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

}
