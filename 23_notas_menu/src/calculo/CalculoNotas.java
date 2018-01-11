package calculo;

import java.util.ArrayList;

public class CalculoNotas {

	public  ArrayList<Double> notas=new ArrayList<>();
	
	/*public  void muestraNotas() {
		
		if (notas.size()>0) {
			for (Double n:notas) {
				System.out.print(n + "\t");
			}
			
		}
	*/
	public Double[] muestraNotas() {
		return notas.toArray(new Double[0]);
	}
	
	public  Double media() {
		Double suma=0.0; 
		for (Double n:notas) {
			suma+=n.doubleValue();
			
		}
		return (Double)suma/notas.size();
	}
	
	public int aprobados() {
		int aprobados=0;
		for (Double n:notas) {
			if (n.doubleValue()>=5.0) aprobados++;
		}
		
		return aprobados;
	}
	public void anadirNota(Double nota) {
		if (nota>=0 && nota<=10)
			notas.add(nota);
	}
	
	
}
