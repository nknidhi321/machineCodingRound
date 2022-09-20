package service;

import java.util.Random;

import model.Board;

public class GameService {
	
	int move;
	boolean isGameCompleted;
	boolean is2048Achieved;
	Board board;
	BoardService boardService;

	
	public GameService(Board board) {
		this.isGameCompleted = false;
		this.is2048Achieved = false;
		this.board = board;
		board.setPlayArea(new Integer[BoardService.DEFAULT_ROWS][BoardService.DEFAULT_COLS]);
		
		Integer[][] playArea = board.getPlayArea();
		playArea[0][2] = 2;
		playArea[0][1] = 2;
		playArea[3][1] = 2;
		
		this.boardService = new BoardService(board);
	}
	
	
	public boolean isGameCompleted() {
		return isGameCompleted;
	}

	public void setGameCompleted(boolean isGameCompleted) {
		this.isGameCompleted = isGameCompleted;
	}

	public boolean isIs2048Achieved() {
		return is2048Achieved;
	}

	public void setIs2048Achieved(boolean is2048Achieved) {
		this.is2048Achieved = is2048Achieved;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public BoardService getBoardService() {
		return boardService;
	}

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}
	
	
	// =============SERVICES===================
	
	public void playGame(int move) {
	//	System.out.println("Hi");
		// boardService.displayBoard();
		int size = BoardService.DEFAULT_ROWS;
		Integer[][] playArea = board.getPlayArea();
		
		if(move == 0) { // left
		    for(int row = 0; row < 4; row++){
	            int ptr = 0;
	            boolean isMerge = false;
	            int i = 0; 
	            while(i < 4){
	                if(i == ptr){
	                    i++;
	                    continue;
	                }
	                if(playArea[row][ptr] != null && playArea[row][i] != null){
	                    
	                    if(playArea[row][ptr] == playArea[row][i]){
	                        if(isMerge){
	                            ptr++;
	                        }
	                        playArea[row][ptr] = 2* playArea[row][i];
	                        playArea[row][i] = null;
	                        isMerge = true;
	                        i++;
	                    }else{
	                        isMerge = false;
	                        ptr++;
	                        Integer val = playArea[row][i];
	                        playArea[row][i] = null;
	                        playArea[row][ptr] = val;
	                        
	                     }
	                }else if(playArea[row][i] == null){
	                    i++;
	                }else if(playArea[row][ptr] == null){
	                    playArea[row][ptr] = playArea[row][i];
	                    playArea[row][i] = null;
	                    i++;
	                }else{
	                    i++;
	                }
	            }
		    }
		}
		else if(move == 1) { // right
		    for(int row = 0; row < 4; row++){
	            int ptr = 3;
	            boolean isMerge = false;
	            int i = 3; 
	            while(i >= 0){
	                if(i == ptr){
	                    i--;
	                    continue;
	                }
	                if(playArea[row][ptr] != null && playArea[row][i] != null){
	                    
	                    if(playArea[row][ptr] == playArea[row][i]){
	                        if(isMerge){
	                            ptr--;
	                        }
	                        playArea[row][ptr] = 2* playArea[row][i];
	                        System.out.println(playArea[row][ptr]);
	                        playArea[row][i] = null;
	                        isMerge = true;
	                        i--;
	                    }else{
	                        isMerge = false;
	                        ptr--;
	                        Integer val = playArea[row][i];
	                        playArea[row][i] = null;
	                        playArea[row][ptr] = val;
	                        
	                     }
	                }else if(playArea[row][i] == null){
	                    i--;
	                }else if(playArea[row][ptr] == null){
	                    playArea[row][ptr] = playArea[row][i];
	                    playArea[row][i] = null;
	                    i--;
	                }else{
	                    i--;
	                }
	            }
		    }
		}
		else if(move == 2) { // top
			System.out.println("Inside move 2");
		    for(int col = 0; col < 4; col++){
	            int ptr = 0;
	            boolean isMerge = false;
	            int i = 0; 
	            while(i < 4){
	                if(i == ptr){
	                    i++;
	                    continue;
	                }
	                if(playArea[ptr][col] != null && playArea[i][col] != null){
	                    
	                    if(playArea[ptr][col] == playArea[i][col]){
	                        if(isMerge){
	                            ptr++;
	                        }
	                        playArea[ptr][col] = 2* playArea[i][col];
	                        System.out.println(playArea[ptr][col]);
	                        playArea[i][col] = null;
	                        isMerge = true;
	                        i++;
	                    }else{
	                        isMerge = false;
	                        ptr++;
	                        Integer val = playArea[i][col];
	                        playArea[i][col] = null;
	                        playArea[ptr][col] = val;
	                        
	                     }
	                }else if(playArea[i][col] == null){
	                    i++;
	                }else if(playArea[ptr][col] == null){
	                    playArea[ptr][col] = playArea[i][col];
	                    playArea[i][col] = null;
	                    i++;
	                }else{
	                    i++;
	                }
	            }
		    }

		}
		else if(move == 3) { // bottom
			for(int col = 0; col < 4; col++){
	            int ptr = 3;
	            boolean isMerge = false;
	            int i = 3; 
	            while(i >= 0){
	                if(i == ptr){
	                    i--;
	                    continue;
	                }
	                if(playArea[ptr][col] != null && playArea[i][col] != null){
	                    
	                    if(playArea[ptr][col] == playArea[i][col]){
	                        if(isMerge){
	                            ptr--;
	                        }
	                        playArea[ptr][col] = 2 * playArea[i][col];
	                        playArea[i][col] = null;
	                        isMerge = true;
	                        i--;
	                    }else{
	                        isMerge = false;
	                        ptr--;
	                        Integer val = playArea[i][col];
	                        playArea[i][col] = null;
	                        playArea[ptr][col] = val;
	                        
	                     }
	                }else if(playArea[i][col] == null){
	                    i--;
	                }else if(playArea[ptr][col] == null){
	                    playArea[ptr][col] = playArea[i][col];
	                    playArea[i][col] = null;
	                    i--;
	                }else{
	                    i--;
	                }
	            }
		    }
		}
		checkIfGameCompleted();
		//int randNum = generateRandomNumber();
		int idx = pickRandomEmptyCell();
		playArea[idx / 4][idx % 4] = 2;
	}
	
	public boolean checkIfGameCompleted() {
		int n = 4, count = 0;
		Integer[][] playArea = board.getPlayArea();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(playArea[i][j] != null) {
					count++;
				}
			}
		}
		boardService.setFilledCells(count);
		
		if(this.is2048Achieved || boardService.getFilledCells() == BoardService.DEFAULT_BOARD_SIZE) {
			if(this.is2048Achieved) {
				System.out.println("Congratulation !! You won the game..");
			}
			else if(boardService.getFilledCells() == BoardService.DEFAULT_BOARD_SIZE) {
				System.out.println("Alas !! You lost the game..");
			}
			this.isGameCompleted = true;
			return true;
		}
		return false;
	}

	public int generateRandomNumber() {
//		if(boardService.getFilledCells() < BoardService.DEFAULT_BOARD_SIZE) {
//			Random rand = new Random();
//			int randomNumber = rand.nextInt(2, 10);
//			if(randomNumber % 2 != 0) return randomNumber + 1;  
//		}
		
		return -1;
	}
	
	public int pickRandomEmptyCell() {
		Integer[][] playArea = board.getPlayArea();
		int row, col, randomCellIdx;
		if(boardService.getFilledCells() != BoardService.DEFAULT_BOARD_SIZE) {
			do {
				Random rand = new Random();
				randomCellIdx = rand.nextInt(0, BoardService.DEFAULT_BOARD_SIZE);
				row = randomCellIdx / BoardService.DEFAULT_ROWS;
				col = randomCellIdx % BoardService.DEFAULT_COLS;
			} while(playArea[row][col] == null);
			
			return randomCellIdx;
		}
		return -1;
	}
	
}
