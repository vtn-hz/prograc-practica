package tp2_exercise6;

import java.util.HashMap;

public class FuelCollection {
	private HashMap<String, Fuel> avaialableFuel;
	
	public FuelCollection(String[] types) {
		this.avaialableFuel = new HashMap<String, Fuel>(); 
		for(String type: types) {
			this.avaialableFuel.put(type, new Fuel(type));
		}
	}
	
	public Fuel getByType (String type) {
		return this.avaialableFuel.get(type);
	}
}
