package Controller;

import java.util.concurrent.Semaphore;

public class ThreadBanco extends Thread {

	private Semaphore semaforo;
	private int id;

	public ThreadBanco(Semaphore semaforo, int id) {

		this.semaforo = semaforo;
		this.id = id;

	}

	public void run() {

		banco();

	}

	private void procDbUm() {
		int tempoCalculos = (int) (Math.random() * 801) + 200;
		int tempoTransacao = 1000;

		for (int i = 0; i < 2; i++) {
			try {
				sleep(tempoCalculos);
				System.out.println("Transact## " + id + " À calcular...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				sleep(tempoTransacao);
				System.out.println("Transact## " + id + " Efetuando transação em Banco...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void procDbDois() {
		int tempoCalculos = (int) (Math.random() * 1001) + 500;
		int tempoTransacao = 1500;

		for (int i = 0; i < 3; i++) {
			try {
				sleep(tempoCalculos);
				System.out.println("Transact## " + id + " À calcular...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				sleep(tempoTransacao);
				System.out.println("Transact## " + id + " Efetuando transação em Banco...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void procDbTres() {
		int tempoCalculos = (int) (Math.random() * 1001) + 1000;
		int tempoTransacao = 1500;

		for (int i = 0; i < 3; i++) {
			try {
				sleep(tempoCalculos);
				System.out.println("Transact## " + id + " À calcular...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				sleep(tempoTransacao);
				System.out.println("Transact## " + id + " Efetuando transação em Banco...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void banco() {

		int opc = id % 3;

		switch (opc) {

		case 1:
			try {
				semaforo.acquire();
				procDbUm();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;

		case 2:
			try {
				semaforo.acquire();
				procDbDois();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;
		case 0:

			try {
				semaforo.acquire();
				procDbTres();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			break;

		default:
			System.out.println("Processando informações");
			break;

		}

	}

}