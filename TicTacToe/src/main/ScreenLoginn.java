package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenLoginn extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Color bg = new Color(42, 52, 146);
	private JButton singlePlayer;
	private JButton twoPlayer;
	protected static boolean singlePlayerB = false;
	protected static boolean twoPlayerB = false;
	
	
	public ScreenLoginn(){
		
		this.setBackground(bg);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(panelLogo());
		this.add(panelSelection());
		
		this.setVisible(true);
	}
	
	private JPanel panelLogo(){
		JPanel panel = new JPanel();
		panel.setBackground(bg);
		panel.add(new JLabel(new ImageIcon("media/login/logo.png")));
		return panel;
	}
	
	private JPanel panelSelection(){
		JPanel panel = new JPanel();
		panel.setBackground(bg);
		panel.setLayout(new BorderLayout());
		singlePlayer = new JButton(new ImageIcon("media/login/oneplayer.png"));
		singlePlayer.setBackground(bg);
		singlePlayer.addActionListener(this);
		twoPlayer = new JButton(new ImageIcon("media/login/twoplayer.png"));
		twoPlayer.setBackground(bg);
		twoPlayer.addActionListener(this);
		panel.add(singlePlayer, BorderLayout.NORTH);
		panel.add(twoPlayer, BorderLayout.SOUTH);
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == singlePlayer){
			this.setVisible(false);
			this.remove(this);
			Game.singlePlayer();
		} else if(e.getSource() == twoPlayer){
			this.setVisible(false);
			this.remove(this);
			Game.twoPlayer();
		}
	}
}