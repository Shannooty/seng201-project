package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import gui.customElements.*;
import inventory.Inventory;
import player.Player;
import player.Team;
import shop.Shop;
import purchasable.Purchasable;
import purchasable.items.Item;
import purchasable.monsters.*;
import javax.swing.ListModel;




/**
 * 
 * @author 
 *
 */
public class ShopBuy {

	/**
	 * Attribute frmShopbuy of type JFrame. The frame which is displayed to the user. Contains the UI for ShopBuy.
	 */
	private JFrame frmShopbuy;
	
//	private ArrayList<String> monsters;
	
	/**
	 * Attribute txtDescription of type JTextArea. The area where the Item/Monster's description is displayed to the user.
	 */
	private static JTextArea txtDescription = new JTextArea("");
	
//	/**
//	 * Attribute gold of type double. The amount of gold the player currently has. 
//	 */
//	private double gold;
	
	/**
	 * Attribute selectedCost of type double. The cost of the currently selected Item/Monster.
	 */
	private static double selectedCost;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	private static Shop shop;
	
	/**
	 * Attribute inventory of type Inventory. The player's inventory.
	 */
	private Inventory inventory;

	
	private static Team team;

	
	/**
	 * Attribute selectedMonster of type String. The currently selected Monster.
	 */
	private static Monster selectedMonster;
	
	/**
	 * Attribute selectedItem of type Item. The currently selected Item.
	 */
	private static Item selectedItem;
	
	
	JButton btnShowMonsters, btnShowItems;

	

	/**
	 * Constructor for the class ShopBuy. Creates an instance of the class Shop, ShopBuy's parent. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible.
	 * @param gameManager type GameEnvironment. The class that manages what windows are open.
	 */
	public ShopBuy(GameEnvironment gameManager, Shop shop) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		inventory = player.getInventory();
		team = inventory.getTeam();
		this.shop = shop;
		initialize();
		frmShopbuy.setVisible(true);
	}
	
	/**
	 * Closes the frame frmShopbuy.
	 */
	public void closeWindow() {
		frmShopbuy.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeShopBuyScreen, passing the ShopBuy object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeShopBuyScreen(this);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmShopbuy = new JFrame();
		frmShopbuy.setTitle("ShopBuy");
		frmShopbuy.setBounds(100, 100, 850, 570);
		frmShopbuy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShopbuy.getContentPane().setLayout(null);
		ArrayList<Monster> monsterInfo = shop.getAvalibleMonsters();
		ArrayList<Item> itemInfo = shop.getAvalibleItems();
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 88, 411, 343);
		frmShopbuy.getContentPane().add(scrollPane);
		
		
		
		ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, monsterInfo, "ShopBuy");
		scrollPane.setViewportView(monsterPanel);
		
//		
//		scrollPane.setViewportView(itemPanel);
		
		JButton btnShowMonsters = new JButton("Show Monsters");
		btnShowMonsters.setEnabled( false );
//		btnShowMonsters.setVisible(false);
		btnShowMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, monsterInfo, "ShopBuy");
				scrollPane.setViewportView(monsterPanel);
				
				btnShowMonsters.setEnabled( false );
		        btnShowItems.setEnabled(true);
			}
		});
		btnShowMonsters.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShowMonsters.setBounds(171, 60, 170, 21);
		frmShopbuy.getContentPane().add(btnShowMonsters);
		
		JButton btnShowItems = new JButton("Show Items");
		btnShowItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImgInventoryPanel itemPanel = new ImgInventoryPanel(itemInfo, scrollPane, "ShopBuy");
				scrollPane.setViewportView(itemPanel);
				btnShowItems.setEnabled( false );
		        btnShowMonsters.setEnabled(true);
			}
		});
		btnShowItems.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnShowItems.setBounds(71, 60, 142, 21);
		frmShopbuy.getContentPane().add(btnShowItems);
		
		
		

		
		

		

		
		
		
		JLabel lblGoldAmount = new JLabel();
		lblGoldAmount.setText("Amount of gold: "+player.getGoldAmount());
		lblGoldAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGoldAmount.setBounds(10, 10, 219, 20);
		frmShopbuy.getContentPane().add(lblGoldAmount);
		
		
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setText("Description: Not Selected\r\n\r\n");
		txtDescription.setBounds(473, 88, 302, 233);
		frmShopbuy.getContentPane().add(txtDescription);
		

	
		JButton btnShopSell = new JButton("Sell");
		btnShopSell.addActionListener(new ActionListener() {
			/**
			 * Launches the ShopSell class, and calls finishedWindow() for ShopBuy.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchShopSellScreen();
				finishedWindow();
			}
		});
		btnShopSell.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShopSell.setBounds(741, 10, 85, 21);
		frmShopbuy.getContentPane().add(btnShopSell);
//		
//		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
//		txtDescription.setText("Description: Not Selected\r\n\r\n");
//		txtDescription.setBounds(457, 88, 302, 233);
//		frmShopbuy.getContentPane().add(txtDescription);
//		
//		
////		Shop shop = new Shop(2, 2);
////		Shop.setNumMonsters(2);
////		Shop.addMonsters();
////		shop.addMonsters();
////		shop.addMonsters();
//		ArrayList<Double> prices = new ArrayList<Double>();
//		DefaultListModel<String> shopStrings = new DefaultListModel<>();
//		DefaultListModel<String> shopInfo = new DefaultListModel<>();
//
//		ArrayList<Monster> monsterInfo = shop.getAvalibleMonsters();
//		ArrayList<Item> itemInfo = shop.getAvalibleItems();
//		
//		for(Monster val : monsterInfo) {
//			shopStrings.addElement(val.getDescription());
//			shopInfo.addElement(val.toString());
//			prices.add(val.getPurchasePrice());
//		}
//		shopStrings.addElement(null);
//		shopInfo.addElement(null);
//		prices.add(null);
//
//		for(Item val : itemInfo) {
//			shopStrings.addElement(val.getName());
//			shopInfo.addElement(val.toString());
//			prices.add(val.getPurchasePrice());
//		}
//		
//		
//
//		// Create the actual JList, notice that we put the astronautListModel in as an argument to new JList		
//		JList<String> availablePurchasables = new JList<>(shopStrings);
//		
//		
//		
//		availablePurchasables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		availablePurchasables.setBounds(49, 88, 341, 233);
//		frmShopbuy.getContentPane().add(availablePurchasables);
//		ListSelectionModel monsterSelectionModel = availablePurchasables.getSelectionModel();
//		monsterSelectionModel.addListSelectionListener(new SharedListSelectionHandler(shopInfo, "ShopBuy", prices));
////		System.out.println(shopInfo);
		
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Creates a pop-up window that asks the user if they are sure they want to buy the selected Item/Monster. Once the user confirms their choice, removes the gold using Player.removeGold(). Monster is added to the player's inventory.
				 * @param e the action that was performed, type ActionEvent.
				 */
				int choice = JOptionPane.showConfirmDialog(frmShopbuy, "Are you sure you want to buy this item/monster?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);			
				if (choice == JOptionPane.YES_OPTION) {
					if (selectedMonster != null) {
						selectedMonster.buy(player);
						shop.removeMonster(selectedMonster);
						ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, shop.getAvalibleMonsters(), "ShopBuy");
						scrollPane.setViewportView(monsterPanel);
						
					} else if (selectedItem != null) {
						selectedItem.buy(player);
						shop.removeItem(selectedItem);
						ImgInventoryPanel itemPanel = new ImgInventoryPanel(shop.getAvalibleItems(), scrollPane, "ShopBuy");
						scrollPane.setViewportView(itemPanel);
						
					}
					lblGoldAmount.setText("Amount of gold: "+player.getGoldAmount());
//					
					
					
					txtDescription.setText("Nothing selected.");
				}
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuy.setBounds(633, 331, 142, 21);
		frmShopbuy.getContentPane().add(btnBuy);
//		
		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.addActionListener(new ActionListener() {
			/**
			 * Launches the MainScreen, and calls finishedWindow() for ShopBuy.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnReturnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReturnHome.setBounds(684, 35, 142, 21);
		frmShopbuy.getContentPane().add(btnReturnHome);
		

		
	}
	
	/**
	 * Sets the text of the JTextArea txtDescription to the description of the currently selected Item/Monster.
	 * @param text, type String. The description of the currently selected Item/Monster.
	 */
	public static void setTxtrDescriptionMonster(String text) {
		List<Monster> listOfMonsters = shop.getAvalibleMonsters().stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedMonster = listOfMonsters.get(0);
		String monsterString = selectedMonster.toString();
		txtDescription.setText(monsterString);
	}
	
	public static void setTxtrDescriptionItem(String text) {
		List<Item> listOfItems = shop.getAvalibleItems().stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedItem = listOfItems.get(0);
		String itemString = selectedItem.toString();
		txtDescription.setText(itemString);
	}
	
	public void enableMonsters() {
		
	}
	
	public void enableItems() {
		
	}
}
