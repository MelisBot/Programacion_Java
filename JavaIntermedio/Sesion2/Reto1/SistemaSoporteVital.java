package Reto1;
import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep((long)(Math.random() * 2000 + 1000));
        return "🧪 Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}