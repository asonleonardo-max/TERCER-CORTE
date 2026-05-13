package Ejercicio_5;

public class PilaEstaciones {
    
    private Estacion tope;

    public PilaEstaciones() {
        this.tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void push(Estacion nueva) {

        nueva.siguiente = tope;
        tope = nueva;
    }

    public Estacion pop() {

        if (estaVacia()) {
            return null;
        }

        Estacion aux = tope;
        tope = tope.siguiente;
        aux.siguiente = null;

        return aux;
    }

    public void imprimir() {

        if (estaVacia()) {

            System.out.println("Pila vacia.");
            return;
        }

        Estacion actual = tope;

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

    public void retrocederASuperficie() {

        if (estaVacia()) {

            System.out.println("No hay estaciones registradas.");
            return;
        }

        System.out.println("Iniciando regreso a la superficie...\n");

        while (!estaVacia()) {

            Estacion retirada = pop();

            System.out.println("Retrocediendo por:");
            System.out.println(retirada.nombrePunto);

            if (retirada.nivelOxigeno < 18) {

                System.out.println("ALERTA: Uso de Tanque de Emergencia Requerido");
            }

            System.out.println();
        }

        System.out.println("El equipo ha salido de la cueva.");
    }
}
