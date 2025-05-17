/*Creado por:Lic.Melissa Jiménez | Curso BEDU+Tecnolochicas |Sesión Dos*/
package Sesion_2.Reto1;
import java.util.Scanner;

public class SimuladorFarmacia {
    public static void main(String[] args) {
        //Usamo Scanner para recibir entras por consola
        Scanner scanner = new Scanner(System.in);

        //Declarión  de las variables
        String nombre;
        double precio;
        int cantidad;


        //Pedir al usuario los valores
        System.out.println("Ingresa el nombre del medicamento: ");
        nombre = scanner.nextLine();
        System.out.println("Ingresa el precio unitario del producto: ");
        precio = scanner.nextDouble();
        System.out.println("Ingresa la cantidad del producto a llevar: ");
        cantidad = scanner.nextInt();

        //Calculamos el total sin descuento
        double total = (cantidad * precio);

        // Descuento si el total supera $150
        boolean aplicaDescuento = total > 500;

        // Asignación del descuento (15%)
        double descuento = aplicaDescuento ? total * 0.15 : 0;

        // Cálculo final
        double totalFinal = total - descuento;

        /*Podemos reducir estas lineas como
        double descuento = total > 500 ? total * 0.15 : 0;
        double totalFinal = total - descuento;
        * */

        //Imprime los  resultados
        System.out.println("Medicamento: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precio);
        System.out.println("Total sin descuento: $" + total);
        System.out.println("¿Aplica descuento?: " + aplicaDescuento);
        //System.out.println("¿Aplica descuento?: " + (descuento > 0));
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total a pagar: $" + totalFinal);

        scanner.close();//Finalizamos el scanner
    }
}
