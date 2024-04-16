
/**
 *
 * @author Lorenzo Utreras
 */
import java.util.Scanner;

public class ventax {
    static int totalEntradasVendidas = 0;
    static double totalIngresos = 0;
    static int[] cantidadEntradasVendidas = new int[100]; 
    static double[] precioEntradaUnitario = {13000, 10000, 9000, 6500};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al sistema de venta de entradas del Teatro Moro.");
            System.out.println("Menú principal:");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Modificar una venta existente");
            System.out.println("3. Eliminar una venta");
            System.out.println("4. Imprimir boleta");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> comprarEntrada(scanner);
                case 2 -> modificarVenta(scanner);
                case 3 -> eliminarVenta(scanner);
                case 4 -> imprimirBoleta(scanner);
                case 5 -> {
                    System.out.println("Gracias por utilizar nuestro sistema de venta de entradas. ¡Hasta luego!");
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }

    public static void comprarEntrada(Scanner scanner) {
    }

    public static void modificarVenta(Scanner scanner) {
        System.out.println("Ingrese el número de venta que desea modificar:");
        int numeroVenta = scanner.nextInt();
        if (numeroVenta < 1 || numeroVenta > 100) {
            System.out.println("Número de venta inválido");
            return;
        }

        System.out.println("Ingrese la cantidad de entradas vendidas:");
        int nuevaCantidad = scanner.nextInt();

        totalEntradasVendidas -= cantidadEntradasVendidas[numeroVenta - 1];
        cantidadEntradasVendidas[numeroVenta - 1] = nuevaCantidad;
        totalEntradasVendidas += nuevaCantidad;
        totalIngresos -= cantidadEntradasVendidas[numeroVenta - 1] * precioEntradaUnitario[numeroVenta - 1];
        totalIngresos += nuevaCantidad * precioEntradaUnitario[numeroVenta - 1];

        System.out.println("Venta modificada exitosamente.");
    }

    public static void eliminarVenta(Scanner scanner) {
        System.out.println("Ingrese el número de la venta que desea eliminar:");
        int numeroVenta = scanner.nextInt();

        if (ventaExiste(numeroVenta)) {
            System.out.println("Venta encontrada.");
            totalEntradasVendidas -= cantidadEntradasVendidas[numeroVenta];
            double precioTotal = cantidadEntradasVendidas[numeroVenta] * precioEntradaUnitario[numeroVenta];
            totalIngresos -= precioTotal;
            cantidadEntradasVendidas[numeroVenta] = 0;
            System.out.println("La venta ha sido eliminada.");
        } else {
            System.out.println("La venta no fue encontrada.");
        }
    }

    public static void imprimirBoleta(Scanner scanner) {
        System.out.println("Ingrese el número de la venta que desea imprimir la boleta:");
        int numeroVenta = scanner.nextInt();

        if (ventaExiste(numeroVenta)) {
            System.out.println("Boleta de venta número: " + numeroVenta);
            System.out.println("Tipo de entrada: " + numeroVenta); // Aquí deberías tener un método para obtener el tipo de entrada de la venta
            System.out.println("Cantidad de entradas: " + cantidadEntradasVendidas[numeroVenta]);
            System.out.println("Precio unitario: $" + precioEntradaUnitario[numeroVenta]);
            System.out.println("Total a pagar: $" + (cantidadEntradasVendidas[numeroVenta] * precioEntradaUnitario[numeroVenta]));
        } else {
            System.out.println("La venta no fue encontrada.");
        }
    }

    private static boolean ventaExiste(int numeroVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



