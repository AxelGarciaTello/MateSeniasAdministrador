
package Control;

import GUI.InformacionNinioPanel;
import GUI.RegistroNinio;
import Logico.Administrador;
import Logico.Ninio;
import Logico.Progreso;
import Logico.Tutor;
import Persistencia.ConexionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class AgregarNinioActionListener implements ActionListener {
    private InformacionNinioPanel ventana;
    private RegistroNinio principal;
    private Tutor tutor;
    private JTextField nombre,
                       correo;
    private JPasswordField contrasenia,
                           confirmacion;
    private Administrador administrador;
    
    public AgregarNinioActionListener(InformacionNinioPanel ventana,
            Tutor tutor, JTextField nombre, JTextField correo,
            JPasswordField contrasenia, JPasswordField confirmacion,
            RegistroNinio principal, Administrador administrador){
        this.ventana=ventana;
        this.tutor=tutor;
        this.nombre=nombre;
        this.correo=correo;
        this.contrasenia=contrasenia;
        this.confirmacion=confirmacion;
        this.principal=principal;
        this.administrador=administrador;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int i=0;
        String sentencia = "INSERT INTO `infante` (`usr`, `emailtutor`, `psw`) "
                + "VALUES ('"+nombre.getText()+"', '"+correo.getText()
                +"', sha2('"+contrasenia.getText()+"', 224));";
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
        Ninio ninio;
        Progreso[] progresos;
        ConexionBD bd;
        boolean aceptado;
        if(nombre.getText().equals("") ||
                correo.getText().equals("") ||
                contrasenia.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null, "Hay campos vacíos\nPor favor, llene todos los datos",
                    "Error", JOptionPane.INFORMATION_MESSAGE
            );
        }
        else if(!contrasenia.getText().equals(confirmacion.getText())){
            JOptionPane.showMessageDialog(
                    null, "Las contraseñas no coinciden", "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        else{
            bd = new ConexionBD();
            aceptado=bd.administrar(sentencia);
            if(aceptado){
                for(i=1; i<=24; i++){
                    sentencia="INSERT INTO `avance` (`IdAvance`, `idContenido`,"
                            + " `UsrInfante`, `Calificación`) VALUES ("
                            + "NULL, '"+i+"', '"+nombre.getText()+"', '0');";
                    bd.administrar(sentencia);
                }
                progresos = new Progreso[24];
                for(i=0; i<24; i++){
                    progresos[i] = new Progreso(temas[i]);
                }
                ninio = new Ninio(
                        nombre.getText(), correo.getText(),
                        contrasenia.getText(), progresos
                );
                tutor.setNinio(ninio);
                ventana.actualizar();
                sentencia="INSERT INTO `Admin_Infante` (`idRegistro`, "
                        + "`usrinfante`, `emailadmin`, `idAccion`) VALUES "
                        + "(NULL, '"+nombre.getText()+"', '"
                        +administrador.getCorreo()+"', '1');";
                bd.administrar(sentencia);
                principal.destruir();
                principal.dispose();
            }
            else{
                JOptionPane.showMessageDialog(
                        null, "No se pudo registrar a el niño\nAsegurece que "
                                + "los datos sean correctos", "Error",
                                JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
}
