package tda;

import model.Producto;

public class ListaProductos {

    // Apunta al primer nodo de la lista
    private NodoListaProducto cabeza;

    public ListaProductos() {
        // La lista arranca vacía, por eso la cabeza apunta a null
        cabeza = null;
    }

    public boolean estaVacia() {
        // Si la cabeza es null, entonces no hay nodos cargados
        return cabeza == null;
    }

    public void insertarFinal(Producto producto) {
        // Creo un nodo nuevo con el producto que quiero agregar
        NodoListaProducto nuevo = new NodoListaProducto(producto);
        NodoListaProducto aux;

        // Si la lista está vacía, el nuevo pasa a ser la cabeza
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            // Si no está vacía, arranco desde la cabeza
            aux = cabeza;

            // Avanzo hasta llegar al último nodo
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            // Cuando llego al final, engancho el nuevo nodo ahí
            aux.siguiente = nuevo;
        }
    }

    public void mostrar() {
        // Empiezo a recorrer desde la cabeza
        NodoListaProducto aux = cabeza;

        // Si no hay productos, aviso y salgo
        if (cabeza == null) {
            System.out.println("No hay productos para mostrar.");
            return;
        }

        // Recorro toda la lista mostrando el producto de cada nodo
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}
    }
}
