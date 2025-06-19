package Reto2;

public class Video extends MaterialCurso {
    private int duracion; // en minutos

    public Video(String titulo, String autor, int duracion) {
        super(titulo, autor);
        this.duracion = duracion;
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("🎥 Video: " + titulo + " - Autor: " + autor + " - Duración: " + duracion + " min");
    }

    public int getDuracion() {
        return duracion;
    }
}