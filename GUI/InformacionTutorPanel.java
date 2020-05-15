
package GUI;

import Control.CancelarEditadoTutor;
import Control.EditarTutorActionListener;
import Control.EliminarTutorActionListener;
import Control.GuardarEditadoTutor;
import Logico.Administrador;
import Logico.Tutor;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class InformacionTutorPanel extends JPanel{
    private JTextField nombre,
                       correo;
    private JTextField[] editables;
    private JPasswordField contrasenia,
                           nuevaContrasenia,
                           confirmacion;
    private JButton editar,
                    eliminar,
                    guardar,
                    cancelar;
    private Object[] paquete;
    private CancelarEditadoTutor accionCancelar;
    private EliminarTutorActionListener accionEliminar;
    private GuardarEditadoTutor accionGuardar;
    private Tutor tutor;
    private int numero;
    private Administrador administrador;
    private MenuAdministrador menu;
    
    public InformacionTutorPanel(Administrador administrador,
            MenuAdministrador menu){
        accionCancelar=null;
        accionEliminar=null;
        accionGuardar=null;
        this.administrador=administrador;
        this.menu=menu;
        initComponents();
    }
    
    private void initComponents(){
        int a=0;
        this.setBackground(new Color(56, 87, 35));
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        JLabel[] margen= new JLabel[5];
        margen[0] = new JLabel();
        margen[0].setSize(50, 40);
        this.add(margen[0], constraints);
        margen[1] = new JLabel();
        margen[1].setSize(50, 40);
        constraints.gridx=3;
        this.add(margen[1], constraints);
        JLabel titulo = new JLabel("Información");
        titulo.setFont(new Font("Ubuntu", 0, 35));
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);
        constraints.gridx=1;
        constraints.gridwidth=2;
        this.add(titulo, constraints);
        JLabel[] etiquetas = new JLabel[5];
        etiquetas[0] = new JLabel("Nombre   ");
        etiquetas[1] = new JLabel("Correo  ");
        etiquetas[2] = new JLabel("Contraseña");
        etiquetas[3] = new JLabel("Nueva contraseña");
        etiquetas[4] = new JLabel("Confirmar contraseña   ");
        constraints.weightx=0.0;
        constraints.gridwidth=1;
        for(a=0; a<5; a++){
            etiquetas[a].setFont(new Font("Ubuntu", 0, 20));
            etiquetas[a].setForeground(new Color(255, 255, 255));
            constraints.gridy=a+1;
            this.add(etiquetas[a], constraints);
        }
        nombre = new JTextField("");
        nombre.setFont(new Font("Ubuntu", 0, 20));
        constraints.gridx=2;
        constraints.gridy=1;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(nombre, constraints);
        correo = new JTextField("");
        correo.setFont(new Font("Ubuntu", 0, 20));
        constraints.gridy+=1;
        this.add(correo, constraints);
        contrasenia = new JPasswordField();
        contrasenia.setFont(new Font("Ubuntu", 0, 20));
        constraints.gridy+=1;
        this.add(contrasenia, constraints);
        nuevaContrasenia = new JPasswordField();
        nuevaContrasenia.setFont(new Font("Ubuntu", 0, 20));
        constraints.gridy+=1;
        this.add(nuevaContrasenia, constraints);
        confirmacion = new JPasswordField();
        confirmacion.setFont(new Font("Ubuntu", 0, 20));
        constraints.gridy+=1;
        this.add(confirmacion, constraints);
        constraints.gridwidth=2;
        constraints.gridx=1;
        constraints.fill=GridBagConstraints.BOTH;
        margen[2] = new JLabel();
        constraints.gridy+=1;
        this.add(margen[2], constraints);
        margen[3] = new JLabel();
        constraints.gridy+=1;
        this.add(margen[3], constraints);
        constraints.fill=GridBagConstraints.HORIZONTAL;
        editar = new JButton("Editar");
        editar.setFont(new Font("Ubuntu", 0, 20));
        editar.setBorder(null);
        editar.setBackground(new Color(47, 55, 74));
        editar.setForeground(new Color(255, 255, 255));
        constraints.gridy+=1;
        this.add(editar, constraints);
        eliminar = new JButton("Eliminar cuenta");
        eliminar.setFont(new Font("Ubuntu", 0, 20));
        eliminar.setBorder(null);
        eliminar.setBackground(new Color(227, 66, 51));
        eliminar.setForeground(new Color(255, 255, 255));
        constraints.gridy+=1;
        this.add(eliminar, constraints);
        guardar = new JButton("Guardar");
        guardar.setFont(new Font("Ubuntu", 0, 20));
        guardar.setBorder(null);
        guardar.setBackground(new Color(47, 55, 74));
        guardar.setForeground(new Color(255, 255, 255));
        constraints.gridy+=1;
        this.add(guardar, constraints);
        cancelar = new JButton("Cancelar");
        cancelar.setFont(new Font("Ubuntu", 0, 20));
        cancelar.setBorder(null);
        cancelar.setBackground(new Color(47, 55, 74));
        cancelar.setForeground(new Color(255, 255, 255));
        constraints.gridy+=1;
        this.add(cancelar, constraints);
        constraints.fill=GridBagConstraints.BOTH;
        margen[4] = new JLabel();
        margen[4].setSize(100, 500);
        constraints.gridy+=1;
        this.add(margen[4], constraints);
        etiquetas[2].setVisible(false);
        etiquetas[3].setVisible(false);
        etiquetas[4].setVisible(false);
        nombre.setEditable(false);
        correo.setEditable(false);
        contrasenia.setVisible(false);
        nuevaContrasenia.setVisible(false);
        confirmacion.setVisible(false);
        guardar.setVisible(false);
        cancelar.setVisible(false);
        paquete = new Object[12];
        paquete[0]=etiquetas[2];
        paquete[1]=etiquetas[3];
        paquete[2]=etiquetas[4];
        paquete[3]=contrasenia;
        paquete[4]=nuevaContrasenia;
        paquete[5]=confirmacion;
        paquete[6]=guardar;
        paquete[7]=cancelar;
        paquete[8]=margen[2];
        paquete[9]=margen[3];
        paquete[10]=editar;
        paquete[11]=eliminar;
        editables = new JTextField[2];
        editables[0]=nombre;
        editables[1]=correo;
        editar.addActionListener(
                new EditarTutorActionListener(
                        paquete, editables
                )
        );
        cancelar.addActionListener(accionCancelar);
        eliminar.addActionListener(accionEliminar);
        guardar.addActionListener(accionGuardar);
    }
    
    public void destruir(){
        int tamanio=0,
            x=0;
        if(nombre!=null){
            nombre=null;
        }
        if(correo!=null){
            correo=null;
        }
        if(editables!=null){
            tamanio=editables.length;
            for(x=0; x<tamanio; x++){
                if(editables[x]!=null){
                    editables[x]=null;
                }
            }
        }
        if(contrasenia!=null){
            contrasenia=null;
        }
        if(nuevaContrasenia!=null){
            nuevaContrasenia=null;
        }
        if(confirmacion!=null){
            confirmacion=null;
        }
        if(editar!=null){
            editar=null;
        }
        if(eliminar!=null){
            eliminar=null;
        }
        if(guardar!=null){
            guardar=null;
        }
        if(cancelar!=null){
            cancelar=null;
        }
        if(paquete!=null){
            tamanio=paquete.length;
            for(x=0; x<tamanio; x++){
                if(paquete[x]!=null){
                    paquete[x]=null;
                }
            }
        }
        if(accionCancelar!=null){
            accionCancelar=null;
        }
        if(accionEliminar!=null){
            accionEliminar=null;
        }
        if(accionGuardar!=null){
            accionGuardar=null;
        }
        System.gc();
    }
    
    public void actualizar(Tutor tutor, int numero){
        this.tutor=tutor;
        nombre.setText(tutor.getNombre());
        correo.setText(tutor.getCorreo());
        cancelar.removeActionListener(accionCancelar);
        accionCancelar = new CancelarEditadoTutor(paquete, editables, tutor);
        cancelar.addActionListener(accionCancelar);
        eliminar.removeActionListener(accionEliminar);
        accionEliminar = new EliminarTutorActionListener(
                numero, administrador, menu
        );
        eliminar.addActionListener(accionEliminar);
        guardar.removeActionListener(accionGuardar);
        accionGuardar = new GuardarEditadoTutor(
                paquete, editables, nombre, correo, contrasenia, 
                nuevaContrasenia, confirmacion, this.tutor, menu
        );
        guardar.addActionListener(accionGuardar);
    }
    
}
