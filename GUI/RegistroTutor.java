
package GUI;

import Control.CerrarVentanaActionListener;
import Control.GuardarRegistroTutorActionListener;
import Logico.Administrador;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;


public class RegistroTutor extends RegistroFrame {
    private JButton guardar,
                    cancelar;
    private MenuAdministrador menu;
    private Administrador administrador;
    
    public RegistroTutor(MenuAdministrador menu,
            Administrador administrador){
        super();
        this.menu=menu;
        this.administrador=administrador;
        initComponents();
    }
    
    private void initComponents(){
        int a=0,
            x=80;
        guardar = new JButton("Registrate");
        guardar.setSize(240, 30);
        guardar.setLocation(30, 365);
        guardar.setFont(new Font("Ubuntu", 0, 20));
        guardar.setBorder(null);
        guardar.setBackground(new Color(47, 55, 74));
        guardar.setForeground(new Color(255, 255, 255));
        guardar.addActionListener(new GuardarRegistroTutorActionListener(
                        super.getNombre(), super.getCorreo(),
                        super.getContrasenia(), super.getConfirmacion(), this,
                        menu, administrador
                )
        );
        super.agregar(guardar);
        cancelar = new JButton("Cancelar");
        cancelar.setSize(240, 30);
        cancelar.setLocation(30, 400);
        cancelar.setFont(new Font("Ubuntu", 0, 20));
        cancelar.setBorder(null);
        cancelar.setBackground(new Color(227, 66, 51));
        cancelar.setForeground(new Color(255, 255, 255));
        cancelar.addActionListener(
                new CerrarVentanaActionListener(this)
        );
        super.agregar(cancelar);
    }
    
    public void destruir(){
        super.destruir();
        if(guardar!=null){
            guardar=null;
        }
        if(cancelar!=null){
            cancelar=null;
        }
        System.gc();
    }
}
