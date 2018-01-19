package principal;

import java.util.Scanner;

import contactos.GestionContactos;

public class Presentacion {
	//el ejercicio hará lo siguiente
	//1.-Agregar contactos ->pedirá nombre, mail y telefono
	//2.-Recuperar contactos ->pedirá el email, elimnando todos los que correspndan
	//3.-Salir
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String opcion;
		int t=0;
		System.out.println("1.-Agregar contactos");
		System.out.println("2.-Eliminar contactos");
		System.out.println("3.-Salir");
		System.out.println("Introduzca la opcion:");
		opcion=sc.nextLine().toString();
		t=Integer.valueOf(opcion);
		
		switch(t) {
			case 1:{
				leerContacto();
				break;
			}case 2:{
				eliminarContacto();
				break;
			}
			case 3:{
				System.out.println("Fin de programa!");
				break;
			}default: System.out.println("Opcion no disponible");
		}
			

	}
	static void leerContacto() {
		Scanner sc= new Scanner(System.in);
		String nombre,email;
		
		GestionContactos agenda=new GestionContactos();
		System.out.println("Introduce el nombre:");
		nombre=sc.nextLine();
		System.out.println("Introduce el email:");
		email=sc.nextLine();
		System.out.println("Introduce el telefono:");
		String tel=sc.nextLine();
		agenda.alta(nombre, email, Integer.valueOf(tel));
	}
	
	static void eliminarContacto() {
		Scanner sc= new Scanner(System.in);
		String email;
		
		GestionContactos agenda=new GestionContactos();
		
		System.out.println("Introduce el email:");
		email=sc.nextLine();
		
		agenda.eliminar(email);
	}
		
		
		
}


