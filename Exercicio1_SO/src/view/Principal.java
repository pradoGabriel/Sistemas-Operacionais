package view;

import java.util.Random;

import Controller.ThreadVetor;

public class Principal {

	public static void main(String[] args) {
		int vetor [] = new int [1000];
		Random gerador = new Random();

		for (int i = 0; i < 1000; i++) {
            vetor [i] = gerador.nextInt(100) + 1;
        }
		
		for (int i = 1; i <=2 ; i ++) {
			Thread threadVetor = new ThreadVetor(i, vetor);
			threadVetor.start();
		}
	}

}
