package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Frame(boolean visibility){

		this.setTitle("TicTacToe");
		this.setSize(825, 825);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		ImageIcon image = new ImageIcon("media/game/o.png");
		this.setIconImage(image.getImage());
		
		this.setVisible(visibility);
		
	}
	
}