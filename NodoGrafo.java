import java.util.*;

// Clase Nodo para el grafo
class NodoGrafo {
    int dato;
    List<NodoGrafo> adyacentes;

    public NodoGrafo(int dato) {
        this.dato = dato;
        adyacentes = new ArrayList<>();
    }
}