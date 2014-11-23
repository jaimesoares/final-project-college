/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.pizzaria.view;

import br.com.pizzaria.controller.CozinhaController;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class CozinhaView extends javax.swing.JFrame {
    
    CozinhaController cozinhaController;
    static DefaultTableModel modelo;
    

    public CozinhaView() {        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        cozinhaController = new CozinhaController();
        modelo = (DefaultTableModel) tblPedido.getModel();
        populaTabela();
        
    }
    
    public static void populaTabela(){        
        modelo.setNumRows(0);
        CozinhaController.controleTabela(modelo); 
    }
    
    static CozinhaView cozinhaV;
    public static void getCozinha(){
        if (cozinhaV == null || !cozinhaV.isShowing()) {
            cozinhaV = new CozinhaView();
            cozinhaV.setVisible(true);
        }else{
            populaTabela();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PEDIDOS COZINHA");
        setAutoRequestFocus(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        tblPedido.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Pedido", "Item", "Quantidade", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedido.setRowHeight(40);
        tblPedido.setRowMargin(10);
        jScrollPane1.setViewportView(tblPedido);
        if (tblPedido.getColumnModel().getColumnCount() > 0) {
            tblPedido.getColumnModel().getColumn(0).setMinWidth(90);
            tblPedido.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblPedido.getColumnModel().getColumn(0).setMaxWidth(90);
            tblPedido.getColumnModel().getColumn(2).setMinWidth(90);
            tblPedido.getColumnModel().getColumn(2).setPreferredWidth(90);
            tblPedido.getColumnModel().getColumn(2).setMaxWidth(90);
            tblPedido.getColumnModel().getColumn(3).setMinWidth(120);
            tblPedido.getColumnModel().getColumn(3).setPreferredWidth(120);
            tblPedido.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        getContentPane().add(jScrollPane1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(CozinhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CozinhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CozinhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CozinhaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CozinhaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblPedido;
    // End of variables declaration//GEN-END:variables
}
