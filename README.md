Sistema Inteligente de Gestión de Stock para un Centro Logístico
Integrantes
Marcos Romero
Santiago Vásquez
Leandro Velázquez
Alternativa Elegida

Sistema Inteligente de Gestión de Stock para un Centro Logístico.

Descripción del Proyecto

El proyecto consiste en desarrollar un sistema que permita gestionar el stock de productos almacenados en un centro logístico. El objetivo es facilitar el control de inventario, la localización de productos, el registro de movimientos y la administración de mercadería dentro del depósito.

Actualmente muchas empresas presentan dificultades para mantener actualizado el stock, localizar productos rápidamente y registrar correctamente los movimientos de entrada y salida de mercadería. Este sistema busca brindar una solución informática para mejorar dichos procesos.

Estructuras de Datos Utilizadas
Arreglo de Productos

Se utiliza para almacenar los productos registrados dentro del inventario.

Pila de Movimientos


Lista de Productos

Representada mediante el arreglo principal utilizado por la clase Inventario.

Funcionalidades Implementadas en esta Segunda Etapa
Gestión de Productos
Registro de nuevos productos.
Almacenamiento de código, nombre, stock y ubicación.
Consulta de productos mediante código único.
Visualización de productos registrados.
Gestión de Stock
Registro de ingreso de mercadería.
Registro de egreso de mercadería.
Actualización automática del stock disponible.
Validación de stock suficiente antes de realizar un egreso.
Historial de Movimientos
Registro de movimientos de ingreso.
Registro de movimientos de egreso.
Visualización del historial almacenado en una pila.
Menú de Prueba

Se implementó una interfaz por consola para demostrar el funcionamiento del sistema y permitir la interacción con las funcionalidades desarrolladas.

Clases Implementadas
Producto.java

Representa los productos almacenados en el depósito. Contiene información sobre código, nombre, stock y ubicación.

Inventario.java

Administra el conjunto de productos registrados. Permite agregar, buscar y mostrar productos.

Movimiento.java

Representa una operación realizada sobre un producto, ya sea ingreso o egreso de mercadería.

PilaMovimientos.java

Gestiona el historial de movimientos utilizando una implementación propia de pila basada en arreglos.

Main.java

Contiene el menú principal y coordina la interacción entre todas las clases del sistema.

Actividades Realizadas por Cada Integrante

Marcos Romero
Desarrollo de la clase Producto.
Desarrollo de la clase Inventario.
Implementación del menú principal.

Santiago Vásquez
Desarrollo de la clase Movimiento.
Pruebas de funcionamiento del sistema.
Validación de operaciones de stock.

Leandro Velázquez
Desarrollo de la clase PilaMovimientos.
Implementación del historial de movimientos.
Integración de las funcionalidades implementadas.
