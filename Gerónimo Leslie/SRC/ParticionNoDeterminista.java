import java.util.*;

public class ParticionNoDeterminista {
    // Método que resuelve el problema de partición de un conjunto en dos subconjuntos con suma igual
    public static boolean resolverParticion(List<Integer> conjunto) {
        // Calcula la suma total de los elementos del conjunto
        int sumaTotal = conjunto.stream().mapToInt(Integer::intValue).sum();

        // Si la suma total es impar, no es posible una partición en dos subconjuntos con suma igual
        if (sumaTotal % 2 != 0) {
            System.out.println("La suma total es impar, no se puede realizar una partición.");
            return false; // Si la suma es impar, no puede dividirse en dos subconjuntos iguales
        }

        // Fase adivinadora: generar subconjunto B que tenga la mitad de la suma total
        List<Integer> subconjuntoB = new ArrayList<>();
        if (!faseAdivinadora(conjunto, subconjuntoB, sumaTotal / 2)) {
            System.out.println("Fase adivinadora fallida: No se pudo encontrar un subconjunto válido.");
            return false; // Si la fase adivinadora falla, no se puede encontrar un subconjunto válido
        }

        System.out.println("Subconjunto adivinado: " + subconjuntoB);

        // Fase verificadora: evaluar si el subconjunto B y el resto del conjunto tienen la misma suma
        boolean resultado = faseVerificadora(conjunto, subconjuntoB);
        if (!resultado) {
            System.out.println("Fase verificadora fallida: La partición no es válida.");
        }
        return resultado; // Devuelve el resultado de la fase verificadora
    }

    // Fase adivinadora: intenta encontrar un subconjunto B cuya suma sea la mitad de la suma total
    private static boolean faseAdivinadora(List<Integer> conjunto, List<Integer> subconjuntoB, int sumaObjetivo) {
        int suma = 0; // Variable para acumular la suma de los elementos en el subconjunto B
        for (int numero : conjunto) {
            // Si agregar el número al subconjunto no supera la suma objetivo, lo agrega
            if (suma + numero <= sumaObjetivo) {
                subconjuntoB.add(numero); // Agrega el número al subconjunto B
                suma += numero; // Actualiza la suma del subconjunto B
            }
        }
        return suma == sumaObjetivo; // Devuelve true si la suma del subconjunto B es igual a la mitad de la suma total
    }

    // Fase verificadora: verifica si la partición es válida comparando las sumas de los subconjuntos
    private static boolean faseVerificadora(List<Integer> conjunto, List<Integer> subconjuntoB) {
        int sumaB = subconjuntoB.stream().mapToInt(Integer::intValue).sum(); // Suma de los elementos en B
        int sumaA = conjunto.stream().mapToInt(Integer::intValue).sum() - sumaB; // Suma de los elementos en A (el resto del conjunto)
        return sumaA == sumaB; // Devuelve true si las sumas de A y B son iguales
    }
}
