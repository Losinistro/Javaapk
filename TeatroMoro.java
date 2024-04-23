
package teatromoro;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lorenzo Utreras
 */

public class TeatroMoro {
    private String nombreTeatro;
    private int capacidadSala;
    private int numEntradasDisponibles;
    private double precioBaseEntrada;

    private static double totalIngresos = 0;
    private static int totalEntradasVendidas = 0;

    private String tipoEntrada;
    private double descuentoTemporal;
    private String ubicacionEntrada;
    private double precioFinalEntrada;

    private ArrayList<String> ventas = new ArrayList<>();


    public TeatroMoro(String nombreTeatro, int capacidadSala, int numEntradasDisponibles, double precioBaseEntrada) {
        this.nombreTeatro = nombreTeatro;
        this.capacidadSala = capacidadSala;
        this.numEntradasDisponibles = numEntradasDisponibles;
        this.precioBaseEntrada = precioBaseEntrada;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir) {
            System.out.println("\n---- Menú ----");
            System.out.println("1. Venta de entradas");
            System.out.println("2. Visualizar resumen de ventas");
            System.out.println("3. Generar boleta");
            System.out.println("4. Salir");
            System.out.print("Seleccione la operación deseada: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    ventaEntradas();
                    break;
                case 2:
                    visualizarResumenVentas();
                    break;
                case 3:
                    generarBoleta();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Gracias por utilizar el sistema de venta de entradas del Teatro Moro.");
                    break;
                default:
                    System.out.println("Por favor, seleccione una opción válida.");
                    break;
            }
        }
        scanner.close();
    }

    public void ventaEntradas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n---- Venta de Entradas ----");
        System.out.print("Seleccione la ubicación (VIP, Platea, Balcón): ");
        ubicacionEntrada = scanner.nextLine();
        
        switch (ubicacionEntrada) {
            case "VIP":
                precioBaseEntrada = 100;
                break;
            case "Platea":
                precioBaseEntrada = 80;
                break;
            case "Balcón":
                precioBaseEntrada = 60; 
                break;
            default:
                System.out.println("Ubicación no válida.");
                return;
        }
        
        System.out.print("¿Es usted estudiante (S/N)? ");
        String respuestaEstudiante = scanner.nextLine();
        if (respuestaEstudiante.equalsIgnoreCase("S")) {
            descuentoTemporal = 0.1;
        } else {
            System.out.print("¿Es usted persona de la tercera edad (S/N)? ");
            String respuestaTerceraEdad = scanner.nextLine();
            if (respuestaTerceraEdad.equalsIgnoreCase("S")) {
                descuentoTemporal = 0.15;
            } else {
                descuentoTemporal = 0; 
            }
        }
        
        precioFinalEntrada = precioBaseEntrada * (1 - descuentoTemporal);
        
        String venta = "Ubicación: " + ubicacionEntrada + ", Costo Final: $" + precioFinalEntrada + ", Descuento: " + (descuentoTemporal * 100) + "%";
        ventas.add(venta);
        
        totalIngresos += precioFinalEntrada;
        totalEntradasVendidas++;
        numEntradasDisponibles--;
        
        System.out.println("Venta realizada con éxito.");
    }

    public void visualizarResumenVentas() {
        System.out.println("\n---- Resumen de Ventas ----");
        for (String venta : ventas) {
            System.out.println(venta);
        }
        System.out.println("Total ingresos: $" + totalIngresos);
        System.out.println("Total entradas vendidas: " + totalEntradasVendidas);
    }

    public void generarBoleta() {
        System.out.println("\n---- Boleta ----");
        for (String venta : ventas) {
            System.out.println("Detalle: " + venta);
        }
        System.out.println("¡Gracias por su compra!");
    }

    public static void main(String[] args) {
        TeatroMoro teatro = new TeatroMoro("Teatro Moro", 500, 200, 0);
        teatro.menu();
    }
}
