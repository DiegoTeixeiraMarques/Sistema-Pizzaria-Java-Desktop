package Controller;

import Beans.ClienteBeans;
import DAO.ClienteDAO;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClienteControle {

    ClienteDAO clienteD;

    public ClienteControle() {
        clienteD = new ClienteDAO();
    }

    public boolean verificarDados(ClienteBeans cliente) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Rua", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cliente.getTelefone().equals("(  )      -")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Telefone", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        clienteD.cadastrarCliente(cliente);
        return true;
    }

    public String controleDeCodigo() {
        return clienteD.proximoCliente();
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        clienteD.buscarCliente(pesquisa, modelo);
    }

    public void controlePesquisa(String pesquisa, List<String> lista) {
        clienteD.buscarCliente(pesquisa, lista);
    }

    public ClienteBeans controlePreencherCampos(int codigo) {
        return clienteD.preencherCampos(codigo);
    }

    public boolean verificarDadosEditar(ClienteBeans cliente) {
        if (cliente.getNome().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cliente.getRua().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Rua", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cliente.getBairro().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cliente.getTelefone().equals("(  )      -")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Telefone", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        clienteD.editarCliente(cliente);
        return true;
    }
}
