package com.empresa.rrhh.repositorio;

import com.empresa.rrhh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByPuesto(String puesto);
}
