package Optimizado;

import java.security.MessageDigest;

public class Monitor_Minado 
{
	
	boolean stop = false;
	MessageDigest md;
	Object centinela = new Object();
	String mejor = "";
	StringBuilder strb;

	public Monitor_Minado(MessageDigest md) {
		this.md = md;
	}
	
	public synchronized boolean darStop() {
		return stop;
	}

	public void FuerzaBrutaCombinatoria (String letraThread, int numCeros, String cadena, long inicio, String algor) 
	{
		int entero = (int) numCeros/8;
		int bits = (int) (Math.pow(2,(numCeros%8)) - 1);
		
		for(char i = 'a'; i <= 'z'; i++) {
			if(stop) { return; };
			synchronized (centinela) { if(minado(""+ i + letraThread + cadena, entero, bits)) { stop = true; 
				encontramos("" + i + letraThread, numCeros, inicio, algor, cadena); return; } }

			for(char j = 'a'; j <= 'z'; j++){
				if(stop) { return; };
				synchronized (centinela) { if(minado(""+ j + i + letraThread + cadena, entero, bits)) { stop = true; 
					encontramos("" + j + i + letraThread, numCeros, inicio, algor, cadena); return; } }
				
				for(char k = 'a'; k <= 'z'; k++) {
					if(stop) { return; };
					synchronized (centinela) { if(minado(""+ k + j + i + letraThread + cadena, entero, bits)) { stop = true; 
						encontramos("" + k + j + i + letraThread, numCeros, inicio, algor, cadena); return; } }

					for(char l = 'a'; l <= 'z'; l++) {
						if(stop) { return; };
						synchronized (centinela) { if(minado(""+ l + k + j + i  + letraThread + cadena, entero, bits)) { stop = true; 
							encontramos("" + l + k + j + i + letraThread, numCeros, inicio, algor, cadena); return; } }

						for(char m = 'a'; m <= 'z'; m++) { 
							if(stop) { return; };
							synchronized (centinela) { if(minado(""+ m + l + k + j + i + letraThread + cadena, entero, bits)) { stop = true; 
								encontramos("" + m + l + k + j + i + letraThread, numCeros, inicio, algor, cadena); return; } }

							for(char n = 'a'; n <= 'z'; n++) {
								if(stop) { return; };
								synchronized (centinela) { if(minado(""+ n + m + l + k + j + i+ letraThread + cadena, entero, bits)) { stop = true; 
									encontramos("" + n + m + l + k + j + i + letraThread, numCeros, inicio, algor, cadena); return; } }

							}
						}
					}
				}
			}
		}
	}
	
	
	private boolean minado (String cadenaRevisar, int entero, int bits) {

		byte[] messageDigest = md.digest(cadenaRevisar.getBytes());
		
		for(int i = 0; i < entero; i++)
			if(messageDigest[i] != 0) return false;
		
		if(bits > 0)
			if (messageDigest[entero] > bits || messageDigest[entero] < 0) return false;
		
		return true;
	}
	
	private void encontramos (String c, int numCeros, long inicio, String algor, String cadena) 
	{
		mejor = c + cadena; 
		String p = "";
		
		if(numCeros%8>0) numCeros = numCeros/8 + 1;
		else numCeros = numCeros/8;
		byte[] messageDigest = md.digest((mejor).getBytes()); 
		for(int f = 0; f < numCeros; f++) p += messageDigest[f];
		long fin = System.currentTimeMillis() - inicio;

		System.out.println(c + " ; " + cadena + " ; " + p + " ; "+ fin + " milisegundos." + " ; " + algor); 
	}
	
}


