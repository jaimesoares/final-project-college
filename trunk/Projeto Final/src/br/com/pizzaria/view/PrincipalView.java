package br.com.pizzaria.view;

import br.com.pizzaria.util.FundoDeTela;
import br.com.pizzaria.util.Global;
import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class PrincipalView extends javax.swing.JFrame {

    FundoDeTela Desktop;
    ClienteView clienteV;
    FuncionarioView funcionarioV;
    EntregadorView entregadorV;
    ProdutoView produtoV;
    EntregaPedidoView pedidoV;
    SobreView sobreV;
    UsuarioView usuarioV;
//    CozinhaView cozinhaV;
    TipoDePedidoView tipoPedidoV;
    BalcaoPedidoView balcaoV;
    DefinirModuloView moduloV;
    ModuloView moduloV2;
    FornecedorView fornecedorV;
    CargoFuncaoView cargoV;
    RelatorioClienteView relatorioClienteV;
    LoginView login;
    TipoProdutoView tipoProdutoV;
    PrecoProdutoView precoProdutoV;
    CancelamentoPedidosView cancelamentoPedidoV;

    MenuProducao menuProducao;
    MenuEstoque menuEstoque;
    MenuAjuda menuAjuda;
    MenuCompras menuCompras;
    MenuContasPagar menuContasPagar;
    MenuContasReceber menuContasReceber;
    MenuEmpresa menuManutencao;
    MenuRelatorio menuRelatorio;
    MenuVendas menuVendas;

    JInternalFrame menu;

    public PrincipalView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       // mniCliente.setIcon(new ImageIcon("imagens/mais.png"));

        Desktop = new FundoDeTela("imagens/pizza_fundo.jpg");
        getContentPane().add(Desktop);
        Desktop.setVisible(true);

        tipoPedidoV = new TipoDePedidoView(Desktop);
        habiltaMenu(false);

        menu = new JInternalFrame();
       // mnAjuda.setVisible(false);

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            public void eventDispatched(AWTEvent e) {
            }
        }, AWTEvent.KEY_EVENT_MASK);
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnEmpresa = new javax.swing.JMenu();
        mnProducao = new javax.swing.JMenu();
        mnEstoque = new javax.swing.JMenu();
        mnCompras = new javax.swing.JMenu();
        mnContasPagar = new javax.swing.JMenu();
        mnVenda = new javax.swing.JMenu();
        mnContarReceber = new javax.swing.JMenu();
        mnRelatorio = new javax.swing.JMenu();
        mnAjuda = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PIZZARIA MAMA");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jMenuBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuBar1KeyPressed(evt);
            }
        });

        mnEmpresa.setText("Empresa F1");
        mnEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnEmpresaMousePressed(evt);
            }
        });
        jMenuBar1.add(mnEmpresa);

        mnProducao.setText("Produção F2");
        mnProducao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnProducaoMousePressed(evt);
            }
        });
        jMenuBar1.add(mnProducao);

        mnEstoque.setText("Estoque F3");
        mnEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnEstoqueMousePressed(evt);
            }
        });
        jMenuBar1.add(mnEstoque);

        mnCompras.setText("Compras F4");
        mnCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnComprasMousePressed(evt);
            }
        });
        jMenuBar1.add(mnCompras);

        mnContasPagar.setText("Contas a Pagar F5");
        mnContasPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnContasPagarMousePressed(evt);
            }
        });
        jMenuBar1.add(mnContasPagar);

        mnVenda.setText("Vendas F6");
        mnVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnVendaMousePressed(evt);
            }
        });
        jMenuBar1.add(mnVenda);

        mnContarReceber.setText("Contas a Receber F7");
        mnContarReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnContarReceberMousePressed(evt);
            }
        });
        jMenuBar1.add(mnContarReceber);

        mnRelatorio.setText("Relatório F8");
        mnRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnRelatorioMousePressed(evt);
            }
        });
        jMenuBar1.add(mnRelatorio);

        mnAjuda.setText("Ajuda F9");
        mnAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnAjudaMousePressed(evt);
            }
        });
        jMenuBar1.add(mnAjuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jMenuBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuBar1KeyPressed

    }//GEN-LAST:event_jMenuBar1KeyPressed

    private void mnProducaoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnProducaoMousePressed
        // TODO add your handling code here:
        if (menu == menuProducao) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuProducao = new MenuProducao();
            Desktop.add(menuProducao);
            menuProducao.setVisible(true);
            menu = menuProducao;
        }

    }//GEN-LAST:event_mnProducaoMousePressed

    private void mnEstoqueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnEstoqueMousePressed
        if (menu == menuEstoque) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuEstoque = new MenuEstoque();
            Desktop.add(menuEstoque);
            menuEstoque.setVisible(true);
            menu = menuEstoque;
        }
    }//GEN-LAST:event_mnEstoqueMousePressed

    private void mnComprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnComprasMousePressed
        // TODO add your handling code here:
        if (menu == menuCompras) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuCompras = new MenuCompras();
            Desktop.add(menuCompras);
            menuCompras.setVisible(true);
            menu = menuCompras;
        }
    }//GEN-LAST:event_mnComprasMousePressed

    private void mnContasPagarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnContasPagarMousePressed
        // TODO add your handling code here:
        if (menu == menuContasPagar) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuContasPagar = new MenuContasPagar();
            Desktop.add(menuContasPagar);
            menuContasPagar.setVisible(true);
            menu = menuContasPagar;
        }
    }//GEN-LAST:event_mnContasPagarMousePressed

    private void mnContarReceberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnContarReceberMousePressed
        // TODO add your handling code here:
        if (menu == menuContasReceber) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuContasReceber = new MenuContasReceber();
            Desktop.add(menuContasReceber);
            menuContasReceber.setVisible(true);
            menu = menuContasReceber;
        }
    }//GEN-LAST:event_mnContarReceberMousePressed

    private void mnEmpresaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnEmpresaMousePressed
        // TODO add your handling code here:
        if (menu == menuManutencao) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuManutencao = new MenuEmpresa();
            Desktop.add(menuManutencao);
            menuManutencao.setVisible(true);
            menu = menuManutencao;
        }
    }//GEN-LAST:event_mnEmpresaMousePressed

    private void mnRelatorioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnRelatorioMousePressed
        // TODO add your handling code here:
        if (menu == menuRelatorio) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuRelatorio = new MenuRelatorio();
            Desktop.add(menuRelatorio);
            menuRelatorio.setVisible(true);
            menu = menuRelatorio;
        }
    }//GEN-LAST:event_mnRelatorioMousePressed

    private void mnAjudaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnAjudaMousePressed
        // TODO add your handling code here:
        if (menu == menuAjuda) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuAjuda = new MenuAjuda();
            Desktop.add(menuAjuda);
            menuAjuda.setVisible(true);
            menu = menuAjuda;
        }
    }//GEN-LAST:event_mnAjudaMousePressed

    private void mnVendaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnVendaMousePressed
        // TODO add your handling code here:
        if (menu == menuVendas) {
            menu.dispose();
            menu = new JInternalFrame();
        } else {
            menu.dispose();
            menuVendas = new MenuVendas();
            Desktop.add(menuVendas);
            menuVendas.setVisible(true);
            menu = menuVendas;
           
        }
    }//GEN-LAST:event_mnVendaMousePressed

    private void telaLogin() {

        login = new LoginView();
        Desktop.add(login);
        centralizaForm(login);
        login.setVisible(true);

    }

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

        PrincipalView janela = new PrincipalView();
        janela.setVisible(true);
        Global.principal = janela;

        janela.telaLogin();

        EventQueue queue = new EventQueue() {
            protected void dispatchEvent(AWTEvent event) {
                super.dispatchEvent(event);

                String a[];
                String tecla[];

                if (!event.paramString().equals("")) {
                    if (event.paramString().substring(0, 5).equals("KEY_P")) {
                        a = event.paramString().split(",");
                        tecla = a[1].split("=");
                        //System.out.println(tecla[1]);

                        switch (Integer.parseInt(tecla[1])) {
                            case 112: //F1
                                Global.principal.mnEmpresaMousePressed(null);
                                break;
                            case 113: //F2
                                Global.principal.mnProducaoMousePressed(null);
//                                try {
//                                    Runtime.getRuntime().exec("calc.exe");
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
                                break;
                            case 114: //F3
                                Global.principal.mnEstoqueMousePressed(null);
                                break;
                            case 115: //F4
                                Global.principal.mnComprasMousePressed(null);
                                break;
                            case 116: //F5
                                Global.principal.mnContasPagarMousePressed(null);
                                break;
                            case 117: //F6
                                Global.principal.mnVendaMousePressed(null);
                                break;
                            case 118: //F7
                                Global.principal.mnContarReceberMousePressed(null);
                                break;
                            case 119: //F8
                                Global.principal.mnRelatorioMousePressed(null);
                                break;
                            case 120: //F9
                                Global.principal.mnAjudaMousePressed(null);
                                break;
                            case 121: //F10
                                //Global.principal.moduloView();
                                break;
                            case 122: //F11
                                break;
                            case 123: //F12
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        };
        Toolkit.getDefaultToolkit().getSystemEventQueue().push(queue);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenu mnCompras;
    private javax.swing.JMenu mnContarReceber;
    private javax.swing.JMenu mnContasPagar;
    private javax.swing.JMenu mnEmpresa;
    private javax.swing.JMenu mnEstoque;
    private javax.swing.JMenu mnProducao;
    private javax.swing.JMenu mnRelatorio;
    private javax.swing.JMenu mnVenda;
    // End of variables declaration//GEN-END:variables

    private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = Desktop.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    public void moduloView() {
        if (moduloV2 == null || !moduloV2.isShowing()) {
            moduloV2 = new ModuloView();
            moduloV2.setVisible(true);
        }
    }

    public void habiltaMenu(boolean valor) {
        mnAjuda.setVisible(valor);
        mnCompras.setVisible(valor);
        mnContarReceber.setVisible(valor);
        mnContasPagar.setVisible(valor);
        mnEmpresa.setVisible(valor);
        mnEstoque.setVisible(valor);
        mnProducao.setVisible(valor);
        mnRelatorio.setVisible(valor);
        mnVenda.setVisible(valor);
        

    }

    public JDesktopPane getDesktop() {
        return this.Desktop;
    }
}
