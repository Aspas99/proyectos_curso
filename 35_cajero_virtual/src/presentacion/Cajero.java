package presentacion;
//El programa deberá
//al iniciar el programa ,se solicita al usuario el saldo inicial y el límite de la cuenta(maxima cantidad a extraer durante el proceso)
//La clase cuenta es una clase base que servirá como superclase a las que se necesiten
//TRas el inicio se muestra el menú
//1.-Ingresar
//2.-Extraer
//3.-Movimientos y saldo
//4.-Salir
//1.-Se solicita la cantidad a ingrear y se procede al ingreso y vuelve al menu
//2.-Se solicita la cantidad a extraer, si es inferior o igual al límite se realiza la extracción.Si no,no se hace 
//3.-Muestra los movimientos realizados en la cuenta y el saldo final. Cada movimiento se caracteriza por un tipo (ingreso o extraccion) 
//   y una cantidad
// La idea es aplicar la herencia para crear una subclase de cuenta para usarla en este ejercicio

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Movimiento;

public class Cajero {
    
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    ArrayList<Movimiento> movimientos=new ArrayList<>();   
	    String opcion;
	    double cantidad;
	    int t;
	    cantidad=leerCantidad("Introduzca el saldo de la cuenta a crear: ");
	    Movimiento m=new Movimiento(cantidad);
		do {			
			System.out.println("1.-Ingresar");
			System.out.println("2.-Extraer");
			System.out.println("3.-Movimientos y saldo");
			System.out.println("4.- Salir");
			System.out.print("Introduzca la opción de menu: ");
			opcion=sc.nextLine();
				
		    t=Integer.valueOf(opcion);
			switch(t) {
				case 1:{
					cantidad=leerCantidad("Introduzca una cantidad a ingresar: ");
					m.setMovimiento("ingreso", cantidad);
					movimientos.add(m);
					break;
				}
				case 2:{
					cantidad=leerCantidad("Introduzca una cantidad a retirar: ");
					if ((m.getSaldo() - cantidad)<0) 
						System.out.println("No dispone de saldo suficiente para esa cantidad");
					else {m.setMovimiento("retirada", cantidad);
						movimientos.add(m);
					}
					break;
				}
				case 3:{
					int contador=0;
					System.out.println("Hay " + movimientos.size() + " movimientos");
					for (Movimiento mov:movimientos) {
						
						System.out.println("movimiento nª" + (++contador) + ": Tipo:" + mov.getTipoMovimiento() +", cantidad:" + mov.getCantidad() + ", Saldo:" + mov.getSaldo());
					}
				}
				case 4:{
					System.out.println("Fin del programa, vuelva pronto!");
					break;
				}
				default: System.out.println("Opción no válida.");
			}

	}while(t!=4);

}
		static double leerCantidad(String mensaje) {
		    Scanner sc=new Scanner(System.in);
			double cantidad=0.0;
			do {	
				System.out.println(mensaje);
				cantidad=Double.parseDouble(sc.nextLine());
				if (cantidad<=0)
					System.out.println("La cantidad no puede ser negativa o igual a cero");
			}while(cantidad<=0.0);
			return cantidad;
		 }
}
