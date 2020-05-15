
package Control;

import Logico.Tutor;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class CancelarEditadoTutor extends 
        EditarTutorActionListener {
    private Tutor tutor;
    
    public CancelarEditadoTutor(Object[] paquete,
            JTextField[] editables, Tutor tutor) {
        super(paquete, editables);
        this.tutor=tutor;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        super.actionPerformed(ae);
        JTextField[] editables = super.getEditables();
        editables[0].setText(tutor.getNombre());
        editables[1].setText(tutor.getCorreo());
    }
    
}
