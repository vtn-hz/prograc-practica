package tp5_exercise6;

public class CofreBueno implements ICofre {

	@Override
	public void abrir(IHechizable hcz) {
		hcz.serBendecido();
	}

}
