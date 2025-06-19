package Sesion6.Reto1.src.main.java.com.ejemplo.inventario.configuracion;

import com.ejemplo.inventario.modelo.Producto;
import com.ejemplo.inventario.repositorio.ProductoRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaInicial {

    @Bean
    CommandLineRunner init(ProductoRepository repo) {
        return args -> {
            try {
                repo.save(new Producto("Laptop Lenovo", "Portátil profesional", 12500));
                repo.save(new Producto("Mouse Logitech", "Mouse inalámbrico", 350));
                repo.save(new Producto("Teclado Mecánico", "RGB para gamers", 950));
                repo.save(new Producto("Monitor", "Monitor de 24 pulgadas", 3200));

                System.out.println("\n📦 Productos con precio mayor a 500:");
                repo.findByPrecioGreaterThan(500).forEach(System.out::println);

                System.out.println("\n🔍 Productos que contienen 'lap':");
                repo.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);

                System.out.println("\n🎯 Productos con precio entre 400 y 1000:");
                repo.findByPrecioBetween(400, 1000).forEach(System.out::println);

                System.out.println("\n📘 Productos cuyo nombre empieza con 'm':");
                repo.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);

            } catch (ConstraintViolationException e) {
                e.getConstraintViolations().forEach(v ->
                    System.out.println("Error de validación: " + v.getMessage()));
            }
        };
    }
}
