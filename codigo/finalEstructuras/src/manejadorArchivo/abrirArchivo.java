/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorArchivo;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author david
 */
public class abrirArchivo {
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
    public static String fileChooserGuardar(){
        String retorno = null;
        JFileChooser jf = new JFileChooser("."); //Logger.getLogger(grafica.class.getName()).log(Level.SEVERE, null, ex);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jgo", "jgo", "jgo");
        jf.setFileFilter(filter);
        if(jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File archivo = jf.getSelectedFile(); // obtiene el archivo seleccionado            
            // muestra error si es inválido
            if ((archivo == null) || (archivo.getName().equals(""))) {
                JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
            } // fin de if
            retorno = archivo.getName();
            System.out.println("retorno"+retorno);
        }
        return retorno;
    }
}
