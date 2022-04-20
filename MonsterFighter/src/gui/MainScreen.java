package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;

import player.*;
import purchasable.items.Item;
import purchasable.monsters.*;

import javax.swing.JEditorPane;


/**
 * 
 * @author 
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
	private static ArrayList<Monster> team;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	private JButton btnChangeMonsterName = new JButton("Change Monster Name");

	
	private static JTextArea textAreaMonsterDescription = new JTextArea("");

	private static Monster selectedMonster;

	
//	private JLabel lblMonsterTotal;

	
	/**
	 * Constructor for the class MainScreen. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible. Sets the private variable player to the player, accessed through the GameEnvironment class. Sets the private variable team to the player's team, accessed via the private player variable, then the Inventory class.
	 * @param gameManager type GameEnvironment. The class that manages what windows are open.
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
		
		
//		For initial testing:
//		------------------------------------------------------------
//		Zombie startingMonster = new Zombie();
//		Slime mobster = new Slime();
//		Inventory.addMonster(startingMonster);
//		Inventory.addMonster(mobster);
//		------------------------------------------------------------
		
		imagesToUse = new ImageIcon[team.size()]; 
		
		for (int i = 0; i < team.size(); i++) {
			
			switch ((team.get(i)).getMonsterType()) {
			  case "skeleton":
				imagesToUse[i] = new ImageIcon(ImageCarousel.class.getResource("/images/skeleton.png"), Integer.toString((team.get(i)).getID()));
			    break;
			  case "slime":
				imagesToUse[i] = new ImageIcon(ImageCarousel.class.getResource("/images/slime.png"), Integer.toString((team.get(i)).getID()));
			    break;
			  case "zombie":
				imagesToUse[i] = new ImageIcon(ImageCarousel.class.getResource("/images/zombie.png"), Integer.toString((team.get(i)).getID()));
			    break;
			  case "undeadGuard":
				imagesToUse[i] = new ImageIcon(ImageCarousel.class.getResource("/images/undead_guard.png"), Integer.toString((team.get(i)).getID()));
			    break;
			}
			
		}
		
		ImageCarousel images = new ImageCarousel(imagesToUse);
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
				gameEnvironment.launchChooseBattleScreen();
				finishedWindow();
			}
		});
		btnBattleSelect.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBattleSelect.setBounds(664, 10, 162, 26);
		frmMainscreen.getContentPane().add(btnBattleSelect);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchInventoryScreen();
				finishedWindow();
			}
		});
		btnInventory.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInventory.setBounds(674, 37, 152, 26);
		frmMainscreen.getContentPane().add(btnInventory);
		
		JButton btnShop = new JButton("Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchShopBuyScreen();
				finishedWindow();
			}
		});
		btnShop.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShop.setBounds(741, 65, 85, 26);
		frmMainscreen.getContentPane().add(btnShop);
		
//		JTextPane textPaneMonsterDescription = new JTextPane();
		textAreaMonsterDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
//		textAreaMonsterDescription.setText("Monster Description:\r\n\r\n\r\nName:\r\n\r\nHealth:\r\n\r\nDamage:\r\n\r\nItem(s):");
		if (team.size() > 0) {
			setTxtrDescription(Integer.toString(team.get(0).getID()));
			btnChangeMonsterName.setVisible(true);
		} else {
			textAreaMonsterDescription.setText("Nothing to display.");
			btnChangeMonsterName.setVisible(false);
		}
		
		textAreaMonsterDescription.setBounds(480, 148, 281, 271);
		frmMainscreen.getContentPane().add(textAreaMonsterDescription);
		
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
		btnSleep.setBounds(741, 483, 85, 26);
		frmMainscreen.getContentPane().add(btnSleep);
		
		
		JLabel lblWelcomeUser = new JLabel();
		lblWelcomeUser.setText("Welcome, " + player.getName());
		lblWelcomeUser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeUser.setBounds(10, 10, 180, 20);
		frmMainscreen.getContentPane().add(lblWelcomeUser);
		
		
		
//		JButton btnChangeMonsterName = new JButton("Change Monster Name");
		btnChangeMonsterName.addActionListener(new ActionListener() {
			/**
			 * Creates a pop-up window that prompts the user for a new name for the monster selected. Once the user confirms their choice, calls the setName() method on the Monster selected.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				String newMonsterName = JOptionPane.showInputDialog(frmMainscreen,"Enter a new name:", null);
				selectedMonster.setName(newMonsterName);
				setTxtrDescription(Integer.toString(selectedMonster.getID()));
				
			}
		});
		btnChangeMonsterName.setBounds(100, 390, 222, 29);
		frmMainscreen.getContentPane().add(btnChangeMonsterName);
		
	}
	
	public static void setTxtrDescription(String text) {
		List<Monster> streamedTeam = team.stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedMonster = streamedTeam.get(0);
		String itemString = selectedMonster.toString();
		textAreaMonsterDescription.setText(itemString);
	}

}
