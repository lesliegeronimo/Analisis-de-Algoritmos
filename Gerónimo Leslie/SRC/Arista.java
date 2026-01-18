public class Arista {
    private Vertice origen; // Atributo privado que almacena el vértice de origen de la arista
    private Vertice destino; // Atributo privado que almacena el vértice de destino de la arista
    private int peso; // Atributo privado que almacena el peso de la arista

    // Constructor que inicializa la arista con los vértices de origen, destino y el peso
    public Arista(Vertice origen, Vertice destino, int peso) {
        this.origen = origen; // Asigna el vértice de origen
        this.destino = destino; // Asigna el vértice de destino
        this.peso = peso; // Asigna el peso de la arista
    }

    // Método que devuelve el vértice de origen de la arista
    public Vertice getOrigen() {
        return origen;
    }

    // Método que devuelve el vértice de destino de la arista
    public Vertice getDestino() {
        return destino;
    }

    // Método que devuelve el peso de la arista
    public int getPeso() {
        return peso;
    }

    // Sobrescribe el método toString para representar la arista como una cadena
    @Override
    public String toString() {
        return origen + " -> " + destino + " : " + peso; // Representa la arista en formato "origen -> destino : peso"
    }
}
