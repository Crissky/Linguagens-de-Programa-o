package br.com.ufrpe.domain;

public class Fork {
	private int position;

	@Override
	public String toString() {
		return "Fork " + position;
	}

	public Fork(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}
