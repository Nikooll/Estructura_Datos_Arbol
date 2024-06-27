import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MainApp extends Application {

    ArbolBinario arbolBinario;
    Grafo grafo;
    ListaSimple listaSimple;
    ListaDoble listaDoble;

    
    @Override
    public void start(Stage primaryStage) {
        arbolBinario = new ArbolBinario();
        grafo = new Grafo();
        listaSimple = new ListaSimple();
        listaDoble = new ListaDoble();

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Árbol Binario
        Label lblArbolBinario = new Label("Árbol Binario");
        TextField txtArbolInsertar = new TextField();
        Button btnArbolInsertar = new Button("Insertar Nodo");
        Button btnArbolEliminar = new Button("Eliminar Nodo");
        Button btnArbolBuscar = new Button("Buscar Nodo");
        Button btnArbolInorden = new Button("Recorrido Inorden");

        btnArbolInsertar.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtArbolInsertar.getText());
                arbolBinario.insertarNodo(valor);
                txtArbolInsertar.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        btnArbolEliminar.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtArbolInsertar.getText());
                arbolBinario.eliminarNodo(valor);
                txtArbolInsertar.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        btnArbolBuscar.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtArbolInsertar.getText());
                boolean encontrado = arbolBinario.buscarValor(valor);
                if (encontrado) {
                    System.out.println("El nodo " + valor + " está en el árbol.");
                } else {
                    System.out.println("El nodo " + valor + " no está en el árbol.");
                }
                txtArbolInsertar.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        btnArbolInorden.setOnAction(e -> {
            arbolBinario.imprimirInorden();
        });

        VBox arbolBinarioPane = new VBox(5, lblArbolBinario, txtArbolInsertar, btnArbolInsertar, btnArbolEliminar, btnArbolBuscar, btnArbolInorden);
        arbolBinarioPane.setStyle("-fx-padding: 10px; -fx-border-color: black; -fx-border-width: 1px;");

        // Grafo
        Label lblGrafo = new Label("Grafo");
        TextField txtGrafoNodo1 = new TextField();
        TextField txtGrafoNodo2 = new TextField();
        Button btnGrafoAgregarNodo = new Button("Agregar Nodo");
        Button btnGrafoAgregarArista = new Button("Agregar Arista");
        Button btnGrafoEliminarNodo = new Button("Eliminar Nodo");
        Button btnGrafoEliminarArista = new Button("Eliminar Arista");

        btnGrafoAgregarNodo.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtGrafoNodo1.getText());
                grafo.agregarNodo(valor);
                txtGrafoNodo1.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        btnGrafoAgregarArista.setOnAction(e -> {
            try {
                int valor1 = Integer.parseInt(txtGrafoNodo1.getText());
                int valor2 = Integer.parseInt(txtGrafoNodo2.getText());

                NodoGrafo nodo1 = null, nodo2 = null;
                for (NodoGrafo nodo : grafo.nodos) {
                    if (nodo.dato == valor1)
                        nodo1 = nodo;
                    if (nodo.dato == valor2)
                        nodo2 = nodo;
                }

                if (nodo1 != null && nodo2 != null) {
                    grafo.agregarArista(nodo1, nodo2);
                } else {
                    System.out.println("No se encontraron los nodos especificados.");
                }

                txtGrafoNodo1.clear();
                txtGrafoNodo2.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        btnGrafoEliminarNodo.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtGrafoNodo1.getText());
                grafo.eliminarNodo(valor);
                txtGrafoNodo1.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        btnGrafoEliminarArista.setOnAction(e -> {
            try {
                int valor1 = Integer.parseInt(txtGrafoNodo1.getText());
                int valor2 = Integer.parseInt(txtGrafoNodo2.getText());

                NodoGrafo nodo1 = null, nodo2 = null;
                for (NodoGrafo nodo : grafo.nodos) {
                    if (nodo.dato == valor1)
                        nodo1 = nodo;
                    if (nodo.dato == valor2)
                        nodo2 = nodo;
                }

                if (nodo1 != null && nodo2 != null) {
                    grafo.eliminarArista(nodo1, nodo2);
                } else {
                    System.out.println("No se encontraron los nodos especificados.");
                }

                txtGrafoNodo1.clear();
                txtGrafoNodo2.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        VBox grafoPane = new VBox(5, lblGrafo, txtGrafoNodo1, txtGrafoNodo2, btnGrafoAgregarNodo, btnGrafoAgregarArista, btnGrafoEliminarNodo, btnGrafoEliminarArista);
        grafoPane.setStyle("-fx-padding: 10px; -fx-border-color: black; -fx-border-width: 1px;");

        // Lista Simple
        Label lblListaSimple = new Label("Lista Simple");
        TextField txtListaSimpleAgregar = new TextField();
        Button btnListaSimpleAgregar = new Button("Agregar Nodo");
        Button btnListaSimpleEliminar = new Button("Eliminar Nodo");

        btnListaSimpleAgregar.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtListaSimpleAgregar.getText());
                listaSimple.agregarNodo(valor);
                txtListaSimpleAgregar.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        btnListaSimpleEliminar.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtListaSimpleAgregar.getText());
                listaSimple.eliminarNodo(valor);
                txtListaSimpleAgregar.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        VBox listaSimplePane = new VBox(5, lblListaSimple, txtListaSimpleAgregar, btnListaSimpleAgregar, btnListaSimpleEliminar);
        listaSimplePane.setStyle("-fx-padding: 10px; -fx-border-color: black; -fx-border-width: 1px;");

        // Lista Doble
        Label lblListaDoble = new Label("Lista Doble");
        TextField txtListaDobleAgregar = new TextField();
        Button btnListaDobleAgregar = new Button("Agregar Nodo");
        Button btnListaDobleEliminar = new Button("Eliminar Nodo");

        btnListaDobleAgregar.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtListaDobleAgregar.getText());
                listaDoble.agregarNodo(valor);
                txtListaDobleAgregar.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        btnListaDobleEliminar.setOnAction(e -> {
            try {
                int valor = Integer.parseInt(txtListaDobleAgregar.getText());
                listaDoble.eliminarNodo(valor);
                txtListaDobleAgregar.clear();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        });

        VBox listaDoblePane = new VBox(5, lblListaDoble, txtListaDobleAgregar, btnListaDobleAgregar, btnListaDobleEliminar);
        listaDoblePane.setStyle("-fx-padding: 10px; -fx-border-color: black; -fx-border-width: 1px;");

        // Contenedor principal
        root.getChildren().addAll(arbolBinarioPane, grafoPane, listaSimplePane, listaDoblePane);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Estructuras de Datos y JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class ArbolBinario {
    // Implementación del árbol binario
}

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
        for (NodoGrafo nodo : nodos) {
            System.out.print("Nodo " + nodo.dato + ": ");
            for (NodoGrafo adyacente : nodo.adyacentes) {
                System.out.print(adyacente.dato + " ");
            }
            System.out.println();
        }
    }
}

class ListaSimple {
    // Implementación de lista simple
}

class ListaDoble {
    // Implementación de lista doble
}

class NodoGrafo {
    int dato;
    List<NodoGrafo> adyacentes;

    public NodoGrafo(int dato) {
        this.dato = dato;
        adyacentes = new ArrayList<>();
    }
}

