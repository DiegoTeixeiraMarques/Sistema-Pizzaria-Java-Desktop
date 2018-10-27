package DAO;

import Beans.PedidoBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PedidoDAO {

    public void pesquisaItens(String pesquisa, List<String> listaDeItens) {

        try {
            String SQLPesquisa = "select * from cardapio where car_descricao like '%" + pesquisa + "%'";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                listaDeItens.add(rs.getString("car_descricao"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }

    public double valorDoItem(String pesquisa) {
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            st.setString(1, pesquisa);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getDouble("car_valor");

            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        return 0;
    }

    public int valorDoCodigo(String pesquisa) {
        try {
            String SQLPesquisa = "select * from cardapio where car_descricao = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            st.setString(1, pesquisa);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("car_cod");

            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        return 0;
    }

    public void cadastrarPedido(String codigoCliente, String codigoFuncionario, String total, int tamanhoTabela, PedidoBeans pedidoB) {
        Date data = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

        try {
            String SQLInsert = "insert into pedidos(ped_cli_cod, ped_fun_cod, ped_ent_cod, ped_data, ped_hora, ped_total, ped_status) value(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLInsert);
            st.setString(1, codigoCliente);
            st.setString(2, codigoFuncionario);
            st.setString(3, "2");
            st.setString(4, formatoData.format(data));
            st.setString(5, formatoHora.format(data));
            st.setString(6, total.replace(',', '.'));
            st.setString(7, "Pedido Aberto");

            st.execute();
            cadastrarItens(codigoCliente, codigoFuncionario, codigoDoPedido(), tamanhoTabela, pedidoB);
            codigoDoPedido();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (SQLException ex) {
            //Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }

    }

    public String codigoDoPedido() {
        String cod = "0";

        try {
            String SQLSelection = "select ped_cod from pedidos order by ped_cod desc limit 1";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cod = rs.getString("ped_cod");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Ordenar os Pedidos", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }

        return cod;
    }

    public void cadastrarItens(String codigoCliente, String codigoFuncionario, String codigoPedido, int tamanhoTabela, PedidoBeans pedidoB) {
        for (int i = 0; i < tamanhoTabela; i++) {
            String SQLInsert = "insert into item(item_ent_cod, item_fun_cod, item_cli_cod, item_ped_cod, item_car_cod, item_quantidade) values (?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsert);
                st.setString(1, "2");
                st.setString(2, codigoFuncionario);
                st.setString(3, codigoCliente);
                st.setString(4, codigoPedido);
                st.setInt(5, pedidoB.getCodCardapio(i));
                st.setInt(6, pedidoB.getQuantidade(i));

                st.execute();

            } catch (SQLException ex) {
                //Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Pedido", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            }
        }
    }
}
