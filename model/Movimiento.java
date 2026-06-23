package model;

public class Movimiento {

    // Código del producto involucrado en el movimiento
    private int codigoProducto;

    // Tipo de movimiento (Entrada, Salida, Ajuste, etc.)
    private String tipo;

    // Cantidad de unidades afectadas por el movimiento
    private int cantidad;

    // Información adicional sobre el movimiento
    private String detalle;

    // Constructor que crea un movimiento sin detalle adicional
    public Movimiento(int codigoProducto, String tipo, int cantidad) {
        this.codigoProducto = codigoProducto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.detalle = "";
    }

    // Constructor que crea un movimiento con detalle adicional
    public Movimiento(int codigoProducto, String tipo, int cantidad, String detalle) {
        this.codigoProducto = codigoProducto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.detalle = detalle;
    }

    // Devuelve el código del producto
    public int getCodigoProducto() {
        return codigoProducto;
    }

    // Devuelve el tipo de movimiento
    public String getTipo() {
        return tipo;
    }

    // Devuelve la cantidad involucrada en el movimiento
    public int getCantidad() {
        return cantidad;
    }

    // Devuelve el detalle del movimiento
    public String getDetalle() {
        return detalle;
    }

    // Genera una representación en texto del movimiento
    @Override
    public String toString() {

        // Si no existe detalle, muestra solo los datos básicos
        if (detalle.equals("")) {
            return tipo +
                    " | Producto: " +
                    codigoProducto +
                    " | Cantidad: " +
                    cantidad;
        }

        // Si existe detalle, lo agrega a la descripción
        return tipo +
                " | Producto: " +
                codigoProducto +
                " | Cantidad: " +
                cantidad +
                " | Detalle: " +
                detalle;
    }
}