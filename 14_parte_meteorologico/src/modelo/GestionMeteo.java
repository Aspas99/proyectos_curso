package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import beans.Ciudad;

public class GestionMeteo extends Ciudad {

	Ciudad [] ciudades;
	private String fichero;
	
	public GestionMeteo(String nombre, double temperatura) {
		super(nombre, temperatura);
		
	
	}
	
	
	public double TemperaturaMedia() {
		double db=0.0;
		try (FileReader fr = new FileReader(fichero);BufferedReader bf=new BufferedReader(fr);){
			db=bf.lines().mapToDouble(s->Double.parseDouble(s.split("[,]")[1])).average().getAsDouble();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return db;
	}
	
	public Ciudad ciudadMasCalurosa() {
		Ciudad c=null;
		try (FileReader fr = new FileReader(fichero);BufferedReader bf=new BufferedReader(fr);){
			
			String linea=bf.lines()
					.max((a,b)->(int)(Double.parseDouble(a.split("[,]")[1]) - Double.parseDouble(b.split("[,]")[1]))).get();
			String [] lineas=linea.split(",");
			c=new Ciudad(lineas[0],Double.parseDouble(lineas[1]));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public List<Ciudad> recuperarTodas(){
		 List<Ciudad> ciudades = null;
		 try (FileReader fr = new FileReader(fichero);BufferedReader bf=new BufferedReader(fr);){
				
				ciudades=bf.lines()
						.map(s ->new Ciudad(s.split(",")[0], Double.parseDouble(s.split(",")[1])))
						.collect(Collectors.toList());
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ciudades;
		
	}
	

}
