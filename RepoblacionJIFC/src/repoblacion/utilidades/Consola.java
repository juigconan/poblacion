package repoblacion.utilidades;

import org.iesalandalus.programacion.utilidades.Entrada;

import repoblacion.modelo.Bosque;

public class Consola {

	private Consola() {
		
	}
	
	public static int leerAnchura() {
		int anchura = 0;
		
		do {
			System.out.print("Introduce la anchura del bosque:");
			anchura = Entrada.entero();
			if(anchura < Bosque.MINIMO || anchura > Bosque.MAX_ANCHURA) {
				System.out.printf("Anchura no valida, debe estar entre %d y %d.%n",Bosque.MINIMO, Bosque.MAX_ANCHURA);
			}
		} while (anchura < Bosque.MINIMO || anchura > Bosque.MAX_ANCHURA);
		
		return anchura;
	}
	
	public static int leerAltura() {
		int altura = 0;
		
		do {
			System.out.print("Introduce la altura del bosque:");
			altura = Entrada.entero();
			if(altura < Bosque.MINIMO || altura > Bosque.MAX_ALTURA) {
				System.out.printf("Altura no valida, debe estar entre %d y %d.%n",Bosque.MINIMO, Bosque.MAX_ALTURA);
			}
		} while (altura < Bosque.MINIMO || altura > Bosque.MAX_ALTURA);
		
		return altura;
	}
	
	public static int leerPoblacion() {
		int poblacion = 0;
		do {
			System.out.print("Introduce la poblacion del bosque:");
			poblacion = Entrada.entero();
			if(poblacion <= 0 ) {
				System.out.println("Poblacion no valida, debe de ser de al menos 1 arbol.");
			}
		} while (poblacion <= 0);
		
		return poblacion;
	}
	
}
