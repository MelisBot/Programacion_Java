/*Subclase de OrdenProduccion
 * La clase OrdenMasa es una subclase de OrdenProduccion que representa órdenes de producción en masa.
 * * Contiene un constructor que inicializa el código y la cantidad de la orden.
 * * * El método mostrarResumen imprime un resumen de la orden de producción en masa,
 *   incluyendo el código y la cantidad.
*/


public class OrdenMasa extends OrdenProduccion {
    public OrdenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🔧 OrdenMasa - Código: " + codigo + " - Cantidad: " + cantidad);
    }
}