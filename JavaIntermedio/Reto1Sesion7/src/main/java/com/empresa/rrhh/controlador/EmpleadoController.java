package com.empresa.rrhh.controlador;

import com.empresa.rrhh.modelo.Empleado;
import com.empresa.rrhh.servicio.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Empleado> listarTodos() {
        return service.obtenerTodos();
    }

    @GetMapping("/puesto/{puesto}")
    public List<Empleado> buscarPorPuesto(@PathVariable String puesto) {
        return service.buscarPorPuesto(puesto);
    }

    @DeleteMapping("/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        try {
            service.eliminarEmpleado(id);
            return "✅ Empleado con ID " + id + " eliminado correctamente.";
        } catch (RuntimeException e) {
            return "❌ " + e.getMessage();
        }
    }
}
