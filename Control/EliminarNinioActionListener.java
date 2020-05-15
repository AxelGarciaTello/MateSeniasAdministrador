
package Control;

import GUI.InformacionNinioPanel;
import Logico.Tutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class EliminarNinioActionListener implements ActionListener {
    private InformacionNinioPanel ventana;
    private JList opciones;
    private Tutor tutor;
    
    public EliminarNinioActionListener(InformacionNinioPanel ventana,
            JList opciones, Tutor tutor){
        this.ventana=ventana;
        this.opciones=opciones;
        this.tutor=tutor;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int opcion=opciones.getSelectedIndex();
        if(opcion!=-1){
            opcion=JOptionPane.showConfirmDialog(
                    null, "Esta seguro que quiere eliminar esta cuenta",
                    "Eliminar", 0, 2
            );
            if(opcion==0){
                tutor.eliminarNinio(opciones.getSelectedIndex());
                ventana.actualizar();
            }
        }
    }
    
}
