/*Creado por:Lic.Melissa Jiménez | Curso BEDU+Tecnolochicas |Sesión Uno*/

package Sesion_3.Reto1;

public class Pasajero {
    private String nombre;
    private String pasaporte;

    public Pasajero(String nombre, String pasaporte) {
        this.nombre = nombre;
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPasaporte() {
        return pasaporte;
    }
}
