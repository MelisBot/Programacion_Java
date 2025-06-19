// GestionOrdenes.java
import java.util.ArrayList;
import java.util.List;

public class GestionOrdenes {
    
    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("\n📋 Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }
    
    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada orden = (OrdenPersonalizada) obj;
                orden.agregarCostoAdicional(costoAdicional);
            }
        }
    }
    
    public static void contarOrdenes(List<? extends OrdenProduccion>... listas) {
        int masa = 0, personalizada = 0, prototipo = 0;
        
        for (List<? extends OrdenProduccion> lista : listas) {
            if (!lista.isEmpty()) {
                if (lista.get(0) instanceof OrdenMasa) {
                    masa += lista.size();
                } else if (lista.get(0) instanceof OrdenPersonalizada) {
                    personalizada += lista.size();
                } else if (lista.get(0) instanceof OrdenPrototipo) {
                    prototipo += lista.size();
                }
            }
        }
        
        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masa);
        System.out.println("🛠️ Personalizadas: " + personalizada);
        System.out.println("🧪 Prototipos: " + prototipo);
    }

    public static void main(String[] args) {
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));
        
        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));
        
        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));
        
        mostrarOrdenes(ordenesMasa);
        mostrarOrdenes(ordenesPersonalizadas);
        mostrarOrdenes(ordenesPrototipo);
        
        procesarPersonalizadas(ordenesPersonalizadas, 200);
        
        contarOrdenes(ordenesMasa, ordenesPersonalizadas, ordenesPrototipo);
    }
}