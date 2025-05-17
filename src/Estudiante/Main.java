/*Creado por:Lic.Melissa Jiménez | Curso BEDU+Tecnolochicas*/
package Estudiante;

public class Main {
    public static void main(String[] args) {
        /*Crear mis objetos
        1. Clase
        2. Identificador
        3. new + constructor
        * */

        Estudiante estudiante1 = new Estudiante();
        //Atributos
        estudiante1.nombre = "Melissa Jiménez González";
        estudiante1.edad = 23;
        //Metodos
        estudiante1.saludar();
    }
}