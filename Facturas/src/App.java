import java.time.LocalDate;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Factura facturaActual = null;

        int opcion;

        do {
            System.out.println("\n=== LIBRERÍA \"EL SABER\" - SISTEMA DE FACTURACIÓN ===");
            System.out.println("1. Crear factura de libro (IVA 4%)");
            System.out.println("2. Crear factura de material escolar (IVA 21%)");
            System.out.println("3. Mostrar factura actual");
            System.out.println("0. Salir");
            System.out.println("====================================================");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                System.out.print("Opción inválida. Introduce un número (0-3): ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {

                case 1:
                    System.out.println("\nCreando factura de LIBRO (IVA 4%)...");
                    facturaActual = crearFactura(sc, 4);
                    facturaActual.imprimirFactura();
                    break;

                case 2:
                    System.out.println("\nCreando factura de MATERIAL ESCOLAR (IVA 21%)...");
                    facturaActual = crearFactura(sc, 21);
                    facturaActual.imprimirFactura();
                    break;

                case 3:
                    if (facturaActual == null) {
                        System.out.println("\nNo hay factura creada todavía.");
                    } else {
                        System.out.println("\n=== FACTURA ACTUAL ===");
                        facturaActual.imprimirFactura();
                    }
                    break;

                case 0:
                    System.out.println("\nGracias por usar el sistema de facturación. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida (0-3).");
            }

        } while (opcion != 0);

        sc.close();
    }


    public static Factura crearFactura(Scanner sc, double iva) {

        System.out.print("Introduce el nombre del producto: ");
        String concepto = sc.nextLine();

        double base;
        do {
            System.out.print("Introduce el precio base (positivo): ");
            while (!sc.hasNextDouble()) {
                System.out.print("Valor inválido. Introduce un número positivo: ");
                sc.next();
            }
            base = sc.nextDouble();
        } while (base <= 0);
        sc.nextLine();

        LocalDate fecha;
        System.out.print("¿La factura es de hoy? (s/n): ");
        String respuesta = sc.nextLine().toLowerCase();

        if (respuesta.equals("s")) {
            fecha = LocalDate.now();
        } else {
            fecha = leerFecha(sc);
        }

        Factura factura = new Factura(fecha, concepto, base, iva);

        System.out.print("¿Desea aplicar descuento? (s/n): ");
        String aplicarDescuento = sc.nextLine().toLowerCase();

        if (aplicarDescuento.equals("s")) {

            double porcentaje;
            do {
                System.out.print("Introduce el porcentaje de descuento (0-100): ");

                while (!sc.hasNextDouble()) {
                    System.out.print("Valor inválido. Introduce un número del 0 al 100: ");
                    sc.next();
                }
                porcentaje = sc.nextDouble();

            } while (porcentaje < 0 || porcentaje > 100);

            sc.nextLine();
            factura.aplicarDescuento(porcentaje);
        }

        return factura;
    }

    public static LocalDate leerFecha(Scanner sc) {

        int dia, mes, año;

        do {
            System.out.print("Introduce día (1-31): ");
            while (!sc.hasNextInt()) {
                System.out.print("Día inválido. Introduce un número entre 1 y 31: ");
                sc.next();
            }
            dia = sc.nextInt();
        } while (dia < 1 || dia > 31);

        do {
            System.out.print("Introduce mes (1-12): ");
            while (!sc.hasNextInt()) {
                System.out.print("Mes inválido. Introduce un número entre 1 y 12: ");
                sc.next();
            }
            mes = sc.nextInt();
        } while (mes < 1 || mes > 12);

        do {
            System.out.print("Introduce año (1900-2100): ");
            while (!sc.hasNextInt()) {
                System.out.print("Año inválido. Introduce un número válido: ");
                sc.next();
            }
            año = sc.nextInt();
        } while (año < 1900 || año > 2100);

        sc.nextLine();

        return LocalDate.of(año, mes, dia);
    }

}
