package com.ejemplo.tienda.configuracion;

import com.ejemplo.tienda.modelo.Marca;
import com.ejemplo.tienda.modelo.Producto;
import com.ejemplo.tienda.repositorio.MarcaRepository;
import com.ejemplo.tienda.repositorio.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargaInicial {

    @Bean
    CommandLineRunner init(MarcaRepository marcaRepo, ProductoRepository productoRepo) {
        return args -> {
            Marca apple = marcaRepo.save(new Marca("Apple"));
            Marca samsung = marcaRepo.save(new Marca("Samsung"));

            productoRepo.save(new Producto("iPhone 15", "Smartphone", 23000, apple));
            productoRepo.save(new Producto("iPad Pro", "Tablet", 18000, apple));
            productoRepo.save(new Producto("Galaxy S23", "Smartphone", 21000, samsung));
            productoRepo.save(new Producto("Smart TV", "Televisión", 15000, samsung));

            System.out.println("\n📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findAll().stream()
                    .filter(p -> p.getMarca().getId().equals(marca.getId()))
                    .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
        };
    }
}
