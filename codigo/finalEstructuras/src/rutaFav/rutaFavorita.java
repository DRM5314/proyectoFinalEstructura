package rutaFav;

import java.util.ArrayList;

public class rutaFavorita {

    private rutaFavorita siguiente = null;
    private rutaFavorita raiz = null;    
    private String ruta;
    private int numeroVisitas = 0;

    public static rutaFavorita insertar(rutaFavorita entrada, String ruta) {
        rutaFavorita aux1 = entrada;
        rutaFavorita aux2 = null;
        rutaFavorita nueva = new rutaFavorita();
        nueva.ruta = ruta;
        nueva.numeroVisitas++;
        while (aux1!=null) {
            aux2 = aux1;
            aux1 = aux1.siguiente;
        }
        if(entrada == aux1){
            nueva.raiz = nueva;
            entrada = nueva;
        }else{
            nueva.raiz = aux2.raiz;
            aux2.siguiente = nueva;
        }
        return nueva.raiz;
    }
    public static rutaFavorita verificarRuta (String ruta,rutaFavorita entrada){
        rutaFavorita aux = entrada;
        rutaFavorita aux1 = null;
        if(entrada == null){
            return insertar(entrada, ruta);
            
        }else
        while (aux!=null) {            
            if(aux.ruta.equals(ruta)){
                aux.numeroVisitas++;
                return aux.raiz;
            }else
            aux1 = aux;
            aux = aux.siguiente;
        }
        return insertar(entrada, ruta);        
    }
    public static ArrayList<String> rutasFav(rutaFavorita entrada,ArrayList<String> listado){        
        rutaFavorita aux1 = entrada;        
        listado.clear();
        while (aux1!=null) {            
            if(aux1.numeroVisitas>=3){
                listado.add(aux1.ruta+" # visitas: "+aux1.numeroVisitas);
            }
            aux1 = aux1.siguiente;
        }
        return listado;
    }
}
