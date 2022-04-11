package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import player.Player;

import java.awt.Font;
import javax.swing.JButton;

public class Sleep {

	private JFrame frmSleep;
	private GameEnvironment gameEnvironment;

	/**
	 * Launch the application.
	 */
	public Sleep(GameEnvironment gameManager) {
		gameEnvironment = gameManager;
		initialize();
		frmSleep.setVisible(true);
	}
	
	public void closeWindow() {
		frmSleep.dispose();
	}
	
	public void finishedWindow() {
		gameEnvironment.closeSleep(this);
	}

	/**
	 * Create the application.
	 */
//	public Sleep() {
//		initialize();
//	}

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
		lblDaysRemaining.setText("There are "+(GameEnvironment.getgameLength() - GameEnvironment.getDayNumber())+" days remaining.");	
		lblDaysRemaining.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDaysRemaining.setBounds(299, 232, 222, 20);
		frmSleep.getContentPane().add(lblDaysRemaining);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnContinue.setBounds(328, 419, 167, 21);
		frmSleep.getContentPane().add(btnContinue);
	}
}
