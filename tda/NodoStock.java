package tda;

import model.Producto;

public class NodoStock {
    Producto dato;
    NodoStock izq;
    NodoStock der;

    public NodoStock(Producto dato) {
        this.dato = dato;
        this.izq = null;
        this.der = null;
    }
}