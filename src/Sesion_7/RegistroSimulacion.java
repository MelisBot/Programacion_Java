package Sesion_7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegistroSimulacion {
    // Ruta del archivo de configuración
    private static final Path CONFIG_PATH = Paths.get("config/parametros.txt");

    public static void main(String[] args) {
        try {
            // Contenido del archivo de parámetros
            String parametros = """
                    Tiempo de ciclo: 55.8 segundos
                    Velocidad de línea: 1.2 m/s
                    Número de estaciones: 8
                    Temperatura ambiente: 23.5 °C
                    Humedad relativa: 45%
                    Modelo utilizado: DigitalTwin_v2.1.5""";

            // Guardar parámetros en el archivo
            guardarParametros(parametros);

            // Verificar existencia del archivo
            if (verificarExistenciaArchivo()) {
                System.out.println("✓ Archivo de configuración creado exitosamente");

                // Leer y mostrar el contenido
                String contenido = leerParametros();
                System.out.println("\n=== PARÁMETROS DE SIMULACIÓN ===");
                System.out.println(contenido);
            } else {
                System.err.println("✗ Error: No se pudo crear el archivo de configuración");
            }

        } catch (IOException e) {
            System.err.println("Error en el proceso: " + e.getMessage());
        }
    }

    /**
     * Guarda los parámetros en el archivo de configuración
     * @param contenido Parámetros a guardar
     * @throws IOException Si ocurre un error al escribir el archivo
     */
    private static void guardarParametros(String contenido) throws IOException {
        // Crear directorio si no existe
        if (!Files.exists(CONFIG_PATH.getParent())) {
            Files.createDirectories(CONFIG_PATH.getParent());
        }

        // Escribir contenido en el archivo
        Files.writeString(CONFIG_PATH, contenido, StandardOpenOption.CREATE);
    }

    /**
     * Verifica si el archivo de configuración existe
     * @return true si existe, false en caso contrario
     */
    private static boolean verificarExistenciaArchivo() {
        return Files.exists(CONFIG_PATH);
    }

    /**
     * Lee el contenido del archivo de configuración
     * @return Contenido del archivo
     * @throws IOException Si ocurre un error al leer el archivo
     */
    private static String leerParametros() throws IOException {
        return Files.readString(CONFIG_PATH);
    }
}
