
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Factura {

    private String numeroFactura;
    private LocalDate fecha;
    private String concepto;
    private double base;
    private double iva;

    // HECHA
    Factura() {
        this.fecha = LocalDate.now();
        this.concepto = "";
        this.base = 0.0;
        this.iva = 21.0;
        this.numeroFactura = generarNumeroFactura();
    }

    // HECHA
    Factura(LocalDate fecha, String concepto, double base, double iva) {
        this.fecha = fecha;
        this.concepto = concepto;
        this.base = base;
        this.iva = iva;
        this.numeroFactura = generarNumeroFactura();
    }

    // HECHA
    public String generarNumeroFactura() {
        Random rand = new Random();

        int num = rand.nextInt(9999) + 1;

        String numeroFormateado = String.format("%04d", num);

        return "FACT-" + numeroFormateado;
    }

    // HECHA
    public int calcularTotal() {
        double precioTotal = base + base * iva / 100;
        return (int) precioTotal;
    }

    // HECHA
    public boolean aplicarDescuento(double porcentaje) {
        if (porcentaje > 100 || porcentaje < 0) {
            return false;
        } else {
            base *= (100.0 - porcentaje) / 100.0;
            return true;
        }
    }

    // HECHA
    public boolean esAntigua() {
        LocalDate hoy = LocalDate.now();
        
        return fecha.isBefore(hoy.minusDays(30));
    }

    // GETTERS Y SETTERS
    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = generarNumeroFactura();
    }

    public String getFecha() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formato);
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    // HECHA
    @Override
    public String toString() {
        return "Número de factura: " + numeroFactura +
                "\nFecha: " + getFecha() +
                "\nConcepto: " + concepto +
                "\nBase imponible: " + base +
                "\nIVA (" + iva + "%): " + (base * iva / 100) +
                "\nTotal a pagar: " + calcularTotal();
    }

    // HECHA
    public void imprimirFactura() {
        System.out.println(toString());
    }

}
