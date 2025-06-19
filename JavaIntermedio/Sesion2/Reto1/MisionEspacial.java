package Reto1;

import java.util.concurrent.*;
import java.util.*;

public class MisionEspacial {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...\n");
        
        // Crear pool de hilos para los 4 subsistemas
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        try {
            // Lista para almacenar los Futures
            List<Future<String>> resultados = new ArrayList<>();
            
            // Enviar todas las tareas al executor
            resultados.add(executor.submit(new SistemaNavegacion()));
            resultados.add(executor.submit(new SistemaSoporteVital()));
            resultados.add(executor.submit(new SistemaControlTermico()));
            resultados.add(executor.submit(new SistemaComunicaciones()));
            
            // Esperar y mostrar los resultados de cada subsistema
            for (Future<String> resultado : resultados) {
                try {
                    System.out.println(resultado.get());
                } catch (ExecutionException e) {
                    System.out.println("❌ Error en subsistema: " + e.getCause().getMessage());
                }
            }
            
            System.out.println("\n✅ Todos los sistemas reportan estado operativo.");
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("❌ Misión interrumpida!");
        } finally {
            executor.shutdown();
        }
    }
}