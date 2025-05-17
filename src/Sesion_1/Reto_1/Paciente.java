/*Creado por:Lic.Melissa Jiménez | Curso BEDU+Tecnolochicas |Sesión Uno*/
package Sesion_1.Reto_1;
public class Paciente {
    // Atributos a utilizar
    String paciente;
    String expediente;
    int edad;


    //Creamos el metodo publico para mostrar la informacion
    public void mostrarInformacion(){
        System.out.println("Paciente: "+ paciente);
        System.out.println("Edad: "+ edad);
        System.out.println("Expediente: "+ expediente);
    }//fin metodo mostrarInformacion
}//fin clase paciente