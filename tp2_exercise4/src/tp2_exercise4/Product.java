package tp2_exercise4;

public class Product {
	private String sku;
	
	private String description;
	
	private double price;

	public Product(String sku, String description, double price) {
		super();
		this.sku = sku;
		this.description = description;
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return  "[" + sku + ", " + price + "]";
	}
	
}	
