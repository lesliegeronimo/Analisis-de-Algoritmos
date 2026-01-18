LESLIE GERONIMO SOTO - 320032848
-----------------------------------------------------------------------------------------------------------------------------------
Algoritmo de Bosque Generador de Peso Máximo - Kruskal
-----------------------------------------------------------------------------------------------------------------------------------

Este programa implementa el algoritmo de Kruskal para encontrar el BOSQUE DE PESO MAXIMO de un grafo disconexo. 
Dado un archivo de entrada con vértices y aristas de un grafo, el programa encontrará los árboles generadores con el mayor peso 
posible, sin ciclos, usando el algoritmo de Kruskal.


ESTRUCTURA DE LA PRACTICA: 

- Grafica.java: Clase que representa el grafo y maneja sus vértices y aristas.
- Arista.java: Clase que representa las aristas del grafo con su peso.
- Vertice.java: Clase que representa los vértices del grafo.
- Kruskal.java: Implementación del algoritmo de Kruskal para encontrar el bosque generador de peso máximo.
- Main.java: Clase principal que ejecuta el programa, lee el archivo de entrada y muestra el resultado.

Archivo de Entrada ("grafica.txt")

El archivo de entrada debe tener la siguiente estructura:

1. Primera línea: lista de vértices separados por coma (`,`) que forman el grafo.
2. Líneas siguientes: cada línea debe representar una arista con el formato "vértice1,vértice2 : peso", 
donde los vértices son números y el peso es un número positivo.

EJECUCION: 
1. Compilar la carpeta: javac *.java
2. java Main grafica.txt