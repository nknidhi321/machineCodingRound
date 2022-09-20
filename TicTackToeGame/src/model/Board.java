package model;

public class Board {
	
	private final int SIZE = 3;
	private Character[][] playArea;
	
	public Board() {
		super();
		initializeBoard();
	}
	
	public Board(Character[][] playArea) {
		super();
		this.playArea = playArea;
	}

	public int getSIZE() {
		return SIZE;
	}
	
	public Character[][] getPlayArea() {
		return playArea;
	}

	public void setPlayArea(Character[][] playArea) {
		this.playArea = playArea;
	}

	public void initializeBoard() {
		this.playArea = new Character[3][3];
	}

}
