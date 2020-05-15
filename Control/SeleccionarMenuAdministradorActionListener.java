
package Control;


import GUI.InformacionNinioPanel;
import GUI.InformacionTutorPanel;
import Logico.Administrador;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SeleccionarMenuAdministradorActionListener implements
        ActionListener {
    private JPanel menu;
    private CardLayout cl;
    private int opcion;
    private JList tutores;
    private Administrador administrador;
    private JPanel tutor;
    
    public SeleccionarMenuAdministradorActionListener(JPanel menu,
            int opcion, JList tutores, Administrador administrador,
            JPanel tutor){
        cl=(CardLayout) menu.getLayout();
        this.menu=menu;
        this.opcion=opcion;
        this.tutores=tutores;
        this.administrador=administrador;
        this.tutor=tutor;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int seleccion=tutores.getSelectedIndex();
        if(opcion==3){
            System.exit(0);
        }
        if(seleccion==-1){
            JOptionPane.showMessageDialog(
                    null, "Por favor seleccione un tutor", "Error", 1
            );
        }
        else{
            switch(opcion){
                case 1:
                    ((InformacionTutorPanel)tutor).actualizar(
                            administrador.getTutores(seleccion), seleccion
                    );
                    cl.show(menu, "informacion");
                break;
                case 2:
                    ((InformacionNinioPanel)tutor).agregarTutor(
                            administrador.getTutores(seleccion)
                    );
                    cl.show(menu, "ninio");
                break;
            }
        }
    }
    
}
