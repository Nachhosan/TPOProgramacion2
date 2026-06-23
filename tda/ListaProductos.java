package tda;

import model.Producto;

public class ListaProductos {

    private NodoListaProducto cabeza;

    public ListaProductos() {
        cabeza = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void insertarFinal(Producto producto) {
        NodoListaProducto nuevo = new NodoListaProducto(producto);
        NodoListaProducto aux;

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            aux = cabeza;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }
    }

    public void mostrar() {
        NodoListaProducto aux = cabeza;

        if (cabeza == null) {
            System.out.println("No hay productos para mostrar.");
            return;
        }

        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}