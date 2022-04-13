package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import inventory.Inventory;
import player.Player;
import purchasable.items.Item;
import purchasable.monsters.*;
import shop.Shop;


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
	
	/**
	 * Attribute selectedPrice of type double. The price of the currently selected Item/Monster/
	 */
	private static double selectedPrice;
	
	/**
	 * Attribute selectedMonster of type String. The currently selected Monster.
	 */
	private static String selectedMonster;
	
	/**
	 * Attribute selectedItem of type Item. The currently selected Item.
	 */
	private static Item selectedItem;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;

	

	/**
	 * Constructor for the class ShopSell. Creates an instance of the class Shop, ShopSell's parent. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible.
	 * @param gameManager type GameEnvironment. The class that manages what windows are open.
	 */
	public ShopSell(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
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
		
		
		JLabel lblGoldAmount = new JLabel();
		lblGoldAmount.setText("Amount of gold: "+Player.getGoldAmount());
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
		btnShopBuy.setBounds(741, 10, 85, 21);
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
		btnReturnHome.setBounds(684, 41, 142, 20);
		frmShopSell.getContentPane().add(btnReturnHome);
		
		
		
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setText("Description: Not Selected\r\n\r\n");
		txtDescription.setBounds(457, 88, 302, 233);
		frmShopSell.getContentPane().add(txtDescription);
		
		
		
		DefaultListModel<String> shopStrings = new DefaultListModel<>();
		DefaultListModel<String> shopInfo = new DefaultListModel<>();

		ArrayList<Monster> monsterInfo = Inventory.getTeam();
		ArrayList<Item> itemInfo = Inventory.getItems();
		
		for(Monster val : monsterInfo) {
			shopStrings.addElement(val.getDescription());
			shopInfo.addElement(val.toString());
		}
		shopStrings.addElement(null);
		shopInfo.addElement(null);

		for(Item val : itemInfo) {
			shopStrings.addElement(val.getItemName());
			shopInfo.addElement(val.toString());
		}
		
		System.out.println("shopStrings " + shopStrings);
		System.out.println("shopInfo " + shopInfo);
		
		// Create the actual JList, notice that we put the astronautListModel in as an argument to new JList		
		JList<String> availablePurchasables = new JList<>(shopStrings);
		availablePurchasables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		availablePurchasables.setBounds(49, 88, 341, 233);
		frmShopSell.getContentPane().add(availablePurchasables);
		ListSelectionModel monsterSelectionModel = availablePurchasables.getSelectionModel();
		monsterSelectionModel.addListSelectionListener(new SharedListSelectionHandler(shopInfo, "ShopSell"));
		
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			/**
			 * Creates a pop-up window that asks the user if they are sure they want to sell the selected Item/Monster. Once the user confirms their choice, adds the gold using Player.addGold(). Monster is removed from the player's inventory.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmShopSell, "Are you sure you want to sell this item/monster?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					Player.addGold(selectedPrice);
					lblGoldAmount.setText("Amount of gold: "+Player.getGoldAmount());
//					STILL NEED TO REMOVE MONSTER/ITEM FROM INVENTORY
				}
			}
		});
		btnSell.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSell.setBounds(617, 331, 142, 21);
		frmShopSell.getContentPane().add(btnSell);
		
		
	}
	
	
	/**
	 * Sets the text of the JTextArea txtDescription to the description of the currently selected Item/Monster.
	 * @param text, type String. The description of the currently selected Item/Monster.
	 */
	public static void setTxtrDescription(String text) {
		txtDescription.setText(text);
	}
	
	
	/**
	 * Sets the private variable selectedPrice to the value of cost.
	 * @param cost, of type double. The cost of the currently selected Item/Monster.
	 */
	public static void setSelectedPrice(double cost) {
		selectedPrice = cost;
	}
	
	
	/**
	 * Sets the private variable selectedMonster to the value of monster.
	 * @param monster, of type String. The currently selected monster.
	 */
	public static void setSelectedMonster(String monster) {
		selectedMonster = monster;
//		List<Monster> listOfMonsters = team.stream().filter(s -> oldMonster.equals(s.getName())).collect(Collectors.toList());
//		System.out.println("monster: "+monster);
	}
	
	
	/**
	 * Sets the private variable selectedItem to the value of item.
	 * @param item, of type Item. The currently selected item.
	 */
	public static void setSelectedItem(Item item) {
		selectedItem = item;
	}
}
