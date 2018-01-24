package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFichero {

	public static void main(String[] args) {
		String fichero="d:\\temporal\\dias.txt";
		try (FileReader fr=new FileReader(fichero);BufferedReader br=new BufferedReader(fr);){
			String cadena=br.readLine();
			while (cadena!=null){
				System.out.println(cadena);
				cadena=br.readLine();
				br.lines().forEach(System.out::println);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
