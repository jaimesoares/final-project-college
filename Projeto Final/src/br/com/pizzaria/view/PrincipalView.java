package br.com.pizzaria.view;

import br.com.pizzaria.util.FundoDeTela;
import br.com.pizzaria.util.Global;
import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

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
    MenuManutencao menuManutencao;
    MenuRelatorio menuRelatorio;
    MenuVendas menuVendas;

    JInternalFrame menu;

    public PrincipalView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        mniCliente.setIcon(new ImageIcon("imagens/mais.png"));

        Desktop = new FundoDeTela("imagens/pizza_fundo.jpg");
        getContentPane().add(Desktop);
        Desktop.setVisible(true);

        tipoPedidoV = new TipoDePedidoView(Desktop);
        habiltaMenu(false);

        menu = new JInternalFrame();

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
        mnProducao = new javax.swing.JMenu();
        mniCozinha = new javax.swing.JMenuItem();
        mnEstoque = new javax.swing.JMenu();
        mniCardapio = new javax.swing.JMenuItem();
        mniTipoProduto = new javax.swing.JMenuItem();
        mniPrecoProduto = new javax.swing.JMenuItem();
        mnCompras = new javax.swing.JMenu();
        mniFornecedor = new javax.swing.JMenuItem();
        mnContasPagar = new javax.swing.JMenu();
        mnVenda = new javax.swing.JMenu();
        mniPedido = new javax.swing.JMenuItem();
        mniCancelarPedido = new javax.swing.JMenuItem();
        mniCliente = new javax.swing.JMenuItem();
        mnContarReceber = new javax.swing.JMenu();
        mnEmpresa = new javax.swing.JMenu();
        mniFuncionario = new javax.swing.JMenuItem();
        mniEntregador = new javax.swing.JMenuItem();
        mniUsuario = new javax.swing.JMenuItem();
        mniModulo = new javax.swing.JMenuItem();
        mniFuncao = new javax.swing.JMenuItem();
        mnRelatorio = new javax.swing.JMenu();
        mniRelatorioCliente = new javax.swing.JMenuItem();
        mnAjuda = new javax.swing.JMenu();
        mniSobre = new javax.swing.JMenuItem();

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

        mnProducao.setText("Produção");
        mnProducao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnProducaoMousePressed(evt);
            }
        });

        mniCozinha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        mniCozinha.setText("Cozinha");
        mniCozinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCozinhaActionPerformed(evt);
            }
        });
        mnProducao.add(mniCozinha);

        jMenuBar1.add(mnProducao);

        mnEstoque.setText("Estoque");
        mnEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnEstoqueMousePressed(evt);
            }
        });

        mniCardapio.setText("Produto");
        mniCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCardapioActionPerformed(evt);
            }
        });
        mnEstoque.add(mniCardapio);

        mniTipoProduto.setText("Tipo de Produto");
        mniTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTipoProdutoActionPerformed(evt);
            }
        });
        mnEstoque.add(mniTipoProduto);

        mniPrecoProduto.setText("Preço Produto");
        mniPrecoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPrecoProdutoActionPerformed(evt);
            }
        });
        mnEstoque.add(mniPrecoProduto);

        jMenuBar1.add(mnEstoque);

        mnCompras.setText("Compras");
        mnCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnComprasMousePressed(evt);
            }
        });

        mniFornecedor.setText("Fornecedor");
        mniFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFornecedorActionPerformed(evt);
            }
        });
        mnCompras.add(mniFornecedor);

        jMenuBar1.add(mnCompras);

        mnContasPagar.setText("Contas a Pagar");
        mnContasPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnContasPagarMousePressed(evt);
            }
        });
        jMenuBar1.add(mnContasPagar);

        mnVenda.setText("Vendas");
        mnVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnVendaMousePressed(evt);
            }
        });

        mniPedido.setText("Pedido");
        mniPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPedidoActionPerformed(evt);
            }
        });
        mnVenda.add(mniPedido);

        mniCancelarPedido.setText("Cancelar Pedido");
        mniCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCancelarPedidoActionPerformed(evt);
            }
        });
        mnVenda.add(mniCancelarPedido);

        mniCliente.setText("Cliente");
        mniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniClienteActionPerformed(evt);
            }
        });
        mnVenda.add(mniCliente);

        jMenuBar1.add(mnVenda);

        mnContarReceber.setText("Contas a Receber");
        mnContarReceber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnContarReceberMousePressed(evt);
            }
        });
        jMenuBar1.add(mnContarReceber);

        mnEmpresa.setText("Empresa");
        mnEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnEmpresaMousePressed(evt);
            }
        });

        mniFuncionario.setText("Funcionário");
        mniFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFuncionarioActionPerformed(evt);
            }
        });
        mnEmpresa.add(mniFuncionario);

        mniEntregador.setText("Entregador");
        mniEntregador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEntregadorActionPerformed(evt);
            }
        });
        mnEmpresa.add(mniEntregador);

        mniUsuario.setText("Usuário");
        mniUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniUsuarioActionPerformed(evt);
            }
        });
        mnEmpresa.add(mniUsuario);

        mniModulo.setText("Módulo");
        mniModulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniModuloActionPerformed(evt);
            }
        });
        mnEmpresa.add(mniModulo);

        mniFuncao.setText("Função / Cargo");
        mniFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFuncaoActionPerformed(evt);
            }
        });
        mnEmpresa.add(mniFuncao);

        jMenuBar1.add(mnEmpresa);

        mnRelatorio.setText("Relatório");
        mnRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnRelatorioMousePressed(evt);
            }
        });

        mniRelatorioCliente.setText("Relatório de Clientes");
        mniRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRelatorioClienteActionPerformed(evt);
            }
        });
        mnRelatorio.add(mniRelatorioCliente);

        jMenuBar1.add(mnRelatorio);

        mnAjuda.setText("Ajuda");
        mnAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnAjudaMousePressed(evt);
            }
        });

        mniSobre.setText("Sobre");
        mniSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSobreActionPerformed(evt);
            }
        });
        mniSobre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mniSobreKeyPressed(evt);
            }
        });
        mnAjuda.add(mniSobre);

        jMenuBar1.add(mnAjuda);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniClienteActionPerformed
        if (clienteV == null || !clienteV.isShowing()) {
            clienteV = new ClienteView(PrincipalView.this);
            Desktop.add(clienteV);
            centralizaForm(clienteV);
            clienteV.setVisible(true);
        }
    }//GEN-LAST:event_mniClienteActionPerformed

    private void mniFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFuncionarioActionPerformed
        if (funcionarioV == null || !funcionarioV.isShowing()) {
            funcionarioV = new FuncionarioView();
            Desktop.add(funcionarioV);
            centralizaForm(funcionarioV);
            funcionarioV.setVisible(true);
        }
    }//GEN-LAST:event_mniFuncionarioActionPerformed

    private void mniEntregadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEntregadorActionPerformed
        if (entregadorV == null || !entregadorV.isShowing()) {
            entregadorV = new EntregadorView();
            Desktop.add(entregadorV);
            centralizaForm(entregadorV);
            entregadorV.setVisible(true);
        }
    }//GEN-LAST:event_mniEntregadorActionPerformed

    private void mniCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCardapioActionPerformed
        if (produtoV == null || !produtoV.isShowing()) {
            produtoV = new ProdutoView();
            Desktop.add(produtoV);
            centralizaForm(produtoV);
            produtoV.setVisible(true);
        }
    }//GEN-LAST:event_mniCardapioActionPerformed

    private void mniPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPedidoActionPerformed
        if (pedidoV == null || !pedidoV.isShowing()) {
            pedidoV = new EntregaPedidoView(1);
            Desktop.add(pedidoV);
            centralizaForm(pedidoV);
            pedidoV.setVisible(true);
        }

//        if (tipoPedidoV == null || !tipoPedidoV.isShowing()) {
//            Desktop.add(tipoPedidoV);
//            centralizaForm(tipoPedidoV);
//            tipoPedidoV.setVisible(true);
//        }
//        if (balcaoV == null || !balcaoV.isShowing()) {
//            balcaoV = new BalcaoPedidoView(1);
//            Desktop.add(balcaoV);
//            centralizaForm(balcaoV);
//            balcaoV.setVisible(true);
//        }
    }//GEN-LAST:event_mniPedidoActionPerformed

    private void mniUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniUsuarioActionPerformed
        if (usuarioV == null || !usuarioV.isShowing()) {
            usuarioV = new UsuarioView();
            Desktop.add(usuarioV);
            centralizaForm(usuarioV);
            usuarioV.setVisible(true);
        }

    }//GEN-LAST:event_mniUsuarioActionPerformed

    private void mniCozinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCozinhaActionPerformed
//        if (cozinhaV == null || !cozinhaV.isShowing()) {
//            cozinhaV = new CozinhaView();
//            cozinhaV.setVisible(true);
//        }
    }//GEN-LAST:event_mniCozinhaActionPerformed

    private void mniModuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniModuloActionPerformed
        if (moduloV == null || !moduloV.isShowing()) {
            moduloV = new DefinirModuloView();
            Desktop.add(moduloV);
            centralizaForm(moduloV);
            moduloV.setVisible(true);
        }

//        if (moduloV2 == null || !moduloV2.isShowing()) {
//            moduloV2 = new ModuloView();
//            Desktop.add(moduloV2);
//            centralizaForm(moduloV2);
//            moduloV2.setVisible(true);
//        }
    }//GEN-LAST:event_mniModuloActionPerformed

    private void mniFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFornecedorActionPerformed
        if (fornecedorV == null || !fornecedorV.isShowing()) {
            fornecedorV = new FornecedorView();
            Desktop.add(fornecedorV);
            centralizaForm(fornecedorV);
            fornecedorV.setVisible(true);
        }
    }//GEN-LAST:event_mniFornecedorActionPerformed

    private void mniFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFuncaoActionPerformed
        if (cargoV == null || !cargoV.isShowing()) {
            cargoV = new CargoFuncaoView();
            Desktop.add(cargoV);
            centralizaForm(cargoV);
            cargoV.setVisible(true);
        }
    }//GEN-LAST:event_mniFuncaoActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void jMenuBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuBar1KeyPressed

    }//GEN-LAST:event_jMenuBar1KeyPressed

    private void mniRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRelatorioClienteActionPerformed
        if (relatorioClienteV == null || !relatorioClienteV.isShowing()) {
            relatorioClienteV = new RelatorioClienteView(PrincipalView.this);
            Desktop.add(relatorioClienteV);
            centralizaForm(relatorioClienteV);
            relatorioClienteV.setVisible(true);
        }
    }//GEN-LAST:event_mniRelatorioClienteActionPerformed

    private void mniTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTipoProdutoActionPerformed
        if (tipoProdutoV == null || !tipoProdutoV.isShowing()) {
            tipoProdutoV = new TipoProdutoView();
            Desktop.add(tipoProdutoV);
            centralizaForm(tipoProdutoV);
            tipoProdutoV.setVisible(true);
        }
    }//GEN-LAST:event_mniTipoProdutoActionPerformed

    private void mniPrecoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPrecoProdutoActionPerformed
        if (precoProdutoV == null || !precoProdutoV.isShowing()) {
            precoProdutoV = new PrecoProdutoView();
            Desktop.add(precoProdutoV);
            centralizaForm(precoProdutoV);
            precoProdutoV.setVisible(true);
        }
    }//GEN-LAST:event_mniPrecoProdutoActionPerformed

    private void mniCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCancelarPedidoActionPerformed
        if (cancelamentoPedidoV == null || !cancelamentoPedidoV.isShowing()) {
            cancelamentoPedidoV = new CancelamentoPedidosView(this);
            Desktop.add(cancelamentoPedidoV);
            centralizaForm(cancelamentoPedidoV);
            cancelamentoPedidoV.setVisible(true);
        }
    }//GEN-LAST:event_mniCancelarPedidoActionPerformed

    private void mniSobreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mniSobreKeyPressed

    }//GEN-LAST:event_mniSobreKeyPressed

    private void mniSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSobreActionPerformed
        sobreV = new SobreView();
        sobreV.setVisible(true);
    }//GEN-LAST:event_mniSobreActionPerformed

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
            menuManutencao = new MenuManutencao();
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
                                //JOptionPane.showMessageDialog(null, "Pressionou F1!");
                                break;
                            case 113: //F2
//                                try {
//                                    Runtime.getRuntime().exec("calc.exe");
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
                                break;
                            case 114: //F3

                                break;
                            case 115: //F4
                                break;
                            case 116: //F5
                                //JOptionPane.showMessageDialog(null, "Pressionou F5!");
                                break;
                            case 117: //F6
                                break;
                            case 118: //F7
                                break;
                            case 119: //F8
                                break;
                            case 120: //F9
                                // JOptionPane.showMessageDialog(null, "Pressionou F9!");
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
    private javax.swing.JMenuItem mniCancelarPedido;
    private javax.swing.JMenuItem mniCardapio;
    private javax.swing.JMenuItem mniCliente;
    private javax.swing.JMenuItem mniCozinha;
    private javax.swing.JMenuItem mniEntregador;
    private javax.swing.JMenuItem mniFornecedor;
    private javax.swing.JMenuItem mniFuncao;
    private javax.swing.JMenuItem mniFuncionario;
    private javax.swing.JMenuItem mniModulo;
    private javax.swing.JMenuItem mniPedido;
    private javax.swing.JMenuItem mniPrecoProduto;
    private javax.swing.JMenuItem mniRelatorioCliente;
    private javax.swing.JMenuItem mniSobre;
    private javax.swing.JMenuItem mniTipoProduto;
    private javax.swing.JMenuItem mniUsuario;
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
        mniCardapio.setEnabled(valor);
        mniCliente.setEnabled(valor);
        mniCozinha.setEnabled(valor);
        mniEntregador.setEnabled(valor);
        mniFuncionario.setEnabled(valor);
        mniModulo.setEnabled(valor);
        mniPedido.setEnabled(valor);
        mniRelatorioCliente.setEnabled(valor);
        mniUsuario.setEnabled(valor);
        mniFornecedor.setEnabled(valor);
        mniFuncao.setEnabled(valor);

    }

    public JDesktopPane getDesktop() {
        return this.Desktop;
    }
}
