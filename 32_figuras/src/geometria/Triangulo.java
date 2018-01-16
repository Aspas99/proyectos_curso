package geometria;

public class Triangulo extends Figura {
    private int alto,base;
    
	public Triangulo(String color,int alto,int base) {
		super(color);
		setAlto(alto);
		setBase(base);
		
		// TODO Auto-generated constructor stub
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	@Override
	public double superficie() {
		// TODO Auto-generated method stub
		return (double) ((alto*base)/2);
	}

}
