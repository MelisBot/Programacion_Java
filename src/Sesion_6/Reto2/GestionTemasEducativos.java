package Sesion_6.Reto2;

import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestionTemasEducativos {
    public static void main(String[] args) {
        // 1. Crear lista concurrente de temas educativos
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();

        // Agregar temas de ejemplo
        temas.add(new Tema("Lectura comprensiva", 2));
        temas.add(new Tema("Matemáticas básicas", 1));
        temas.add(new Tema("Cuidado del medio ambiente", 3));
        temas.add(new Tema("Historia universal", 2));
        temas.add(new Tema("Ciencias naturales", 1));

        // 2. Mostrar lista ordenada alfabéticamente
        System.out.println("=== Temas ordenados alfabéticamente ===");
        temas.sort(Comparator.naturalOrder());
        temas.forEach(System.out::println);

        // 3. Ordenar por prioridad ascendente (1 → 3)
        System.out.println("\n=== Temas ordenados por prioridad ===");
        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        temas.forEach(System.out::println);

        // 4. Crear repositorio de recursos educativos
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();

        // Agregar recursos de ejemplo
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/medio-ambiente");
        recursos.put("Historia universal", "https://recursos.edu/historia");
        recursos.put("Ciencias naturales", "https://recursos.edu/ciencias");

        // Mostrar recursos disponibles
        System.out.println("\n=== Recursos educativos disponibles ===");
        recursos.forEach((titulo, url) ->
                System.out.printf("%-30s → %s%n", titulo, url));

        // Ejemplo de búsqueda de recurso
        String temaBuscado = "Matemáticas básicas";
        System.out.printf("\nBuscando recurso para: %s%n", temaBuscado);
        System.out.println("Enlace: " + recursos.get(temaBuscado));
    }
}
