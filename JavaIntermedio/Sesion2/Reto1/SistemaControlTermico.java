package Reto1;
import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep((long)(Math.random() * 2000 + 1000));
        return "🔥 Control térmico: temperatura estable (22°C).";
    }
}