package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

import exceptions.InsufficientGoldException;
import exceptions.TeamFullException;
import gui.customElements.*;
import player.Inventory;
import player.Player;
import player.Team;
import shop.Shop;
import purchasable.items.Item;
import purchasable.monsters.*;
import javax.swing.JPanel;




/**
 * The screen that displays the items/monsters the player can buy.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class ShopBuy {

	/**
	 * Attribute frmShopbuy of type JFrame. The frame which is displayed to the user. Contains the UI for ShopBuy.
	 */
	private JFrame frmShopbuy;
		
	/**
	 * Attribute txtDescription of type JTextArea. The area where the Item/Monster's description is displayed to the user.
	 */
	private JTextArea txtDescription = new JTextArea("");

	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute player of type Player. The current player.
	 */
	private Player player;
	
	/**
	 * Attribute shop of type Shop. The current shop.
	 */
	private Shop shop;
	
	/**
	 * Attribute selectedMonster of type String. The currently selected Monster.
	 */
	private Monster selectedMonster;
	
	/**
	 * Attribute selectedItem of type Item. The currently selected Item.
	 */
	private Item selectedItem;
	
	/**
	 * Attribute type of type Object. The current instance of ShopBuy.
	 */
	private Object type = this;
	

	/**
	 * Constructor for the class ShopBuy. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible.
	 * @param gameManager type GameEnvironment. The game manager.
	 * @param shop, of type Shop. The current instance of Shop.
	 */
	public ShopBuy(GameEnvironment gameManager, Shop shop) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		setShop(shop);
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
		scrollPane.getVerticalScrollBar().setUnitIncrement(15);
		scrollPane.setBounds(52, 88, 411, 343);
		frmShopbuy.getContentPane().add(scrollPane);

		ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, monsterInfo, type);
		scrollPane.setViewportView(monsterPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(52, 40, 327, 34);
		frmShopbuy.getContentPane().add(buttonPanel);
		
		
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
				  ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, monsterInfo, type);
				  scrollPane.setViewportView(monsterPanel);
				  txtDescription.setText("Nothing selected.");
			  }
			} );
		
		showItems.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  ImgInventoryPanel itemPanel = new ImgInventoryPanel(scrollPane, itemInfo, type);
				  scrollPane.setViewportView(itemPanel);
				  txtDescription.setText("Nothing selected.");
			  }
			} );
		

		JLabel lblGoldAmount = new JLabel();
		lblGoldAmount.setText("Amount of gold: "+player.getGoldAmount());
		lblGoldAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGoldAmount.setBounds(10, 10, 219, 20);
		frmShopbuy.getContentPane().add(lblGoldAmount);
		
		
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setMargin(new Insets(0,7,0,7));
		txtDescription.setText("Nothing selected.");
		txtDescription.setLineWrap(true);
		txtDescription.setEditable(false);
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
		btnShopSell.setBounds(741, 10, 85, 25);
		frmShopbuy.getContentPane().add(btnShopSell);

		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Creates a pop-up window that asks the user if they are sure they want to buy the selected Item/Monster. Once the user confirms their choice, calls the method shop.purchase(selectedMonster, player) to take the player's gold, and add the Monster from the player's inventory if no exceptions are thrown.
				 * @param e the action that was performed, type ActionEvent.
				 */
				int choice = JOptionPane.showConfirmDialog(frmShopbuy, "Are you sure you want to buy this item/monster?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);			
				if (choice == JOptionPane.YES_OPTION) {

					if (selectedMonster != null && showMonsters.isSelected() == true) {
						try {
							shop.purchase(selectedMonster, player);

						} catch (InsufficientGoldException ex) {
							gameEnvironment.getShopBuyScreen().exceptionPopUp(ex.getMessage());
						} catch (TeamFullException ex) {
							gameEnvironment.getShopBuyScreen().exceptionPopUp(ex.getMessage());
						}
						
						ImgInventoryPanel monsterPanel = new ImgInventoryPanel(scrollPane, shop.getAvalibleMonsters(), type);
						scrollPane.setViewportView(monsterPanel);
					} 
					
					if (selectedItem != null && showItems.isSelected() == true) {
						try {
							shop.purchase(selectedItem, player);
						} catch (InsufficientGoldException ex) {
							gameEnvironment.getShopBuyScreen().exceptionPopUp(ex.getMessage());
						}
						
						ImgInventoryPanel itemPanel = new ImgInventoryPanel(scrollPane, shop.getAvalibleItems(), type);
						scrollPane.setViewportView(itemPanel);
					}
					
					lblGoldAmount.setText("Amount of gold: "+player.getGoldAmount());				
					txtDescription.setText("Nothing selected.");
					
				}
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuy.setBounds(633, 331, 142, 25);
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
		btnReturnHome.setBounds(684, 35, 142, 25);
		frmShopbuy.getContentPane().add(btnReturnHome);

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
	 * Returns the current instance of the class Shop.
	 * @return shop, of type Shop.
	 */
	public Shop getShop() {
		return shop;
	}
	
	/**
	 * Sets the private attribute shop to the given parameter shop. Return type void.
	 * @param shop, of type Shop. The current instance of Shop.
	 */
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	
	
	/**
	 * Sets the text of the JTextArea txtDescriptionMonster to the description of the currently selected Monster. Filter's the player's team for the Monster whose id matches the id given as a parameter.
	 * @param id, of type String. The currently selected Monster's unique id.
	 */
	public void setTxtrDescriptionMonster(String id) {
		List<Monster> listOfMonsters = getShop().getAvalibleMonsters().stream().filter(s -> id.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		setSelectedMonster(listOfMonsters.get(0));
		String monsterString = getSelectedMonster().getBuyDescription();
		getTxtDescription().setText(monsterString);
	}
	
	/**
	 * Sets the text of the JTextArea txtDescriptionItem to the description of the currently selected Item. Filter's the player's inventory for the Item whose id matches the id given as a parameter.
	 * @param id, of type String. The currently selected Item's unique id.
	 */
	public void setTxtrDescriptionItem(String id) {
		List<Item> listOfItems = getShop().getAvalibleItems().stream().filter(s -> id.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		setSelectedItem(listOfItems.get(0));
		String itemString = getSelectedItem().getBuyDescription();
		getTxtDescription().setText(itemString);
	}
	
	/**
	 * Sends a pop-up to the user, with the text of the parameter message.
	 * @param message, of type String. The exception that the player caused.
	 */
	public void exceptionPopUp(String message) {
		JOptionPane.showMessageDialog(frmShopbuy, message);
	}
	
}
