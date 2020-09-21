package View;

import java.util.concurrent.Semaphore;

import Controller.ThreadTransacao;

public class Principal {
	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore saque = new Semaphore(permissoes);
		Semaphore deposito= new Semaphore(permissoes);
		for (int i = 1; i <= 20; i++) {
			double saldoConta = ((Math.random() * 3001) + 1);
			double valorTransacao = ((Math.random() * 2000) + 1);
			int tipoTransacao = (int) ((Math.random() * 2) + 1);
			Thread transacao = new ThreadTransacao(i, saldoConta, valorTransacao, tipoTransacao, saque, deposito);
			transacao.start();
		}
	}

}
