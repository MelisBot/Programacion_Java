package com.empresa.rrhh.modelo;

import jakarta.persistence.*;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado() {}

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }
}
