package arbolB;

import java.util.ArrayList;

public class obtenerCamino {
    public static ArrayList<String> obtenerRuta(estructura arbolEntrada[],boolean mejorRuta){
        ArrayList <String> ruta = new ArrayList<String>();
        estructura aux [] = arbolEntrada;
        double costo = 0;
        while (aux != null) {
            if(mejorRuta){
                if(aux[0].hijoI != null){
                    aux = aux[0].hijoI;
                }else{
                    for (int i = 0; i < aux[0].lugar.length; i++) {
                        ruta.add(aux[0].lugar[i]);
                    }
                    costo = aux[0].dato;
                    aux = null;
                }
            }else{
                if(aux[0].hijoD != null){
                    aux = aux[0].hijoD;
                }else{
                    for (int i = 0; i < aux.length; i++) {
                        if(aux[i]==null){
                            for (int j = 0; j < aux[i-1].lugar.length; j++) {
                                if(i>0){
                                    ruta.add(aux[i-1].lugar[j]);
                                }else{
                                    ruta.add(aux[i].lugar[j]);
                                }
                            }
                            if(i>0)costo = aux[i-1].dato;
                            else costo = aux[i].dato;
                            aux = null;                            
                            break;
                        }
                    }
                }
            }
        }
        ruta.add(""+costo);
        return ruta;
    }
    public static ArrayList<String> invertidor(ArrayList<String> entrada,int posicionesFinales []){
        ArrayList<String> retorno = null;
        int contador;
        String auxCosto="";
        if( entrada!=null && entrada.size()>0 && posicionesFinales!=null && posicionesFinales.length>0){
            contador = posicionesFinales.length-1;
            retorno = new ArrayList<>();
            for (int i = entrada.size() - 1; i > -1 ; i--) {
                if(i!=posicionesFinales[contador]){
                    retorno.add(entrada.get(i));
                }else{
                    if(i!=entrada.size() - 1)retorno.add(auxCosto);
                    auxCosto = entrada.get(i);
                    if(contador>0)contador--;
                }
            }
            retorno.add(entrada.get(entrada.size()-1));
        }
        return retorno;
    }
}
