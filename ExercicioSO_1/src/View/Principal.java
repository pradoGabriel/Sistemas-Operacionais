package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadBanco;

public class Principal {

	public static void main(String[] args) {

		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);

		for (int id = 1; id < 22; id++) {

			Thread thread = new ThreadBanco(semaforo,id);
			thread.start();
		}

	}

}