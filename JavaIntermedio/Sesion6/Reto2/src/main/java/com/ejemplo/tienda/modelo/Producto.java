package com.ejemplo.tienda.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String descripcion;

    @Min(1)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Producto() {}

    public Producto(String nombre, String descripcion, double precio, Marca marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre='%s', precio=%.2f]", id, nombre, precio);
    }
}
