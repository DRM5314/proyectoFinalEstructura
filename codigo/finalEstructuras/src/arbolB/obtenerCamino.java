package arbolB;

public class obtenerCamino {
    public static String obtenerRuta(estructura arbolEntrada[],boolean mejorRuta){
        estructura aux [] = arbolEntrada;
        String ruta = "";
        double costo = 0;
        while (aux != null) {            
            if(mejorRuta){
                if(aux[0].hijoI != null){
                    aux = aux[0].hijoI;
                }else{
                    for (int i = 0; i < aux[0].lugar.length; i++) {
                        ruta+=aux[0].lugar[i];
                        if(i+1 < aux[0].lugar.length)ruta+=" ->";                        
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
                                    ruta+=aux[i-1].lugar[j];
                                    if(i+1 < aux[i-1].lugar.length)ruta+=" ->";
                                }else{
                                    ruta+=aux[i].lugar[j];
                                    if(i+1 < aux[i].lugar.length)ruta+=" ->";
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
        ruta += " Costo: "+costo;
        return ruta;
    }
}
