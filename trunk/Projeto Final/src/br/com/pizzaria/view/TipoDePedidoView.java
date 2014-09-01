package br.com.pizzaria.view;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class TipoDePedidoView extends javax.swing.JInternalFrame {

    BalcaoPedidoView balcaoV;
    EntregaPedidoView entregaV;
    JDesktopPane desktop;

    public TipoDePedidoView(JDesktopPane desktop) {
        initComponents();
        this.desktop = desktop;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPedidoBalcao = new javax.swing.JButton();
        btnPedidoEntrega = new javax.swing.JButton();

        setClosable(true);
        setTitle("Tipo de Pedido");

        btnPedidoBalcao.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnPedidoBalcao.setForeground(new java.awt.Color(0, 51, 255));
        btnPedidoBalcao.setText("Pedido Balcão");
        btnPedidoBalcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoBalcaoActionPerformed(evt);
            }
        });

        btnPedidoEntrega.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        btnPedidoEntrega.setForeground(new java.awt.Color(0, 51, 255));
        btnPedidoEntrega.setText("Pedido Entrega");
        btnPedidoEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPedidoBalcao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPedidoEntrega))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPedidoBalcao, btnPedidoEntrega});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnPedidoBalcao, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPedidoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPedidoBalcao, btnPedidoEntrega});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedidoBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoBalcaoActionPerformed
        if (balcaoV == null || !balcaoV.isShowing()) {
            balcaoV = new BalcaoPedidoView(1);
            desktop.add(balcaoV);
            centralizaForm(balcaoV);
            balcaoV.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnPedidoBalcaoActionPerformed

    private void btnPedidoEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoEntregaActionPerformed
        if (entregaV == null || !entregaV.isShowing()) {
            entregaV = new EntregaPedidoView(1);
            desktop.add(entregaV);
            centralizaForm(entregaV);
            entregaV.setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnPedidoEntregaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedidoBalcao;
    private javax.swing.JButton btnPedidoEntrega;
    // End of variables declaration//GEN-END:variables

    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = desktop.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

}
