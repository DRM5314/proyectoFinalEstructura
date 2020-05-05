
package arbolB;

public class insertar {
    public static estructura insetarDato(int valor,estructura indices){
        for (int i = 0; i < indices.espaciosMaximosPermitidos; i++) {
            //System.out.println("Analizando "+indices.datos[i]+" en posicion "+i);
            if(indices.datos[i] == -1 && indices.hijoD == null && indices.hijoI == null){
                indices.datos[i] = valor;
                indices.espaciosOcupados++;
                break;
            }else
            if(valor < indices.datos[i]){
                if(indices.hijoI == null){
                    int limite = indices.espaciosMaximosPermitidos - (i+1);
                    int datos [] = new int[limite];
                    int a = 0;
                    for (int j = 0; j < limite; j++) {
                        datos [a] = indices.datos[i+j];                        
                        a++;
                    }
                    a = 0;
                    for (int j = i; j < indices.espaciosMaximosPermitidos; j++) {
                        if(i==j)indices.datos[i] = valor;
                        else {
                            indices.datos[j] = datos[a];
                            a++;
                        }
                    }
                    indices.espaciosOcupados++;
                    break;
                }else {
                    System.out.println("Tiene hijo a la izquierda");
                    indices.hijoI = insetarDato(valor, indices.hijoI);
                    return indices;
                }
            }else if(valor > indices.datos[i]){
                if(indices.hijoD != null){
                    indices.hijoD = insetarDato(valor,indices.hijoD);
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
        if(indices.espaciosMaximosPermitidos == indices.espaciosOcupados){
            estructura nuevaRaiz = new estructura();
            int posicionDivision = (indices.espaciosMaximosPermitidos-1)/2;
            nuevaRaiz.hijoI = new estructura();
            nuevaRaiz.hijoD = new estructura();
            int posicionHijoD = 0;
            for (int i = 0; i < indices.espaciosMaximosPermitidos; i++) {
                if(i < posicionDivision){
                    nuevaRaiz.hijoI.datos[i] = indices.datos[i];
                    nuevaRaiz.hijoI.espaciosOcupados++;
                    nuevaRaiz.hijoI.raiz = nuevaRaiz;
                    System.out.println("inserto en hijo izquierdo "+indices.datos[i]);
                }else if(i > posicionDivision){
                    nuevaRaiz.hijoD.datos[posicionHijoD] = indices.datos[i];
                    nuevaRaiz.hijoD.espaciosOcupados++;
                    nuevaRaiz.hijoD.raiz = nuevaRaiz;
                    posicionHijoD++;
                    System.out.println("inserto en hijo derechoo "+indices.datos[i]);
                }else if(i == posicionDivision){
                    nuevaRaiz.indice = indices.datos[i];
                    nuevaRaiz.datos[0] = indices.datos[i];
                    nuevaRaiz.espaciosOcupados++;
                    System.out.println("inserto en la raiz del nuevo nodo"+indices.datos[i]);
                }
            }
            indices = nuevaRaiz;
            return indices;            
        }
        return indices;
    }
    
}
