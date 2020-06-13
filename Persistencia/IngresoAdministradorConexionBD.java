
package Persistencia;

import Logico.Administrador;
import Logico.Ninio;
import Logico.Progreso;
import Logico.Tutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class IngresoAdministradorConexionBD extends ConexionBD{
    
    public IngresoAdministradorConexionBD(){
        super();
    }
    
    public Administrador ingresarAdministrador(String correo,
            String contrasenia){
        int i=0,
            j=0,
            k=0,
            noTutores,
            noNinios;
        String sentencia,
               nombre;
        String[] temas={"Suma con Unidades",
                        "Suma con Decenas",
                        "Suma con Centenas",
                        "Resta con Unidades",
                        "Resta con Decenas",
                        "Resta con Centenas",
                        "Multiplicación con Unidades",
                        "Multiplicación con Decenas",
                        "Multilicación con Centenas",
                        "Divición con Unidades",
                        "División con Decenas",
                        "División con Centenas",
                        "Crucigrama sumas",
                        "Crucigrama restas",
                        "Crucigrama sumas y restas",
                        "Crucigrama sumas y restas 2",
                        "Crucigrama multiplicaciones",
                        "Crucigrama divisiones",
                        "Crucigrama multiplicaciones y divisiones",
                        "Crucigrama multiplicaciones y divisiones 2",
                        "Crucigrama operadores",
                        "Crucigrama operadores 2",
                        "Crucigrama operadores 3",
                        "Crucigrama operadores 4"
        };
        Administrador administrador=null;
        Tutor[] tutores;
        Ninio[][] ninios;
        Progreso[][][] progresos;
        ResultSet rs;
        sentencia="SELECT * FROM `administrador` WHERE email='"+correo
                +"' AND psw=sha2('"+contrasenia+"', 224);";
        rs=super.consultar(sentencia);
        try{
            rs.next();
            nombre=rs.getString("usr");
            sentencia="SELECT count(*) FROM `tutor`;";
            rs=super.consultar(sentencia);
            rs.next();
            noTutores=Integer.parseInt(rs.getString("count(*)"));
            if(noTutores==0){
                administrador = new Administrador(
                        nombre, correo, contrasenia, null
                );
            }
            else{
                tutores = new Tutor[noTutores];
                ninios = new Ninio[noTutores][];
                progresos = new Progreso[noTutores][][];
                sentencia="SELECT * FROM `tutor`;";
                rs=super.consultar(sentencia);
                for(i=0; i<noTutores; i++){
                    rs.next();
                    tutores[i] = new Tutor(
                            rs.getString("usr"), rs.getString("email"),
                            rs.getString("psw"), null
                    );
                }
                for(i=0; i<noTutores; i++){
                    sentencia="SELECT count(*) FROM `infante` WHERE "
                            + "emailtutor='"+tutores[i].getCorreo()+"';";
                    rs=super.consultar(sentencia);
                    rs.next();
                    noNinios=Integer.parseInt(rs.getString("count(*)"));
                    if(noNinios!=0){
                        ninios[i] = new Ninio[noNinios];
                        progresos[i] = new Progreso[noNinios][24];
                        sentencia="SELECT * FROM `infante` WHERE emailtutor='"
                                +tutores[i].getCorreo()+"';";
                        rs=super.consultar(sentencia);
                        for(j=0; j<noNinios; j++){
                            rs.next();
                            ninios[i][j] = new Ninio(
                                    rs.getString("usr"),
                                    rs.getString("emailtutor"),
                                    rs.getString("psw")
                            );
                        }
                        for(j=0; j<noNinios; j++){
                            sentencia="SELECT * FROM `avance` WHERE "
                                    + "UsrInfante='"+ninios[i][j].getNombre()
                                    +"' ORDER BY `avance`.`idContenido` ASC;";
                            rs=super.consultar(sentencia);
                            for(k=0; k<24; k++){
                                rs.next();
                                progresos[i][j][k] = new Progreso(
                                        temas[k],
                                        Integer.parseInt(
                                                rs.getString("Calificación")
                                        )
                                );
                            }
                            ninios[i][j].setProgresos(progresos[i][j]);
                        }
                        tutores[i].setNinio(ninios[i]);
                    }
                }
                administrador = new Administrador(
                        nombre, correo, contrasenia, tutores
                );
            }
        }
        catch(SQLException sqle){
            sqle.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Sus datos son incorrectos", "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return administrador;
    }
    
}
