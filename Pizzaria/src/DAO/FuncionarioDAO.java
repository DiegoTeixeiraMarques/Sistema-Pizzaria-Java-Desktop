package DAO;

import Beans.ClienteBeans;
import Beans.FuncionarioBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FuncionarioDAO {
   
    
    public FuncionarioDAO() {
        
    }
    
    public void cadastrarFuncionario(FuncionarioBeans funcionario) {
        try {
            String SQLIsertion = "insert into funcionarios(fun_nome, fun_cargo, fun_data_cad) values(?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLIsertion);
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getCargo());
            st.setString(3, Corretores.converterParaSQL(funcionario.getDataCad()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro salvo com sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));
        
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null,"Erro ao Cadastrar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }
    
    public String proximoFuncionario() {
        String SQLSelection = "select * from funcionarios order by fun_cod desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return (Integer.parseInt(rs.getString("fun_cod")) + 1) + "";
            } else {
                return "1";
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
             return "0";            
        }
    }
    
    public void buscarFuncionario(String pesquisa, DefaultTableModel modelo) {
        
        try {
            String SQLSelection = "select * from funcionarios where fun_nome like '%" + pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                modelo.addRow(new Object[] {rs.getString("fun_cod"), rs.getString("fun_nome"), rs.getString("fun_cargo"), Corretores.converterParaJava(rs.getString("fun_data_cad"))});
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Buscar Funcionario", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }
    
    public FuncionarioBeans preencherCampos(int codigo) {
        FuncionarioBeans funcionario = new FuncionarioBeans();
        
        
        try {
            String SQLSelection = "select * from funcionarios where fun_cod = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                funcionario.setCodigo(rs.getInt("fun_cod"));
                funcionario.setNome(rs.getString("fun_nome"));
                funcionario.setCargo(rs.getString("fun_cargo"));
                funcionario.setDataCad(Corretores.converterParaJava(rs.getString("fun_data_cad")));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Buscar Funcionario", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        return funcionario;
    }
    
    public void editarFuncionario(FuncionarioBeans funcionario) {
        try {
            String SQLIsertion = "update funcionarios set fun_nome = ?, fun_cargo = ? where fun_cod = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLIsertion);
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getCargo());
            st.setInt(3, funcionario.getCodigo());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro editado com sucesso", "Editado", 1, new ImageIcon("Imagens/ok.png"));
        
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null,"Erro ao Editar Registro", "Editado", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        
    }
    
}
