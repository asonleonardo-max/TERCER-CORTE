package Ejercicio_4;

public class PilaMedicamentos {
    
    private Medicamento tope;

    public PilaMedicamentos() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Medicamento nuevo) {

        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Medicamento pop() {

        if (estaVacia()) {
            return null;
        }

        Medicamento aux = tope;
        tope = tope.siguiente;
        aux.siguiente = null;

        return aux;
    }

    public Medicamento peek() {
        return tope;
    }

    public void imprimir() {

        if (estaVacia()) {
            System.out.println("Pila vacia.");
            return;
        }

        Medicamento actual = tope;

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

    public void validarDespacho() {

        if (estaVacia()) {

            System.out.println("No hay medicamentos.");
            return;
        }

        while (!estaVacia() && peek().diasParaVencer < 10) {

            Medicamento vencido = pop();

            System.out.println("Medicamento retirado por vencimiento:");
            System.out.println(vencido);
        }

        if (estaVacia()) {

            System.out.println("No quedaron medicamentos seguros.");
        }

        else {

            System.out.println("Medicamento seguro para despacho:");
            System.out.println(peek());
        }
    }
}
