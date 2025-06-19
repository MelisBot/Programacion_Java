package com.empresa.rrhh;

import com.empresa.rrhh.modelo.Empleado;
import com.empresa.rrhh.repositorio.EmpleadoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaDatos {
    @Bean
    CommandLineRunner initData(EmpleadoRepository repo) {
        return args -> {
            repo.save(new Empleado("Ana Gómez", "Gerente de Marketing", 55000));
            repo.save(new Empleado("Carlos Pérez", "Desarrollador Backend", 45000));
        };
    }
}
