
package service;

import model.Movimiento;
import model.Pedido;
import model.Producto;
import tda.ArbolStock;
import tda.ColaPedidos;
import tda.DiccionarioProductos;
import tda.GrafoDeposito;
import tda.ListaProductos;
import tda.PilaMovimientos;

public class Inventario {

    private DiccionarioProductos productos;
    private PilaMovimientos historial;
    private ColaPedidos pedidos;
    private GrafoDeposito grafo;
    private ArbolStock arbolStock;

    public Inventario(int capacidadProductos, int capacidadMovimientos, int capacidadPedidos, int capacidadUbicaciones) {
        productos = new DiccionarioProductos(capacidadProductos);
        historial = new PilaMovimientos(capacidadMovimientos);
        pedidos = new ColaPedidos(capacidadPedidos);
        grafo = new GrafoDeposito(capacidadUbicaciones);
        arbolStock = new ArbolStock();
    }

    public boolean registrarProducto(int codigo, String nombre, int stock, String ubicacion, int stockMinimo) {
        Producto producto;

        if (codigo <= 0 || stock < 0 || stockMinimo < 0) {
            System.out.println("Datos inválidos.");
            return false;
        }

        if (nombre == null || nombre.trim().equals("")) {
            System.out.println("El nombre no puede estar vacío.");
            return false;
        }

        if (ubicacion == null || ubicacion.trim().equals("")) {
            System.out.println("La ubicación no puede estar vacía.");
            return false;
        }

        if (!grafo.existeUbicacion(ubicacion)) {
            grafo.agregarUbicacion(ubicacion);
        }

        producto = new Producto(codigo, nombre, stock, ubicacion, stockMinimo);
        return productos.insertar(producto);
    }

    public Producto buscarProducto(int codigo) {
        return productos.buscar(codigo);
    }

    public void mostrarProductos() {
        productos.mostrar();
    }

    public boolean ingresarMercaderia(int codigo, int cantidad) {
        Producto producto = productos.buscar(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return false;
        }

        if (!producto.ingresarStock(cantidad)) {
            System.out.println("Cantidad inválida.");
            return false;
        }

        historial.apilar(new Movimiento(codigo, "INGRESO", cantidad));
        return true;
    }

    public boolean egresarMercaderia(int codigo, int cantidad) {
        Producto producto = productos.buscar(codigo);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return false;
        }

        if (!producto.egresarStock(cantidad)) {
            System.out.println("Stock insuficiente o cantidad inválida.");
            return false;
        }

        historial.apilar(new Movimiento(codigo, "EGRESO", cantidad));
        return true;
    }

    public boolean transferirProducto(int codigo, String nuevaUbicacion) {
        Producto producto = productos.buscar(codigo);
        String ubicacionAnterior;

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return false;
        }

        if (nuevaUbicacion == null || nuevaUbicacion.trim().equals("")) {
            System.out.println("La nueva ubicación no puede estar vacía.");
            return false;
        }

        if (producto.getUbicacion().equalsIgnoreCase(nuevaUbicacion)) {
            System.out.println("El producto ya está en esa ubicación.");
            return false;
        }

        if (!grafo.existeUbicacion(nuevaUbicacion)) {
            grafo.agregarUbicacion(nuevaUbicacion);
        }

        ubicacionAnterior = producto.getUbicacion();
        producto.setUbicacion(nuevaUbicacion);

        historial.apilar(new Movimiento(codigo, "TRANSFERENCIA", 0, ubicacionAnterior));
        return true;
    }

    public void verHistorial() {
        historial.mostrar();
    }

    public boolean deshacerUltimoMovimiento() {
        Movimiento ultimo = historial.desapilar();
        Producto producto;

        if (ultimo == null) {
            System.out.println("No hay movimientos para deshacer.");
            return false;
        }

        producto = productos.buscar(ultimo.getCodigoProducto());

        if (producto == null) {
            System.out.println("No se encontró el producto del movimiento.");
            return false;
        }

        if (ultimo.getTipo().equals("INGRESO")) {
            if (producto.egresarStock(ultimo.getCantidad())) {
                System.out.println("Se deshizo el ingreso.");
                return true;
            }
            System.out.println("No se pudo deshacer el ingreso.");
            return false;
        }

        if (ultimo.getTipo().equals("EGRESO")) {
            if (producto.ingresarStock(ultimo.getCantidad())) {
                System.out.println("Se deshizo el egreso.");
                return true;
            }
            System.out.println("No se pudo deshacer el egreso.");
            return false;
        }

        if (ultimo.getTipo().equals("TRANSFERENCIA")) {
            producto.setUbicacion(ultimo.getDetalle());
            System.out.println("Se deshizo la transferencia.");
            return true;
        }

        return false;
    }

    public void mostrarProductosCriticos() {
        ListaProductos lista;

        arbolStock.construirDesdeDiccionario(productos);
        lista = arbolStock.obtenerCriticos();
        lista.mostrar();
    }

    public boolean registrarPedido(int numeroPedido, int codigoProducto, int cantidadSolicitada) {
        Producto producto = productos.buscar(codigoProducto);
        Pedido pedido;

        if (numeroPedido <= 0) {
            System.out.println("Número de pedido inválido.");
            return false;
        }

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return false;
        }

        if (cantidadSolicitada <= 0) {
            System.out.println("Cantidad inválida.");
            return false;
        }

        if (producto.getStock() < cantidadSolicitada) {
            System.out.println("No hay stock suficiente para ese pedido.");
            return false;
        }

        pedido = new Pedido(numeroPedido, codigoProducto, cantidadSolicitada);
        pedidos.encolar(pedido);
        return true;
    }

    public void verPedidosPendientes() {
        pedidos.mostrar();
    }

    public void procesarSiguientePedido() {
        Pedido pedido = pedidos.verFrente();

        if (pedido == null) {
            System.out.println("No hay pedidos para procesar.");
            return;
        }

        if (egresarMercaderia(pedido.getCodigoProducto(), pedido.getCantidadSolicitada())) {
            pedidos.desencolar();
            System.out.println("Pedido procesado: " + pedido);
        } else {
            System.out.println("No se pudo procesar el pedido: " + pedido);
        }
    }

    public void agregarUbicacion(String ubicacion) {
        grafo.agregarUbicacion(ubicacion);
    }

    public void conectarUbicaciones(String origen, String destino) {
        grafo.conectarUbicaciones(origen, destino);
    }

    public void mostrarMapaDeposito() {
        grafo.mostrarMatriz();
    }

    public void mostrarRutaHastaProducto(String origen, int codigoProducto) {
        Producto producto = productos.buscar(codigoProducto);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        grafo.mostrarRutaMasCorta(origen, producto.getUbicacion());
    }

    public void generarReporteGeneral() {
        System.out.println("===== REPORTE GENERAL =====");
        System.out.println("Productos registrados:");
        mostrarProductos();
        System.out.println();
        System.out.println("Productos críticos:");
        mostrarProductosCriticos();
        System.out.println();
        System.out.println("Pedidos pendientes:");
        verPedidosPendientes();
        System.out.println();
        System.out.println("Historial de movimientos:");
        verHistorial();
    }
}
