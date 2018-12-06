package br.com.ufrpe.domain;

public class Philosopher implements Runnable {
	private int id;
	private int timeSleep;
	private Fork leftHand;
	private Fork rightHand;
	private Table table;

	public Philosopher(int id, int timeSleep, Table table) {
		this.id = id;
		this.timeSleep = timeSleep;
		this.table = table;
	}

	@Override
	public void run() {
		this.eat(this.timeSleep);
		this.think(this.timeSleep);
		this.eat(this.timeSleep);
		this.think(this.timeSleep);
		System.err.println("Fil�sofo " + this.id + " recebeu um telefonema de sua mulher e saiu da mesa.");
	}

	public void eat(int time) {
		try {
			System.err.println("Fil�sofo " + id + " Vai tentar comer.");
			this.takeFork();
			printStartEat();
			Thread.sleep(time);
			System.err.println("Fil�sofo " + id + " acabou de comer.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void printStartEat() {
		int leftFork = this.leftHand.getPosition();
		int rightFork = this.rightHand.getPosition();
		System.err.println("Fil�sofo " + id + " est� comendo com os garfos " + leftFork + " e " + rightFork);
	}

	public void think(int time) {
		try {
			this.dropFork();
			System.err.println("Fil�sofo " + id + " est� pensando...");
			Thread.sleep(time);
			System.err.println("Fil�sofo " + id + " parou de pensar.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void takeFork() {
		Fork[] forks = null;

		while (forks == null) {
			forks = this.table.takeFork(id);
		}

		this.leftHand = forks[0];
		this.rightHand = forks[1];
	}

	public void dropFork() {
		if (this.leftHand == null) {
			System.err.println("Fil�sofo " + id + " Tentou devolver Garfos da m�o esquerda vazia");
		}

		if (this.rightHand == null) {
			System.err.println("Fil�sofo " + id + " Tentou devolver Garfos da m�o direita vazia");
		}

		this.table.dropFork(this.leftHand);
		this.table.dropFork(this.rightHand);

	}

	public Fork getLeftHand() {
		return leftHand;
	}

	public void setLeftHand(Fork leftHand) {
		this.leftHand = leftHand;
	}

	public Fork getRightHand() {
		return rightHand;
	}

	public void setRightHand(Fork rightHand) {
		this.rightHand = rightHand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTimeSleep() {
		return timeSleep;
	}

	public void setTimeSleep(int timeSleep) {
		this.timeSleep = timeSleep;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

}
