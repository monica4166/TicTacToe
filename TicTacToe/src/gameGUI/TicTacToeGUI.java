package gameGUI;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends JFrame{
	
	// Variables
	private Container pane;
	private String currentPlayer;
	private JButton [][] board;
	private boolean hasWinner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	
	// Contructor
	public TicTacToeGUI() {
		super();
		
		// set up the window
		pane = getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		setTitle("TicTacToe");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		// initialize base variables
		currentPlayer = "X";
		board = new JButton[3][3];
		hasWinner = false;
		
		// initializing the rest of the game setup
		initializeBoard();
		initializeMenuBar();
		
	}
	
	// Methods
	private void initializeMenuBar() {
		
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		quit = new JMenuItem("Quit");
		
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
				
			}
		});
		
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	private void resetBoard() {
		currentPlayer = "X";
		hasWinner = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j].setText("");
			}
		}
	}
	
	private void initializeBoard() {
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton btn = new JButton();
				btn.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
				board[i][j] = btn;
				
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if(((JButton)e.getSource()).getText().equals("") && hasWinner == false) {// check if the move is valid
							btn.setText(currentPlayer); // Add player's move to board
							hasWinner(); // checks if there is a winner
							togglePlayer(); // change player to next player
						}
						
					}
					
				});
				
				pane.add(btn);
			}
		}
	}
	
	private void togglePlayer() {
		if(currentPlayer.equals("X")) {
			currentPlayer = "O";
		}
		else {
			currentPlayer = "X";
		}
	}
	
	private void hasWinner() {
		
		if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
			hasWinner = true;
		}
		else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
			hasWinner = true;
		}
		else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
			hasWinner = true;
		}
		else if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
			hasWinner = true;
		}
		else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
			hasWinner = true;
		}
		else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
			hasWinner = true;
		}
		else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
			hasWinner = true;
		}
		else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)) {
			JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
			hasWinner = true;
		}
		
	}
}
