package repoblacion;

import repoblacion.modelo.Bosque;
import repoblacion.utilidades.Consola;

public class MainApp {
	private static Bosque bosque;

	public static void main(String[] args) {
		int anchura;
		int altura;
		anchura = Consola.leerAnchura();
		altura = Consola.leerAltura();
		do {
			try {
				bosque = new Bosque(anchura, altura, Consola.leerPoblacion());
			} catch (IllegalArgumentException e) {
				System.out.println("ERROR: " + e.getMessage());
			}
		} while (bosque == null);
		bosque.realizarCalculos();
		System.out.printf("Arbol más cercano: %s%n", bosque.getArbolMasCentrado().toString());
		System.out.printf("Arbol más alejado: %s", bosque.getArbolMasAlejado().toString());
	}
}
