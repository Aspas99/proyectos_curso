package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import beans.Ciudad;

public class Ficheros {
	private String fichero;
	
	private String nombre;
	private double temperatura;
	public Ciudad c;
	public Ficheros() {

	}
	
	public Ficheros(String fichero) {
		c=new Ciudad();
		if (fichero!=null && !fichero.equals(""))
			this.fichero = fichero;
		else this.fichero="d:\\temporal\\ciudades.txt";
		try (FileOutputStream fs=new FileOutputStream(fichero,true); PrintStream salida=new PrintStream(fs);) {
			
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Ciudad[] leerFichero(String fichero) {
		List<Ciudad> resultado=new ArrayList<>();
		if (fichero!=null && !fichero.equals(""))
			this.fichero = fichero;
		else this.fichero="d:\\temporal\\ciudades.txt";
		
		try (FileReader fr=new FileReader(fichero);BufferedReader br=new BufferedReader(fr);){
			
			    br.lines().map(l->{String[] params=l.split(","); return params; }).map()
			/*	params=params[0].split(",");
		    
				c.setNombre(params[1]);
				c.setTemperatura(Double.parseDouble(params[2]));*/
				
			}	
		
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public void escribirFichero(Ciudad c, String fichero) {
		if (fichero!=null && !fichero.equals(""))
			this.fichero = fichero;
		else this.fichero="d:\\temporal\\ciudades.txt";
		
		try (FileOutputStream fs=new FileOutputStream(fichero,true); PrintStream salida=new PrintStream(fs);) {
			salida.print(c.getNombre() + "," +Double.toString(c.getTemperatura()));
			
		} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
