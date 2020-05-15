
package Control;

import Logico.Ninio;
import Logico.Progreso;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class VerProgresoNinioListSelectionListener implements 
        ListSelectionListener {
    private JList opciones;
    private Ninio[] ninios;
    private JLabel titulo;
    private JLabel[] temas;
    private JProgressBar[] progresosBarra;
    
    public VerProgresoNinioListSelectionListener(JList opciones, Ninio[] ninios,
            JLabel titulo, JLabel[] temas, JProgressBar[] progreso){
        this.opciones=opciones;
        this.ninios=ninios;
        this.titulo=titulo;
        this.temas=temas;
        this.progresosBarra=progreso;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        int opcion=opciones.getSelectedIndex(),
            tamanio=0,
            x=0;
        if(opcion!=-1){
            titulo.setText(ninios[opcion].getNombre());
            Progreso[] progresos = ninios[opcion].getProgreso();
            tamanio=progresos.length;
            for(x=0; x<tamanio; x++){
                temas[x].setText(progresos[x].getNombreTema());
                progresosBarra[x].setValue(progresos[x].getValor());
            }
        }
        
    }
    
}
