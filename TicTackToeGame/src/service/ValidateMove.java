package service;

import model.Board;

public class ValidateMove {
	Board board;
	Character[][] playArea;
	public ValidateMove(Board board){
		this.board = board;
		this.playArea = board.getPlayArea();
	}
	
	public boolean isValidMove(int i, int j) {
        if (i >= 0 && j >= 0 && j < 3 && i < 3 && playArea[i][j] == null) {
            return true;
        }
        return false;
    }
	
}
