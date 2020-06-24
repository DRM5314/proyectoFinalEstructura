package graphiz;

public class GraphvizJava {  
    public static void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;
            /*
             * Realiza la construccion del comando    
             * en la linea de comandos esto es: 
             * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();
            System.out.println("ejecuto comando para grapvhiz para crear la imagen png desde el .dot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
