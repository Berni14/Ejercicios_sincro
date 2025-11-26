public class Vuelo {
    private String numeroVuelo, origen, destino;
    private int asientosDisponibles;
    private int capacidadTotal;

    // Constructor vacio
    public Vuelo() {
        this.numeroVuelo = "";
        this.origen = "";
        this.destino = "";
        this.asientosDisponibles = 0;
        this.capacidadTotal = 0;
    }

    // Constructor con parametros
    public Vuelo(String numeroVuelo, String origen, String destino, int asientosDisponibles) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.asientosDisponibles = asientosDisponibles;
        this.capacidadTotal = asientosDisponibles;
    }

    // Getters y setters automaticos
    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    // Funcion para comprobar si hay asientos libres
    private boolean asientoLibre() {
        return asientosDisponibles > 0;
    }

    // Funcion que reserva asiento y devuelve el asignado
    public int reservarAsiento() {
        if (asientoLibre()) {
            int asientoAsignado = capacidadTotal - asientosDisponibles + 1;
            asientosDisponibles--;
            return asientoAsignado;
        } else {
            return -1; // En caso de que no quedaran asientos libres
        }
    }

    // Funcion para asignar la clase que sea el asiento
    public String asignarAsiento(int numeroAsiento) {
        int primeraClaseLimite = (int) (Math.ceil(capacidadTotal * 0.10)); // 10% asientos, la funcion ceil sirve para redondear a lo alto
        int businessLimite = (int) Math.ceil(capacidadTotal * 0.30); // 20% siguiente

        if (numeroAsiento <= primeraClaseLimite) {
            return "Primera Clase";
        } else if (numeroAsiento <= businessLimite) {
            return "Clase Business";
        } else {
            return "Clase Turista";
        }
    }

    // Funcion para mostrar la informacion del vuelo
    public void mostrarInformacionVuelo() {
        System.out.println("\n=== Información del vuelo ===");
        System.out.println("Número de vuelo: " + numeroVuelo);
        System.out.println("Ciudad de origen: " + origen);
        System.out.println("Ciudad de destino: " + destino);
        System.out.println("Asientos disponibles: " + asientosDisponibles + " / " + capacidadTotal);
    }
}
