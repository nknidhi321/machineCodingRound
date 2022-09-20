package service;

import model.Board;

public class BoardService {
	
	Board board;
	
	public BoardService() {
	}
	public BoardService(Board board){
		this.board = board;
	}
	
	public void displayBoard() {
		System.out.println();
        for (int i = 0; i < board.getSIZE(); i++) {
            for (int j = 0; j < board.getSIZE(); j++) {
            	Character[][] playArea = board.getPlayArea();
                if (playArea[i][j] == null) {
                    System.out.print("_\t");
                } else {
                    System.out.print(playArea[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

}
