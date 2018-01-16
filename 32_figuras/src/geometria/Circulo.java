package geometria;

public class Circulo extends Figura {
	private int radio;
	
	public Circulo(String color,int radio) {
		super(color);
		setRadio(radio);
		// TODO Auto-generated constructor stub
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	public double superficie() {
	
		return Math.PI*radio*radio;
	}

}
