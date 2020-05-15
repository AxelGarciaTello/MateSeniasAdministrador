
package Logico;


public class Progreso {
    private String nombreTema;
    private int valor;
    
    public Progreso(String nombreTema){
        this.nombreTema=nombreTema;
        valor=0;
    }
    
    public Progreso(String nombreTema, int valor){
        this.nombreTema=nombreTema;
        this.valor=valor;
    }
    
    public void destruir(){
        if(nombreTema!=null){
            nombreTema=null;
        }
        System.gc();
    }
    
    public void setNombreTema(String nombreTema){
        this.nombreTema=nombreTema;
    }
    
    public void setValor(int valor){
        this.valor=valor;
    }
    
    public String getNombreTema(){
        return nombreTema;
    }
    
    public int getValor(){
        return valor;
    }
    
}
