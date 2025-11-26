import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Vuelos predefinidos en el enunciado
        Vuelo vuelo1 = new Vuelo("AA123", "Madrid", "Nueva York", 150);
        Vuelo vuelo2 = new Vuelo("IB456", "Barcelona", "Londres", 100);

        // Reservas individuales hasta 10 por si acaso
        Reserva reserva1 = null, reserva2 = null, reserva3 = null, reserva4 = null, reserva5 = null;
        Reserva reserva6 = null, reserva7 = null, reserva8 = null, reserva9 = null, reserva10 = null;

        int totalReservas = 0;
        // Menu del Sistema de gestion con las 5 opciones diferentes
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE GESTION DE VUELOS ===");
            System.out.println("1. Ver vuelos disponibles");
            System.out.println("2. Realizar reserva");
            System.out.println("3. Ver detalles de una reserva");
            System.out.println("4. Cancelar reserva");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                // Primer caso-> mostrar la informacion de los vuelos, en el caso de que hubiera
                // mas vuelos se añadiria
                case 1:
                    vuelo1.mostrarInformacionVuelo();
                    vuelo2.mostrarInformacionVuelo();
                    break;
                // Segundo caso -> Donde se realiza la reserva, solo toma el vuelo 1 y 2, sino
                // no se puede hacer la reserva
                case 2:
                    System.out.println("Seleccionar el vuelo (1 o 2): ");
                    int vueloSeleccionado = Integer.parseInt(sc.nextLine());
                    sc.nextLine();

                    Vuelo vueloElegido;
                    if (vueloSeleccionado == 1)
                        vueloElegido = vuelo1;
                    else
                        vueloElegido = vuelo2;

                    if (vueloElegido == null) {
                        System.out.println("Opcion incorrecta.");
                        break;
                    }
                    // si asiento == -1 significa que no quedan asientos disponibles y no se podra
                    // hacer la reserva
                    int asiento = vueloElegido.reservarAsiento();
                    if (asiento == -1) {
                        System.out.println(" El vuelo esta completo. No hay asientos disponibles.");
                        break;
                    }

                    System.out.print("Nombre del pasajero: ");
                    String nombre = sc.nextLine();
                    System.out.print("Numero de pasaporte: ");
                    String pasaporte = sc.nextLine();

                    String tipoClase = vueloElegido.asignarAsiento(asiento);
                    totalReservas++;
                    // Este comando sirve para crear el codigo con el formato R000
                    String codigoReserva = String.format("R%03d", totalReservas);
                    // Guarda la reserva
                    Reserva nuevaReserva = new Reserva(nombre, pasaporte, vueloElegido, asiento, tipoClase,
                            codigoReserva);
                    if (reserva1 == null)
                        reserva1 = nuevaReserva;
                    else if (reserva2 == null)
                        reserva2 = nuevaReserva;
                    else if (reserva3 == null)
                        reserva3 = nuevaReserva;
                    else if (reserva4 == null)
                        reserva4 = nuevaReserva;
                    else if (reserva5 == null)
                        reserva5 = nuevaReserva;
                    else if (reserva6 == null)
                        reserva6 = nuevaReserva;
                    else if (reserva7 == null)
                        reserva7 = nuevaReserva;
                    else if (reserva8 == null)
                        reserva8 = nuevaReserva;
                    else if (reserva9 == null)
                        reserva9 = nuevaReserva;
                    else if (reserva10 == null)
                        reserva10 = nuevaReserva;
                    else {
                        System.out.println("No se pueden crear mas reservas.");
                        break;
                    }

                    System.out.println(" Reserva confirmada - Codigo: " + codigoReserva);
                    break;

                case 3:
                    // Muestra por pantalla la reserva que he hecho
                    System.out.print("Introduce el codigo de la reserva: ");
                    String codigoBuscar = sc.nextLine();

                    Reserva encontrada = buscarReserva(codigoBuscar,
                            reserva1, reserva2, reserva3, reserva4, reserva5,
                            reserva6, reserva7, reserva8, reserva9, reserva10);

                    if (encontrada != null)
                        encontrada.mostrarInformacionReserva();
                    else
                        System.out.println(" No se encontro ninguna reserva con ese codigo");
                    break;

                case 4:
                    // Donde se cancela la reserva
                    // Importante que me suelo confundir!!!! .equals lo uso para ver si son iguales
                    // los codigos, no se usa == porque son strings
                    System.out.print("Introduce el codigo de la reserva a cancelar: ");
                    String codigoCancelar = sc.nextLine();

                    boolean cancelada = false;

                    if (reserva1 != null && reserva1.getCodigoReserva().equals(codigoCancelar)) {
                        vuelo1.setAsientosDisponibles(vuelo1.getAsientosDisponibles() + 1);
                        reserva1 = null;
                        cancelada = true;
                    } else if (reserva2 != null && reserva2.getCodigoReserva().equals(codigoCancelar)) {
                        vuelo1.setAsientosDisponibles(vuelo1.getAsientosDisponibles() + 1);
                        reserva2 = null;
                        cancelada = true;
                    }

                    if (cancelada)
                        System.out.println("Reserva cancelada exitosamente");
                    else
                        System.out.println("No se encontro ninguna reserva con ese codigo");
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema de gestion de vuelos.");
                    break;

                default:
                    System.out.println("Opcion invalida, intenta nuevamente.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }

    // for each para ver los codigos de todas las reservas
    public static Reserva buscarReserva(String codigo, Reserva... reservas) {
        for (Reserva r : reservas) {
            if (r != null && r.getCodigoReserva().equals(codigo))
                return r;
        }
        return null;
    }

    // Funcion usada en el caso 4, se mira 1 a 1 para liberaro
    public static boolean cancelarReserva(String codigo,
            Reserva r1, Reserva r2, Reserva r3, Reserva r4, Reserva r5,
            Reserva r6, Reserva r7, Reserva r8, Reserva r9, Reserva r10) {

        if (r1 != null && r1.getCodigoReserva().equals(codigo)) {
            liberar(r1);
            return true;
        }
        if (r2 != null && r2.getCodigoReserva().equals(codigo)) {
            liberar(r2);
            return true;
        }
        if (r3 != null && r3.getCodigoReserva().equals(codigo)) {
            liberar(r3);
            return true;
        }
        if (r4 != null && r4.getCodigoReserva().equals(codigo)) {
            liberar(r4);
            return true;
        }
        if (r5 != null && r5.getCodigoReserva().equals(codigo)) {
            liberar(r5);
            return true;
        }
        if (r6 != null && r6.getCodigoReserva().equals(codigo)) {
            liberar(r6);
            return true;
        }
        if (r7 != null && r7.getCodigoReserva().equals(codigo)) {
            liberar(r7);
            return true;
        }
        if (r8 != null && r8.getCodigoReserva().equals(codigo)) {
            liberar(r8);
            return true;
        }
        if (r9 != null && r9.getCodigoReserva().equals(codigo)) {
            liberar(r9);
            return true;
        }
        if (r10 != null && r10.getCodigoReserva().equals(codigo)) {
            liberar(r10);
            return true;
        }

        return false;
    }

    // Establece los valores a null
    private static void liberar(Reserva r) {
        Vuelo v = r.getVuelo();
        v.setAsientosDisponibles(v.getAsientosDisponibles() + 1);
        r = null;
    }

}
