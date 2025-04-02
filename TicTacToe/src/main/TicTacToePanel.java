package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;

public class TicTacToePanel extends JLayeredPane implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Color bg = new Color(42, 52, 146);
	
	private JButton[] buttons;
	private boolean[] buttonsClicked;
	
	protected boolean turn; // true is player 1s turn
	private boolean victorySwitch;
	
	protected int player1Score;
	protected int player2Score;
	
	public TicTacToePanel(){
		turn = true;
		victorySwitch = false;
		buttonsClicked = new boolean[9];
		for(int i = 0; i < buttonsClicked.length; i++){
			buttonsClicked[i] = false;
		}
		player1Score = 0;
		player2Score = 0;
		
		this.setBackground(bg);
		this.setPreferredSize(new Dimension(720, 650));
		
		JPanel panelBG = panelBG();
		panelBG.setBounds(0, 0, 720, 720);
		panelBG.setMaximumSize(new Dimension(720, 650));
		this.add(panelBG, JLayeredPane.DEFAULT_LAYER);
		
		JPanel panelFG = panelFG();
		panelFG.setBounds(40, 40, 650, 650);
		panelFG.setMaximumSize(new Dimension(650, 650));
		this.add(panelFG, JLayeredPane.PALETTE_LAYER);
		
		this.setVisible(true);
	}
	
	private JPanel panelBG(){
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon("media/game/frame.png"));
		panel.add(label);
		panel.setBackground(bg);
		return panel;
	}
	
	private JPanel panelFG(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		
		buttons = new JButton[9];
		
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton();
			buttons[i].setBackground(bg);
			buttons[i].addActionListener(this);
			buttons[i].setBorderPainted(false);
			buttons[i].setOpaque(false);
			panel.add(buttons[i]);
		}
		
		panel.setBackground(null);
		panel.setOpaque(false);
		return panel;
	}
	//checks turn and pastes icon
	private void checkTurn(int butt){
		if(buttonsClicked[butt]) return;
		if(turn) buttons[butt].setIcon(new ImageIcon("media/game/o.png"));
		else buttons[butt].setIcon(new ImageIcon("media/game/x.png"));
		
		buttonsClicked[butt] = true;
		turn = !turn;
		TTTGameLogic.add(butt, turn);
		if(!checkWin())
			checkDraw();
		
		ScreenTicTacToe.turnUpdate(turn);
	}
	
	private boolean checkWin(){
		if(victorySwitch != TTTGameLogic.getVictory()){
			victorySwitch = !victorySwitch;
			win();
			return true;
		}
		return false;
	}
	
	private void checkDraw(){
		if(buttonsClicked[0] == true && buttonsClicked[1] == true && buttonsClicked[2] == true && buttonsClicked[3] == true && buttonsClicked[4] == true && buttonsClicked[5] == true && buttonsClicked[6] == true && buttonsClicked[7] == true && buttonsClicked[8] == true){
			draw();
		}
	}
	
	private void win(){
		JPanel panelSlash = new JPanel();
		JPanel panelWin = new JPanel();
		String wc = "WC" + TTTGameLogic.getWinCondition();
		panelSlash.add(new JLabel(new ImageIcon("media/game/" + wc + ".png")));
		panelSlash.setBackground(null);
		panelSlash.setBounds(0, 0, 720, 720);
		panelSlash.setMaximumSize(new Dimension(720, 720));
		panelSlash.setOpaque(false);
		
		//added ! because it flips turn during check turn
		if(!turn) {
			panelWin.add(new JLabel(new ImageIcon("media/game/Player1Wins.png")));
			player1Score++;
			ScreenTicTacToe.player1ScoreUpdate(player1Score);
		} else { 
			panelWin.add(new JLabel(new ImageIcon("media/game/Player2Wins.png")));
			player2Score++;
			ScreenTicTacToe.player2ScoreUpdate(player2Score);
		}
		
		panelWin.setBackground(null);
		panelWin.setBounds(0, 0, 720, 720);
		panelWin.setMaximumSize(new Dimension(720, 720));
		panelWin.setOpaque(false);
		
		this.add(panelSlash, JLayeredPane.MODAL_LAYER);
		this.add(panelWin, JLayeredPane.POPUP_LAYER);
		
		reset(panelWin, panelSlash);
	}
	
	private void draw(){
		JPanel panelDraw = new JPanel();
		JPanel temp = new JPanel();
		panelDraw.add(new JLabel(new ImageIcon("media/game/draw.png")));
		panelDraw.setBackground(null);
		panelDraw.setBounds(0, 0, 720, 720);
		panelDraw.setMaximumSize(new Dimension(720, 720));
		panelDraw.setOpaque(false);
		this.add(panelDraw, JLayeredPane.POPUP_LAYER);
		
		reset(panelDraw, temp);
	}
	
	private void reset(JPanel panel1, JPanel panel2){
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run(){
				for(int i = 0; i < buttonsClicked.length; i++){
					buttonsClicked[i] = false;
					buttons[i].setIcon(null);
					victorySwitch = !victorySwitch;
					TTTGameLogic.reset();
					panel1.setVisible(false);
					panel2.setVisible(false);
					remove(panel1);
					remove(panel2);
				}
			}
		};
		
		timer.schedule(task, 5000);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttons[0]){
			checkTurn(0);
		} else if(e.getSource() == buttons[1]){
			checkTurn(1);
		} else if(e.getSource() == buttons[2]){
			checkTurn(2);
		} else if(e.getSource() == buttons[3]){
			checkTurn(3);
		} else if(e.getSource() == buttons[4]){
			checkTurn(4);
		} else if(e.getSource() == buttons[5]){
			checkTurn(5);
		} else if(e.getSource() == buttons[6]){
			checkTurn(6);
		} else if(e.getSource() == buttons[7]){
			checkTurn(7);
		} else if(e.getSource() == buttons[8]){
			checkTurn(8);
		}
		
	}
}