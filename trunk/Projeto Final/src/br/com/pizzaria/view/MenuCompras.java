/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.view;

import br.com.pizzaria.util.Global;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author Jaime
 */
public class MenuCompras extends javax.swing.JInternalFrame {

    FornecedorView fornecedorV;
    PedidoCompraView pedidoV;
    CancelaPedidoCompraView cancelaV;

    /**
     * Creates new form MenuProdução
     */
    public MenuCompras() {
        initComponents();
        Timer time = new Timer(1000, ativar);
        time.start();

        btnFornecedor.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK), "evento");
        btnFornecedor.getActionMap().put("evento", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnFornecedorActionPerformed(e);
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFornecedor = new javax.swing.JButton();
        btnFornecedor1 = new javax.swing.JButton();
        btnFornecedor2 = new javax.swing.JButton();
        btnFornecedor3 = new javax.swing.JButton();

        setTitle("Menu Compras");
        setPreferredSize(new java.awt.Dimension(308, 352));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        btnFornecedor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnFornecedor.setForeground(new java.awt.Color(0, 51, 255));
        btnFornecedor.setText("<html>Fornecedor <font size='2' style='color:black'> Crtl-1 </font>");
        btnFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedorActionPerformed(evt);
            }
        });

        btnFornecedor1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnFornecedor1.setForeground(new java.awt.Color(0, 51, 255));
        btnFornecedor1.setText("<html>Cotação <font size='2' style='color:black'> Crtl-1 </font>");
        btnFornecedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedor1ActionPerformed(evt);
            }
        });

        btnFornecedor2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnFornecedor2.setForeground(new java.awt.Color(0, 51, 255));
        btnFornecedor2.setText("<html>Pedido de Compra <font size='2' style='color:black'> Crtl-1 </font>");
        btnFornecedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedor2ActionPerformed(evt);
            }
        });

        btnFornecedor3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnFornecedor3.setForeground(new java.awt.Color(0, 51, 255));
        btnFornecedor3.setText("<html>Cancela Pedido de Compra <font size='2' style='color:black'> Crtl-1 </font>");
        btnFornecedor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedor3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(btnFornecedor1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(btnFornecedor2, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(btnFornecedor3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFornecedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFornecedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFornecedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedorActionPerformed
        if (fornecedorV == null || !fornecedorV.isShowing()) {
            fornecedorV = new FornecedorView();
            Global.principal.Desktop.add(fornecedorV);
            centralizaForm(fornecedorV);
            fornecedorV.setVisible(true);
        }
    }//GEN-LAST:event_btnFornecedorActionPerformed

    private void btnFornecedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFornecedor1ActionPerformed

    private void btnFornecedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedor2ActionPerformed
        // TODO add your handling code here:
        if (pedidoV == null || !pedidoV.isShowing()) {
            pedidoV = new PedidoCompraView();
            Global.principal.Desktop.add(pedidoV);
            centralizaForm(pedidoV);
            pedidoV.setVisible(true);
        }
    }//GEN-LAST:event_btnFornecedor2ActionPerformed

    private void btnFornecedor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedor3ActionPerformed
        // TODO add your handling code here:
        if (cancelaV == null || !cancelaV.isShowing()) {
            cancelaV = new CancelaPedidoCompraView();
            Global.principal.Desktop.add(cancelaV);
            centralizaForm(cancelaV);
            cancelaV.setVisible(true);
        }
    }//GEN-LAST:event_btnFornecedor3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFornecedor;
    private javax.swing.JButton btnFornecedor1;
    private javax.swing.JButton btnFornecedor2;
    private javax.swing.JButton btnFornecedor3;
    // End of variables declaration//GEN-END:variables
    ActionListener ativar = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            centralizarComponente();
        }

    });

    public final void centralizarComponente() {
        int x = Global.principal.getLocation().x;
        int y = Global.principal.getLocation().y;

        Dimension ds = Global.principal.getSize();
        Dimension dw = getSize();
        setLocation((0), (0));
    }

    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = Global.principal.Desktop.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }
}
