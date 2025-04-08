//Creado por Melissa Jiménez González
package Reto1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Llamamos a la clase Paciente
        Paciente  paciente = new Paciente();

        /*Usaremos el manejo de Excepciones para capturar los errores al recibir datos
        inesperados, en java se usa try-catch*/
        try{
            //Nombre paciente
            System.out.println("Ingresa el nombre del paciente: ");
            paciente.paciente = scanner.nextLine();
            //aqui podemos agregar una condicion para que solo reciba datos de tipo string

            //Número de expediente
            System.out.println("Ingresa el Número de expediente: ");
            paciente.expediente = scanner.nextLine();

            //Edad paciente
            System.out.println("Ingresa la edad del paciente: ");
            paciente.edad = scanner.nextInt();

            System.out.println("La informacion del Paciente es la siguiente: ");
            paciente.mostrarInformacion(); //Se llama al metodo para ser impreso

        }catch (InputMismatchException e){
            System.out.println("La edad debe ser un número entero.");
        }catch (Exception e) {
            System.out.println("Error inesperado: "+ e.getMessage());//Captura el mensaje de error
        }//fin try-catch
        scanner.close();//Cerramos el scanner
    }
}