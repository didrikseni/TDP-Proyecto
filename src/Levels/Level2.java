package Levels;

import GUI.GUI_Game;
import Main.Game;

public class Level2 extends Game {
	//Attributes
	private static Level2 INSTANCE = null;
	
	//Constructor
	private Level2(GUI_Game gui) {
		super(gui);
	}
		
	//Commands	
	private synchronized static void createInstance(GUI_Game gui) {
		if (INSTANCE == null) {
			INSTANCE = new Level2(gui);
		}	
	}
	
	/**
	 * Metodo que retorna una instancia de Level1
	 * @return Retorna una instancia de Level1
	 */
	public static Level2 getInstance(GUI_Game gui) {
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
