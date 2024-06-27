// Clase para el árbol AVL
class ArbolAVL {
    NodoAVL raiz;

    class NodoAVL {
        int dato, altura;
        NodoAVL izquierda, derecha;

        public NodoAVL(int dato) {
            this.dato = dato;
            this.altura = 1;
            izquierda = null;
            derecha = null;
        }
    }

    public ArbolAVL() {
        raiz = null;
    }

    // Implementación de métodos AVL: inserción, eliminación, rotaciones, balanceo, etc.
}


