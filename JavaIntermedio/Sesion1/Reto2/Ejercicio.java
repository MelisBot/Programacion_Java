package Reto2;

public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio(String titulo, String autor, boolean revisado) {
        super(titulo, autor);
        this.revisado = revisado;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("📝 Ejercicio: " + titulo + " - Autor: " + autor + " - Revisado: " + (revisado ? "true" : "false"));
    }

    public void marcarRevisado() {
        this.revisado = true;
    }
}