package finalestructuras;

import arbolB.estructura;

public class FinalEstructuras {

    public static void main(String[] args) {
        arbolB.estructura nuevaEstructura[] = new estructura[5];
        //int datosInsertar [] = {35,30,29,25,18};
        //int datosInsertar [] = {18,25,29,30,35};        
        int datosInsertar [] =   {35,3,12,2,45,6,4,1,7,5,9};
        for (int i = 0; i < datosInsertar.length; i++) {
            nuevaEstructura = arbolB.insertar.insetarDato(datosInsertar[i], nuevaEstructura);
            System.out.println("inserto "+datosInsertar[i]);
            System.out.println("los datos totales son los siguientes");
        for (int j = 0; j < nuevaEstructura.length; j++) {
            if(nuevaEstructura[j] != null){
                System.out.print(nuevaEstructura[j].dato);
                System.out.print("|");
            }
        }
            System.out.println("");            
        }
        
        System.out.println("fin");
    }
    
}
