package manejadorArchivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class salidaArbol {
    public static void escribirArbol(arbolB.estructura entrada []){        
            String salida;
            int contador = 0;
            int contadorNivel = 1;
            salida = "digraph A { node [shape = record,height=.1];"+"\n";
            for (int i = 0; i < entrada.length; i++) {
                salida+="node"+(i+1)+"[label = \"";
                if(entrada[i]!=null){
                    salida+="<f0>|"+entrada[i].dato+"|<f1>";
                    if(entrada[i].hijoI!=null){
                        salida+="\"];\n";
                        salida+="\"node"+(i+1)+"\":f0 -> \"node"+(i+2)+"\":f1;\n";
                        salida+="node"+(i+2)+"[label = \"";
                        for (int j = 0; j < entrada[i].hijoI.length; j++) {
                            if(entrada[i].hijoI[j]!=null){
                                salida+=entrada[i].hijoI[j].dato+"|<f1>";
                            }else break;
                        }
                        salida+="\"];\n";
                    }
                }else break;
            }
            salida+="}";
            FileWriter archivoSalida;
        try {
            archivoSalida = new FileWriter(new File("../arbol.dot"));
            archivoSalida.write(salida);  
            archivoSalida.close();
            new graphiz.GraphvizJava("../arbol.dot", "../arbol.png");
        } catch (IOException ex) {
        }            
        
    }
    public static String codigoDot(String salida, int contadorNivel,arbolB.estructura entrada,int contador){
        if(entrada == null){
            return salida;
        }else{
            if(entrada.hijoI != null){
                salida+= codigoDot("", contadorNivel, entrada.hijoI[contador], contador+1);
                salida+= "<- Hi "+entrada.dato;
            }
            if(entrada.hijoD != null){
                contador = 0;
                salida+= " Hd -> ";
                salida+= codigoDot("", contadorNivel, entrada.hijoD[contador], contador+1);                
            }
            else {
                if(entrada.hijoD!=null){
                    for (int i = 0; i < entrada.hijoD.length; i++) {
                        if(entrada.hijoD[i]!=null)salida+= entrada.hijoD[i].dato+"  ";else break;
                    }                
                }else if(entrada.hijoI!=null){
                    for (int i = 0; i < entrada.hijoI.length; i++) {
                    if(entrada.hijoI[i]!=null)salida+= entrada.hijoI[i].dato+"  ";else break;
                }                
                }
            }            
        }
        return salida;
    }
}
