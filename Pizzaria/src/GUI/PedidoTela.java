package GUI;

import Beans.ClienteBeans;
import Beans.PedidoBeans;
import Controller.ClienteControle;
import Controller.PedidoControle;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class PedidoTela extends javax.swing.JInternalFrame {

    ClienteBeans clienteB;
    PedidoBeans pedidoB;
    ClienteControle clienteC;
    PedidoControle pedidoC;
    List<String> lista;
    List<String> listaDeItens;
    DefaultTableModel modelo;
    MaskFormatter formatoTelefone;
    SimpleDateFormat formatoData, formatoHora;
    Date dataAtual;
    DecimalFormat formatoDecimal;
    int codigoFuncionario;

    public PedidoTela(int codigoFuncionario) {
        initComponents();
        habilitarCampos(false);
        lista = new ArrayList();
        listaDeItens = new ArrayList();
        clienteB = new ClienteBeans();
        clienteC = new ClienteControle();
        pedidoB = new PedidoBeans();
        pedidoC = new PedidoControle();
        painelPai.setEnabledAt(1, false);
        modelo = (DefaultTableModel) tabela.getModel();
        formatoDecimal = new DecimalFormat("0.00 ");
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.codigoFuncionario = codigoFuncionario;
        formatoData = new SimpleDateFormat("yyy-MM-dd");
        formatoHora = new SimpleDateFormat("HH:mm:ss");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPai = new javax.swing.JTabbedPane();
        painelCliente = new javax.swing.JPanel();
        btn_pesquisar = new javax.swing.JToggleButton();
        cb_clientes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_rua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_bairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        try {
            formatoTelefone = new MaskFormatter("(##) #####-####");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao inserir campo personalizado", "Erro", 0);
        }
        txt_telefone = new JFormattedTextField(formatoTelefone);
        jLabel6 = new javax.swing.JLabel();
        txt_data = new javax.swing.JTextField();
        btn_pedido = new javax.swing.JButton();
        btn_cli_fechar = new javax.swing.JButton();
        painelPedido = new javax.swing.JPanel();
        txt_nome_cliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_item = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cb_selecionar = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_quantidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_cod_pedido = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btn_add = new javax.swing.JButton();
        btn_remover = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        btn_calcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btn_fechar_pedido = new javax.swing.JButton();
        btn_finalizar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Pedidos");

        btn_pesquisar.setText("Pesquisar");
        btn_pesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pesquisarActionPerformed(evt);
            }
        });

        cb_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_clientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Código");

        txt_codigo.setEditable(false);
        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Rua");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Bairro");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Telefone");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Data");

        txt_data.setEditable(false);
        txt_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataActionPerformed(evt);
            }
        });

        btn_pedido.setText("Pedido");
        btn_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pedidoActionPerformed(evt);
            }
        });

        btn_cli_fechar.setText("Fechar");
        btn_cli_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cli_fecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelClienteLayout = new javax.swing.GroupLayout(painelCliente);
        painelCliente.setLayout(painelClienteLayout);
        painelClienteLayout.setHorizontalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelClienteLayout.createSequentialGroup()
                        .addComponent(btn_pedido)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cli_fechar))
                    .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(painelClienteLayout.createSequentialGroup()
                            .addComponent(btn_pesquisar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelClienteLayout.createSequentialGroup()
                            .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelClienteLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(painelClienteLayout.createSequentialGroup()
                                    .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(painelClienteLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(painelClienteLayout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(64, 64, 64)
                                            .addComponent(jLabel6)
                                            .addGap(20, 20, 20)
                                            .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(painelClienteLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_rua)
                                        .addComponent(txt_bairro)))))))
                .addContainerGap())
        );
        painelClienteLayout.setVerticalGroup(
            painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pesquisar)
                    .addComponent(cb_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_rua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(painelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pedido)
                    .addComponent(btn_cli_fechar))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        painelPai.addTab("Clientes", painelCliente);

        txt_nome_cliente.setEditable(false);
        txt_nome_cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nome_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nome_clienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Item");

        txt_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_itemActionPerformed(evt);
            }
        });
        txt_item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_itemKeyReleased(evt);
            }
        });

        jLabel8.setText("Selecionar");

        cb_selecionar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Busque um item ao lado" }));
        cb_selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_selecionarActionPerformed(evt);
            }
        });

        jButton2.setText("Valor");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Valor");

        txt_valor.setEditable(false);

        jLabel10.setText("Quantidade");

        txt_quantidade.setText("1");
        txt_quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantidadeFocusLost(evt);
            }
        });

        jLabel11.setText("Código");

        txt_cod_pedido.setEditable(false);

        btn_add.setText("+");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_remover.setText("-");
        btn_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removerActionPerformed(evt);
            }
        });

        jLabel12.setText("Total");

        btn_calcular.setText("Calcular");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Item", "Descrição", "Valor Unitário", "Quantidade", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(3).setResizable(false);
        }

        btn_fechar_pedido.setText("Fechar");
        btn_fechar_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fechar_pedidoActionPerformed(evt);
            }
        });

        btn_finalizar.setText("Finalizar");
        btn_finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPedidoLayout = new javax.swing.GroupLayout(painelPedido);
        painelPedido.setLayout(painelPedidoLayout);
        painelPedidoLayout.setHorizontalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelPedidoLayout.createSequentialGroup()
                                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelPedidoLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_item, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelPedidoLayout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelPedidoLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cod_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(painelPedidoLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_selecionar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_finalizar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_fechar_pedido))
                    .addGroup(painelPedidoLayout.createSequentialGroup()
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        painelPedidoLayout.setVerticalGroup(
            painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPedidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txt_nome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cb_selecionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel9)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_cod_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add)
                    .addComponent(btn_remover)
                    .addComponent(jLabel12)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_calcular))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_fechar_pedido)
                    .addComponent(btn_finalizar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        painelPai.addTab("Pedidos", painelPedido);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelPai, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(painelPai, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nome_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nome_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nome_clienteActionPerformed

    private void btn_cli_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cli_fecharActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cli_fecharActionPerformed

    private void txt_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataActionPerformed

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void btn_finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarActionPerformed
        popularBeans();
        pedidoC.controleDePedido(txt_codigo.getText(), codigoFuncionario + "", txt_total.getText(), tabela.getRowCount(), pedidoB);
        limparFinalizar();
    }//GEN-LAST:event_btn_finalizarActionPerformed

    private void btn_pesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pesquisarActionPerformed
        cb_clientes.removeAllItems();
        lista.clear();
        String pesquisa = JOptionPane.showInputDialog(null, "Digite o Nome do Cliente", "Pesquisar", 3);
        clienteC.controlePesquisa(pesquisa, lista);
        for (String i : lista) {
            cb_clientes.addItem(i);
        }
    }//GEN-LAST:event_btn_pesquisarActionPerformed

    private void cb_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_clientesActionPerformed
        if (!(cb_clientes.getSelectedItem() == null)) {
            String cod = cb_clientes.getSelectedItem().toString();
            cod = cod.substring(0, cod.indexOf(" "));
            clienteB = clienteC.controlePreencherCampos(Integer.parseInt(cod));
            txt_codigo.setText(clienteB.getCodigo() + "");
            txt_nome.setText(clienteB.getNome() + "");
            txt_rua.setText(clienteB.getRua() + "");
            txt_bairro.setText(clienteB.getBairro() + "");
            txt_telefone.setText(clienteB.getTelefone() + "");
            txt_data.setText(clienteB.getDataCad() + "");

        }
    }//GEN-LAST:event_cb_clientesActionPerformed

    private void btn_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pedidoActionPerformed
        painelPai.setEnabledAt(1, true);
        painelPai.setEnabledAt(0, false);
        painelPai.setSelectedIndex(1);
        txt_nome_cliente.setText(txt_nome.getText());
        btn_finalizar.setEnabled(false);
    }//GEN-LAST:event_btn_pedidoActionPerformed

    private void btn_fechar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fechar_pedidoActionPerformed
        dispose();
    }//GEN-LAST:event_btn_fechar_pedidoActionPerformed

    private void txt_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_itemActionPerformed

    }//GEN-LAST:event_txt_itemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txt_valor.setText(pedidoC.controleDeValor(cb_selecionar.getSelectedItem().toString()) + "");
        txt_cod_pedido.setText(pedidoC.controleDeCodigo(cb_selecionar.getSelectedItem().toString()) + "");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_itemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_itemKeyReleased
        txt_valor.setText("");
        cb_selecionar.removeAllItems();
        listaDeItens.clear();
        pedidoC.controleDeItens(txt_item.getText(), listaDeItens);
        for (String i : listaDeItens) {
            cb_selecionar.addItem(i);
        }
    }//GEN-LAST:event_txt_itemKeyReleased

    private void cb_selecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_selecionarActionPerformed
        txt_valor.setText("");
        txt_quantidade.setText("1");
    }//GEN-LAST:event_cb_selecionarActionPerformed

    private void txt_quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantidadeFocusLost

    }//GEN-LAST:event_txt_quantidadeFocusLost

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (pedidoC.verificarItens(txt_valor.getText(), txt_quantidade.getText(), txt_cod_pedido.getText(), cb_selecionar.getSelectedItem().toString())) {
            double total = Double.parseDouble(txt_valor.getText()) * Double.parseDouble(txt_quantidade.getText());
            modelo.addRow(new Object[]{txt_cod_pedido.getText(),
                cb_selecionar.getSelectedItem(),
                txt_valor.getText(),
                txt_quantidade.getText(),
                total

            });
            limparItens();
            calcularTotal();
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removerActionPerformed
        modelo.removeRow(tabela.getSelectedRow());
        calcularTotal();
    }//GEN-LAST:event_btn_removerActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        calcularTotal();
    }//GEN-LAST:event_btn_calcularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_cli_fechar;
    private javax.swing.JButton btn_fechar_pedido;
    private javax.swing.JButton btn_finalizar;
    private javax.swing.JButton btn_pedido;
    private javax.swing.JToggleButton btn_pesquisar;
    private javax.swing.JButton btn_remover;
    private javax.swing.JComboBox<String> cb_clientes;
    private javax.swing.JComboBox<String> cb_selecionar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel painelCliente;
    private javax.swing.JTabbedPane painelPai;
    private javax.swing.JPanel painelPedido;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txt_bairro;
    private javax.swing.JTextField txt_cod_pedido;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_item;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_nome_cliente;
    public static javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_rua;
    private javax.swing.JTextField txt_telefone;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables

    final void habilitarCampos(boolean valor) {
        txt_bairro.setEnabled(valor);
        txt_rua.setEnabled(valor);
        txt_nome.setEnabled(valor);
        txt_telefone.setEnabled(valor);
        txt_data.setEnabled(valor);
    }

    final void limparItens() {
        txt_item.setText("");
        txt_quantidade.setText("1");
        txt_valor.setText("");
        cb_selecionar.removeAllItems();

    }

    final void calcularTotal() {
        double totalPedido = 0;
        for (int i = 0; i < tabela.getRowCount(); i++) {
            totalPedido += Double.parseDouble(modelo.getValueAt(i, 4).toString());
        }
        txt_total.setText(formatoDecimal.format(totalPedido).replace('.', ','));
        if (totalPedido > 0) {
            btn_finalizar.setEnabled(true);
        }
    }

    final void popularBeans() {
        dataAtual = new Date();
        pedidoB.setCodigoCliente(Integer.parseInt(txt_codigo.getText()));
        pedidoB.setCodigoFuncionario(codigoFuncionario);
        pedidoB.setCodigoEntregador(2);
        pedidoB.setData(formatoData.format(dataAtual));
        pedidoB.setData(formatoData.format(dataAtual));
        pedidoB.setStatus("Pedido Aberto");
        pedidoB.setValor(Double.parseDouble(txt_total.getText().replace(',', '.')));
        for (int i = 0; i < tabela.getRowCount(); i++) {
            pedidoB.setCodCardapio(Integer.parseInt(modelo.getValueAt(i, 0).toString()));
            pedidoB.setQuantidade(Integer.parseInt(modelo.getValueAt(i, 3).toString()));

        }
    }

    final void limparFinalizar() {
        txt_total.setText("");
        txt_cod_pedido.setText("");
        btn_finalizar.setEnabled(false);
        modelo.setNumRows(0);
    }
}
