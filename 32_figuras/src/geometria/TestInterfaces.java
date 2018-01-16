package geometria;

public class TestInterfaces implements PruebaInterfaz1, PruebaInterfaz2 {

	public TestInterfaces() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int m() {
		// TODO Auto-generated method stub
		System.out.print("La variable a es:" + PruebaInterfaz1.a);
		return 0;
	}

}
