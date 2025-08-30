package tp2_exercise4;

public class RowItem {
	private Product product;
	
	private int qty;
	
	public RowItem(Product product, int qty) {
		super();
		this.qty = qty;
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Product getProduct() {
		return product;
	}
	
	public void addQty (int qty) {
		this.setQty( this.getQty() + qty );
	}
	
	public String getSku() {
		return this.product.getSku();
	}

	@Override
	public String toString() {
		return "RowItem [product=" + product + ", qty=" + qty + "]";
	}
	
}
