/*Logística de Distribución (Callejón sin Salida)
Un centro de logística urbana tiene un muelle de carga ubicado al final de un callejón muy estrecho. 
Los camiones de reparto entran uno tras otro y quedan "atrapados" en el orden de llegada. El último camión en entrar 
debe ser obligatoriamente el primero en salir para permitir que los demás se retiren.

La Clase Camion (Nodo): Debe contener placa (String), conductor (String) y cargaToneladas (double).
El Problema: El supervisor necesita saber cuánta carga total hay en el callejón sin mover los camiones físicamente 
(solo consultando la estructura).
Reto: Implementa un método que recorra la pila (sin destruirla permanentemente, o reconstruyéndola) y calcule 
la suma total de cargaToneladas de todos los camiones estacionados.*/

package Ejercicio_3;

import java.util.Scanner;

public class Main {
    
     public static void main(String[] args) {

        PilaCamiones callejon = new PilaCamiones();

        Scanner scanner = new Scanner(System.in);

        callejon.push(new Camion("ABC-123", "Carlos", 12.5));
        callejon.push(new Camion("DEF-456", "Miguel", 8.2));
        callejon.push(new Camion("GHI-789", "Andres", 15.7));
        callejon.push(new Camion("JKL-321", "Pedro", 10.0));

        int opcion;

        do {

            System.out.println("\n--- LOGISTICA DE DISTRIBUCION ---");
            System.out.println("1. Ver camiones");
            System.out.println("2. Agregar camion");
            System.out.println("3. Retirar camion");
            System.out.println("4. Calcular carga total");
            System.out.println("5. Salir");

            System.out.print("Seleccione: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    callejon.imprimir();
                    break;

                case 2:

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Conductor: ");
                    String conductor = scanner.nextLine();

                    System.out.print("Carga toneladas: ");
                    double carga = scanner.nextDouble();

                    callejon.push(new Camion(placa, conductor, carga));

                    System.out.println("Camion agregado.");
                    break;

                case 3:

                    Camion retirado = callejon.pop();

                    if (retirado != null) {

                        System.out.println("Camion retirado:");
                        System.out.println(retirado);
                    }

                    else {

                        System.out.println("Pila vacia.");
                    }

                    break;

                case 4:

                    double total = callejon.calcularCargaTotal();

                    System.out.println("Carga total en el callejon: "
                            + total + " toneladas");

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
