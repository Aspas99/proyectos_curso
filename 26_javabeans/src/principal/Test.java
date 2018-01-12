package principal;

import java.util.ArrayList;

import beans.Alumno;

public class Test {

	public static void main(String[] args) {
		Alumno al=new Alumno("paco","Java",10);
		
		ArrayList<Alumno> lista=new ArrayList<>();
		lista.add(al);
	}

}
