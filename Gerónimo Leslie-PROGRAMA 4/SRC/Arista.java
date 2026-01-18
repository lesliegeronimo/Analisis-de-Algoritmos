public class Arista implements Comparable<Arista> {
    Vertice origen, destino;
    int peso;

    public Arista(Vertice origen, Vertice destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public int compareTo(Arista o) {
        return Integer.compare(o.peso, this.peso);  // Para peso máximo, se invierte el orden
    }

    @Override
    public String toString() {
        return origen + "," + destino + " : " + peso;
    }
}
