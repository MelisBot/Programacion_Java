package Reto1;

import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep((long)(Math.random() * 2000 + 1000)); // Simula procesamiento
        return "🛰️ Navegación: trayectoria corregida con éxito.";
    }
}