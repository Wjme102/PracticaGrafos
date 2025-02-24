
import java.util.*;

public class Grafo {
    private List<List<Integer>> listaAdyacencia;
    private Map<Character, Integer> mapVertices;

    /**
     * Función: Grafo
     * Parámetros: Ninguno
     * Objetivo: Inicializar la lista de adyacencia 
     */
    public Grafo() {
        listaAdyacencia = new ArrayList<>(9);
        mapVertices = new HashMap<>();
    }

    /**
     * Función: agregarVertice
     * Parámetros: char vertice
     * Objetivo: Añadir el vértice al mapeo y a la lista de adyacencia si aún no existe, evitando errores de índice
     */
    public void agregarVertice(char vertice) {
        if (!mapVertices.containsKey(vertice)) {
            mapVertices.put(vertice, listaAdyacencia.size());
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    /**
     * Función: agregarArista
     * Parámetros: char ini, char fin
     * Objetivo: Añadir una conexión entre ini y fin en la lista de adyacencia
     */
    public void agregarArista(char ini, char fin) {
        agregarVertice(ini);
        agregarVertice(fin);
        int idx1 = mapVertices.get(ini);
        int idx2 = mapVertices.get(fin);
        listaAdyacencia.get(idx1).add(idx2);
        listaAdyacencia.get(idx2).add(idx1);
    }

    /**
     * Función: imprimirListaAdyacencia
     * Parámetros: Ninguno
     * Objetivo: Mostrar cada vértice y sus adyacentes convertidos a letras, ordenados para una mejor presentación
     */
    public void imprimirListaAdyacencia() {
        char[] indiceALetra = new char[listaAdyacencia.size()];
        for (Map.Entry<Character, Integer> entry : mapVertices.entrySet()) {
            indiceALetra[entry.getValue()] = entry.getKey();
        }
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            char vertice = indiceALetra[i];
            List<Integer> adyacentes = listaAdyacencia.get(i);
            List<Character> adyLetras = new ArrayList<>();
            for (int idx : adyacentes) {
                adyLetras.add(indiceALetra[idx]);
            }

            System.out.print(vertice + ": ");
            for (int j = 0; j < adyLetras.size(); j++) {
                System.out.print(adyLetras.get(j));
                if (j < adyLetras.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Función: imprimirSecuenciaGrados
     * Parámetros: Ninguno
     * Objetivo: Calcular y mostrar el grado de cada vértice del grafo
     */
    public void imprimirSecuenciaGrados() {
        char[] indiceALetra = new char[listaAdyacencia.size()];
        for (Map.Entry<Character, Integer> entry : mapVertices.entrySet()) {
            indiceALetra[entry.getValue()] = entry.getKey();
        }
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            char vertice = indiceALetra[i];
            int grado = listaAdyacencia.get(i).size();
            System.out.println("Grado de " + vertice + ": " + grado);
        }
    }

    /**
     * Función: main
     * Parámetros: String[] args
     * Objetivo: Crear una instancia de Grafo, agregar las aristas definidas y mostrar la lista de adyacencia y la secuencia de grados
     */
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.agregarArista('A', 'B');
        grafo.agregarArista('A', 'C');
        grafo.agregarArista('B', 'D');
        grafo.agregarArista('B', 'E');
        grafo.agregarArista('C', 'F');
        grafo.agregarArista('C', 'G');
        grafo.agregarArista('D', 'E');
        grafo.agregarArista('D', 'H');
        grafo.agregarArista('E', 'I');
        grafo.agregarArista('F', 'G');
        grafo.agregarArista('G', 'H');
        grafo.agregarArista('H', 'I');
        grafo.agregarArista('I', 'F');

        System.out.println("Lista de Adyacencia:");
        grafo.imprimirListaAdyacencia();

        System.out.println("\nSecuencia de Grados:");
        grafo.imprimirSecuenciaGrados();
    }
}