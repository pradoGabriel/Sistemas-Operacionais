package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadPessoas;

public class Principal {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idPessoa = 0; idPessoa < 4; idPessoa++) {
			Thread tPessoa = new ThreadPessoas(idPessoa, semaforo);
			tPessoa.start();
		}
	}
}
