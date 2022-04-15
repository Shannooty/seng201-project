package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import player.Player;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

public class EndScreen {

	private JFrame frame;
	private GameEnvironment gameEnvironment;
	private Player player;
	
	/**
	 * Create the application.
	 */
	public EndScreen(GameEnvironment manager) {
		initialize();
		gameEnvironment = manager;
		setPlayer(manager.getPlayer());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over!");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblGameOver.setBounds(248, 11, 337, 53);
		frame.getContentPane().add(lblGameOver);
		
		JLabel lblScore = new JLabel("Score : #####");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblScore.setBounds(257, 61, 320, 53);
		frame.getContentPane().add(lblScore);
		
		JLabel lblLeaderboard = new JLabel("Leaderboard");
		lblLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderboard.setBounds(295, 115, 244, 46);
		frame.getContentPane().add(lblLeaderboard);
		
		JList listLeaderboard = new JList();
		listLeaderboard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listLeaderboard.setVisibleRowCount(20);
		listLeaderboard.setBounds(295, 157, 244, 306);
		frame.getContentPane().add(listLeaderboard);
		
		JButton btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(295, 478, 110, 28);
		frame.getContentPane().add(btnPlayAgain);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(429, 478, 110, 28);
		frame.getContentPane().add(btnQuit);
	}

	public GameEnvironment getGameEnvironment() {
		return gameEnvironment;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
