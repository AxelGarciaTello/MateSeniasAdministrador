
package GUI;

import Control.IrRegistroActionListener;
import Control.SeleccionarMenuAdministradorActionListener;
import Logico.Administrador;
import Logico.Tutor;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MenuAdministrador extends MenuFrame {
    private JButton nuevoTutor,
                    informacion,
                    ninios,
                    salir;
    private JList tutores;
    private JPanel menu,
                   fondo,
                   supermenu;
    private Administrador administrador;
    private InformacionTutorPanel informacionTutor;
    private InformacionNinioPanel informacionNinio;
    
    public MenuAdministrador(Administrador administrador){
        super();
        this.administrador=administrador;
        initComponents();
    }
    
    private void initComponents(){
        crearFondo();
        super.agregarFondo(fondo);
        informacionTutor = new InformacionTutorPanel(administrador, this);
        informacionNinio = new InformacionNinioPanel();
        supermenu = new JPanel();
        supermenu = new JPanel();
        supermenu.setLayout(new CardLayout());
        supermenu.add(fondo, "fondo");
        supermenu.add(informacionTutor, "informacion");
        supermenu.add(informacionNinio, "ninio");
        super.agregarFondo(supermenu);
        crearMenu();
    }
    
    private void crearFondo(){
        fondo = new JPanel();
        fondo.setBackground(new Color(56, 87, 35));
        fondo.setLayout(new BorderLayout());
        fondo.add(super.getIcono(), BorderLayout.CENTER);
    }
    
    private void crearMenu(){
        int tamanio=0,
            x=0;
        menu = new JPanel();
        menu.setBackground(new Color(56, 87, 35));
        menu.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill=GridBagConstraints.BOTH;
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        Tutor[] listaTutores = administrador.getTutores();
        DefaultListModel model = new DefaultListModel<>();
        if(listaTutores!=null){
            tamanio=listaTutores.length;
            for(x=0; x<tamanio; x++){
                model.addElement("     "+listaTutores[x].getNombre()+"     ");
                
            }
        }
        tutores = new JList();
        tutores.setModel(model);
        tutores.setBackground(new Color(56, 87, 35));
        tutores.setForeground(new Color(255, 255, 255));
        tutores.setFont(new Font("Ubuntu", 0, 20));
        JScrollPane seleccion = new JScrollPane();
        seleccion.setViewportView(tutores);
        seleccion.setBorder(null);
        constraints.gridx=1;
        constraints.gridy=0;
        constraints.gridwidth=1;
        constraints.gridheight=4;
        menu.add(seleccion, constraints);
        constraints.gridx=0;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        nuevoTutor = new JButton("Nuevo tutor");
        nuevoTutor.setIcon(
                new ImageIcon(
                        getClass().getResource("Iconos/Agregar.png")
                )
        );
        nuevoTutor.setBackground(new Color(56, 87, 35));
        nuevoTutor.setForeground(new Color(255, 255, 255));
        nuevoTutor.setBorder(null);
        nuevoTutor.addActionListener(
                new IrRegistroActionListener(this, administrador)
        );
        menu.add(nuevoTutor, constraints);
        constraints.gridy+=1;
        informacion = new JButton("Información del tutor");
        informacion.setIcon(
                new ImageIcon(
                        getClass().getResource("Iconos/Informacion.png")
                )
        );
        informacion.setBackground(new Color(56, 87, 35));
        informacion.setForeground(new Color(255, 255, 255));
        informacion.setBorder(null);
        informacion.addActionListener(
                new SeleccionarMenuAdministradorActionListener(
                        supermenu, 1, tutores, administrador, informacionTutor
                )
        );
        menu.add(informacion, constraints);
        constraints.gridy+=1;
        ninios = new JButton("Niños");
        ninios.setIcon(
                new ImageIcon(
                        getClass().getResource("Iconos/Progreso.png")
                )
        );
        ninios.setBackground(new Color(56, 87, 35));
        ninios.setForeground(new Color(255, 255, 255));
        ninios.setBorder(null);
        ninios.addActionListener(
                new SeleccionarMenuAdministradorActionListener(
                        supermenu, 2, tutores, administrador, informacionNinio
                )
        );
        menu.add(ninios, constraints);
        constraints.gridy+=1;
        salir = new JButton("Salir");
        salir.setIcon(
                new ImageIcon(
                        getClass().getResource("Iconos/Salir.png")
                )
        );
        salir.setBackground(new Color(56, 87, 35));
        salir.setForeground(new Color(255, 255, 255));
        salir.setBorder(null);
        salir.addActionListener(
                new SeleccionarMenuAdministradorActionListener(
                        supermenu, 3, tutores, administrador, null
                )
        );
        menu.add(salir, constraints);
        super.agregarMenu(menu);
    }
    
    public void destruir(){
        if(nuevoTutor!=null){
            nuevoTutor=null;
        }
        if(informacion!=null){
            informacion=null;
        }
        if(ninios!=null){
            ninios=null;
        }
        if(salir!=null){
            salir=null;
        }
        if(tutores!=null){
            tutores=null;
        }
        if(menu!=null){
            menu=null;
        }
        if(fondo!=null){
            fondo=null;
        }
        if(supermenu!=null){
            supermenu=null;
        }
        if(administrador!=null){
            administrador.destruir();
            administrador=null;
        }
        if(informacionTutor!=null){
            informacionTutor=null;
        }
        if(informacionNinio!=null){
            informacionNinio=null;
        }
        System.gc();
    }
    
    public void actualizar(){
        int tamanio=0,
            x=0;
        Tutor[] listaTutores = administrador.getTutores();
        DefaultListModel model = new DefaultListModel<>();
        if(listaTutores!=null){
            tamanio=listaTutores.length;
            for(x=0; x<tamanio; x++){
                model.addElement("     "+listaTutores[x].getNombre()+"     ");
            }
        }
        tutores.setModel(model);
    }
    
}
