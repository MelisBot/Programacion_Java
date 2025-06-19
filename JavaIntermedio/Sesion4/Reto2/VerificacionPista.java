package Sesion4.Reto2;
public class VerificacionPista extends ServicioVerificacion {
    public VerificacionPista() {
        super("Pista disponible", 0.8, 0.2);
    }

    @Override
    protected String getIcono() {
        return "🛣️";
    }
}