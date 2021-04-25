package Optimizado;

public class Optimizador extends Thread
{
	String letra;
	String cadena;
	int numCeros;
	String algoritmo;

	public Monitor_Minado minado;

	public Optimizador(String letra, Monitor_Minado minado, String cadena, int numCeros, String algoritmo) {
		this.letra = letra;
		this.cadena = cadena;
		this.numCeros = numCeros;
		this.algoritmo = algoritmo;
		this.minado = minado;
	}

	public void run () {

		long inicio = System.currentTimeMillis();
		minado.FuerzaBrutaCombinatoria(this.letra, this.numCeros, this.cadena, inicio, algoritmo);

		long finCritico = System.currentTimeMillis() - inicio;
		if(!minado.darStop()) System.out.println("Thread " + this.letra + " ; " + "No V" + " ; " + cadena + " ; " + numCeros + " ceros " + " ; "+ finCritico + " milisegundos." + " ; " + this.algoritmo);

	}

}
