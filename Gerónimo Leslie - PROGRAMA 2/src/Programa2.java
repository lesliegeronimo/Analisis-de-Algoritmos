/**
 * GERÓNIMO SOTO LESLIE - 320032848
 */

import java.io.*;
import java.util.*;

public class Programa2 {

    // Función de búsqueda por interpolación
    public static int busquedaInterpolacion(int[] arr, int n, int z) {
        int izq = 0, der = n - 1;
        while (izq <= der && z >= arr[izq] && z <= arr[der]) {
            if (izq == der) {
                if (arr[izq] == z) return izq;
                return -1;
            }
            // Fórmula de interpolación
            int pos = izq + ((z - arr[izq]) * (der - izq)) / (arr[der] - arr[izq]);

            System.out.println("Interpolación en pos: " + pos + ", valor: " + arr[pos]);

            // Elemento encontrado
            if (arr[pos] == z)
                return pos;

            // Si z es mayor, buscar en la parte derecha
            if (arr[pos] < z)
                izq = pos + 1;
            // Si z es menor, buscar en la parte izquierda
            else
                der = pos - 1;
        }
        return -1; // Si no se encuentra el elemento
    }

    // Función de búsqueda exponencial
    public static int busquedaExponencial(int[] arr, int n, int z) {
        if (arr[0] == z) return 0;

        // Encuentra el rango en el que se puede encontrar el valor
        int i = 1;
        while (i < n && arr[i] <= z) {
            System.out.println("Exponencial en i: " + i + ", valor: " + arr[i]);
            i = i * 2;
        }

        // Realiza búsqueda binaria en el rango encontrado
        return busquedaBinaria(arr, i / 2, Math.min(i, n), z);
    }

    // Búsqueda binaria
    public static int busquedaBinaria(int[] arr, int izq, int der, int z) {
        while (izq <= der) {
            int mid = izq + (der - izq) / 2;
            System.out.println("Búsqueda binaria en mid: " + mid + ", valor: " + arr[mid]);
            if (arr[mid] == z)
                return mid;
            if (arr[mid] < z)
                izq = mid + 1;
            else
                der = mid - 1;
        }
        return -1; // Si no se encuentra el elemento
    }

    public static void main(String[] args) throws IOException {
        // Cargar archivo de entrada
        BufferedReader br = new BufferedReader(new FileReader("entrada.txt"));
        String[] line = br.readLine().split(" ");
        int n = line.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        // Leer el número a buscar
        System.out.println("Ingrese el valor que se quiere buscar: ");
        Scanner scanner = new Scanner(System.in);
        int z = scanner.nextInt();

        // Elegir método de búsqueda
        System.out.println("Elija el método de búsqueda (1: Interpolación, 2: Exponencial): ");
        int metodo = scanner.nextInt();

        int resultado = -1;
        if (metodo == 1) {
            resultado = busquedaInterpolacion(arr, n, z);
        } else if (metodo == 2) {
            resultado = busquedaExponencial(arr, n, z);
        }

        if (resultado != -1) {
            System.out.println("Elemento encontrado en la posición: " + resultado);
        } else {
            System.out.println("Elemento no encontrado :C.");
        }
    }
}
