package principal.adaptadores;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import beans.Contacto;

public class AdaptadorListaCombo implements ComboBoxModel<Contacto> {

	List<Contacto> contactos;
	Contacto seleccion; //guarda el contacto seleccionado
	
	public AdaptadorListaCombo(List<Contacto> contactos) {
	
		this.contactos = contactos;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contacto getElementAt(int pos) {
		// TODO Auto-generated method stub
		return contactos.get(pos);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return contactos.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return seleccion;
	}

	@Override
	public void setSelectedItem(Object arg0) {
		this.seleccion=(Contacto)arg0;
		
	}

	

}
