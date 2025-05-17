/*Creado por:Lic.Melissa Jiménez | Curso BEDU+Tecnolochicas |Sesión Ocho*/
package Sesion_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;

public class AnalizadorDeLogs {
    private static final Path ARCHIVO_LOGS = Paths.get("errores.log");
    private static final Path ARCHIVO_FALLOS = Paths.get("registro_fallos.txt");
    private static final DecimalFormat FORMATO_PORCENTAJE = new DecimalFormat("0.00%");

    public static void main(String[] args) {
        int totalLineas = 0;
        int errores = 0;
        int advertencias = 0;

        try {
            // Verificar si el archivo de logs existe
            if (!Files.exists(ARCHIVO_LOGS)) {
                throw new FileNotFoundException("El archivo errores.log no existe en la ruta especificada");
            }

            // Procesar el archivo con try-with-resources
            try (BufferedReader lector = Files.newBufferedReader(ARCHIVO_LOGS)) {
                String linea;
                System.out.println("🔍 Analizando archivo de logs...");

                while ((linea = lector.readLine()) != null) {
                    totalLineas++;

                    if (linea.contains("ERROR")) {
                        errores++;
                    } else if (linea.contains("WARNING")) {
                        advertencias++;
                    }
                }

                // Generar reporte
                System.out.println("\n=== RESUMEN DE ANÁLISIS ===");
                System.out.println("Total de líneas leídas: " + totalLineas);
                System.out.println("Errores detectados: " + errores);
                System.out.println("Advertencias detectadas: " + advertencias);

                if (totalLineas > 0) {
                    double porcentajeErrores = (double) errores / totalLineas;
                    double porcentajeAdvertencias = (double) advertencias / totalLineas;

                    System.out.println("\nPorcentaje de líneas con ERROR: " +
                            FORMATO_PORCENTAJE.format(porcentajeErrores));
                    System.out.println("Porcentaje de líneas con WARNING: " +
                            FORMATO_PORCENTAJE.format(porcentajeAdvertencias));
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error al procesar los logs: " + e.getMessage());
            registrarFallo(e);
        }
    }

    /**
     * Registra los fallos en un archivo de registro
     * @param ex Excepción ocurrida
     */
    private static void registrarFallo(Exception ex) {
        try (BufferedWriter escritor = Files.newBufferedWriter(ARCHIVO_FALLOS,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

            String mensajeError = String.format("[%s] %s%n",
                    java.time.LocalDateTime.now(), ex.getMessage());

            escritor.write(mensajeError);
            System.out.println("⚠ Se registró el fallo en " + ARCHIVO_FALLOS);
        } catch (IOException ioEx) {
            System.err.println("No se pudo registrar el fallo: " + ioEx.getMessage());
        }
    }
}
