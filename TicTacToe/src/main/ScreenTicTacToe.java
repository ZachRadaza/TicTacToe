package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenTicTacToe extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Color bg = new Color(42, 52, 146);
	
	private static JButton back;
	
	private static TicTacToePanel tttPanel;
	
	private static JPanel player1;
	private static JLabel score1;
	private static JPanel player2;
	private static JLabel score2;
	private static JPanel turnShower;
	private static JLabel turn;
	
	public ScreenTicTacToe(){
		
		this.setBounds(0, 0, 800, 800);
		this.setBackground(bg);

		tttPanel = new TicTacToePanel();
		tttPanel.setBounds(new Rectangle(720, 670));
		this.add(tttPanel);
		
		this.add(setScoreboard(tttPanel.player1Score, tttPanel.player2Score, tttPanel.turn));
		
		this.setVisible(true);
	}
	
	private JPanel setScoreboard(int player1Score, int player2Score, boolean turn){
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		main.setBackground(null);
		main.setMinimumSize(new Dimension(800, 150));
		
		player1 = setScorePlayer1();
		player1.setBounds(new Rectangle(233, 80));
		main.add(player1, BorderLayout.WEST);
		
		turnShower = setTurn();
		turnShower.setBounds(new Rectangle(233, 80));
		main.add(turnShower, BorderLayout.CENTER);
		
		player2 = setScorePlayer2();
		player1.setBounds(new Rectangle(233, 80));
		main.add(player2, BorderLayout.EAST);
		
		main.setVisible(true);
		return main;
	}
	
	private JPanel setScorePlayer1(){
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel name = new JLabel("Player 1 Score:");
		name.setFont(new Font("Dialog", Font.BOLD, 30));
		name.setForeground(Color.WHITE);
		name.setAlignmentX(CENTER_ALIGNMENT);
		
		score1 = new JLabel("0");
		score1.setFont(new Font("Dialog", Font.BOLD, 50));
		score1.setForeground(Color.WHITE);
		score1.setAlignmentX(CENTER_ALIGNMENT);
		
		panel.add(name);
		panel.add(score1);
		panel.setMinimumSize(new Dimension(233, 80));
		
		return panel;
	}
	
	private JPanel setScorePlayer2(){
		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel name = new JLabel("Player 2 Score");
		name.setFont(new Font("Dialog", Font.BOLD, 30));
		name.setForeground(Color.WHITE);
		name.setAlignmentX(CENTER_ALIGNMENT);
		
		score2 = new JLabel("0");
		score2.setFont(new Font("Dialog", Font.BOLD, 50));
		score2.setForeground(Color.WHITE);
		score2.setAlignmentX(CENTER_ALIGNMENT);
		
		panel.add(name);
		panel.add(score2);
		panel.setMinimumSize(new Dimension(233, 80));
		
		return panel;
	}
	
	private JPanel setTurn(){
		turnShower = new JPanel();
		turnShower.setBackground(null);
		turnShower.setLayout(new BoxLayout(turnShower, BoxLayout.Y_AXIS));
		
		turn = new JLabel("    Player 1's Turn    ");
		
		turn.setFont(new Font("Dialog", Font.BOLD, 30));
		turn.setForeground(Color.WHITE);
		turn.setAlignmentX(CENTER_ALIGNMENT);
		
		turnShower.add(turn);
		turnShower.setMinimumSize(new Dimension(250, 80));
		
		back = new JButton();
		JLabel label = new JLabel("Back to Main Menu");
		label.setFont(new Font("Dialog", Font.PLAIN, 15));
		back.add(label);
		back.addActionListener(this);
		back.setAlignmentX(CENTER_ALIGNMENT);
		
		turnShower.add(back);
		
		return turnShower;
	}
	
	protected static void player1ScoreUpdate(int score){
		player1.remove(score1);
		score1.removeAll();
		Integer scoreInteger = (Integer) score;
		String scoreString = scoreInteger.toString();
		
		score1 = new JLabel(scoreString);
		score1.setFont(new Font("Dialog", Font.BOLD, 50));
		score1.setForeground(Color.WHITE);
		score1.setAlignmentX(CENTER_ALIGNMENT);
		
		player1.add(score1);
	}
	
	protected static void player2ScoreUpdate(int score){
		player2.remove(score2);
		score2.removeAll();
		Integer scoreInteger = (Integer) score;
		String scoreString = scoreInteger.toString();
		
		score2 = new JLabel(scoreString);
		score2.setFont(new Font("Dialog", Font.BOLD, 50));
		score2.setForeground(Color.WHITE);
		score2.setAlignmentX(CENTER_ALIGNMENT);
		
		player2.add(score2);
	}
	
	protected static void turnUpdate(boolean turnBoolean){
		turnShower.removeAll();
		turn.removeAll();
		
		if(turnBoolean) turn = new JLabel("    Player 1's Turn    ");
		else turn = new JLabel("    Player 2's Turn    ");
		
		turn.setFont(new Font("Dialog", Font.BOLD, 30));
		turn.setForeground(Color.WHITE);
		turn.setAlignmentX(CENTER_ALIGNMENT);
		
		turnShower.add(turn);
		turnShower.add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back){
			this.setVisible(false);
			TTTGameLogic.reset();
			//TTTGameLogic.reset();
			TTTGameLogic.setVictory(false);
			this.remove(this);
			Game.start();
		}
	}
}