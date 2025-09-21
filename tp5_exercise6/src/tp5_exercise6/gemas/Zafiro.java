package tp5_exercise6.gemas;

public class Zafiro implements IGema {

	@Override
	public String mezclar(IGema gema) {
		return gema.mezclarZafiro();
	}

	@Override
	public String mezclarRubi() {
		return "Erupción Volcánica";
	}

	@Override
	public String mezclarZafiro() {
		return "Inundación";
	}

	@Override
	public String mezclarEsmeralda() {
		return "Huracán";
	}

	@Override
	public String mezclarDiamante() {
		return "Granizo Asesino";
	}
}
