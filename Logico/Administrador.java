
package Logico;

import Persistencia.ConexionBD;
import javax.swing.JOptionPane;


public class Administrador {
    private String nombre,
                   correo,
                   contrasenia;
    private Tutor[] tutores;
    
    public Administrador(String nombre, String correo,
            String contrasenia, Tutor[] tutores){
        this.nombre=nombre;
        this.correo=correo;
        this.contrasenia=contrasenia;
        this.tutores=tutores;
    }
    
    public void destruir(){
        int tamanio=0,
            x=0;
        if(nombre!=null){
            nombre=null;
        }
        if(correo!=null){
            correo=null;
        }
        if(contrasenia!=null){
            contrasenia=null;
        }
        if(tutores!=null){
            tamanio=tutores.length;
            for(x=0; x<tamanio; x++){
                if(tutores[x]!=null){
                    tutores[x]=null;
                }
            }
        }
        System.gc();
    }
    
    public Tutor getTutores(int x){
        return tutores[x];
    }
    
    public Tutor[] getTutores(){
        return tutores;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    public void setTutor(Tutor nuevo){
        int tamanio=tutores.length,
            x=0;
        Tutor[] nuevos = new Tutor[tamanio+1];
        for(x=0; x<tamanio; x++){
            nuevos[x]=tutores[x];
        }
        nuevos[x]=nuevo;
        tutores=nuevos;
    }
    
    public void eliminarTutor(int posicion){
        int tamanio=tutores.length,
            x=0,
            y=0;
        boolean aceptacion;
        String sentencia="DELETE FROM `tutor` WHERE `tutor`.`email` = '"
                +tutores[posicion].getCorreo()+"';";
        Tutor[] nuevos = new Tutor[tamanio-1];
        ConexionBD bd = new ConexionBD();
        aceptacion=bd.administrar(sentencia);
        sentencia="INSERT INTO `Admin_Tutor` (`idRegistro`, `emailtutor`,"
                    + " `emailadmin`, `idAccion`) VALUES (NULL, '"
                    +tutores[posicion].getCorreo()+"', '"+correo+"', '4');";
        bd.administrar(sentencia);
        if(aceptacion){
            while(x<(tamanio-1)){
                if(y==posicion){
                    tutores[y]=null;
                    y++;
                }
                else{
                    nuevos[x]=tutores[y];
                    x++;
                    y++;
                }
            }
            tutores=nuevos;
        }
        else{
            JOptionPane.showMessageDialog(
                    null, "No se pudo eliminar el tutor", "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    
    
}
