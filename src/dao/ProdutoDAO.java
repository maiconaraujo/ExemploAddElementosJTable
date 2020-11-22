/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author MAICON
 */
public class ProdutoDAO {
    public ArrayList listar() throws SQLException, ClassNotFoundException{               
        Connection conn = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        String SQL = "";
        ArrayList<Produto> lista = new ArrayList<>();
                
        // Obtem conexao com BD
        conn = ConnectionFactory.getConnection();
        
        // Comando SQL 
        SQL = "select codigo, descricao, preco "
                + "from produtos order by descricao";
        

        ps = conn.prepareStatement(SQL);
        // Para buscar informações
        rs = ps.executeQuery();   

        // Verifica se possui dados
        while (rs.next()) {
            
            Produto p = new Produto();           
            
            p.setCodigo(rs.getInt("codigo"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getDouble("preco"));

            lista.add(p);
         } 
        
        ps.close();
        rs.close();
        conn.close();
        
        return lista;
        
    } 
    
    public ArrayList listarPorNome(String nome) throws SQLException, ClassNotFoundException{
        nome = "%" + nome.trim() + "%";
        
        Connection conn = null;
        PreparedStatement  ps = null;
        ResultSet rs = null;
        String SQL = "";
        ArrayList<Produto> lista = new ArrayList<>();
                
        // Obtem conexao com BD
        conn = ConnectionFactory.getConnection();
        
        // Comando SQL 
        SQL = "select codigo, descricao, preco "
                + "from produtos where descricao like ? order by descricao";
        

        ps = conn.prepareStatement(SQL);
        ps.setString(1, nome);
        // Para buscar informações
        rs = ps.executeQuery();   

        // Verifica se possui dados
        while (rs.next()) {
            
            Produto p = new Produto();           
            
            p.setCodigo(rs.getInt("codigo"));
            p.setDescricao(rs.getString("descricao"));
            p.setPreco(rs.getDouble("preco"));

            lista.add(p);
         } 
        
        ps.close();
        rs.close();
        conn.close();
        
        return lista;
        
    } 
}
