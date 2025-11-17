import java.util.Random;

public class Dados {
    private int numeroCaras, valorActual, ultimoValor;
    private Random aleatorio;

    Dados(int numeroCaras) {
        this.numeroCaras = numeroCaras;
        this.valorActual = 0;
        this.ultimoValor = 0;
        this.aleatorio = new Random();
    }

    public void lanzar() {
        ultimoValor = valorActual;
        valorActual = aleatorio.nextInt(numeroCaras) + 1;
    }

    public int getValorActual() {
        return valorActual;
    }

    public int getUltimoValor() {
        return ultimoValor;
    }

    public boolean esPar() {
        return valorActual % 2 == 0;
    }

    public void resetear() {
        valorActual = 0;
        ultimoValor = 0;
    }

    @Override
    public String toString() {
        return "Dado de " + numeroCaras +
                " caras | Valor actual: " + valorActual +
                " | Ultimo valor: " + ultimoValor;
    }

}
