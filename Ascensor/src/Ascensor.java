public class Ascensor {
    private int pisoActual;
    private int pisoMaximo;
    private boolean enMovimiento;
    private boolean puertaAbierta;

    Ascensor() {
        this.pisoActual = 0;
        this.pisoMaximo = 10;
        this.enMovimiento = false;
        this.puertaAbierta = false;
    }


    Ascensor(int pisoMaximo) {
        this.pisoActual = 0;
        this.pisoMaximo = pisoMaximo;
        this.enMovimiento = false;
        this.puertaAbierta = false;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public int getPisoMaximo() {
        return pisoMaximo;
    }

    public boolean isEnMovimiento() {
        return enMovimiento;
    }

    public boolean isPuertaAbierta() {
        return puertaAbierta;
    }


    public boolean abrirPuerta() {
        if (enMovimiento) {
            System.out.println("No se puede abrir la puerta en movimiento.");
            return false;
        }
        if (puertaAbierta) {
            System.out.println("La puerta ya está abierta.");
            return false;
        }

        puertaAbierta = true;
        System.out.println("Puerta abierta.");
        return true;
    }

    public boolean cerrarPuerta() {
        if (!puertaAbierta) {
            System.out.println("La puerta ya está cerrada.");
            return false;
        }

        puertaAbierta = false;
        System.out.println("Puerta cerrada.");
        return true;
    }


    public boolean subirPiso() {
        if (puertaAbierta) {
            System.out.println("No se puede subir con la puerta abierta.");
            return false;
        }
        if (pisoActual == pisoMaximo) {
            System.out.println("Ya estás en el piso máximo.");
            return false;
        }

        enMovimiento = true;
        pisoActual++;
        enMovimiento = false;

        System.out.println("Subiste al piso " + pisoActual);
        return true;
    }

    public boolean bajarPiso() {
        if (puertaAbierta) {
            System.out.println("No se puede bajar con la puerta abierta.");
            return false;
        }
        if (pisoActual == 0) {
            System.out.println("Ya estás en la planta baja.");
            return false;
        }

        enMovimiento = true;
        pisoActual--;
        enMovimiento = false;

        System.out.println("Bajaste al piso " + pisoActual);
        return true;
    }


    public boolean irAPiso(int pisoDestino) {


        if (puertaAbierta) {
            cerrarPuerta();
        }

        if (pisoDestino < 0 || pisoDestino > pisoMaximo) {
            System.out.println("Número de piso inválido.");
            return false;
        }

        if (pisoDestino == pisoActual) {
            System.out.println("Ya estás en el piso " + pisoActual);
            return true;
        }

        enMovimiento = true;


        if (pisoDestino > pisoActual) {
            for (int i = pisoActual + 1; i <= pisoDestino; i++) {
                System.out.println("Subiendo... piso " + i);
                pisoActual = i;
            }
        }

        else {
            for (int i = pisoActual - 1; i >= pisoDestino; i--) {
                System.out.println("Bajando... piso " + i);
                pisoActual = i;
            }
        }

        enMovimiento = false;

        System.out.println("Llegaste al piso " + pisoActual);
        return true;
    }


    public void activarEmergencia() {
        enMovimiento = false;
        puertaAbierta = true;
        System.out.println("Emergencia activada en el piso " + pisoActual);
        System.out.println("Puerta abierta por seguridad.");
    }


    public void verificarEstado() {
        System.out.println("------ ESTADO DEL ASCENSOR ------");
        System.out.println("Piso actual: " + pisoActual);
        System.out.println("Puerta: " + (puertaAbierta ? "Abierta" : "Cerrada"));
        System.out.println("Movimiento: " + (enMovimiento ? "En movimiento" : "Detenido"));
        System.out.println("Piso máximo del edificio: " + pisoMaximo);
        System.out.println("---------------------------------");
    }
}
