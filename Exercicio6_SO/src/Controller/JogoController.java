package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JogoController implements ActionListener {

	private JButton btnJogar;
	private JTextField textFieldUm;
	private JTextField textFieldDois;
	private JTextField textFieldTres;

	public JogoController(JTextField textFieldUm, JTextField textFieldDois, JTextField textFieldTres, JButton btnJogar) {
		this.textFieldUm = textFieldUm;
		this.textFieldDois = textFieldDois;
		this.textFieldTres = textFieldTres;
		this.btnJogar = btnJogar;

	}

	private void botaoJogo() {
		Thread t1 = new ThreadJogo(textFieldUm, btnJogar);
		Thread t2 = new ThreadJogo(textFieldDois, btnJogar);
		Thread t3 = new ThreadJogo(textFieldTres, btnJogar);
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		botaoJogo();
	}
}