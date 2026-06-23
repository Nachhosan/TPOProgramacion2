package tda;

import model.Producto;

public class NodoListaProducto {
    Producto dato;
    NodoListaProducto siguiente;

    public NodoListaProducto(Producto dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}