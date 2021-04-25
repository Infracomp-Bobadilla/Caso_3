package Optimizado;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	static Monitor_Minado monitorSHA;

	public static void main(String[] args) throws NoSuchAlgorithmException {

		// ......... Ejecusión de escenarios
		// .. Dos algoritmos ~ SHA-256 Y SHA-512
		
		String mensaje = args[0];
		String ceros = args[1];  
		String algoritmo = args[2];
		
		monitorSHA = new Monitor_Minado(MessageDigest.getInstance(algoritmo));

		for(char l = 'a'; l <= 'z'; l++)
			new Optimizador(String.valueOf(l), monitorSHA, mensaje, Integer.parseInt(ceros), algoritmo).start();
	}

}
