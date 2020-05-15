
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class EditarTutorActionListener implements ActionListener {
    private Object[] paquete;
    private JTextField[] editables;
    
    public EditarTutorActionListener(Object[] paquete,
            JTextField[] editables){
        this.paquete=paquete;
        this.editables=editables;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int tamanio=0,
            x=0;
        tamanio=paquete.length;
        for(x=0; x<tamanio; x++){
            if(paquete[x] instanceof JLabel){
                if(((JLabel)paquete[x]).isVisible()){
                    ((JLabel)paquete[x]).setVisible(false);
                }
                else{
                    ((JLabel)paquete[x]).setVisible(true);
                }
            }
            else if(paquete[x] instanceof JPasswordField){
                if(((JPasswordField)paquete[x]).isVisible()){
                    ((JPasswordField)paquete[x]).setVisible(false);
                    ((JPasswordField)paquete[x]).setText("");
                }
                else{
                    ((JPasswordField)paquete[x]).setVisible(true);
                    ((JPasswordField)paquete[x]).setText("");
                }
            }
            else if(paquete[x] instanceof JButton){
                if(((JButton)paquete[x]).isVisible()){
                    ((JButton)paquete[x]).setVisible(false);
                }
                else{
                    ((JButton)paquete[x]).setVisible(true);
                }
            }
        }
        tamanio=editables.length;
        for(x=0; x<tamanio; x++){
            if(editables[x].isEditable()){
                editables[x].setEditable(false);
            }
            else{
                editables[x].setEditable(true);
            }
        }
    }
    
    public JTextField[] getEditables(){
        return editables;
    }
    
}
