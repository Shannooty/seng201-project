package gui;
import java.awt.EventQueue;

import java.util.ArrayList;

import monsters.*;
import player.Player;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSlider;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JSpinner;


//testing
public class SetupScreen {

	private JFrame frmSetup;


	private Player player;
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>();
	private int gameLength;
	private String difficulty;
	private JTextField username;
	

	
	public int getgameLength() {
		return gameLength;
	}
	
	public void setGameLength(int game) {
		gameLength = game;
	}
	
	public String getGameDifficulty() {
		return difficulty;
	}
	
	public void setGameDifficulty(String gameDifficulty) {
		difficulty = gameDifficulty;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	private void setStartingMonsters() {
		startingMonsters.add(new Slime());
		startingMonsters.add(new Zombie());
		startingMonsters.add(new UndeadGuard());
		startingMonsters.add(new Skeleton());
	}
	
	public void launchSetUpScreen(){
		//TODO create setupscreen class and pass the game through
	}
	
	
//	
//	public static void main(String[] args) {
//		SetupScreen game = new SetupScreen();
//		game.launchSetUpScreen();
//	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frmSetup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setBackground(Color.WHITE);
		frmSetup.setTitle("SetUp");
		frmSetup.setBounds(100, 100, 850, 570);
		frmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetup.getContentPane().setLayout(null);
		
		
		
		

		
		
		
		
		JLabel lblUsername = new JLabel("Please choose a username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(315, 14, 218, 26);
		frmSetup.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(328, 50, 162, 21);
		frmSetup.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblHowManyDays = new JLabel("How many days do you want to play?");
		lblHowManyDays.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHowManyDays.setBounds(307, 83, 226, 15);
		frmSetup.getContentPane().add(lblHowManyDays);
		
		
		
		JSlider gameLengthSlider = new JSlider(JSlider.HORIZONTAL, 3, 15, 9);
		gameLengthSlider.setBounds(287, 108, 200, 43);
		gameLengthSlider.setMajorTickSpacing(3);
		gameLengthSlider.setMinorTickSpacing(1);
		gameLengthSlider.setPaintTicks(true);
		gameLengthSlider.setPaintLabels(true);
		frmSetup.getContentPane().add(gameLengthSlider);


		
		
		
//		https://www.youtube.com/watch?v=3c0QZit2ObY
		
//		String images[] = {"C:/Users/cal135/Desktop/index.png", "C:/Users/cal135/Desktop/inde1x.png"};
//
//		JLabel pic = new JLabel();
//        pic.setBounds(40, 30, 700, 300);
//		
//		JPanel monsterPanel = new JPanel();
//		monsterPanel.setBounds(287, 190, 183, 184);
//		frmSetup.getContentPane().add(monsterPanel);
//		JButton forward = new JButton(">");
//		JButton back = new JButton("<");
//		monsterPanel.add(forward);
//		monsterPanel.add(back);
		
//		images[0] = new ImageIcon("https://itstabletoptime.fandom.com/wiki/Berri_Bobbins?file=Default.jpg");
//	    JLabel l = new JLabel("",JLabel.CENTER); 
//	    l.setIcon(images[0]);
	
		

		
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setGameLength(gameLengthSlider.getValue());
			}
		});
		btnNext.setBounds(595, 465, 117, 25);
		frmSetup.getContentPane().add(btnNext);
		
		JLabel lblSelectMonster = new JLabel("Please select a monster:");
		lblSelectMonster.setBounds(287, 170, 200, 15);
		frmSetup.getContentPane().add(lblSelectMonster);
		
		JLabel lblChooseDifficulty = new JLabel("Choose difficulty:");
		lblChooseDifficulty.setBounds(328, 400, 142, 19);
		frmSetup.getContentPane().add(lblChooseDifficulty);
		
		
	}
}













