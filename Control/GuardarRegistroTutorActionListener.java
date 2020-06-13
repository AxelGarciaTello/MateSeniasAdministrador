
package Control;

import GUI.MenuAdministrador;
import GUI.RegistroTutor;
import Logico.Administrador;
import Logico.Tutor;
import Persistencia.ConexionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class GuardarRegistroTutorActionListener implements ActionListener {
    private JTextField nombre,
                       correo;
    private JPasswordField contrasenia,
                           confirmacion;
    private RegistroTutor ventana;
    private MenuAdministrador menu;
    private Administrador administrador;
    
    public GuardarRegistroTutorActionListener(JTextField nombre,
            JTextField correo, JPasswordField contrasenia,
            JPasswordField confirmacion, RegistroTutor ventana, 
            MenuAdministrador menu, Administrador administrador){
        this.nombre=nombre;
        this.correo=correo;
        this.contrasenia=contrasenia;
        this.confirmacion=confirmacion;
        this.ventana=ventana;
        this.menu=menu;
        this.administrador=administrador;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean respuesta;
        ConexionBD bd;
        String sentencia="";
        if(nombre.getText().equals("") ||
                correo.getText().equals("") ||
                contrasenia.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null, "Hay campos vacios.", "Error", 1
            );
        }
        else if(!contrasenia.getText().equals(confirmacion.getText())){
            JOptionPane.showMessageDialog(
                    null, "Las contraseñas no concuerdan", "Error", 1
            );
        }
        else if(contrasenia.getText().length()<6){
            JOptionPane.showMessageDialog(
                    null, "La contraseña es muy pequeña", "Advertencia",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        else{
            bd = new ConexionBD();
            sentencia="INSERT INTO `tutor` (`usr`, `email`, `psw`) VALUES ('"+
                    nombre.getText()+"', '"+correo.getText()+"', sha2('"+
                    contrasenia.getText()+"', 224));";
            respuesta=bd.administrar(sentencia);
            if(respuesta){
                Tutor nuevo = new Tutor(
                        nombre.getText(), correo.getText(),
                        contrasenia.getText(), null
                );
                administrador.setTutor(nuevo);
                menu.actualizar();
                sentencia="INSERT INTO `Admin_Tutor` (`idRegistro`, "
                        + "`emailtutor`, `emailadmin`, `idAccion`) VALUES "
                        + "(NULL, '"+correo.getText()+"', '"
                        +administrador.getCorreo()+"', '1');";
                bd.administrar(sentencia);
                ventana.destruir();
                ventana.dispose();
            }
            else{
                JOptionPane.showMessageDialog(
                        null, "No se pudo crear el usuario", "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
}
