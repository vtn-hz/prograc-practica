package tp5_exercise6;

public class CofreMalvado implements ICofre {

	@Override
	public void abrir(IHechizable hcz) {
		hcz.serMaldito();
	}

}
