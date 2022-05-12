package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import player.*;
import purchasable.items.Item;
import purchasable.monsters.*;
import shop.Shop;

import javax.swing.JEditorPane;


/**
 * The main screen of the game.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class MainScreen {

	/**
	 * Attribute frmMainscreen of type JFrame. The frame which is displayed to the user. Contains the UI for the MainScreen.
	 */
	private JFrame frmMainscreen;
	
	/**
	 * Attribute imagesToUse of type ImageIcon[]. The images that are used in the slide show shown to the user. Attribute is passed to an instance of ImageCarousel.
	 */
	private ImageIcon imagesToUse[];
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute team of type ArrayList<Monster>. The user's current team of Monsters.
	 */
	private ArrayList<Monster> team;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	/**
	 * Attribute btnChangeMonsterName of type JButton. A button that triggers a pop-up allowing the user to change a Monster's name.
	 */
	private JButton btnChangeMonsterName = new JButton("Change Monster Name");

	/**
	 * Attribute textAreaMonsterDescription of type JTextArea. A JTextArea that displays the description of the currently displayed Monster.
	 */
	private JTextArea textAreaMonsterDescription = new JTextArea("");

	/**
	 * Attribute selectedMonster of type Monster. The currently displayed Monster.
	 */
	private Monster selectedMonster;

	/**
	 * Attribute type, of type Object. The current instance of MainScreen.
	 */
	private Object type = this;
	

	
	/**
	 * Constructor for the class MainScreen. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible. Sets the private variable player to the player, accessed through the GameEnvironment class. Sets the private variable team to the player's team, accessed via the private player variable, then the Inventory class.
	 * @param gameManager type GameEnvironment. The game manager.
	 */
	public MainScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		team = player.getInventory().getTeam().getTeam();
		initialize();
		frmMainscreen.setVisible(true);
	}
	
	
	/**
	 * Closes the frame frmMainScreen.
	 */
	public void closeWindow() {
		frmMainscreen.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeMainScreen, passing the MainScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeMainScreen(this);
	}


	/**
	 * Initialize the contents of the frame. Creates an instance of the class ImageCarousel to create a slide show of images for the user.
	 */
	private void initialize() {
		frmMainscreen = new JFrame();
		frmMainscreen.setTitle("MainScreen");
		frmMainscreen.setBounds(100, 100, 850, 570);
		frmMainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainscreen.getContentPane().setLayout(null);
		
		if (team.size() == 0 && player.getGoldAmount() < 60) {
			JOptionPane.showMessageDialog(frmMainscreen, "You have no monsters, and insufficient funds to purchase any more. Game Over.");
			gameEnvironment.launchEndScreen();
			finishedWindow();
		}
		
		imagesToUse = new ImageIcon[team.size()]; 
		
		
		for (int i = 0; i < team.size(); i++) {
			
			String type;
			if ((team.get(i)).getMonsterType() == "undeadGuard") {
				type = "/images/undead_guard.png";	
			} else {
				type = "/images/"+(team.get(i)).getMonsterType()+".png";			
			}
			imagesToUse[i] = new ImageIcon(ImageCarousel.class.getResource(type), Integer.toString((team.get(i)).getID()));			
		}
		
		ImageCarousel images = new ImageCarousel(imagesToUse, type);
		images.setSize(290, 195);
		images.setLocation(72, 166);
		frmMainscreen.getContentPane().add(images);

		
		JLabel lblGoldAmount = new JLabel("Amount of gold:");
		lblGoldAmount.setText("Amount of gold: " + Double.toString(player.getGoldAmount()));
		lblGoldAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGoldAmount.setBounds(10, 38, 203, 20);
		frmMainscreen.getContentPane().add(lblGoldAmount);
		
		
		JLabel lblDayNumber = new JLabel();
		lblDayNumber.setText("Day Number: " + Integer.toString(gameEnvironment.getDayNumber()));
		lblDayNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDayNumber.setBounds(10, 68, 152, 20);
		frmMainscreen.getContentPane().add(lblDayNumber);
		
		JButton btnBattleSelect = new JButton("Select Battle");
		btnBattleSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nonStunnedMonsters = 0;
				
				for (Monster monster : team) {
					if (monster.getHealth() > 0) {
						nonStunnedMonsters += 1;
					}
				}
				
				if (nonStunnedMonsters > 0) {
					gameEnvironment.launchChooseBattleScreen();
					finishedWindow();
				} else {
					JOptionPane.showMessageDialog(frmMainscreen, "You have no non-stunned monsters. Please heal at least one before you battle.");
				}
			}
		});
		btnBattleSelect.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBattleSelect.setBounds(664, 10, 162, 25);
		frmMainscreen.getContentPane().add(btnBattleSelect);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchInventoryScreen();
				finishedWindow();
			}
		});
		btnInventory.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInventory.setBounds(674, 37, 152, 25);
		frmMainscreen.getContentPane().add(btnInventory);
		
		JButton btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchShopBuyScreen();
				finishedWindow();
			}
		});
		btnShop.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShop.setBounds(741, 65, 85, 25);
		frmMainscreen.getContentPane().add(btnShop);
		
		textAreaMonsterDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaMonsterDescription.setMargin(new Insets(0,7,0,7));
		if (team.size() > 0) {
			setTxtrDescription(Integer.toString(team.get(0).getID()));
			btnChangeMonsterName.setVisible(true);
		} else {
			textAreaMonsterDescription.setText("Nothing to display.");
			btnChangeMonsterName.setVisible(false);
		}
		
		textAreaMonsterDescription.setBounds(480, 148, 281, 271);
		textAreaMonsterDescription.setLineWrap(true);
		textAreaMonsterDescription.setEditable(false);
		
        JScrollPane scrollableTextArea = new JScrollPane(textAreaMonsterDescription);  
        scrollableTextArea.setBounds(480, 148, 281, 271);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        frmMainscreen.getContentPane().add(scrollableTextArea); 
		
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			/**
			 * Increases the day number, launches the SleepScreen, and calls finishedWindow on MainScreen.
			 * @param e the action that was performed, type ActionEvent
			 */
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.increaseDayNumber();
				gameEnvironment.sleep();
				finishedWindow();
			}
		});
		btnSleep.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSleep.setBounds(741, 483, 85, 25);
		frmMainscreen.getContentPane().add(btnSleep);
		
		
		JLabel lblWelcomeUser = new JLabel();
		lblWelcomeUser.setText("Welcome, " + player.getName());
		lblWelcomeUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeUser.setBounds(10, 10, 180, 20);
		frmMainscreen.getContentPane().add(lblWelcomeUser);
		
		btnChangeMonsterName.addActionListener(new ActionListener() {
			/**
			 * Creates a pop-up window that prompts the user for a new name for the monster selected. Once the user confirms their choice, calls the setName() method on the Monster selected.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				String newMonsterName = JOptionPane.showInputDialog(frmMainscreen,"Enter a new name:", null);
				if (newMonsterName != null) {
					selectedMonster.setName(newMonsterName);
					setTxtrDescription(Integer.toString(selectedMonster.getID()));
				}
			}
		});
		btnChangeMonsterName.setBounds(100, 390, 222, 29);
		frmMainscreen.getContentPane().add(btnChangeMonsterName);
		
	}
	
	/**
	 * Returns the JTextArea that displays the description of the currently selected Monster.
	 * @return textAreaMonsterDescription, of type JTextArea.
	 */
	public JTextArea getTextAreaMonsterDescription() {
		return textAreaMonsterDescription;
	}
	
	/**
	 * Returns the currently selected Monster.
	 * @return selectedMonster, of type Monster.
	 */
	public Monster getSelectedMonster() {
		return selectedMonster;
	}
	
	/**
	 * Sets the private attribute selectedMonster to the Monster that is currently selected. Return type void.
	 * @param selectedMonster, of type Monster. The currently selected Monster.
	 */
	public void setSelectedMonster(Monster selectedMonster) {
		this.selectedMonster = selectedMonster;
	}
	
	/**
	 * Returns the player's current team.
	 * @return team, of type ArrayList[Monster]
	 */
	public ArrayList<Monster> getTeam() {
		return team;
	}
	
	/**
	 * Sets the private attribute team to the given ArrayList, the player's team.
	 * @param team, of type ArrayList[Monster]
	 */
	public void setTeam(ArrayList<Monster> team) {
		this.team = team;
	}
	
	/**
	 * Sets the text of the JTextArea txtDescription to the description of the currently selected Monster. Filter's the player's team for the Monster whose id matches the id given as a parameter.
	 * @param id, of type String. The currently selected Monsters's unique id.
	 */
	public void setTxtrDescription(String id) {
		List<Monster> streamedTeam = getTeam().stream().filter(s -> id.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		setSelectedMonster(streamedTeam.get(0));
		String itemString = getSelectedMonster().getSellBackDescription();
		getTextAreaMonsterDescription().setText(itemString);
		getTextAreaMonsterDescription().setCaretPosition(0);
	}

}
