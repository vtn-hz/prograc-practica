package tp6_exercise1;

public class Main {

	public static void main(String[] args) {
		try {
			User user = new User("Pablo", "1234");
		} catch (NombreInvalidoException | ContrasenaInvalidaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

}
