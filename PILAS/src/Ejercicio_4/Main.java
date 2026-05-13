/*Farmacia Automatizada (Dispensador Tubo LIFO)
En una farmacia de alta tecnología, los medicamentos de alta rotación se almacenan en tubos dispensadores verticales. 
El personal introduce las cajas por la parte superior y las retira de la misma forma (el último lote en llegar es el primero en ser despachado).

La Clase Medicamento (Nodo): Debe contener nombre (String), lote (String) y diasParaVencer (int).
El Problema: Por norma de seguridad, no se puede despachar un medicamento si le quedan menos de 10 días para vencer.
Reto: Implementa un método validarDespacho() que revise el medicamento en el tope. Si está a punto de vencer, debe ser 
retirado automáticamente y el sistema debe revisar el siguiente. El proceso se repite hasta que el tope sea un medicamento 
seguro o la pila quede vacía.*/

package Ejercicio_4;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        PilaMedicamentos farmacia = new PilaMedicamentos();

        Scanner scanner = new Scanner(System.in);

        farmacia.push(new Medicamento("Acetaminofen", "LOT-001", 30));
        farmacia.push(new Medicamento("Ibuprofeno", "LOT-002", 5));
        farmacia.push(new Medicamento("Amoxicilina", "LOT-003", 3));
        farmacia.push(new Medicamento("Loratadina", "LOT-004", 20));

        int opcion;

        do {

            System.out.println("\n--- FARMACIA AUTOMATIZADA ---");
            System.out.println("1. Ver medicamentos");
            System.out.println("2. Agregar medicamento");
            System.out.println("3. Retirar medicamento");
            System.out.println("4. Validar despacho");
            System.out.println("5. Salir");

            System.out.print("Seleccione: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    farmacia.imprimir();
                    break;

                case 2:

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Lote: ");
                    String lote = scanner.nextLine();

                    System.out.print("Dias para vencer: ");
                    int dias = scanner.nextInt();

                    farmacia.push(new Medicamento(nombre, lote, dias));

                    System.out.println("Medicamento agregado.");
                    break;

                case 3:

                    Medicamento retirado = farmacia.pop();

                    if (retirado != null) {

                        System.out.println("Medicamento retirado:");
                        System.out.println(retirado);
                    }

                    else {

                        System.out.println("Pila vacia.");
                    }

                    break;

                case 4:

                    farmacia.validarDespacho();
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
