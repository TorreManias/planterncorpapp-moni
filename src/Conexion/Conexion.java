package Conexion;

import java.sql.*;

public class Conexion {
    
    private static final String SERVIDOR = "localhost";
    private static final String USUARIO = "sa";
    private static final String PASSWORD = "root";
    private static final String NOMBREBD = "PlanternAppDB";
    private static final String PUERTO = "1433";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public Connection conectarse() {
        try {
            String url = "jdbc:sqlserver://" + SERVIDOR + ": " + PUERTO + "; Databasename= " + NOMBREBD + "; user= " + USUARIO + "; password = " + PASSWORD + ";";
            Class.forName(DRIVER);
            return (DriverManager.getConnection(url));
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public void cerrarConexion(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

