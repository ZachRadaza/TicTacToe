package main;

import java.awt.Color;

public class Game{
	
	protected static Frame frame;
	private final Color bg = new Color(42, 52, 146);
	
	public Game(){
		
		frame = new Frame(true);
		frame.getContentPane().setBackground(bg);
		frame.getContentPane().setBounds(0, 0, 800, 800);
		
		start();
		
		frame.setVisible(true);
	}
	
	protected static void start(){
		ScreenLoginn login = new ScreenLoginn();
		frame.add(login);
	}
	
	protected static void singlePlayer(){
		SinglePlayer ttt = new SinglePlayer();
		frame.add(ttt);
	}
	
	protected static void twoPlayer(){
		ScreenTicTacToe ttt = new ScreenTicTacToe();
		frame.add(ttt);
	}
}