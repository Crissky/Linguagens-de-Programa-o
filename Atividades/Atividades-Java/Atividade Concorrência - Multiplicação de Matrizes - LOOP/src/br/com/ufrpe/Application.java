package br.com.ufrpe;

import java.util.Arrays;
import java.util.Random;

import br.com.ufrpe.domain.MultiplyMatrix;

public class Application {

	public static void main(String[] args) {
		int rowMatrix1 = 	20;
		int columnMatrix1 = 30;
		int rowMatrix2 = 	30;
		int columnMatrix2 = 50;
		
		int[] rowArray = {rowMatrix1, rowMatrix2};
		int[] columnArray = {columnMatrix1, columnMatrix2};
		
		int maxRow = Arrays.stream(rowArray).max().getAsInt();
		int maxColumn = Arrays.stream(columnArray).max().getAsInt();
		
		int[][] matrix1 = new int[rowMatrix1][columnMatrix1];
		int[][] matrix2 = new int[rowMatrix2][columnMatrix2];
		Random rand = new Random();
		
		for (int i = 0; i < maxRow; i++) {
			for (int j = 0; j < maxColumn; j++) {
				matrix1[i % matrix1.length][j % matrix1[0].length] = rand.nextInt(5);
				matrix2[i % matrix2.length][j % matrix2[0].length] = rand.nextInt(5);
			}
		}
		
		long time1 = java.lang.System.currentTimeMillis();
		
		try {
			MultiplyMatrix multiplyMatrix = new MultiplyMatrix(matrix1, matrix2);
			multiplyMatrix.startMultiply();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long time2 = java.lang.System.currentTimeMillis();
		
		System.out.println("\nTempo total: " + ((float) (time2-time1) / 1000) + " segundos");
	}

}
