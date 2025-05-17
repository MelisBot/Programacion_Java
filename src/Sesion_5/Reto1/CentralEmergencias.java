/*Creado por:Lic.Melissa Jiménez | Curso BEDU+Tecnolochicas |Sesión Cinco*/
package Sesion_5.Reto1;

public class CentralEmergencias {
    public static void main(String[] args) {
        Ambulancia ambulancia = new Ambulancia("Ambulancia", new Operador("Juan"));
        Patrulla patrulla = new Patrulla("Patrulla", new Operador("Laura"));
        UnidadBomberos bomberos = new UnidadBomberos("UnidadBomberos", new Operador("Marco"));

        ambulancia.iniciarOperacion();
        patrulla.iniciarOperacion();
        bomberos.iniciarOperacion();
    }
}
