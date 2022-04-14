package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import day.Battle;
import day.Day;
import generators.MonsterGenerator;
import purchasable.monsters.Monster;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ChooseBattleScreen {

	private JFrame frmChoosebattle;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	private ArrayList<Battle> possibleBattles = new ArrayList<Battle>();
	
	private String difficulty;
	
	private Day day;


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
		
		JTextArea textArea = new JTextArea();
		textArea.setText(possibleBattles.toString());
		textArea.setBounds(72, 68, 458, 215);
		frmChoosebattle.getContentPane().add(textArea);
		
		
		System.out.println(possibleBattles);
	}
}
