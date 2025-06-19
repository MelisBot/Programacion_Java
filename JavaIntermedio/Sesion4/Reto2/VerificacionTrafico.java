package Sesion4.Reto2;

public class VerificacionTrafico extends ServicioVerificacion {
    public VerificacionTrafico() {
        super("Tráfico aéreo despejado", 0.9, 0.1);
    }

    @Override
    protected String getIcono() {
        return "🚦";
    }
}