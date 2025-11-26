public class Reserva {
    private String nombrePasajero;
    private String numeroPasaporte;
    private int numeroAsiento;
    private String tipoClase;
    private String codigoReserva;

    Vuelo vuelo = new Vuelo();

    public Reserva(String nombrePasajero, String numeroPasaporte, Vuelo vuelo, int numeroAsiento, String tipoClase,
            String codigoReserva) {
        this.nombrePasajero = nombrePasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.vuelo = vuelo;
        this.numeroAsiento = numeroAsiento;
        this.tipoClase = tipoClase;
        this.codigoReserva = codigoReserva;
    }

    // Getters
    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    // Mostrar información completa de la reserva
    public void mostrarInformacionReserva() {
        System.out.println("\n=== Informacion de la reserva ===");
        System.out.println("Codigo de reserva: " + codigoReserva);
        System.out.println("Nombre del pasajero: " + nombrePasajero);
        System.out.println("Número de pasaporte: " + numeroPasaporte);
        if (numeroAsiento != -1) {
            System.out.println("Numero de asiento: " + numeroAsiento);
            System.out.println("Clase: " + tipoClase);
        }
        vuelo.mostrarInformacionVuelo();
    }
}
