
package Logico;


public class Administrador {
    private Tutor[] tutores;
    
    public Administrador(Tutor[] tutores){
        this.tutores=tutores;
    }
    
    public void destruir(){
        int tamanio=0,
            x=0;
        if(tutores!=null){
            tamanio=tutores.length;
            for(x=0; x<tamanio; x++){
                if(tutores[x]!=null){
                    tutores[x]=null;
                }
            }
        }
        System.gc();
    }
    
    public Tutor getTutores(int x){
        return tutores[x];
    }
    
    public Tutor[] getTutores(){
        return tutores;
    }
    
    public void setTutor(Tutor nuevo){
        int tamanio=tutores.length,
            x=0;
        Tutor[] nuevos = new Tutor[tamanio+1];
        for(x=0; x<tamanio; x++){
            nuevos[x]=tutores[x];
        }
        nuevos[x]=nuevo;
        tutores=nuevos;
    }
    
    public void eliminarTutor(int posicion){
        int tamanio=tutores.length,
            x=0,
            y=0;
        Tutor[] nuevos = new Tutor[tamanio-1];
        while(x<(tamanio-1)){
            if(y==posicion){
                tutores[y]=null;
                y++;
            }
            else{
                nuevos[x]=tutores[y];
                x++;
                y++;
            }
        }
        tutores=nuevos;
    }
    
}
