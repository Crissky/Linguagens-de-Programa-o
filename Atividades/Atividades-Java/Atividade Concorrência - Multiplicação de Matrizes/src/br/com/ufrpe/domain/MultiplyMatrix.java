package br.com.ufrpe.domain;

import java.util.Arrays;

public class MultiplyMatrix {
	private int[][] matrix1;
	private int[][] matrix2;
	private int[][] matrixResult;
		
	public MultiplyMatrix(int[][] matrix1, int[][] matrix2) throws Exception {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		
		if(!this.isMultipliable()) {
			throw new Exception("As matrizes informadas não podem ser multiplicas");
		}

		int rows = this.matrix1.length;
		int columns = this.matrix2[0].length;
		this.matrixResult = new int[rows][columns];
	}

	public void startMultiply() {
		int numRows = this.matrixResult.length;
		int numcolumns = this.matrixResult[0].length;
		MultiplyPoint multiplier;
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numcolumns; j++) {
				multiplier = new MultiplyPoint(this, j, i);
				Thread thread = new Thread(multiplier);
				thread.start();
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("Matriz 1");
		this.printMatrix(this.matrix1);
		System.out.println("Matriz 2");
		this.printMatrix(this.matrix2);
		System.out.println("Matriz Resultado");
		this.printMatrix(this.matrixResult);
	}
	
	public boolean isMultipliable() {
		boolean result = true;
		
		if( matrix1[0].length != matrix2.length ) {
			result = false;
		}
		
		return result;
	}
	
	public void setCellResult(int column, int row, int cellResult) {
		this.matrixResult[row][column] = cellResult;
	}
	
	public Boolean isMatrix(int[][] matrix) {
		int lengthBase = matrix[0].length;
		boolean result = true;
		
		for (int[] is : matrix) {
			if(is.length != lengthBase) {
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	public void printMatrix(int[][] matrix) {
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
	}

	public int[][] getMatrix1() {
		return matrix1;
	}

	public void setMatrix1(int[][] matrix1) {
		this.matrix1 = matrix1;
	}

	public int[][] getMatrix2() {
		return matrix2;
	}

	public void setMatrix2(int[][] matrix2) {
		this.matrix2 = matrix2;
	}

	public int[][] getMatrixResult() {
		return matrixResult;
	}

	public void setMatrixResult(int[][] matrixResult) {
		this.matrixResult = matrixResult;
	}
}
