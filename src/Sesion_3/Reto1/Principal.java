package Sesion_3.Reto1;

public class Principal {
    public static void main(String[] args){
        Pasajero pasajero1 = new Pasajero("Ana Martínez", "P123456");
        Vuelo vuelo = new Vuelo("UX123", "París", "14:30");

        // Reservar asiento
        if (vuelo.reservarAsiento(pasajero1)) {
            System.out.println("✅ Reserva realizada con éxito.\n");
        }

        // Mostrar itinerario
        System.out.println(vuelo.obtenerItinerario());

        // Cancelar reserva
        System.out.println("❌ Cancelando reserva...\n");
        vuelo.cancelarReserva();

        // Mostrar itinerario nuevamente
        System.out.println(vuelo.obtenerItinerario());

        // Reservar asiento usando nombre y pasaporte
        vuelo.reservarAsiento("Mario Gonzalez", "P987654");

        // Mostrar itinerario final
        System.out.println(vuelo.obtenerItinerario());
    }
}
