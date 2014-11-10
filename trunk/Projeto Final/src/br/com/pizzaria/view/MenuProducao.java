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
public class MenuProducao extends javax.swing.JInternalFrame {

    CozinhaView cozinhaV;
    RequisicaoMercadoria requisicaoV;

    /**
     * Creates new form MenuProdução
     */
    public MenuProducao() {
        initComponents();
        Timer time = new Timer(1000, ativar);
        time.start();

        btnPedidoBalcao.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK), "evento");
        btnPedidoBalcao.getActionMap().put("evento", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                btnPedidoBalcaoActionPerformed(e);
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

        btnPedidoBalcao = new javax.swing.JButton();
        btnPedidoBalcao1 = new javax.swing.JButton();

        setTitle("Menu Produção");
        setPreferredSize(new java.awt.Dimension(308, 263));
        setRequestFocusEnabled(false);

        btnPedidoBalcao.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnPedidoBalcao.setForeground(new java.awt.Color(0, 51, 255));
        btnPedidoBalcao.setText("<html>Cozinha <font size='2' style='color:black'> Crtl-1 </font>");
        btnPedidoBalcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoBalcaoActionPerformed(evt);
            }
        });

        btnPedidoBalcao1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnPedidoBalcao1.setForeground(new java.awt.Color(0, 51, 255));
        btnPedidoBalcao1.setText("<html>Requisição de Material <font size='2' style='color:black'> Crtl-1 </font>");
        btnPedidoBalcao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoBalcao1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPedidoBalcao, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(btnPedidoBalcao1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPedidoBalcao, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPedidoBalcao1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedidoBalcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoBalcaoActionPerformed
//        if (cozinhaV == null || !cozinhaV.isShowing()) {
//            cozinhaV = new CozinhaView();
//            cozinhaV.setVisible(true);
//        }
        CozinhaView.getCozinha();
    }//GEN-LAST:event_btnPedidoBalcaoActionPerformed

    private void btnPedidoBalcao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoBalcao1ActionPerformed
        // TODO add your handling code here:
        if (requisicaoV == null || !requisicaoV.isShowing()) {
            requisicaoV = new RequisicaoMercadoria();
            Global.principal.Desktop.add(requisicaoV);
            centralizaForm(requisicaoV);
            requisicaoV.setVisible(true);
        }
    }//GEN-LAST:event_btnPedidoBalcao1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPedidoBalcao;
    private javax.swing.JButton btnPedidoBalcao1;
    // End of variables declaration//GEN-END:variables
    ActionListener ativar = (new ActionListener() {
        @Override
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
