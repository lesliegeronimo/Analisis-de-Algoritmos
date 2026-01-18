public class Vertice {
    private String id; // Atributo privado que almacena el identificador del vértice

    // Constructor que inicializa el vértice con un identificador
    public Vertice(String id) {
        this.id = id;
    }

    // Método que devuelve el identificador del vértice
    public String getId() {
        return id;
    }

    // Sobrescribe el método equals para comparar dos vértices basándose en su id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Si ambos objetos son el mismo, devuelve true
        if (obj == null || getClass() != obj.getClass()) return false; // Si el objeto es nulo o de diferente clase, devuelve false
        Vertice vertice = (Vertice) obj; // Convierte el objeto a un vértice
        return id.equals(vertice.id); // Compara los id de los vértices
    }

    // Sobrescribe el método hashCode para generar un código hash basado en el id del vértice
    @Override
    public int hashCode() {
        return id.hashCode(); // Devuelve el código hash del id
    }

    // Sobrescribe el método toString para representar el vértice como su id
    @Override
    public String toString() {
        return id; // Devuelve el id del vértice como representación en cadena
    }
}