package Conexion;

import java.sql.*;

public class Dt_Usuario {
    private final Conexion conDB = new Conexion();
    private Connection con;
    
    private PreparedStatement recuperarPassword;
    private String queryPassword = "SELECT password FROM dbo.Usuario WHERE username = ?";

    public Dt_Usuario() {
        
        try{
            con = conDB.conectarse();
            recuperarPassword = con.prepareStatement(queryPassword);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public String recuperarPass(String username) {
        ResultSet rs = null;
        String pass = "";
        
        try {
            recuperarPassword.setString(1, username);
            rs = recuperarPassword.executeQuery();
            
            while(rs.next()) {
               pass = rs.getString("password");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pass;
    }
    
    
}
