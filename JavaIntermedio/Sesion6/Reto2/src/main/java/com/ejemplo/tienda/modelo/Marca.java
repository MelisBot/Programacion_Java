package com.ejemplo.tienda.modelo;

import jakarta.persistence.*;

@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Marca() {}

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }

    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return String.format("Marca[id=%d, nombre='%s']", id, nombre);
    }
}
