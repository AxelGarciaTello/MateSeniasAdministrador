
package Control;

import GUI.IngresoAdministrador;
import GUI.MenuAdministrador;
import Logico.Administrador;
import Logico.Ninio;
import Logico.Tutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class IngresarAdministradorActionListener implements ActionListener {
    private JFrame ventana;
    
    public IngresarAdministradorActionListener(JFrame ventana){
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Ninio[] ninios = new Ninio[2];
        ninios[0] = new Ninio("Paredes");
        ninios[1] = new Ninio("Vaca");
        Tutor[] tutores = new Tutor[2];
        tutores[0] = new Tutor("Armando", "a", "a", ninios);
        tutores[1] = new Tutor("Soila", "b", "b", ninios);
        Administrador administrador = new Administrador(tutores);
        MenuAdministrador menu = new MenuAdministrador(administrador);
        menu.setVisible(true);
        if(ventana instanceof IngresoAdministrador){
            ((IngresoAdministrador)ventana).destruir();
        }
        ventana.dispose();
    }
    
}
