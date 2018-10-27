package Controller;

import Beans.FuncionarioBeans;
import DAO.FuncionarioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioControle {
    
    FuncionarioDAO funcionarioD;
    
    public FuncionarioControle() {
        funcionarioD = new FuncionarioDAO();
    }
    public boolean verificarDados(FuncionarioBeans funcionario) {
        if(funcionario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        } 
          
        if(funcionario.getCargo().equals("Selecione um cargo")) {
            JOptionPane.showMessageDialog(null,"Selecione um Cargo", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        } 
        
        
        funcionarioD.cadastrarFuncionario(funcionario);
        return true;
    }
    
    public String controleDeCodigo() {
        return funcionarioD.proximoFuncionario();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modelo) {
        funcionarioD.buscarFuncionario(pesquisa, modelo);
    }
    
    public FuncionarioBeans controlePreencherCampos(int codigo) {
        return funcionarioD.preencherCampos(codigo);
    }
    
    public boolean verificarDadosEditar(FuncionarioBeans funcionario) {
        if(funcionario.getNome().equals("")) {
            JOptionPane.showMessageDialog(null,"Preencha o campo Nome", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }
          
       if(funcionario.getCargo().equals("Selecione um cargo")) {
            JOptionPane.showMessageDialog(null,"Selecione um Cargo", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            return false;
        }
        
        funcionarioD.editarFuncionario(funcionario);
        return true;
    }
}   