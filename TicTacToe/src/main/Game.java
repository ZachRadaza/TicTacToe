package main;

import java.awt.Color;

public class Game{
	
	private static Frame frame;
	private final Color bg = new Color(42, 52, 146);
	
	public Game(){
		
		frame = new Frame(true);
		frame.getContentPane().setBackground(bg);
		
		start();
		
		frame.setVisible(true);
	}
	
	protected static void start(){
		ScreenLoginn login = new ScreenLoginn();
		frame.add(login);
	}
	
	protected static void singlePlayer(){
		System.out.println("test");
		ScreenTicTacToe ttt = new ScreenTicTacToe();
		frame.add(ttt);
	}
	
	protected static void twoPlayer(){
		
	}
}