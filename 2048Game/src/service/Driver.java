package service;

import java.util.Scanner;

import model.Board;

public class Driver {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		Board board = new Board();
		BoardService boardService = new BoardService(board);
		GameService gameService = new GameService(board);
		
		while(!gameService.checkIfGameCompleted()) {
			System.out.println("LEFT : 0 \t RIGHT : 1 \t UP : 2 \t DOWN : 3");
			boardService.displayBoard();
			int move = sc.nextInt();
			gameService.playGame(move);
			if(move == 0)
			System.out.println("After Left MOVE ");

			else if(move == 1)
			System.out.println("After Right MOVE ");

			else if(move == 2)
			System.out.println("After Top MOVE ");
			
			else 
			System.out.println("After Bottom MOVE ");
			
			boardService.displayBoard();
			System.out.println();
		}
		
		sc.close();
	}

}
