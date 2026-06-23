package tda;

import model.Movimiento;

public class PilaMovimientos {

    private Movimiento[] pila;
    private int tope;

    public PilaMovimientos(int tamanio) {
        pila = new Movimiento[tamanio];
        tope = -1;
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == pila.length - 1;
    }

    public void apilar(Movimiento movimiento) {
        if (estaLlena()) {
            System.out.println("Pila llena");
            return;
        }

        tope++;
        pila[tope] = movimiento;
    }

    public Movimiento desapilar() {
        Movimiento aux;

        if (estaVacia()) {
            return null;
        }

        aux = pila[tope];
        tope--;
        return aux;
    }

    public void mostrar() {
        int i;

        if (estaVacia()) {
            System.out.println("No hay movimientos");
            return;
        }

        for (i = tope; i >= 0; i--) {
            System.out.println(pila[i]);
        }
    }
}