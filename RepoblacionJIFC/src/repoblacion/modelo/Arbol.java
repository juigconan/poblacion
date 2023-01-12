package repoblacion.modelo;

public class Arbol {

	private Especie especie;
	private Posicion posicion;

	public Arbol(Especie especie, Posicion posicion) {
		setEspecie(especie);
		setPosicion(posicion);
	}

	public Especie getEspecie() {
		return especie;
	}

	private void setEspecie(Especie especie) {
		if(especie == null) {
			throw new NullPointerException("La especie no puede ser nula");
		}
		this.especie = especie;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	private void setPosicion(Posicion posicion) {
		if(posicion == null) {
			throw new NullPointerException("La posicion no puede ser nula");
		}
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		if(this.getEspecie() == Especie.ENCINA) {
			String cadenaAMostrar = "Una %s, en la posicion %s";
			return String.format(cadenaAMostrar, getEspecie().toString(), getPosicion().toString());
		}
		String cadenaAMostrar = "Un %s, en la posicion %s";
		return String.format(cadenaAMostrar, getEspecie().toString(), getPosicion().toString());
	}

}
