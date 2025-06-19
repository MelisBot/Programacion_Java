/* Creado: Melissa Jiménez Gonzalez | Reto2 Sesion1 
*/
package Reto2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HospitalSimulacion {
    public static void main(String[] args) {
        // Creamos el recurso médico compartido
        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");
        
        System.out.println("🏥 Iniciando acceso a la " + salaCirugia + "...");

        // Creamos los profesionales médicos como tareas Runnable
        Runnable draSanchez = () -> salaCirugia.usar("Dra. Sánchez");
        Runnable drGomez = () -> salaCirugia.usar("Dr. Gómez");
        Runnable enfMartinez = () -> salaCirugia.usar("Enf. Martínez");
        Runnable drRodriguez = () -> salaCirugia.usar("Dr. Rodríguez");
        Runnable draPerez = () -> salaCirugia.usar("Dra. Pérez");

        // Creamos un pool de hilos con 4 ejecutores
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        // Enviamos todas las tareas al executor
        executor.execute(draSanchez);
        executor.execute(drGomez);
        executor.execute(enfMartinez);
        executor.execute(drRodriguez);
        executor.execute(draPerez);

        // Cerramos el executor de manera ordenada
        executor.shutdown();
        
        try {
            // Esperamos a que todas las tareas terminen (máximo 1 minuto)
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}