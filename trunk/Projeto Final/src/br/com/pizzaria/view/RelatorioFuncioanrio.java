package br.com.pizzaria.view;

import br.com.pizzaria.bean.CepBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.FornecedorBean;
import br.com.pizzaria.controller.ClienteController;
import br.com.pizzaria.controller.RelatorioClienteController;
import br.com.pizzaria.model.RelatorioClienteModel;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class RelatorioFuncioanrio extends javax.swing.JInternalFrame {

    MaskFormatter FormatoTelefone;
    MaskFormatter formatoData;
    MaskFormatter formatoCEP;
    FornecedorBean clienteBeans;
    ClienteController clienteController;
    DefaultTableModel modelo;

    RelatorioClienteController relatorioClienteController;

    public RelatorioFuncioanrio() {
        initComponents();

        clienteBeans = new FornecedorBean();
        relatorioClienteController = new RelatorioClienteController();
        modelo = (DefaultTableModel) tblCliente.getModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sep_pesquisa = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        sep_tabela = new javax.swing.JSeparator();
        btnFechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnTodosClientes = new javax.swing.JButton();
        btnCadastradosHoje = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        try{

            formatoData = new MaskFormatter("##/##/####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);
        }
        txtDataInicial = new JFormattedTextField(formatoData);
        try{

            formatoData = new MaskFormatter("##/##/####");

        }catch (Exception Erro){
            JOptionPane.showMessageDialog(null, "Data inválida", "ERRO DE FORMATAÇÃO", 0);
        }
        txtDataFinal = new JFormattedTextField(formatoData);
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("RELATÓRIO DE FUNCIONÁRIOS");
        setPreferredSize(new java.awt.Dimension(1000, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Endereço ", "Bairro", "Cidade", "Telefone", "Celular", "Dt. Inclusão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

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
        jLabel1.setText("Relatório de Funcionários");
        jLabel1.setOpaque(true);

        btnTodosClientes.setText("Todos os Funcionários");
        btnTodosClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosClientesActionPerformed(evt);
            }
        });

        btnCadastradosHoje.setText("Cadastrados Hoje");
        btnCadastradosHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastradosHojeActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listar Funcionários Cadastrados no Período de:"));

        jLabel2.setText("Data Inicial:");

        jLabel3.setText("Data Final:");

        txtDataInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataInicialKeyTyped(evt);
            }
        });

        txtDataFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDataFinalKeyTyped(evt);
            }
        });

        jButton3.setText("Listar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sep_tabela, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnCadastradosHoje)
                        .addGap(18, 18, 18)
                        .addComponent(btnTodosClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(sep_pesquisa)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTodosClientes)
                        .addComponent(btnCadastradosHoje)))
                .addGap(18, 18, 18)
                .addComponent(sep_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sep_tabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMousePressed

    }//GEN-LAST:event_tblClienteMousePressed

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

    private void txtDataInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataInicialKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtDataInicialKeyTyped

    private void txtDataFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDataFinalKeyTyped
        String caracteres = "0987654321";

        if (!caracteres.contains(evt.getKeyChar() + "")) {

            evt.consume();

        }
    }//GEN-LAST:event_txtDataFinalKeyTyped

    private void btnCadastradosHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastradosHojeActionPerformed
        modelo.setNumRows(0);
        listarFornecedorDia(VerificarData.retornoDeDataAtual(), modelo);
    }//GEN-LAST:event_btnCadastradosHojeActionPerformed

    private void btnTodosClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosClientesActionPerformed
        modelo.setNumRows(0);
        listarTodosFornecedores(modelo);
    }//GEN-LAST:event_btnTodosClientesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        modelo.setNumRows(0);
        listarFornecedorPeriodo(txtDataInicial.getText(), txtDataFinal.getText(), modelo);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastradosHoje;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnTodosClientes;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator sep_pesquisa;
    private javax.swing.JSeparator sep_tabela;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtDataFinal;
    private javax.swing.JTextField txtDataInicial;
    // End of variables declaration//GEN-END:variables

    public void listarFornecedorDia(String data, DefaultTableModel tabela) {
        String SqlSelection = "SELECT\n"
                + "  `fun_codigo`,\n"
                + "  `fun_nome`,\n"
                + "  `fun_dt_admis`,\n"
                + "  `fun_dt_demis`,\n"
                + "  `fun_nro_ender`,\n"
                + "  `fun_cpf`,\n"
                + "  `fun_rg`,\n"
                + "  `fun_tel`,\n"
                + "  `tel_cel`,\n"
                + "  `fun_email`,\n"
                + "  `fun_cargo`,\n"
                + "  `fun_salario`,\n"
                + "  `fun_vale_transp`,\n"
                + "  `fun_vale_refeicao`,\n"
                + "  `fun_ctps`,\n"
                + "  `fun_id_empresa`,\n"
                + "  `fun_permissao`,\n"
                + "  `fun_nascimento`,\n"
                + "  `fun_rua`,\n"
                + "  `fun_cep`,\n"
                + "  `fun_bairro`,\n"
                + "  `fun_cidade`,\n"
                + "  `fun_estado`,\n"
                + "  `fun_moto`,\n"
                + "  `fun_cnh`,\n"
                + "  `fun_placa_moto`\n"
                + "FROM `pizzaria`.`funcionario`"
                + "where `fun_dt_admis`='" + VerificarData.converteParaSql(data) + "';";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getString("fun_nome"), rs.getString("fun_rua"), rs.getString("fun_bairro"), rs.getString("fun_cidade"), rs.getString("fun_tel"), rs.getString("tel_cel"), VerificarData.converteParaJAVA(rs.getString("fun_dt_admis"))});
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param tabela
     */
    public void listarTodosFornecedores(DefaultTableModel tabela) {
        String SqlSelection = "select *  from `pizzaria`.`funcionario`";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getString("fun_nome"), rs.getString("fun_rua"), rs.getString("fun_bairro"), rs.getString("fun_cidade"), rs.getString("fun_tel"), rs.getString("tel_cel"), VerificarData.converteParaJAVA(rs.getString("fun_dt_admis"))});
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param dataInicial
     * @param dataFinal
     * @param tabela
     */
    public void listarFornecedorPeriodo(String dataInicial, String dataFinal, DefaultTableModel tabela) {
        String SqlSelection = "SELECT\n"
                + "  `fun_codigo`,\n"
                + "  `fun_nome`,\n"
                + "  `fun_dt_admis`,\n"
                + "  `fun_dt_demis`,\n"
                + "  `fun_nro_ender`,\n"
                + "  `fun_cpf`,\n"
                + "  `fun_rg`,\n"
                + "  `fun_tel`,\n"
                + "  `tel_cel`,\n"
                + "  `fun_email`,\n"
                + "  `fun_cargo`,\n"
                + "  `fun_salario`,\n"
                + "  `fun_vale_transp`,\n"
                + "  `fun_vale_refeicao`,\n"
                + "  `fun_ctps`,\n"
                + "  `fun_id_empresa`,\n"
                + "  `fun_permissao`,\n"
                + "  `fun_nascimento`,\n"
                + "  `fun_rua`,\n"
                + "  `fun_cep`,\n"
                + "  `fun_bairro`,\n"
                + "  `fun_cidade`,\n"
                + "  `fun_estado`,\n"
                + "  `fun_moto`,\n"
                + "  `fun_cnh`,\n"
                + "  `fun_placa_moto`\n"
                + "FROM `pizzaria`.`funcionario`"
                + "WHERE  `fun_dt_admis`  BETWEEN '" + VerificarData.converteParaSql(dataInicial) + "' AND '" + VerificarData.converteParaSql(dataFinal) + "';";

        try (PreparedStatement pstmt = ConectaBanco.getConnection().prepareStatement(SqlSelection)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                tabela.addRow(new Object[]{rs.getString("fun_nome"), rs.getString("fun_rua"), rs.getString("fun_bairro"), rs.getString("fun_cidade"), rs.getString("fun_tel"), rs.getString("tel_cel"), VerificarData.converteParaJAVA(rs.getString("fun_dt_admis"))});
            }
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClienteModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
