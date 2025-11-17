import java.util.Scanner;

public class CarreraCoches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la marca del Coche 1:");
        String marca1 = sc.nextLine();
        System.out.println("Introduce la marca del Coche 2:");
        String marca2 = sc.nextLine();

        Coche coche1 = new Coche(marca1, 120);
        Coche coche2 = new Coche(marca2, 120);

        int puntosCoche1 = 0;
        int puntosCoche2 = 0;
        int vueltas = 5;

        System.out.println("\n=== INICIA LA CARRERA ===");

        for (int i = 1; i <= vueltas; i++) {
            System.out.println("\n--- Vuelta " + i + " ---");

            int distancia1 = coche1.acelerar();
            int distancia2 = coche2.acelerar();

            System.out.println(coche1.getMarca() + " recorrió esta vuelta: " + distancia1);
            System.out.println(coche2.getMarca() + " recorrió esta vuelta: " + distancia2);

            if (distancia1 > distancia2) {
                puntosCoche1++;
                System.out.println(coche1.getMarca() + " gana la vuelta.");
            } else if (distancia2 > distancia1) {
                puntosCoche2++;
                System.out.println(coche2.getMarca() + " gana la vuelta.");
            } else {
                puntosCoche1++;
                puntosCoche2++;
                System.out.println("Empate en la vuelta. Ambos obtienen 1 punto.");
            }

            if (distancia1 > distancia2) {
                puntosCoche1++;
                System.out.println("BONUS: " + coche1.getMarca() + " obtiene 1 punto extra por velocidad máxima en la vuelta.");
            } else if (distancia2 > distancia1) {
                puntosCoche2++;
                System.out.println("BONUS: " + coche2.getMarca() + " obtiene 1 punto extra por velocidad máxima en la vuelta.");
            }

            System.out.println("Marcador actual: " + coche1.getMarca() + " = " + puntosCoche1 + " | " +
                    coche2.getMarca() + " = " + puntosCoche2);
        }

        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println(coche1.getMarca() + " recorrió en total: " + coche1.getDistanciaRecorrida());
        System.out.println(coche2.getMarca() + " recorrió en total: " + coche2.getDistanciaRecorrida());

        System.out.println("\nMarcador final: " + coche1.getMarca() + " = " + puntosCoche1 +
                " | " + coche2.getMarca() + " = " + puntosCoche2);

        if (puntosCoche1 > puntosCoche2) {
            System.out.println("¡El ganador es " + coche1.getMarca() + "!");
        } else if (puntosCoche2 > puntosCoche1) {
            System.out.println("¡El ganador es " + coche2.getMarca() + "!");
        } else {
            System.out.println("¡La carrera terminó en empate!");
        }
        sc.close();
    }
}
