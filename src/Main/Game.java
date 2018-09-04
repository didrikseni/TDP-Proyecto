package Main;

import javax.swing.JFrame;

import Level.Level;
import Level.Level1;

public class Game extends JFrame {
	//Attributes
	private static Level lvl;
	
	public static void main(String [] args) {
		lvl = new Level1();
		lvl.setVisible(true);
		
	}
}
