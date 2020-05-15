
package Control;

import GUI.InformacionNinioPanel;
import Logico.Ninio;
import Logico.Tutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class AgregarNinioActionListener implements ActionListener {
    private InformacionNinioPanel ventana;
    private Tutor tutor;
    
    public AgregarNinioActionListener(InformacionNinioPanel ventana,
            Tutor tutor){
        this.ventana=ventana;
        this.tutor=tutor;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int tamanio=0,
            x=0;
        String nombre=JOptionPane.showInputDialog(
                null, "Nombre del niño", "Nuevo niño", 3
        );
        if(nombre!=null){
            tutor.setNinio(new Ninio(nombre));
            ventana.actualizar();
        }
    }
    
}
