package Controller;

import java.util.Random;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadCarro extends Thread {
	private int distancia = 600, velMax = 30;
	private JLabel carro;
	private JButton btnCorrer;
	private double tempoTotal;
	private JTextField textVencedor;
	private JTextField textPerdedor;
	
	public ThreadCarro(JLabel carro, JButton btnCorrer, JTextField textVencedor,
			JTextField textPerdedor) {
		this.carro = carro;
		this.btnCorrer = btnCorrer;
		this.textVencedor = textVencedor;
		this.textPerdedor = textPerdedor;
	}

	@Override
	public void run() {
		carro();
	}

	private void carro() {
		textPerdedor.setText(null);
		textVencedor.setText(null);
		btnCorrer.setVisible(false);
		Rectangle posicao, posicaoInicial;
		posicaoInicial = carro.getBounds();
		posicao = carro.getBounds();
		carro.setBounds(posicao);
		int percorrido = 0;
		int aceleracao = 0;
		Random gerador = new Random();

		while (percorrido < distancia) {
			aceleracao = gerador.nextInt(velMax) + 1;
			posicao.x = posicao.x + aceleracao;
			carro.setBounds(posicao);
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			percorrido = percorrido + aceleracao;
		}
		if (textVencedor.getText().isEmpty()) {
			textVencedor.setText(carro.getText());
		} else {
			textPerdedor.setText(carro.getText());
		}
		carro.setBounds(posicaoInicial);
		btnCorrer.setVisible(true);
	}
}
