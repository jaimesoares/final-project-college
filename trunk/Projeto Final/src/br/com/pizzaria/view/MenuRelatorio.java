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
public class MenuRelatorio extends javax.swing.JInternalFrame {
RelatorioClienteView relatorioClienteV;
    /**
     * Creates new form MenuProdução
     */
    public MenuRelatorio() {
        initComponents();
        Timer time = new Timer(1000,ativar);
        time.start(); 
        
        btnRelatorioCliente.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK), "evento");
        btnRelatorioCliente.getActionMap().put("evento", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
               btnRelatorioClienteActionPerformed(e);
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

        btnRelatorioCliente = new javax.swing.JButton();

        setTitle("Menu Relatório");
        setPreferredSize(new java.awt.Dimension(308, 263));

        btnRelatorioCliente.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnRelatorioCliente.setForeground(new java.awt.Color(0, 51, 255));
        btnRelatorioCliente.setText("<html> Relatório de Clientes <font size='2' style='color:black'> Crtl-1 </font>");
        btnRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRelatorioCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRelatorioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioClienteActionPerformed
        // TODO add your handling code here:
        if (relatorioClienteV == null || !relatorioClienteV.isShowing()) {
            relatorioClienteV = new RelatorioClienteView(Global.principal);
            Global.principal.Desktop.add(relatorioClienteV);
            centralizaForm(relatorioClienteV);
            relatorioClienteV.setVisible(true);
        }
    }//GEN-LAST:event_btnRelatorioClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRelatorioCliente;
    // End of variables declaration//GEN-END:variables
    ActionListener ativar = (  
        new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                centralizarComponente();
            }  
          
        }  
    );
    
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
