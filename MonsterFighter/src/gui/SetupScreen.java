package gui;
import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

import player.*;
import purchasable.monsters.*;

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
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import day.Day;

import javax.swing.JList;
import javax.swing.JSpinner;


/**
 * 
 * @author 
 *
 */
public class SetupScreen {
	
	/**
	 * Attribute frmSetup of type JFrame. The frame which is displayed to the user. Contains the UI for the SetupScreen.
	 */
	private JFrame frmSetup;
	
	/**
	 * Attribute startingMonster of type Monster. The user's starting Monster.
	 */
	private Monster startingMonster;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
//	/**
//	 * Attribute gameLength of type integer. The length of the game (how many days the game lasts.)
//	 */
//	private int gameLength;
//	
//	/**
//	 * Attribute difficulty of type String. The difficulty of the game.
//	 */
//	private String difficulty;
	
	/**
	 * Attribute username of type JTextField. The user's username.
	 */
	private JTextField username;
	
	/**
	 * Attribute imagesToUse of type ImageIcon[]. The images that are used in the slide show shown to the user. Attribute is passed to an instance of ImageCarousel.
	 */
	private ImageIcon imagesToUse[];
	
	/**
	 * Attribute stringDifficulty of type List<String>. The list of possible difficulties for the game, "Easy", "Medium", or "Hard".
	 */
	private List<String> stringDifficulty = Arrays.asList("Easy", "Medium", "Hard");
	

	/**
	 * Returns the instance of class Player representing the current player.
	 * @return type Player, the current player.
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Sets the private variable player equal to the player passed to it.
	 * @param player type Player, the current player.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	
	
	
	/**
	 * Constructor for the class SetupScreen. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible.
	 * @param gameManager type GameEnvironment. The class that manages what windows are open.
	 */
	public SetupScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		initialize();
		frmSetup.setVisible(true);
	}
	
	/**
	 * Closes the frame frmSetUp.
	 */
	public void closeWindow() {
		frmSetup.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeSetupScreen, passing the SetupScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeSetupScreen(this);
	}
	
	
	
	/**
	 * Initialize the contents of the frame. Creates an instance of the class ImageCarousel to create a slide show of images to display for the user.
	 */
	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setBackground(Color.WHITE);
		frmSetup.setTitle("SetUp");
		frmSetup.setBounds(100, 100, 850, 570);
		frmSetup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSetup.getContentPane().setLayout(null);
		
		
		imagesToUse = new ImageIcon[4]; 
		imagesToUse[0] = new ImageIcon(ImageCarousel.class.getResource("/images/skeleton.png"), "skeleton");
		imagesToUse[1] = new ImageIcon(ImageCarousel.class.getResource("/images/slime.png"), "slime");
		imagesToUse[2] = new ImageIcon(ImageCarousel.class.getResource("/images/zombie.png"), "zombie");
		imagesToUse[3] = new ImageIcon(ImageCarousel.class.getResource("/images/undead_guard.png"), "undeadGuard");
		
		
		ImageCarousel images = new ImageCarousel(imagesToUse);
		images.setSize(290, 195);
		images.setLocation(266, 195);
		frmSetup.getContentPane().add(images);
		
		JLabel lblUsername = new JLabel("Please choose a username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(297, 14, 218, 26);
		frmSetup.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(317, 50, 162, 21);
		frmSetup.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblHowManyDays = new JLabel("How many days do you want to play?");
		lblHowManyDays.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHowManyDays.setBounds(289, 81, 226, 15);
		frmSetup.getContentPane().add(lblHowManyDays);
		
		
		JSlider gameLengthSlider = new JSlider(JSlider.HORIZONTAL, 3, 15, 9);
		gameLengthSlider.setBounds(297, 106, 200, 43);
		gameLengthSlider.setMajorTickSpacing(3);
		gameLengthSlider.setMinorTickSpacing(1);
		gameLengthSlider.setPaintTicks(true);
		gameLengthSlider.setPaintLabels(true);
		frmSetup.getContentPane().add(gameLengthSlider);


		
		JLabel lblSelectMonster = new JLabel("Please select a monster:");
		lblSelectMonster.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectMonster.setBounds(315, 170, 200, 15);
		frmSetup.getContentPane().add(lblSelectMonster);
		
		JLabel lblChooseDifficulty = new JLabel("Choose difficulty:");
		lblChooseDifficulty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseDifficulty.setBounds(328, 400, 142, 19);
		frmSetup.getContentPane().add(lblChooseDifficulty);
		
		JSlider gameDifficultySlider = new JSlider(SwingConstants.HORIZONTAL, 1, 3, 2);
		gameDifficultySlider.setPaintTicks(true);
		
		Hashtable<Integer, JLabel> difficultyLabels = new Hashtable<>();
		difficultyLabels.put(1, new JLabel("Easy"));
		difficultyLabels.put(2, new JLabel("Medium"));
		difficultyLabels.put(3, new JLabel("Hard"));
        gameDifficultySlider.setLabelTable(difficultyLabels);
		
		gameDifficultySlider.setPaintLabels(true);
		gameDifficultySlider.setMinorTickSpacing(1);
		gameDifficultySlider.setMajorTickSpacing(1);
		gameDifficultySlider.setBounds(297, 429, 200, 43);
		frmSetup.getContentPane().add(gameDifficultySlider);

		

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			/**
			 * Gets the values given by the user, and sets them using setGameLength(), setGameDifficulty(), and setToday(). Creates an instance of the Player class, launches the MainScreen, and calls finishedWindow() for SetupScreen.
			 * @param arg0 the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent arg0) {
				gameEnvironment.setGameLength(gameLengthSlider.getValue());
				gameEnvironment.setGameDifficulty(stringDifficulty.get(gameDifficultySlider.getValue()));
				gameEnvironment.setToday(new Day(0));
				
				switch (images.getImg()) {
				  case "skeleton":
					startingMonster = new Skeleton();
				    break;
				  case "slime":
					startingMonster = new Slime();
				    break;
				  case "zombie":
					startingMonster = new Zombie();
				    break;
				  case "undeadGuard":
					startingMonster = new UndeadGuard();
				    break;
				}
				
				Player player = new Player(username.getText(), startingMonster);
				gameEnvironment.setPlayer(player);
				
				gameEnvironment.launchMainScreen();
				finishedWindow();
				
				
			}
		});
		btnNext.setBounds(637, 472, 117, 25);
		frmSetup.getContentPane().add(btnNext);
		 
	}
}













