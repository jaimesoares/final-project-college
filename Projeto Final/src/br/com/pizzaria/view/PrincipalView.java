package br.com.pizzaria.view;

import br.com.pizzaria.util.FundoDeTela;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class PrincipalView extends javax.swing.JFrame {

    FundoDeTela Desktop;
    ClienteView clienteV;
    FuncionarioView funcionarioV;
    EntregadorView entregadorV;
    ProdutoView cardapioV;
    PedidoView pedidoV;
    SobreView sobreV;

    public PrincipalView() {
        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridLayout());
        mniCliente.setIcon(new ImageIcon("imagens/mais.png"));

        Desktop = new FundoDeTela("imagens/pizza_fundo.jpg");
        getContentPane().add(Desktop);
        Desktop.setVisible(true);
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
        JM_Movimentacao = new javax.swing.JMenu();
        mniPedido = new javax.swing.JMenuItem();
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

        jMenuBar1.add(JM_Manutencao);

        JM_Movimentacao.setText("Movimentação");

        mniPedido.setText("Pedido");
        mniPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPedidoActionPerformed(evt);
            }
        });
        JM_Movimentacao.add(mniPedido);

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
        clienteV = new ClienteView();
        Desktop.add(clienteV);
        clienteV.setVisible(true);
    }//GEN-LAST:event_mniClienteActionPerformed

    private void mniFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFuncionarioActionPerformed
        funcionarioV = new FuncionarioView();
        Desktop.add(funcionarioV);
        funcionarioV.setVisible(true);
    }//GEN-LAST:event_mniFuncionarioActionPerformed

    private void mniEntregadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEntregadorActionPerformed
        entregadorV = new EntregadorView();
        Desktop.add(entregadorV);
        entregadorV.setVisible(true);
    }//GEN-LAST:event_mniEntregadorActionPerformed

    private void mniCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCardapioActionPerformed
        cardapioV = new ProdutoView();
        Desktop.add(cardapioV);
        cardapioV.setVisible(true);
    }//GEN-LAST:event_mniCardapioActionPerformed

    private void mniPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPedidoActionPerformed
        pedidoV = new PedidoView();
        Desktop.add(pedidoV);
        pedidoV.setVisible(true);
    }//GEN-LAST:event_mniPedidoActionPerformed

    private void mniSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSobreActionPerformed
        sobreV = new SobreView();
        sobreV.setVisible(true);
    }//GEN-LAST:event_mniSobreActionPerformed

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
    private javax.swing.JMenu mnSobre;
    private javax.swing.JMenuItem mniCardapio;
    private javax.swing.JMenuItem mniCliente;
    private javax.swing.JMenuItem mniEntregador;
    private javax.swing.JMenuItem mniFuncionario;
    private javax.swing.JMenuItem mniPedido;
    private javax.swing.JMenuItem mniSobre;
    // End of variables declaration//GEN-END:variables

}
