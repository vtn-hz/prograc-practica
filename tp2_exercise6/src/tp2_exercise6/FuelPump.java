package tp2_exercise6;

import java.lang.Math;

public class FuelPump {
	private FuelCollection fuelCollection;
	
	private static int instanceCount = 0 ;
	
	private Record record;

	public FuelPump(String[] fuelTypes) {
		super();
		this.fuelCollection = new FuelCollection(fuelTypes);
		this.record = new Record();
		FuelPump.instanceCount++;
	}
	
	public static int getInstanceCount () {
		return FuelPump.instanceCount;
	}
	
	public boolean extractFuel (int amount, String type) {
		int previousAmount = this.getFuelAmount(type);
		this.record.save(Math.min(previousAmount, amount), type);
		
		Fuel fuel = this.fuelCollection.getByType(type);
		if (fuel == null) {
			return false;
		}
		
		return fuel.extract(amount);	
	}
	
	public int getFuelAmount (String type) {
		Fuel fuel = this.fuelCollection.getByType(type);
		if (fuel == null) {
			return 0;
		}
		
		return fuel.getAmount();
	}
	
	public void restoreFuel(String type) {
		Fuel fuel = this.fuelCollection.getByType(type);
		if (fuel != null) {
			fuel.restore();
		}
	}
	
	public int soldFuelCant (String type) {
		return this.record.getSoldCantByType(type);
	}
	
	public int soldFuelAmount(String type) {
		return this.record.getSoldAmountByType(type);
	}
	
	public void showSalesHistory () {
		this.record.print();
	}
}
