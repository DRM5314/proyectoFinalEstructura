
package arbolB;

public class insertar {
    public static void insetarDato(int valor,estructura indices){
        for (int i = 0; i < indices.espaciosMaximosPermitidos; i++) {
            //System.out.println("Analizando "+indices.datos[i]+" en posicion "+i);
            if(indices.datos[i] == -1){
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
                System.out.println("Aqui debe de subir el centro como raiz y agrega las mitades como hijos");   
        }
    }
    
}
