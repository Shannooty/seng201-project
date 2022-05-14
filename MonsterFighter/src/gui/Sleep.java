package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import day.Day;
import player.Player;
import purchasable.monsters.Monster;
import random_event.RandomEvent;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


/**
 * The screen that displays the amount of gold and points the user earned in the past day, as well as the random event that might or might not have occurred.
 * @author Celia Allen
 * @author Bede Nathan
 *
 */
public class Sleep {

	
	/**
	 * Attribute frmSleep, of type JFrame. The frame which is displayed to the user. Contains the UI for Sleep.
	 */
	private JFrame frmSleep;
	
	/**
	 * Attribute gameEnvironment of type GameEnvironment. Instance of the class GameEnvironment.
	 */
	private GameEnvironment gameEnvironment;
	
	/**
	 * Attribute randomEvent, of type RandomEvent. A new RandomEvent.
	 */
	private RandomEvent randomEvent;
	
	/**
	 * Attribute pointsEarnedToday, of type Integer. The amount of gold that the player earned in the past day.
	 */
	private int pointsEarnedToday;
	
	/**
	 * Attribute goldEarnedToday, of type double. The amount of points that the player earned in the past day.
	 */
	private double goldEarnedToday;
	
	/**
	 * Constructor for the class Sleep. Sets the private attribute gameEnvironment to the gameManager given, and sets the private attributes pointsEarnedToday, goldEarnedToday and randomEvent. Calls the initialize() method, and sets the frame to visible.
	 * @param gameManager, of type GameEnvironment. The game manager.
	 * @param goldEarnedToday, of type double. The amount of gold the player earned in the past day.
	 * @param pointsEarnedToday, of type integer. The amount of points the player earned in the past day.
	 */
	public Sleep(GameEnvironment gameManager, Double goldEarnedToday, int pointsEarnedToday) {
		gameEnvironment = gameManager;
		this.pointsEarnedToday = pointsEarnedToday;
		this.goldEarnedToday = goldEarnedToday;
		randomEvent = new RandomEvent(gameEnvironment.getPlayer().getInventory());		
		initialize();
		frmSleep.setVisible(true);
	}
	
	
	/**
	 * Closes the frame frmSleep.
	 */
	public void closeWindow() {
		frmSleep.dispose();
	}
	
	/**
	 * Calls the GameEnvironment method closeSleep, passing the Sleep object as a parameter.
	 */
	public void finishedWindow() {
		gameEnvironment.closeSleep(this);
	}


	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSleep = new JFrame();
		frmSleep.setTitle("Sleep");
		frmSleep.setBounds(100, 100, 850, 570);
		frmSleep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSleep.getContentPane().setLayout(null);
		
		JLabel lblDaysRemaining = new JLabel();
		lblDaysRemaining.setText("There are "+(gameEnvironment.getGameLength() - gameEnvironment.getDayNumber())+" days remaining.");	
		lblDaysRemaining.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDaysRemaining.setBounds(302, 340, 222, 20);
		frmSleep.getContentPane().add(lblDaysRemaining);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			/**
			 * Launches the MainScreen class, and calls finishedWindow() for Sleep.
			 * @param e the action that was performed, type ActionEvent.
			 */
			public void actionPerformed(ActionEvent e) {
				gameEnvironment.launchMainScreen();
				finishedWindow();
			}
		});
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnContinue.setBounds(328, 419, 167, 25);
		frmSleep.getContentPane().add(btnContinue);
		
		JLabel lblShopUpdated = new JLabel("The shop has been updated.");
		lblShopUpdated.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblShopUpdated.setBounds(288, 83, 208, 20);
		frmSleep.getContentPane().add(lblShopUpdated);
		
		JLabel lblBattlesUpdated = new JLabel("Battles have been updated.");
		lblBattlesUpdated.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBattlesUpdated.setBounds(292, 127, 203, 20);
		frmSleep.getContentPane().add(lblBattlesUpdated);
		
		JLabel lblGainedGoldPoints = new JLabel("You gained "+goldEarnedToday+" gold and "+pointsEarnedToday+" points today.");
		lblGainedGoldPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGainedGoldPoints.setBounds(236, 173, 374, 20);
		frmSleep.getContentPane().add(lblGainedGoldPoints);
		
		JLabel lblRandomEvent = new JLabel();
		String event = randomEvent.runRandomEvent();
		

		if (event == "Nothing") {
			lblRandomEvent.setText("No random event occurred.");
		} else {
			lblRandomEvent.setText("Random event "+event+" occured.");
		}
		
		lblRandomEvent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRandomEvent.setBounds(257, 253, 328, 20);
		frmSleep.getContentPane().add(lblRandomEvent);
	}
}
