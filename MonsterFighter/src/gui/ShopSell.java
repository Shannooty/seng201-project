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
 * 
 * @author 
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
	private static JTextArea txtDescription = new JTextArea("");
	
//	/**
//	 * Attribute selectedPrice of type double. The price of the currently selected Item/Monster/
//	 */
//	private static double selectedPrice;
	
	/**
	 * Attribute selectedMonster of type String. The currently selected Monster.
	 */
	private static Monster selectedMonster;
	
	/**
	 * Attribute selectedItem of type Item. The currently selected Item.
	 */
	private static Item selectedItem;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute inventory of type Inventory. The player's inventory.
	 */
	private static Inventory inventory;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	private static Team team;

	

	/**
	 * Constructor for the class ShopSell. Creates an instance of the class Shop, ShopSell's parent. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible. Sets the private variable player through the GameEnvironment class, and sets the private variable via the variable player.
	 * @param gameManager type GameEnvironment. The class that manages what windows are open.
	 */
	public ShopSell(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		inventory = player.getInventory();
		team = inventory.getTeam();
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
		scrollPane.setBounds(52, 88, 411, 343);
		frmShopSell.getContentPane().add(scrollPane);
		
		ImgInventoryPanel panel = new ImgInventoryPanel(scrollPane, team.getTeam(), "ShopSell");
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
		btnReturnHome.setBounds(684, 41, 142, 25);
		frmShopSell.getContentPane().add(btnReturnHome);
		
		
		
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setMargin(new Insets(0,7,0,7));
		txtDescription.setText("Nothing selected.");
		txtDescription.setLineWrap(true);
		txtDescription.setEditable(false);
		txtDescription.setBounds(473, 88, 302, 233);
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
				  ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, team.getTeam(), "ShopSell");
				  scrollPane.setViewportView(monsterPanel);
				  txtDescription.setText("Nothing selected.");
			  }
			} );
		
		showItems.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  ImgInventoryPanel itemPanel = new ImgInventoryPanel(scrollPane, inventory.getItems(), "ShopSell");
				  scrollPane.setViewportView(itemPanel);
				  txtDescription.setText("Nothing selected.");
			  }
			} );	
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			/**
			 * Creates a pop-up window that asks the user if they are sure they want to sell the selected Item/Monster. Once the user confirms their choice, adds the gold using Player.addGold(). Monster is removed from the player's inventory.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmShopSell, "Are you sure you want to sell this item/monster?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					if (selectedMonster != null && showMonsters.isSelected() == true) {
						selectedMonster.sell(player);
						ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, team.getTeam(), "ShopSell");
						scrollPane.setViewportView(monsterPanel);
					}
					
					if (selectedItem != null && showItems.isSelected() == true) {
						selectedItem.sell(player);
						ImgInventoryPanel itemPanel = new ImgInventoryPanel(scrollPane, inventory.getItems(), "ShopSell");
						scrollPane.setViewportView(itemPanel);
					}
					
					
					lblGoldAmount.setText("Amount of gold: "+player.getGoldAmount());
					txtDescription.setText("Nothing selected.");
				}
			}
		});
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSell.setBounds(617, 331, 142, 25);
		frmShopSell.getContentPane().add(btnSell);
		
	}
	
	/**
	 * Sets the text of the JTextArea txtDescription to the description of the currently selected Item/Monster.
	 * @param text, type String. The description of the currently selected Item/Monster.
	 */	
	public static void setTxtrDescriptionMonster(String text) {
		List<Monster> listOfMonsters = team.getTeam().stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedMonster = listOfMonsters.get(0);
		String monsterString = selectedMonster.getSellBackDescription();
		txtDescription.setText(monsterString);
	}
	
	
	public static void setTxtrDescriptionItem(String text) {
		List<Item> listOfItems = inventory.getItems().stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedItem = listOfItems.get(0);
		String itemString = selectedItem.getSellBackDescription();
		txtDescription.setText(itemString);
	}
	
	
	
//	/**
//	 * Sets the private variable selectedPrice to the value of cost.
//	 * @param cost, of type double. The cost of the currently selected Item/Monster.
//	 */
//	public static void setSelectedPrice(double cost) {
//		selectedPrice = cost;
//	}
//	
//	
//	/**
//	 * Sets the private variable selectedMonster to the value of the Monster at index monster in team.
//	 * @param monster, of type integer. The index of the currently selected monster.
//	 */
//	public static void setSelectedMonster(int monster) {
//		selectedMonster = team.getTeam().get(monster);
////		System.out.println("selectedMonster: " + selectedMonster.getDescription() + selectedMonster.getClass());
//	}
//	
//	
//	/**
//	 * Sets the private variable selectedItem to the value of item.
//	 * @param item, of type Item. The currently selected item.
//	 */
//	public static void setSelectedItem(Item item) {
//		selectedItem = item;
//	}
}
