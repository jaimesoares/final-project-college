/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.view;

import br.com.pizzaria.bean.CargoBean;
import br.com.pizzaria.bean.ClienteBean;
import br.com.pizzaria.bean.FornecedorBean;
import br.com.pizzaria.bean.FuncionarioBean;
import br.com.pizzaria.util.ConectaBanco;
import br.com.pizzaria.util.ValidaCNPJ;
import br.com.pizzaria.util.ValidaCPF;
import br.com.pizzaria.util.VerificarData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaime
 */
public class FornecedorPesquisa extends javax.swing.JDialog {

    /**
     * Creates new form ClientePesquisa
     */
    FornecedorBean fornecedorBean;
    DefaultTableModel modelo;
    ButtonGroup grupoPesquisa;

    public FornecedorPesquisa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        fornecedorBean = new FornecedorBean();
        modelo = (DefaultTableModel) tblCliente.getModel();
        grupoPesquisa = new ButtonGroup();
        grupoPesquisa.add(rbNome);
        grupoPesquisa.add(rbTelefone);
        grupoPesquisa.add(rbEndereco);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        rbNome = new javax.swing.JRadioButton();
        rbTelefone = new javax.swing.JRadioButton();
        rbEndereco = new javax.swing.JRadioButton();
        txtPesquisar = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Telefone", "CPF/CNPJ", "Contato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        rbNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbNome.setSelected(true);
        rbNome.setText("Nome");

        rbTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbTelefone.setText("Telefone");

        rbEndereco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        rbEndereco.setText("CPF/CNPJ");

        txtPesquisar.setForeground(new java.awt.Color(0, 51, 255));
        txtPesquisar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPesquisar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNome)
                    .addComponent(rbTelefone)
                    .addComponent(rbEndereco)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public FornecedorBean getFornecedorBean(){
        return fornecedorBean;
    }
    
    
    private void tblClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMousePressed
        //clienteBeans = clienteController.controlePreenchimento(Integer.parseInt(modelo.getValueAt(tblCliente.getSelectedRow(), 0).toString()));
        if (evt.getClickCount() == 2) {
            fornecedorBean = preencherCampos(((FornecedorBean) modelo.getValueAt(tblCliente.getSelectedRow(), 0)).getCodigo());
            
            this.dispose();
        }
        //txtCodigo.setText(fornecedorBean.getCodigoCliente() + "");

    }//GEN-LAST:event_tblClienteMousePressed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased

        String tipoPesquisa;
        if (rbNome.isSelected()) {
            tipoPesquisa = "nome";
        } else if (rbTelefone.isSelected()) {
            tipoPesquisa = "telefone";
        } else {
            tipoPesquisa = "cpf";
        }

        modelo.setNumRows(0);

        procuraCliente(txtPesquisar.getText(), tipoPesquisa, modelo);

//        modelo.setNumRows(0);
//        clienteController.controlePesquisa(txtPesquisar.getText(), modelo);

    }//GEN-LAST:event_txtPesquisarKeyReleased

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FornecedorPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FornecedorPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FornecedorPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FornecedorPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FornecedorPesquisa dialog = new FornecedorPesquisa(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbEndereco;
    private javax.swing.JRadioButton rbNome;
    private javax.swing.JRadioButton rbTelefone;
    private javax.swing.JTable tblCliente;
    private javax.swing.JFormattedTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables

    public void procuraCliente(String pesquisa, String tipo, DefaultTableModel modelo) {
        String SQLSelection;

        switch (tipo) {
            case "nome":
                SQLSelection = "select * from fornecedor where for_nome like '%" + pesquisa + "%';";
                break;
            case "telefone":
                SQLSelection = "select * from fornecedor where for_tel like '%" + pesquisa + "%';";
                break;
            default:
                SQLSelection = "select * from fornecedor where for_cod_pfj like '%" + pesquisa + "%';";
                break;
        }
        try {
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                FornecedorBean fornecedorBeans = new FornecedorBean();
                fornecedorBeans.setNome(rs.getString("for_nome"));
                fornecedorBeans.setTelefone(rs.getString("for_tel"));
                fornecedorBeans.setTelCelular(rs.getString("for_tel_cel"));

                 fornecedorBeans.setCep(rs.getInt("for_cep"));
                  fornecedorBeans.setEndereco(rs.getString("for_ender"));
                //fornecedorBeans.setCep(rs.getInt("for_numero"));
                fornecedorBeans.setNumero(rs.getInt("for_nro_ender"));
                fornecedorBeans.setCidade(rs.getString("for_cidade"));
                 fornecedorBeans.setBairro(rs.getString("for_bairro"));
                 fornecedorBeans.setEstado(rs.getString("for_estado"));
                // fornecedorBeans.setBairro(rs.getString("for_bairro"));
                fornecedorBeans.setPfj(rs.getString("for_cod_pfj"));
                fornecedorBeans.setDataCad(rs.getString("for_dt_cad"));
                fornecedorBeans.setContato(rs.getString("for_contato"));
                fornecedorBeans.setEmail(rs.getString("for_email"));
                fornecedorBeans.setCodigo(rs.getInt("for_id_fornec"));
                
                String cpf_cnpj = rs.getString("for_cod_pfj");
                if(ValidaCPF.isCPF(cpf_cnpj)){
                    cpf_cnpj = ValidaCPF.imprimeCPF(cpf_cnpj);
                }else if(ValidaCNPJ.isCNPJ(cpf_cnpj)){
                    cpf_cnpj = ValidaCNPJ.imprimeCNPJ(cpf_cnpj);
                }
                
                
               modelo.addRow(new Object[]{fornecedorBeans, rs.getString("for_tel"), cpf_cnpj, rs.getString("for_contato")});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível Cadastrar " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }
    }

    public FornecedorBean preencherCampos(int codigo) {

        FornecedorBean fornecedorBeans = new FornecedorBean();

        try {
            String SQLSelection = "select * from fornecedor where for_id_fornec = ?;";
            PreparedStatement pstm = ConectaBanco.getConnection().prepareStatement(SQLSelection);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                
                fornecedorBeans.setNome(rs.getString("for_nome"));
                fornecedorBeans.setTelefone(rs.getString("for_tel"));
                fornecedorBeans.setTelCelular(rs.getString("for_tel_cel"));

                 fornecedorBeans.setCep(rs.getInt("for_cep"));
                  fornecedorBeans.setEndereco(rs.getString("for_ender"));
                //fornecedorBeans.setCep(rs.getInt("for_numero"));
                fornecedorBeans.setNumero(rs.getInt("for_nro_ender"));
                fornecedorBeans.setCidade(rs.getString("for_cidade"));
                 fornecedorBeans.setBairro(rs.getString("for_bairro"));
                 fornecedorBeans.setEstado(rs.getString("for_estado"));
                // fornecedorBeans.setBairro(rs.getString("for_bairro"));
                fornecedorBeans.setPfj(rs.getString("for_cod_pfj"));
                fornecedorBeans.setDataCad(rs.getString("for_dt_cad"));
                fornecedorBeans.setContato(rs.getString("for_contato"));
                fornecedorBeans.setEmail(rs.getString("for_email"));
                fornecedorBeans.setCodigo(rs.getInt("for_id_fornec"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossível preencher os campos " + ex, "Erro de SQL", 0, new ImageIcon("imagens/cancelar.png"));
        }

        return fornecedorBeans;
    }
    
}