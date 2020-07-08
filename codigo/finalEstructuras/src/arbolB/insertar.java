
package arbolB;

import java.util.ArrayList;

public class insertar {
    public static estructura [] insetarDato(double valor,estructura indices[],boolean expancion,String [] lugar){
        for (int i = 0; i < indices.length; i++) {
            //System.out.println("Analizando "+indices.datos[i]+" en posicion "+i);
            if(indices[i] == null ){
                indices[i] = new estructura();
                indices[i].dato = valor;                
                indices[i].lugar = lugar;
                indices[i].anterior = indices[0].anterior;
                break;
            }else
            if(valor < indices[i].dato){
                if(expancion || indices[i].hijoI == null){
                    int limite = 0;
                    for (int j = i; j < indices[i].espaciosMaximosPermitidos; j++) {
                        if(indices[j] == null)break;
                        else limite++;
                    }
                    System.out.println("tiene que guardar datos de "+limite);
                    double datos [] = new double[limite];
                    String lugares [] = null ;
                    int a = 0;
                    for (int j = 0; j < limite; j++) {
                        datos [a] = indices[i+j].dato;
                        lugares = indices[i+j].lugar;
                        System.out.println("guardo "+datos[a]);
                        a++;
                    }
                    a = 0;
                    int finale = i + limite;
                    for (int j = i; j <= finale; j++) {
                        if(j == i){
                            indices[j].dato = valor;
                            indices[j].lugar = lugar;
                            indices[j].anterior = indices[0].anterior;
                        }else
                        {
                         if(indices[j]==null)indices[j] = new estructura();
                         indices[j].dato = datos[a];
                         indices[j].lugar = lugares;
                         if(indices[0].padre!= null)indices[j].padre = indices[0].padre;
                         indices[j].raiz = obtenerRaiz(indices[0]);
                         indices[j].anterior = indices[0].anterior;
                         a++;
                        }
                    }
                    a=0;
                    break;
                }else {
                    System.out.println("Tiene hijo a la izquierda");
                    insetarDato(valor, indices[i].hijoI,false,lugar);
                    return indices;
                }
            }else if(valor > indices[i].dato){
                if((i+1 < 5) && indices[i+1] == null &&indices[i].hijoD != null){
                    insetarDato(valor,indices[i].hijoD,false,lugar);
                    return indices;
                }
            }        
        }
        if(indices[indices.length-1] != null){
            System.out.println("va a expandir");
            double datos [] = recuperarDatos(indices);
            String lugares [] = recuperarLugares(indices);
            estructura nuevaEstructura = new estructura();
            
            nuevaEstructura.hijoD = new estructura[5];
            nuevaEstructura.hijoI = new estructura[5];
            nuevaEstructura.dato = datos[2];
            nuevaEstructura.lugar = lugares;
            nuevaEstructura.raiz = obtenerRaiz(indices[2]);
            int nuevoContador = 0;
            if(indices[0].anterior == null || indices[0].anterior[3] != null){
                estructura nuevoAnterior [] = new estructura[5];
                nuevoAnterior [0] = nuevaEstructura;
                nuevoAnterior [0].anterior = nuevoAnterior;
                if(indices[0].anterior == null)indices = nuevoAnterior;
                else{
                    for (int i = 0; i < indices[0].anterior.length; i++) {
                        if(i<4){
                            if(nuevaEstructura.dato < indices[0].anterior[i].dato){
                                indices[0].anterior[i].hijoI = nuevoAnterior;
                                if(i>0)indices[0].anterior[i-1].hijoD = nuevoAnterior;
                                break;
                            }
                        }if (i==3){
                            indices[0].anterior[i].hijoD = nuevoAnterior;
                            break;
                        }
                    }
                }
            }else {                
                int limite2 = 0;
                int datosInsertar = 0;
                for (int i = 0; i < indices[0].anterior.length; i++) {
                    if(indices[0].anterior[i]==null){
                        indices[0].anterior[i] = nuevaEstructura;
                        indices[0].anterior[i-1].hijoD = nuevaEstructura.hijoI;
                        datosInsertar = 5;
                        break;
                    }
                    if(nuevaEstructura.dato > indices[0].anterior[i].dato){
                        datosInsertar++;
                    }else if(nuevaEstructura.dato < indices[0].anterior[i].dato)break;
                }
                limite2 = nuevaEstructura.espaciosMaximosPermitidos - datosInsertar;
                estructura aux [] = new estructura[limite2];
                for (int i = 0; i < aux.length; i++) {
                    if(indices[0].anterior[i+datosInsertar]!=null){
                        aux[i] = indices[0].anterior[i+datosInsertar];
                    }else break;
                }
                for (int i = 0; i < nuevaEstructura.espaciosMaximosPermitidos; i++) {
                    if(i == 0){
                        if(datosInsertar == 5)break;
                        indices[0].anterior[i+datosInsertar] = nuevaEstructura;
                        if(limite2 > 0)aux[i].hijoI = nuevaEstructura.hijoD;
                        if(datosInsertar ==0 && limite2>0 &&aux[i+1]!=null)aux[i+1].hijoD = nuevaEstructura.hijoI;
                        else if(datosInsertar>0 && limite2>0 && aux[i]!=null){
                            aux[i].hijoI = nuevaEstructura.hijoD;
                            if(datosInsertar>0)indices[0].anterior[datosInsertar-1].hijoD = nuevaEstructura.hijoI;
                        }
                    }
                    else{
                        if(limite2>0 && aux[i-1] == null)break;                        
                        else if (limite2>0)indices[0].anterior[i+datosInsertar] = aux[i-1];                        
                    }
                }
                nuevaEstructura.anterior = indices[0].anterior;
                indices = indices[0].anterior;
            }
            
            for (int i = 0; i < nuevaEstructura.espaciosMaximosPermitidos ;i++) {
                if(i<2){
                    nuevaEstructura.hijoI[i] = new estructura();
                    nuevaEstructura.hijoI[i].dato = datos[i];
                    nuevaEstructura.hijoI[i].lugar = lugares;
                    nuevaEstructura.hijoI[i].padre = nuevaEstructura;
                    nuevaEstructura.hijoI[i].raiz = obtenerRaiz(indices[2]);
                    nuevaEstructura.hijoI[i].anterior = nuevaEstructura.anterior;
                }else if(i!=2 && i>2){
                    nuevaEstructura.hijoD[nuevoContador] = new estructura();
                    nuevaEstructura.hijoD[nuevoContador].dato = datos[i];
                    nuevaEstructura.hijoD[nuevoContador].lugar = lugares;
                    nuevaEstructura.hijoD[nuevoContador].padre = nuevaEstructura;
                    nuevaEstructura.hijoD[nuevoContador].raiz = obtenerRaiz(indices[2]);
                    nuevaEstructura.hijoD[nuevoContador].anterior = nuevaEstructura.anterior;
                    nuevoContador++;
                }
            }
            System.out.println("su anterior es "+indices[0].anterior);           
            return indices;            
        }
        
        return indices;
    }
    private static double [] recuperarDatos (estructura entrada []){
        double retorno [] = new double[entrada.length];
        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = entrada[i].dato;
        }
        return retorno;
    }
    private static String [] recuperarLugares (estructura entrada []){
        String retorno [] = null;
        for (int i = 0; i < entrada.length; i++) {
            retorno = entrada[i].lugar;
        }
        return retorno;
    }
    private static estructura obtenerRaiz (estructura entrada){
        estructura retorno = null,aux=entrada;
        while (aux != null) {
            retorno = aux;            
            aux = aux.padre;            
        }
        if(retorno!= null)System.out.println("la raiz es "+retorno.dato);
        return retorno;
    }
    public static estructura [] borrar (estructura borrar[],String ruta[]){
        estructura aux[] = borrar;
        int contador = 0;
        while(aux[contador]!=null){
            if(aux[contador].lugar==ruta){
                aux[contador]=null;
                if(aux[contador].hijoD!=null){
                    aux = aux[contador].hijoD;
                }else if(aux[contador].hijoD==null){
                    aux[contador] = null;
                    if(aux[contador-1]!=null){
                        aux[contador] = aux[contador-1];
                    }else
                    if(aux[contador+1]!=null){
                        aux[contador] = aux[contador+1];
                    }
                }
            }
        }
        return aux;
    }
}
