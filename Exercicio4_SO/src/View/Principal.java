package View;

import Controller.ThreadSapo;

public class Principal {

	public static void main(String[] args) {
		for (int i = 0 ; i < 5 ; i ++) {
			Thread sapo = new ThreadSapo(i+1);
			sapo.start();
		}

	}

}
