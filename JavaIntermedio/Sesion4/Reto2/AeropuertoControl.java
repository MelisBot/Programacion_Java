package Sesion4.Reto2;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class AeropuertoControl {
    private final List<ServicioVerificacion> servicios;

    public AeropuertoControl() {
        this.servicios = List.of(
            new VerificacionPista(),
            new VerificacionClima(),
            new VerificacionTrafico(),
            new VerificacionPersonal()
        );
    }

    public void verificarCondicionesAterrizaje() {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");
        
        List<CompletableFuture<Boolean>> verificaciones = servicios.stream()
            .map(ServicioVerificacion::verificar)
            .collect(Collectors.toList());

        CompletableFuture<Void> todasVerificaciones = CompletableFuture.allOf(
            verificaciones.toArray(new CompletableFuture[0])
        );
        
        todasVerificaciones.thenRun(() -> {
            try {
                boolean todasOptimas = verificaciones.stream()
                    .allMatch(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            return false;
                        }
                    });
                
                if (todasOptimas) {
                    System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                } else {
                    System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                }
            } catch (Exception e) {
                System.out.println("\n🚫 Aterrizaje denegado: error en verificación - " + e.getMessage());
            }
        }).join();
    }

    public static void main(String[] args) {
        AeropuertoControl control = new AeropuertoControl();
        control.verificarCondicionesAterrizaje();
    }
}