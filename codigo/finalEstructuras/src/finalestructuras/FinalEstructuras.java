package finalestructuras;

import arbolB.estructura;

public class FinalEstructuras {

    public static void main(String[] args) {
        arbolB.estructura nuevaEstructura = new estructura();
        //int datosInsertar [] = {35,30,29,25,18};
        //int datosInsertar [] = {18,25,29,30,35};        
        int datosInsertar [] =   {8,12,7,25,6,3,2,5};
        for (int i = 0; i < datosInsertar.length; i++) {
            nuevaEstructura = arbolB.insertar.insetarDato(datosInsertar[i], nuevaEstructura);
            System.out.println("inserto "+datosInsertar[i]);
            System.out.println("los datos totales son los siguientes");
        for (int j = 0; j < nuevaEstructura.datos.length; j++) {
                System.out.print(nuevaEstructura.datos[j]);
                System.out.print("|");
        }
            System.out.println("");
            if(nuevaEstructura.getHijoI()!=null)System.out.println("hijo izquierdo es "+nuevaEstructura.getHijoI().datos[0]);
            if(nuevaEstructura.getHijoD()!=null)System.out.println("hijo derecho es "+nuevaEstructura.getHijoD().datos[0]);
            System.out.println("la raiz es "+nuevaEstructura.indice);
        }
        
        System.out.println("fin");
    }
    
}
