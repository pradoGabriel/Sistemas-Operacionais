package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarroController implements ActionListener {
	private JLabel carroUm;
	private JLabel carroDois;
	private JButton btnCorrer;
	private JTextField textVencedor;
	private JTextField textPerdedor;

	public CarroController(JLabel carroUm, JLabel carroDois, JButton btnCorrer, JTextField textVencedor,
			JTextField textPerdedor) {
		this.carroUm = carroUm;
		this.carroDois = carroDois;
		this.btnCorrer = btnCorrer;
		this.textVencedor = textVencedor;
		this.textPerdedor = textPerdedor;
	}

	private void botaoCarro() {
		Thread t1 = new ThreadCarro(carroUm, btnCorrer, textVencedor, textPerdedor);
		Thread t2 = new ThreadCarro(carroDois, btnCorrer, textVencedor, textPerdedor);

		t1.start();
		t2.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botaoCarro();
	}
}