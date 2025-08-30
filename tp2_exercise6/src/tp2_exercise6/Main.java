package tp2_exercise6;

public class Main {
	
	/** 
	 * 3.
	 * Se podria haber diseñado una variable estatica
	 * que estableciera un top, quien cumpla con ese valor
	 * retorna true, sino retorna false
	 * asi se sabria quien es el que mas vendio
	 * */ 
	public static void main(String[] args) {
		String[] types = { "gasoil", "premium", "super" };
		FuelPump fp1 = new FuelPump(types);
		FuelPump fp2 = new FuelPump(types);
		
		// Simulación de ventas
		fp1.extractFuel(12000, "gasoil");
		fp1.extractFuel(7000, "gasoil");
		fp1.extractFuel(9000, "premium");
		
		fp2.extractFuel(15000, "gasoil");
		fp2.extractFuel(3000, "super");
		
		// 1. Cantidad total de surtidores
		System.out.println("Cantidad de surtidores: " + FuelPump.getInstanceCount());
		
		// 2. Existencia en litros de un combustible (ej: gasoil en surtidor 1)
		System.out.println("Existencia de gasoil en fp1: " + fp1.getFuelAmount("gasoil"));
		fp1.restoreFuel("gasoil");
		System.out.println("Existencia de gasoil en fp1: " + fp1.getFuelAmount("gasoil"));
		
		// 3. Informar el surtidor con mayor cantidad de ventas de un tipo de combustible
		// --- agregado ---
		FuelPump[] pumps = { fp1, fp2 };
		String type = "gasoil";
		FuelPump topSeller = pumps[0];
		for (FuelPump p : pumps) {
			if (p.soldFuelCant(type) > topSeller.soldFuelCant(type)) {
				topSeller = p;
			}
		}
		System.out.println("Surtidor con más ventas de " + type + ": " + topSeller);
		
		// 4. Histórico de litros vendidos
		// --- agregado ---
		System.out.println("\nHistórico surtidor 1:");
		fp1.showSalesHistory();
		
		System.out.println("\nHistórico surtidor 2:");
		fp2.showSalesHistory();
		
		// Total por estación (suma de los surtidores)
		int totalEstacion = 0;
		for (FuelPump p : pumps) {
			totalEstacion += p.soldFuelAmount(type);
		}
		System.out.println("\nTotal de litros vendidos de " + type + " en la estación: " + totalEstacion);
	}
}
