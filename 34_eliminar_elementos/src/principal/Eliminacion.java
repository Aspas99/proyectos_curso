package principal;

import java.util.ArrayList;

public class Eliminacion {

	public static void main(String[] args) {
		ArrayList<Integer> numeros=new ArrayList<>();
		numeros.add(10);numeros.add(15);numeros.add(27);numeros.add(41);numeros.add(11);
		numeros.add(8);
		
		//Eliminar del arraylist los numeros menores de 15
		//1ª forma
		for(int i=0;i<numeros.size();i++) {
			if (numeros.get(i)<15) {
				numeros.remove(i);
			}
		}
		//2ª forma ,que da error
		for (Integer n:numeros) {
			if (n<15) {
				numeros.remove(n);//Esto da error en ejecucion
			}
		}
		//3ª forma, mediante el uso de expresiones lamda implementando el método abstracto test de la interfaz Predicate 
		//boolean removeIf(Predicate<? super E> filter) 
		//Removes all of the elements of this collection that satisfy the given predicate.
		numeros.removeIf(n->n<15); //(Integer n)->{return n<15;}
		
		numeros.forEach(n->System.out.println(n)); 

	}

}
