package br.com.ufrpe.domain;

import java.util.Arrays;

public class Table {
	private Fork[] forks;

	public Table(Fork[] forks) {
		this.forks = forks;
	}

	public synchronized Fork[] takeFork(int position) {
		String text1 = "Filósofo " + position + " olhou a mesa para pegar garfos:";
		printTable(text1);

		int position1 = getArrayPosition(position);
		int position2 = getArrayPosition((position + 1));

		Fork[] forks = null;

		if (this.forks[position1] == null || this.forks[position2] == null) {
			try {
				printForkInUse(position1, position2);
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			forks = new Fork[] { this.forks[position1], this.forks[position2] };
			this.forks[position1] = null;
			this.forks[position2] = null;
			String text2 = "Filósofo " + position + " pegou garfos nas posições " + forks[0] + " e " + forks[1];
			printTable(text2);
		}

		return forks;
	}

	private int getArrayPosition(int position) {
		return (position) % (this.forks.length);
	}

	private void printForkInUse(int position1, int position2) {
		if (this.forks[position1] == null) {
			System.err.println("Garfo na posição " + position1 + " está em uso.");
		}
		if (this.forks[position2] == null) {
			System.err.println("Garfo na posição " + position2 + " está em uso.");
		}
	}

	private void printTable(String firstLine) {
		System.err.println("\n" + firstLine + "\nGarfos na mesa " + Arrays.toString(this.forks));
	}

	public synchronized void dropFork(Fork fork) {
		int position = fork.getPosition();
		this.forks[position] = fork;

		System.err.println("Garfo na posição " + position + " foi largado");
		this.notifyAll();
	}

	public Fork[] getForks() {
		return forks;
	}

	public void setForks(Fork[] forks) {
		this.forks = forks;
	}
}
