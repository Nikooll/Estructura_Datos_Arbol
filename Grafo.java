import java.util.ArrayList;
import java.util.List;

class Grafo {
    List<NodoGrafo> nodos;

    public Grafo() {
        nodos = new ArrayList<>();
    }

    public void agregarNodo(int dato) {
        nodos.add(new NodoGrafo(dato));
    }

    public void agregarArista(NodoGrafo nodo1, NodoGrafo nodo2) {
        nodo1.adyacentes.add(nodo2);
        nodo2.adyacentes.add(nodo1);
    }

    public void eliminarNodo(int dato) {
        NodoGrafo nodoEliminar = null;
        for (NodoGrafo nodo : nodos) {
            if (nodo.dato == dato) {
                nodoEliminar = nodo;
                break;
            }
        }
        if (nodoEliminar != null) {
            nodos.remove(nodoEliminar);
            // Eliminar aristas que involucren al nodo eliminado
            for (NodoGrafo nodo : nodos) {
                nodo.adyacentes.remove(nodoEliminar);
            }
        }
    }

    public void eliminarArista(NodoGrafo nodo1, NodoGrafo nodo2) {
        nodo1.adyacentes.remove(nodo2);
        nodo2.adyacentes.remove(nodo1);
    }

    public void imprimirGrafo() {
    }

    // Otros métodos como búsqueda de nodo, recorridos, etc.
}

