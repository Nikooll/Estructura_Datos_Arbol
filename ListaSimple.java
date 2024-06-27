class ListaSimple {
    NodoListaSimple cabeza;

    public ListaSimple() {
        cabeza = null;
    }

    public void agregarNodo(int dato) {
        NodoListaSimple nuevoNodo = new NodoListaSimple(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void eliminarNodo(int dato) {
        if (cabeza == null)
            return;

        if (cabeza.dato == dato) {
            cabeza = cabeza.siguiente;
            return;
        }

        NodoListaSimple actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato == dato) {
                actual.siguiente = actual.siguiente.siguiente;
                return;
            }
            actual = actual.siguiente;
        }
    }

    public void imprimirLista() {
    }

    // Otros métodos como buscar nodo, imprimir lista, etc.
}
