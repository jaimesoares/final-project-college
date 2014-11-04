/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.view;

import br.com.pizzaria.bean.UsuarioBean;
import br.com.pizzaria.controller.UsuarioController;
import br.com.pizzaria.util.Global;
import br.com.pizzaria.util.Som;
import br.com.pizzaria.util.ThreadTempo;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author katia
 */
public class LoginView extends javax.swing.JInternalFrame {

    private ThreadTempo thread;
    private final UsuarioBean momentUser;
    private final Som play;
    private final UsuarioController usuarioController;

    public LoginView() {
        initComponents();
        lblMensagem.setVisible(false);
        momentUser = new UsuarioBean();
        usuarioController = new UsuarioController();
        play = new Som();
        //this.login();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelLogin = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnLimpar = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();
        lblMensagem = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        lblH2O = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnAjuda = new javax.swing.JMenu();
        mniSuporte = new javax.swing.JMenuItem();

        painelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acesso ao sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 12))); // NOI18N

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsuario.setText("Usuário");

        lblSenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSenha.setText("Senha");

        txtUsuario.setText("admin");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        txtSenha.setText("admin");
        txtSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSenhaKeyPressed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLogin1.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        btnLogin1.setText("Cancelar");
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLoginLayout = new javax.swing.GroupLayout(painelLogin);
        painelLogin.setLayout(painelLoginLayout);
        painelLoginLayout.setHorizontalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsuario)
                            .addComponent(lblSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtSenha)))
                    .addGroup(painelLoginLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        painelLoginLayout.setVerticalGroup(
            painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin1)
                    .addComponent(btnLogin)
                    .addComponent(btnLimpar))
                .addContainerGap())
        );

        lblMensagem.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(0, 204, 51));
        lblMensagem.setText("Mensagem:");

        lblH2O.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lblH2O.setForeground(new java.awt.Color(0, 204, 51));
        lblH2O.setText("(Beba H2O)");

        mnAjuda.setText("Ajuda");

        mniSuporte.setText("Suporte");
        mniSuporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSuporteActionPerformed(evt);
            }
        });
        mnAjuda.add(mniSuporte);

        jMenuBar1.add(mnAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblMensagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblH2O))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(separador)
                            .addComponent(painelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblH2O)
                    .addComponent(lblMensagem))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSenhaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }//GEN-LAST:event_txtSenhaKeyPressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        if (txtUsuario.getText().isEmpty() && String.valueOf(txtSenha.getPassword()).isEmpty()) {
            play.som();
        } else {
            txtUsuario.setText("");
            txtSenha.setText("");
            lblMensagem.setVisible(false);
        }
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        this.login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        play.som();
        switch (JOptionPane.showConfirmDialog(null, "Deseja realmente finalizar o sistema?", "Finalizar sistema", JOptionPane.YES_NO_OPTION)) {
            case 0:
                System.exit(0);
                break;
        }
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void mniSuporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSuporteActionPerformed
        // TODO add your handling code here:
        SuporteView suporte = new SuporteView(Global.principal, closable);
        
        Dimension desktopSize = Global.principal.Desktop.getSize();
        Dimension jInternalFrameSize = suporte.getSize();
        suporte.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        suporte.setVisible(true);
    }//GEN-LAST:event_mniSuporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblH2O;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenuItem mniSuporte;
    private javax.swing.JPanel painelLogin;
    private javax.swing.JSeparator separador;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    final void populaUsuarioBeans() {
        momentUser.setLogin(this.txtUsuario.getText());
        momentUser.setSenha(String.valueOf(this.txtSenha.getPassword()));
    }

    public void login() {

        populaUsuarioBeans();
        if (usuarioController.verificaDados(momentUser)) {

            UsuarioBean usuarioBeans = usuarioController.controlePesquisaLogin(momentUser);

            if (usuarioBeans.getCodigoFuncionario() == 0) {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
//                lblMensagem.setText("Mensagem: Usuário não cadastrado!");
//                lblMensagem.setVisible(true);
//                thread = new ThreadTempo(lblMensagem);
//                thread.start();
//                play.som();
            } else if (usuarioBeans.getSenha().equals(momentUser.getSenha())) {
                Global.principal.habiltaMenu(true);
                Global.usuario = usuarioBeans;
//                CozinhaView cozinhaV = new CozinhaView();
//                cozinhaV.setVisible(true);
                    //Relogio relogio = new Relogio();
                //relogio.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Senha incorreta!");
//                lblMensagem.setText("Mensagem: Senha incorreta!");
//                lblMensagem.setVisible(true);
//                thread = new ThreadTempo(lblMensagem);
//                thread.start();
//                play.som();
            }
        }

    }

}
