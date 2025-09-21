package tp5_exercise6.gemas;

public class Rubi implements IGema {

	@Override
	public String mezclar(IGema gema) {
		return gema.mezclarRubi();
	}

	@Override
	public String mezclarRubi() {
		return "Lluvia de fuego";
	}

	@Override
	public String mezclarZafiro() {
		return "Erupción Volcánica";
	}

	@Override
	public String mezclarEsmeralda() {
		return "Terremoto";
	}

	@Override
	public String mezclarDiamante() {
		return "Tormenta de Rayos";
	}
}
