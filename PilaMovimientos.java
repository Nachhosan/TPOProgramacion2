public class PilaMovimientos {
    private Movimiento[] pila;
    private int tope;

    //El constructo para crear la pila con el tamaño indicado
    public PilaMovimientos(int tamanio){
        pila=new Movimiento[tamanio];
        tope=-1; //esto significa que la pila esta vacia
    }

    //Agrega un movimiento al tope con el tamaño indicado
    public void apilar(Movimiento movimiento){
        if (tope==pila.lenght-1){
            System.out.println("Pila llena");
            return;
        }
        //Avanza el tope y guarda el movimiento
        tope++;
        pila[tope]=movimiento;
    }

    //Eliminara y devolvera el movimiento que esta en el tope
    public Movimiento desapilar(){
        //Si la pila esta vacia, devuelve nulo
        if (tope==-1){
            return null;
        }
        //Guarada el movimiento del tope y lo recuce para eliminarlo de la pila
        Movimiento aux=pila[tope];
        tope--;
        return aux;
    }

    //Muestra todos los movimiento de la pila
    public void mostrar(){
        //Verifica si la pila esta vacia
        if(tope==-1){
            System.out.println("No hay movimiento");
            return;
        }
        //Recorrera la pila desde el tope hasta la base
        for (int i=tope;i>=0;i--){
            System.out.println(pila[i]);
        }
    }
}
