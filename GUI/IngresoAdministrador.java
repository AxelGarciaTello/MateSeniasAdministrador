
package GUI;

import Control.IngresarAdministradorActionListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;


public class IngresoAdministrador extends IngresoFrame {
    private JPasswordField contrasenia;
    private JButton ingresar;
    private Container contenedor;
    
    public IngresoAdministrador(){
        super();
        initComponents();
    }
    
    private void initComponents(){
        contenedor = super.getContenedor();
        JLabel etiqueta = new JLabel("Contaseña");
        etiqueta.setSize(200, 25);
        etiqueta.setLocation(50, 170);
        etiqueta.setFont(new Font("Ubuntu", 0, 20));
        etiqueta.setForeground(new Color(255, 255, 255));
        contrasenia = new JPasswordField();
        contrasenia.setSize(200, 30);
        contrasenia.setLocation(50, 205);
        contrasenia.setFont(new Font("Ubuntu", 0, 20));
        ingresar = new JButton("Ingresar");
        ingresar.setSize(200, 30);
        ingresar.setLocation(50, 245);
        ingresar.setBackground(new Color(47, 55, 74));
        ingresar.setForeground(new Color(255, 255, 255));
        ingresar.setBorder(null);
        ingresar.setFont(new Font("Ubuntu", 0, 20));
        contenedor.add(etiqueta);
        contenedor.add(contrasenia);
        contenedor.add(ingresar);
        ingresar.addActionListener(
                new IngresarAdministradorActionListener(
                        this, super.getNombre(), contrasenia
                )
        );
    }
    
    @Override
    public void destruir(){
        super.destruir();
        if(contrasenia!=null){
            contrasenia=null;
        }
        if(ingresar!=null){
            ingresar=null;
        }
        if(contenedor!=null){
            contenedor=null;
        }
        System.gc();
    }
    
}
