package gui;
import java.awt.EventQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

import monsters.*;
import player.*;

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
import javax.swing.JList;
import javax.swing.JSpinner;


//testing
public class SetupScreen extends JFrame {

	private JFrame frmSetup;
	Monster startingMonster;
	private GameEnvironment gameEnvironment;
	private Player player;
	private int gameLength;
	private String difficulty;
	private JTextField username;
	private List<String> stringDifficulty = Arrays.asList("Easy", "Medium", "Hard");
	
//	
//	public int getgameLength() {
//		return gameLength;
//	}
//	
//	public void setGameLength(int game) {
//		gameLength = game;
//	}
//	
//	public String getGameDifficulty() {
//		return difficulty;
//	}
//	
//	public void setGameDifficulty(String gameDifficulty) {
//		difficulty = gameDifficulty;
//	}
	
	public Player getPlayer() {
		return player;
	}
	
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Create the application.
	 */
	public SetupScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		initialize();
		frmSetup.setVisible(true);
	}
	
	public void closeWindow() {
		frmSetup.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeSetupScreen(this);
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
		ImageCarousel images = new ImageCarousel();
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
			public void actionPerformed(ActionEvent arg0) {
				GameEnvironment.setGameLength(gameLengthSlider.getValue());
				GameEnvironment.setGameDifficulty(stringDifficulty.get(gameDifficultySlider.getValue()));
				
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
			}
		});
		btnNext.setBounds(637, 472, 117, 25);
		frmSetup.getContentPane().add(btnNext);
		
	}
}













