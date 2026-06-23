package tda;

import model.Producto;

public class DiccionarioProductos {

    private Producto[] productos;
    private int cantidad;

    public DiccionarioProductos(int capacidad) {
        productos = new Producto[capacidad];
        cantidad = 0;
    }

    public boolean insertar(Producto producto) {
        if (cantidad == productos.length) {
            System.out.println("No hay espacio para más productos.");
            return false;
        }

        if (buscar(producto.getCodigo()) != null) {
            System.out.println("Ya existe un producto con ese código.");
            return false;
        }

        productos[cantidad] = producto;
        cantidad++;
        return true;
    }

    public Producto buscar(int codigo) {
        int i;

        for (i = 0; i < cantidad; i++) {
            if (productos[i].getCodigo() == codigo) {
                return productos[i];
            }
        }

        return null;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProductoEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }

        return productos[posicion];
    }

    public void mostrar() {
        int i;

        if (cantidad == 0) {
            System.out.println("No hay productos cargados.");
            return;
        }

        for (i = 0; i < cantidad; i++) {
            System.out.println(productos[i]);
        }
    }
}