package Sesion4.Reto2;

public class VerificacionPersonal extends ServicioVerificacion {
    public VerificacionPersonal() {
        super("Personal disponible", 0.95, 0.05);
    }

    @Override
    protected String getIcono() {
        return "👷‍♂️";
    }
}
