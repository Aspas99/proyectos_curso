package calculos;

public class GeneraLoto {
	
	public int [] numeros;
	
	private boolean existenum(int numero) {
		//Comentario versi�n 3
		//comprueba si el n�mero ya est� en el array
		int i=0;
		boolean existe=false;
		while (i<numeros.length && numeros[i]>0 && !existe) {		
			if (numeros[i]==numero)
				existe=true;
			i++;
		}
		
		return existe;
	}
	
	private void ordena() {
		//Comentario versi�n 4 desde casa
		//ordenamos el array de menor a mayor.
		int aux;		
		for (int i=0;i<numeros.length;i++) {
			for (int j=i+1;j<numeros.length;j++) {
				if (numeros[j]<numeros[i]) {
					aux=numeros[i];
					numeros[i]=numeros[j];
					numeros[j]=aux;
				}
						
			}
		}
	}
	//Versi�n 2
	//El m�todo genera "n" n�meros diferentes comprobando que sean siempre distintos
	//y los guarda en el atributo array que devuelve 
	public GeneraLoto(int n) {
		numeros=new int[n];
		int numero;
		for(int i=0;i<numeros.length;i++) {
			do {
			numero = (int) Math.floor(Math.random()*49+1);
			}while(existenum(numero));
			numeros[i]=numero;
		}	
		ordena();
	}
	
}
