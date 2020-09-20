package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCorrida extends Thread {

	private double tempoVoltaNaPista = 0;
	private double tempoFinalCorrida = 0;
	private int idCarro;
	private Semaphore corrida;

	public ThreadCorrida(int idCarro, Semaphore corrida) {
		this.idCarro = idCarro;
		this.corrida = corrida;
	}

	public void run() {
		iniciarCorrida();
		try {
			corrida.acquire();
			carroNaPista();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			corrida.release();
		}
	}

	public void iniciarCorrida() {

		if (idCarro <= 14) {
			System.out.println("#" + idCarro + " pronto para iniciar");
		}

	}

	public void carroNaPista() {

		int distanciaTotal = 200;
		int distanciaAtingida = 0;
		int deslocamento = (int)((Math.random() * 20) + 10);
		int tempo = 500;

		for (int i = 1; i <= 3; i++) {
			while (distanciaAtingida < distanciaTotal) {
				distanciaAtingida = distanciaAtingida + deslocamento;
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tempoVoltaNaPista = tempoVoltaNaPista + (double) 1 + (Math.random() * 1);

				System.out.println("#" + idCarro + " percorreu: " + distanciaAtingida + "m.");
				if (distanciaAtingida > 200) {
					tempoVoltaNaPista = Math.round(tempoVoltaNaPista * 100);
					System.out.println(
							"#" + idCarro + " completou a " + i + " volta em " + (tempoVoltaNaPista / 10) + "s.");
				}

			}
			distanciaAtingida = 0;
			tempoFinalCorrida += tempoVoltaNaPista;
			tempoVoltaNaPista = 0;

		}
		System.out.println("#" + idCarro + " finalizou a corrida em " + tempoFinalCorrida + "min.");
	}
}