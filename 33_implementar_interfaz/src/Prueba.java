
public class Prueba {



	public static void main(String[] args) {
		// Prueba del caso 1
		TestInterfaz t=new TestInterfaz();
		t.print();
		//implementar una interfaz opción 2: clase anónima
		InterPrueba t2 = new InterPrueba() {
			
			@Override
			public void print() {
				System.out.println("Implementación 2");		
			}
		};
		t2.print();
		//implementar interfaz opción 3:expresiones lambda
		InterPrueba t3=()->System.out.println("Implementación 3");
		t3.print();

	}
	
}
