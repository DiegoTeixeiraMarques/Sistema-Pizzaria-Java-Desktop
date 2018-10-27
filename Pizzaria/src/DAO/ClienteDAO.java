package DAO;

import Beans.ClienteBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteDAO {

    public ClienteDAO() {

    }

    public void cadastrarCliente(ClienteBeans cliente) {
        try {
            String SQLIsertion = "insert into clientes(cli_nome, cli_rua, cli_bairro, cli_data_cad, cli_telefone) values(?, ?, ?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLIsertion);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRua());
            st.setString(3, cliente.getBairro());
            st.setString(5, cliente.getTelefone());
            st.setString(4, Corretores.converterParaSQL(cliente.getDataCad()));

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }

    public String proximoCliente() {
        String SQLSelection = "select * from clientes order by cli_cod desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString("cli_cod")) + 1) + "";
            } else {
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return "0";
        }
    }

    public void buscarCliente(String pesquisa, DefaultTableModel modelo) {

        try {
            String SQLSelection = "select * from clientes where cli_nome like '%" + pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("cli_cod"), rs.getString("cli_nome"), rs.getString("cli_rua"), rs.getString("cli_bairro")});

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }

    public void buscarCliente(String pesquisa, List<String> lista) {

        try {
            String SQLSelection = "select * from clientes where cli_nome like '%" + pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("cli_cod") + (" - ") + rs.getString("cli_nome") + ("--") + rs.getString("cli_telefone"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }

    public ClienteBeans preencherCampos(int codigo) {
        ClienteBeans cliente = new ClienteBeans();

        try {
            String SQLSelection = "select * from clientes where cli_cod = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, codigo);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cliente.setCodigo(rs.getInt("cli_cod"));
                cliente.setNome(rs.getString("cli_nome"));
                cliente.setRua(rs.getString("cli_rua"));
                cliente.setBairro(rs.getString("cli_bairro"));
                cliente.setTelefone(rs.getString("cli_telefone"));
                cliente.setDataCad(Corretores.converterParaJava(rs.getString("cli_data_cad")));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        return cliente;
    }

    public void editarCliente(ClienteBeans cliente) {
        try {
            String SQLIsertion = "update clientes set cli_nome = ?, cli_rua = ?, cli_bairro = ?, cli_telefone = ? where cli_cod = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLIsertion);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRua());
            st.setString(3, cliente.getBairro());
            st.setString(5, cliente.getTelefone());
            st.setInt(4, cliente.getCodigo());

            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro editado com sucesso", "Editado", 1, new ImageIcon("Imagens/ok.png"));

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Editar Registro", "Editado", 0, new ImageIcon("Imagens/btn_sair.png"));
        }

    }

}
