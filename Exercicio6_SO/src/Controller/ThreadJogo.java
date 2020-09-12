package Controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ThreadJogo extends Thread {

	private JButton btnJogar;
	private JTextField textField;
	
	public ThreadJogo (JTextField textField, JButton btnJogar) {
		this.btnJogar = btnJogar;
		this.textField = textField;
	}
	

	public void run() {
		jogo();
	}
	
	private void jogo () {
		btnJogar.setVisible(false);
		Random gerador = new Random();
		int giros = gerador.nextInt(150) + 1;
		for (int i = 0; i < giros ; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			int value = gerador.nextInt(7) + 1; 
			String s =String.valueOf(value);
			textField.setText(s);
		}
		btnJogar.setVisible(true);
	}
}
