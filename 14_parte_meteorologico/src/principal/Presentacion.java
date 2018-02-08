package principal;

import java.util.List;
import java.util.Scanner;

import beans.Contacto;
import contactos.GestionContactos;
import modelo.GestionMeteo;

/*
 * Te pide los datos para registrar los datos de la ciudad:nombre y temperatura de la ciudad y lo salva a fichero.
 * en bucle para registrar "n" ciudades y su temeperatura
 * 1.-Datos ciudad
 * 2.-Temperatura media
 * 3.-Ciudad mas calurosa
 * 4.-Mostrar todas (nombre + temperatura)
 * 5.-Salir
 * Capa de negocio beans + capa intermedia 
 * 
 * */
public class Presentacion {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		GestionMeteo gciudades=new GestionMeteo();
		String opcion;
		int t=0;
		System.out.println("1.-Agregar ciudad");
		System.out.println("2.-Temeperatura Media");
		System.out.println("3.-Ciudad mas calurosa");
		System.out.println("4.-Mostrar todas");
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
		
		GestionMeteo agenda=new GestionContactos();
		System.out.println("Introduce el nombre:");
		nombre=sc.nextLine();
		System.out.println("Introduce el email:");
		email=sc.nextLine();
		System.out.println("Introduce el telefono:");
		String tel=sc.nextLine();
		agenda.alta(nombre, email, Integer.valueOf(tel));
	}
}	
