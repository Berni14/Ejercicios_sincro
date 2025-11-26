import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Ascensor ascensor = new Ascensor(11);
        boolean emergenciaActiva = false;

        System.out.println("============================================");
        System.out.println(" BIENVENIDO AL HOTEL GRAN VÍA - ASCENSOR ");
        System.out.println(" Edificio de 12 pisos (0 - 11)");
        System.out.println("============================================");

        int opcion;

        do {
            System.out.println("\n=== HOTEL GRAN VÍA - SISTEMA DE ASCENSOR ===");
            System.out.println("1. Llamar ascensor a mi piso");
            System.out.println("2. Ir a un piso específico");
            System.out.println("3. Abrir/Cerrar puerta manualmente");
            System.out.println("4. Ver estado del ascensor");
            System.out.println("5. EMERGENCIA");
            System.out.println("0. Salir");
            System.out.println("============================================");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(sc.nextLine());

            if (emergenciaActiva && opcion != 4 && opcion != 0) {
                System.out.println("⚠ El ascensor está en EMERGENCIA. No se puede usar.");
                continue;
            }

            switch (opcion) {

            case 1:
                System.out.print("¿En qué piso estás? (0-11): ");
                int pisoUsuario = Integer.parseInt(sc.nextLine());

                if (pisoUsuario < 0 || pisoUsuario > 11) {
                    System.out.println("Piso inválido.");
                    break;
                }

                System.out.println("El ascensor está en el piso " + ascensor.getPisoActual());

                if (pisoUsuario == ascensor.getPisoActual()) {
                    System.out.println("El ascensor ya está en tu piso.");
                    ascensor.abrirPuerta();
                } else {
                    ascensor.irAPiso(pisoUsuario);
                    ascensor.abrirPuerta();
                }

                System.out.println("El ascensor ha llegado a su piso.");
                break;

            case 2:
                System.out.print("¿A qué piso quiere ir? (0-11): ");
                int destino = Integer.parseInt(sc.nextLine());

                if (destino < 0 || destino > 11) {
                    System.out.println("Piso inválido.");
                    break;
                }

                if (ascensor.isPuertaAbierta()) {
                    System.out.println("Cerrando puerta automáticamente...");
                    ascensor.cerrarPuerta();
                }

                ascensor.irAPiso(destino);
                ascensor.abrirPuerta();

                System.out.println("Ha llegado al piso " + destino + ". ¡Que tenga un buen día!");
                break;

            case 3:
                System.out.println("a) Abrir puerta");
                System.out.println("b) Cerrar puerta");
                System.out.print("Seleccione opción: ");
                char sub = sc.next().toLowerCase().charAt(0);

                if (sub == 'a') {
                    if (!ascensor.abrirPuerta())
                        System.out.println("No se puede abrir la puerta.");

                } else if (sub == 'b') {
                    if (!ascensor.cerrarPuerta())
                        System.out.println("No se puede cerrar la puerta.");

                } else {
                    System.out.println("Opción inválida.");
                }
                break;

            case 4:
                ascensor.verificarEstado();
                mostrarEdificio(ascensor.getPisoActual());
                break;

            case 5:
                System.out.print("¿Está seguro de activar la emergencia? (s/n): ");
                char r = sc.next().toLowerCase().charAt(0);

                if (r == 's') {
                    ascensor.activarEmergencia();
                    emergenciaActiva = true;
                    System.out.println("⚠ EMERGENCIA ACTIVADA. El ascensor está fuera de servicio.");
                    System.out.println("Siga las instrucciones del personal del hotel.");
                }
                break;

            case 0:
                if (!emergenciaActiva) {
                    System.out.println("Llevando el ascensor al piso 0 antes de cerrar...");
                    ascensor.irAPiso(0);
                }
                System.out.println("Gracias por usar el sistema del Hotel Gran Vía.");
                break;

            default:
                System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarEdificio(int pisoAscensor) {
        System.out.println("\n===== ESTADO DEL EDIFICIO =====");
        for (int piso = 11; piso >= 0; piso--) {
            if (piso == pisoAscensor)
                System.out.println("Piso " + piso + ": [X] ← Ascensor");
            else
                System.out.println("Piso " + piso + ":");
        }
        System.out.println("================================");
    }
}
