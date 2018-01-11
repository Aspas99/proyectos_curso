package principal;
import java.util.Scanner;
import contactos.GestionContactos;

public class MenuContactos {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
		
		GestionContactos agenda=new GestionContactos();
		String email,nombre;
		
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
				System.out.println("Introduzca una email: ");
				email=sc.nextLine();
				if (leeremail(email)) {
					System.out.println("Introduzca el nombre ");
					nombre=sc.nextLine();
				}
				break;
			case 2:
				System.out.println("Introduzca el email a buscar: ");
				email=sc.nextLine();
				if (agenda.buscar(email))
			}

	}while(!opcion.equals("5"));
	}		
		
		static boolean leeremail(String correo) {
			boolean valido=false;
			do {
				System.out.println("Introduzca una email: ");
				correo=sc.nextLine();
				if (!correo.contains("@")) {
					System.out.println("La direccion " + correo + " Debe de incluir el simbolo \"@\" para ser un correo válido");
				}else valido = true;
				
			}while (!valido);
			
			return valido;
		}
		}

}
