package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class LecturaFichero {

	public static void main(String[] args) {
		String fichero="c:\\temporal\\NIF.dat";
		String volcado="c:\\temporal\\NIF_Formateado.dat";
		try (FileReader fr=new FileReader(fichero);BufferedReader br=new BufferedReader(fr);PrintStream wr=new PrintStream(volcado)){
			//String cadena=br.readLine();
			/*while (cadena!=null){
				System.out.println(cadena);
				cadena=br.readLine();
			}*/
			br.lines().map(s->s=s.substring(1, s.length())).forEach(wr::println);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
