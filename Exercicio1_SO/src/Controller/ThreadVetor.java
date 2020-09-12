package Controller;

public class ThreadVetor extends Thread {

	private int a;
	private int dados[];

	public ThreadVetor(int a, int dados[]) {
		this.a = a;
		this.dados = dados;
	}

	@Override
	public void run() {
		if (a / 2 == 0) {
			casoPar();
		} else {
			casoImpar();
		}
	}

	private void casoPar() {
		double tempoInicial = System.nanoTime();

		for (int i = 0; i < dados.length; i++) {

		}

		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;

		tempoTotal = tempoTotal / Math.pow(10, 9);

		System.out.println("Par ==> " + tempoTotal + "s. ");
	}

	private void casoImpar() {
		double tempoInicial = System.nanoTime();

		for (Integer dado : dados) {
		}

		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;

		tempoTotal = tempoTotal / Math.pow(10, 9);

		System.out.println("Impar ==> " + tempoTotal + "s. ");
	}
}