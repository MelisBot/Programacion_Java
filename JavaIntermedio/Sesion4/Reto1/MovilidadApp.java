package Sesion4.Reto1;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    private static final Random random = new Random();

    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Calculando ruta...");
            try {
                // Simular latencia de 2-3 segundos
                TimeUnit.MILLISECONDS.sleep(2000 + random.nextInt(1000));
                
                // Simular posible error (10% de probabilidad)
                if (random.nextDouble() < 0.1) {
                    throw new RuntimeException("Error en el cálculo de ruta");
                }
                
                return "Ruta: Centro -> Norte";
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupción en cálculo de ruta", e);
            }
        });
    }

    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💰 Estimando tarifa...");
            try {
                // Simular latencia de 1-2 segundos
                TimeUnit.MILLISECONDS.sleep(1000 + random.nextInt(1000));
                
                // Simular posible error (10% de probabilidad)
                if (random.nextDouble() < 0.1) {
                    throw new RuntimeException("Error en estimación de tarifa");
                }
                
                return 75.50 + random.nextDouble() * 20; // Variación en tarifa
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupción en estimación de tarifa", e);
            }
        });
    }

    public void procesarViaje() {
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) -> {
            String rutaLimpia = ruta.replace("Ruta: ", "");
            return String.format("✅ 🚗 Ruta calculada: %s | Tarifa estimada: $%.2f", 
                               rutaLimpia, tarifa);
        })
        .exceptionally(ex -> {
            System.err.println("❌ Error en el procesamiento: " + ex.getMessage());
            return "⚠️ No se pudo completar la solicitud de viaje. Por favor intente nuevamente.";
        })
        .thenAccept(System.out::println)
        .join(); // Solo para el ejemplo (en aplicación real no usar join)
    }

    public static void main(String[] args) {
        MovilidadApp app = new MovilidadApp();
        app.procesarViaje();
    }
}