/*
 * GERÓNIMO SOTO LESLIE - 320032848
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        
        // Verifica que el número de argumentos sea correcto (1 argumento para el archivo)
        if (args.length != 1) {
            System.out.println("Por favor, proporcione el archivo de entrada como argumento. Es seguido del java Main");
            return;  // Si no se pasa el archivo como argumento, termina el programa
        }

        // Obtener el nombre del archivo de entrada desde los argumentos
        String nombreArchivo = args[0];
        
        // Crear un objeto grafica para almacenar los vértices y aristas
        Grafica grafica = new Grafica(); 

        // Intentar leer el archivo de entrada
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            // Leer la primera línea que contiene los vértices
            String linea = br.readLine();

            // Si la primera línea no es nula, procesamos los vértices
            if (linea != null) {
                // Dividimos la línea por comas para obtener los vértices
                String[] vertices = linea.trim().split(",");
                
                // Añadir cada vértice a la gráfica
                for (String vertice : vertices) {
                    grafica.agregarVertice(vertice.trim());  // Agregamos cada vértice quitando espacios extra
                }
            }

            // Leer las siguientes líneas que contienen las aristas
            while ((linea = br.readLine()) != null) {
                linea = linea.trim(); // Eliminar espacios en blanco antes y después de la línea
                if (linea.isEmpty()) continue; // Ignorar líneas vacías

                // Dividir la línea en dos partes: los vértices conectados y el peso de la arista
                String[] partes = linea.split(" : ");
                if (partes.length != 2) {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    continue;  // Si el formato es incorrecto, se omite la línea
                }

                // Obtener los dos vértices conectados por la arista
                String[] verticesArista = partes[0].split(",");
                if (verticesArista.length != 2) {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    continue;  // Si no hay exactamente dos vértices, se omite la línea
                }

                // Intentar convertir el peso de la arista en un número entero
                try {
                    int peso = Integer.parseInt(partes[1].trim());  // Parsear el peso de la arista
                    // Agregar la arista a la gráfica
                    grafica.agregarArista(verticesArista[0].trim(), verticesArista[1].trim(), peso);
                } catch (NumberFormatException e) {
                    // Si no es posible convertir el peso, se muestra un mensaje de error
                    System.out.println("Peso inválido en la línea: " + linea);
                }
            }

        } catch (IOException e) {
            // En caso de error al leer el archivo, se muestra un mensaje de error
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Lógica para calcular el bosque generador de peso máximo usando el algoritmo de Kruskal
        Kruskal kruskal = new Kruskal(grafica);  // Crear una instancia de Kruskal con el grafo
        kruskal.encontrarBosqueGenerador();  // Llamar al método que ejecuta el algoritmo de Kruskal
    }
}
