package tp5_exercise3;

public class TorreVigilancia extends Edificio implements IHostil {

	public TorreVigilancia(String equipo, int x, int y, int tiempoConstruccion) {
		super(equipo, 200, 2000, x, y, tiempoConstruccion);
	}

	@Override
	public void recibeDano(int cantidad) {
		this.setEnergia( this.getEnergia() - cantidad );
	}
	
	@Override
	public void atacar(Unidad adversario) {
		adversario.recibeDano(10);
	}

}
