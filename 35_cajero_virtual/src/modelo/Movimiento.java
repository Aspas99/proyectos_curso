package modelo;

public class Movimiento extends Cuenta {
    
    private String tipoMovimiento;
    private double cantidad;
	public Movimiento(double saldo) {
		super(saldo);
	//	movimientos=new ArrayList<>();
		
	}
	public void setMovimiento(String tipoMovimiento,double cantidad) {
		this.tipoMovimiento=tipoMovimiento;
		
		String accion=this.tipoMovimiento.toLowerCase();
		switch (accion) {
			case "ingreso":{
				if (cantidad>0) {
					this.ingresar(cantidad);
					this.cantidad=cantidad;
				}
				break;
			}case "retirada":{
				if ((getSaldo()-cantidad)>0 && cantidad>0) {
					this.extraer(cantidad);
					this.cantidad=cantidad;
				}
				break;
			}
		}
		
	}
	
	public String getTipoMovimiento() {
		return this.tipoMovimiento;
		
	}
	public double getCantidad() {
		return this.cantidad;
	}
	
}
