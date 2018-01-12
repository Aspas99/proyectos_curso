package principal;

public class Test {

	public static void main(String[] args) {
		Test t= new Test();
		t.test(5);
		int [] h= {7,6,9};
		t.test(h);

	}
	
	void test(int a) {
		System.out.print("Primero");
	}
	void test(int a, int ... b) {
		System.out.print("Segundo");
		
	}
	
	void test(int ... x) {
		System.out.print("Tercero");
		for(int i:x)
			System.out.println(i);
		
	}
	void test(Integer z) {
		System.out.print("Cuarto");
		
	}

}
