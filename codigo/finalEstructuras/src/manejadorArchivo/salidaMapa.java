package manejadorArchivo;

import grafo.origen;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class salidaMapa {

    public static void escribirMapaCompleto(origen entrada[]) {
        String salida;
        salida = "digraph A {" + "\n" + "rankdir=LR;\n";
        for (int i = 0; i < entrada.length; i++) {
            for (int j = 0; j < entrada[i].getDestino().length; j++) {
                salida += entrada[i].getOrigen() + " -> ";
                salida += entrada[i].getDestino()[j].getDestino() + " ";
                salida += " [label= \"";
                salida += " CP: " + entrada[i].getDestino()[j].getConsumo_Persona()
                        + " \tTP: " + entrada[i].getDestino()[j].getTiempo_Pie() + "\n";
                salida += "CV: " + entrada[i].getDestino()[j].getConsumo_Gas()
                        + " \tTV: " + entrada[i].getDestino()[j].getTiempo_Vehiculo();
                salida += "\n   Distancia = " + entrada[i].getDestino()[j].getDistancia();
                salida += "\",weight=50];\n";
                //if((j+1)<entrada[i].getDestino().length)salida+=",";
            }
        }
        salida += "}";
        FileWriter archivoSalida;
        try {
            archivoSalida = new FileWriter(new File("../mapa.dot"));
            archivoSalida.write(salida);
            archivoSalida.close();
            archivoSalida = new FileWriter(new File("../mapa.png"));
            archivoSalida.write("");
            archivoSalida.close();
        } catch (IOException ex) {
            Logger.getLogger(salidaMapa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void escribirMapa_Mejor_Peor_Ruta(ArrayList<String> ruta, int posicionesFinalesRutas[], String tipo) {
        String salida;
        salida = "digraph A {" + "\n" + "rankdir=LR;\n";
        String tiposRutas[] = {"Tiempo", "Desgaste", "Distancia"};
        int contadorPosicionesFinales = 0;
        for (int i = 0; i < ruta.size(); i++) {            
            if (i != posicionesFinalesRutas[contadorPosicionesFinales]) {
                salida += ruta.get(i);
                salida += "->";
            } else {
                salida += tiposRutas[contadorPosicionesFinales] +"_"+ ruta.get(i);
                contadorPosicionesFinales++;
                salida += ";";
            }            
        }
        salida+="}";
        FileWriter archivoSalida;
        try {
            archivoSalida = new FileWriter(new File("../mapa" + tipo + ".dot"));
            archivoSalida.write(salida);
            archivoSalida.close();
            archivoSalida = new FileWriter(new File("../mapa" + tipo + ".png"));
            archivoSalida.write("");
            archivoSalida.close();
        } catch (IOException ex) {
            Logger.getLogger(salidaMapa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
