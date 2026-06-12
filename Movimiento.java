package TPOPROYECTo;

public class Movimiento {
    private int codigoProducto; // guarda el codigo del producto al que se hiz el movimiento
    private String tipo; //aqui se guarda el tipo de movimiento, ej "ingreso" o "egreso"
    private int cantidad;//Cantidad de unidades que entraron o salieron

    public Movimiento(int codigoProducto, String tipo, int cantidad){ // Constructor: cuando creo un movimiento, le paso el producto, el tipo y la cantidad
        this.codigoProducto = codigoProducto;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Devuelve el código del producto
    public int getCodigoProducto(){
    return  codigoProducto;
    }

    // Devuelve el tipo de movimiento
    public String getTipo(){
        return tipo;
    }

    // Devuelve el tipo de movimiento
    public int getCantidad(){
        return cantidad;
    }

    @Override
    public String toString(){
        // Esto sirve para mostrar el movimiento en forma de texto
        // Así cuando lo imprimo, sale algo más claro y no una referencia rara del objeto
        return tipo +
                "| producto:" +
                codigoProducto +
                "| cantidad:" +
                cantidad;
    }
}
