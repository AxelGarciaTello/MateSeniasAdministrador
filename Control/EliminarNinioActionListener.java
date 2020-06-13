
package Control;

import GUI.InformacionNinioPanel;
import Logico.Administrador;
import Logico.Tutor;
import Persistencia.ConexionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;
import javax.swing.JOptionPane;


public class EliminarNinioActionListener implements ActionListener {
    private InformacionNinioPanel ventana;
    private JList opciones;
    private Tutor tutor;
    private Administrador administrador;
    
    public EliminarNinioActionListener(InformacionNinioPanel ventana,
            JList opciones, Tutor tutor, Administrador administrador){
        this.ventana=ventana;
        this.opciones=opciones;
        this.tutor=tutor;
        this.administrador=administrador;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ConexionBD bd;
        String sentencia="INSERT INTO `Admin_Infante` (`idRegistro`, "
                + "`usrinfante`, `emailadmin`, `idAccion`) VALUES (NULL, '"
                +tutor.getNinios(opciones.getSelectedIndex()).getNombre()
                +"', '"+tutor.getCorreo()+"', '4');";
        int opcion=opciones.getSelectedIndex();
        if(opcion!=-1){
            opcion=JOptionPane.showConfirmDialog(
                    null, "Esta seguro que quiere eliminar esta cuenta",
                    "Eliminar", 0, 2
            );
            if(opcion==0){
                tutor.eliminarNinio(opciones.getSelectedIndex());
                bd = new ConexionBD();
                bd.administrar(sentencia);
                ventana.actualizar();
            }
        }
    }
    
}
