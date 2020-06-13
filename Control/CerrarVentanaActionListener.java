
package Control;

import GUI.RegistroTutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class CerrarVentanaActionListener implements ActionListener {
    private JFrame ventana;
    
    public CerrarVentanaActionListener(JFrame ventana){
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ventana instanceof RegistroTutor){
            ((RegistroTutor)ventana).destruir();
        }
        ventana.dispose();
    }
    
}
