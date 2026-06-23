package tda;

import model.Producto;

public class NodoStock {
    // Acá se guarda el producto que va en este nodo del árbol
    Producto dato;

    // Referencia al hijo izquierdo
    NodoStock izq;

    // Referencia al hijo derecho
    NodoStock der;

    public NodoStock(Producto dato) {
        // Cuando creo el nodo, le asigno el producto que va a guardar
        this.dato = dato;

        // Arranca sin hijo izquierdo
        this.izq = null;

        // Arranca sin hijo derecho
        this.der = null;
    }
}
