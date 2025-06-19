package Sesion4.Reto2;

public class VerificacionClima extends ServicioVerificacion {
    public VerificacionClima() {
        super("Clima favorable", 0.85, 0.15);
    }

    @Override
    protected String getIcono() {
        return "🌦️";
    }
}