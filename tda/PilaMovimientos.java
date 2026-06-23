package tda;

import model.Movimiento;

public class PilaMovimientos {

    // Arreglo donde se van guardando los movimientos
    private Movimiento[] pila;

    // Marca la posición del último elemento cargado en la pila
    private int tope;

    public PilaMovimientos(int tamanio) {
        // Creo la pila con el tamaño que me pasen
        pila = new Movimiento[tamanio];

        // Empieza en -1 porque al principio no hay nada cargado
        tope = -1;
    }

    public boolean estaVacia() {
        // Si el tope está en -1, significa que no hay movimientos
        return tope == -1;
    }

    public boolean estaLlena() {
        // Si el tope llegó a la última posición del arreglo, ya no entra nada más
        return tope == pila.length - 1;
    }

    public void apilar(Movimiento movimiento) {
        // Primero controlo si la pila está llena
        if (estaLlena()) {
            System.out.println("Pila llena");
            return;
        }

        // Subo el tope para apuntar a la nueva posición libre
        tope++;

        // Guardo el movimiento en esa posición
        pila[tope] = movimiento;
    }

    public Movimiento desapilar() {
        Movimiento aux;

        // Si está vacía, no hay nada para sacar
        if (estaVacia()) {
            return null;
        }

        // Guardo en una variable auxiliar el movimiento que está en el tope
        aux = pila[tope];

        // Bajo el tope porque ese movimiento ya se sacó
        tope--;

        // Devuelvo el movimiento eliminado
        return aux;
    }

    public void mostrar() {
        int i;

        // Si no hay movimientos, aviso y corto
        if (estaVacia()) {
            System.out.println("No hay movimientos");
            return;
        }

        // Recorro desde el tope hacia abajo para mostrar la pila de arriba hacia abajo
        for (i = tope; i >= 0; i--) {
            System.out.println(pila[i]);
        }
    }
}
    }
}
