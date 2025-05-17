package Sesion_6.Reto2;

class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad;

    // Constructor
    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Implementación de Comparable para ordenar por título
    @Override
    public int compareTo(Tema otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    // Representación en String
    @Override
    public String toString() {
        return String.format("%s (Prioridad: %d)", titulo, prioridad);
    }
}