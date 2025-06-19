package Sesion3.Reto2;

import java.util.List;
import java.util.Optional;

public class ProcesadorEncuestas {
    public static void main(String[] args) {
        // Crear datos de ejemplo
        List<Sucursal> sucursales = List.of(
            new Sucursal("Centro", List.of(
                new Encuesta("Juan Pérez", "El tiempo de espera fue largo", 3),
                new Encuesta("María López", null, 2),
                new Encuesta("Carlos Gómez", "Excelente atención", 5)
            )),
            new Sucursal("Norte", List.of(
                new Encuesta("Ana Ruiz", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("Luisa Torres", null, 1),
                new Encuesta("Pedro Sánchez", "Muy satisfecho", 4)
            ))
        );

        // Procesar encuestas con Stream API
        sucursales.stream()
            .flatMap(sucursal -> 
                sucursal.getEncuestas().stream()
                    .filter(encuesta -> encuesta.getCalificacion() <= 3)
                    .flatMap(encuesta -> 
                        encuesta.getComentario()
                            .map(comentario -> String.format(
                                "Sucursal %s: Seguimiento a paciente con comentario: \"%s\"",
                                sucursal.getNombre(),
                                comentario
                            ))
                            .stream()
                    )
            )
            .forEach(System.out::println);
    }
}