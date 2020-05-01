package manejadorArchivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class manejador {
    public static List<String> recuperarTexto(String path){
        List <String> retorno = new ArrayList<>();
        try {
            Scanner entrada = new Scanner(new File(path));
            while (entrada.hasNextLine()) {                
                retorno.add(entrada.nextLine());
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error en lectura de archivo");
        }
        return retorno;
    }
}
