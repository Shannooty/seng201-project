package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import gui.customElements.ImgInventoryPanel;
import player.Inventory;
import player.Player;
import player.Team;
import purchasable.items.Item;
import purchasable.monsters.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class InventoryScreen {

	private JFrame frmInventoryscreen;

	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	private Player player;
	
	private static Inventory inventory;
	
	private static ArrayList<Monster> team;
	
	/**
	 * Attribute selectedMonster of type String. The currently selected Monster.
	 */
	private static Monster selectedMonster;
	
	/**
	 * Attribute selectedItem of type Item. The currently selected Item.
	 */
	private static Item selectedItem;
	
	/**
	 * Attribute txtDescription of type JTextArea. The area where the Item/Monster's description is displayed to the user.
	 */
	private static JTextArea txtDescriptionMonsters = new JTextArea("Nothing currently selected.");
	
	/**
	 * Attribute txtDescription of type JTextArea. The area where the Item/Monster's description is displayed to the user.
	 */
	private static JTextArea txtDescriptionItems = new JTextArea("Nothing currently selected.");
	


	/**
	 * Create the application.
	 */
	public InventoryScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		inventory = player.getInventory();
//		team = player.getInventory().getTeam();
		team = inventory.getTeam().getTeam();
		initialize();
		frmInventoryscreen.setVisible(true);
	}
	
	
	/**
	 * Closes the frame frmInventoryscreen.
	 */
	public void closeWindow() {
		frmInventoryscreen.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeInventoryScreen, passing the InventoryScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeInventoryScreen(this);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInventoryscreen = new JFrame();
		frmInventoryscreen.setTitle("InventoryScreen");
		frmInventoryscreen.setBounds(100, 100, 850, 570);
		frmInventoryscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventoryscreen.getContentPane().setLayout(null);
		
		JScrollPane monsterScrollPane = new JScrollPane();
		monsterScrollPane.setBounds(52, 69, 411, 207);
		frmInventoryscreen.getContentPane().add(monsterScrollPane);
		
		JScrollPane itemScrollPane = new JScrollPane();
		itemScrollPane.setBounds(54, 318, 409, 205);
		frmInventoryscreen.getContentPane().add(itemScrollPane);
		
		ImgInventoryPanel monsterPanel = new ImgInventoryPanel(monsterScrollPane, team, "Inventory");
		monsterScrollPane.setViewportView(monsterPanel);
		
		ImgInventoryPanel itemPanel = new ImgInventoryPanel(inventory.getItems(), itemScrollPane, "Inventory");
		itemScrollPane.setViewportView(itemPanel);
		
		txtDescriptionItems.setBounds(544, 318, 241, 207);
		frmInventoryscreen.getContentPane().add(txtDescriptionItems);
		
		txtDescriptionMonsters.setBounds(544, 69, 241, 207);
		frmInventoryscreen.getContentPane().add(txtDescriptionMonsters);
		
		JButton btnHome = new JButton("Return Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHome.setBounds(663, 10, 163, 27);
		frmInventoryscreen.getContentPane().add(btnHome);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Welcome to the inventory, " + player.getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(52, 10, 291, 19);
		frmInventoryscreen.getContentPane().add(lblNewLabel);
	}
	
	public static void setTxtrDescriptionMonster(String text) {
		List<Monster> listOfMonsters = team.stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		
		
		selectedMonster = listOfMonsters.get(0);
		String monsterString = selectedMonster.toString();
		txtDescriptionMonsters.setText(monsterString);
	}
	
	
	public static void setTxtrDescriptionItem(String text) {
		List<Item> listOfItems = inventory.getItems().stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedItem = listOfItems.get(0);
		String itemString = selectedItem.toString();
		txtDescriptionItems.setText(itemString);
	}
}
