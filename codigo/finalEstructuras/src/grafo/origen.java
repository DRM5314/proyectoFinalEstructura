package grafo;

import java.util.ArrayList;
import java.util.List;

public class origen {
    private String origen;
    private destino [] destino;
    private List <String> nombresDestinos;
    public origen(String origen, destino[] destino) {
        this.origen = origen;
        this.destino = destino;
        this.nombresDestinos = new ArrayList<>();
    }
    public void agregarNombreDestino (String nombre){
        this.nombresDestinos.add(nombre);
    }
    public List <String> getNombresDestinos(){
        return nombresDestinos;
    }
    public String getOrigen() {
        return origen;
    }

    public destino[] getDestino() {
        return destino;
    }
    
           
}
