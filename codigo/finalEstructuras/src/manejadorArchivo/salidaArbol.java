package manejadorArchivo;

import arbolB.estructura;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class salidaArbol {

    //digraph g {node [shape = record,height=.1];node0[label = "<H0>|<D0>9.0|<H1>|<D1>40.0"];}    
    public static void estructurarDot(estructura entrada[]) {
        String termino = datosRaiz(entrada, "raiz \n", new ArrayList<>());
        String auxNodoEscritura = "";
        String separadorLineas[] = termino.split("\n");
        String salidaArchivo = "";
        if (separadorLineas.length > 0) {
            salidaArchivo += "digraph g { \nnode [shape = record,height=.1];";
            for (int i = 0; i < separadorLineas.length; i++) {
                String separadorEpacios[] = separadorLineas[i].split(" ");
                if (i % 2 == 0) {
                    salidaArchivo += "\n";
                    auxNodoEscritura += "node" + (i / 2) + " [label =\"";
                }
                for (int j = 0; j < separadorEpacios.length; j++) {
                    if (separadorEpacios[j].equals("raiz")) {
                        String datosRaiz[] = separadorLineas[i + 1].split(" ");
                        for (int k = 0; k < datosRaiz.length; k++) {                            
                            if (!datosRaiz[k].equals("InicioNietos")) {
                                if(k==0)salidaArchivo += auxNodoEscritura;
                                if (k > 0) {
                                    salidaArchivo += "|";
                                }
                                salidaArchivo += "<f" + k + "> |" + datosRaiz[k];
                                if (k + 1 == datosRaiz.length) {
                                    salidaArchivo += "|<f" + datosRaiz.length + ">\"];";
                                }
                            }else break;
                        }
                        System.out.println("imprimio raiz");
                        salidaArchivo += "\n";
                    } else if (separadorEpacios[j].equals("Padre")) {                        
                        String datosRaiz[] = separadorLineas[i + 1].split(" ");
                        for (int k = 0; k < datosRaiz.length; k++) {
                            if (!datosRaiz[k].equals("InicioNietos")) {
                                if(k==0)salidaArchivo += auxNodoEscritura;
                                if (k > 0) {
                                    salidaArchivo += "|";
                                }
                                salidaArchivo += "<f" + k + "> |" + datosRaiz[k];
                                if (k + 1 == datosRaiz.length) {
                                    salidaArchivo += "|<f" + datosRaiz.length + ">\"];";
                                }
                            }else break;
                        }
                        System.out.println("imprimio hijos");
                    } else if (separadorEpacios[j].equals("InicioNietos")) {                        
                        String datosRaiz[] = separadorLineas[i].split(" ");
                        salidaArchivo += "node" + (i / 2) + " [label =\"";
                        for (int k = 1; k < datosRaiz.length; k++) {
                            if (k > 0) {
                                salidaArchivo += "|";
                            }
                            salidaArchivo += "<f" + k + "> |" + datosRaiz[k];
                            if (k + 1 == datosRaiz.length) {
                                salidaArchivo += "|<f" + datosRaiz.length + ">\"];";
                            }
                        }
                        i++;
                        for (int k = i; k < separadorLineas.length; k++) {
                            String datosRaiz1[] = separadorLineas[k+1].split(" ");                            
                            if(datosRaiz1.length>0 && datosRaiz1[0].equals("FinNietos")){
                                k++;
                                i=k;
                                break;
                            }
                            salidaArchivo += "node" + (k / 2) + " [label =\"";
                            for (int L = 0; L < datosRaiz1.length; L++) {
                                if (L > 0) {
                                    salidaArchivo += "|";
                                }
                                salidaArchivo += "<f" + L + "> |" + datosRaiz1[L];
                                if (L + 1 == datosRaiz1.length) {
                                    salidaArchivo += "|<f" + datosRaiz1.length + ">\"];";
                                }
                            }
                            
                        }
                        break;
                    }
                }
                auxNodoEscritura = "";
            }
            int numeroDatosSinRaiz = separadorLineas.length - 2;
            if (numeroDatosSinRaiz / 2 > 0) {
                int aux = 0;
                for (int i = 0; i < separadorLineas.length; i++) {
                    String separadorEspacios[] = separadorLineas[i].split(" ");
                    for (int j = 0; j < separadorEspacios.length; j++) {
                        if (separadorEspacios[j].equals("raiz")) {
                            String auxDatos[] = separadorLineas[i + 1].split(" ");
                            for (int k = 0; k < auxDatos.length + 1; k++) {
                                aux = 2 * k + 3;
                                String ubicacionCentro[] = separadorLineas[aux].split(" ");
                                salidaArchivo += "\"node0\":f" + k + " -> \"node" + (k + 1) + "\":f" + (ubicacionCentro.length / 2) + ";";
                                salidaArchivo += "\n";
                            }
                        }
                    }
                }
            }
            salidaArchivo += "}";
            FileWriter archivoSalida;
            try {
                archivoSalida = new FileWriter(new File("../arbol.dot"));
                archivoSalida.write(salidaArchivo);
                archivoSalida.close();
                archivoSalida = new FileWriter(new File("../arbol.png"));
                archivoSalida.write("");
                archivoSalida.close();
            } catch (IOException ex) {
                Logger.getLogger(salidaMapa.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private static void imprimirArbol(String datos) {
        String[] separadorLineas = datos.split("\n");
        for (int i = 0; i < separadorLineas.length; i++) {
            String[] separadorEspacios = separadorLineas[i].split(" ");

        }
    }

    private static String datosRaiz(estructura[] datos, String retorno, ArrayList<Double[]> datosSalida) {
        estructura hijo[] = datos;
        estructura hijoAux[] = datos;
        String aux = "";
        int contador = 0;
        Double[] auxInsertar = new Double[2];
        while (hijo != null) {
            if (contador == 5) {
                break;
            }
            for (int i = 0; i < hijo.length; i++) {
                if (hijo[i] != null) {
                    retorno += hijo[i].dato + " ";
                    auxInsertar[0] = new Double(1);
                    auxInsertar[1] = hijo[i].dato;
                    datosSalida.add(auxInsertar);
                } else {
                    break;
                }
            }
            retorno += "\n";
            if (datos[contador] != null) {
                if (datos[contador].hijoD != null || datos[contador].hijoI != null) {
                    retorno += "Padre " + datos[contador].dato + "\n";
                    auxInsertar[0] = new Double(0);
                    auxInsertar[1] = datos[contador].dato;
                    datosSalida.add(auxInsertar);
                }
                if (datos[contador].hijoI != null) {
                    hijo = datos[contador].hijoI;
                } else {
                    break;
                }
            } else {
                retorno += aux;
                aux = "";
                break;
            }
            if (contador < 4) {
                if (datos[contador + 1] == null && datos[contador] != null && datos[contador].hijoD != null) {
                    aux += "Padre " + datos[contador].dato + "\n";
                    auxInsertar[0] = new Double(0);
                    auxInsertar[1] = datos[contador].dato;
                    datosSalida.add(auxInsertar);
                    String aux2 = datosRaiz(datos[contador].hijoD, "", datosSalida);
                    if (!aux2.equals(aux)) {
                        aux += aux2;
                    } else {
                        aux = "";
                    }
                    hijoAux = datos[contador].hijoD;
                    System.out.println("agrego hijos, el padre es " + aux);
                }
                if (hijo[0] != null && hijo[0].hijoI != null) {
                    retorno += "InicioNietos ";
                    auxInsertar[0] = new Double(0);
                    auxInsertar[1] = hijo[0].dato;
                    datosSalida.add(auxInsertar);
                    retorno += datosRaiz(hijo, "", datosSalida);
                    retorno += "FinNietos ";
                }
            }
            contador++;
        }
        System.out.println("termino ");
        return retorno;
    }

}
