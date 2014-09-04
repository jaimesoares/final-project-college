package br.com.pizzaria.view;

import br.com.pizzaria.util.FundoDeTela;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class PrincipalView extends javax.swing.JFrame {

    FundoDeTela Desktop;
    ClienteView clienteV;
    FuncionarioView funcionarioV;
    EntregadorView entregadorV;
    ProdutoView produtoV;
    PedidoView pedidoV;
    SobreView sobreV;
    UsuarioView usuarioV;
    CozinhaView cozinhaV;
    TipoDePedidoView tipoPedidoV;
    BalcaoPedidoView balcaoV;
    DefinirModuloView moduloV;
    FornecedorView fornecedorV;
    CargoView cargoV;

    public PrincipalView() {
        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridLayout());
        mniCliente.setIcon(new ImageIcon("imagens/mais.png"));

        Desktop = new FundoDeTela("imagens/pizza_fundo.jpg");
        getContentPane().add(Desktop);
        Desktop.setVisible(true);
        
        tipoPedidoV = new TipoDePedidoView(Desktop);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        JM_Manutencao = new javax.swing.JMenu();
        mniCliente = new javax.swing.JMenuItem();
        mniFuncionario = new javax.swing.JMenuItem();
        mniEntregador = new javax.swing.JMenuItem();
        mniCardapio = new javax.swing.JMenuItem();
        mniUsuario = new javax.swing.JMenuItem();
        mniModulo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        JM_Movimentacao = new javax.swing.JMenu();
        mniPedido = new javax.swing.JMenuItem();
        mniCozinha = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnSobre = new javax.swing.JMenu();
        mniSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PIZZARIA MAMA");

        JM_Manutencao.setText("Manutenção");

        mniCliente.setText("Cliente");
        mniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniClienteActionPerformed(evt);
            }
        });
        JM_Manutencao.add(mniCliente);

        mniFuncionario.setText("Funcionário");
        mniFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFuncionarioActionPerformed(evt);
            }
        });
        JM_Manutencao.add(mniFuncionario);

        mniEntregador.setText("Entregador");
        mniEntregador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEntregadorActionPerformed(evt);
            }
        });
        JM_Manutencao.add(mniEntregador);

        mniCardapio.setText("Produto");
        mniCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCardapioActionPerformed(evt);
            }
        });
        JM_Manutencao.add(mniCardapio);

        mniUsuario.setText("Usuário");
        mniUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUsuarioActionPerformed(evt);
            }
        });
        JM_Manutencao.add(mniUsuario);

        mniModulo.setText("Módulo");
        mniModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniModuloActionPerformed(evt);
            }
        });
        JM_Manutencao.add(mniModulo);

        jMenuItem1.setText("Fornecedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JM_Manutencao.add(jMenuItem1);

        jMenuItem2.setText("Cargo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        JM_Manutencao.add(jMenuItem2);

        jMenuBar1.add(JM_Manutencao);

        JM_Movimentacao.setText("Movimentação");

        mniPedido.setText("Pedido");
        mniPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPedidoActionPerformed(evt);
            }
        });
        JM_Movimentacao.add(mniPedido);

        mniCozinha.setText("Cozinha");
        mniCozinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCozinhaActionPerformed(evt);
            }
        });
        JM_Movimentacao.add(mniCozinha);

        jMenuBar1.add(JM_Movimentacao);

        jMenu1.setText("Relatório");
        jMenuBar1.add(jMenu1);

        mnSobre.setText("Ajuda");

        mniSobre.setText("Sobre");
        mniSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSobreActionPerformed(evt);
            }
        });
        mnSobre.add(mniSobre);

        jMenuBar1.add(mnSobre);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniClienteActionPerformed
        if (clienteV == null || !clienteV.isShowing()) {
            clienteV = new ClienteView(PrincipalView.this);
            Desktop.add(clienteV);
            centralizaForm(clienteV);
            clienteV.setVisible(true);
        }
    }//GEN-LAST:event_mniClienteActionPerformed

    private void mniFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFuncionarioActionPerformed
        if (funcionarioV == null || !funcionarioV.isShowing()) {
            funcionarioV = new FuncionarioView();
            Desktop.add(funcionarioV);
            centralizaForm(funcionarioV);
            funcionarioV.setVisible(true);
        }
    }//GEN-LAST:event_mniFuncionarioActionPerformed

    private void mniEntregadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEntregadorActionPerformed
        if (entregadorV == null || !entregadorV.isShowing()) {
            entregadorV = new EntregadorView();
            Desktop.add(entregadorV);
            centralizaForm(entregadorV);
            entregadorV.setVisible(true);
        }
    }//GEN-LAST:event_mniEntregadorActionPerformed

    private void mniCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCardapioActionPerformed
        if (produtoV == null || !produtoV.isShowing()) {
            produtoV = new ProdutoView();
            Desktop.add(produtoV);
            centralizaForm(produtoV);
            produtoV.setVisible(true);
        }
    }//GEN-LAST:event_mniCardapioActionPerformed

    private void mniPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPedidoActionPerformed
//        if (pedidoV == null || !pedidoV.isShowing()) {
//            pedidoV = new PedidoView(1);
//            Desktop.add(pedidoV);
//            centralizaForm(pedidoV);
//            pedidoV.setVisible(true);
//        }

        if (tipoPedidoV == null || !tipoPedidoV.isShowing()) {            
            Desktop.add(tipoPedidoV);
            centralizaForm(tipoPedidoV);
            tipoPedidoV.setVisible(true);
        }
        
//        if (balcaoV == null || !balcaoV.isShowing()) {
//            balcaoV = new BalcaoPedidoView(1);
//            Desktop.add(balcaoV);
//            centralizaForm(balcaoV);
//            balcaoV.setVisible(true);
//        }
    }//GEN-LAST:event_mniPedidoActionPerformed

    private void mniSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSobreActionPerformed
        sobreV = new SobreView();
        sobreV.setVisible(true);
    }//GEN-LAST:event_mniSobreActionPerformed

    private void mniUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUsuarioActionPerformed
        if (usuarioV == null || !usuarioV.isShowing()) {
            usuarioV = new UsuarioView();
            Desktop.add(usuarioV);
            centralizaForm(usuarioV);
            usuarioV.setVisible(true);
        }
    }//GEN-LAST:event_mniUsuarioActionPerformed

    private void mniCozinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCozinhaActionPerformed
        if (cozinhaV == null || !cozinhaV.isShowing()) {
            cozinhaV = new CozinhaView();
            cozinhaV.setVisible(true);
        }
    }//GEN-LAST:event_mniCozinhaActionPerformed

    private void mniModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniModuloActionPerformed
        if (moduloV == null || !moduloV.isShowing()) {
            moduloV = new DefinirModuloView();
            Desktop.add(moduloV);
            centralizaForm(moduloV);
            moduloV.setVisible(true);
        }
    }//GEN-LAST:event_mniModuloActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (fornecedorV == null || !fornecedorV.isShowing()) {
            fornecedorV = new FornecedorView();
            Desktop.add(fornecedorV);
            centralizaForm(fornecedorV);
            fornecedorV.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (cargoV == null || !cargoV.isShowing()) {
            cargoV = new CargoView();
            Desktop.add(cargoV);
            centralizaForm(cargoV);
            cargoV.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JM_Manutencao;
    private javax.swing.JMenu JM_Movimentacao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu mnSobre;
    private javax.swing.JMenuItem mniCardapio;
    private javax.swing.JMenuItem mniCliente;
    private javax.swing.JMenuItem mniCozinha;
    private javax.swing.JMenuItem mniEntregador;
    private javax.swing.JMenuItem mniFuncionario;
    private javax.swing.JMenuItem mniModulo;
    private javax.swing.JMenuItem mniPedido;
    private javax.swing.JMenuItem mniSobre;
    private javax.swing.JMenuItem mniUsuario;
    // End of variables declaration//GEN-END:variables

    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = Desktop.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

}
