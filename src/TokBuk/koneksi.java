/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TokBuk;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Fikri Khairul Shaleh
 */
public class koneksi {
    public Connection con;
    public Statement stat;
    
    public koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/fikri","root","");
            stat = con.createStatement();
            System.out.println("Sukses");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
}
