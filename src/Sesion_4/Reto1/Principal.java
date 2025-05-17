package Sesion_4.Reto1;

public class Principal {
    public static void main(String[] args) {
        Factura f1 = new Factura("FAC001", "Juan Pérez", 1450.0);
        Factura f2 = new Factura("FAC001", "Comercial XYZ", 1450.0);

        System.out.println(f1);
        System.out.println(f2);

        boolean sonIguales = f1.equals(f2);
        System.out.println("¿Las facturas son iguales?: " + sonIguales);
    }
}
