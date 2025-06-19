// Sesion5/Reto1/src/main/java/com/meridian/reto1/MeridianPrimeSystem.java
package Sesion5.Reto1.src.main.java.com.meridian.reto1;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MeridianPrimeSystem {

    private final Random random = new Random();
    private final AtomicInteger redCount = new AtomicInteger(0);

    public void iniciar() throws InterruptedException {
        Flux<String> traffic = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(congestion -> congestion > 70)
                .map(congestion -> "🚗 Alerta: Congestión del " + congestion + "% en Avenida Solar")
                .onBackpressureBuffer()
                .publishOn(Schedulers.parallel());

        Flux<String> pollution = Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(101))
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)")
                .publishOn(Schedulers.parallel());

        Flux<String> accidents = Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    int val = random.nextInt(3);
                    return val == 0 ? "Baja" : val == 1 ? "Media" : "Alta";
                })
                .filter(priority -> priority.equals("Alta"))
                .map(p -> "🚑 Emergencia vial: Accidente con prioridad Alta")
                .publishOn(Schedulers.parallel());

        Flux<String> trains = Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11))
                .filter(delay -> delay > 5)
                .map(delay -> "🚝 Tren maglev con retraso crítico: " + delay + " minutos")
                .delayElements(Duration.ofMillis(200))
                .publishOn(Schedulers.parallel());

        Flux<String> trafficLights = Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    String[] states = {"Verde", "Amarillo", "Rojo"};
                    return states[random.nextInt(3)];
                })
                .filter(state -> {
                    if (state.equals("Rojo")) {
                        return redCount.incrementAndGet() >= 3;
                    } else {
                        redCount.set(0);
                        return false;
                    }
                })
                .map(s -> "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte")
                .publishOn(Schedulers.parallel());

        Flux<String> allCriticalEvents = Flux.merge(
                traffic, pollution, accidents, trains, trafficLights
        );

        allCriticalEvents
                .doOnNext(System.out::println)
                .buffer(Duration.ofSeconds(1))
                .filter(buffer -> buffer.size() >= 3)
                .map(buffer -> "🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime")
                .subscribe(System.out::println);

        Thread.sleep(20000); // Ejecutar por 20 segundos
    }
}
