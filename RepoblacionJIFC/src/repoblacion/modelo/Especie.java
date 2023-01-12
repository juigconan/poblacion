package repoblacion.modelo;

public enum Especie {
	ALAMO("�lamo"), ENCINA("Encina"), CASTANO("Casta�o"), CIPRES("Cipr�s"), PINO("Pino pi�onero"), ROBLE("Roble mediterraneo"),
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
