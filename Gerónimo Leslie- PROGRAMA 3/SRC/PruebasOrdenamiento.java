/*
 * PROGRAMA 3 - ANÁLISIS DE ALGORITMOS
 * GERÓNIMO SOTO LESLIE 
 * 320032848
 */
import java.util.*;

public class PruebasOrdenamiento {

    public static void main(String[] args) {
        int[] numeros = {5, 3, 8, 6, 2, 7, 4, 1, 20, 99, 100, 24, 50};
        String[] cadenasHex = {"3C", "7F", "4A", "9B", "5D", "8E", "6F", "0A"};

        System.out.println("\033[93;1mArreglo Original:\033[93m" + Arrays.toString(numeros));
        AlgoritmosDeOrdenamiento.InsertionSort(numeros.clone()); // Prueba con InsertionSort

        AlgoritmosDeOrdenamiento.MergeSort(numeros.clone()); // Prueba con MergeSort

        AlgoritmosDeOrdenamiento.TreeSort(numeros.clone()); // Prueba con TreeSort

        System.out.println("\n\033[93;1mArreglo Hexadecimal Original: \033[93m " + Arrays.toString(cadenasHex));
        AlgoritmosDeOrdenamiento.Radix(cadenasHex.clone(), 2); // Prueba con Radix
    }
}
