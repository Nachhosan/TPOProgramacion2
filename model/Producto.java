package model;

public class Producto {

    // Código único que identifica al producto
    private int codigo;

    // Nombre del producto
    private String nombre;

    // Cantidad disponible en stock
    private int stock;

    // Ubicación física del producto en el depósito
    private String ubicacion;

    // Cantidad mínima de stock permitida
    private int stockMinimo;

    // Constructor que inicializa todos los datos del producto
    public Producto(int codigo, String nombre, int stock, String ubicacion, int stockMinimo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.ubicacion = ubicacion;
        this.stockMinimo = stockMinimo;
    }

    // Devuelve el código del producto
    public int getCodigo() {
        return codigo;
    }

    // Devuelve el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Devuelve la cantidad actual en stock
    public int getStock() {
        return stock;
    }

    // Devuelve la ubicación del producto
    public String getUbicacion() {
        return ubicacion;
    }

    // Devuelve el stock mínimo establecido
    public int getStockMinimo() {
        return stockMinimo;
    }

    // Modifica la cantidad de stock
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Modifica la ubicación del producto
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Ingresa unidades al stock si la cantidad es válida
    public boolean ingresarStock(int cantidad) {
        if (cantidad <= 0) {
            return false;
        }

        stock = stock + cantidad;
        return true;
    }

    // Retira unidades del stock si hay suficiente cantidad disponible
    public boolean egresarStock(int cantidad) {
        if (cantidad <= 0 || cantidad > stock) {
            return false;
        }

        stock = stock - cantidad;
        return true;
    }

    // Verifica si el stock está en nivel crítico
    public boolean esCritico() {
        return stock <= stockMinimo;
    }

    // Devuelve una representación en texto de los datos del producto
    @Override
    public String toString() {
        return "Codigo: " + codigo +
                " | Nombre: " + nombre +
                " | Stock: " + stock +
                " | Ubicacion: " + ubicacion +
                " | Stock minimo: " + stockMinimo;
    }
}