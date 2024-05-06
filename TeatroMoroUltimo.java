package TeatroMoroUltimo;

//Creado por Lorenzo Utreras//


import java.util.ArrayList;
import java.util.List;

public class TeatroMoroUltimo {
    private int capacidadSala;
    private int numEntradasDisponibles;
    private double precioBaseEntrada;
    private List<Entrada> entradasVendidas;

    public TeatroMoroUltimo(int capacidadSala, double precioBaseEntrada) {
        this.capacidadSala = capacidadSala;
        this.numEntradasDisponibles = capacidadSala;
        this.precioBaseEntrada = precioBaseEntrada;
        this.entradasVendidas = new ArrayList<>();
    }

    public void venderEntrada(String asiento, Cliente cliente) {
        if (numEntradasDisponibles > 0) {
            double precio = calcularPrecioEntrada(cliente);
            Entrada nuevaEntrada = new Entrada(asiento, cliente, precio);
            entradasVendidas.add(nuevaEntrada);
            numEntradasDisponibles--;
            System.out.println("Entrada vendida: " + nuevaEntrada);
        } else {
            System.out.println("Lo siento, no hay asientos disponibles.");
        }
    }

    private double calcularPrecioEntrada(Cliente cliente) {
        double precioFinal = precioBaseEntrada;
        if (cliente != null) {
            if (cliente.isEsEstudiante()) {
                precioFinal *= 0.9; 
            }
            if (cliente.isEsTerceraEdad()) {
                precioFinal *= 0.85;
            }
        }
        return precioFinal;
    }

    public static void main(String[] args) {
        TeatroMoroUltimo teatro = new TeatroMoroUltimo(100, 50.0);
        Cliente juan = new Cliente("Juan", true, false);
        Cliente maria = new Cliente("Maria", false, true); 

        teatro.venderEntrada("A1", juan);
        teatro.venderEntrada("A2", maria);
        teatro.venderEntrada("A3", null); 
        teatro.venderEntrada("A4", juan);
    }
}

class Entrada {
    private String asiento;
    private Cliente cliente;
    private double precio;

    public Entrada(String asiento, Cliente cliente, double precio) {
        this.asiento = asiento;
        this.cliente = cliente;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Asiento: " + asiento + ", Cliente: " + cliente.getNombre() + ", Precio Final: $" + precio;
    }
}

class Cliente {
    private String nombre;
    private boolean esEstudiante;
    private boolean esTerceraEdad;

    public Cliente(String nombre, boolean esEstudiante, boolean esTerceraEdad) {
        this.nombre = nombre;
        this.esEstudiante = esEstudiante;
        this.esTerceraEdad = esTerceraEdad;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEsEstudiante() {
        return esEstudiante;
    }

    public boolean isEsTerceraEdad() {
        return esTerceraEdad;
    }
}

class Boleta {
    private Entrada entrada;

    public Boleta(Entrada entrada) {
        this.entrada = entrada;
    }
}

