package Controller;

public class ThreadCalc extends Thread{
	private int matriz [][];
	private int linha;
	
	public ThreadCalc (int linha, int matriz[][]) {
		this.matriz = matriz;
		this.linha = linha;
	}
	
	@Override
	public void run() {
		calculoLinha();
	}
	
	public void calculoLinha() {
		int soma = 0;
		for (int i = 0; i < 5; i++) {
			soma = soma + matriz [linha][i];
		}
		System.out.println("A soma da linha " + (linha+1) + " é: " + soma);
	}
}
