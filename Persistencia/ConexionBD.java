
package Persistencia;

import java.sql.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
    private Connection conexion;
    private Statement st;
    
    public ConexionBD(){
        try{
            conexion=DriverManager.getConnection(
                    "jdbc:mysql://localhost/ADOO?serverTimezone=UTC","root",""
            );
            st=conexion.createStatement();
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "No se pudo establecer conexion con la base de datos",
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public ResultSet consultar(String sentencia){
        ResultSet rs=null;
        try{
            rs = st.executeQuery(sentencia);
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Error al realizar la consulta","Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return rs;
    }
    
    public boolean administrar(String sentencia){
        boolean bandera=false;
        try{
            st.executeUpdate(sentencia);
            bandera=true;
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return bandera;
    }
}
