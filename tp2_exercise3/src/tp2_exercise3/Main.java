package tp2_exercise3;

public class Main {

	public static void main(String[] args) {
		boolean result;
		
		BankAccount account = new BankAccount("Rich Pablo");
		account.deposit(777);
		
		result = account.extract(999);
		
		System.out.println("result["+result+"]: " + account.getMoney());
		
		result = account.extract(700);
		
		System.out.println("result["+result+"]: " + account.getMoney());

	}	

}
