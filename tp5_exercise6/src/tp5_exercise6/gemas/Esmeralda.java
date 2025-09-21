package tp5_exercise6.gemas;

public class Esmeralda implements IGema {

	@Override
	public String mezclar(IGema gema) {
		return gema.mezclarEsmeralda();
	}

	@Override
	public String mezclarRubi() {
		return "Terremoto";
	}

	@Override
	public String mezclarZafiro() {
		return "Huraćan";
	}

	@Override
	public String mezclarEsmeralda() {
		return "Niebla Desoladora";
	}

	@Override
	public String mezclarDiamante() {
		return "Vientos venenosos";
	}
}
