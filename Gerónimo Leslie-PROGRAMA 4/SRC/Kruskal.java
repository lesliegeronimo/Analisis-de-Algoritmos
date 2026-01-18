import java.util.*;

public class Kruskal {
    private Grafica grafica; 
    private Map<Vertice, Vertice> padres; 

    // Constructor que inicializa la gráfica y el mapa de padres.
    public Kruskal(Grafica grafica) {
        this.grafica = grafica;
        this.padres = new HashMap<>();
    }

    // Método para inicializar los conjuntos disjuntos. Cada vértice es su propio padre al inicio.
    public void inicializar() {
        for (Vertice vertice : grafica.obtenerVertices()) {
            padres.put(vertice, vertice);
        }
    }

    // Método para encontrar el representante (raíz) de un conjunto usando compresión de caminos.
    public Vertice encontrar(Vertice v) {
        if (padres.get(v) != v) {
            padres.put(v, encontrar(padres.get(v))); // Actualiza el padre del vértice para optimizar futuras búsquedas.
        }
        return padres.get(v);
    }

    // Método para unir dos conjuntos, conectando sus representantes.
    public void unir(Vertice v1, Vertice v2) {
        Vertice raiz1 = encontrar(v1); // Encuentra el representante del primer vértice.
        Vertice raiz2 = encontrar(v2); // Encuentra el representante del segundo vértice.

        if (raiz1 != raiz2) {
            padres.put(raiz1, raiz2); // Une los conjuntos asignando un mismo representante.
        }
    }

    // Método para encontrar el bosque generador de peso máximo utilizando el algoritmo de Kruskal.
    public void encontrarBosqueGenerador() {
        inicializar(); // Inicializa los conjuntos disjuntos.
    
        // Obtiene las aristas de la gráfica y las ordena por peso (de mayor a menor).
        List<Arista> aristas = grafica.obtenerAristas();
        Collections.sort(aristas); // Se asume que la clase Arista implementa `Comparable` para ordenar.
    
        List<List<Arista>> bosque = new ArrayList<>(); // Lista de listas para almacenar los árboles del bosque.
    
        // Itera sobre cada arista para construir el bosque generador.
        for (Arista arista : aristas) {
            Vertice v1 = arista.getOrigen(); // Vértice de origen de la arista.
            Vertice v2 = arista.getDestino(); // Vértice de destino de la arista.
    
            // Verifica si los vértices están en conjuntos diferentes.
            if (encontrar(v1) != encontrar(v2)) {
                unir(v1, v2); // Une los conjuntos de los vértices.
    
                boolean agregado = false;
                // Busca un árbol en el bosque al que se pueda agregar la arista.
                for (List<Arista> arbol : bosque) {
                    if (!arbol.isEmpty() && 
                        (arbol.get(0).getOrigen().equals(v1) || arbol.get(0).getOrigen().equals(v2))) {
                        arbol.add(arista); // Agrega la arista al árbol correspondiente.
                        agregado = true;
                        break;
                    }
                }
    
                // Si no se encontró un árbol existente, crea un nuevo árbol.
                if (!agregado) {
                    List<Arista> nuevoArbol = new ArrayList<>();
                    nuevoArbol.add(arista);
                    bosque.add(nuevoArbol);
                }
            }
        }
    
        // Imprime el número de árboles en el bosque y las aristas de cada árbol.
        System.out.println("Número de árboles en el bosque: " + bosque.size());
        int i = 1;
        for (List<Arista> arbol : bosque) {
            System.out.println("\u001B[35mÁrbol " + i++ + ":\u001B[0m"); 
            for (Arista arista : arbol) {
                // Imprime las aristas en el formato origen,destino:peso.
                System.out.println(arista.getOrigen() + "," + arista.getDestino() + ":" + arista.getPeso());
            }
        }
    }
}
