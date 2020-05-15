
package Control;

import GUI.RegistroFrame;
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
        if(ventana instanceof RegistroFrame){
            ((RegistroFrame)ventana).destruir();
        }
        ventana.dispose();
    }
    
}
