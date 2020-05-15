package grafo;

public class origen {
    private String origen;
    private destino [] destino;

    public origen(String origen, destino[] destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public destino[] getDestino() {
        return destino;
    }
    
           
}
