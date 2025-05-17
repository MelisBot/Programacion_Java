/*Creado por:Lic.Melissa Jiménez | Curso BEDU+Tecnolochicas |Sesión Dos*/
package Sesion_2.Reto2;
import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        var saldo = 1000.0;// variable inferida por java por lo que usamos var
        int opcion;//variable para guardar la opcion del usuario

        System.out.println("Bienvenido al cajero automático");

        while(true){
            //Mostrar menu
            System.out.println("´\nSelecciona una opción");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();

            //Queremos un menu asi que switch es una buena opcion
            switch (opcion) {
                case 1: // Consultar saldo
                    System.out.printf("Su saldo actual es: $%.2f%n", saldo);
                    break;

                case 2: // Depositar dinero
                    System.out.print("Ingrese el monto a depositar: ");
                    var montoDeposito = scanner.nextDouble();

                    if (montoDeposito <= 0) {
                        System.out.println("Error: El monto debe ser positivo");
                        continue;
                    }

                    saldo += montoDeposito;
                    System.out.printf("Depósito exitoso. Nuevo saldo: $%.2f%n", saldo);
                    break;

                case 3: // Retirar dinero
                    System.out.print("Ingrese el monto a retirar: ");
                    var montoRetiro = scanner.nextDouble();

                    if (montoRetiro <= 0) {
                        System.out.println("Error: El monto debe ser positivo");
                        continue;
                    }

                    if (montoRetiro > saldo) {
                        System.out.println("Error: Saldo insuficiente");
                        continue;
                    }

                    saldo -= montoRetiro;
                    System.out.printf("Retiro exitoso. Nuevo saldo: $%.2f%n", saldo);
                    break;

                case 4: // Salir
                    System.out.println("Gracias por usar nuestro cajero automático. ¡Hasta pronto!");
                    scanner.close();
                    return; // Termina el programa

                default: // Opción inválida
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 4.");
                    continue;
            }
        }
    }
}
