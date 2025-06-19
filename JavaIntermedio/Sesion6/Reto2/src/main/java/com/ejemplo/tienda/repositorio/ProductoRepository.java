package com.ejemplo.tienda.repositorio;

import com.ejemplo.tienda.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {}
