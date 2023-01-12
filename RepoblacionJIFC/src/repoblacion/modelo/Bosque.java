package repoblacion.modelo;

import java.util.Random;

public class Bosque {

	public static final int MAX_ANCHURA = 1000;
	public static final int MAX_ALTURA = 500;
	public static final int MINIMO = 10;
	private int ancho;
	private int alto;
	private Random generador = new Random();
	private Arbol arbolMasCentrado;
	private Arbol arbolMasAlejado;
	private Arbol[] poblacion;
	
	public Bosque(int ancho, int alto, int poblacion) {
		if (ancho < MINIMO || ancho > MAX_ANCHURA) {
			throw new IllegalArgumentException("Anchura no valida, debe estar entre 10 y 1000.");
		}
		if (alto < MINIMO || alto > MAX_ALTURA) {
			throw new IllegalArgumentException("Altura no valida, debe estar entre 10 y 500.");
		}
		if(poblacion > 2*(ancho+alto)) {
			throw new IllegalArgumentException("La poblacion excede la capacidad del bosque.");
		}
		this.ancho = ancho;
		this.alto = alto;
		this.poblacion = new Arbol[poblacion];
		repoblar();
	}
	
	private void repoblar() {
		int indiceEspecie;
		double posX;
		double posY;
		for (int i = 0; i < poblacion.length; i++) {
			indiceEspecie = generador.nextInt(Especie.values().length);
			//Con negateExact cogemos el valor negativo del int introducido y ponemos el tope como el (alto/2)+1 puesto que el segundo valor del metodo es exclusivo
			//Ademas hacemos un casting a double para que los valores sean correctos
			posX = generador.nextDouble((double)Math.negateExact(alto)/2,(double)(alto/2)+1);
			posY = generador.nextDouble((double)Math.negateExact(ancho)/2,(double)(ancho/2)+1);
			poblacion[i] = new Arbol(Especie.values()[indiceEspecie], new Posicion(posX, posY));
		}
	}
	
	public void realizarCalculos() {
		//Creamos la posicion centro para no crear una nueva posicion 0,0 cada vuelta del bucle
		Posicion centro = new Posicion(0, 0);
		//Asignamos el valor de la posicion 0 a ambos arboles ahorrandonos asi una vuelta del bucle
		arbolMasAlejado = poblacion[0];
		arbolMasCentrado = poblacion[0];
		for (int i = 1; i < poblacion.length; i++) {
			if (poblacion[i].getPosicion().distancia(centro) < arbolMasCentrado.getPosicion().distancia(centro)) {
				//Aunque podria existir aliasing no creamos un arbol nuevo ya uqqe queremos que al buscar el mas centrado nos apunte a este en concreto
				arbolMasCentrado = poblacion[i];
			}
			if (poblacion[i].getPosicion().distancia(centro) > arbolMasAlejado.getPosicion().distancia(centro)) {
				//Aunque podria existir aliasing no creamos un arbol nuevo ya uqqe queremos que al buscar el mas centrado nos apunte a este en concreto
				arbolMasAlejado = poblacion[i];
			}
		}
	}

	public Arbol getArbolMasCentrado() {
		return arbolMasCentrado;
	}

	public Arbol getArbolMasAlejado() {
		return arbolMasAlejado;
	}
	
}
