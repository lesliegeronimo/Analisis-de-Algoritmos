import java.util.*;

public class Grafica {
    private Map<String, Vertice> vertices;
    private List<Arista> aristas;

    public Grafica() {
        this.vertices = new HashMap<>();
        this.aristas = new ArrayList<>();
    }

    public void agregarVertice(String nombre) {
        if (!vertices.containsKey(nombre)) {
            vertices.put(nombre, new Vertice(nombre));
        }
    }

    public void agregarArista(String v1, String v2, int peso) {
        Vertice origen = vertices.get(v1);
        Vertice destino = vertices.get(v2);
        aristas.add(new Arista(origen, destino, peso));
    }

    public List<Arista> obtenerAristas() {
        return aristas;
    }

    public Collection<Vertice> obtenerVertices() {
        return vertices.values();
    }
}
