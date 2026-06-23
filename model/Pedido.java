package model;

public class Pedido {

    //numero unico que identificara el pedido
    private int numeroPedido;

    //Codigo del producto que se solicito
    private int codigoProducto;

    //cantidad de unidad que se solicita del producto
    private int cantidadSolicitada;

    //constructor que inicializa los datos del pedido
    public Pedido(int numeroPedido, int codigoProducto, int cantidadSolicitada) {
        this.numeroPedido = numeroPedido;
        this.codigoProducto = codigoProducto;
        this.cantidadSolicitada = cantidadSolicitada;
    }
    //devuelve el número del pedido
    public int getNumeroPedido() {
        return numeroPedido;
    }

    //devuelve el código del producto solicitado
    public int getCodigoProducto() {
        return codigoProducto;
    }

    //devuelve la cantidad solicitada del producto
    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    //devuelve una representación en texto del pedido
    @Override
    public String toString() {
        return "Pedido N°: " + numeroPedido +
                " | Producto: " + codigoProducto +
                " | Cantidad: " + cantidadSolicitada;DS
    }
}