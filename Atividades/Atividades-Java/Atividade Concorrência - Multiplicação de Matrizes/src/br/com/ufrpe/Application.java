package br.com.ufrpe;

import br.com.ufrpe.domain.MultiplyMatrix;

public class Application {

	public static void main(String[] args) {
		int[][] matrix1 = new int[2][3];
		int[][] matrix2 = new int[3][2];
		
		matrix1[0][0] = 1;
		matrix1[0][1] = 2;
		matrix1[0][2] = 3;
		matrix1[1][0] = 4;
		matrix1[1][1] = 5;
		matrix1[1][2] = 6;
		
		matrix2[0][0] = 1;
		matrix2[0][1] = 2;
		matrix2[1][0] = 3;
		matrix2[1][1] = 4;
		matrix2[2][0] = 5;
		matrix2[2][1] = 6;
		
		try {
			MultiplyMatrix multiplyMatrix = new MultiplyMatrix(matrix1, matrix2);
			multiplyMatrix.startMultiply();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
