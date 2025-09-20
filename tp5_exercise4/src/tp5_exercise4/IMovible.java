package tp5_exercise4;

public interface IMovible {
	double getPosx();
	
	double getPosy();
	
	void setXY(double x, double y);
	
	void incrementaPos(double valX, double valY);
	
	double distancia(IMovible movible);
}
