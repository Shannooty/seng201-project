package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import day.Battle;
import day.Day;
import generators.MonsterGenerator;
import gui.customElements.ImgInventoryPanel;
import purchasable.monsters.Monster;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class ChooseBattleScreen {

	private JFrame frmChoosebattle;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	private ArrayList<Battle> possibleBattles = new ArrayList<Battle>();
	
	private String difficulty;
	
	private static Day day;
	
	private ImageIcon imagesToUse[];
	
	private ArrayList<Monster> gameMonsters;
	
	private static Battle selectedBattle;
	
	private static JTextArea txtDescription = new JTextArea("");
	


	/**
	 * Create the application.
	 */
	public ChooseBattleScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		difficulty = gameEnvironment.getGameDifficulty();
//		System.out.println(difficulty);
//		for (int i = 0; i < 6; i++) {
//			Battle battle = new Battle(difficulty);
//			possibleBattles.add(battle);
//		}
		day = gameEnvironment.getToday();
		
		
		
		possibleBattles = day.getBattles();
		
//		gameMonsters = possibleBattles.getGameMonsters();
		
//		player = gameEnvironment.getPlayer();
//		team = player.getInventory().getTeam();
		initialize();
		frmChoosebattle.setVisible(true);
	}
	
	/**
	 * Closes the frame frmChoosebattle.
	 */
	public void closeWindow() {
		frmChoosebattle.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeChooseBattleScreen, passing the ChooseBattleScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeChooseBattleScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChoosebattle = new JFrame();
		frmChoosebattle.setTitle("ChooseBattle");
		frmChoosebattle.setBounds(100, 100, 850, 570);
		frmChoosebattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChoosebattle.getContentPane().setLayout(null);
		
		
//		imagesToUse = new ImageIcon[possibleBattles.size()]; 
//		imagesToUse[0] = new ImageIcon(ImageCarousel.class.getResource("/images/zombie.png"), "skeleton");
//		for (int i = 1; i < possibleBattles.size(); i++) {
//			imagesToUse[i] = new ImageIcon(ImageCarousel.class.getResource("/images/skeleton.png"), "skeleton");
//		}
//		
//		ImageCarousel images = new ImageCarousel(imagesToUse);
//		images.setSize(290, 195);
//		images.setLocation(266, 195);
//		frmChoosebattle.getContentPane().add(images);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 88, 411, 343);
		frmChoosebattle.getContentPane().add(scrollPane);

		ImgInventoryPanel monsterPanel = new ImgInventoryPanel(possibleBattles, scrollPane);
		scrollPane.setViewportView(monsterPanel);
		
		
		txtDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtDescription.setText("Description: Not Selected\r\n\r\n");
		txtDescription.setBounds(473, 88, 302, 233);
		frmChoosebattle.getContentPane().add(txtDescription);
		

		
		JButton btnReturnHome = new JButton("Return Home");
		btnReturnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnReturnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReturnHome.setBounds(672, 10, 154, 27);
		frmChoosebattle.getContentPane().add(btnReturnHome);
		
		JButton btnStartBattle = new JButton("Start Battle");
		btnStartBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(frmChoosebattle, "Are you sure you want to start this battle?",  "Shop Pop-Up", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
						gameEnvironment.launchBattleScreen(selectedBattle);
						finishedWindow();
					}
			}
		});
		btnStartBattle.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStartBattle.setBounds(631, 342, 145, 27);
		frmChoosebattle.getContentPane().add(btnStartBattle);
		

		
//		JTextArea textArea = new JTextArea();
//		textArea.setText(possibleBattles.toString());
//		textArea.setBounds(72, 68, 458, 215);
//		frmChoosebattle.getContentPane().add(textArea);
		
		
		System.out.println(possibleBattles);
	}
	
	public static void setTxtrDescription(String text) {
		List<Battle> battles = day.getBattles().stream().filter(s -> text.equals(Integer.toString(s.getID()))).collect(Collectors.toList());
		selectedBattle = battles.get(0);
		String battleString = selectedBattle.toString();
		txtDescription.setText(battleString);
	}
}
