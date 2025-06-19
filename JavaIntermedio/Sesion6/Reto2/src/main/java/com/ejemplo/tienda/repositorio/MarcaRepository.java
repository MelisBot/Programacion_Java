package com.ejemplo.tienda.repositorio;

import com.ejemplo.tienda.modelo.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {}
