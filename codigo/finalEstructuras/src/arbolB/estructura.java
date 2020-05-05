package arbolB;


public class estructura {
    public int datos[] = {-1,-1,-1,-1,-1};
    int espaciosOcupados;
    public int indice;
    int espaciosMaximosPermitidos = 5;
    public estructura raiz;
    estructura hijoI,hijoD;

    public estructura getRaiz() {
        return raiz;
    }

    public void setRaiz(estructura raiz) {
        this.raiz = raiz;
    }

    public estructura getHijoI() {
        return hijoI;
    }

    public void setHijoI(estructura hijoI) {
        this.hijoI = hijoI;
    }

    public estructura getHijoD() {
        return hijoD;
    }

    public void setHijoD(estructura hijoD) {
        this.hijoD = hijoD;
    }
}
