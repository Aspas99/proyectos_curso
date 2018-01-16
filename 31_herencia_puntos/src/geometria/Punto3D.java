package geometria;

public class Punto3D extends Punto {

	private int z;
	public Punto3D(int x,int y,int z) {
		//aunque no se use explictamente la clase punto ,debido a la herencia se ejecutan 
		//tambien los bloques static y de inicializaci�n de instancia
		super(x,y);
		this.z=z;
	}
	//SObreescribimos el m�todo de imprimir
	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println(","+z);
	}
}
