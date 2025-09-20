package tp5_exercise3;

public class Soldado extends Personaje implements IHostil {

	public Soldado(String equipo, int x, int y) {
		super(equipo, 100, 500, x, y);
	}

	@Override
	public void recibeDano(int cantidad) {
		this.setEnergia( this.getEnergia() - cantidad );
	}

	@Override
	public void atacar(Unidad adversario) {
		adversario.recibeDano(50);
	}

}
