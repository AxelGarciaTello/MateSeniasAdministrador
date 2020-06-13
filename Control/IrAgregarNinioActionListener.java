
package Control;

import GUI.InformacionNinioPanel;
import GUI.RegistroNinio;
import Logico.Administrador;
import Logico.Tutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IrAgregarNinioActionListener implements ActionListener {
    private InformacionNinioPanel ventana;
    private Tutor tutor;
    private Administrador administrador;
    
    public IrAgregarNinioActionListener(InformacionNinioPanel ventana,
            Tutor tutor, Administrador administrador){
        this.ventana=ventana;
        this.tutor=tutor;
        this.administrador=administrador;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        RegistroNinio registro = new RegistroNinio(
                ventana, tutor, administrador
        );
        registro.setVisible(true);
    }
    
}
