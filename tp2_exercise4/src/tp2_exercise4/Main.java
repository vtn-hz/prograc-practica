package tp2_exercise4;

public class Main {

	public static void main(String[] args) {
		Employee emp = new Employee("Pablito", "+54 223 112-3012", "pablo@gmail.com");
		Order order = new Order(emp, "30-08-2025");
		
		Product p1, p2;
		
		p1 = new Product("sku1", "name 1", 1000);
		p2 = new Product("sku2", "name 2", 2000);

		order.addItem(p1, 1);
		order.addItem(p1, 1);
		order.addItem(p1, 1);
		
		order.addItem(p2, 2);
		
		order.collectTotals();
		order.print();
	}

}
