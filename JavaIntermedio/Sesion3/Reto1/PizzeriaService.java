package Sesion3.Reto1;
import java.util.List;
import java.util.Optional;

public class PizzeriaService {
    public static void main(String[] args) {
        // Crear lista de pedidos de ejemplo
        List<Pedido> pedidos = List.of(
            new Pedido("Juan Pérez", "domicilio", "555-1234"),
            new Pedido("María García", "local", null),
            new Pedido("Carlos López", "domicilio", "555-5678"),
            new Pedido("Ana Martínez", "domicilio", null),
            new Pedido("Luisa Fernández", "domicilio", "555-9012")
        );

        // Procesar pedidos con Stream API y Optional
        pedidos.stream()
            .filter(p -> "domicilio".equals(p.getTipoEntrega())) // Filtrar solo domicilio
            .map(Pedido::getTelefono) // Convertir a Optional<String>
            .filter(Optional::isPresent) // Filtrar solo los que tienen teléfono
            .map(Optional::get) // Obtener el valor del Optional
            .forEach(telefono -> System.out.println("📞 Confirmación enviada al número: " + telefono));
    }
}