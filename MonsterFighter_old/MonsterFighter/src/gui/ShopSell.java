package gui;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import gui.customElements.ImgInventoryPanel;
import player.Inventory;
import player.Player;
import player.Team;
import purchasable.items.Item;
import purchasable.monsters.*;


/**
 * The screen that displays the items/monsters the player owns, and can sell.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class ShopSell {

	/**
	 * Attribute frmShopSell of type JFrame. The frame which is displayed to the user. Contains the UI for ShopSell.
	 */
	private JFrame frmShopSell;
	
	/**
	 * Attribute txtDescription of type JTextArea. The area where the Item/Monster's description is displayed to the user.
	 */
	private JTextArea txtDescription = new JTextArea("");
	
	/**
	 * Attribute selectedMonster of type String. The currently selected Monster.
	 */
	private Monster selectedMonster;
	
	/**
	 * Attribute selectedItem of type Item. The currently selected Item.
	 */
	private Item selectedItem;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute inventory of type Inventory. The player's inventory.
	 */
	private Inventory inventory;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	/**
	 * Attribute team of type Team. The player's current team.
	 */
	private Team team;
	
	/**
	 * Attribute type of type Object. The current instance of ShopBuy.
	 */
	private Object type = this;

	

	/**
	 * Constructor for the class ShopSell. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible. Sets the private variable player through the GameEnvironment class, and sets the private variables inventory and team.
	 * @param gameManager type GameEnvironment. The game manager.
	 */
	public ShopSell(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		setInventory(player.getInventory());
		setTeam(inventory.getTeam());
		initialize();
		frmShopSell.setVisible(true);
	}
	
	/**
	 * Closes the frame frmShopSell.
	 */
	public void closeWindow() {
		frmShopSell.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeShopSellScreen, passing the ShopSell object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeShopSellScreen(this);
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShopSell = new JFrame();
		frmShopSell.setBounds(100, 100, 850, 570);
		frmShopSell.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShopSell.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		scrollPane.setBounds(50, 88, 460, 343);
		frmShopSell.getContentPane().add(scrollPane);
		
		ImgInventoryPanel panel = new ImgInventoryPanel(scrollPane, team.getTeam(), type);
		scrollPane.setViewportView(panel);

		JLabel lblGoldAmount = new JLabel();
		lblGoldAmount.setText("Amount of gold: "+player.getGoldAmount());
		lblGoldAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGoldAmount.setBounds(10, 10, 219, 20);
		frmShopSell.getContentPane().add(lblGoldAmount);

		JButton btnShopBuy = new JButton("Buy");
		btnShopBuy.addActionListener(new ActionListener() {
			/**
			 * Launches the ShopBuy class, and calls finishedWindow() for ShopSell.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchShopBuyScreen();
				finishedWindow();
			}
		});
		btnShopBuy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShopBuy.setBounds(741, 10, 85, 25);
		frmShopSell.getContentPane().add(btnShopBuy);
		
		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.addActionListener(new ActionListener() {
			/**
			 * Launches the MainScreen, and calls finishedWindow() for ShopSell.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnReturnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReturnHome.setBounds(675, 41, 151, 25);
		frmShopSell.getContentPane().add(btnReturnHome);

		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setMargin(new Insets(0,7,0,7));
		txtDescription.setText("Nothing selected.");
		txtDescription.setLineWrap(true);
		txtDescription.setEditable(false);
		txtDescription.setBounds(524, 88, 302, 233);
		frmShopSell.getContentPane().add(txtDescription);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(52, 40, 327, 34);
		frmShopSell.getContentPane().add(buttonPanel);
		
		ButtonGroup buttons = new ButtonGroup();
		JToggleButton showMonsters = new JToggleButton("Show Monsters");
		showMonsters.setSelected(true);
		JToggleButton showItems = new JToggleButton("Show Items");
		buttons.add(showMonsters);
		buttons.add(showItems);
		buttonPanel.add(showMonsters);
		buttonPanel.add(showItems);
		
		showMonsters.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, team.getTeam(), type);
				  scrollPane.setViewportView(monsterPanel);
				  txtDescription.setText("Nothing selected.");
			  }
			} );
		
		showItems.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  ImgInventoryPanel itemPanel = new ImgInventoryPanel(scrollPane, inventory.getItems(), type);
				  scrollPane.setViewportView(itemPanel);
				  txtDescription.setText("Nothing selected.");
			  }
			} );	
		
		
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			/**
			 * Creates a pop-up window that asks the user if they are sure they want to sell the selected Item/Monster. Once the user confirms their choice, calls the method selectedMonster.sell(player) to give the player the gold, and remove the Monster from the player's inventory.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmShopSell, "Are you sure you want to sell this item/monster?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					if (selectedMonster != null && showMonsters.isSelected() == true) {
						selectedMonster.sell(player);
						ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, team.getTeam(), type);
						scrollPane.setViewportView(monsterPanel);
					}
					
					if (selectedItem != null && showItems.isSelected() == true) {
						selectedItem.sell(player);
						ImgInventoryPanel itemPanel = new ImgInventoryPanel(scrollPane, inventory.getItems(), type);
						scrollPane.setViewportView(itemPanel);
					}
					
					lblGoldAmount.setText("Amount of gold: "+player.getGoldAmount());
					txtDescription.setText("Nothing selected.");
					selectedItem = null;
					selectedMonster = null;
				}
			}
		});
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSell.setBounds(684, 330, 142, 25);
		frmShopSell.getContentPane().add(btnSell);
		
	}
	
	/**
	 * Returns the JTextArea that displays the description of the currently selected Monster/Item.
	 * @return txtDescription, of type JTextArea. 
	 */
	public JTextArea getTxtDescription() {
		return txtDescription;
	}
	
	/**
	 * Returns the currently selected Monster.
	 * @return selectedMonster, of type Monster.
	 */
	public Monster getSelectedMonster() {
		return selectedMonster;
	}
	
	/**
	 * Sets the attribute selectedMonster to the currently selected Monster. Return type void.
	 * @param selectedMonster, of type Monster.
	 */
	public void setSelectedMonster(Monster selectedMonster) {
		this.selectedMonster = selectedMonster;
	}
	
	/**
	 * Returns the currently selected Item.
	 * @return selectedItem, of type Item.
	 */
	public Item getSelectedItem() {
		return selectedItem;
	}
	
	/**
	 * Sets the attribute selectedItem to the currently selected Item. Return type void.
	 * @param selectedItem, of type Item.
	 */
	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	/**
	 * Returns the player's current team.
	 * @return team, of type Team.
	 */
	public Team getTeam() {
		return team;
	}
	
	/**
	 * Sets the private attribute team to the given parameter team. Return type void.
	 * @param team, of type Team. The player's current team.
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	
	/**
	 * Returns the player's current inventory.
	 * @return inventory, of type Inventory.
	 */
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * Sets the private attribute inventory to the given parameter inventory. Return type void.
	 * @param inventory, of type Inventory. The player's current inventory.
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	/**
	 * Sets the text of the JTextArea txtDescriptionMonster to the description of the currently selected Monster. Filter's the player's team for the Monster whose id matches the id given as a parameter.
	 * @param id, of type String. The currently selected Monster's unique id.
	 */
	public void setTxtrDescriptionMonster(String id) {
		List<Monster> listOfMonsters = getTeam().getTeam().stream().filter(s -> id.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		setSelectedMonster(listOfMonsters.get(0));
		String monsterString = getSelectedMonster().getSellBackDescription();
		getTxtDescription().setText(monsterString);
	}
	
	/**
	 * Sets the text of the JTextArea txtDescriptionItem to the description of the currently selected Item. Filter's the player's inventory for the Item whose id matches the id given as a parameter.
	 * @param id, of type String. The currently selected Item's unique id.
	 */
	public void setTxtrDescriptionItem(String id) {
		List<Item> listOfItems = getInventory().getItems().stream().filter(s -> id.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		setSelectedItem(listOfItems.get(0));
		String itemString = getSelectedItem().getSellBackDescription();
		getTxtDescription().setText(itemString);
	}
	
}
