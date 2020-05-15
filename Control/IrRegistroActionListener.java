
package Control;

import GUI.MenuAdministrador;
import GUI.RegistroFrame;
import Logico.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IrRegistroActionListener implements ActionListener {
    private MenuAdministrador menu;
    private Administrador administrador;
    
    public IrRegistroActionListener(MenuAdministrador menu,
            Administrador administrador){
        this.menu=menu;
        this.administrador=administrador;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        RegistroFrame registro = new RegistroFrame(menu, administrador);
        registro.setVisible(true);
    }
    
}
