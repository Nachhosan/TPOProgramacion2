import ch.Movimiento;
import ch.PilaMovimientos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Scanner para leer los datos ingresados por el usuario
        Scanner teclado = new Scanner(System.in);

        // Estructuras principales del sistema
        Inventario inventario = new Inventario(100);
        PilaMovimientos historial = new PilaMovimientos(100);

        // Variable utilizada para controlar el menú
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Ingreso mercaderia");
            System.out.println("5. Egreso mercaderia");
            System.out.println("6. Ver movimientos");
            System.out.println("0. Salir");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    // Se solicitan los datos del producto
                    System.out.print("Codigo: ");
                    int codigo = teclado.nextInt();

                    teclado.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Stock: ");
                    int stock = teclado.nextInt();

                    teclado.nextLine();

                    System.out.print("Ubicacion: ");
                    String ubicacion = teclado.nextLine();

                    // Se crea el producto y se agrega al inventario
                    Producto producto =
                            new Producto(codigo, nombre, stock, ubicacion);

                    inventario.agregarProducto(producto);

                    System.out.println("Producto agregado correctamente.");

                    break;

                case 2:

                    // Búsqueda de producto por código
                    System.out.print("Codigo: ");
                    codigo = teclado.nextInt();

                    Producto encontrado =
                            inventario.buscarProducto(codigo);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }

                    break;

                case 3:

                    // Muestra todos los productos registrados
                    inventario.mostrarProductos();

                    break;

                case 4:

                    // Registro de ingreso de mercadería
                    System.out.print("Codigo producto: ");
                    codigo = teclado.nextInt();

                    Producto p1 =
                            inventario.buscarProducto(codigo);

                    if (p1 != null) {

                        System.out.print("Cantidad a ingresar: ");
                        int cantidad = teclado.nextInt();

                        p1.setStock(p1.getStock() + cantidad);

                        // Se guarda el movimiento en la pila
                        historial.apilar(
                                new Movimiento(
                                        codigo,
                                        "INGRESO",
                                        cantidad
                                )
                        );

                        System.out.println("Ingreso registrado.");
                    }

                    break;

                case 5:

                    // Registro de salida de mercadería
                    System.out.print("Codigo producto: ");
                    codigo = teclado.nextInt();

                    Producto p2 =
                            inventario.buscarProducto(codigo);

                    if (p2 != null) {

                        System.out.print("Cantidad a retirar: ");
                        int cantidad = teclado.nextInt();

                        if (cantidad <= p2.getStock()) {

                            p2.setStock(
                                    p2.getStock() - cantidad
                            );

                            // Se registra la salida en el historial
                            historial.apilar(
                                    new Movimiento(
                                            codigo,
                                            "EGRESO",
                                            cantidad
                                    )
                            );

                            System.out.println("Egreso registrado.");

                        } else {

                            System.out.println("Stock insuficiente.");
                        }
                    }

                    break;

                case 6:

                    // Muestra los movimientos realizados
                    historial.mostrar();

                    break;

                case 0:

                    System.out.println("Programa finalizado.");

                    break;

                default:

                    System.out.println("Opcion invalida.");
            }
        }
    }
}