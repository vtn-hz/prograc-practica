
package tp6_exercise6;

public class Automovil implements Cloneable {
    private String marca;
    private String modelo;
    private Motor motor;
    private String patente;

    public Automovil() {
        super();
    }

    public Automovil(String marca, String modelo, Motor motor, String patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
	    Automovil aux = (Automovil) super.clone();
	    Motor motorClonado=new Motor();
	    motorClonado.setFabricante(this.motor.getFabricante());
	    motorClonado.setNSerie(this.motor.getNSerie());
	    motorClonado.setPotencia(this.motor.getPotencia());
	    
	    aux.setMotor( (Motor) this.motor.clone() );
	    // aux.setMotor(motorClonado);
		
	    return aux;
    }
}