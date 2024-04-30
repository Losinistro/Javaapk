package TMO;

import java.util.ArrayList;
import java.util.List;

public class TMO {
    private int capacidadSala;
    private int numEntradasDisponibles;
    private double precioBaseEntrada;
    private String[] asientos;
    private String[] clientes;
    private String[] ventas;
    private List<String> descuentos;

    public TMO(int capacidadSala, int numEntradasDisponibles, double precioBaseEntrada) {
        this.capacidadSala = capacidadSala;
        this.numEntradasDisponibles = numEntradasDisponibles;
        this.precioBaseEntrada = precioBaseEntrada;
        this.asientos = new String[capacidadSala];
        this.clientes = new String[capacidadSala];
        this.ventas = new String[capacidadSala];
        this.descuentos = new ArrayList<>();
    }

    public void venderEntrada(String asiento, String cliente) {
        int indice = -1;
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i] == null) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("Lo siento, no hay asientos disponibles.");
            return;
        }

        double precioFinal = precioBaseEntrada;
        if (cliente != null && descuentos.contains(cliente)) {
            precioFinal *= 0.85;
        }

        asientos[indice] = asiento;
        clientes[indice] = cliente;
        ventas[indice] = "Asiento: " + asiento + ", Cliente: " + cliente + ", Precio Final: $" + precioFinal;
        numEntradasDisponibles--;
    }

    public void agregarDescuento(String descuento) {
        descuentos.add(descuento);
    }

    public static void main(String[] args) {
        TMO teatro = new TMO(100, 100, 50.0);
        teatro.agregarDescuento("terceraEdad");

        teatro.venderEntrada("A1", "Juan");
        teatro.venderEntrada("A2", "Maria");
        teatro.venderEntrada("A3", null); 
        teatro.venderEntrada("A4", "Ana"); 
    }
}
