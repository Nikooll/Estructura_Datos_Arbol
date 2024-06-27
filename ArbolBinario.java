class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertarNodo(int dato) {
        raiz = insertarRec(raiz, dato);
    }

    private Nodo insertarRec(Nodo raiz, int dato) {
        if (raiz == null) {
            raiz = new Nodo(dato);
            return raiz;
        }

        if (dato < raiz.dato)
            raiz.izquierda = insertarRec(raiz.izquierda, dato);
        else if (dato > raiz.dato)
            raiz.derecha = insertarRec(raiz.derecha, dato);

        return raiz;
    }

    public boolean buscarValor(int dato) {
        return buscarRec(raiz, dato);
    }

    private boolean buscarRec(Nodo raiz, int dato) {
        if (raiz == null)
            return false;

        if (raiz.dato == dato)
            return true;
        else if (dato < raiz.dato)
            return buscarRec(raiz.izquierda, dato);
        else
            return buscarRec(raiz.derecha, dato);
    }

    public void eliminarNodo(int dato) {
        raiz = eliminarRec(raiz, dato);
    }

    private Nodo eliminarRec(Nodo raiz, int dato) {
        if (raiz == null)
            return raiz;

        if (dato < raiz.dato)
            raiz.izquierda = eliminarRec(raiz.izquierda, dato);
        else if (dato > raiz.dato)
            raiz.derecha = eliminarRec(raiz.derecha, dato);
        else {
            // Caso nodo con un solo hijo o sin hijos
            if (raiz.izquierda == null)
                return raiz.derecha;
            else if (raiz.derecha == null)
                return raiz.izquierda;

            // Caso nodo con dos hijos: encontrar el sucesor inorden (menor nodo en el subárbol derecho)
            raiz.dato = encontrarMinimo(raiz.derecha);
            raiz.derecha = eliminarRec(raiz.derecha, raiz.dato);
        }
        return raiz;
    }

    private int encontrarMinimo(Nodo raiz) {
        int min = raiz.dato;
        while (raiz.izquierda != null) {
            min = raiz.izquierda.dato;
            raiz = raiz.izquierda;
        }
        return min;
    }

    public void imprimirInorden() {
        imprimirInordenRec(raiz);
        System.out.println();
    }

    private void imprimirInordenRec(Nodo raiz) {
        if (raiz != null) {
            imprimirInordenRec(raiz.izquierda);
            System.out.print(raiz.dato + " ");
            imprimirInordenRec(raiz.derecha);
        }
    }

    // Otros métodos como recorrido preorden, postorden, balancear, altura, etc.
}



