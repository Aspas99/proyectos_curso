package gestioncontactos;

import java.util.HashMap;
import java.util.Hashtable;
import beans.Contacto;

public class GestionContactos {
   
    Hashtable<String,Contacto> agenda ;
    boolean res;
    
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
//Vamos a implementar aqui un metodo abstracto de una interfaz funcional 
	public boolean buscarPorTelefono(int tel) {
		//boolean res=false;
		agenda.forEach((String k,Contacto v)->{if(v.getTelefono()==tel) //Estamos implementando del interfaz BiConsumer el método accept 
								res=true;								//el metodo es void ,por lo que no hay return
							});
		
		return res;
	}
	//cambiar los dominios de los correos por el dominio nuevo. Aqui estamos implementando el metodo abstracto apply  Bifunction ..que esn este caso 
    //devuelve un tipo R,que es del mismo tipo que la clave "K" del Hashmap
	public void cambiarDominio(String nuevo) {
		agenda.replaceAll((k,v)->{  		String email=v.getEmail();		
									       email=email.substring(0, email.lastIndexOf("."));
									        email=email+"." +nuevo;
								v.setEmail(email);
								return v;
							});
		}
	
}