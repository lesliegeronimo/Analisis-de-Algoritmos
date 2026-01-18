import java.io.*;
import java.util.*;

class Grafica {
    List<Vertice> vertices;
    List<Arista> aristas;

    public Grafica() {
        vertices = new ArrayList<>();
        aristas = new ArrayList<>();
    }

    public void agregarVertice(String nombre) {
        Vertice v = buscarVertice(nombre);
        if (v == null) {
            vertices.add(new Vertice(nombre));
        }
    }

    public void agregarArista(String origen, String destino) {
        Vertice vOrigen = buscarVertice(origen);
        Vertice vDestino = buscarVertice(destino);
        if (vOrigen != null && vDestino != null) {
            aristas.add(new Arista(vOrigen, vDestino));
        }
    }

    private Vertice buscarVertice(String nombre) {
        for (Vertice v : vertices) {
            if (v.nombre.equals(nombre)) {
                return v;
            }
        }
        return null;
    }

    // Encuentra el conjunto independiente
    public Set<Vertice> encontrarConjuntoIndependiente() {
        Set<Vertice> conjuntoIndependiente = new HashSet<>();
        Set<Vertice> cubiertos = new HashSet<>();

        for (Vertice v : vertices) {
            if (!cubiertos.contains(v)) {
                conjuntoIndependiente.add(v);  // Añadimos el vértice al conjunto independiente
                cubiertos.add(v);  // Marcamos el vértice como cubierto
                // Excluir todos los vértices adyacentes al actual (distancia 1)
                for (Arista a : aristas) {
                    if (a.origen.equals(v)) {
                        cubiertos.add(a.destino);  // Excluir vértices directamente conectados
                    }
                    // Excluir vértices a distancia 2 (vértices conectados a los adyacentes)
                    if (cubiertos.contains(a.origen)) {
                        for (Arista a2 : aristas) {
                            if (a2.origen.equals(a.destino)) {
                                cubiertos.add(a2.destino);  // Excluir vértices a distancia 2
                            }
                        }
                    }
                }
            }
        }
        return conjuntoIndependiente;
    }

    // Cargar la gráfica desde el archivo
    public void cargarDesdeArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            // Leer la primera línea que contiene los vértices
            linea = br.readLine();
            if (linea != null && !linea.trim().isEmpty()) {
                String[] vertices = linea.split(",");
                for (String vertice : vertices) {
                    agregarVertice(vertice.trim());  // Agregar vértices eliminando espacios
                }
            }

            // Leer las líneas que contienen las aristas
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;  // Ignorar líneas vacías
                }

                String[] arista = linea.split(",");
                if (arista.length == 2) {
                    agregarArista(arista[0].trim(), arista[1].trim());  // Agregar arista eliminando espacios
                } else {
                    System.out.println("Línea mal formateada o incompleta: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Mostrar el conjunto independiente encontrado
    public void mostrarConjuntoIndependiente() {
        Set<Vertice> conjuntoIndependiente = encontrarConjuntoIndependiente();
        System.out.print("Conjunto independiente: ");
        for (Vertice v : conjuntoIndependiente) {
            System.out.print(v.nombre + " ");
        }
        System.out.println();
    }
}

