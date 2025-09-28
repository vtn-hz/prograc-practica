package tp6_exercise3;

import tp6_exercise3.exceptions.*;
import java.lang.Math;

public class Surtidor {

	private double cantidadDiesel;
	
	private double cantidadPremium;
	
	private double cantidadSuper;

	public Surtidor() {
		this.cantidadDiesel = 20000;
		this.cantidadPremium = 20000;
		this.cantidadSuper = 20000;
	}
	
	public void cargaCombustible(String combustible, double cantidad) throws CargaInvalidaException {
		double cantidadDisponible = -1;

		switch(combustible) {
			case "diesel": 	cantidadDisponible = this.getCantidadDiesel(); 
							this.cantidadDiesel = cantidad > 0 ? Math.max(0, cantidadDisponible - cantidad) : cantidadDisponible;
			break;
			
			case "premium": cantidadDisponible = this.getCantidadPremium();
							this.cantidadPremium = cantidad > 0 ? Math.max(0, cantidadDisponible - cantidad) : cantidadDisponible;
			break;
			
			case "super": 	cantidadDisponible = this.getCantidadSuper();  
							this.cantidadSuper = cantidad > 0 ? Math.max(0, cantidadDisponible - cantidad) : cantidadDisponible;
			break;
			
			default: throw new TipoCombustibleInvalidoException("tipo combustible invalido", combustible, cantidad, cantidadDisponible);
		}
		
		if (cantidad < 0) {
			throw new CargaInvalidaException("cantidad de carga invalida", combustible, cantidad, cantidadDisponible); 
		}
		
		if (cantidad > cantidadDisponible) {
			throw new FaltaCombustibleException("falta combustible", combustible, cantidad, cantidadDisponible);
		}
		
	}
	
	public double getCantidadDiesel() {
		return cantidadDiesel;
	}

	public double getCantidadPremium() {
		return cantidadPremium;
	}

	public double getCantidadSuper() {
		return cantidadSuper;
	}
	
	public void llenarDiesel() {
		this.cantidadDiesel = 20000;
	}
	
	public void llenarPremium() {
		this.cantidadPremium = 20000;
	}
	
	public void llenarSuper() {
		this.cantidadSuper = 20000;
	}

}
