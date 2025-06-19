package Sesion4.Reto2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public abstract class ServicioVerificacion {
    protected final Random random = new Random();
    protected final String nombre;
    protected final double probabilidadExito;
    protected final double probabilidadFallo;

    public ServicioVerificacion(String nombre, double probabilidadExito, double probabilidadFallo) {
        this.nombre = nombre;
        this.probabilidadExito = probabilidadExito;
        this.probabilidadFallo = probabilidadFallo;
    }

    public CompletableFuture<Boolean> verificar() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(2000 + random.nextInt(1000));
                
                if (random.nextDouble() < probabilidadFallo) {
                    throw new RuntimeException("Error en servicio de " + nombre);
                }
                
                boolean exitoso = random.nextDouble() < probabilidadExito;
                System.out.println(getIcono() + " " + nombre + ": " + exitoso);
                return exitoso;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Interrupción en verificación de " + nombre, e);
            }
        });
    }

    protected abstract String getIcono();
}