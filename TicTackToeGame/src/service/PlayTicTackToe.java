package service;

import exception.InvalidMoveException;
import model.Board;
import model.Player;

public class PlayTicTackToe {
    Character [][] playArea;
    private boolean isRunning;
	private int[] rows;
    private int[] cols;
    private int dig;
    private int antiDig;
    int moveCount;
    
    Player player;
    Board board;
    BoardService boardService;
    ValidateMove validateMove;
    
    public PlayTicTackToe(Player player, Board board) {
        this.rows = new int[3];
        this.cols = new int[3];
        this.dig = 0;
        this.antiDig = 0;
        
        this.isRunning = true;
        this.moveCount = 0;
        this.player = player;
        this.board = board;
        this.playArea = board.getPlayArea();
        this.boardService = new BoardService(board);
        this.validateMove = new ValidateMove(board);
        
        this.boardService.displayBoard();
    }
    
    public boolean isGameRunning() {
    	return this.isRunning;
    }
    
    public int getMoveCount() {
    	return this.moveCount;
    }

    public String currUser() {
        if (this.moveCount % 2 == 0) {
            return player.getUser1();
        }
        return player.getUser2();
    }

    private int detectUser() {
        if (this.moveCount % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean applyMove(int i, int j) throws Exception{
        String user = currUser();
//        if (!validateMove.isValidMove(i, j)) {
//            System.out.println("Hii " + user + " Please take right move");
//            return false;
//        }
        try {
        	try {
        		if(this.playArea[i][j] != null) throw new Exception();

        		int opr = this.detectUser();
		        if (opr == 1) {
		            this.playArea[i][j] = 'O';
		        } else {
		            this.playArea[i][j] = 'X';
		        }
		        
		        this.rows[i] += opr;
		        this.cols[j] += opr;
		        if (i == j) this.dig += opr;
		        if (i + j == board.getSIZE() - 1) this.antiDig += opr;
        	
        		if (this.rows[i] == 3 || this.cols[j] == 3 || this.dig == 3 || this.antiDig == 3 || this.rows[i] == -3 || this.cols[j] == -3 || this.antiDig == -3 || this.dig == -3) {
    	            this.isRunning = false;
    	            boardService.displayBoard();
    	            System.out.println("Congratulations !! " + user + " you won the game");
    	            return true;
    	        }
                
        	} catch(Exception e) {
        		throw new InvalidMoveException();
        	}
	        
        } catch(InvalidMoveException e) {
        	System.out.println(e.message());
        	return false;
        }
        
        this.moveCount++;
        boardService.displayBoard();
        return false;
    }
    
}