package calculos;

public class GeneraLoto {
	
	public int [] numeros;
	
	private boolean existenum(int numero) {
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
