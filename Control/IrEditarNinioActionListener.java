
package Control;

import GUI.EditadoNinio;
import GUI.InformacionNinioPanel;
import Logico.Administrador;
import Logico.Tutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;


public class IrEditarNinioActionListener implements ActionListener {
    private InformacionNinioPanel ventana;
    private JList ninios;
    private Tutor tutor;
    private Administrador administrador;
    
    public IrEditarNinioActionListener(InformacionNinioPanel ventana,
            JList ninios, Tutor tutor, Administrador administrador){
        this.ventana=ventana;
        this.ninios=ninios;
        this.tutor=tutor;
        this.administrador=administrador;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        EditadoNinio editado = new EditadoNinio(
                ventana, ninios, tutor, administrador
        );
        editado.setVisible(true);
    }
    
}
