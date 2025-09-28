
package tp6_exercise6;

public class Motor implements Cloneable {
    private String fabricante;
    private String nSerie;
    private double potencia;

    public Motor() {
        super();
    }

    public Motor(String fabricante, String nSerie, double potencia) {
        this.fabricante = fabricante;
        this.nSerie = nSerie;
        this.potencia = potencia;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getNSerie() {
        return nSerie;
    }

    public void setNSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    @Override
    public Motor clone() throws CloneNotSupportedException {
        return (Motor) super.clone();
    }
}




