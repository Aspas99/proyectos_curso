
public class Prueba {



	public static void main(String[] args) {
		// Prueba del caso 1
		TestInterfaz t=new TestInterfaz();
		t.print();
		//implementar una interfaz opci�n 2: clase an�nima
		InterPrueba t2 = new InterPrueba() {
			
			@Override
			public void print() {
				System.out.println("Implementaci�n 2");		
			}
		};
		t2.print();
		//implementar interfaz opci�n 3:expresiones lambda
		InterPrueba t3=()->System.out.println("Implementaci�n 3");
		t3.print();

	}
	
}
