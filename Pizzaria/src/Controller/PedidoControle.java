package Controller;

import Beans.PedidoBeans;
import DAO.PedidoDAO;
import GUI.PedidoTela;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PedidoControle {

    PedidoDAO pedidoD;

    public PedidoControle() {
        pedidoD = new PedidoDAO();

    }

    public void controleDeItens(String pesquisa, List<String> listaDeItens) {
        pedidoD.pesquisaItens(pesquisa, listaDeItens);
    }

    public double controleDeValor(String pesquisa) {
        return pedidoD.valorDoItem(pesquisa);

    }

    public int controleDeCodigo(String pesquisa) {
        return pedidoD.valorDoCodigo(pesquisa);

    }

    public boolean verificarItens(String valor, String quantidade, String codigo, String item) {

        try {
            int x = Integer.parseInt(quantidade);
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "A quantidade não pode ser 0", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
                PedidoTela.txt_quantidade.setText("1");
                PedidoTela.txt_quantidade.requestFocus();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Insira um número inteiro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            PedidoTela.txt_quantidade.setText("1");
            PedidoTela.txt_quantidade.requestFocus();
        }

        if (quantidade.equals("")) {

        }

        if (valor.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Valor", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (codigo.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Codigo", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (item.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Item", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        return true;
    }

    public void controleDePedido(String codigoCliente, String codigoFuncionario, String total, int tamanhoTabela,
             PedidoBeans pedidoB) {
        pedidoD.cadastrarPedido(codigoCliente, codigoFuncionario, total, tamanhoTabela,
                pedidoB);

    }
}
