package finalestructuras;

import arbolB.estructura;

public class FinalEstructuras {

    public static void main(String[] args) {
        arbolB.estructura nuevaEstructura = new estructura();
        //int datosInsertar [] = {35,30,29,25,18};
        //int datosInsertar [] = {18,25,29,30,35};
        int datosInsertar [] =   {8,12,7,25,1};
        for (int i = 0; i < datosInsertar.length; i++) {
            arbolB.insertar.insetarDato(datosInsertar[i], nuevaEstructura);
            System.out.println("inserto "+datosInsertar[i]);
            System.out.println("los datos totales son los siguientes");
        for (int j = 0; j < nuevaEstructura.datos.length; j++) {
                System.out.print(nuevaEstructura.datos[j]);
                System.out.print("|");
        }
        }
        System.out.println("fin");
    }
    
}
