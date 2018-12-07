package br.com.ufrpe;

import java.util.ArrayList;
import java.util.List;

import br.com.ufrpe.domain.Fork;
import br.com.ufrpe.domain.Philosopher;
import br.com.ufrpe.domain.Table;

public class Aplication {

	public static void main(String[] args) {
		int numFork = 5;
		int timeSleep = 2000;
		Fork[] forksArrays = new Fork[numFork];
		Table table = new Table(forksArrays);

		List<Thread> threadsList = new ArrayList<Thread>();

		for (int i = 0; i < forksArrays.length; i++) {
			forksArrays[i] = new Fork(i);

			Philosopher philosopher = new Philosopher(i, timeSleep, table);
			Thread thread = new Thread(philosopher);
			threadsList.add(thread);
		}
		startThreads(threadsList);
		joinThreads(threadsList);
		
		System.err.println("\n\nO BAR FECHOU. PROGRAMA ENCERRADO!!!");
	}

	private static void joinThreads(List<Thread> threadsList) {
		for (Thread thread : threadsList) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void startThreads(List<Thread> threadsList) {
		for (Thread thread : threadsList) {
			thread.start();
		}
	}
}
