package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;

import inventory.Inventory;
import monsters.*;

public class MainScreen {

	private JFrame frmMainscreen;
	private ImageIcon imagesToUse[];
	private ArrayList<Monster> team = Inventory.getTeam();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frmMainscreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainscreen = new JFrame();
		frmMainscreen.setTitle("MainScreen");
		frmMainscreen.setBounds(100, 100, 850, 570);
		frmMainscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainscreen.getContentPane().setLayout(null);
		
		Skeleton startingMonster = new Skeleton();
		Slime mobster = new Slime();
		Inventory.addMonster(startingMonster);
		Inventory.addMonster(mobster);
		for (int i = 0; i < team.size(); i++) {
			
			
			System.out.println(team.get(i));
			System.out.println((team.get(i)).getClass());
		}
		
//		ImageCarousel images = new ImageCarousel();
//		images.setSize(290, 195);
//		images.setLocation(266, 195);
//		frmMainscreen.getContentPane().add(images);
		
		
		
		JLabel lblGoldAmountText = new JLabel("Amount of gold:");
		lblGoldAmountText.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGoldAmountText.setBounds(10, 10, 154, 20);
		frmMainscreen.getContentPane().add(lblGoldAmountText);
		
		JLabel lblDayNumberText = new JLabel("Day number:");
		lblDayNumberText.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDayNumberText.setBounds(10, 40, 105, 20);
		frmMainscreen.getContentPane().add(lblDayNumberText);
		
		JButton btnBattleSelect = new JButton("Select Battle");
		btnBattleSelect.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBattleSelect.setBounds(664, 10, 162, 26);
		frmMainscreen.getContentPane().add(btnBattleSelect);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInventory.setBounds(674, 37, 152, 26);
		frmMainscreen.getContentPane().add(btnInventory);
		
		JButton btnShop = new JButton("Shop");
		btnShop.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnShop.setBounds(741, 65, 85, 26);
		frmMainscreen.getContentPane().add(btnShop);
		
		JTextPane textPaneMonsterDescription = new JTextPane();
		textPaneMonsterDescription.setFont(new Font("Tahoma", Font.BOLD, 16));
		textPaneMonsterDescription.setText("Monster Description:\r\n\r\n\r\nHealth:\r\n\r\nDamage:\r\n\r\nItem(s):");
		textPaneMonsterDescription.setBounds(480, 148, 281, 271);
		frmMainscreen.getContentPane().add(textPaneMonsterDescription);
		
		JLabel lblDayNumber = new JLabel("N/A");
		lblDayNumber.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblDayNumber.setBounds(119, 40, 45, 20);
		frmMainscreen.getContentPane().add(lblDayNumber);
		
		JLabel lblGoldAmount = new JLabel("N/A");
		lblGoldAmount.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblGoldAmount.setBounds(145, 10, 45, 20);
		frmMainscreen.getContentPane().add(lblGoldAmount);
	}
}
