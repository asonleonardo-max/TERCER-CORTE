package Ejercicio_2;

public class PilaPiezas {
    
    private Pieza tope;

    public PilaPiezas() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Pieza nueva) {
        nueva.siguiente = tope;
        tope = nueva;
    }

    public Pieza pop() {

        if (estaVacia()) {
            return null;
        }

        Pieza aux = tope;
        tope = tope.siguiente;
        aux.siguiente = null;

        return aux;
    }

    public void imprimir() {

        if (estaVacia()) {
            System.out.println("Pila vacia.");
            return;
        }

        Pieza actual = tope;

        while (actual != null) {

            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }
    }

    public void limpiarHastaDefecto() {

        if (estaVacia()) {
            System.out.println("La pila esta vacia.");
            return;
        }

        while (!estaVacia()) {

            Pieza retirada = pop();

            if (retirada.esDefectuosa == true) {

                System.out.println("Se encontro la pieza defectuosa:");
                System.out.println(retirada);

                System.out.println("Linea detenida.");
                return;
            }

            else {

                System.out.println("Pieza buena retirada: "
                        + retirada.nombrePieza);
            }
        }

        System.out.println("No habia piezas defectuosas.");
    }
}
