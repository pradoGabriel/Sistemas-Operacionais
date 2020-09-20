package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadCorrida;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 5;
		Semaphore corrida = new Semaphore(permissoes);

		for (int idCarro = 0; idCarro < 14; idCarro++) {
			Thread tCorrida = new ThreadCorrida(idCarro, corrida);
			tCorrida.start();
		}

	}

}
