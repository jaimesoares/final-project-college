/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.view;

import br.com.pizzaria.util.Global;
import java.awt.Desktop;
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
public class MenuVendas extends javax.swing.JInternalFrame {

    ClienteView clienteV;
    EntregaPedidoView pedidoV;
    CancelamentoPedidosView cancelamentoPedidoV;

    /**
     * Creates new form MenuProdução
     */
    public MenuVendas() {
        initComponents();
        Timer time = new Timer(1000, ativar);
        time.start();

        btnPedido.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK), "evento");
        btnPedido.getActionMap().put("evento", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnPedidoActionPerformed(e);
            }

        });
        btnCancelarPedido.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK), "evento");
        btnCancelarPedido.getActionMap().put("evento", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelarPedidoActionPerformed(e);
            }

        });
        btnCliente.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK), "evento");
        btnCliente.getActionMap().put("evento", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnClienteActionPerformed(e);
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

        btnPedido = new javax.swing.JButton();
        btnCancelarPedido = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();

        setTitle("Menu Vendas");
        setPreferredSize(new java.awt.Dimension(308, 263));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        btnPedido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnPedido.setForeground(new java.awt.Color(0, 51, 255));
        btnPedido.setText("<html>Pedido<font size='2' style='color:black'> Crtl-1 </font>");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });

        btnCancelarPedido.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCancelarPedido.setForeground(new java.awt.Color(0, 51, 255));
        btnCancelarPedido.setText("<html>Cancelar Pedido<font size='2' style='color:black'> Crtl-2 </font>");
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        btnCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(0, 51, 255));
        btnCliente.setText("<html>Cliente <font size='2' style='color:black'> Crtl-3 </font>");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPedido)
                    .addComponent(btnCancelarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(btnCliente))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        if (pedidoV == null || !pedidoV.isShowing()) {
            pedidoV = new EntregaPedidoView(1);
            Global.principal.Desktop.add(pedidoV);
            centralizaForm(pedidoV);
            pedidoV.setVisible(true);
        }
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        // TODO add your handling code here:
        if (cancelamentoPedidoV == null || !cancelamentoPedidoV.isShowing()) {
            cancelamentoPedidoV = new CancelamentoPedidosView(Global.principal);
            Global.principal.Desktop.add(cancelamentoPedidoV);
            centralizaForm(cancelamentoPedidoV);
            cancelamentoPedidoV.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
        if (clienteV == null || !clienteV.isShowing()) {
            clienteV = new ClienteView(Global.principal);
            Global.principal.Desktop.add(clienteV);
            centralizaForm(clienteV);
            clienteV.setVisible(true);
        }
    }//GEN-LAST:event_btnClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnPedido;
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
