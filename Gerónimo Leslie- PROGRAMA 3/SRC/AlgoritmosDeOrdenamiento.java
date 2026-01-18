import java.util.*;

public class AlgoritmosDeOrdenamiento {

    // Método para el Ordenamiento por Inserción
    public static void InsertionSort(int[] arreglo) {
        System.out.println("\033[34;1m Ordenamiento por Inserción\033[0m");
        for (int i = 1; i < arreglo.length; i++) { // Iteramos desde el segundo elemento
            int clave = arreglo[i]; // Obtenemos el elemento actual
            int j = i - 1;

            // Desplazamos los elementos mayores que la clave hacia la derecha
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = clave; // Insertamos la clave en su posición correcta
            System.out.println("Paso " + i + ": " + Arrays.toString(arreglo)); // Mostramos el estado actual del arreglo
        }
    }

    // Método recursivo para dividir el arreglo y luego combinarlo
    private static void mezclaRecursiva(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) { // Condición para dividir el arreglo
            // Calculamos el punto medio
            int medio = (izquierda + derecha) / 2;

            // Dividimos el arreglo en dos partes
            mezclaRecursiva(arreglo, izquierda, medio); // Ordenamos la parte izquierda
            mezclaRecursiva(arreglo, medio + 1, derecha); // Ordenamos la parte derecha

            // Combinamos ambas partes ya ordenadas
            combinar(arreglo, izquierda, medio, derecha);
        }
    }

    // Método para el Ordenamiento por Merge Sort
    public static void MergeSort(int[] arreglo) {
        System.out.println("\033[35;1m Ordenamiento por MergeSort: \033[0m");
        mezclaRecursiva(arreglo, 0, arreglo.length - 1); // Llamamos al método recursivo que ordena
    }

    // Método para combinar dos partes del arreglo ordenadas
    private static void combinar(int[] arreglo, int izquierda, int medio, int derecha) {
        int[] temp = new int[derecha - izquierda + 1]; // Arreglo temporal para almacenar el resultado
        int i = izquierda, j = medio + 1, k = 0;

        // Combinamos los elementos de ambas mitades en orden
        while (i <= medio && j <= derecha) {
            if (arreglo[i] <= arreglo[j]) {
                temp[k++] = arreglo[i++]; // Insertamos el menor elemento en la parte temporal
            } else {
                temp[k++] = arreglo[j++]; // Insertamos el menor elemento de la otra mitad
            }
        }

        // Agregamos los elementos restantes de la primera mitad (si los hay)
        while (i <= medio) {
            temp[k++] = arreglo[i++];
        }

        // Agregamos los elementos restantes de la segunda mitad (si los hay)
        while (j <= derecha) {
            temp[k++] = arreglo[j++];
        }

        // Copiamos los elementos combinados de vuelta al arreglo original
        System.arraycopy(temp, 0, arreglo, izquierda, temp.length);

        // Mostramos el estado actual del arreglo después de la fusión
        System.out.println("Merge (izquierda: " + Arrays.toString(Arrays.copyOfRange(arreglo, izquierda, medio + 1)) +
                           ", derecha: " + Arrays.toString(Arrays.copyOfRange(arreglo, medio + 1, derecha + 1)) + ") \n Lista Ordenada:  "  +
                           Arrays.toString(arreglo));
    }

    // Método para el Ordenamiento Radix (LSD) para cadenas hexadecimales
    public static void Radix(String[] arreglo, int k) {
        System.out.println("\033[32;1m Ordenamiento Radix (LSD):\033[0m");
        int base = 16; // Base para el sistema hexadecimal
        for (int digito = k - 1; digito >= 0; digito--) { // Iteramos desde el dígito menos significativo
            List<List<String>> cubetas = new ArrayList<>();
            for (int i = 0; i < base; i++) cubetas.add(new ArrayList<>()); // Creamos 16 cubetas (0-15)

            // Clasificamos cada cadena en la cubeta correspondiente según el dígito actual
            for (String s : arreglo) {
                int indiceCubeta = Character.digit(s.charAt(digito), base);
                cubetas.get(indiceCubeta).add(s);
            }

            // Reconstruimos el arreglo desde las cubetas
            int indice = 0;
            for (List<String> cubeta : cubetas) {
                for (String s : cubeta) {
                    arreglo[indice++] = s;
                }
            }
            // Mostramos el estado actual después de procesar el dígito actual
            System.out.println("Después del dígito " + (k - digito) + ": " + Arrays.toString(arreglo)); // Mostramos el estado actual
        }
    }

    /*
     * OPCIONAL: Ordenamiento Tree Sort
     */
    // Método para el Ordenamiento TreeSort
    public static void TreeSort(int[] arreglo) {
        System.out.println("\033[31;1m Ordenamiento por TreeSort:\033[0m");
        TreeSet<Integer> arbol = new TreeSet<>(); // Utilizamos un TreeSet para ordenar automáticamente

        // Agregamos cada elemento al árbol
        for (int num : arreglo) {
            arbol.add(num);
            System.out.println("Agregado " + num + ": " + arbol); // Mostramos el estado actual del árbol
        }

        // Extraemos los elementos ordenados del árbol y los guardamos en el arreglo original
        int i = 0;
        for (int num : arbol) {
            arreglo[i++] = num;
        }
    }

    // Método principal para ejecutar ejemplos
    public static void main(String[] args) {
        // Ejemplo con MergeSort
        int[] arreglo = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("\033[33;1mArreglo Original: " + Arrays.toString(arreglo) + "\033[0m");

        MergeSort(arreglo); // Llamada al algoritmo MergeSort
        System.out.println("\033[33;1mArreglo Ordenado: " + Arrays.toString(arreglo) + "\033[0m");
    }
}
