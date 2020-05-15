
package Control;

import GUI.MenuAdministrador;
import Logico.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class EliminarTutorActionListener implements ActionListener {
    private int seleccion;
    private Administrador administrador;
    private MenuAdministrador menu;
    
    public EliminarTutorActionListener(int seleccion,
            Administrador administrador, MenuAdministrador menu){
        this.seleccion=seleccion;
        this.administrador=administrador;
        this.menu=menu;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int opcion=JOptionPane.showConfirmDialog(
                null, "Esta seguro que quiere eliminar su "
                        + "cuenta", "Eliminar", 0, 2
        );
        if(opcion==0){
            administrador.eliminarTutor(seleccion);
            menu.actualizar();
        }
    }
    
}
