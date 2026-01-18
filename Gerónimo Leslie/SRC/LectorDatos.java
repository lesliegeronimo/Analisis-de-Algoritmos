import java.io.*;
import java.util.*;

public class LectorDatos {
    // Método que lee una gráfica desde un archivo para el problema de Trayectoria
    public static Grafica leerGraficaDesdeArchivo(String rutaArchivo) throws IOException {
        Grafica grafica = new Grafica(); // Crea una nueva instancia de Grafica
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) { // Lee el archivo línea por línea
            String linea = br.readLine(); // Lee la primera línea del archivo
            if (linea != null) {
                // Leer los vértices desde la primera línea del archivo
                String[] vertices = linea.split(","); // Los vértices están separados por comas
                for (String vertice : vertices) {
                    grafica.agregarVertice(vertice.trim()); // Agrega cada vértice a la gráfica
                }
            }
            // Leer las aristas desde las siguientes líneas
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":"); // Divide la línea en dos partes: los vértices y el peso
                String[] verticesArista = partes[0].split(","); // Divide la primera parte (vértices) por coma
                int peso = Integer.parseInt(partes[1].trim()); // Convierte el peso de la arista a un número entero
                // Agrega la arista a la gráfica
                grafica.agregarArista(verticesArista[0].trim(), verticesArista[1].trim(), peso);
            }
        }
        return grafica; // Devuelve la gráfica con los vértices y aristas leídos
    }

    // Método que lee un conjunto de enteros desde un archivo para el problema de Partición
    public static List<Integer> leerConjuntoDesdeArchivo(String rutaArchivo) throws IOException {
        List<Integer> conjunto = new ArrayList<>(); // Crea una lista para almacenar los enteros
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) { // Lee el archivo línea por línea
            String linea = br.readLine(); // Lee la primera línea del archivo
            if (linea != null) {
                // Leer los elementos del conjunto desde la línea
                String[] elementos = linea.split(","); // Los elementos están separados por comas
                for (String elemento : elementos) {
                    conjunto.add(Integer.parseInt(elemento.trim())); // Convierte cada elemento a entero y lo agrega al conjunto
                }
            }
        }
        return conjunto; // Devuelve la lista con los elementos del conjunto
    }
}
