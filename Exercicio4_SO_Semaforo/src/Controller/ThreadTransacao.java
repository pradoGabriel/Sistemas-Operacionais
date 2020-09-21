package Controller;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class ThreadTransacao extends Thread {
	private int codigoConta;
	private double saldoConta;
	private double valorTransacao;
	private int tipoTransacao;
	private Semaphore saque;
	private Semaphore deposito;
	DecimalFormat df = new DecimalFormat("###,##0.00");
	// Tipo transação: 1 - Para saque //// 2- Para depósito
	public ThreadTransacao(int codigoConta, double saldoConta, double valorTransacao, int tipoTransacao, Semaphore saque, Semaphore deposito) {
		this.codigoConta = codigoConta;
		this.saldoConta = saldoConta;
		this.valorTransacao = valorTransacao;
		this.tipoTransacao = tipoTransacao;
		this.saque = saque;
		this.deposito = deposito;
	}

	@Override
	public void run() {
		if (tipoTransacao == 1) {
			try {
				saque.acquire();
				sacar();
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				saque.release();
				// fim seção critica
			}
		} else if (tipoTransacao == 2) {
			try {
				deposito.acquire();
				depositar();
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				deposito.release();
				// fim seção critica
			}
		}
	}

	private void sacar() {
		System.out.println("Código da conta: " + codigoConta + ". Transação iniciada: Saque.");
		System.out.println("Código da conta: " + codigoConta + ". Saldo atual: R$" + df.format(saldoConta) + ". Valor a ser sacado: R$"
				+ df.format(valorTransacao));
		if (saldoConta < valorTransacao) {
			System.out.println("Código da conta: " + codigoConta + ". Saldo insuficiente para saque!");
		} else {
			saldoConta = saldoConta - valorTransacao;
			System.out.println("Código da conta: " + codigoConta + ". Saldo final: R$" + df.format(saldoConta) + " Valor sacado: R$"
					+ df.format(valorTransacao));
		}
	}

	private void depositar() {
		System.out.println("Código da conta: " + codigoConta + ".Transação iniciada: Depósito.");
		System.out.println("Código da conta: " + codigoConta + ". Saldo atual: R$" + df.format(saldoConta));
		saldoConta += valorTransacao;
		System.out.println("Código da conta: " + codigoConta + ". Saldo final: R$" + df.format(saldoConta) + " valor depositado: R$"
				+ df.format(valorTransacao));
	}
}
