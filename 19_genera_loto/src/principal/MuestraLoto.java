package principal;

import java.util.Scanner;

import calculos.GeneraLoto;

public class MuestraLoto {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		GeneraLoto apuesta;
		String continuar;
		do {
			 apuesta= new GeneraLoto(7);
			 System.out.println("La apuesta generada es:");
			 for (int i=0;i<apuesta.numeros.length;i++)
				 System.out.print(apuesta.numeros[i] + "\t");
			 System.out.print("\n" + "¿Desea generar una nueva apuesta? (s/n):");
			 continuar=sc.nextLine();
		}while(continuar.equalsIgnoreCase("s"));
	}

}
