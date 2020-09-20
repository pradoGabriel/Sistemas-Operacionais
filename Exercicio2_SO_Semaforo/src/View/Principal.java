package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadCruzamento;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore (permissoes);
		
		Thread tCarro1 = new ThreadCruzamento("Cima para baixo", semaforo, 1);
		Thread tCarro2 = new ThreadCruzamento("Baixo para cima", semaforo, 2);
		Thread tCarro3 = new ThreadCruzamento("Esquerda para direita", semaforo, 3);
		Thread tCarro4 = new ThreadCruzamento("Direita para a esquerda", semaforo, 4);
		tCarro1.start();
		tCarro2.start();
		tCarro3.start();
		tCarro4.start();
	}

}
