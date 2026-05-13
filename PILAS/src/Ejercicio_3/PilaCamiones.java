package Ejercicio_3;

public class PilaCamiones {

     private Camion tope;

    public PilaCamiones() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Camion nuevo) {

        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Camion pop() {

        if (estaVacia()) {
            return null;
        }

        Camion aux = tope;
        tope = tope.siguiente;
        aux.siguiente = null;

        return aux;
    }

    public void imprimir() {

        if (estaVacia()) {
            System.out.println("Pila vacia.");
            return;
        }

        Camion actual = tope;

        while (actual != null) {

            if (actual == tope) {
                System.out.print("TOPE -> ");
            }

            else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }
    }

    public double calcularCargaTotal() {

        double suma = 0;

        PilaCamiones auxiliar = new PilaCamiones();

        while (!estaVacia()) {

            Camion retirado = pop();

            suma += retirado.cargaToneladas;

            auxiliar.push(retirado);
        }

        while (!auxiliar.estaVacia()) {

            push(auxiliar.pop());
        }

        return suma;
    }
}
