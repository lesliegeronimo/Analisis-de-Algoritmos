// GERÓNIMO SOTO LESLIE - 320032848

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main <archivo_grafo.txt>");
            return;
        }

        String archivo = args[0];
        Grafica grafica = new Grafica();

        try {
            grafica.cargarDesdeArchivo(archivo);
            grafica.mostrarConjuntoIndependiente();
        } catch (Exception e) {
            System.out.println("Error durante la ejecución: " + e.getMessage());
        }
    }
}

