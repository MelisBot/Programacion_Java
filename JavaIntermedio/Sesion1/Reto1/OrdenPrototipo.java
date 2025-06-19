/*Subclase de OrdenProduccion
 * La clase OrdenPrototipo es una subclase de OrdenProduccion que representa órdenes de producción de prototipos.
 * Contiene un constructor que inicializa el código, la cantidad y la fase de desarrollo del prototipo.
 * El método mostrarResumen imprime un resumen de la orden de producción de prototipo,
 * incluyendo el código, la cantidad y la fase de desarrollo.
*/

public class OrdenPrototipo extends OrdenProduccion {
    private String faseDesarrollo;

    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🧪 OrdenPrototipo - Código: " + codigo + " - Cantidad: " + cantidad + 
                         " - Fase: " + faseDesarrollo);
    }
}