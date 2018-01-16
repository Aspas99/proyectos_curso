package principal;

import geometria.Circulo;
import geometria.Figura;
import geometria.Triangulo;

public class PruebaPolimorfismo {

	public PruebaPolimorfismo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Circulo cr=new Circulo("amarillo",4);
		Triangulo tr=new Triangulo("verde",9,4);
		//datos de circulo 
		System.out.println("Color :· "+cr.getColor());
		System.out.println("Superficie:"+cr.superficie());
		//datos de triangulo
		System.out.println("Color :· "+tr.getColor());
		System.out.println("Superficie:"+tr.superficie());
		//Version con polimorfismo
		mostrar(new Circulo("amarillo",4));
		mostrar(new Triangulo("verde",9,4));
		
	}
	private static void mostrar(Figura f) {
		System.out.println("Color :· "+f.getColor());
		System.out.println("Superficie:"+f.superficie());
	}

}
