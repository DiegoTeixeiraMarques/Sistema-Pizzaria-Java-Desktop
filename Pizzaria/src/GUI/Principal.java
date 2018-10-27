package GUI;

import Utilitarios.Conexao;
import Utilitarios.FundoTela;
import java.awt.GridLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Principal extends javax.swing.JFrame {

    FundoTela tela;
    ClienteTela clienteTela;
    FuncionarioTela funcionarioTela;
    EntregadorTela entregadorTela;
    CardapioTela cardapioTela;
    PedidoTela pedidoTela;
    Connection conexao = null;
    TelaPedidos telaPedidos;

    public Principal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new GridLayout());
        tela = new FundoTela("/Icones/pizza-fundo.jpg");
        getContentPane().add(tela);

        menu_clientes.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_clientes.png")));
        menu_funcionarios.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_func.png")));
        menu_cardapio.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_cardapio.png")));
        menu_entregador.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_boy.png")));

        menu_cadastro.setIcon(new ImageIcon(getClass().getResource("/Icones/inserir-32.png")));
        menu_caixa.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_caixa.png")));
        menu_relatorios.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_rel.png")));
        tela_pedido.setIcon(new ImageIcon(getClass().getResource("")));
        menu_pedidos.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_clientes.png")));
        menu_tela.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_clientes.png")));
        menu_sair.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        ImageIcon icone = new ImageIcon(getClass().getResource("/Icones/ico_cardapio.png"));
        setIconImage(icone.getImage());

        conexao = Conexao.getConnection();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menu_cadastro = new javax.swing.JMenu();
        menu_clientes = new javax.swing.JMenuItem();
        menu_funcionarios = new javax.swing.JMenuItem();
        menu_cardapio = new javax.swing.JMenuItem();
        menu_entregador = new javax.swing.JMenuItem();
        menu_caixa = new javax.swing.JMenu();
        menu_pedidos = new javax.swing.JMenuItem();
        menu_relatorios = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        tela_pedido = new javax.swing.JMenu();
        menu_tela = new javax.swing.JMenuItem();
        menu_sair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzaria Teste");

        menu_cadastro.setText("Cadastro");
        menu_cadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menu_clientes.setText("Clientes");
        menu_clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_clientesActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_clientes);

        menu_funcionarios.setText("Funcionários");
        menu_funcionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_funcionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_funcionariosActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_funcionarios);

        menu_cardapio.setText("Cardápio");
        menu_cardapio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_cardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_cardapioActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_cardapio);

        menu_entregador.setText("Entregador");
        menu_entregador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_entregador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_entregadorActionPerformed(evt);
            }
        });
        menu_cadastro.add(menu_entregador);

        jMenuBar1.add(menu_cadastro);

        menu_caixa.setText("Caixa");
        menu_caixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menu_pedidos.setText("Pedidos");
        menu_pedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_pedidosActionPerformed(evt);
            }
        });
        menu_caixa.add(menu_pedidos);

        jMenuBar1.add(menu_caixa);

        menu_relatorios.setText("Relatórios");
        menu_relatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem1.setText("Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_relatorios.add(jMenuItem1);

        jMenuItem2.setText("Pedidos");
        menu_relatorios.add(jMenuItem2);

        jMenuBar1.add(menu_relatorios);

        tela_pedido.setText("Tela Pedido");
        tela_pedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menu_tela.setText("Tela");
        menu_tela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_telaActionPerformed(evt);
            }
        });
        tela_pedido.add(menu_tela);

        jMenuBar1.add(tela_pedido);

        menu_sair.setText("Sair");
        menu_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_sairActionPerformed(evt);
            }
        });
        jMenuBar1.add(menu_sair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_clientesActionPerformed
        clienteTela = new ClienteTela();
        tela.add(clienteTela);
        clienteTela.setVisible(true);
    }//GEN-LAST:event_menu_clientesActionPerformed

    private void menu_funcionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_funcionariosActionPerformed
        funcionarioTela = new FuncionarioTela();
        tela.add(funcionarioTela);
        funcionarioTela.setVisible(true);
    }//GEN-LAST:event_menu_funcionariosActionPerformed

    private void menu_entregadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_entregadorActionPerformed
        entregadorTela = new EntregadorTela();
        tela.add(entregadorTela);
        entregadorTela.setVisible(true);
    }//GEN-LAST:event_menu_entregadorActionPerformed

    private void menu_cardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_cardapioActionPerformed
        cardapioTela = new CardapioTela();
        tela.add(cardapioTela);
        cardapioTela.setVisible(true);
    }//GEN-LAST:event_menu_cardapioActionPerformed

    private void menu_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_pedidosActionPerformed
        pedidoTela = new PedidoTela(2);
        tela.add(pedidoTela);
        pedidoTela.setVisible(true);
    }//GEN-LAST:event_menu_pedidosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        try {
            //Caminho Local - Arquivos não vão juntos ao .jar
            //JasperPrint print = JasperFillManager.fillReport("rel/rel_clientes.jasper", null, conexao);

            //Caminho do pacote - arquivos vãojunto ao .jar (forma correta)
            InputStream caminho = getClass().getResourceAsStream("/rel/rel_clientes.jasper");
            JasperPrint print = JasperFillManager.fillReport(caminho, null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menu_telaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_telaActionPerformed
        telaPedidos = new TelaPedidos();
        telaPedidos.setVisible(true);
    }//GEN-LAST:event_menu_telaActionPerformed

    private void menu_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_sairActionPerformed
        dispose();
    }//GEN-LAST:event_menu_sairActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenu menu_cadastro;
    private javax.swing.JMenu menu_caixa;
    private javax.swing.JMenuItem menu_cardapio;
    private javax.swing.JMenuItem menu_clientes;
    private javax.swing.JMenuItem menu_entregador;
    private javax.swing.JMenuItem menu_funcionarios;
    private javax.swing.JMenuItem menu_pedidos;
    private javax.swing.JMenu menu_relatorios;
    private javax.swing.JMenu menu_sair;
    private javax.swing.JMenuItem menu_tela;
    private javax.swing.JMenu tela_pedido;
    // End of variables declaration//GEN-END:variables

}
