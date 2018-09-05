package Main;

import javax.swing.JFrame;

import Game.Game;
import Game.Level1;

public class Main extends JFrame {
	//Attributes
	private static GUI gui;
	
	public static void main(String [] args) {
		gui = new GUI();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui.setVisible(true);	
	}
}
