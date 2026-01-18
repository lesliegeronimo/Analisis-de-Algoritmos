import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Verifica que se haya proporcionado al menos dos argumentos (problema y archivo de entrada)
        if (args.length < 2) {
            System.out.println("Uso: java Main <problema> <archivoEntrada> [<parametros>]");
            System.out.println("Problemas:");
            System.out.println("  trayectoria <archivo> <inicio> <fin> <pesoMinimo>");
            System.out.println("  particion <archivo>");
            return; // Si no se cumplen los requisitos de los argumentos, muestra el mensaje de uso y termina
        }

        // El primer argumento especifica el tipo de problema a resolver
        String problema = args[0];
        // El segundo argumento es el archivo de entrada que contiene los datos
        String archivoEntrada = args[1];

        try {
            // Dependiendo del problema especificado, se ejecuta el caso correspondiente
            switch (problema.toLowerCase()) {
                case "trayectoria":
                    // Verifica que se hayan proporcionado los parámetros adicionales necesarios
                    if (args.length < 5) {
                        System.out.println("Uso: java Main trayectoria <archivo> <inicio> <fin> <pesoMinimo>");
                        return;
                    }
                    String inicio = args[2]; // Vértice de inicio
                    String fin = args[3];    // Vértice de fin
                    int pesoMinimo = Integer.parseInt(args[4]); // Peso mínimo

                    // Lee la gráfica desde el archivo especificado
                    Grafica grafica = LectorDatos.leerGraficaDesdeArchivo(archivoEntrada);
                    System.out.println("Gráfica cargada:\n" + grafica);

                    // Resuelve el problema de Trayectoria usando la clase TrayectoriaNoDeterminista
                    boolean solucionTrayectoria = TrayectoriaNoDeterminista.resolverTrayectoria(grafica, inicio, fin, pesoMinimo);
                    System.out.println("¿Cumple las condiciones del problema? " + solucionTrayectoria);
                    break;

                case "particion":
                    // Lee el conjunto de números desde el archivo especificado
                    List<Integer> conjunto = LectorDatos.leerConjuntoDesdeArchivo(archivoEntrada);
                    System.out.println("Conjunto cargado: " + conjunto);

                    // Resuelve el problema de Partición usando la clase ParticionNoDeterminista
                    boolean solucionParticion = ParticionNoDeterminista.resolverParticion(conjunto);
                    System.out.println("¿Cumple las condiciones del problema? " + solucionParticion);
                    break;

                default:
                    // Si el tipo de problema no es reconocido, muestra un mensaje de error
                    System.out.println("Problema desconocido: " + problema);
                    System.out.println("Problemas soportados: trayectoria, particion");
            }
        } catch (IOException e) {
            // Maneja errores al leer el archivo
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Maneja errores en la conversión de parámetros numéricos
            System.out.println("Error al convertir parámetros numéricos: " + e.getMessage());
        }
    }
}
