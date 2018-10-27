package Controller;

import Beans.EntregadorBeans;
import DAO.EntregadorDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EntregadorControle {
    
    EntregadorDAO entregadorD;
    
    public EntregadorControle() {
        entregadorD = new EntregadorDAO();
    }
    public boolean verificarDados(EntregadorBeans entregador) {
        if(entregador.getNome().equals("")) {
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        } 
        
        entregadorD.cadastrarEntregador(entregador);
        return true;
    }
    
    public String controleDeCodigo() {
        return entregadorD.proximoEntregador();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        entregadorD.buscarEntregador(pesquisa, modelo);
    }
    
    public EntregadorBeans controlePreencherCampos(int codigo) {
        return entregadorD.preencherCampos(codigo);
    }
    
    public boolean verificarDadosEditar(EntregadorBeans entregador) {
        if(entregador.getNome().equals("")) {
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }
        
        entregadorD.editarEntregador(entregador);
        return true;
    }
}   