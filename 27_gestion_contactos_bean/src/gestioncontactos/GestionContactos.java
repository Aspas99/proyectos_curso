package gestioncontactos;

import java.util.HashMap;
import java.util.Hashtable;
import beans.Contacto;

public class GestionContactos {
   
    Hashtable<String,Contacto> agenda ;
    
    public GestionContactos() {
    	this.agenda =  new Hashtable<>();
    }
    
    public GestionContactos(String nombre, String email, Integer telefono) {
	   	this.agenda =  new Hashtable<>();
		anadircontacto(email,nombre,telefono);
	}

	
	
	public boolean anadircontacto(String email,String nombre,Integer telefono) {
		boolean anadido=false;
		if (!agenda.containsKey(email)) {
			agenda.put(email, new Contacto(nombre,email,telefono));
			anadido=true;
		}
		return anadido;
	}
	
	public boolean buscar(String email) {
		return agenda.containsKey(email);
	}
	
	public Contacto mostrarcontacto(String email) {
		Contacto contacto = null ;
		if (buscar(email))
			 contacto=agenda.get(email);
		return contacto;
		
	}
	
	public Contacto eliminar(String email) {
		if (buscar(email)) {
			return agenda.remove(email);
		}else
			return null;
	}
	
	public Contacto[] mostrar() {
		
		return agenda.values().toArray(new Contacto[0]);
	}

	
}
