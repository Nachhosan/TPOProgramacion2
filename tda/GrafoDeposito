package tda;

public class GrafoDeposito {

    private String[] vertices;
    private int[][] matriz;
    private int cantidad;

    public GrafoDeposito(int capacidad) {
        vertices = new String[capacidad];
        matriz = new int[capacidad][capacidad];
        cantidad = 0;
    }

    public boolean existeUbicacion(String ubicacion) {
        return obtenerIndice(ubicacion) != -1;
    }

    public void agregarUbicacion(String ubicacion) {
        if (ubicacion == null || ubicacion.trim().equals("")) {
            System.out.println("La ubicación no puede estar vacía.");
            return;
        }

        if (cantidad == vertices.length) {
            System.out.println("No hay espacio para más ubicaciones.");
            return;
        }

        if (existeUbicacion(ubicacion)) {
            System.out.println("La ubicación ya existe.");
            return;
        }

        vertices[cantidad] = ubicacion;
        cantidad++;
    }

    public void conectarUbicaciones(String origen, String destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Una de las ubicaciones no existe.");
            return;
        }

        if (posOrigen == posDestino) {
            System.out.println("No se puede conectar una ubicación consigo misma.");
            return;
        }

        if (matriz[posOrigen][posDestino] == 1) {
            System.out.println("Las ubicaciones ya están conectadas.");
            return;
        }

        matriz[posOrigen][posDestino] = 1;
        matriz[posDestino][posOrigen] = 1;
    }

    private int obtenerIndice(String ubicacion) {
        int i;

        for (i = 0; i < cantidad; i++) {
            if (vertices[i].equalsIgnoreCase(ubicacion)) {
                return i;
            }
        }

        return -1;
    }

    public void mostrarMatriz() {
        int i;
        int j;

        if (cantidad == 0) {
            System.out.println("No hay ubicaciones cargadas en el depósito.");
            return;
        }

        System.out.print("      ");
        for (i = 0; i < cantidad; i++) {
            System.out.print(vertices[i] + " ");
        }
        System.out.println();

        for (i = 0; i < cantidad; i++) {
            System.out.print(vertices[i] + " ");
            for (j = 0; j < cantidad; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void mostrarRutaMasCorta(String origen, String destino) {
        int posOrigen;
        int posDestino;
        boolean[] visitado;
        int[] anterior;
        int[] cola;
        int frente;
        int fin;
        int actual;
        int i;
        int[] camino;
        int cantidadCamino;

        posOrigen = obtenerIndice(origen);
        posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Origen o destino inexistente.");
            return;
        }

        if (posOrigen == posDestino) {
            System.out.println("Ya estás en la ubicación del producto.");
            return;
        }

        visitado = new boolean[cantidad];
        anterior = new int[cantidad];
        cola = new int[cantidad];

        for (i = 0; i < cantidad; i++) {
            anterior[i] = -1;
        }

        frente = 0;
        fin = 0;

        cola[fin] = posOrigen;
        fin++;
        visitado[posOrigen] = true;

        while (frente < fin) {
            actual = cola[frente];
            frente++;

            for (i = 0; i < cantidad; i++) {
                if (matriz[actual][i] == 1 && !visitado[i]) {
                    visitado[i] = true;
                    anterior[i] = actual;
                    cola[fin] = i;
                    fin++;
                }
            }
        }

        if (!visitado[posDestino]) {
            System.out.println("No hay camino entre las ubicaciones.");
            return;
        }

        camino = new int[cantidad];
        cantidadCamino = 0;
        actual = posDestino;

        while (actual != -1) {
            camino[cantidadCamino] = actual;
            cantidadCamino++;
            actual = anterior[actual];
        }

        System.out.println("Ruta más corta:");
        for (i = cantidadCamino - 1; i >= 0; i--) {
            System.out.print(vertices[camino[i]]);
            if (i > 0) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
