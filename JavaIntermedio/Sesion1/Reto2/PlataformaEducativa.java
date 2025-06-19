package Reto2;

import java.util.List;
import java.util.function.Predicate;

public class PlataformaEducativa {

    // Método genérico para mostrar cualquier tipo de material
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("\n📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    // Método para sumar la duración de videos
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int total = 0;
        for (Video video : lista) {
            total += video.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + total + " minutos");
    }

    // Método para marcar ejercicios como revisados
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) {
                Ejercicio ejercicio = (Ejercicio) obj;
                ejercicio.marcarRevisado();
                System.out.println("✅ Ejercicio '" + ejercicio.titulo + "' marcado como revisado.");
            }
        }
    }

    // Método adicional para filtrar por autor
    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, String autor) {
        Predicate<MaterialCurso> porAutor = material -> material.autor.equals(autor);
        
        System.out.println("\n🔍 Filtrando materiales por autor '" + autor + "':");
        lista.stream()
            .filter(porAutor)
            .forEach(MaterialCurso::mostrarDetalle);
    }

    public static void main(String[] args) {
        // Crear materiales
        Video video1 = new Video("Introducción a Java", "Mario", 15);
        Video video2 = new Video("POO en Java", "Carlos", 20);
        Articulo articulo1 = new Articulo("Historia de Java", "Ana", 1200);
        Articulo articulo2 = new Articulo("Tipos de datos", "Luis", 800);
        Ejercicio ejercicio1 = new Ejercicio("Variables y tipos", "Luis", false);
        Ejercicio ejercicio2 = new Ejercicio("Condicionales", "Mario", false);

        // Crear listas
        List<MaterialCurso> todosMateriales = List.of(video1, video2, articulo1, articulo2, ejercicio1, ejercicio2);
        List<Video> videos = List.of(video1, video2);
        List<Ejercicio> ejercicios = List.of(ejercicio1, ejercicio2);

        // Mostrar todos los materiales
        mostrarMateriales(todosMateriales);

        // Contar duración de videos
        contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        marcarEjerciciosRevisados(ejercicios);

        // Mostrar materiales del autor "Mario" (desafío adicional)
        filtrarPorAutor(todosMateriales, "Mario");
    }
}