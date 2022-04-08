<<<<<<< HEAD
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
public class GameEnvironment {

	private JFrame frmSetup;


	private Player player;
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>();
	private int gameLength;
	private String difficulty;
	private JTextField username;
	
	
//	
//	public GameEnvironment() {
//		setStartingMonsters();
//		
//	}
	
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
//		GameEnvironment game = new GameEnvironment();
//		game.launchSetUpScreen();
//	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameEnvironment window = new GameEnvironment();
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
	public GameEnvironment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setBackground(Color.WHITE);
		frmSetup.setTitle("SetUp");
		frmSetup.setBounds(100, 100, 750, 550);
		frmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetup.getContentPane().setLayout(null);
		
		
		
		

		
		
		
		
		JLabel lblUsername = new JLabel("Please choose a username:");
		lblUsername.setBounds(267, 12, 203, 26);
		frmSetup.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(315, 50, 114, 19);
		frmSetup.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblHowManyDays = new JLabel("How many days do you want to play?");
		lblHowManyDays.setBounds(249, 81, 282, 15);
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
		
		
=======
import java.util.ArrayList;

import monsters.*;
import player.Player;

public class GameEnvironment {
	
	private int gameLength;
	private String difficulty;
	private Player player;
	private ArrayList<Monster> startingMonsters = new ArrayList<Monster>();
	
	
	public GameEnvironment() {
		setStartingMonsters();
		
	}
	
	public int getGameLength() {
		return gameLength;
	}
	
	
	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
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
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchSetUpScreen();
>>>>>>> branch 'main' of https://github.com/Shannooty/seng201-project.git
	}
}
