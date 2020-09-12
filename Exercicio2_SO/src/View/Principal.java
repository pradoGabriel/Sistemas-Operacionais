package View;

import Controller.ThreadId;

public class Principal {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			Thread Id = new ThreadId();
			Id.start();
		}
	}
}
