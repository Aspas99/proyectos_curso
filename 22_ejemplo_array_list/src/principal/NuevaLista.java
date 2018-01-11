package principal;

import java.util.ArrayList;
import java.util.Arrays;

public class NuevaLista {

	public static void main(String[] args) {
		ArrayList<Integer> nums=new ArrayList<>();
		nums.add(25);
		nums.add(10);
		nums.add(9);
		//25,10,9
		nums.add(1,50);
		//50,25,10,9
		for (Integer i:nums) {
			System.out.println(i);
		}
		//transformar  ArrayList en array 
		Integer[] miarray=nums.toArray(new Integer[0]);
		for (Integer i:miarray) {
			System.out.println(i);
		}
		
		miarray[0]+=4000;
		System.out.println(nums.get(0));
		
		ArrayList<StringBuilder> palabras=new ArrayList<>();
		palabras.add(new StringBuilder("Java"));
		StringBuilder[] pds=palabras.toArray(new StringBuilder[0]);
		pds[0].append("9");
		System.out.println(palabras.get(0));
		//Comentario para la Versión 1.2 documentado
		//del uso de StringBuilder como clase mutable en un ArrayList<StringBuilder>
		String[] nombres={"uno","dos","tres"};

		ArrayList<String>  valors=(ArrayList<String>)Arrays.asList(nombres);
		for  (String cadena:valors) {
			System.out.println(cadena);
		}
		
		
		
		
	}

}
