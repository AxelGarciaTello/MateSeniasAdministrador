
package Control;

import GUI.IngresoAdministrador;
import GUI.MenuAdministrador;
import Logico.Administrador;
import Logico.Ninio;
import Logico.Tutor;
import Persistencia.IngresoAdministradorConexionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class IngresarAdministradorActionListener implements ActionListener {
    private JFrame ventana;
    private JTextField correo;
    private JPasswordField contrasenia;
    
    public IngresarAdministradorActionListener(JFrame ventana,
            JTextField correo, JPasswordField contrasenia){
        this.ventana=ventana;
        this.correo=correo;
        this.contrasenia=contrasenia;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        IngresoAdministradorConexionBD bd;
        Administrador administrador;
        MenuAdministrador menu;
        if(correo.getText().equals("") || contrasenia.getText().equals("")){
            JOptionPane.showMessageDialog(
                    null, "Por favor llene todos los campos", "Campos vacíos",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
        else{
            
            bd =new IngresoAdministradorConexionBD();
            administrador=bd.ingresarAdministrador(
                    correo.getText(), contrasenia.getText()
            );
            if(administrador!=null){
                menu = new MenuAdministrador(administrador);
                menu.setVisible(true);
                ((IngresoAdministrador)ventana).destruir();
                ventana.dispose();
            }
        }
    }
    
}
