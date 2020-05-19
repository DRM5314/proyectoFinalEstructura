package manejadorArchivo;

import grafo.origen;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class salidaMapa {
    public static void escribirMapa(origen entrada [],boolean persona){        
            String salida;
            salida = "digraph A {"+"\n"+"rankdir=LR;\n";
            for (int i = 0; i < entrada.length; i++) {                
                for (int j = 0; j < entrada[i].getDestino().length; j++) {
                    salida+=entrada[i].getOrigen()+" -> ";
                    salida +=entrada[i].getDestino()[j].getDestino()+" ";
                    salida += " [label= \"";
                    if(persona){
                        salida+=" CP: "+entrada[i].getDestino()[j].getConsumo_Persona()+
                            " TP: "+entrada[i].getDestino()[j].getTiempo_Pie();
                    }else{
                        salida += "CG: "+entrada[i].getDestino()[j].getConsumo_Gas()+
                                " TC: "+entrada[i].getDestino()[j].getTiempo_Vehiculo();
                    }
                    salida +="\",weight=50];\n";
                    //if((j+1)<entrada[i].getDestino().length)salida+=",";
                }
            }
            salida+="}";
            FileWriter archivoSalida;
        try {
            archivoSalida = new FileWriter(new File("../mapa.dot"));
            archivoSalida.write(salida);  
            archivoSalida.close();
            new graphiz.GraphvizJava("../mapa.dot", "../mapa.png");
        } catch (IOException ex) {
            Logger.getLogger(salidaMapa.class.getName()).log(Level.SEVERE, null, ex);
        }            
        
    }
}
