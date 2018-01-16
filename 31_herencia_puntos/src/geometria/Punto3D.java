package geometria;

public class Punto3D extends Punto {

	private int z;
	public Punto3D(int x,int y,int z) {
		//aunque no se use explictamente la clase punto ,debido a la herencia se ejecutan 
		//tambien los bloques static y de inicialización de instancia
		super(x,y);
		this.z=z;
	}
	//SObreescribimos el método de imprimir
	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println(","+z);
	}
}
