package gameGUI;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() { // need this so everything runs at the beginning properly due to threads

			@Override
			public void run() {
				new TicTacToeGUI();
			}
			
		});

	}

}
