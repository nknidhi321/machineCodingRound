package service;

import java.util.Scanner;

import model.Board;
import model.Player;
import model.Toss;

public class Main {
	
	PlayTicTackToe playTicTackToe;
	
	public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Let's Begin... ");
        System.out.println("Please enter 1st player name : ");
        String user1 = scn.nextLine();
        
        System.out.println("Please enter 2nd player name : ");
        String user2 = scn.nextLine();

        Toss createToss = new Toss();
        int toss = createToss.generateToss();
    	Player player;
    	if (toss == 0) {
    		 player = new Player(user1, user2);
        } else {
        	 player = new Player(user2, user1);
        }
  	
    	Main main = new Main();
    	Board board = new Board();
    	main.playTicTackToe  = new PlayTicTackToe(player, board);
    	Character[][] playArea = board.getPlayArea();
        
        main.playTicTackToe(playArea);

        scn.close();
	}
	
	public void playTicTackToe (Character[][] playArea) throws Exception{
		Scanner scn = new Scanner(System.in);
		boolean gotWinner = false;
		while (playTicTackToe.isGameRunning() && playTicTackToe.getMoveCount() < 9) {
            String user = playTicTackToe.currUser();
            System.out.println(user + " It's your turn..");
            int r = scn.nextInt();
            int c = scn.nextInt();
            boolean res = playTicTackToe.applyMove(r, c);
            if (res == true) {
            	gotWinner = true;
                break;
            }
        }
		
		if(!gotWinner) System.out.println("It's a tie..");
    }
        
}