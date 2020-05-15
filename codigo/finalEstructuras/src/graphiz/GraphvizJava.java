package graphiz;

public class GraphvizJava{	
		
	public GraphvizJava( String direccionDot, String direccionPng ){
		dibujar( direccionDot, direccionPng );
	}
	
	public void dibujar( String direccionDot, String direccionPng ){
	           System.out.println("reibio los pahts");	
                   System.out.println(direccionDot);
                   System.out.println(direccionPng);
            try
		{       
			ProcessBuilder pbuilder;
		    
			/*
			 * Realiza la construccion del comando    
			 * en la linea de comandos esto es: 
			 * dot -Tpng -o archivo.png archivo.dot
			 */
			pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", direccionPng, direccionDot );
			pbuilder.redirectErrorStream( true );
			//Ejecuta el proceso
			pbuilder.start();
		    
		} catch (Exception e) { e.printStackTrace(); }
	}
}