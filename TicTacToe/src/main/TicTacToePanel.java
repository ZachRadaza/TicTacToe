package main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToePanel extends JPanel{
	
	private final Color bg = new Color(42, 52, 146);
	
	public TicTacToePanel(){
		
		this.setBackground(bg);
		
		JPanel panelBG = panelBG();
		this.add(panelBG());
		panelBG.setLocation(0, 0);
		
		JPanel panelFG = panelFG();
		this.add(panelFG);
		panelFG.setLocation(0, 0);
		
		this.setVisible(true);
	}
	
	private JPanel panelBG(){
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon("media/game/frame.png"));
		panel.add(label);
		panel.setBackground(null);
		return panel;
	}
	
	private JPanel panelFG(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		
		
		panel.setBackground(null);
		return panel;
	}
}