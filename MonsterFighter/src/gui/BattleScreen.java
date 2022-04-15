package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import player.Player;
import player.Team;

public class BattleScreen {

	private JFrame frmBattlescreen;
	private GameEnvironment gameEnvironment;
	private Player player;
	private static Team team;


	/**
	 * Create the application.
	 */
	public BattleScreen(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		player = gameEnvironment.getPlayer();
		team = player.getInventory().getTeam();
		initialize();
		frmBattlescreen.setVisible(true);
	}
	
	
	/**
	 * Closes the frame frmBattlescreen.
	 */
	public void closeWindow() {
		frmBattlescreen.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeBattleScreen, passing the BattleScreen object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeBattleScreen(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBattlescreen = new JFrame();
		frmBattlescreen.setTitle("BattleScreen");
		frmBattlescreen.setBounds(100, 100, 850, 570);
		frmBattlescreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBattlescreen.getContentPane().setLayout(null);
	}

}
