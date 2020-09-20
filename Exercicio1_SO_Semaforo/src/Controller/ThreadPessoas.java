package Controller;

import java.util.concurrent.Semaphore;

public class ThreadPessoas extends Thread {
	private int idPessoa;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;

	public ThreadPessoas(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		pessoaAndando();
		// inicio seção crítica
		try {
			semaforo.acquire();
			cruzandoPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			// fim seção critica
			cruzouPorta();
		}
	}

	private void pessoaAndando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int) ((Math.random() * 2) + 4);
		int tempo = 1000;
		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idPessoa + " já andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idPessoa + " foi o " + posChegada + " a chegar até a porta");
	}

	private void cruzandoPorta() {
		System.out.println("#" + idPessoa + " está cruzando a porta");
		int tempo = (int) ((Math.random() * 1001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void cruzouPorta() {
		posSaida++;
		System.out.println("#" + idPessoa + " foi o " + posSaida + " a cruzar a porta");
	}
}
