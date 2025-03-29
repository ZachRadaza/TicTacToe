package main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenTicTacToe extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Color bg = new Color(42, 52, 146);
	
	public ScreenTicTacToe(){
		
		this.setBounds(0, 0, 800, 800);
		this.setBackground(bg);
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		TicTacToePanel tttPanel = new TicTacToePanel();
		tttPanel.setBounds(80, 0, 720, 720);
		System.out.println(tttPanel.getWidth());
		this.add(tttPanel);
		
		//this.add(new JLabel("hi"));
		
		this.setVisible(true);
	}
	
}