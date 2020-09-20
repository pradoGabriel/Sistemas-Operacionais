package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread {
	private Semaphore semaforo;
	private String sentido;
	private static int posSaida;
	private int idCarro;
	private int distanciaAteCruzamento = 100;

	public ThreadCruzamento(String sentido, Semaphore semaforo, int idCarro) {
		this.sentido = sentido;
		this.semaforo = semaforo;
		this.idCarro = idCarro;
	}

	@Override
	public void run() {
		carroAndando();
		try {
			semaforo.acquire();
			carroCruzando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			// fim seção critica
			carroCruzou();
		}
	}

	private void carroAndando() {
		int distanciaPercorrida = 0;
		int deslocamento = 20;
		int tempo = 1000;
		while (distanciaPercorrida < distanciaAteCruzamento) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idCarro + " já andou " + distanciaPercorrida + "m. no sentido: " + sentido);
		}
		System.out.println("#" + idCarro + " chegou ao cruzamento");
	}

	private void carroCruzando() {
		System.out.println("#" + idCarro + " está cruzando a avenida no sentido: " + sentido);
		int tempo = (int) ((Math.random() * 3001) + 1000);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void carroCruzou() {
		posSaida++;
		System.out.println("#"+idCarro+" foi o " +posSaida+" a cruzar a avenida no sentido: " + sentido);
	}
}
