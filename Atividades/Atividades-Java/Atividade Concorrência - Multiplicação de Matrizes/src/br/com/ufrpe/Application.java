package br.com.ufrpe;

import br.com.ufrpe.domain.MultiplyMatrix;

public class Application {

	public static void main(String[] args) {
		int[][] matrix1 = new int[2][4];
		int[][] matrix2 = new int[4][2];
		
		matrix1[0][0] = 1;
		matrix1[0][1] = 2;
		matrix1[0][2] = 3;
		matrix1[0][3] = 4;
		matrix1[1][0] = 5;
		matrix1[1][1] = 6;
		matrix1[1][2] = 7;
		matrix1[1][3] = 8;
		
		matrix2[0][0] = 1;
		matrix2[1][0] = 2;
		matrix2[2][0] = 3;
		matrix2[3][0] = 4;
		matrix2[0][1] = 5;
		matrix2[1][1] = 6;
		matrix2[2][1] = 7;
		matrix2[3][1] = 8;
		
		try {
			MultiplyMatrix multiplyMatrix = new MultiplyMatrix(matrix1, matrix2);
			multiplyMatrix.startMultiply();

			multiplyMatrix = new MultiplyMatrix(matrix2, matrix1);
			multiplyMatrix.startMultiply();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
