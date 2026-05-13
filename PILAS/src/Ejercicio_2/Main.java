/*Control de Calidad (Línea de Ensamblaje)
Un brazo robótico en una fábrica de motores apila componentes siguiendo una secuencia precisa. Un sensor de visión 
artificial inspecciona cada pieza después de ser colocada.

La Clase Pieza (Nodo): Debe contener nombrePieza (String), numeroSerie (String) y esDefectuosa (boolean).
El Problema: Si el sensor detecta una pieza defectuosa, la línea de producción debe detenerse inmediatamente.
Reto: Crea un método limpiarHastaDefecto() que extraiga (pop) todas las piezas de la pila hasta encontrar la primera 
que tenga esDefectuosa = true. El método debe imprimir el nombre de todas las piezas "buenas" que tuvieron que ser retiradas y 
descartadas antes de llegar a la pieza fallida.*/

package Ejercicio_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PilaPiezas linea = new PilaPiezas();
        Scanner scanner = new Scanner(System.in);

        linea.push(new Pieza("Motor", "SER-001", false));
        linea.push(new Pieza("Piston", "SER-002", false));
        linea.push(new Pieza("Valvula", "SER-003", false));
        linea.push(new Pieza("Tornillo", "SER-004", true));
        linea.push(new Pieza("Filtro", "SER-005", false));

        int opcion;

        do {

            System.out.println("\n--- CONTROL DE CALIDAD ---");
            System.out.println("1. Ver pila");
            System.out.println("2. Agregar pieza");
            System.out.println("3. Retirar pieza");
            System.out.println("4. Limpiar hasta defecto");
            System.out.println("5. Salir");

            System.out.print("Seleccione: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    linea.imprimir();
                    break;

                case 2:

                    System.out.print("Nombre pieza: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Numero serie: ");
                    String serie = scanner.nextLine();

                    System.out.print("Es defectuosa (true/false): ");
                    boolean defecto = scanner.nextBoolean();

                    linea.push(new Pieza(nombre, serie, defecto));

                    System.out.println("Pieza agregada.");
                    break;

                case 3:

                    Pieza retirada = linea.pop();

                    if (retirada != null) {
                        System.out.println("Se retiro:");
                        System.out.println(retirada);
                    }

                    else {
                        System.out.println("Pila vacia.");
                    }

                    break;

                case 4:

                    linea.limpiarHastaDefecto();
                    break;

                case 5:

                    System.out.println("Saliendo...");
                    break;

                default:

                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
    
}
