package Reto2;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class RecursoMedico {
    private final String nombre;
    private final Lock lock = new ReentrantLock(true); // Lock con fairness

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        lock.lock(); // Adquirimos el lock
        try {
            // Simulamos el uso del recurso
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep((int)(Math.random() * 2000 + 1000)); // Tiempo aleatorio entre 1-3 segundos
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println("❌ " + profesional + " interrumpido durante el uso de " + nombre);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); // Siempre liberamos el lock
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}