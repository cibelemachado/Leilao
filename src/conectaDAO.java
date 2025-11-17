
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
   
    public Connection connectDB() {
        Connection conn = null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/leiloes?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String pass = "Felicidade15.";
            
            conn = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
        }
        return conn;
    }
    
}
