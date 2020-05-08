
package arbolB;

public class insertar {
    public static estructura [] insetarDato(int valor,estructura indices[],boolean expancion){
        for (int i = 0; i < indices.length; i++) {
            //System.out.println("Analizando "+indices.datos[i]+" en posicion "+i);
            if(indices[i] == null ){
                indices[i] = new estructura();
                indices[i].dato = valor;                
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
                    int datos [] = new int[limite];
                    int a = 0;
                    for (int j = 0; j < limite; j++) {
                        datos [a] = indices[i+j].dato;
                        System.out.println("guardo "+datos[a]);
                        a++;
                    }
                    a = 0;
                    int finale = i + limite;
                    for (int j = i; j <= finale; j++) {
                        if(j == i){
                            indices[j].dato = valor;
                        }else
                        {
                         if(indices[j]==null)indices[j] = new estructura();
                         indices[j].dato = datos[a];
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
                    indices[i].hijoI = insetarDato(valor, indices[i].hijoI,false);
                    return indices;
                }
            }else if(valor > indices[i].dato){
                if(indices[i].hijoD != null){
                    indices[i].hijoD = insetarDato(valor,indices[i].hijoD,false);
                    return indices;
                }
            }
//            if(valor > indices.datos[i]){
//                if(indices.hijoD == null){
//                    for (int j = i; j < indices.espaciosMaximosPermitidos; j++) {
//                        if(indices.datos[j] == -1)indices.datos[j] = valor;
//                        else if(valor < indices.datos[j]){
//                            int limite = indices.espaciosMaximosPermitidos - (1+j);
//                            int datos [] = new int[limite];
//                            int a =0;
//                            for (int k = j; k < limite; k++) {
//                                datos[a] = indices.datos[k];
//                                a++;
//                            }
//                            a = 0;
//                            for (int k = j; k < indices.espaciosMaximosPermitidos; k++) {
//                                if(k == j)indices.datos[k] = valor;
//                                else{
//                                    indices.datos[k] = datos[a];
//                                    a++;
//                                }
//                            }
//                        }
//                    }
//                }
//                indices.espaciosOcupados++;
//                return;
//            }
        
        }
        if(indices[indices.length-1] != null){
            System.out.println("va a expandir");
            int datos [] = recuperarDatos(indices);
            estructura nuevaEstructura = new estructura();
            
            nuevaEstructura.hijoD = new estructura[5];
            nuevaEstructura.hijoI = new estructura[5];
            nuevaEstructura.dato = datos[2];
            nuevaEstructura.raiz = obtenerRaiz(indices[2]);
            int nuevoContador = 0;
            if(indices[0].anterior == null){
                estructura nuevoAnterior [] = new estructura[5];
                nuevoAnterior [0] = nuevaEstructura;
                nuevoAnterior [0].anterior = nuevoAnterior;
                indices = nuevoAnterior;
            }else {
                System.out.println("el anterior no es nulo");                
                insertar.insetarDato(datos[2], indices[0].anterior,true);
            }
            for (int i = 0; i < indices.length; i++) {
                if(i<2){
                    nuevaEstructura.hijoI[i] = new estructura();
                    nuevaEstructura.hijoI[i].dato = datos[i];
                    nuevaEstructura.hijoI[i].padre = nuevaEstructura;
                    nuevaEstructura.hijoI[i].raiz = obtenerRaiz(indices[2]);
                    nuevaEstructura.hijoI[i].anterior = nuevaEstructura.anterior;
                }else if(i!=2 && i>2){
                    nuevaEstructura.hijoD[nuevoContador] = new estructura();
                    nuevaEstructura.hijoD[nuevoContador].dato = datos[i];
                    nuevaEstructura.hijoD[nuevoContador].padre = nuevaEstructura;
                    nuevaEstructura.hijoD[nuevoContador].raiz = obtenerRaiz(indices[2]);
                    nuevoContador++;
                }
            }
            System.out.println("su anterior es "+indices[0].anterior);
            
            return indices;            
        }
        
        return indices;
    }
    private static int [] recuperarDatos (estructura entrada []){
        int retorno [] = new int[entrada.length];
        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = entrada[i].dato;
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
}
