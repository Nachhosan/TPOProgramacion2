package tda;

import model.Producto;

/**
 * Árbol binario de búsqueda que organiza productos según su nivel de stock.
 * Permite obtener de forma eficiente los productos en estado crítico.
 */
public class ArbolStock {

    private NodoStock raiz; // Nodo raíz del árbol

    /**
     * Constructor: inicializa el árbol vacío.
     */
    public ArbolStock() {
        raiz = null;
    }

    /**
     * Vacía el árbol eliminando todos los nodos.
     */
    public void vaciar() {
        raiz = null;
    }

    /**
     * Inserta un producto en el árbol según su stock.
     * Si dos productos tienen el mismo stock, se desempata por código.
     */
    public void insertar(Producto producto) {
        raiz = insertarRecursivo(raiz, producto);
    }

    /**
     * Método recursivo que ubica la posición correcta del producto en el árbol.
     * Criterio principal: stock. Criterio de desempate: código del producto.
     */
    private NodoStock insertarRecursivo(NodoStock actual, Producto producto) {
        // Caso base: posición vacía, se crea el nodo aquí
        if (actual == null) {
            return new NodoStock(producto);
        }

        if (producto.getStock() < actual.dato.getStock()) {
            // Menor stock → subárbol izquierdo
            actual.izq = insertarRecursivo(actual.izq, producto);
        } else if (producto.getStock() > actual.dato.getStock()) {
            // Mayor stock → subárbol derecho
            actual.der = insertarRecursivo(actual.der, producto);
        } else {
            // Stock igual → se desempata por código
            if (producto.getCodigo() < actual.dato.getCodigo()) {
                actual.izq = insertarRecursivo(actual.izq, producto);
            } else {
                actual.der = insertarRecursivo(actual.der, producto);
            }
        }

        return actual;
    }

    /**
     * Reconstruye el árbol a partir de todos los productos del diccionario dado.
     * Vacía el árbol primero e inserta cada producto uno por uno.
     */
    public void construirDesdeDiccionario(DiccionarioProductos diccionario) {
        int i;
        Producto producto;

        vaciar(); // Limpia el árbol antes de reconstruirlo

        for (i = 0; i < diccionario.getCantidad(); i++) {
            producto = diccionario.getProductoEnPosicion(i);
            insertar(producto); // Inserta cada producto en orden de stock
        }
    }

    /**
     * Retorna una lista con todos los productos en estado crítico de stock.
     * El recorrido inorden garantiza que se devuelven ordenados de menor a mayor stock.
     */
    public ListaProductos obtenerCriticos() {
        ListaProductos lista = new ListaProductos();
        cargarCriticos(raiz, lista);
        return lista;
    }

    /**
     * Recorre el árbol en inorden y agrega a la lista los productos críticos.
     * Al ser inorden (izq → raíz → der), los productos quedan ordenados por stock ascendente.
     */
    private void cargarCriticos(NodoStock actual, ListaProductos lista) {
        if (actual != null) {
            cargarCriticos(actual.izq, lista); // Primero los de menor stock

            if (actual.dato.esCritico()) {
                lista.insertarFinal(actual.dato); // Solo se agrega si es crítico
            }

            cargarCriticos(actual.der, lista); // Luego los de mayor stock
        }
    }

    /**
     * Muestra todos los productos del árbol en orden ascendente de stock (inorden).
     */
    public void mostrarInorden() {
        mostrarInordenRecursivo(raiz);
    }

    /**
     * Recorre el árbol en inorden e imprime cada producto por consola.
     */
    private void mostrarInordenRecursivo(NodoStock actual) {
        if (actual != null) {
            mostrarInordenRecursivo(actual.izq); // Subárbol izquierdo (menor stock)
            System.out.println(actual.dato);     // Imprime el nodo actual
            mostrarInordenRecursivo(actual.der); // Subárbol derecho (mayor stock)
        }
    }
}
