package repoblacion.modelo;

public class Posicion {

	double x;
	double y;

	public Posicion(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distancia(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("La posicion no puede ser nula");
		}
		return Math.sqrt((Math.pow(x - posicion.getX(), 2)) + (Math.pow(y - posicion.getY(), 2)));
	}

	@Override
	public String toString() {
		String cadenaAMostrar = "x=%.3f y=%.3f";
		return String.format(cadenaAMostrar, x, y);
	}
}
