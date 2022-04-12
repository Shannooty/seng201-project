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

import player.Player;
import shop.Shop;
import purchasable.items.Item;
import purchasable.monsters.*;
import javax.swing.ListModel;





public class ShopBuy extends Shop {

	private JFrame frmShopbuy;
//	private ArrayList<String> monsters;
	private static JTextArea txtDescription = new JTextArea("");
	private double gold = Player.getGoldAmount();
	private static double selectedCost;
	private GameEnvironment gameEnvironment;

	
	

	/**
	 * Launch the application.
	 */
	public ShopBuy(GameEnvironment gameManager) {
		super(3,5);
		gameEnvironment = gameManager;
		initialize();
		frmShopbuy.setVisible(true);
	}
	
	public void closeWindow() {
		frmShopbuy.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeShopBuyScreen(this);
	}
	/**
	 * Create the application.
	 */


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShopbuy = new JFrame();
		frmShopbuy.setTitle("ShopBuy");
		frmShopbuy.setBounds(100, 100, 850, 570);
		frmShopbuy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShopbuy.getContentPane().setLayout(null);
		
		JLabel lblGoldAmount = new JLabel();
		lblGoldAmount.setText("Amount of gold: "+gold);
		lblGoldAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGoldAmount.setBounds(10, 10, 219, 20);
		frmShopbuy.getContentPane().add(lblGoldAmount);
		
		JButton btnShopSell = new JButton("Sell");
		btnShopSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchShopSellScreen();
				finishedWindow();
			}
		});
		btnShopSell.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShopSell.setBounds(741, 10, 85, 21);
		frmShopbuy.getContentPane().add(btnShopSell);
		
//		JTextArea txtrDescription = new JTextArea();
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setText("Description: Not Selected\r\n\r\n");
		txtDescription.setBounds(457, 88, 302, 233);
		frmShopbuy.getContentPane().add(txtDescription);
		
		
//		Shop shop = new Shop(2, 2);
//		Shop.setNumMonsters(2);
//		Shop.addMonsters();
//		shop.addMonsters();
//		shop.addMonsters();
		
		DefaultListModel<String> shopStrings = new DefaultListModel<>();
		DefaultListModel<String> shopInfo = new DefaultListModel<>();

		ArrayList<Monster> monsterInfo = super.getAvalibleMonsters();
		ArrayList<Item> itemInfo = super.getAvalibleItems();
		
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
		
		

		// Create the actual JList, notice that we put the astronautListModel in as an argument to new JList		
		JList<String> availablePurchasables = new JList<>(shopStrings);
		availablePurchasables.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		availablePurchasables.setBounds(49, 88, 341, 233);
		frmShopbuy.getContentPane().add(availablePurchasables);
		ListSelectionModel monsterSelectionModel = availablePurchasables.getSelectionModel();
		monsterSelectionModel.addListSelectionListener(new SharedListSelectionHandler(shopInfo, "ShopBuy"));
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmShopbuy, "Are you sure you want to buy this item/monster?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					Player.removeGold(selectedCost);
					lblGoldAmount.setText("Amount of gold: "+Player.getGoldAmount());	
//					STILL NEED TO ADD MONSTER/ITEM TO INVENTORY
				}
			}
		});
		btnBuy.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBuy.setBounds(617, 331, 142, 21);
		frmShopbuy.getContentPane().add(btnBuy);
		
		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnReturnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReturnHome.setBounds(684, 41, 142, 20);
		frmShopbuy.getContentPane().add(btnReturnHome);
		

		


	    
//	    
//		JButton btnShowDetailsButton = new JButton("Show Selected Details");
//		btnShowDetailsButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Button pressed! Currently selected astronaut is:");
//				System.out.println(availableMonsters.getSelectedValue());
//			}
//		});
//		btnShowDetailsButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnShowDetailsButton.setBounds(116, 232, 192, 21);
//		frmShopbuy.getContentPane().add(btnShowDetailsButton);
//		
	}
	
	
	public static void setTxtrDescription(String text) {
		txtDescription.setText(text);
	}
	
	public static void setSelectedCost(double cost) {
		selectedCost = cost;
	}
}
