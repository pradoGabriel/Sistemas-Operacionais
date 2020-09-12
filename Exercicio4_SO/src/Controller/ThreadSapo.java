package Controller;

import java.util.Random;

public class ThreadSapo extends Thread {
	private int tamanhoMaximo = 10, distancia = 100, sapoId;
	
	public ThreadSapo(int sapoId) {
		this.sapoId = sapoId;
	}
	
	@Override
	public void run() {
		sapo();
	}
	
	private void sapo() {
		int percorrido = 0;
		int salto = 0;
		Random gerador = new Random();
		while (percorrido < distancia) {
			salto = gerador.nextInt(tamanhoMaximo) + 1;
			percorrido = percorrido + salto;
			System.out.println("O sapo de id: " + sapoId +  " deu um salto de " + salto + " metros. Distancia total percorrida: " + percorrido + " metros.");
			if (percorrido >= distancia) {
				System.out.println("O sapo de id: " + sapoId +  " finalizou a corrida.");
			}
		}
	}
}
