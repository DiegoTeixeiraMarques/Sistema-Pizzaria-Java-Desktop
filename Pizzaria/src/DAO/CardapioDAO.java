package DAO;

import Beans.CardapioBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CardapioDAO {

    public CardapioDAO() {

    }

    public void cadastrarCardapio(CardapioBeans cardapio) {
        try {
            String SQLIsertion = "insert into cardapio(car_descricao, car_tipo, car_valor) values(?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLIsertion);
            st.setString(1, cardapio.getDescricao());
            st.setString(2, cardapio.getTipo());
            st.setDouble(3, cardapio.getValor());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }

    public String proximoCardapio() {
        String SQLSelection = "select * from cardapio order by car_cod desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("car_cod")) + 1) + "";
            } else {
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return "0";
        }
    }

    public void buscarCardapio(String pesquisa, DefaultTableModel modelo) {

        try {
            String SQLSelection = "select * from cardapio where car_descricao like '%" + pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("car_cod"), rs.getString("car_descricao"), rs.getDouble("car_valor")});

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Item", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }

    public CardapioBeans preencherCampos(int codigo) {
        CardapioBeans cardapio = new CardapioBeans();

        try {
            String SQLSelection = "select * from cardapio where car_cod = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, codigo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cardapio.setCodigo(rs.getInt("car_cod"));
                cardapio.setDescricao(rs.getString("car_descricao"));
                cardapio.setTipo(rs.getString("car_tipo"));
                cardapio.setValor(rs.getDouble("car_valor"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Item", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        return cardapio;
    }

    public void editarCardapio(CardapioBeans cardapio) {
        try {
            String SQLIsertion = "update cardapio set car_descricao = ?, car_tipo = ?, car_valor = ? where car_cod = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLIsertion);
            st.setString(1, cardapio.getDescricao());
            st.setString(2, cardapio.getTipo());
            st.setDouble(3, cardapio.getValor());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro editado com sucesso", "Editado", 1, new ImageIcon("Imagens/ok.png"));

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Editar Registro", "Editado", 0, new ImageIcon("Imagens/btn_sair.png"));
        }

    }

}
