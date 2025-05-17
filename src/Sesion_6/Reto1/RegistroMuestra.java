package Sesion_6.Reto1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class RegistroMuestra{
    public static void main(String[] args) {
        // Paso 1: ArrayList para registrar el orden de llegada de las muestras
        ArrayList<String> ordenLlegada = new ArrayList<>();
        ordenLlegada.add("Homo sapiens");
        ordenLlegada.add("Mus musculus");
        ordenLlegada.add("Arabidopsis thaliana");
        ordenLlegada.add("Homo sapiens");  // réplica de muestra

        // Paso 2: HashSet para filtrar especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(ordenLlegada);

        // Paso 3: HashMap para asociar ID de muestra con investigador responsable
        HashMap<String, String> muestraInvestigador = new HashMap<>();
        muestraInvestigador.put("M-001", "Dra. López");
        muestraInvestigador.put("M-002", "Dr. Hernández");
        muestraInvestigador.put("M-003", "Dra. Pérez");

        // Paso 4: Mostrar resultados
        System.out.println("📋 Lista completa (orden de llegada):");
        for (String especie : ordenLlegada) {
            System.out.println(" - " + especie);
        }

        System.out.println("\n🔬 Especies únicas procesadas:");
        for (String unica : especiesUnicas) {
            System.out.println(" - " + unica);
        }

        System.out.println("\n🧑‍🔬 Asociación Muestra → Investigador:");
        for (String id : muestraInvestigador.keySet()) {
            System.out.println(" - " + id + " → " + muestraInvestigador.get(id));
        }

        // Búsqueda por ID de muestra
        String busqueda = "M-002";
        String investigador = muestraInvestigador.get(busqueda);
        System.out.println("\n🔎 Búsqueda por ID (" + busqueda + "):");
        if (investigador != null) {
            System.out.println("El investigador responsable es: " + investigador);
        } else {
            System.out.println("No se encontró la muestra con ID " + busqueda);
        }
    }
}
