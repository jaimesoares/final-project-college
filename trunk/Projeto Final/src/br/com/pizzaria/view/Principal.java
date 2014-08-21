package br.com.pizzaria.view;

import br.com.pizzaria.util.FundoDeTela;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Principal extends javax.swing.JFrame {

    FundoDeTela Desktop;
    ClienteView clienteV;
    
    public Principal() {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridLayout());
        JMI_Cliente.setIcon(new ImageIcon("imagens/mais.png"));
        
        Desktop = new FundoDeTela("imagens/pizza_fundo.jpg");
        getContentPane().add(Desktop);
        Desktop.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        JM_Manutencao = new javax.swing.JMenu();
        JMI_Cliente = new javax.swing.JMenuItem();
        JMI_Funcionario = new javax.swing.JMenuItem();
        JMI_Entregador = new javax.swing.JMenuItem();
        JMI_Cardapio = new javax.swing.JMenuItem();
        JM_Movimentacao = new javax.swing.JMenu();
        JMI_Pedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizza MAMA");

        JM_Manutencao.setText("Manutenção");

        JMI_Cliente.setText("Cliente");
        JMI_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_ClienteActionPerformed(evt);
            }
        });
        JM_Manutencao.add(JMI_Cliente);

        JMI_Funcionario.setText("Funcionário");
        JMI_Funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_FuncionarioActionPerformed(evt);
            }
        });
        JM_Manutencao.add(JMI_Funcionario);

        JMI_Entregador.setText("Entregador");
        JM_Manutencao.add(JMI_Entregador);

        JMI_Cardapio.setText("Cardápio");
        JM_Manutencao.add(JMI_Cardapio);

        jMenuBar1.add(JM_Manutencao);

        JM_Movimentacao.setText("Movimentação");

        JMI_Pedido.setText("Pedido");
        JM_Movimentacao.add(JMI_Pedido);

        jMenuBar1.add(JM_Movimentacao);

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

    private void JMI_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_ClienteActionPerformed
        clienteV = new ClienteView();        
        Desktop.add(clienteV);
        clienteV.setVisible(true);
    }//GEN-LAST:event_JMI_ClienteActionPerformed

    private void JMI_FuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_FuncionarioActionPerformed
        
    }//GEN-LAST:event_JMI_FuncionarioActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMI_Cardapio;
    private javax.swing.JMenuItem JMI_Cliente;
    private javax.swing.JMenuItem JMI_Entregador;
    private javax.swing.JMenuItem JMI_Funcionario;
    private javax.swing.JMenuItem JMI_Pedido;
    private javax.swing.JMenu JM_Manutencao;
    private javax.swing.JMenu JM_Movimentacao;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
    
}
