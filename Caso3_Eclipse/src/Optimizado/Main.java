package Optimizado;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	static Monitor_Minado monitorSHA;

	public static void main(String[] args) throws NoSuchAlgorithmException {

		// ......... Ejecusión de escenarios
		// .. Dos algoritmos ~ SHA-256 Y SHA-512
		
		String mensaje = "Quiero un perro para jugar fubol"; 
		String ceros = "24";  
		String algoritmo = "SHA-256";
		
		monitorSHA = new Monitor_Minado(MessageDigest.getInstance(algoritmo));

		for(char l = 'a'; l <= 'z'; l++)
			new Optimizador(String.valueOf(l), monitorSHA, mensaje, Integer.parseInt(ceros), algoritmo).start();
	}

}
