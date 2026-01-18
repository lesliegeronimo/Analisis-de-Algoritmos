// GERÓNIMO SOTO LESLIE - 320032848
class Arista {
    Vertice origen;
    Vertice destino;

    public Arista(Vertice origen, Vertice destino) {
        this.origen = origen;
        this.destino = destino;
    }

    @Override
    public String toString() {
        return origen + " -> " + destino;
    }
}
