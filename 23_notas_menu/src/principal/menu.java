package principal;

import java.util.Scanner;

import calculo.CalculoNotas;

public class menu {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		CalculoNotas n=new CalculoNotas();
		String valor;
		
		String opcion;
		do {
		    
		
			System.out.println("1.- Añadir nota");
			System.out.println("2.- Ver aprobados");
			System.out.println("3.- Nota media ");
			System.out.println("4.- Mostrar notas");
			System.out.println("5.- Salir");
			
			System.out.print("Introduzca la opción de menu: ");
			opcion=sc.nextLine();
			
			int t=Integer.valueOf(opcion);
			switch(t) {
				case 1:
						System.out.println("Introduzca una nota: ");
						valor=sc.nextLine();
						Double v=Double.valueOf(valor);
						if (v.doubleValue()>=0.0) {
							
							n.anadirNota(v);
						}else {
						System.out.println("¡la nota no puede ser negativa!");
						}
						
				break;
				case 2:
						if (n.size()==0) {
							System.out.println("No hay notas por mostrar");
						}else {
							System.out.println("Hay :" + n.aprobados() +" aprobados");
						}
						
					break;	
				case 3:
						System.out.println("La media es: " + n.media());
						break;
				case 4:
						if (n.size()==0) {
							System.out.println("No hay notas por mostrar");
						}else {
							for (Double p:n.muestraNotas()) {
								System.out.print(p + "\t");
							}
							System.out.println("");
							}
						break;
				case 5:{
					System.out.println("Hasta la próxima!");
					break;
				}default:
					System.out.println("Opción no disponible!");
		     }
			
		
			
		}while(!opcion.equals("5"));

	}

}
