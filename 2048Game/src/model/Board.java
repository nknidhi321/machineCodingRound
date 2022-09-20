package model;

public class Board {

	private Integer[][] playArea;

	
	public Board() {
		super();
	}

	public Board(Integer[][] playArea) {
		super();
		this.playArea = playArea;
	}
	
	public Integer[][] getPlayArea() {
		return playArea;
	}

	public void setPlayArea(Integer[][] playArea) {
		this.playArea = playArea;
	}

}
