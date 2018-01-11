package contactos;

import java.util.Collection;
import java.util.HashMap;

public class GestionContactos {

	HashMap<String,String> agenda = new HashMap<>();
	
	public boolean anadircontacto(String email,String nombre) {
		boolean anadido=false;
		if (!agenda.containsKey(email)) {
			agenda.put(email, nombre);
			anadido=true;
		}
		return anadido;
	}
	
	public boolean buscar(String nombre) {
		return agenda.containsKey(nombre);
	}
	
	public String mostrarcontacto(String email) {
		String contacto = null;
		if (buscar(email))
			 contacto=agenda.get(email);
		return contacto;
		
	}
	
	public String eliminar(String nombre) {
		if (buscar(nombre)) {
			return agenda.remove(nombre);
		}else
			return "";
	}
	
	public String[] mostrar() {
		
		return agenda.values().toArray(new String[0]);
	}
	
}
