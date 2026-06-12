public class Inventario {

    private Producto[] productos;
    private int cantidad;

    public Inventario(int capacidad) {
        productos = new Producto[capacidad];
        cantidad = 0;
    }

    public void agregarProducto(Producto producto) {

        if(cantidad < productos.length){
            productos[cantidad] = producto;
            cantidad++;
        }
    }

    public Producto buscarProducto(int codigo) {

        for(int i = 0; i < cantidad; i++){

            if(productos[i].getCodigo() == codigo){
                return productos[i];
            }
        }

        return null;
    }

    public void mostrarProductos() {

        for(int i = 0; i < cantidad; i++){
            System.out.println(productos[i]);
        }
    }
}