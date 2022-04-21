package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import gui.customElements.ImgInventoryPanel;
import player.Inventory;
import player.Player;
import purchasable.items.Item;
import purchasable.monsters.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private static JTextArea txtDescriptionMonsters = new JTextArea("Nothing selected.");
	
	/**
	 * Attribute txtDescription of type JTextArea. The area where the Item/Monster's description is displayed to the user.
	 */
	private static JTextArea txtDescriptionItems = new JTextArea("Nothing selected.");
	


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
		monsterScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		monsterScrollPane.setBounds(31, 316, 411, 207);
		frmInventoryscreen.getContentPane().add(monsterScrollPane);
		
		JScrollPane itemScrollPane = new JScrollPane();
		itemScrollPane.getVerticalScrollBar().setUnitIncrement(15);
		itemScrollPane.setBounds(31, 68, 409, 205);
		frmInventoryscreen.getContentPane().add(itemScrollPane);
		
		ImgInventoryPanel monsterPanel = new ImgInventoryPanel(monsterScrollPane, team, "Inventory");
		monsterScrollPane.setViewportView(monsterPanel);
		
		ImgInventoryPanel itemPanel = new ImgInventoryPanel(itemScrollPane, inventory.getItems(), "Inventory");
		itemScrollPane.setViewportView(itemPanel);
		
		
//		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
//		txtDescription.setMargin(new Insets(0,7,0,7));
//		txtDescription.setText("Nothing selected.");
//		txtDescription.setLineWrap(true);
//		txtDescription.setEditable(false);
//		


		
		
		txtDescriptionItems.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescriptionItems.setMargin(new Insets(0,7,0,7));
//		txtDescriptionItems.setBounds(530, 68, 267, 190);
		txtDescriptionItems.setLineWrap(true);
		txtDescriptionItems.setEditable(false);
		frmInventoryscreen.getContentPane().add(txtDescriptionItems);
		
        JScrollPane scrollableTextAreaItems = new JScrollPane(txtDescriptionItems);  
        scrollableTextAreaItems.setBounds(530, 68, 267, 190);
        scrollableTextAreaItems.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        scrollableTextAreaItems.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        frmInventoryscreen.getContentPane().add(scrollableTextAreaItems); 
		
		txtDescriptionMonsters.setFont(new Font("Monospaced", Font.PLAIN, 15));		
		txtDescriptionMonsters.setMargin(new Insets(0,7,0,7));
//		txtDescriptionMonsters.setBounds(530, 316, 267, 190);
		txtDescriptionMonsters.setLineWrap(true);
		txtDescriptionMonsters.setEditable(false);
//		frmInventoryscreen.getContentPane().add(txtDescriptionMonsters);
		
		
        JScrollPane scrollableTextAreaMonsters = new JScrollPane(txtDescriptionMonsters);  
        scrollableTextAreaMonsters.setBounds(530, 316, 267, 190);
        scrollableTextAreaMonsters.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
        scrollableTextAreaMonsters.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        frmInventoryscreen.getContentPane().add(scrollableTextAreaMonsters); 
		
		
		JButton btnHome = new JButton("Return Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHome.setBounds(663, 10, 163, 25);
		frmInventoryscreen.getContentPane().add(btnHome);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Welcome to the inventory, " + player.getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(52, 10, 347, 19);
		frmInventoryscreen.getContentPane().add(lblNewLabel);
		
		JLabel lblYourTeam = new JLabel("Your Team:");
		lblYourTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblYourTeam.setBounds(31, 286, 99, 20);
		frmInventoryscreen.getContentPane().add(lblYourTeam);
		
		JLabel lblNewLabel_1 = new JLabel("Items you own:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 39, 140, 19);
		frmInventoryscreen.getContentPane().add(lblNewLabel_1);
		
//		JButton btnEquipItem = new JButton("Equip Item");
//		btnEquipItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				int choice = JOptionPane.showConfirmDialog(frmInventoryscreen, "Are you sure you want to buy this item/monster?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);			
//				if (choice == JOptionPane.YES_OPTION) {
//					
//				}
//			}
//		});
//		btnEquipItem.setFont(new Font("Tahoma", Font.BOLD, 15));
//		btnEquipItem.setBounds(663, 476, 122, 25);
//		frmInventoryscreen.getContentPane().add(btnEquipItem);
		

		
		
		
		
		JButton btnEquipItem = new JButton("Equip Item");
		btnEquipItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEquipItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] choices = new String[team.size()];
				for (int i = 0; i < team.size(); i++) {
					choices[i] = team.get(i).getDescription();
				}
				String selection = (String) JOptionPane.showInputDialog(
						frmInventoryscreen,
				                    "Which monster do you wish to use this item on?",
				                    "Inventory pop-up",
				                    JOptionPane.PLAIN_MESSAGE,
				                    null,
				                    choices,
				                    team.get(0).getDescription());

				if (selection != null) {
					String selectedID = selection.substring(selection.length() - 1);
//					System.out.println("InventoryScreen, selection "+selection);
					List<Monster> listOfMonsters = team.stream().filter(s -> selectedID.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
					Monster monsterToEquip = listOfMonsters.get(0);
//					System.out.println("selectedItem "+selectedItem+" "+selectedItem.toString());
//					System.out.println("monsterToEquip "+monsterToEquip+" "+monsterToEquip.toString());
					inventory.useItem(selectedItem, monsterToEquip);
					
					selectedItem.setEquipped(true);
					txtDescriptionItems.setText("Nothing selected.");
					txtDescriptionMonsters.setText("Nothing selected.");
					ImgInventoryPanel monsterPanel = new ImgInventoryPanel(monsterScrollPane, team, "Inventory");
					monsterScrollPane.setViewportView(monsterPanel);
					
					ImgInventoryPanel itemPanel = new ImgInventoryPanel(itemScrollPane, inventory.getItems(), "Inventory");
					itemScrollPane.setViewportView(itemPanel);

				}
			}
		});
		btnEquipItem.setBounds(642, 268, 155, 25);
		frmInventoryscreen.getContentPane().add(btnEquipItem);
		
		
		if (inventory.getItems().size() == 0) {
			btnEquipItem.setEnabled(false);
		}
		

	}
	
	public static void setTxtrDescriptionMonster(String text) {
		List<Monster> listOfMonsters = team.stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedMonster = listOfMonsters.get(0);
		String monsterString = selectedMonster.getSellBackDescription();
		txtDescriptionMonsters.setText(monsterString);
		txtDescriptionMonsters.setCaretPosition(0);
	}
	
	
	public static void setTxtrDescriptionItem(String text) {
		List<Item> listOfItems = inventory.getItems().stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedItem = listOfItems.get(0);
		String itemString = selectedItem.getSellBackDescription();
		txtDescriptionItems.setText(itemString);
		txtDescriptionItems.setCaretPosition(0);
	}
}
