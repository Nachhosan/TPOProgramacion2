public class Producto {

    private int codigo;
    private String nombre;
    private int stock;
    private String ubicacion;

    public Producto(int codigo, String nombre, int stock, String ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.ubicacion = ubicacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                " | Nombre: " + nombre +
                " | Stock: " + stock +
                " | Ubicacion: " + ubicacion;
    }
}