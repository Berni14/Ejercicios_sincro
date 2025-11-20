import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nombre del jugador 1");
        String nombre1 = sc.nextLine();

        System.out.println("Nombre del jugador 2");
        String nombre2 = sc.nextLine();

        Dados j1d1 = new Dados(6);
        Dados j1d2 = new Dados(6);
        Dados j2d1 = new Dados(6);
        Dados j2d2 = new Dados(6);

        int puntosJ1 = 0;
        int puntosJ2 = 0;

        int doblesParesJ1 = 0;
        int doblesParesJ2 = 0;

        System.out.println("======================");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Ronda " + i);

            j1d1.lanzar();
            j1d2.lanzar();

            int suma1 = j1d1.getValorActual() + j1d2.getValorActual();

            System.out.println(nombre1 + " -> D1: " +
                    j1d1.getValorActual() + ", D2: " +
                    j1d2.getValorActual() + " | Suma: " + suma1);

            boolean bonus1 = false;
            if (j1d1.getValorActual() == j1d2.getValorActual() && j1d1.esPar()) {
                bonus1 = true;
                doblesParesJ1++;
            }

            j2d1.lanzar();
            j2d2.lanzar();
            int suma2 = j2d1.getValorActual() + j2d2.getValorActual();

            System.out.println(nombre2 + " -> D1: " +
                    j2d1.getValorActual() + ", D2: " +
                    j2d2.getValorActual() + " | Suma: " + suma2);

            boolean bonus2 = false;
            if (j2d1.getValorActual() == j2d2.getValorActual() && j2d1.esPar()) {
                bonus2 = true;
                doblesParesJ2++;
            }

            if (suma1 > suma2) {
                System.out.println("Ganador de la ronda: " + nombre1);
                puntosJ1++;
            } else if (suma2 > suma1) {
                System.out.println("Ganador de la ronda: " + nombre2);
                puntosJ2++;
            } else {
                System.out.println("Empate, ambos ganan 1 punto");
                puntosJ1++;
                puntosJ2++;
            }

            if (bonus1) {
                System.out.println(nombre1 + " obtiene BONUS (+1 punto)");
                puntosJ1++;
            }
            if (bonus2) {
                System.out.println(nombre2 + " obtiene BONUS (+1 punto)");
                puntosJ2++;
            }

            System.out.println("Marcador -> " + nombre1 + ": " + puntosJ1 + " | " + nombre2 + ": " + puntosJ2 + "\n");
        }

        System.out.println("===== RESULTADO FINAL =====");
        System.out.println(nombre1 + ": " + puntosJ1);
        System.out.println(nombre2 + ": " + puntosJ2);

        if (puntosJ1 > puntosJ2) {
            System.out.println("GANADOR: " + nombre1);
        } else if (puntosJ2 > puntosJ1) {
            System.out.println("GANADOR: " + nombre2);
        } else {
            System.out.println("EMPATE TOTAL");
        }

        System.out.println("\nEstadísticas:");
        System.out.println(nombre1 + " -> Dobles pares: " + doblesParesJ1);
        System.out.println(nombre2 + " -> Dobles pares: " + doblesParesJ2);

        sc.close();
    }
}
