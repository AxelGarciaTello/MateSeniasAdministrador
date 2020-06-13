
package Control;

import GUI.MenuAdministrador;
import GUI.RegistroTutor;
import Logico.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IrRegistroTutorActionListener implements ActionListener {
    private MenuAdministrador menu;
    private Administrador administrador;
    
    public IrRegistroTutorActionListener(MenuAdministrador menu,
            Administrador administrador){
        this.menu=menu;
        this.administrador=administrador;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        RegistroTutor registro = new RegistroTutor(menu, administrador);
        registro.setVisible(true);
    }
    
}
