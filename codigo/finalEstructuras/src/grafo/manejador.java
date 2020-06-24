package grafo;

import arbolB.estructura;
import arbolB.insertar;
import java.util.ArrayList;
import java.util.List;

public class manejador {
    public static List <String> origenesDestino(String destino,origen origeneEntrada[],List <String> listadoAnterior){
        List <String> retorno = new ArrayList<>();        
        for (int i = 0; i < origeneEntrada.length; i++) {
            for (int j = 0; j < origeneEntrada[i].getDestino().length; j++) {
                if(origeneEntrada[i].getDestino()[j].getDestino().equals(destino)){
                    if(listadoAnterior!= null && listadoAnterior.contains(origeneEntrada[i].getOrigen()))break;
                    retorno.add(origeneEntrada[i].getOrigen());
                }
            }            
        }

        return retorno;
    }
    public static arbolB.estructura [] getRutas(List <String> datosOrigen, String posicionActual,origen origenes[],String destino,origen origenEntrada,int tipoConsumoBusqueda,boolean enCarro){
        arbolB.estructura retorno [] = new estructura[5];
        List <String> listadoOrigenDestino = origenesDestino(destino, origenes,null);
        for (int i = 0; i < listadoOrigenDestino.size(); i++) {
            List <String[] > rutasObtenida = rutas(listadoOrigenDestino.get(i), origenes, origenEntrada,destino);
            if(!origenEntrada.getNombresDestinos().contains(listadoOrigenDestino.get(i)) && !origenEntrada.getOrigen().equals(listadoOrigenDestino.get(i))){
                rutasObtenida = rutas(listadoOrigenDestino.get(i), origenes, origenEntrada,destino);
                if(rutasObtenida.size()>0){
                    for (int j = 0; j < rutasObtenida.size(); j++) {
                        int posicionUltima = rutasObtenida.get(j).length-1;
                        rutasObtenida.get(j)[posicionUltima] = destino;
                    }                
                    retorno = insertarRuta(rutasObtenida, origenes, tipoConsumoBusqueda, retorno,enCarro);
                    rutasObtenida = null;
                }
            }else if (origenEntrada.getNombresDestinos().contains(listadoOrigenDestino.get(i))){
                rutasObtenida = new ArrayList<>();
                String aux [] = new String[3];
                aux[0] = origenEntrada.getOrigen();
                aux[1] = listadoOrigenDestino.get(i);
                aux[2] = destino;                
                rutasObtenida.add(aux);
                retorno = insertarRuta(rutasObtenida, origenes, tipoConsumoBusqueda, retorno,enCarro);
                rutasObtenida = null;
            }else if (origenEntrada.getOrigen().equals(listadoOrigenDestino.get(i))){
                rutasObtenida = new ArrayList<>();
                String aux [] = new String[2];
                aux[0] = origenEntrada.getOrigen();
                aux[1] = destino;
                rutasObtenida.add(aux);
                retorno = insertarRuta(rutasObtenida, origenes, tipoConsumoBusqueda, retorno,enCarro);
                rutasObtenida = null;
            }
        }
        return retorno;
    }
    public static origen buscarOrigen(String origen,origen origenes[]){
        for (int i = 0; i < origenes.length; i++) {
            if(origenes[i].getOrigen().equals(origen))return origenes[i];
        }
        return null;
    }
    public static destino buscarDestino(String destino,origen origenEntrada){
        if(origenEntrada!= null){
            for (int i = 0; i < origenEntrada.getDestino().length; i++) {
                if(origenEntrada.getDestino()[i].getDestino().equals(destino))return origenEntrada.getDestino()[i];
            }
        }
        return null;
    }
    public static List<String[]> rutas(String entrada,origen origenes[],origen origenEntrada,String destino){
        List <String []> retorno = new ArrayList<>();
        List <String> aux ;
        if(!entrada.equals(origenEntrada.getOrigen())){
            aux = origenesDestino(entrada, origenes, null);
        }else{            
            aux = origenesDestino(destino, origenes, null);
            aux.add(0,destino);
        }
        boolean salida = true;
        for (int i = 0; i < aux.size(); i++) {
            salida = true;
            List <String> aux2 = new ArrayList<>();
            int contador = 0;
            while (salida) {                
                if(aux2.size()==0){
                    List <String> aux3 = origenesDestino(aux.get(i), origenes, aux);
                    if(aux3.size() == 0)salida = false;
                    aux2.addAll(aux2.size(),aux3);
                    aux2.add(0, aux.get(i));
                }
                else {
                    if(aux2.get(contador).equals(origenEntrada.getOrigen())){
                        salida = false;
                        aux2.add(0, entrada);
                        String auxRetorno [] = new String[aux2.size()+1];
                        for (int j = auxRetorno.length -1; j >0 ; j--) {
                            auxRetorno[j-1] = aux2.get(auxRetorno.length-(j+1));
                        }
                        retorno.add(auxRetorno);
                    }else{
                        aux2.addAll(aux2.size(),origenesDestino(aux2.get(contador), origenes, aux2));
                        if(contador == (aux2.size()-1)){
                            salida = false;
                            aux2.add(0, entrada);
                        }
                        else contador++;
                    }
                }
            }
        }
        return retorno;
    }
    private static arbolB.estructura [] insertarRuta (List <String []> ruta,origen origenes[],int tipoConsumo,arbolB.estructura estructuraEntrada [],boolean enCarro){
        arbolB.estructura retorno [] = estructuraEntrada;
        int sumador = 0;
        for (int i = 0; i < ruta.size(); i++) {
            for (int j = 0; j < ruta.get(i).length; j++) {
                if((j+1)<ruta.get(i).length){
                    origen origenAux = buscarOrigen(ruta.get(i)[j], origenes);
                    if(enCarro)sumador+= obtenerConsumosVehiculo(origenAux, ruta.get(i)[j+1], tipoConsumo);
                    else sumador+= obtenerConsumosPersona(origenAux, ruta.get(i)[j+1], tipoConsumo);
                }
            }
            retorno = arbolB.insertar.insetarDato(sumador, retorno, false, ruta.get(i));
            sumador = 0;
        }
        return retorno;
    }
    private static double obtenerConsumosPersona(origen origen, String destino,int tipoConsumo){
        for (int i = 0; i < origen.getDestino().length; i++) {
            if(origen.getDestino()[i].getDestino().equals(destino)){
                switch(tipoConsumo){//utiliza una case para saber que tipo de consumo quiere saber el usuario
                    case 0:                        
                        return origen.getDestino()[i].getTiempo_Pie();
                    case 1:
                        return origen.getDestino()[i].getConsumo_Persona();
                    case 2:
                        return origen.getDestino()[i].getDistancia();
                }
            }
        }
        return -1;
    }
    private static double obtenerConsumosVehiculo(origen origen, String destino,int tipoConsumo){
        for (int i = 0; i < origen.getDestino().length; i++) {
            if(origen.getDestino()[i].getDestino().equals(destino)){
                switch(tipoConsumo){//utiliza una case para saber que tipo de consumo quiere saber el usuario
                    case 0:                        
                        return origen.getDestino()[i].getTiempo_Vehiculo();
                    case 1:
                        return origen.getDestino()[i].getConsumo_Gas();
                    case 2:
                        return origen.getDestino()[i].getDistancia();
                }
            }
        }
        return -1;
    }
}
