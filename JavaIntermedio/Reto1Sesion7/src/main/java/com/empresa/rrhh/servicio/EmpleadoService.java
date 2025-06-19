package com.empresa.rrhh.servicio;

import com.empresa.rrhh.modelo.Empleado;
import com.empresa.rrhh.repositorio.EmpleadoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository repo;

    public EmpleadoService(EmpleadoRepository repo) {
        this.repo = repo;
    }

    public List<Empleado> obtenerTodos() {
        return repo.findAll();
    }

    public List<Empleado> buscarPorPuesto(String puesto) {
        return repo.findByPuesto(puesto);
    }

    public void eliminarEmpleado(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Empleado con ID " + id + " no existe.");
        }
        repo.deleteById(id);
    }
}
