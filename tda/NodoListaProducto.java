package tda;

import model.Producto;

public class NodoListaProducto {
    // Acá se guarda el producto que contiene este nodo
    Producto dato;

    // Referencia al siguiente nodo de la lista
    NodoListaProducto siguiente;

    public NodoListaProducto(Producto dato) {
        // Guardo el producto que me pasan al crear el nodo
        this.dato = dato;

        // Arranca sin siguiente porque todavía no está enlazado con otro nodo
        this.siguiente = null;
    }
}
