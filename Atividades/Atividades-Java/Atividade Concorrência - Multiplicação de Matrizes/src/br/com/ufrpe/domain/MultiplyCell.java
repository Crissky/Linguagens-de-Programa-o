package br.com.ufrpe.domain;

public class MultiplyCell implements Runnable{
	private MultiplyMatrix multiplyMatrix;
	private int column;
	private int row;
	
	public MultiplyCell(MultiplyMatrix multiplyMatrix, int column, int row) {
		this.multiplyMatrix = multiplyMatrix;
		this.column = column;
		this.row = row;
	}

	@Override
	public void run() {
		int multiplyCellResult = 0;
		int num = this.multiplyMatrix.getMatrix2().length;
		
		for (int i = 0; i < num; i++) {
			int valueRow = this.multiplyMatrix.getMatrix1()[this.row][i];
			int valueColumn = this.multiplyMatrix.getMatrix2()[i][this.column];
			multiplyCellResult += valueRow * valueColumn;
		}
		
		this.multiplyMatrix.setCellResult(this.column, this.row, multiplyCellResult);
	}

}
