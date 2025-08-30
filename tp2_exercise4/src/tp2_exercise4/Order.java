package tp2_exercise4;

import java.util.ArrayList;

public class Order {
	private ArrayList<RowItem> items;
	
	private Employee employee;
	
	private String date;
	
	private double totalAmount;

	public Order(Employee employee, String date) {
		super();
		this.items = new ArrayList<RowItem>();
		this.employee = employee;
		this.date = date;
	} 
	
	public void addItem (Product product, int qty) {
		RowItem item = this.getItem(product);
		if (item != null) 
			item.addQty(qty);
		else
			this.items.add( new RowItem(product, qty) );
		
	} 
	
	/** is this allow? */
	public RowItem getItem(Product product) {
	    for (RowItem item : items) {
	        if (item.getProduct() == product) {
	            return item;
	        }
	    }
	    
	    return null;
	}
	
	public void collectTotals () {
		float totals = 0;
		for (RowItem item : this.items) {
			totals += item.getQty() * item.getProduct().getPrice();
		}
		this.totalAmount = totals;
	}
	
	public void print() {
		System.out.println( this.employee );
		System.out.println( this.date );
		System.out.println( "---" );
		
		for (RowItem item : this.items) {
			System.out.println( item );
		}
		
		System.out.println( "---" );
		System.out.println( this.totalAmount );		
	}
}
