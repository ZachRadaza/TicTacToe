package main;

import java.awt.Color;

import javax.swing.BoxLayout;
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
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		TicTacToePanel tttPanel = new TicTacToePanel();
		
		this.add(tttPanel);
		
		this.setVisible(true);
	}
	
}