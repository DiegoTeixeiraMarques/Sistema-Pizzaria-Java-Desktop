package DAO;

import Beans.EntregadorBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EntregadorDAO {
   
    
    public EntregadorDAO() {
        
    }
    
    public void cadastrarEntregador(EntregadorBeans entregador) {
        try {
            String SQLIsertion = "insert into entregador(ent_nome, ent_status, ent_data_cad) values(?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLIsertion);
            st.setString(1, entregador.getNome());
            st.setString(2, "Livre");
            st.setString(3, Corretores.converterParaSQL(entregador.getDataCad()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro salvo com sucesso", "Salvo", 1, new ImageIcon("Imagens/ok.png"));
        
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null,"Erro ao Cadastrar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }
    
    public String proximoEntregador() {
        String SQLSelection = "select * from entregador order by ent_cod desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return (Integer.parseInt(rs.getString("ent_cod")) + 1) + "";
            } else {
                return "1";
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao Buscar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
             return "0";            
        }
    }
    
    public void buscarEntregador(String pesquisa, DefaultTableModel modelo) {
        
        try {
            String SQLSelection = "select * from entregador where ent_nome like '%" + pesquisa + "%' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                modelo.addRow(new Object[] {rs.getString("ent_cod"), rs.getString("ent_nome"), Corretores.converterParaJava(rs.getString("ent_data_cad"))});
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Buscar Entregador", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }
    
    public EntregadorBeans preencherCampos(int codigo) {
        EntregadorBeans entregador = new EntregadorBeans();
        
        
        try {
            String SQLSelection = "select * from entregador where ent_cod = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                entregador.setCodigo(rs.getInt("ent_cod"));
                entregador.setNome(rs.getString("ent_nome"));
                entregador.setDataCad(Corretores.converterParaJava(rs.getString("ent_data_cad")));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Buscar Entregador", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        return entregador;
    }
    
    public void editarEntregador(EntregadorBeans entregador) {
        try {
            String SQLIsertion = "update entregador set ent_nome = ? where ent_cod = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLIsertion);
            st.setString(1, entregador.getNome());
            st.setInt(2, entregador.getCodigo());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null,"Registro editado com sucesso", "Editado", 1, new ImageIcon("Imagens/ok.png"));
        
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            JOptionPane.showMessageDialog(null,"Erro ao Editar Registro", "Editado", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        
    }
    
}
