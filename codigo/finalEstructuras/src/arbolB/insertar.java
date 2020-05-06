
package arbolB;

public class insertar {
    public static estructura [] insetarDato(int valor,estructura indices[]){
        for (int i = 0; i < indices.length; i++) {
            //System.out.println("Analizando "+indices.datos[i]+" en posicion "+i);
            if(indices[i] == null ){
                indices[i] = new estructura();
                indices[i].dato = valor;
                indices[i].espaciosOcuapados++;
                break;
            }else
            if(valor < indices[i].dato){
                if(indices[i].hijoI == null){
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
                         a++;
                        }
                    }
                    break;
                }else {
                    System.out.println("Tiene hijo a la izquierda");
                    indices[i].hijoI = insetarDato(valor, indices[i].hijoI);
                    return indices;
                }
            }else if(valor > indices[i].dato){
                if(indices[i].hijoD != null){
                    indices[i].hijoD = insetarDato(valor,indices[i].hijoD);
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
            System.out.println("excedio el limite va a expandir");
            estructura nuevaRaiz [] = new estructura[5];
            nuevaRaiz[0] = new estructura();
            int posicionDivision = (indices[indices.length-1].espaciosMaximosPermitidos-1)/2;
            nuevaRaiz[0].hijoI = new estructura[5];
            nuevaRaiz[0].hijoD = new estructura[5];
            int posicionHijoD = 0;
            for (int j = 0; j < indices.length; j++) {
                if(j < posicionDivision){
                    nuevaRaiz[0].hijoI[j] = new estructura();
                    nuevaRaiz[0].hijoI[j].dato = indices[j].dato;
                    nuevaRaiz[0].hijoI[j].espaciosOcuapados++;
                    nuevaRaiz[0].hijoI[j].padre = nuevaRaiz[0];
                    nuevaRaiz[0].hijoI[j].raiz = obtenerRaiz(indices[2]);
                    System.out.println("inserto en hijo izquierdo "+indices[j].dato);
                }else if(j > posicionDivision){
                    nuevaRaiz[0].hijoD[posicionHijoD] = new estructura();
                    nuevaRaiz[0].hijoD[posicionHijoD].dato = indices[j].dato;
                    nuevaRaiz[0].hijoD[posicionHijoD].espaciosOcuapados++;
                    nuevaRaiz[0].hijoD[posicionHijoD].padre = nuevaRaiz[0];
                    nuevaRaiz[0].hijoD[posicionHijoD].raiz = obtenerRaiz(indices[2]);
                    posicionHijoD++;
                    System.out.println("inserto en hijo derechoo "+indices[j].dato);
                }else if(j == posicionDivision){
                    nuevaRaiz[0].dato = indices[j].dato;
                    nuevaRaiz[0].espaciosOcuapados++;
                    nuevaRaiz[0].padre = indices[j].padre;
                    nuevaRaiz[0].raiz = obtenerRaiz(nuevaRaiz[0]);
                    System.out.println("inserto en el padre del nuevo nodo"+indices[j].dato);
                }
            }
            indices = nuevaRaiz;
            return indices;            
        }
        
        return indices;
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
