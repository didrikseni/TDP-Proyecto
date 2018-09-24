package Game;

import Main.GUI;

public class Level2 extends Game {
	//Attributes
	private static Level2 INSTANCE = null;
	
	//Constructor
	private Level2(GUI gui) {
		super(gui);
	}
		
	//Commands	
	private synchronized static void createInstance(GUI gui) {
		if (INSTANCE == null) {
			INSTANCE = new Level2(gui);
		}	
	}
	
	/**
	 * Metodo que retorna una instancia de Level1
	 * @return Retorna una instancia de Level1
	 */
	public static Level2 getInstance(GUI gui) {
		if(INSTANCE == null) {
			createInstance(gui);
		}
		return INSTANCE;
	}
}
