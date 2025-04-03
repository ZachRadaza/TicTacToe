package main;

public class TTTGameLogic{
	
	private static int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}; //0 is empty, 1 is o, 2 is x
	private static boolean victorySwitch = false;
	private static int winCondition = -1;
	
	public static void add(int button, boolean turn){ //turn is either 1 for o or 2 for x
		int turnInt = 2;
		if(turn) turnInt = 1;
		board[xConverter(button)][yConverter(button)] = turnInt;
		
		if(check()){ //if they win, reset everything
			reset();
		}
		System.out.println(board[0][0] + "|" + board[1][0] + "|" + board[2][0] + "\n" + board[0][1] + "|" +board[1][1] + "|" +board[2][1] + "\n" + board[0][2] + "|" +board[1][2] + "|" + board[2][2]);
		
	}
	
	private static boolean check(){
		int temp = board[0][0];
		for(int i = 0; i < 3; i++){ // checks vertically
			boolean lineCheck = false;
			temp = board[i][0];
			for(int j = 0; j < 3; j++){
				if(temp == 0) break;
				else if(board[i][j] == temp) {
					lineCheck = true;
					winCondition = i + 3;
				} else {
					lineCheck = false;
					break;
				}
			}
			if(lineCheck && temp != 0) return true;
		}
		
		for(int i = 0; i < 3; i++){ //checks horizontally
			boolean lineCheck = false;
			temp = board[0][i];
			for(int j = 0; j < 3; j++){
				if(temp == 0) break;
				else if(board[j][i] == temp) {
					lineCheck = true;
					winCondition = i;
				} else {
					lineCheck = false;
					break;
				}
			}
			if(lineCheck && temp != 0) return true;
		}
		
		temp = board[0][0];
		if(board[0][0] == temp && board[1][1] == temp && board[2][2] == temp && temp != 0) {
			winCondition = 6; // for the \
			return true;
		}
		temp = board[0][2];
		if(board[0][2] == temp && board[1][1] == temp && board[2][0] == temp && temp != 0) {
			winCondition = 7; // for the /
			return true;
		}
		
		return false;
	}
	
	protected static void reset(){
		victorySwitch = !victorySwitch;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = 0;
			}
		}
	}
	
	public static boolean getVictory(){
		return victorySwitch;
	}
	
	public static int getWinCondition(){
		return winCondition;
	}
	
	public static void setVictory(boolean condition){
		victorySwitch = condition;
	}
	//too lazy to think so I hard Coded it
	private static int xConverter(int i){
		switch(i){
			case 0:
			case 3:
			case 6:
				return 0;
			case 1:
			case 4:
			case 7:
				return 1;
			case 2:
			case 5:
			case 8:
				return 2;
			default:
				return -1;
		}
	}
	private static int yConverter(int i){
		switch(i){
			case 0:
			case 1:
			case 2:
				return 0;
			case 3:
			case 4:
			case 5:
				return 1;
			case 6:
			case 7:
			case 8:
				return 2;
			default:
				return -1;
		}
	}
}