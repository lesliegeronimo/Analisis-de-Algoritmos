import java.util.*;

public class Grafica {
    private Map<Vertice, List<Arista>> adjList; // Mapa que almacena las listas de aristas asociadas a cada vértice

    // Constructor que inicializa la gráfica con un mapa vacío de listas de aristas
    public Grafica() {
        this.adjList = new HashMap<>();
    }

    // Método para agregar un vértice a la gráfica si no existe previamente
    public void agregarVertice(String id) {
        adjList.putIfAbsent(new Vertice(id), new ArrayList<>()); // Si no existe el vértice, lo agrega con una lista vacía de aristas
    }

    // Método para agregar una arista entre dos vértices con un peso especificado
    public void agregarArista(String origen, String destino, int peso) {
        Vertice verticeOrigen = new Vertice(origen); // Crea el vértice de origen
        Vertice verticeDestino = new Vertice(destino); // Crea el vértice de destino

        // Si los vértices no existen, los agrega con listas vacías de aristas
        adjList.putIfAbsent(verticeOrigen, new ArrayList<>());
        adjList.putIfAbsent(verticeDestino, new ArrayList<>());

        // Agrega la arista al vértice de origen
        adjList.get(verticeOrigen).add(new Arista(verticeOrigen, verticeDestino, peso));
    }

    // Método que devuelve una lista de las aristas que salen de un vértice específico
    public List<Arista> obtenerAristas(Vertice vertice) {
        return adjList.getOrDefault(vertice, new ArrayList<>()); // Devuelve la lista de aristas o una lista vacía si el vértice no tiene aristas
    }

    // Método que devuelve un conjunto con todos los vértices de la gráfica
    public Set<Vertice> obtenerVertices() {
        return adjList.keySet(); // Devuelve el conjunto de vértices (las claves del mapa)
    }

    // Sobrescribe el método toString para representar la gráfica como una cadena
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Usamos StringBuilder para construir la cadena de manera eficiente
        // Recorre cada entrada del mapa y agrega la representación de cada vértice y sus aristas
        for (Map.Entry<Vertice, List<Arista>> entry : adjList.entrySet()) {
            sb.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        return sb.toString(); // Devuelve la representación completa de la gráfica
    }
}
