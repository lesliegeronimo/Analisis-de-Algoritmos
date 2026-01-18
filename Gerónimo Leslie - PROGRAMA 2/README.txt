---------------------------------------------------------------------------------------------------------------------------------
GERÓNIMO SOTO LESLIE - 320032848 
---------------------------------------------------------------------------------------------------------------------------------
P R O G R A M A      0 2 
---------------------------------------------------------------------------------------------------------------------------------

Este programa implementa dos algoritmos de búsqueda en arreglos ordenados de números enteros:

    - Búsqueda por Interpolación: Este algoritmo estima la posición del elemento a buscar utilizando una fórmula 
    de interpolación lineal, basándose en los valores de los extremos del arreglo y en el valor del número que se busca.
    - Búsqueda Exponencial: Este algoritmo expande el rango de búsqueda de forma exponencial (en potencias de 2) hasta 
    encontrar un rango adecuado, y luego aplica búsqueda binaria para encontrar el elemento.

El programa permite al usuario seleccionar entre estos dos métodos de búsqueda y, dado un archivo de entrada con números 
ordenados, busca un valor específico en la secuencia.

## Especificaciones del Programa ##

    Entrada:
        El programa lee los datos de entrada desde un archivo de texto llamado entrada.txt, que contiene una secuencia de números enteros ordenados de menor a mayor, separados por espacios.
        El usuario ingresa el valor a buscar y selecciona el método de búsqueda:
            1 para búsqueda por interpolación.
            2 para búsqueda exponencial.

    Salida:
        Si el elemento es encontrado, el programa muestra la posición del elemento dentro del arreglo.
        Si no se encuentra, muestra un mensaje indicando que el elemento no está presente.
        Para búsqueda por interpolación, muestra la posición estimada en cada iteración.
        Para búsqueda exponencial, muestra el valor de las potencias de 2 utilizadas para encontrar el rango, 
        y luego las iteraciones de la búsqueda binaria dentro de ese rango.

### Intrucciones de Uso ##

1.  Crear un archivo de texto llamado entrada.txt en el mismo directorio que el código Java. Este archivo debe contener 
    una secuencia de números ordenados separados por espacios. 

2.  Compila el programa con el siguiente comando:

    javac Programa2.java

3.  Ejecuta el programa:



    java Programa2

    El programa te pedirá ingresar el valor a buscar y el método de búsqueda:
        Ingresar el valor que deseas buscar.
        Seleccionar el método de búsqueda (1 para interpolación, 2 para exponencial).

