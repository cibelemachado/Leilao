/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProdutosDAO {
    
    public ProdutosDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");            
        } catch (ClassNotFoundException ex) {
             System.err.println("Driver JDBC não encontrado: " + ex.getMessage());
        }
    }
    
    private Connection getConnection() throws SQLException {
        return new conectaDAO().connectDB();
    }
    
    public void cadastrarProduto (ProdutosDTO produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";       
        try (Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, produto.getNome());
            pst.setInt(2, produto.getValor() != null ? produto.getValor() : 0);
            pst.setString(3, produto.getStatus() != null ? produto.getStatus() : "A Venda");
            
            pst.executeUpdate();
        }
       
    }
    
    public ArrayList<ProdutosDTO> listarProdutos() throws SQLException {
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT id, nome, valor, status FROM produtos ORDER BY id";
        
        try (Connection conn = getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                ProdutosDTO p = new ProdutosDTO();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getInt("valor"));
                p.setStatus(rs.getString("status"));
                lista.add(p);
            }
        }                
        
        return lista;
    }    
}

