package gui;

import java.util.Arrays;

import player.*;
import purchasable.monsters.*;

import javax.swing.JFrame;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import day.Day;
import gui.customElements.ImageCarousel;

import javax.swing.JOptionPane;


/**
 * The screen that prompts the user for their chosen username, game difficulty, game length and starting monster.
 * @author Celia Allen
 * @author Bede Nathan
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
	
	/**
	 * Attribute username of type JFormattedTextField. The user's username.
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
	 * Attribute type of type Object. The current instance of SetupScreen.
	 */
	private Object type = this;

	
	
	/**
	 * Constructor for the class SetupScreen. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible.
	 * @param gameManager type GameEnvironment. The game manager.
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
		
		ImageCarousel images = new ImageCarousel(imagesToUse, type);
		images.setSize(290, 195);
		images.setLocation(279, 218);
		frmSetup.getContentPane().add(images);
		
		JLabel lblUsername = new JLabel("Please choose a username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(309, 10, 230, 26);
		frmSetup.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		username.setBounds(334, 73, 180, 21);
		frmSetup.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblHowManyDays = new JLabel("How many days do you want to play?");
		lblHowManyDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblHowManyDays.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHowManyDays.setBounds(266, 115, 315, 15);
		frmSetup.getContentPane().add(lblHowManyDays);
		
		
		JSlider gameLengthSlider = new JSlider(JSlider.HORIZONTAL, 5, 15, 10);
		gameLengthSlider.setBounds(324, 140, 200, 43);
		gameLengthSlider.setMajorTickSpacing(2);
		gameLengthSlider.setMinorTickSpacing(1);
		gameLengthSlider.setPaintTicks(true);
		gameLengthSlider.setPaintLabels(true);
		frmSetup.getContentPane().add(gameLengthSlider);


		
		JLabel lblSelectMonster = new JLabel("Please select a monster:");
		lblSelectMonster.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectMonster.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSelectMonster.setBounds(320, 193, 207, 15);
		frmSetup.getContentPane().add(lblSelectMonster);
		
		JLabel lblChooseDifficulty = new JLabel("Choose difficulty:");
		lblChooseDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblChooseDifficulty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseDifficulty.setBounds(345, 423, 157, 19);
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
		gameDifficultySlider.setBounds(324, 452, 200, 43);
		frmSetup.getContentPane().add(gameDifficultySlider);

		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNext.addActionListener(new ActionListener() {
			/**
			 * Gets the values given by the user, and sets them using setGameLength(), setGameDifficulty(), and setToday(). Creates an instance of the Player class, launches the MainScreen, and calls finishedWindow() for SetupScreen.
			 * @param arg0 the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				switch (images.getImg()) {
				  case "skeleton":
					startingMonster = new Skeleton();
					startingMonster.setInitialID();
				    break;
				  case "slime":
					startingMonster = new Slime();
					startingMonster.setInitialID();
				    break;
				  case "zombie":
					startingMonster = new Zombie();
					startingMonster.setInitialID();
				    break;
				  case "undeadGuard":
					startingMonster = new UndeadGuard();
					startingMonster.setInitialID();
				    break;
				  case "dinosaur":
						startingMonster = new Dinosaur();
						startingMonster.setInitialID();
					    break;
				  case "snake":
						startingMonster = new Snake();
						startingMonster.setInitialID();
					    break;
				}
				
				gameEnvironment.setGameDifficulty(stringDifficulty.get(gameDifficultySlider.getValue()-1));
				Player player = new Player(username.getText(), startingMonster, gameEnvironment);
				gameEnvironment.setPlayer(player);
				gameEnvironment.setGameLength(gameLengthSlider.getValue());				
				gameEnvironment.setToday(new Day(gameEnvironment));
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		
		btnNext.setEnabled(false);
		btnNext.setBounds(654, 472, 117, 25);
		frmSetup.getContentPane().add(btnNext);
		
		JLabel lblNewLabel = new JLabel("(Username must be between 3 and 15 characters, and cannot contain numbers or special characters.)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(92, 31, 664, 43);
		frmSetup.getContentPane().add(lblNewLabel);
		
		username.getDocument().addDocumentListener(new DocumentListener() {
			/**
			 * Calls the method checker() if the JTextField username changes. Return type void.
			 * @param e, of type DocumentEvent.
			 */
			public void changedUpdate(DocumentEvent e) {
				checker();
			}
		  
			/**
			 * Calls the method checker() if the JTextField username changes. Return type void.
			 * @param e, of type DocumentEvent.
			 */
		    public void removeUpdate(DocumentEvent e) {
			    checker();
		    }
		  
			/**
			 * Calls the method checker() if the JTextField username changes. Return type void.
			 * @param e, of type DocumentEvent.
			 */
		    public void insertUpdate(DocumentEvent e) {
			    checker();	
		    }

		    /**
		     * Sets the JButton btnNext to enabled if it is not already. Return type void.
		     */
		    public void enableButton() {
		       if (btnNext.isEnabled() == false) {
		    	   btnNext.setEnabled(true);
		       }
		    }
		  
		    /**
		     * Sets the JButton btnNext to disabled if it is not already. Return type void.
		     */
		    public void disableButton() {
		       if (btnNext.isEnabled() == true) {
		    	   btnNext.setEnabled(false);
		       }
		    }
		  
		  
		    /**
		     * Checks if the username the player inputs contains special characters or numbers. If so, a pop-up is given to the user saying that special characters and number are not allowed, and the JButton btnNext is disabled.
		     * Also checks if the username the player inputs is less than 3 or more than 15 characters long. If so, the JButton btnNext is disabled.
		     */
		    public void checker() {
			    Pattern pattern = Pattern.compile("[^A-Za-z]");
			    Matcher match = pattern.matcher(username.getText());
			    boolean bool = match.find();
			  
			    if (bool) {
				    JOptionPane.showMessageDialog(frmSetup,
					  	    "Username cannot contain numbers or special characters.",
						    "Username Error",
						    JOptionPane.ERROR_MESSAGE);
				    disableButton();
			    } else {
				    if (username.getText().length() >= 3 && username.getText().length() <= 15) {
					    enableButton();
				    } else {
					    disableButton();
				    }
			    }	
		    }
		  
		  
		});
		frmSetup.getRootPane().setDefaultButton(btnNext);
	}

	
	
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
}













