package tp2_exercise6;

import java.util.ArrayList;

public class Record {
	private ArrayList<RecordItem> items = new ArrayList<RecordItem>();
	
	public void save (int amount, String type) {
		items.add( new RecordItem(amount, type) );
	}
	
	public int getSoldAmountByType (String type) {
		int amount = 0;
		
		for(RecordItem item: this.items) {
			if (item.getType().equals(type))
				amount += item.getSoldAmount();
		}
		
		return amount;
	}
	
	public int getSoldCantByType (String type) {
		int cant = 0;
		
		for(RecordItem item: this.items) {
			if (item.getType().equals(type))
				cant++;
		}
		
		return cant;
	}
	
	public void print () {
		for(RecordItem item: this.items) {
			System.out.println(item);
		}
	}
	
	
}	
