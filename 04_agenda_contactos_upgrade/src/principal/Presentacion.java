package principal;

import java.util.List;
import java.util.Scanner;

import beans.Contacto;
import contactos.GestionContactos;

public class Presentacion {
	//el ejercicio hará lo siguiente
	//1.-Agregar contactos ->pedirá nombre, mail y telefono
	//2.-Recuperar contactos ->pedirá el email, elimnando todos los que correspndan
	//3.-Salir
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		GestionContactos gcontactos=new GestionContactos();
		String opcion;
		int t=0;
		System.out.println("1.-Agregar contactos");
		System.out.println("2.-Eliminar contactos");
		System.out.println("3.-Buscar contacto");
		System.out.println("4.-Mostrar todos");
		System.out.println("5.-Salir");
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
				buscarContacto();
				break;
			}
			case 4:{
				List<Contacto> todos = gcontactos.recuperarTodos();//Implementa el método accept del forEach (accept(T t)  		
				todos.forEach(c->System.out.println(c.getNombre() + "-" +c.getEmail() + "-"+ c.getTelefono()));//Expresion lambda c->codigo
				break;
			}
			case 5:{
				System.out.println("Finalizacion del programa, vuelva pronto");
				break;
			}
			default: System.out.println("Opcion no disponible");
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
	
	static void buscarContacto() {
	
		Scanner sc= new Scanner(System.in);
		String email;
		
		GestionContactos agenda=new GestionContactos();
		
		System.out.println("Introduce el email:");
		email=sc.nextLine();
		Contacto contacto=agenda.buscar(email);
		if (contacto==null) {
			System.out.println("No existe el contacto");			
		}else
			System.out.println("Nombre:" + contacto.getNombre() + " Email:" + contacto.getEmail() + " Telefono:" + contacto.getTelefono());
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