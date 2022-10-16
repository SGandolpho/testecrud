package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estado;
import util.ConnectionFactory;

public class EstadoDAO implements GenericDAO{
    private Connection conexao;
    
    public EstadoDAO(){
        try {
            this.conexao = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean inserir(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from estado order by nomeestado";
        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Estado e = new Estado();
                e.setIdEstado(rs.getInt("idEstado"));
                e.setNomeEstado(rs.getString("nomeEstado"));
                e.setSiglaEstado(rs.getString("siglaEstado"));
                resultado.add(e);
            }
        }catch (Exception e) {
            System.err.println("Erro ao listar Estado: " + e.getMessage());
        }finally{
            try {
                ConnectionFactory.CloseConnection(conexao, stmt, rs);
            } catch (Exception e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return resultado;
    }
}
