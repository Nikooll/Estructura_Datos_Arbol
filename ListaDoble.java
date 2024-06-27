class ListaDoble {
    NodoListaDoble cabeza;

    public ListaDoble() {
        cabeza = null;
    }

    public void agregarNodo(int dato) {
        NodoListaDoble nuevoNodo = new NodoListaDoble(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
    }

    public void eliminarNodo(int dato) {
        if (cabeza == null)
            return;

        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            if (cabeza != null)
                cabeza.anterior = null;
            return;
        }

        NodoListaDoble actual = cabeza;
        while (actual != null) {
            if (actual.dato == dato) {
                if (actual.anterior != null)
                    actual.anterior.siguiente = actual.siguiente;
                if (actual.siguiente != null)
                    actual.siguiente.anterior = actual.anterior;
                return;
            }
            actual = actual.siguiente;
        }
    }

    public void imprimirLista() {
    }

    // Otros métodos como buscar nodo, imprimir lista, etc.
}