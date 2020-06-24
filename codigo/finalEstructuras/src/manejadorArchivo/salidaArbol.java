package manejadorArchivo;

import arbolB.estructura;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class salidaArbol {

    //digraph g {node [shape = record,height=.1];node0[label = "<H0>|<D0>9.0|<H1>|<D1>40.0"];}
    public static String estructurarDot(estructura entrada[], String salida, int nodo, int contador) {
        String termino = datosRaiz(entrada, "");
        System.out.println("gin");
        if (entrada == null || contador == 3) {
            System.out.println("Termino de imprimir un lado");
            return salida;
        }
        salida = "node" + nodo + "[label = \"";
        if (entrada[contador] != null) {
            salida += "<H" + contador + ">|<D" + contador + ">" + entrada[contador].dato;
            if ((contador + 1) < entrada.length && entrada[contador + 1] != null) {
                salida += "|";
            }
        }
        salida += "\"];\n";
        salida += estructurarDot(entrada[contador].hijoI, salida, nodo + 1, contador + 1);
        return salida;
    }

    private static String datosRaiz(estructura[] datos, String retorno) {
        estructura hijo[] = datos;
        estructura hijoAux[] = datos;
        String aux="";
        int contador = 0;
        while (hijo != null) {            
            if(contador==5){
                break;
            }
            for (int i = 0; i < hijo.length; i++) {
                if (hijo[i] != null) {
                    retorno += hijo[i].dato + "  ";
                } else {
                    break;
                }
            }
            retorno += "\n";                        
            if (datos[contador] != null) {
                retorno += "Padre " + datos[contador].dato+"\n";
                if (datos[contador].hijoI != null) {
                    hijo = datos[contador].hijoI;
                }else break;
            }else{                                
                retorno+=aux;
                aux="";
                break;
            }
            if(contador < 4){
                if(datos[contador+1]==null && datos[contador]!=null && datos[contador].hijoD!=null){
                    aux+="Padre "+datos[contador].dato+"\n";
                    String aux2 = datosRaiz(datos[contador].hijoD,"");
                    if(!aux2.equals(aux))aux+=aux2;else aux = "";
                    hijoAux = datos[contador].hijoD;
                    System.out.println("agrego hijos, el padre es "+aux);
                }
                if (hijo[0]!=null && hijo[0].hijoI!=null){
                    retorno+="Padre "+hijo[0].dato+"\n";
                    retorno+= datosRaiz(hijo,"");
                }
            }
            contador++;
        }
        System.out.println("termino ");
        return retorno;
    }

}
