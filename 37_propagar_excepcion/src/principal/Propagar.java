package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Propagar {

	public static void main(String[] args) throws IOException { //No hacer con un método main, ya que lo redirige a la JVM (el llamante) 
																//y haria que el programa se detuviera
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		//try {
		System.out.print("Introduce tu nombre:" );
		String n=bf.readLine();
		System.out.println("Te llamas : " + n);
		//}
	/*	catch(IOException ex){
			System.out.print("Error:");
		}
	*/
	
	}
	
	public void prueba() throws IOException {
		int a=10;
		//Si queremos provocar una excepcion,con el uso de la palabra reservada throw -singular-
		if (a==5) {
				throw new IOException();//lanzar excepcion
				//Esto implica que hay que capturarla o propagarla
		}
	}

}
