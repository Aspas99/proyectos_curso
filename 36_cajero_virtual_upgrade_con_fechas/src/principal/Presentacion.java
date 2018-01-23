package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import modelo.Cuenta;
import modelo.Movimiento;


/*
 Se inicia el programa solicitando el numero de cuenta que se incluye en la BBDD bancabd de prácticas y movimientos
 
 Se accede a un menu tal como este
 1.- Ingresar
 2.- Extraer
 3.- Transferencia
 4.- Ultimos movimientos
 5.- Salir
 Transferencia : pide la cuenta destino y la cantidad .La de origen es la introducida al inicio (extraer en una - ingreso en otra) 
 y reflejarla en la tabla movimientos
 Ultimos movimientos solo saca los ultimos 5 movimientos de la cuenta
  */
public class Presentacion {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    String opcion;
	    Cuenta c;
	    int origen=0,destino=0;
	    double cantidad=0;
	    DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
	    LocalDateTime fecha=LocalDateTime.now(); 
	    int t;
	   // String fechaF=df.format(fecha);
	   System.out.println("La fecha actual es :" + fecha);
	  //   System.out.println("La fecha actual es :" + ParseFecha(fechaF));
	   do {
		   c=leerCuenta("Introduzca el numero  de la cuenta a buscar: ");
		   // Movimiento n, m=new Movimiento(cantidad);
		    
		    //Falta implementar la validación de la cuenta
		   //O incluir una salida del metodo main() con return; 
		   if (c==null) {
			   System.out.println("La cuenta no existe, introduzca de nuevo el número");
		   }
	   } while(c==null);
	   
		do {			
			System.out.println("1.-Ingresar");
			System.out.println("2.-Extraer");
			System.out.println("3.-Transferencias");
			System.out.println("4.-Ultimos Movimientos");
			System.out.println("5.- Salir");
			System.out.print("Introduzca la opción de menu: ");
			opcion=sc.nextLine();
				
		    t=Integer.valueOf(opcion);
			switch(t) {
			case 1:{
				//mejorar incluyendo un método que refleje los tipos de movimiento
			
				System.out.println("Introduzca la cantidad a ingresar:");
				 cantidad=Double.parseDouble(sc.nextLine());
				Movimiento m=new Movimiento(Movimiento.last()+1,c.getIdCuenta(),c.getSaldo(c.getIdCuenta()),
						cantidad,fecha,"ingreso");
				m.setMovimiento(Movimiento.last()+1,c.getIdCuenta(), cantidad, fecha,"ingreso");
				break;
			}
			case 2:{
					System.out.println("Introduzca la cantidad a retirar:");
					 cantidad=Double.parseDouble(sc.nextLine());
					//int idMovimiento,int idCuenta, double saldo, double cantidad, Date fecha,	String operacion)
					Movimiento m=new Movimiento(Movimiento.last()+1,c.getIdCuenta(),c.getSaldo(c.getIdCuenta()),
							cantidad,fecha,"extracción");
					m.setMovimiento(Movimiento.last()+1,c.getIdCuenta(), cantidad, fecha,"extracción");
					break;
			}
			case 3:{		
					origen=c.getIdCuenta();
					System.out.println("Introduzca la cuenta destino de la transferencia:");
					destino=Integer.parseInt(sc.nextLine());
					System.out.println("Introduzca la cantidad a transferir:");
					 cantidad=Double.parseDouble(sc.nextLine());
					 Movimiento m=new Movimiento(Movimiento.last()+1,c.getIdCuenta(),c.getSaldo(c.getIdCuenta()),
								cantidad,fecha,"ingreso");
					 if (m.transferencia(origen,destino,cantidad))
						 System.out.println("La transferencia se ha realizado con éxito");
					 else System.out.println("No se ha podido realizar la transferencia");
					break;
			}
			case 4:{
					System.out.println("Los movimientos de la cuenta " + c.getIdCuenta());
					Movimiento m=new Movimiento(Movimiento.last()+1,c.getIdCuenta(),c.getSaldo(c.getIdCuenta()),
							cantidad,fecha,"ingreso");
					List <Movimiento> lista=m.listaMovimientos(5);
					for (Movimiento a:lista) {
						DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm");
						System.out.println("Movimiento id:" + a.getIdMovimiento() + " fecha:" + a.getFecha().format(dtf2) + " Cantidad:" + a.getCantidad() +
					" Operacion:" + a.getOperacion() );
					}
					System.out.println("El saldo actual es:"  + m.getSaldo(c.getIdCuenta()));
					break;
			}
			case 5:
					System.out.println("El programa ha finalizado.Hasta otra!");
					break;
			default:
					System.out.println("No se reconoce la opción");
		 }
	 }while (t!=5);
			
}
	


 
 
static Cuenta leerCuenta(String mensaje) {
    Scanner sc=new Scanner(System.in);
   
	int numeroCuenta;
	do {	
		System.out.println(mensaje);
		numeroCuenta=Integer.parseInt(sc.nextLine());
		if (numeroCuenta<=0)
			System.out.println("El numero de cuenta no puede ser negativo o cero");
	}while(numeroCuenta<=0);
	
	return Cuenta.buscarCuenta(numeroCuenta);
 }



public static Date ParseFecha(String fecha)
{
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date fechaDate = null;
    try {
        fechaDate = formato.parse(fecha);
    } 
    catch (ParseException ex) 
    {
        System.out.println(ex);
    }
    return fechaDate;
}
}
