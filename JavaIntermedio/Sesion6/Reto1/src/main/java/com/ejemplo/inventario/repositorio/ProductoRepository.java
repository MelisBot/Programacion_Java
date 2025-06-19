package Sesion6.Reto1.src.main.java.com.ejemplo.inventario.repositorio;

import com.ejemplo.inventario.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByPrecioGreaterThan(double precio);
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
    List<Producto> findByPrecioBetween(double min, double max);
    List<Producto> findByNombreStartingWithIgnoreCase(String prefijo);
}
