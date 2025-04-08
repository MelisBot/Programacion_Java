//Creado por Melissa Jiménez González
package Reto2;
/*
public class Entrada{
   String nombreEvento;
   Double precioEvento;

   //Contructor
   public Entrada(String nombreEvento, double precioEntrada) {
        this.nombreEvento = nombreEvento;
        this.precioEvento = precioEntrada;
    }

    // Método para mostrar la información
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombreEvento + " | Precio: $" + precioEvento);
    }
}//fin clase Entrada
*/

//Para el reto extra creamos esta clase en un record
//La diferencia cambiamos class por record

public record Entrada (String nombreEvento, Double precioEvento){
    //Metodo para mostrar la información
    public void mostrarInformacion(){
        System.out.println("Evento: "+nombreEvento + " | Precio: $ "+precioEvento);
    }//fin metodo
}//fin record Entrada
