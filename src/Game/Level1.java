package Game;

import Main.GUI;

public class Level1 extends Game {
	//Attributes
	private static Level1 INSTANCE = null;
	
	//Constructor
	private Level1(GUI gui) {
		super(gui);
	}
	
	
	//Commands	
	private synchronized static void createInstance(GUI gui) {
		if (INSTANCE == null) {
			INSTANCE = new Level1(gui);
		}	
	}
	/**
	 * Metodo que retorna una instancia de Level1
	 * @return Retorna una instancia de Level1
	 */
	public static Level1 getInstance(GUI gui) {
		if(INSTANCE == null) {
			createInstance(gui);
		}
		return INSTANCE;
	}
	
	
	
	
	
}
