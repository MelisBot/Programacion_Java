package Reto1;
import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep((long)(Math.random() * 2000 + 1000));
        return "📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}