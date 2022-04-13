package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import player.Player;
import random_event.RandomEvent;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 * @author 
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
	 * Constructor for the class Sleep. Sets the private variable gameEnvironment to the gameManager given, calls the initialize() method, and sets the frame to visible.
	 * @param gameManager type GameEnvironment. The class that manages what windows are open.
	 */
	public Sleep(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
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
		
		JLabel lblDaysRemaining = new JLabel("There are __ days remaining.");
		lblDaysRemaining.setText("There are "+(gameEnvironment.getgameLength() - gameEnvironment.getDayNumber())+" days remaining.");	
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
		btnContinue.setBounds(328, 419, 167, 21);
		frmSleep.getContentPane().add(btnContinue);
		
		JLabel lblShopUpdated = new JLabel("The shop has been updated.");
		lblShopUpdated.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblShopUpdated.setBounds(288, 83, 208, 20);
		frmSleep.getContentPane().add(lblShopUpdated);
		
		JLabel lblBattlesUpdated = new JLabel("Battles have been updated.");
		lblBattlesUpdated.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBattlesUpdated.setBounds(292, 127, 203, 20);
		frmSleep.getContentPane().add(lblBattlesUpdated);
		
		JLabel lblGainedGoldPoints = new JLabel("You gained __ gold and __ points today.");		
		lblGainedGoldPoints.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGainedGoldPoints.setBounds(257, 173, 308, 20);
		frmSleep.getContentPane().add(lblGainedGoldPoints);
		
		JLabel lblRandomEvent = new JLabel();
		String event = RandomEvent.getRandomEvent();
		RandomEvent.runRandomEvent();
		lblRandomEvent.setText("Random event "+event+" occured.");
		lblRandomEvent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRandomEvent.setBounds(257, 253, 328, 20);
		frmSleep.getContentPane().add(lblRandomEvent);
	}
}
