package View;

import java.util.Random;

import Controller.ThreadCalc;

public class Principal {

	public static void main(String[] args) {
		int mat[][] = new int [3][5];
		Random gerador = new Random();
		
		for (int i = 0; i <3 ; i++) {
			for (int j = 0; j < 5 ; j++) {
				mat[i][j] = gerador.nextInt(100) + 1;
			}
		}
		
		for (int k = 0 ; k < 3; k++) {
			Thread soma = new ThreadCalc(k, mat);
			soma.start();
		}
	}

}
