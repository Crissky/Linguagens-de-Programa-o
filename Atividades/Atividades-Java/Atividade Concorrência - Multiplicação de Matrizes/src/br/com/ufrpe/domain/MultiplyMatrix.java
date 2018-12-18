package br.com.ufrpe.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiplyMatrix {
	private int[][] matrix1;
	private int[][] matrix2;
	private int[][] matrixResult;
		
	public MultiplyMatrix(int[][] matrix1, int[][] matrix2) throws Exception {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		
		if(!this.isMultipliable()) {
			throw new Exception("As matrizes informadas não podem ser multiplicas."
					+ "O número de colunas da 1º Matriz deve ser igual ao número de linhas da 2º Matriz."
					);
		}

		int rows = this.matrix1.length;
		int columns = this.matrix2[0].length;
		this.matrixResult = new int[rows][columns];
	}

	public void startMultiply() {
		List<Thread> threads = new ArrayList<Thread>();
		this.startMultiply(0, 0, threads);
	}

	public void startMultiply(int column, int row, List<Thread> threads) {
		int numRows = this.matrixResult.length - 1;
		int numColumns = this.matrixResult[0].length;
		
		if(column < numColumns) {
			createMultiplyCellThread(column, row, threads);
		} else if (row < numRows) {
			this.startMultiply(0, (row+1), threads);
		} else {
			runMultiply(threads);
		}
	}

	private void createMultiplyCellThread(int column, int row, List<Thread> threads) {
		MultiplyCell multiplier = new MultiplyCell(column, row);
		Thread thread = new Thread(multiplier);
		threads.add(thread);
		this.startMultiply((column+1), row, threads);
	}
	
	private void runMultiply(List<Thread> threads) {
		startThreads(threads);
		joinThreads(threads);
		printResult();
	}

	private void startThreads(List<Thread> threads) {
		for (Thread thread : threads) {
			thread.start();
		}
	}

	private void joinThreads(List<Thread> threads) {
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isMultipliable() {
		boolean result = true;
		
		if( matrix1[0].length != matrix2.length ) {
			result = false;
		}
		
		return result;
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

	private void printResult() {
		System.out.println("\nMatriz 1");
		this.printMatrix(this.matrix1);
		System.out.println("\nMatriz 2");
		this.printMatrix(this.matrix2);
		System.out.println("\nMatriz Resultado");
		this.printMatrix(this.matrixResult);
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
	
	public void setCellResult(int column, int row, int cellResult) {
		this.matrixResult[row][column] = cellResult;
	}

	class MultiplyCell implements Runnable{
		private int column;
		private int row;
		
		public MultiplyCell(int column, int row) {
			this.column = column;
			this.row = row;
		}

		@Override
		public void run() {
			int multiplyCellResult = 0;
			int numOperation = matrix2.length;
			
			for (int i = 0; i < numOperation; i++) {
				int valueRow = matrix1[this.row][i];
				int valueColumn = matrix2[i][this.column];
				multiplyCellResult += valueRow * valueColumn;
			}
			
			setCellResult(this.column, this.row, multiplyCellResult);
		}
	}
}
