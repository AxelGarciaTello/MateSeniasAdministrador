
package Control;

import GUI.InformacionNinioPanel;
import Logico.Tutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class EditarNinioActionListener implements ActionListener {
    private InformacionNinioPanel ventana;
    private JList opciones;
    private Tutor tutor;
    
    public EditarNinioActionListener(InformacionNinioPanel ventana,
            JList opciones, Tutor tutor){
        this.ventana=ventana;
        this.opciones=opciones;
        this.tutor=tutor;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int opcion=opciones.getSelectedIndex();
        String nombre;
        if(opcion!=-1){
            nombre=JOptionPane.showInputDialog(
                    null, "Nuevo nombre del niño", "Cambiar nombre", 3
            );
            if(nombre!=null){
                tutor.getNinios(opcion).setNombre(nombre);
                ventana.actualizar();
            }
        }
    }
    
}
