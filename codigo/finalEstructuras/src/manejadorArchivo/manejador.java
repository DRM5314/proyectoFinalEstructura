package manejadorArchivo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    public static void voidGuardarArchivo(String textoEntrada){
        String pathArchivoAbsoluto = fileChooser();
        if(pathArchivoAbsoluto!= null){
            System.out.println("va a guardar en "+pathArchivoAbsoluto);
            try {
                FileWriter archivoSalida = new FileWriter(new File(pathArchivoAbsoluto));
                archivoSalida.write(textoEntrada);
                archivoSalida.close();
            } catch (IOException ex) {
            }        
        }
    }
    public static void abrirArchivo1(String archivo){
       try {
          File objetofile = new File (archivo);
          Desktop.getDesktop().open(objetofile);

       }catch (IOException ex) {
      //System.out.println(ex);
       }
    }
    public static String fileChooser(){
        String retorno = null;
        JFileChooser jf = new JFileChooser("."); //Logger.getLogger(grafica.class.getName()).log(Level.SEVERE, null, ex);;
        if(jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File archivo = jf.getSelectedFile(); // obtiene el archivo seleccionado            
            // muestra error si es inválido
            if ((archivo == null) || (archivo.getName().equals(""))) {
                JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
            } // fin de if
            retorno = archivo.getAbsolutePath();
        }
        return retorno;
    }    
}
