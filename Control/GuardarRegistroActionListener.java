
package Control;

import GUI.MenuAdministrador;
import GUI.RegistroFrame;
import Logico.Administrador;
import Logico.Tutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class GuardarRegistroActionListener implements ActionListener {
    private JTextField nombre,
                       correo;
    private JPasswordField contrasenia,
                           confirmacion;
    private RegistroFrame ventana;
    private MenuAdministrador menu;
    private Administrador administrador;
    
    public GuardarRegistroActionListener(JTextField nombre, JTextField correo,
            JPasswordField contrasenia, JPasswordField confirmacion,
            RegistroFrame ventana, MenuAdministrador menu,
            Administrador administrador){
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
        if(contrasenia.getText().equals(confirmacion.getText())){
            if(nombre.getText().equals("") ||
                    correo.getText().equals("") ||
                    contrasenia.getText().equals("")){
                JOptionPane.showMessageDialog(
                        null, "Hay campos vacios.", "Error", 1
                );
            }
            else{
                Tutor nuevo = new Tutor(
                        nombre.getText(), correo.getText(),
                        contrasenia.getText(), null
                );
                administrador.setTutor(nuevo);
                menu.actualizar();
                ventana.destruir();
                ventana.dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(
                    null, "Las contraseñas no concuerdan", "Error", 1
            );
        }
    }
    
}
