package Levels;

import GUI.GUI_Game;
import Main.Game;

public class Level1 extends Game {
	//Attributes
	private static Level1 INSTANCE = null;
	
	//Constructor
	private Level1(GUI_Game gui) {
		super(gui);
	}
	
	
	//Commands	
	private synchronized static void createInstance(GUI_Game gui) {
		if (INSTANCE == null) {
			INSTANCE = new Level1(gui);
		}	
	}
	/**
	 * Metodo que retorna una instancia de Level1
	 * @return Retorna una instancia de Level1
	 */
	public static Level1 getInstance(GUI_Game gui) {
		if(INSTANCE == null) {
			createInstance(gui);
		}
		return INSTANCE;
	}


	@Override
	public Game getInstance() {
		return INSTANCE;
	}
	
}
