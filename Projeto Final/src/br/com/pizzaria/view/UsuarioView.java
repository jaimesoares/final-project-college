package br.com.pizzaria.view;

import br.com.pizzaria.bean.FuncionarioBean;
import br.com.pizzaria.bean.UsuarioBean;
import br.com.pizzaria.controller.UsuarioController;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UsuarioView extends javax.swing.JInternalFrame {

    UsuarioController usuarioController;
    DefaultTableModel modelo;
    UsuarioBean usuarioBeans;

    public UsuarioView() {
        initComponents();
        usuarioController = new UsuarioController();
        usuarioBeans = new UsuarioBean();
        modelo = (DefaultTableModel) tblFucnionario.getModel();
        populaListaFuncionario();
    }

    public final void populaListaFuncionario() {
        usuarioController.controleListaFuncionario(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFucnionario = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        pswSenhaConfirma = new javax.swing.JPasswordField();
        btnFechar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Manutenção de Usuário");
        setPreferredSize(new java.awt.Dimension(680, 680));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Funcionários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        tblFucnionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funcionário", "Função / Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFucnionario.getTableHeader().setReorderingAllowed(false);
        tblFucnionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblFucnionarioMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblFucnionario);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Definições de Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome de Usuário:");

        txtLogin.setEditable(false);
        txtLogin.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Senha:");

        pswSenha.setEditable(false);
        pswSenha.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Confirme sua senha:");

        pswSenhaConfirma.setEditable(false);
        pswSenhaConfirma.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(pswSenhaConfirma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(pswSenha, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswSenhaConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnFechar))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFucnionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFucnionarioMousePressed
        usuarioBeans = usuarioController.controlePreenchimento(((FuncionarioBean) modelo.getValueAt(tblFucnionario.getSelectedRow(), 0)).getCodigo());
        txtLogin.setText(usuarioBeans.getLogin());
    }//GEN-LAST:event_tblFucnionarioMousePressed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (btnNovo.getText().equals("Novo")) {

            if (usuarioController.controleDeCampos(tblFucnionario.getSelectedRow(), txtLogin.getText())) {
                btnNovo.setText("Salvar");
                btnFechar.setText("Cancelar");
                tblFucnionario.setEnabled(false);
                habilitaCampos(true);
                txtLogin.requestFocus();
                btnEditar.setEnabled(false);
                btnRemover.setEnabled(false);
            }

        } else {

            if (usuarioController.controleDeSenha(Arrays.toString(pswSenha.getPassword()), Arrays.toString(pswSenhaConfirma.getPassword()))) {
                if (usuarioController.controleDadosNovo(populaUsuarioBeans())) {
                    btnNovo.setText("Novo");
                    btnFechar.setText("Fechar");
                    habilitaCampos(false);
                    limpaTudo();
                    tblFucnionario.setEnabled(true);
                    btnEditar.setEnabled(true);
                    btnRemover.setEnabled(true);
                }
            }

        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (btnEditar.getText().equals("Editar")) {

            if (usuarioController.controleDeCamposEditar(tblFucnionario.getSelectedRow(), txtLogin.getText())) {
                btnEditar.setText("Salvar");
                btnFechar.setText("Cancelar");
                tblFucnionario.setEnabled(false);
                habilitaCamposEditar(true);
                btnNovo.setEnabled(false);
                btnRemover.setEnabled(false);
            }

        } else {

            if (usuarioController.controleDeSenha(Arrays.toString(pswSenha.getPassword()), Arrays.toString(pswSenhaConfirma.getPassword()))) {
                if (usuarioController.controleDadosEditar(populaUsuarioBeans())) {
                    btnEditar.setText("Editar");
                    btnFechar.setText("Fechar");
                    habilitaCampos(false);
                    limpaTudo();
                    tblFucnionario.setEnabled(true);
                    btnNovo.setEnabled(true);
                    btnRemover.setEnabled(true);
                }
            }

        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        if (btnFechar.getText().equals("Cancelar")) {
            limpaTudo();
            if (btnEditar.getText().equals("Salvar")) {
                btnEditar.setText("Editar");
                btnNovo.setEnabled(true);
                habilitaCampos(false);
            } else {
                btnNovo.setText("Novo");
                btnFechar.setText("Fechar");
                btnEditar.setEnabled(true);
                tblFucnionario.setEnabled(true);

                habilitaCampos(false);
            }
            btnFechar.setText("Fechar");
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tblFucnionario.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionário!", "SELEÇÃO INVÁLIDA", 1);

        } else {
            JOptionPane.showMessageDialog(null, "Implementar método que inativa este usuário!\nEm Breve!");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JPasswordField pswSenhaConfirma;
    private javax.swing.JTable tblFucnionario;
    private javax.swing.JTextField txtLogin;
    // End of variables declaration//GEN-END:variables

    public final void habilitaCampos(boolean valor) {
        pswSenha.setEditable(valor);
        pswSenhaConfirma.setEditable(valor);
        txtLogin.setEditable(valor);
    }

    public final void habilitaCamposEditar(boolean valor) {
        pswSenha.setEditable(valor);
        pswSenhaConfirma.setEditable(valor);
    }

    public UsuarioBean populaUsuarioBeans() {
        usuarioBeans.setSenha(new String(pswSenha.getPassword()));
        usuarioBeans.setLogin(txtLogin.getText());
        usuarioBeans.setCodigoFuncionario(((FuncionarioBean) modelo.getValueAt(tblFucnionario.getSelectedRow(), 0)).getCodigo());
        return usuarioBeans;
    }

    public void limpaTudo() {
        pswSenha.setText("");
        pswSenhaConfirma.setText("");
        txtLogin.setText("");
    }

}
