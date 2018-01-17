package principal;

import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		int a,b,r;
		Scanner sc=new Scanner(System.in); 
		//Scanner sc=null;
		try {
			System.out.println("Introduzca el dividendo: ");
			a=Integer.parseInt(sc.nextLine());
			System.out.println("Introduzca el divisor: ");
			b=Integer.parseInt(sc.nextLine());
			r=a/b;
			System.out.println("Divisi�n: " + r );
		}catch(NumberFormatException ex) {
			System.out.println("N�mero no v�lido o formato incorrecto " + ex.getMessage());
		}
		catch(ArithmeticException ex) {
			System.out.println("El divisor no es v�lido "  + ex.getMessage());
		}
		catch (Exception ex) {
			System.out.println("Error inesperado");//No se recomienda
			ex.printStackTrace();
		}
	}

}
