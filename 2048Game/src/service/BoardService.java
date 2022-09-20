package service;

import model.Board;

public class BoardService {
	
	public static final int DEFAULT_ROWS = 4;
	public static final int DEFAULT_COLS = 4;
	public static final int DEFAULT_BOARD_SIZE = 16;
	int filledCells;
	Board board;
	
	public BoardService() {
		// this(BoardService.DEFAULT_BOARD_SIZE);
	}

	public BoardService(Board board) {
		this.filledCells = 0;
		this.board = board;
	}

	public int getFilledCells() {
		return filledCells;
	}

	public void setFilledCells(int filledCells) {
		this.filledCells = filledCells;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	public void displayBoard() {
		Integer[][] playArea = board.getPlayArea();
		int n = 4;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(playArea[i][j] == null) System.out.print("_\t");
				else System.out.print(playArea[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
}
