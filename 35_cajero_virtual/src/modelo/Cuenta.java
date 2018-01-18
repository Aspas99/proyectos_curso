package modelo;

public class Cuenta {
	// La clase dispone de los atributos
	private double saldo;
	
	public Cuenta(double saldo) {
		
			this.saldo=saldo;
	}
	
	public void ingresar(double cant) {
		saldo+=cant;
	}
	public void extraer(double cant) {
		saldo-=cant;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	

}
