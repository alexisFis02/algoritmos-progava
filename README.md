# Repositorio de Algoritmos en Java

## Introducción
Este repositorio está diseñado para almacenar todos los algoritmos vistos en las clases de Programacion Avanzada de la UNLaM.

## Contribuyentes
Clivio Lucas Ariel, 43308587  [Foto](https://upload.wikimedia.org/wikipedia/commons/d/d9/Edsger_Wybe_Dijkstra.jpg)

Castillo Alexis, 43991136  [Foto](https://upload.wikimedia.org/wikipedia/commons/e/e8/Lc3_2018_%28263682303%29_%28cropped%29.jpeg)

Rosano Matias, 43570765 [Foto](https://pbs.twimg.com/profile_images/102914807/ivar_400x400.jpg)

## Uso
En el main, se puede correr la funcion OrdenamientoStats.mostrarEstadisticasOrdenamiento() que probara todos los algoritmos de ordenamiento.
El mismo generara array de datos aleatorios y los probara con cada algoritmo, imprimiendo a la vez, el tiempo promedio que le tomo ordenar el conjunto de datos al algoritmo actual.

## Contenido

### Implementacion de Monticulo
Un montículo es un árbol binario completo, lo que significa que está completamente lleno en todos los niveles, excepto posiblemente en el último nivel, que está lleno de izquierda a derecha. 

En un montículo máximo, para cada nodo `i` distinto de la raíz, el valor de `i` es menor o igual que el valor de su padre. 

En un montículo mínimo, para cada nodo `i` distinto de la raíz, el valor de `i` es mayor o igual que el valor de su padre.

### Algoritmos de Ordenamiento:
Se describen los algoritmos implementados para ordenar vectores.

#### Bubble Sort
Bubble Sort es un algoritmo de ordenamiento simple que compara pares adyacentes de elementos y los intercambia si están en el orden incorrecto. 
Este proceso se repite hasta que la lista esté ordenada. Es ineficiente para listas grandes debido a su complejidad O(n^2).

#### Insertion Sort
Insertion Sort ordena una lista dividiéndola en una parte ordenada y otra no ordenada. 
Los elementos de la parte no ordenada se insertan uno a uno en su posición correcta en la parte ordenada. 
Es eficiente para listas pequeñas y casi ordenadas, con una complejidad de O(n^2) en el peor caso.

#### Merge Sort
Merge Sort es un algoritmo de ordenamiento divide y vencerás que divide la lista en mitades, las ordena recursivamente y luego las combina para formar una lista ordenada. 
Tiene una complejidad de O(n log n) en el peor caso, haciéndolo eficiente para listas grandes.

#### Quick Sort
Quick Sort es un algoritmo de ordenamiento divide y vencerás que selecciona un pivote, divide la lista en sublistas según el pivote y las ordena recursivamente. 
Es eficiente en la práctica con una complejidad promedio de O(n log n), pero puede degradarse a O(n^2) en el peor caso.

#### Selection Sort
Selection Sort ordena una lista dividiéndola en una parte ordenada y otra no ordenada. 
En cada iteración, selecciona el elemento mínimo de la parte no ordenada y lo intercambia con el primer elemento no ordenado. 
Tiene una complejidad de O(n^2), lo que lo hace ineficiente para listas grandes.

#### Shell Sort
Shell Sort es una variante de Insertion Sort que mejora la eficiencia al comparar e intercambiar elementos que están a una distancia mayor. 
La distancia se reduce gradualmente hasta que se convierte en una ordenación por inserción clásica. 
Su complejidad varía, pero es más eficiente que O(n^2) en la práctica.

### Algoritmos de Grafos
Se describen los algoritmos utilizados que necesitan de un grafo. Recorren grafos o obtienen datos del mismo

#### Dijkstra
El algoritmo de Dijkstra encuentra el camino más corto desde un nodo fuente a todos los demás nodos en un grafo con pesos no negativos. 
Utiliza una cola de prioridad para seleccionar el nodo con la distancia más corta y actualizar las distancias de sus vecinos. 
Su complejidad es O(V^2) para grafos densos y O(E log V) usando colas de prioridad con un montículo binario.

#### BFS (Búsqueda en Anchura)
La Búsqueda en Anchura (BFS) es un algoritmo de recorrido de grafos que explora todos los nodos a una distancia k antes de avanzar a los nodos a una distancia k+1. 
Es útil para encontrar el camino más corto en grafos no ponderados y tiene una complejidad de O(V + E), donde V es el número de nodos y E es el número de aristas.

#### DFS (Búsqueda en Profundidad)
La Búsqueda en Profundidad (DFS) es un algoritmo de recorrido de grafos que explora tanto como sea posible a lo largo de cada rama antes de retroceder. 
Es útil para detectar ciclos, encontrar componentes fuertemente conectados y realizar otras tareas que requieren explorar todas las aristas de un grafo. Su complejidad es O(V + E).

### Algoritmo MST (Minimum Spanning Tree)

Un Árbol de Expansión Mínima (MST) es un subgrafo de un grafo no dirigido que conecta todos los nodos con el menor costo total posible, sin ciclos. 
Los algoritmos implementados para encontrar un MST son los de Prim.

#### Prim
El algoritmo de Prim encuentra el árbol de expansión mínima (MST) de un grafo conectando todos los nodos con el costo total más bajo posible. 
Comienza en un nodo arbitrario y agrega aristas de menor peso que conectan nuevos nodos al árbol. 
Utiliza una cola de prioridad para seleccionar las aristas de menor peso y tiene una complejidad de O(V^2) para grafos densos y O(E log V) usando un montículo binario.

## Testing
Todos los algoritmos de ordenamiento tienen un apartado de pruebas en la carptea test/ordenamiento.
