package Sesion6.Reto1.src.main.java.com.ejemplo.inventario.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar en blanco")
    private String descripcion;

    @Min(value = 1, message = "El precio debe ser mayor o igual a 1")
    private double precio;

    public Producto() {}

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f]", id, nombre, precio);
    }

    // Getters y setters omitidos por brevedad
}
