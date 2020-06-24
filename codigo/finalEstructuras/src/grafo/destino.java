package grafo;

public class destino {
    private origen origen;
    private String destino;
    private double tiempo_Vehiculo;
    private double tiempo_Pie;
    private double consumo_Gas;
    private double consumo_Persona;
    private double distancia;
    public destino(String datos [],origen origenEntrada) {
        this.origen = origenEntrada;
        this.destino = datos[1];
        this.tiempo_Vehiculo = Double.parseDouble(datos[2]);
        this.tiempo_Pie = Double.parseDouble(datos[3]);
        this.consumo_Gas = Double.parseDouble(datos[4]);
        this.consumo_Persona = Double.parseDouble(datos[5]);
        this.distancia = Double.parseDouble(datos[6]);
    }

    public double getDistancia() {
        return distancia;
    }

    public origen getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getTiempo_Vehiculo() {
        return tiempo_Vehiculo;
    }

    public double getTiempo_Pie() {
        return tiempo_Pie;
    }

    public double getConsumo_Gas() {
        return consumo_Gas;
    }

    public double getConsumo_Persona() {
        return consumo_Persona;
    }
    
    
}
