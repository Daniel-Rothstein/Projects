package c247R.c247Rclassism;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class tictactoe {
	private int size;
	public tictactoe(int size) {
		size=size;
	}
	private String board [][] = new String [size][size];
	private boolean player1turn=true;
	private boolean done = false;

	public void run() {
		Scanner s= new Scanner(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ShowBoard();
		while (!isDone()) {
			if(player1turn) {
				System.out.println("Player 1 go");
			}
			else {
			System.out.println("Player 2 go");
			}
			while (!s.hasNext()) {
			}
			
				sb.append(s.next());
			String move=sb.toString();
			sb.setLength(0);
			char p []= move.toCharArray();
			int p1=(int)p[0]-48;
			int p2= (int)p[2]-48;
			if(p1<3&&p2<3)
			move(p1,p2);
			ShowBoard();
		}
	}

	private void ShowBoard(){
		System.out.print(board[0][0]);
		System.out.print("|");
		System.out.print(board[0][1]);
		System.out.print("|");
		System.out.println(board[0][2]);
		System.out.println("------");
		System.out.print(board[1][0]);
		System.out.print("|");
		System.out.print(board[1][1]);
		System.out.print("|");
		System.out.println(board[1][2]);
		System.out.println("------");
		System.out.print(board[2][0]);
		System.out.print("|");
		System.out.print(board[2][1]);
		System.out.print("|");
		System.out.println(board[2][2]);
	}
	private boolean move(int p1, int p2) {
		if (done) {
				System.out.println("the game is over silly");
			return false;
		}
		System.out.println(p1+" "+p2);
		if (!(board[p1][p2].equals("X")||board[p1][p2].equals("O"))) {
			if (player1turn) {
				board[p1][p2]="O";
			}
			else {
				board[p1][p2]="X";
			}
			player1turn=!player1turn;
			boolean check=isDone();
			if (!check) {
				System.out.println("new turn");
			}
			else {
				done=true;
			}
			//ShowBoard();
			return true;
		}
		else {
			System.out.println("you can't go there");
			//ShowBoard();
			return false;
		}
		
	}
	public boolean isDone(){
		for (int i=0;i<3;i++) {
			if (!board[0][i].equals(" ")) {
				if (board[1][i].equals(board[2][i])&&board[1][i].equals(board[0][i])) {
					if (board[0][i].equals("X")) {
						System.out.println("Player 2 wins!!");
						
					}
					else {
						System.out.println("Player 1 wins!!");
				
					}
					return true;
				}
			}
		}
		for (int i=0;i<3;i++) {
			if (!board[i][0].equals(" ")) {
				if (board[i][1].equals(board[i][2])&&board[i][1].equals(board[i][0])) {
					if (board[i][1].equals("X")) {
						System.out.println("Player 2 wins!!");
						
					}
					else {
						System.out.println("Player 1 wins!!");
				
					}
					return true;
				}
			}
		}
			if (!board[0][0].equals(" ")) {
				if (board[1][1].equals(board[2][2])&&board[1][1].equals(board[0][0])) {
					if (board[0][0].equals("X")) {
						System.out.println("Player 2 wins!!");
						
					}
					else {
						System.out.println("Player 1 wins!!");
				
					}
					return true;
				}
			}
			if (!board[0][2].equals(" ")) {
				if (board[1][1].equals(board[2][0])&&board[1][1].equals(board[0][2])) {
					if (board[0][2].equals("X")) {
						System.out.println("Player 2 wins!!");
						
					}
					else {
						System.out.println("Player 1 wins!!");
				
					}
					return true;
				}
			}
		
		return false;
	}
	
}