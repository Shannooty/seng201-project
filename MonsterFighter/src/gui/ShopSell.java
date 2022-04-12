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

public class ShopSell extends Shop {

	private JFrame frmShopSell;
	private static JTextArea txtDescription = new JTextArea("");
	private static double selectedPrice;
	private static String selectedMonster;
	private static Item selectedItem;
	private GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
	public ShopSell(GameEnvironment gameManager) {
		super(3,5);
		gameEnvironment = gameManager;
		initialize();
		frmShopSell.setVisible(true);
	}
	
	public void closeWindow() {
		frmShopSell.dispose();
	}
	
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
	
	public static void setTxtrDescription(String text) {
		txtDescription.setText(text);
	}
	
	public static void setSelectedPrice(double cost) {
		selectedPrice = cost;
	}
	
	public static void setSelectedMonster(String monster) {
		selectedMonster = monster;
//		List<Monster> listOfMonsters = team.stream().filter(s -> oldMonster.equals(s.getName())).collect(Collectors.toList());
		System.out.println("monster: "+monster);
	}
	
	public static void setSelectedItem(Item item) {
		selectedItem = item;
	}
}
