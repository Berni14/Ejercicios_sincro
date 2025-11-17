import java.util.Random;

public class Coche {
    private String marca;
    private int distanciaRecorrida;
    private int velocidadMax;
    private Random velocidadAleatoria;

    Coche(String marca, int velocidadMax) {
        this.marca = marca;
        this.velocidadMax = velocidadMax; // usar el valor que pasa el constructor
        this.distanciaRecorrida = 0;
        this.velocidadAleatoria = new Random();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(int distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public int acelerar() {
        int velocidadEstaVuelta = velocidadAleatoria.nextInt(velocidadMax + 1);
        distanciaRecorrida += velocidadEstaVuelta;
        return velocidadEstaVuelta;
    }

    public void reset() {
        distanciaRecorrida = 0;
    }

    @Override
    public String toString() {
        return "Coche " + marca + ": distancia recorrida = " + distanciaRecorrida;
    }

}
