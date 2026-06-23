
package view;

import java.util.Scanner;
import model.Producto;
import service.Inventario;

public class Main2 {

    static Scanner teclado = new Scanner(System.in);
    static Inventario inventario = new Inventario(100, 100, 100, 50);

    public static void main(String[] args) {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n=================================");
            System.out.println(" SISTEMA DE GESTION DE INVENTARIO");
            System.out.println("=================================");
            System.out.println("1. Gestion de Productos");
            System.out.println("2. Gestion de Stock");
            System.out.println("3. Gestion de Pedidos");
            System.out.println("4. Deposito");
            System.out.println("5. Reportes");
            System.out.println("0. Salir");

            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    menuProductos();
                    break;

                case 2:
                    menuStock();
                    break;

                case 3:
                    menuPedidos();
                    break;

                case 4:
                    menuDeposito();
                    break;

                case 5:
                    menuReportes();
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    public static void menuProductos() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== PRODUCTOS =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("0. Volver");

            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    registrarProducto();
                    break;

                case 2:
                    buscarProducto();
                    break;

                case 3:
                    inventario.mostrarProductos();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    public static void menuStock() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== STOCK =====");
            System.out.println("1. Ingresar mercaderia");
            System.out.println("2. Egresar mercaderia");
            System.out.println("3. Transferir producto");
            System.out.println("4. Ver historial");
            System.out.println("5. Deshacer ultimo movimiento");
            System.out.println("0. Volver");

            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    ingresarMercaderia();
                    break;

                case 2:
                    egresarMercaderia();
                    break;

                case 3:
                    transferirProducto();
                    break;

                case 4:
                    inventario.verHistorial();
                    break;

                case 5:
                    inventario.deshacerUltimoMovimiento();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    public static void menuPedidos() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== PEDIDOS =====");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Ver pedidos pendientes");
            System.out.println("3. Procesar siguiente pedido");
            System.out.println("0. Volver");

            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    registrarPedido();
                    break;

                case 2:
                    inventario.verPedidosPendientes();
                    break;

                case 3:
                    inventario.procesarSiguientePedido();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    public static void menuDeposito() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== DEPOSITO =====");
            System.out.println("1. Agregar ubicacion");
            System.out.println("2. Conectar ubicaciones");
            System.out.println("3. Mostrar mapa");
            System.out.println("4. Mostrar ruta hasta producto");
            System.out.println("0. Volver");

            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    agregarUbicacion();
                    break;

                case 2:
                    conectarUbicaciones();
                    break;

                case 3:
                    inventario.mostrarMapaDeposito();
                    break;

                case 4:
                    mostrarRuta();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    public static void menuReportes() {

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== REPORTES =====");
            System.out.println("1. Productos criticos");
            System.out.println("2. Reporte general");
            System.out.println("0. Volver");

            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:
                    inventario.mostrarProductosCriticos();
                    break;

                case 2:
                    inventario.generarReporteGeneral();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }
        }
    }

    public static void registrarProducto() {

        System.out.print("Codigo: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.print("Stock inicial: ");
        int stock = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Ubicacion: ");
        String ubicacion = teclado.nextLine();

        System.out.print("Stock minimo: ");
        int stockMinimo = teclado.nextInt();
        teclado.nextLine();

        if (inventario.registrarProducto(codigo, nombre, stock, ubicacion, stockMinimo)) {
            System.out.println("Producto registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el producto.");
        }
    }

    public static void buscarProducto() {

        System.out.print("Codigo: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        Producto encontrado = inventario.buscarProducto(codigo);

        if (encontrado != null) {
            System.out.println(encontrado);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void ingresarMercaderia() {

        System.out.print("Codigo producto: ");
        int codigo = teclado.nextInt();

        System.out.print("Cantidad: ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        if (inventario.ingresarMercaderia(codigo, cantidad)) {
            System.out.println("Ingreso registrado.");
        } else {
            System.out.println("No se pudo registrar el ingreso.");
        }
    }

    public static void egresarMercaderia() {

        System.out.print("Codigo producto: ");
        int codigo = teclado.nextInt();

        System.out.print("Cantidad: ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        if (inventario.egresarMercaderia(codigo, cantidad)) {
            System.out.println("Egreso registrado.");
        } else {
            System.out.println("No se pudo registrar el egreso.");
        }
    }

    public static void transferirProducto() {

        System.out.print("Codigo producto: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Nueva ubicacion: ");
        String ubicacion = teclado.nextLine();

        if (inventario.transferirProducto(codigo, ubicacion)) {
            System.out.println("Transferencia realizada.");
        } else {
            System.out.println("No se pudo realizar la transferencia.");
        }
    }

    public static void registrarPedido() {

        System.out.print("Numero pedido: ");
        int numeroPedido = teclado.nextInt();

        System.out.print("Codigo producto: ");
        int codigo = teclado.nextInt();

        System.out.print("Cantidad: ");
        int cantidad = teclado.nextInt();
        teclado.nextLine();

        if (inventario.registrarPedido(numeroPedido, codigo, cantidad)) {
            System.out.println("Pedido registrado.");
        } else {
            System.out.println("No se pudo registrar el pedido.");
        }
    }

    public static void agregarUbicacion() {

        System.out.print("Ubicacion: ");
        String ubicacion = teclado.nextLine();

        inventario.agregarUbicacion(ubicacion);
    }

    public static void conectarUbicaciones() {

        System.out.print("Origen: ");
        String origen = teclado.nextLine();

        System.out.print("Destino: ");
        String destino = teclado.nextLine();

        inventario.conectarUbicaciones(origen, destino);
    }

    public static void mostrarRuta() {

        System.out.print("Ubicacion origen: ");
        String origen = teclado.nextLine();

        System.out.print("Codigo producto: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        inventario.mostrarRutaHastaProducto(origen, codigo);
    }
}
