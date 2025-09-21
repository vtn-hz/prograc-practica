package tp5_exercise6.gemas;

public class Diamante implements IGema {

	@Override
	public String mezclar(IGema gema) {
		return gema.mezclarDiamante();
	}

	@Override
	public String mezclarRubi() {
		return "Tormenta de Rayos";
	}

	@Override
	public String mezclarZafiro() {
		return "Granizo Asesino";
	}

	@Override
	public String mezclarEsmeralda() {
		return "Vientos venenosos";
	}

	@Override
	public String mezclarDiamante() {
		return "Congelamiento";
	}
}
