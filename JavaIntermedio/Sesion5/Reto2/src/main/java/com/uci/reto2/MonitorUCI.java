package com.uci.reto2;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

public class MonitorUCI {

    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        Flux<String> paciente1 = generarFlujoPaciente(1);
        Flux<String> paciente2 = generarFlujoPaciente(2);
        Flux<String> paciente3 = generarFlujoPaciente(3);

        Flux.merge(paciente1, paciente2, paciente3)
            .filter(evento -> !evento.isEmpty())
            .delayElements(Duration.ofSeconds(1)) // backpressure
            .subscribe(System.out::println);

        Thread.sleep(20000);
    }

    private static Flux<String> generarFlujoPaciente(int id) {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> generarEvento(id))
                .publishOn(Schedulers.parallel());
    }

    private static String generarEvento(int id) {
        int fc = random.nextInt(151); // 0-150 bpm
        int paSys = random.nextInt(81) + 80; // 80-160 mmHg
        int paDia = random.nextInt(41) + 50; // 50-90 mmHg
        int spo2 = random.nextInt(21) + 80; // 80-100%

        StringBuilder alertas = new StringBuilder();

        if (fc < 50 || fc > 120) {
            alertas.append("⚠️ Paciente ").append(id).append(" - FC crítica: ").append(fc).append(" bpm\n");
        }
        if (paSys < 90 || paDia < 60 || paSys > 140 || paDia > 90) {
            alertas.append("⚠️ Paciente ").append(id).append(" - PA crítica: ").append(paSys).append("/").append(paDia).append(" mmHg\n");
        }
        if (spo2 < 90) {
            alertas.append("⚠️ Paciente ").append(id).append(" - SpO2 baja: ").append(spo2).append("%\n");
        }

        return alertas.toString().trim();
    }
}
