package Controller;

import Beans.CardapioBeans;
import DAO.CardapioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CardapioControle {

    CardapioDAO cardapioD;

    public CardapioControle() {
        cardapioD = new CardapioDAO();
    }

    public boolean verificarDados(CardapioBeans cardapio) {
        if (cardapio.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Descricao", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cardapio.getTipo().equals("Selecione um Tipo")) {
            JOptionPane.showMessageDialog(null, "Selecione um Tipo", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cardapio.getValor() == 0) {
            JOptionPane.showMessageDialog(null, "Informe o Valor", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        cardapioD.cadastrarCardapio(cardapio);
        return true;
    }

    public String controleDeCodigo() {
        return cardapioD.proximoCardapio();
    }

    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        cardapioD.buscarCardapio(pesquisa, modelo);
    }

    public CardapioBeans controlePreencherCampos(int codigo) {
        return cardapioD.preencherCampos(codigo);
    }

    public boolean verificarDadosEditar(CardapioBeans cardapio) {
        if (cardapio.getDescricao().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Descricao", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cardapio.getTipo().equals("Selecione um Tipo")) {
            JOptionPane.showMessageDialog(null, "Selecione um Tipo", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        if (cardapio.getValor() == null) {
            JOptionPane.showMessageDialog(null, "Informe o Valor", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }

        cardapioD.editarCardapio(cardapio);
        return true;
    }
}
