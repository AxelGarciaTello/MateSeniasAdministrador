
package Logico;


public class Ninio {
    private String nombre;
    private Progreso[] progresos;
    
    public Ninio(String nombre){
        int x;
        String[] temas={"Suma con Unidades",
                        "Suma con Decenas",
                        "Suma con Centenas",
                        "Resta con Unidades",
                        "Resta con Decenas",
                        "Resta con Centenas",
                        "Multiplicación con Unidades",
                        "Multiplicación con Decenas",
                        "Multilicación con Centenas",
                        "Divición con Unidades",
                        "División con Decenas",
                        "División con Centenas",
                        "Crucigrama sumas",
                        "Crucigrama restas",
                        "Crucigrama sumas y restas",
                        "Crucigrama sumas y restas 2",
                        "Crucigrama multiplicaciones",
                        "Crucigrama divisiones",
                        "Crucigrama multiplicaciones y divisiones",
                        "Crucigrama multiplicaciones y divisiones 2",
                        "Crucigrama operadores",
                        "Crucigrama operadores 2",
                        "Crucigrama operadores 3",
                        "Crucigrama operadores 4"
        };
        this.nombre=nombre;
        progresos = new Progreso[24];
        for(x=0; x<24; x++){
            progresos[x] = new Progreso(temas[x]);
        }
    }
    
    public Ninio(String nombre, Progreso[] progresos){
        this.nombre=nombre;
        this.progresos=progresos;
    }
    
    public void destruir(){
        int x;
        if(nombre!=null){
            nombre=null;
        }
        for(x=0; x<24; x++){
            if(progresos[x]!=null){
                progresos[x].destruir();
                progresos[x]=null;
            }
        }
        System.gc();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public Progreso getProgreso(int progreso){
        return progresos[progreso];
    }
    
    public Progreso[] getProgreso(){
        return progresos;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
}
