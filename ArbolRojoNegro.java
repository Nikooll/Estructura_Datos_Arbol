// Clase para el árbol Rojo-Negro
class ArbolRojoNegro {
    private static final boolean ROJO = false;
    private static final boolean NEGRO = true;

    NodoRN raiz;

    class NodoRN {
        int dato;
        boolean color;
        NodoRN izquierda, derecha, padre;

        public NodoRN(int dato, boolean color) {
            this.dato = dato;
            this.color = color;
            izquierda = null;
            derecha = null;
            padre = null;
        }
    }

    public ArbolRojoNegro() {
        raiz = null;
    }

    // Implementación de métodos Árbol Rojo-Negro: inserción, eliminación, rotaciones, balanceo, etc.
}
