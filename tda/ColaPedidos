package tda;

import model.Pedido;

public class ColaPedidos {

    private Pedido[] cola;
    private int frente;
    private int fin;
    private int cantidad;

    public ColaPedidos(int capacidad) {
        cola = new Pedido[capacidad];
        frente = 0;
        fin = -1;
        cantidad = 0;
    }

    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == cola.length;
    }

    public void encolar(Pedido pedido) {
        if (estaLlena()) {
            System.out.println("La cola de pedidos está llena.");
            return;
        }

        fin = (fin + 1) % cola.length;
        cola[fin] = pedido;
        cantidad++;
    }

    public Pedido desencolar() {
        Pedido aux;

        if (estaVacia()) {
            return null;
        }

        aux = cola[frente];
        frente = (frente + 1) % cola.length;
        cantidad--;

        return aux;
    }

    // Sirve para mirar el primer pedido sin sacarlo de la cola
    public Pedido verFrente() {
        if (estaVacia()) {
            return null;
        }

        return cola[frente];
    }

    public void mostrar() {
        int i;
        int pos;

        if (estaVacia()) {
            System.out.println("No hay pedidos pendientes.");
            return;
        }

        for (i = 0; i < cantidad; i++) {
            pos = (frente + i) % cola.length;
            System.out.println(cola[pos]);
        }
    }
}
