/*Subclase 
 * La clase OrdenPersonalizada es una subclase de OrdenProduccion que representa órdenes de producción personalizadas.
 * Contiene un constructor que inicializa el código, la cantidad y el cliente de la orden 
 * * El método mostrarResumen imprime un resumen de la orden de producción personalizada,
 *   incluyendo el código, la cantidad y el cliente.
*/

public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + 
                         " - Cliente: " + cliente);
    }

    public void agregarCostoAdicional(int costo) {
        System.out.println("✅ Orden " + codigo + " ajustada con costo adicional de $" + costo);
    }
}