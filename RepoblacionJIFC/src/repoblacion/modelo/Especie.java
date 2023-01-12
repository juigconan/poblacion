package repoblacion.modelo;

public enum Especie {
	ALAMO("Álamo"), ENCINA("Encina"), CASTANO("Castaño"), CIPRES("Ciprés"), PINO("Pino piñonero"), ROBLE("Roble mediterraneo"),
	OLIVO("Olivo");

	private String cadenaAMostrar;

	private Especie(String nombre) {
		cadenaAMostrar = nombre;
	}

	@Override
	public String toString() {
		return cadenaAMostrar;
	}
}
