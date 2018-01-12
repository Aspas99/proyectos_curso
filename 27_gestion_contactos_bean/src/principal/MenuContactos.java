package principal;
import java.util.Scanner;

import beans.Contacto;
import gestioncontactos.GestionContactos;

public class MenuContactos {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		
		GestionContactos agenda=new GestionContactos();
		String email,nombre,telefono;
		
		String opcion;
		do {
		    
		
			System.out.println("1.- Añadir contacto");
			System.out.println("2.- Buscar contacto");
			System.out.println("3.- Eliminar contacto");
			System.out.println("4.- Mostrar todos");
			System.out.println("5.- Salir");
			
			System.out.print("Introduzca la opción de menu: ");
			opcion=sc.nextLine();
			
			int t=Integer.valueOf(opcion);
			switch(t) {
			case 1:
					do {
						System.out.println("Introduzca un email: ");
						email=sc.nextLine();
					}while (! leeremail(email)); 
					System.out.println("Introduzca el nombre ");
					nombre=sc.nextLine();
					System.out.println("Introduzca el telefono ");
					telefono=sc.nextLine();
					Integer t1=Integer.valueOf(telefono);
					agenda.anadircontacto(email, nombre,t1);
					break;
			case 2:
					System.out.println("Introduzca el email a buscar: ");
					email=sc.nextLine();
					if (agenda.buscar(email)) {
						System.out.println("El contacto del email " + email + "es:" + agenda.mostrarcontacto(email));
					}
				    break;
			case 3:			
					do {
						System.out.print("Introduzca el email del contacto a eliminar: ");
						email=sc.nextLine();
					}while (! leeremail(email));
						
					if (agenda.buscar(email)) {
						System.out.println("Se ha eliminado el contacto " + agenda.eliminar(email) + "correspondiente a " + email);;
					}else
						System.out.println("El email introducido no corresponde a ningún usuario");
				break;
			case 4:
					Contacto [] listado=agenda.mostrar();
					int i=1;
					for (Contacto contacto:listado) {
						System.out.println("Nombre contacto: " + i +" Nombre:"+ contacto.getNombre() +" ,E-mail:" +contacto.getEmail() +" ,Telefono:" + contacto.getTelefono());
						i++;
					}
					System.out.println();
			 break;
			case 5:
				System.out.println("Hasta pronto!");
			 break;
			 default:
				 System.out.println("La opcion no es válida");
			}
		}while(!opcion.equals("5"));
	}		
		
		static boolean leeremail(String correo) {
			boolean valido=false;
				if (!correo.contains("@")) {
					System.out.println("La direccion " + correo + " Debe de incluir el simbolo \"@\" para ser un correo válido");
				}else valido = true;
			
			return valido;
		}
		

}
