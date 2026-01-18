import java.util.*;

public class TrayectoriaNoDeterminista {
    // Método que resuelve el problema de encontrar una trayectoria con un peso mínimo
    public static boolean resolverTrayectoria(Grafica grafica, String inicio, String fin, int pesoMinimo) {
        Vertice s = new Vertice(inicio); // Crea el vértice de inicio
        Vertice t = new Vertice(fin); // Crea el vértice de fin

        // Fase adivinadora: generar una trayectoria
        List<Vertice> trayectoria = new ArrayList<>();
        if (!faseAdivinadora(grafica, s, t, trayectoria)) {
            System.out.println("Fase adivinadora fallida: No se pudo construir una trayectoria.");
            return false; // Si la fase adivinadora falla, no se pudo encontrar una trayectoria
        }

        System.out.println("Trayectoria adivinada: " + trayectoria);

        // Fase verificadora: evaluar la trayectoria generada
        boolean resultado = faseVerificadora(grafica, trayectoria, pesoMinimo);
        if (!resultado) {
            System.out.println("Fase verificadora fallida: La trayectoria no cumple el peso mínimo.");
        }
        return resultado; // Devuelve el resultado de la fase verificadora
    }

    // Fase adivinadora: intenta generar una trayectoria desde el vértice actual hasta el destino
    private static boolean faseAdivinadora(Grafica grafica, Vertice actual, Vertice destino, List<Vertice> trayectoria) {
        trayectoria.add(actual); // Añade el vértice actual a la trayectoria
        if (actual.equals(destino)) return true; // Si llegamos al destino, la trayectoria es válida

        // Recorre las aristas del vértice actual y prueba todas las posibles trayectorias
        for (Arista arista : grafica.obtenerAristas(actual)) {
            if (!trayectoria.contains(arista.getDestino())) { // Evita ciclos en la trayectoria
                if (faseAdivinadora(grafica, arista.getDestino(), destino, trayectoria)) {
                    return true; // Si se encuentra una trayectoria válida, retorna verdadero
                }
            }
        }
        return false; // Si no se encuentra una trayectoria, retorna falso
    }

    // Fase verificadora: valida que la trayectoria generada cumple con el peso mínimo
    private static boolean faseVerificadora(Grafica grafica, List<Vertice> trayectoria, int pesoMinimo) {
        int pesoTotal = 0; // Variable que acumula el peso total de la trayectoria

        // Recorre la trayectoria y calcula el peso total
        for (int i = 0; i < trayectoria.size() - 1; i++) {
            Vertice origen = trayectoria.get(i); // Obtiene el vértice de origen
            Vertice destino = trayectoria.get(i + 1); // Obtiene el vértice de destino
            boolean encontrado = false; // Indica si se encontró la arista entre origen y destino

            // Recorre las aristas del vértice de origen para encontrar la arista hacia el destino
            for (Arista arista : grafica.obtenerAristas(origen)) {
                if (arista.getDestino().equals(destino)) {
                    pesoTotal += arista.getPeso(); // Suma el peso de la arista al peso total
                    encontrado = true; // Marca que se encontró la arista
                    break;
                }
            }

            if (!encontrado) return false; // Si no se encontró la arista, la trayectoria es inválida
        }

        return pesoTotal >= pesoMinimo; // Verifica si el peso total de la trayectoria cumple con el peso mínimo
    }
}
