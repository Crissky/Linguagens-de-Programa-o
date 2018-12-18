package br.com.ufrpe.domain;

public class MultiplyPoint implements Runnable{
	private MultiplyMatrix2 multiplyMatrix;
	private int column;
	private int row;
	
	public MultiplyPoint(MultiplyMatrix2 multiplyMatrix, int column, int row) {
		this.multiplyMatrix = multiplyMatrix;
		this.column = column;
		this.row = row;
	}

	@Override
	public void run() {
		int multiplyCellResult = 0;
		int numOperation = this.multiplyMatrix.getMatrix2().length;
		
		for (int i = 0; i < numOperation; i++) {
			int valueRow = this.multiplyMatrix.getMatrix1()[this.row][i];
			int valueColumn = this.multiplyMatrix.getMatrix2()[i][this.column];
			multiplyCellResult += valueRow * valueColumn;
		}
		
		this.multiplyMatrix.setCellResult(this.column, this.row, multiplyCellResult);
	}

}
